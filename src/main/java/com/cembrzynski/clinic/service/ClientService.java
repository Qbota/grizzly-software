package com.cembrzynski.clinic.service;

import com.cembrzynski.clinic.data.entity.Client;
import com.cembrzynski.clinic.data.repository.ClientRepository;
import com.cembrzynski.clinic.error.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    private static final int LOWER_BOUND = 1000;
    private static final int UPPER_BOUND = 9999;

    public Client findClientByCredentials(Long id, int pin) throws AuthenticationException{
        if(credentialsAreNotValid(id, pin)){
            throw new AuthenticationException("Credentials are not valid");
        }
        return clientRepository.findByIdAndPin(id, pin).orElseThrow(() -> new AuthenticationException("Cannot find user for given id and pin"));
    }

    private boolean credentialsAreNotValid(Long id, int pin) {
        return (id > UPPER_BOUND || id < LOWER_BOUND) || (pin > UPPER_BOUND || pin < LOWER_BOUND);
    }

    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
}
