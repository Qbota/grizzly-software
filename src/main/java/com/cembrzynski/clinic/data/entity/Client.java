package com.cembrzynski.clinic.data.entity;

import java.util.List;

public class Client {

    private Long id; //starting 1000
    private String firstName;
    private String lastName;
    private Long pin; //Starting 1000
    private List<Appointment> appointments;
}
