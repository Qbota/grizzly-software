package com.cembrzynski.clinic.data.repository;

import com.cembrzynski.clinic.data.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByDoctorId(Long id);
    Optional<Appointment> findByDateAndDoctorId(LocalDateTime date, Long Id);
    Optional<Appointment> findByDateAndClientId(LocalDateTime date, Long Id);
}
