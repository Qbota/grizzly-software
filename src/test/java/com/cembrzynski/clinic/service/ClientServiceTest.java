package com.cembrzynski.clinic.service;

import com.cembrzynski.clinic.data.repository.ClientRepository;
import com.cembrzynski.clinic.error.exception.AuthenticationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;
    private ClientService clientService;

    @BeforeEach
    public void initService(){
        MockitoAnnotations.openMocks(this);
        clientService = new ClientService();
        clientService.setClientRepository(clientRepository);
    }

    @Test
    public void shouldThrowExceptionForInvalidCredentials(){
        Long tooSmallId = 999L;
        int tooSmallPin = 999;
        Long tooLargeId = 10000L;
        int tooLargePin = 10000;

        assertThrows(AuthenticationException.class, () -> clientService.findClientByCredentials(tooSmallId, tooSmallPin));
        assertThrows(AuthenticationException.class, () -> clientService.findClientByCredentials(tooLargeId, tooLargePin));
    }

    @Test
    public void shouldQueryForUser() throws AuthenticationException {
        Long id = 1234L;
        int pin = 1234;

        //Repository returns null for any data
        assertThrows(AuthenticationException.class, () -> clientService.findClientByCredentials(id, pin));

        verify(clientRepository, times(1)).findByIdAndPin(id, pin);
    }

}