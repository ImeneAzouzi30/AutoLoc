package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;
import java.util.List;
import java.util.Optional;

public interface IClientService {

    Client addClient(Client client);

    Client updateClient(Client client);

    List<Client> getAllClients();

    Optional<Client> getClientById(Long idClient);

    void deleteClientById(Long idClient);

    void deleteAllClients();
}
