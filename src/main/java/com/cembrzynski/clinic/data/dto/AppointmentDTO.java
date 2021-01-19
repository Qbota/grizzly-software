package com.cembrzynski.clinic.data.dto;

import com.cembrzynski.clinic.data.entity.Appointment;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentDTO {

    private final Long id;
    private final LocalDateTime date;

    private AppointmentDTO(Appointment appointment) {
        this.id = appointment.getId();
        this.date = appointment.getDate();
    }

    public static AppointmentDTO from(Appointment entity) {
        return new AppointmentDTO(entity);
    }

    public static List<AppointmentDTO> from(List<Appointment> appointmentList){
        return appointmentList.stream().map(AppointmentDTO::from).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

}
