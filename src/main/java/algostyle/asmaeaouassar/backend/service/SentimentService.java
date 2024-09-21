package algostyle.asmaeaouassar.backend.service;

import algostyle.asmaeaouassar.backend.entites.Client;
import algostyle.asmaeaouassar.backend.entites.Sentiment;
import algostyle.asmaeaouassar.backend.enums.TypeSentiment;
import algostyle.asmaeaouassar.backend.repository.SentimentRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SentimentService {

    private ClientService clientService;
    private SentimentRepository sentimentRepository;

    public SentimentService(ClientService clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }

    public void create(Sentiment sentiment){
        // avant la création du sentiment
        // on va demander au ClientService de créer le client s'il n'existe pas déjà
        // et de nous retourner le client au cas où il existe déjà
        Client client=this.clientService.readOrCreate(sentiment.getClient());
        sentiment.setClient(client);

        // avant d'enregistrer le sentiment on peut analyser ce sentiment
        // on peut le faire en utilisant une api externe
        if(sentiment.getTexte().contains("pas")){
            sentiment.setType(TypeSentiment.NEGATIF);
        }else{
            sentiment.setType(TypeSentiment.POSITIF);
        }
        this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> getSentiments(TypeSentiment typeSentiment) {
        if(typeSentiment==null){
            return this.sentimentRepository.findAll();
        }else{
            return this.sentimentRepository.findByType(typeSentiment);
        }
    }

    public void deleteById(int id) {
        this.sentimentRepository.deleteById(id);
    }
}
