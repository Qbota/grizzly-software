package com.cembrzynski.clinic.validator;

import com.cembrzynski.clinic.data.entity.Appointment;
import com.cembrzynski.clinic.data.entity.Client;
import com.cembrzynski.clinic.data.repository.AppointmentRepository;
import com.cembrzynski.clinic.error.exception.DuplicateEntryException;
import com.cembrzynski.clinic.error.exception.EntityNotValidException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentValidatorTest {

    private Appointment testAppointment;
    private AppointmentRepository appointmentRepository;
    private AppointmentValidator appointmentValidator;

    @BeforeEach
    public void initValidator(){
        appointmentValidator = new AppointmentValidator();
        testAppointment = createTestAppointment();
        appointmentRepository = new AppointmentRepositoryMock();
        appointmentValidator.setAppointmentRepository(appointmentRepository);
    }

    private Appointment createTestAppointment(){
        Appointment appointment = new Appointment();
        LocalDate date = LocalDate.MAX;
        LocalTime time = LocalTime.of(12,30);
        appointment.setDate(LocalDateTime.of(date, time));
        Client client = new Client();
        client.setId(1234L);
        client.setPin(1234);
        appointment.setClient(client);
        return appointment;
    }

    @Test
    public void shouldNotThrowForCorrectInput(){
        assertDoesNotThrow(() -> appointmentValidator.validate(testAppointment));
    }

    @Test
    public void shouldSignalAlreadyTakenSpot(){
        appointmentRepository = new AppointmentRepositoryMock(testAppointment);
        appointmentValidator.setAppointmentRepository(appointmentRepository);

        assertThrows(DuplicateEntryException.class, () -> appointmentValidator.validate(testAppointment));
    }

    @Test
    public void shouldSignalInputDateInThePast(){
        testAppointment.setDate(LocalDateTime.MIN);

        assertThrows(EntityNotValidException.class, () -> appointmentValidator.validate(testAppointment));
    }

    @Test
    public void shouldSignalAppointmentNotEveryHalfAnHour(){
        LocalTime incorrectTime = LocalTime.of(12,35);
        testAppointment.setDate(LocalDateTime.of(LocalDate.MAX, incorrectTime));

        assertThrows(EntityNotValidException.class, () -> appointmentValidator.validate(testAppointment));
    }

    @Test
    public void shouldSignalAppointmentOutsideOpeningHours(){
        LocalTime incorrectTime = LocalTime.of(20,30);
        testAppointment.setDate(LocalDateTime.of(LocalDate.MAX, incorrectTime));

        assertThrows(EntityNotValidException.class, () -> appointmentValidator.validate(testAppointment));
    }
}