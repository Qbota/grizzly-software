package com.cembrzynski.clinic.data.dto;

import com.cembrzynski.clinic.data.entity.Appointment;
import com.cembrzynski.clinic.data.entity.Client;
import com.cembrzynski.clinic.data.entity.Doctor;
import com.cembrzynski.clinic.error.exception.EntityNotValidException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModelMapper {

    public AppointmentDTO map(Appointment appointment) throws EntityNotValidException {
        if(appointment != null){
            return AppointmentDTO.from(appointment);
        }else{
            throw new EntityNotValidException("Cannot map appointment to DTO");
        }
    }

    public DoctorDTO map(Doctor doctor) throws EntityNotValidException {
        if(doctor != null){
            return DoctorDTO.from(doctor);
        }else{
            throw new EntityNotValidException("Cannot map doctor to DTO");
        }
    }

    public ClientDTO map(Client client) throws EntityNotValidException {
        if(client != null){
            return ClientDTO.from(client);
        }else{
            throw new EntityNotValidException("Cannot map client to DTO");
        }
    }

    public List<AppointmentDTO> map(List<Appointment> appointmentList) throws EntityNotValidException {
        if(appointmentList != null){
            return AppointmentDTO.from(appointmentList);
        }else{
            throw new EntityNotValidException("Cannot map appointment to DTO");
        }
    }
}
