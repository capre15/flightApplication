package com.yeuksing.flightreservation.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yeuksing.flightreservation.entities.Reservation;





public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	Reservation save(Reservation reservation);

}
