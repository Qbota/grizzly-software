package com.cembrzynski.clinic.data.dto;

import com.cembrzynski.clinic.data.entity.Doctor;

import java.util.List;

public class DoctorDTO {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final List<AppointmentDTO> appointments;

    private DoctorDTO(Doctor doctor) {
        this.id = doctor.getId();
        this.firstName = doctor.getFirstName();
        this.lastName = doctor.getLastName();
        this.appointments = AppointmentDTO.from(doctor.getAppointments());
    }

    public static DoctorDTO from(Doctor doctor){
        return new DoctorDTO(doctor);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<AppointmentDTO> getAppointments() {
        return appointments;
    }
}
