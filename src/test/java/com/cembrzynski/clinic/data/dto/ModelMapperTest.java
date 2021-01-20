package com.cembrzynski.clinic.data.dto;

import com.cembrzynski.clinic.data.entity.Appointment;
import com.cembrzynski.clinic.data.entity.Client;
import com.cembrzynski.clinic.data.entity.Doctor;
import com.cembrzynski.clinic.error.exception.EntityNotValidException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelMapperTest {

    private ModelMapper modelMapper;

    @BeforeEach
    public void initModelMapper(){
        modelMapper = new ModelMapper();
    }

    @Test
    public void shouldThrowExceptionForNullAppointment(){
        Appointment appointment = null;

        assertThrows(EntityNotValidException.class, () -> modelMapper.map(appointment));
    }

    @Test
    public void shouldReturnDtoForAppointment() throws EntityNotValidException {
        Appointment appointment = new Appointment();

        var dto = modelMapper.map(appointment);

        assertTrue(dto instanceof AppointmentDTO);
    }

    @Test
    public void shouldThrowExceptionForNullDoctor(){
        Doctor doctor = null;

        assertThrows(EntityNotValidException.class, () -> modelMapper.map(doctor));
    }

    @Test
    public void shouldReturnDtoForDoctor() throws EntityNotValidException {
        Doctor doctor = new Doctor();
        doctor.setAppointments(Collections.emptyList());

        var dto = modelMapper.map(doctor);

        assertTrue(dto instanceof DoctorDTO);
    }

    @Test
    public void shouldThrowExceptionForNullClient(){
        Client client = null;

        assertThrows(EntityNotValidException.class, () -> modelMapper.map(client));
    }

    @Test
    public void shouldReturnDtoForClient() throws EntityNotValidException {
        Client client = new Client();
        client.setAppointments(Collections.emptyList());

        var dto = modelMapper.map(client);

        assertTrue(dto instanceof ClientDTO);
    }

    @Test
    public void shouldThrowExceptionForNullList(){
        List<Appointment> appointment = null;

        assertThrows(EntityNotValidException.class, () -> modelMapper.map(appointment));
    }

    @Test
    public void shouldReturnDtoForAppointmentList() throws EntityNotValidException {
        List<Appointment> appointment = List.of(new Appointment(), new Appointment());

        var dtoList = modelMapper.map(appointment);

        assertTrue(dtoList.stream().allMatch(dto -> dto instanceof AppointmentDTO));
    }


}