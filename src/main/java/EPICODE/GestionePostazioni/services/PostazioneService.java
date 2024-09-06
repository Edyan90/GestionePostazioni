package EPICODE.GestionePostazioni.services;

import EPICODE.GestionePostazioni.entities.Postazione;
import EPICODE.GestionePostazioni.exceptions.NotFoundException;
import EPICODE.GestionePostazioni.repositories.PostazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public void savePostazione(Postazione postazione) {

        postazioneRepository.save(postazione);
        log.info("Nuova postazione con ID: " + postazione.getId() + " di tipo" + postazione.getPostazioneType() + "situato in: " + postazione.getEdificio().getIndirizzo() + "-" + postazione.getEdificio().getCitta() + " salvata con successo!");
    }

    public Postazione findById(long postazioneId) {
        return postazioneRepository.findById(postazioneId).orElseThrow(() -> new NotFoundException(postazioneId));
    }

    public void findByIdAndDelete(long postazioneId) {
        Postazione found = this.findById(postazioneId);
        postazioneRepository.delete(found);
        log.info("Postazione con id: " + postazioneId + " cancellato correttamente!");
    }

    public long count() {
        return postazioneRepository.count();
    }


}
