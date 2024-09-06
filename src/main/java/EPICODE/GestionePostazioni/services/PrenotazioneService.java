package EPICODE.GestionePostazioni.services;

import EPICODE.GestionePostazioni.entities.Prenotazione;
import EPICODE.GestionePostazioni.exceptions.NotFoundException;
import EPICODE.GestionePostazioni.repositories.PrenotazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public boolean isPostazioneAvailable(Long postazioneId, LocalDate requestedDate) {
        List<LocalDate> bookedDates = prenotazioneRepository.findDatesByPostazioneId(postazioneId);
        for (LocalDate date : bookedDates) {
            if (date.equals(requestedDate)) {
                return false;
            }
        }
        return true;
    }

    public void savePrenotazione(Prenotazione prenotazione) {
        if (isPostazioneAvailable(prenotazione.getPostazione().getId(), prenotazione.getData())) {
            prenotazioneRepository.save(prenotazione);
            log.info("Nuova prenotazione con ID " + prenotazione.getId() + "salvata con successo!");
        } else {
            throw new IllegalArgumentException("Postazione già prenotata per questa data");
        }
    }

    public Prenotazione findByIdPrenotazione(long prenotazioneID) {
        return prenotazioneRepository.findById(prenotazioneID).orElseThrow(() -> new NotFoundException(prenotazioneID));
    }

    public void findByIdAndDelete(long prenotazioneID) {
        Prenotazione found = this.findByIdPrenotazione(prenotazioneID);
        prenotazioneRepository.delete(found);
        log.info("Prenotazione con id: " + prenotazioneID + " cancellato correttamente!");
    }

    public long count() {
        return prenotazioneRepository.count();
    }

}
