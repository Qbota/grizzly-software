package com.cembrzynski.clinic.data.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "APPOINTMENT")
public class Appointment {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "DATE", unique = true)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "FK_CLIENT_ID")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "FK_DOCTOR_ID")
    private Doctor doctor;

    public Appointment(){
        //Should be empty
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
