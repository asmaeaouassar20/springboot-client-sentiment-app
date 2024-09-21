package algostyle.asmaeaouassar.backend.repository;

import algostyle.asmaeaouassar.backend.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    Client findByEmail(String email);

}
