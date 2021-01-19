package com.cembrzynski.clinic.service;

import com.cembrzynski.clinic.data.dto.AppointmentDTO;
import com.cembrzynski.clinic.data.dto.ModelMapper;
import com.cembrzynski.clinic.data.entity.Appointment;
import com.cembrzynski.clinic.data.repository.AppointmentRepository;
import com.cembrzynski.clinic.error.exception.AuthenticationException;
import com.cembrzynski.clinic.error.exception.DuplicateEntryException;
import com.cembrzynski.clinic.error.exception.EntityNotFoundException;
import com.cembrzynski.clinic.error.exception.EntityNotValidException;
import com.cembrzynski.clinic.validator.AppointmentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private AppointmentValidator appointmentValidator;
    @Autowired
    private ClientService clientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private ModelMapper modelMapper;

    public AppointmentDTO createAppointmentForDoctor(Appointment appointment, Long doctorId) throws EntityNotValidException, AuthenticationException, EntityNotFoundException, DuplicateEntryException {
        appointmentValidator.validate(appointment);
        var client = clientService.findClientByCredentials(appointment.getClient().getId(), appointment.getClient().getPin());
        var doctor = doctorService.findDoctorById(doctorId);
        appointment.setClient(client);
        appointment.setDoctor(doctor);
        var entity = appointmentRepository.save(appointment);
        return modelMapper.map(entity);
    }

    public List<AppointmentDTO> findAppointmentsForDoctor(Long id) throws EntityNotValidException{
        var entityList = appointmentRepository.findByDoctorId(id);
        return modelMapper.map(entityList);
    }

    public void deleteAppointment(Appointment appointment){
        //TODO check if appointment belongs to given user
        appointmentRepository.delete(appointment);
    }

    public void setAppointmentRepository(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void setAppointmentValidator(AppointmentValidator appointmentValidator) {
        this.appointmentValidator = appointmentValidator;
    }

    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
}
