package EPICODE.GestionePostazioni.services;

import EPICODE.GestionePostazioni.entities.Edificio;
import EPICODE.GestionePostazioni.exceptions.NotFoundException;
import EPICODE.GestionePostazioni.exceptions.ValidationException;
import EPICODE.GestionePostazioni.repositories.EdificioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public void saveUser(Edificio edificio) {

        if (edificio.getNome().length() < 2) throw new ValidationException("Nome troppo corto!");
        edificioRepository.save(edificio);
        log.info("Nuovo edificio " + edificio.getNome() + " salvato con successo!");
    }

    public Edificio findById(long edificioId) {
        return edificioRepository.findById(edificioId).orElseThrow(() -> new NotFoundException(edificioId));
    }

    public void findByIdAndDelete(long edificioId) {
        Edificio found = this.findById(edificioId);
        edificioRepository.delete(found);
        log.info("Utente con id " + edificioId + " cancellato correttamente!");
    }

    public long count() {
        return edificioRepository.count();
    }
    
}
