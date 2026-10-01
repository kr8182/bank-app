package ru.kr8182.bankapp.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kr8182.bankapp.exceptions.ClientNotFoundException;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client createClient(Client client) {
        clientRepository.findByEmail(client.getEmail())
                .ifPresent(c -> {
                    throw new IllegalArgumentException("Клиент с таким email уже существует");
                });
        return clientRepository.save(client);
    }

    public Client getClientById (long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

}


