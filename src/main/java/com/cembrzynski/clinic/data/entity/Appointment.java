package com.cembrzynski.clinic.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "APPOINTMENT")
public class Appointment {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "DATE")
    private Date date;
    @ManyToOne
    private Client client;
    @ManyToOne
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
