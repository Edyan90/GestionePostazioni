package EPICODE.GestionePostazioni.repositories;

import EPICODE.GestionePostazioni.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    @Query("SELECT p.data FROM Prenotazione p WHERE p.postazione.id = :postazioneId")
    List<LocalDate> findDatesByPostazioneId(Long postazioneId);
}
