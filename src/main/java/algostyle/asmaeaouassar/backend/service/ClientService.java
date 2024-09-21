package algostyle.asmaeaouassar.backend.service;


import algostyle.asmaeaouassar.backend.entites.Client;
import algostyle.asmaeaouassar.backend.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void create(Client client){
        Client clientFromDB=this.clientRepository.findByEmail(client.getEmail());
        if(clientFromDB==null){ // ex:gestion d'erreur ->  comme ça l'erreur ne s'affiche pas dans postman
            this.clientRepository.save(client);
        }
    }


    public List<Client> getClients(){
        return this.clientRepository.findAll();
    }

    public Client getClientById(int id) {
        Optional<Client> optionalClient=this.clientRepository.findById(id); // Optional est une classe en Java qui représente une valeur potentiellement présente ou absente
        return optionalClient.orElse(null);
    }

    public Client readOrCreate(Client client){
        Client clientFromDB=this.clientRepository.findByEmail(client.getEmail());
        if(clientFromDB==null){
            this.clientRepository.save(client);
        }
        return clientFromDB;
    }

    public void update(int idOfOldClient, Client newClient) {
        Client clientFromDB=this.getClientById(idOfOldClient);
        if(clientFromDB.getId()==newClient.getId()){
            clientFromDB.setEmail(newClient.getEmail());
            clientFromDB.setTelephone(newClient.getTelephone());
            this.clientRepository.save(clientFromDB);
        }
    }

}
