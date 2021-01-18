package com.cembrzynski.clinic.init;

import com.cembrzynski.clinic.data.entity.Client;
import com.cembrzynski.clinic.data.entity.Doctor;
import com.cembrzynski.clinic.data.repository.ClientRepository;
import com.cembrzynski.clinic.data.repository.DoctorRepository;
import com.cembrzynski.clinic.util.PinGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Value("${db.init}")
    private boolean shouldInitDatabase;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(shouldInitDatabase){
            initClients();
            initDoctors();
        }
    }

    private void initDoctors() {
        doctorRepository.saveAll(List.of(
                new Doctor("Jan", "Kowalski")
        ));
    }

    private void initClients() {
        clientRepository.saveAll(List.of(
            new Client("Adam", "Nowak", PinGenerator.generatePinNumber())
        ));
    }

    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void setDoctorRepository(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void setShouldInitDatabase(boolean shouldInitDatabase) {
        this.shouldInitDatabase = shouldInitDatabase;
    }
}
