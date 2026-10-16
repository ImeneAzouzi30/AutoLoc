package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;
import java.util.List;
import java.util.Optional;

public interface IReservationService {

    Reservation addReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);

    List<Reservation> getAllReservations();

    Optional<Reservation> getReservationById(Long idReservation);

    void deleteReservationById(Long idReservation);

    void deleteAllReservations();
}
