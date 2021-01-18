package com.cembrzynski.clinic.service;

import com.cembrzynski.clinic.data.entity.Appointment;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AppointmentService {


    public Appointment createAppointment(Appointment appointment){
        return null;
    }

    public List<Appointment> findAppointmentsForDoctor(Long id){
        return Collections.emptyList();
    }

    public void deleteAppointment(Appointment appointment){

    }

}
