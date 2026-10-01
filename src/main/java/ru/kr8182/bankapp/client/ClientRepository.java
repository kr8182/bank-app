package ru.kr8182.bankapp.client;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ru.kr8182.bankapp.client.Client, Long> {

    Optional<Client> findByEmail(String email);
    Optional<Client> findByDPAN (String dpan);
}
