package com.cembrzynski.clinic.service;

import com.cembrzynski.clinic.data.entity.Doctor;
import com.cembrzynski.clinic.data.repository.DoctorRepository;
import com.cembrzynski.clinic.error.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor findDoctorById(Long id) throws EntityNotFoundException {
        return doctorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cannot find doctor for given id"));
    }

    public void setDoctorRepository(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
}
