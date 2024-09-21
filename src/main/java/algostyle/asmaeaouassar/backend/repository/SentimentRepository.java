package algostyle.asmaeaouassar.backend.repository;

import algostyle.asmaeaouassar.backend.entites.Sentiment;
import algostyle.asmaeaouassar.backend.enums.TypeSentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment,Integer> {
    List<Sentiment> findByType(TypeSentiment typeSentiment);
}
