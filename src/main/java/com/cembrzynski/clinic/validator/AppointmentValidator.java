package com.cembrzynski.clinic.validator;

import com.cembrzynski.clinic.data.entity.Appointment;
import com.cembrzynski.clinic.data.repository.AppointmentRepository;
import com.cembrzynski.clinic.error.exception.DuplicateEntryException;
import com.cembrzynski.clinic.error.exception.EntityNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class AppointmentValidator {

    @Autowired
    private AppointmentRepository appointmentRepository;
    private static final int FULL_HOUR_MINUTES = 0;
    private static final int HALF_HOUR_MINUTEST = 30;
    private static final LocalTime FIRST_AVAILABLE = LocalTime.of(8, 0);
    private static final LocalTime LAST_AVAILABLE = LocalTime.of(15,30);

    public void validate(Appointment appointment) throws EntityNotValidException, DuplicateEntryException {
        validateComplete(appointment);
        validateUniqueForDoctor(appointment);
        validateUniqueForClient(appointment);
        validateAppointmentNotInPast(appointment);
        validateCorrectTime(appointment);
        validateTimeInOpeningHours(appointment);
    }

    private void validateComplete(Appointment appointment) throws EntityNotValidException {
        if(appointment.getDate() == null || appointment.getClient() == null){
            throw new EntityNotValidException("Cannot handle incomplete request");
        }
        if(appointment.getClient().getId() == 0 || appointment.getClient().getPin() == 0){
            throw new EntityNotValidException("Please provide credentials");
        }
    }

    private void validateUniqueForDoctor(Appointment appointment) throws DuplicateEntryException {
        if(appointmentRepository.findByDateAndDoctorId(appointment.getDate(), appointment.getDoctor().getId()).isPresent()){
            throw new DuplicateEntryException("Selected date and time is already taken");
        }
    }

    private void validateUniqueForClient(Appointment appointment) throws DuplicateEntryException {
        if(appointmentRepository.findByDateAndClientId(appointment.getDate(), appointment.getClient().getId()).isPresent()){
            throw new DuplicateEntryException("Client has already appointment on requested time");
        }
    }

    private void validateAppointmentNotInPast(Appointment appointment) throws EntityNotValidException {
        if(appointment.getDate().isBefore(LocalDateTime.now())){
            throw new EntityNotValidException("Cannot create appointment in the past");
        }
    }

    private void validateCorrectTime(Appointment appointment) throws EntityNotValidException {
        var minutes = appointment.getDate().getMinute();
        if(minutes != FULL_HOUR_MINUTES && minutes != HALF_HOUR_MINUTEST){
            throw new EntityNotValidException("Appointment can be created only every half an hour");
        }
    }

    private void validateTimeInOpeningHours(Appointment appointment) throws EntityNotValidException {
        var appointmentTime = appointment.getDate().toLocalTime();
        if(appointmentTime.isBefore(FIRST_AVAILABLE) || appointmentTime.isAfter(LAST_AVAILABLE)){
            throw new EntityNotValidException("Clinic cannot serve clients out of opening hours: 8:00 - 16:00");
        }
    }

    public void setAppointmentRepository(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
}
