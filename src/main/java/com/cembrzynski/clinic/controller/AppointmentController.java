package com.cembrzynski.clinic.controller;

import com.cembrzynski.clinic.data.entity.Appointment;
import com.cembrzynski.clinic.error.exception.AuthenticationException;
import com.cembrzynski.clinic.error.exception.DuplicateEntryException;
import com.cembrzynski.clinic.error.exception.EntityNotFoundException;
import com.cembrzynski.clinic.error.exception.EntityNotValidException;
import com.cembrzynski.clinic.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctor/{doctorId}/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Object> createAppointment(@PathVariable Long doctorId, @RequestBody Appointment appointment)
            throws EntityNotValidException, AuthenticationException, EntityNotFoundException, DuplicateEntryException {
        return new ResponseEntity<>(appointmentService.createAppointmentForDoctor(appointment, doctorId), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> listAllAppointments(@PathVariable Long doctorId) throws EntityNotValidException {
        return ResponseEntity.ok(appointmentService.findAppointmentsForDoctor(doctorId));
    }

    @DeleteMapping
    public ResponseEntity<Object> cancelAppointment(@PathVariable Long doctorId, @RequestBody Appointment appointment) throws AuthenticationException {
        appointmentService.deleteAppointment(appointment);
        return ResponseEntity.ok().build();
    }

    public void setAppointmentService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
}
