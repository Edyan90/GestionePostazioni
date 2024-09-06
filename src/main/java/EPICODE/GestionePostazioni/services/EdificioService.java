package EPICODE.GestionePostazioni.services;

import EPICODE.GestionePostazioni.entities.Edificio;
import EPICODE.GestionePostazioni.repositories.EdificioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public void saveEdificio(Edificio edifico){
        try{
            edificioRepository.save(edifico);
            log.info("Nuovo prodotto: "+ edifico.getNome() +" salvato con successo!");
        }catch ()
    }
}
