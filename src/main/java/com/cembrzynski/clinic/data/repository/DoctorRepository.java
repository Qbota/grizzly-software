package com.cembrzynski.clinic.data.repository;

import com.cembrzynski.clinic.data.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
