package EPICODE.GestionePostazioni.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "utenti")
@Data
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String username;
    private String nomeCompleto;
    private String email;


    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;
}
