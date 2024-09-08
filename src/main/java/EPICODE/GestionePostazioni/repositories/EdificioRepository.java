package EPICODE.GestionePostazioni.repositories;

import EPICODE.GestionePostazioni.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {
    @Query("SELECT e FROM Edificio e WHERE e.citta =:city")
    List<Edificio> findEdificioByCity(String city);
}
