package EPICODE.GestionePostazioni.runners;

import EPICODE.GestionePostazioni.entities.Edificio;
import EPICODE.GestionePostazioni.entities.Postazione;
import EPICODE.GestionePostazioni.entities.Utente;
import EPICODE.GestionePostazioni.services.EdificioService;
import EPICODE.GestionePostazioni.services.PostazioneService;
import EPICODE.GestionePostazioni.services.PrenotazioneService;
import EPICODE.GestionePostazioni.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    //qui ci vanno i componenti da richiamare
    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private UtenteService utenteService;
    @Autowired
    private ApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------------------QUI SIAMO DENTRO AL RUN----------------------");
        ///Salvataggi Edifici
        Edificio edificio1 = ctx.getBean("accentureRoma", Edificio.class);
        Edificio edificio2 = ctx.getBean("accentureMilano", Edificio.class);
        Edificio edificio3 = ctx.getBean("stmItaliaRoma", Edificio.class);
        Edificio edificio4 = ctx.getBean("stmItaliaMilano", Edificio.class);

        edificioService.saveEdificio(edificio1);
        edificioService.saveEdificio(edificio2);
        edificioService.saveEdificio(edificio3);
        edificioService.saveEdificio(edificio4);

        ///Salvataggi Utenti
        Utente utente1 = ctx.getBean("utente1", Utente.class);
        Utente utente2 = ctx.getBean("utente2", Utente.class);
        Utente utente3 = ctx.getBean("utente3", Utente.class);

        utenteService.saveUtente(utente1);
        utenteService.saveUtente(utente2);
        utenteService.saveUtente(utente3);


        ///Salvataggi Postazioni prendendo dal database l'edificio
//        Edificio edificioDb1 = edificioService.findByIdEdificio(2);
//        Edificio edificioDb2 = edificioService.findByIdEdificio(3);
//        Edificio edificioDb3 = edificioService.findByIdEdificio(4);
//        Edificio edificioDB4 = edificioService.findByIdEdificio(5);


        ////creo ora le postazioni dato che esse hanno bisogno dell'edificio prima di essere create
        Postazione postazione1 = ctx.getBean("postazioneOpenSpace", Postazione.class);
        Postazione postazione2 = ctx.getBean("postazionePrivato1", Postazione.class);
        Postazione postazione3 = ctx.getBean("postazionePrivato2", Postazione.class);
        Postazione postazione4 = ctx.getBean("postazioneSala", Postazione.class);
        Postazione postazione5 = ctx.getBean("postazioneSala2", Postazione.class);


        postazioneService.savePostazione(postazione1);
        postazioneService.savePostazione(postazione2);
        postazioneService.savePostazione(postazione3);
        postazioneService.savePostazione(postazione4);
        postazioneService.savePostazione(postazione5);
        System.out.println("-------------------------QUI FINISCE IL RUN-------------------------");
    }
}
