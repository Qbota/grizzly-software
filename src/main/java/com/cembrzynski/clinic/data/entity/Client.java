package com.cembrzynski.clinic.data.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CLIENT")
@SequenceGenerator(name = "CLIENT_ID_SEQUENCE", initialValue = 1000, allocationSize = 1)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENT_ID_SEQUENCE")
    @Column(name = "ID")
    private Long id; //starting 1000
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "PIN")
    private int pin;
    @OneToMany(mappedBy = "client")
    private List<Appointment> appointments;

    public Client() {
        //Should be empty
    }

    public Client(String firstName, String lastName, int pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
