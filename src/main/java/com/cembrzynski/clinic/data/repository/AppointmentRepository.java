package com.cembrzynski.clinic.data.repository;

import com.cembrzynski.clinic.data.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
