package EPICODE.GestionePostazioni.repositories;

import EPICODE.GestionePostazioni.entities.Postazione;
import EPICODE.GestionePostazioni.enums.PostazioneType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    @Query("SELECT p FROM Postazione p WHERE p.postazioneType =:postazioneType AND p.edificio.citta=:postazionecitta")
    List<Postazione> findByPostazioneTypeAndCity(PostazioneType postazioneType, String postazionecitta);
}
