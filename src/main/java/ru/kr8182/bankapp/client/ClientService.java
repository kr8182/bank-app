package ru.kr8182.bankapp.client;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.kr8182.bankapp.exceptions.ClientNotFoundException;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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

    public List<Client> getAllClients () {
        return clientRepository.findAll(Sort.by("id").ascending());
    }

    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ClientNotFoundException(id);
        }
        clientRepository.deleteById(id);
    }

}


