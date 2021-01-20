package com.cembrzynski.clinic.service;

import com.cembrzynski.clinic.data.repository.DoctorRepository;
import com.cembrzynski.clinic.error.exception.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;
    private DoctorService doctorService;

    @BeforeEach
    public void initService(){
        MockitoAnnotations.openMocks(this);
        doctorService = new DoctorService();
        doctorService.setDoctorRepository(doctorRepository);
    }

    @Test
    public void shouldQueryForDoctor(){
        Long id = 1L;

        assertThrows(EntityNotFoundException.class, () -> doctorService.findDoctorById(id));

        verify(doctorRepository, times(1)).findById(id);
    }

}