package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "equipement")
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipement;

    @Column(nullable = false, length = 100)
    private String libelle;

    @ManyToMany(mappedBy = "equipements", fetch = FetchType.LAZY)
    private List<Vehicule> vehicules = new ArrayList<>();

    public Equipement() {
    }

    public Equipement(Long idEquipement, String libelle) {
        this.idEquipement = idEquipement;
        this.libelle = libelle;
    }

    public Long getIdEquipement() {
        return idEquipement;
    }

    public void setIdEquipement(Long idEquipement) {
        this.idEquipement = idEquipement;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }
}
