package com.yeuksing.flightreservation.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yeuksing.flightreservation.entities.Passenger;




public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}
