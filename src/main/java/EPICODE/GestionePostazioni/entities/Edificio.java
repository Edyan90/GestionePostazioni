package EPICODE.GestionePostazioni.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "edifici")
@Data
public class Edificio {
    @Id
    @GeneratedValue
    private Long Id;
    private String nome;
    private String indirizzo;
    private String citta;
}
