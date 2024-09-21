package algostyle.asmaeaouassar.backend.controller;

import algostyle.asmaeaouassar.backend.entites.Client;
import algostyle.asmaeaouassar.backend.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path="client")
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Client client){
        this.clientService.create(client);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Client> getClients(){
        return this.clientService.getClients();
    }

    @GetMapping(path="{id}",produces = APPLICATION_JSON_VALUE)
    public Client getClientById(@PathVariable int id){
        return this.clientService.getClientById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path="{id}",consumes=APPLICATION_JSON_VALUE)
    public void update(@PathVariable("id") int idOfOldClient,@RequestBody Client newClient){
        this.clientService.update(idOfOldClient,newClient);
    }

}
