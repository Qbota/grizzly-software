package com.cembrzynski.clinic.data.repository;

import com.cembrzynski.clinic.data.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByIdAndPin(Long id, int pin);
}
