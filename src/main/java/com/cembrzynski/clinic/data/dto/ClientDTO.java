package com.cembrzynski.clinic.data.dto;

import com.cembrzynski.clinic.data.entity.Client;

import java.util.List;

public class ClientDTO {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final List<AppointmentDTO> appointments;

    private ClientDTO(Client client) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.appointments = AppointmentDTO.from(client.getAppointments());
    }

    public static ClientDTO from(Client client){
        return new ClientDTO(client);
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
