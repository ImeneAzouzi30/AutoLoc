package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicule")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;

    @Column(nullable = false, unique = true, length = 20)
    private String immatriculation;

    @Column(nullable = false, length = 50)
    private String marque;

    @Column(nullable = false, length = 50)
    private String modele;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CategorieVehicule categorie;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutVehicule statut;

    @ManyToOne(fetch = FetchType.LAZY)
    private Agence agence;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Maintenance> maintenances = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "vehicule_equipement",
        joinColumns = @JoinColumn(name = "id_vehicule"),
        inverseJoinColumns = @JoinColumn(name = "id_equipement")
    )
    private List<Equipement> equipements = new ArrayList<>();

    @OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();

    public Vehicule() {
    }

    public Vehicule(Long idVehicule, String immatriculation, String marque, String modele,
                    CategorieVehicule categorie, BigDecimal tarifJournalier, StatutVehicule statut) {
        this.idVehicule = idVehicule;
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.categorie = categorie;
        this.tarifJournalier = tarifJournalier;
        this.statut = statut;
    }

    public Long getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Long idVehicule) {
        this.idVehicule = idVehicule;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public CategorieVehicule getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieVehicule categorie) {
        this.categorie = categorie;
    }

    public BigDecimal getTarifJournalier() {
        return tarifJournalier;
    }

    public void setTarifJournalier(BigDecimal tarifJournalier) {
        this.tarifJournalier = tarifJournalier;
    }

    public StatutVehicule getStatut() {
        return statut;
    }

    public void setStatut(StatutVehicule statut) {
        this.statut = statut;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public List<Maintenance> getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(List<Maintenance> maintenances) {
        this.maintenances = maintenances;
    }

    public List<Equipement> getEquipements() {
        return equipements;
    }

    public void setEquipements(List<Equipement> equipements) {
        this.equipements = equipements;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addMaintenance(Maintenance maintenance) {
        if (maintenance != null) {
            this.maintenances.add(maintenance);
            maintenance.setVehicule(this);
        }
    }

    public void removeMaintenance(Maintenance maintenance) {
        if (maintenance != null) {
            this.maintenances.remove(maintenance);
            maintenance.setVehicule(null);
        }
    }

    public void addReservation(Reservation reservation) {
        if (reservation != null) {
            this.reservations.add(reservation);
            reservation.setVehicule(this);
        }
    }

    public void removeReservation(Reservation reservation) {
        if (reservation != null) {
            this.reservations.remove(reservation);
            reservation.setVehicule(null);
        }
    }

    public void addEquipement(Equipement equipement) {
        if (equipement != null) {
            this.equipements.add(equipement);
            equipement.getVehicules().add(this);
        }
    }

    public void removeEquipement(Equipement equipement) {
        if (equipement != null) {
            this.equipements.remove(equipement);
            equipement.getVehicules().remove(this);
        }
    }
}