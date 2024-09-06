package EPICODE.GestionePostazioni.entities;

import EPICODE.GestionePostazioni.enums.PostazioneType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Table(name = "postazioni")
@Entity
@Data
public class Postazione {
    private final boolean stato = true;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private PostazioneType postazioneType;
    private int numeroMaxOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;

}
