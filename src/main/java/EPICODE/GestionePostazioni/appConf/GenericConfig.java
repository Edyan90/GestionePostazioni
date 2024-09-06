package EPICODE.GestionePostazioni.appConf;

import EPICODE.GestionePostazioni.entities.Edificio;
import EPICODE.GestionePostazioni.entities.Postazione;
import EPICODE.GestionePostazioni.entities.Utente;
import EPICODE.GestionePostazioni.enums.PostazioneType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class GenericConfig {
    ////EDIFICI
    @Bean
    @Scope("prototype")
    public Edificio accentureRoma() {
        return new Edificio("Accenture Roma", "Via Shangay 51", "Roma");
    }

    @Bean
    @Scope("prototype")
    public Edificio accentureMilano() {
        return new Edificio("Accenture Milano", "Via Logudoro 1", "Milano");
    }

    @Bean
    @Scope("prototype")
    public Edificio stmItaliaRoma() {
        return new Edificio("STM Italia Roma", "Via Elio Chianesi 124", "Roma");
    }

    @Bean
    @Scope("prototype")
    public Edificio stmItaliaMilano() {
        return new Edificio("STM Italia Milano", "Via degli schiavi 32", "Milano");
    }

    ///UTENTI
    @Bean
    @Scope("prototype")
    public Utente utente1() {
        return new Utente("Edyan", "Eddy Turpo", "edyan7@hotmail.it");
    }

    @Bean
    @Scope("prototype")
    public Utente utente2() {
        return new Utente("Arjanna", "Arianna Loreti", "aryannalore@hotmail.it");
    }

    @Bean
    @Scope("prototype")
    public Utente utente3() {
        return new Utente("Gabriele123", "Gabriel Azmqualcosa", "gabry@hotmail.it");
    }

    ////POSTAZIONI
    @Bean
    @Scope
    public Postazione postazioneOpenSpace() {
        return new Postazione("bello ma con tanto casino", PostazioneType.OPENSPACE, 50, accentureRoma());
    }

    @Bean
    @Scope
    public Postazione postazionePrivato1() {
        return new Postazione("comodo e silenzioso", PostazioneType.PRIVATO, 2, accentureRoma());
    }

    @Scope
    public Postazione postazionePrivato2() {
        return new Postazione("comodo e silenzioso", PostazioneType.PRIVATO, 2, accentureMilano());
    }

    @Scope
    public Postazione postazioneSala() {
        return new Postazione("Buono per feste", PostazioneType.SALA_RIUNIONI, 30, stmItaliaRoma());
    }

    @Scope
    public Postazione postazioneSala2() {
        return new Postazione("Buono per feste", PostazioneType.SALA_RIUNIONI, 30, stmItaliaMilano());
    }

    //Le prenotazioni vanno create manualmente.
}
