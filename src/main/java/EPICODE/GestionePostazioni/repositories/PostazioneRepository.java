package EPICODE.GestionePostazioni.repositories;

import EPICODE.GestionePostazioni.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

}
