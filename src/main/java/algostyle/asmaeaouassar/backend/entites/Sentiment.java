package algostyle.asmaeaouassar.backend.entites;

import algostyle.asmaeaouassar.backend.enums.TypeSentiment;
import jakarta.persistence.*;


@Entity
@Table(name = "SENTIMENT")
public class Sentiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String texte;
    @Enumerated(EnumType.STRING)  // Mapping par string:nom de l'enum
    private TypeSentiment type;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}) // :D => Sans avoir à gérer manuellement :
    @JoinColumn(name="CLIENT_ID")  // pour indiquer le champ qui contient la clé étrangere
    private Client client; // le client qui a déposé le sentiment


    public Sentiment() {
    }

    public Sentiment(int id, String texte, TypeSentiment type, Client client) {
        this.id = id;
        this.texte = texte;
        this.type = type;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public TypeSentiment getType() {
        return type;
    }

    public void setType(TypeSentiment type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
