package algostyle.asmaeaouassar.backend.controller;

import algostyle.asmaeaouassar.backend.entites.Sentiment;
import algostyle.asmaeaouassar.backend.enums.TypeSentiment;
import algostyle.asmaeaouassar.backend.service.SentimentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "sentiment",produces = APPLICATION_JSON_VALUE)
public class SentimentController {

    private SentimentService sentimentService;
    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Sentiment sentiment){
        this.sentimentService.create(sentiment);
    }

    @GetMapping
    public @ResponseBody List<Sentiment> getSentiments(
            @RequestParam(required=false) TypeSentiment typeSentiment) // ATTENTION : l'attribut à mettre dans l'URL dans POSTMAN est: <typeSentiment>
    {
        return this.sentimentService.getSentiments(typeSentiment);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path="{id}")
    public void deleteById(@PathVariable int id){
        this.sentimentService.deleteById(id);
    }



}
