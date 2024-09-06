package EPICODE.GestionePostazioni.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    //qui ci vanno i componenti da richiamare
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {

    }
}
