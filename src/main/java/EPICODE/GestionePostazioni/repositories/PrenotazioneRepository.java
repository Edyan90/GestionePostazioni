package EPICODE.GestionePostazioni.repositories;

import EPICODE.GestionePostazioni.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Double> {
}
