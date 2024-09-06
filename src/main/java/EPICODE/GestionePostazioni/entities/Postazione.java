package EPICODE.GestionePostazioni.entities;

import EPICODE.GestionePostazioni.enums.PostazioneType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "postazioni")
@Entity
@Getter
@Setter
@NoArgsConstructor

public class Postazione {
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

    public Postazione(String descrizione, PostazioneType postazioneType, int numeroMaxOccupanti, Edificio edificio) {
        this.descrizione = descrizione;
        this.postazioneType = postazioneType;
        this.numeroMaxOccupanti = numeroMaxOccupanti;
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return "Postazione{" +
                ", id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", postazioneType=" + postazioneType +
                ", numeroMaxOccupanti=" + numeroMaxOccupanti +
                ", edificio=" + edificio.getNome() + "/" + edificio.getCitta() +
                '}';
    }
}
