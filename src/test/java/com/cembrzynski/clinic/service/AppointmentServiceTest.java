package com.cembrzynski.clinic.service;

import com.cembrzynski.clinic.data.dto.ModelMapper;
import com.cembrzynski.clinic.data.entity.Appointment;
import com.cembrzynski.clinic.data.entity.Client;
import com.cembrzynski.clinic.data.repository.AppointmentRepository;
import com.cembrzynski.clinic.error.exception.AuthenticationException;
import com.cembrzynski.clinic.error.exception.DuplicateEntryException;
import com.cembrzynski.clinic.error.exception.EntityNotFoundException;
import com.cembrzynski.clinic.error.exception.EntityNotValidException;
import com.cembrzynski.clinic.validator.AppointmentValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;
    @Mock
    private AppointmentValidator appointmentValidator;
    @Mock
    private ClientService clientService;
    @Mock
    private DoctorService doctorService;
    @Mock
    private ModelMapper modelMapper;

    private AppointmentService appointmentService;
    private Appointment testAppointment;

    @BeforeEach
    public void initServices(){
        MockitoAnnotations.openMocks(this);
        appointmentService = new AppointmentService();
        appointmentService.setAppointmentRepository(appointmentRepository);
        appointmentService.setAppointmentValidator(appointmentValidator);
        appointmentService.setClientService(clientService);
        appointmentService.setDoctorService(doctorService);
        appointmentService.setModelMapper(modelMapper);
    }

    @BeforeEach
    public void initAppointment(){
        testAppointment = new Appointment();
        Client client = new Client();
        client.setId(1234L);
        client.setPin(1234);
        testAppointment.setClient(client);
        testAppointment.setDate(LocalDateTime.now());
    }

    @Test
    public void shouldValidateAppointment() throws DuplicateEntryException, AuthenticationException, EntityNotValidException, EntityNotFoundException {
        appointmentService.createAppointmentForDoctor(testAppointment, 1L);

        verify(appointmentValidator, times(1)).validate(testAppointment);
    }

    @Test
    public void shouldFindUser() throws DuplicateEntryException, AuthenticationException, EntityNotValidException, EntityNotFoundException {
        appointmentService.createAppointmentForDoctor(testAppointment, 1L);

        verify(clientService, times(1)).findClientByCredentials(1234L, 1234);
    }

    @Test
    public void shouldFindDoctor() throws DuplicateEntryException, AuthenticationException, EntityNotValidException, EntityNotFoundException {
        appointmentService.createAppointmentForDoctor(testAppointment, 1L);

        verify(doctorService, times(1)).findDoctorById(1L);
    }

    @Test
    public void shouldInsertAppointment() throws DuplicateEntryException, AuthenticationException, EntityNotValidException, EntityNotFoundException {
        appointmentService.createAppointmentForDoctor(testAppointment, 1L);

        verify(appointmentRepository, times(1)).save(testAppointment);
    }

    @Test
    public void shouldConvertToDtoAfterAppointmentCreation() throws DuplicateEntryException, AuthenticationException, EntityNotValidException, EntityNotFoundException {
        appointmentService.createAppointmentForDoctor(testAppointment, 1L);

        verify(modelMapper, times(1)).map((Appointment) null);
    }

    @Test
    public void shouldQueryForDoctorsAppointments() throws EntityNotValidException {
        appointmentService.findAppointmentsForDoctor(1L);

        verify(appointmentRepository, times(1)).findByDoctorId(1L);
    }

    @Test
    public void shouldConvertDoctorsAppointments() throws EntityNotValidException {
        appointmentService.findAppointmentsForDoctor(1L);

        verify(modelMapper, times(1)).map(anyList());
    }

    @Test
    public void shouldCheckClientsCredentialsBeforeDelete() throws AuthenticationException {
        appointmentService.deleteAppointment(testAppointment);

        verify(clientService, times(1)).findClientByCredentials(testAppointment.getClient().getId(), testAppointment.getClient().getPin());
    }
    
    @Test
    public void shouldDeleteAppointment() throws AuthenticationException {
        appointmentService.deleteAppointment(testAppointment);

        verify(appointmentRepository, times(1)).delete(testAppointment);
    }

}