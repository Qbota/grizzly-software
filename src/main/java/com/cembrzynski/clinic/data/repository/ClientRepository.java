package com.cembrzynski.clinic.data.repository;

import com.cembrzynski.clinic.data.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
