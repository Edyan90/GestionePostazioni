package EPICODE.GestionePostazioni.services;


import EPICODE.GestionePostazioni.entities.Utente;
import EPICODE.GestionePostazioni.exceptions.NotFoundException;
import EPICODE.GestionePostazioni.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public void saveUtente(Utente utente) {
        utenteRepository.save(utente);
        log.info("Nuovo utente di nome: " + utente.getNomeCompleto() + "salvato con successo!");
    }

    public Utente findById(long utenteID) {
        return utenteRepository.findById(utenteID).orElseThrow(() -> new NotFoundException(utenteID));
    }

    public void findByIdAndDelete(long utenteId) {
        Utente found = this.findById(utenteId);
        utenteRepository.delete(found);
        log.info("Postazione con id: " + utenteId + " cancellato correttamente!");
    }

    public long count() {
        return utenteRepository.count();
    }


}