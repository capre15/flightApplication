package com.yeuksing.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeuksing.flightreservation.dto.ReservationRequest;
import com.yeuksing.flightreservation.entities.Flight;
import com.yeuksing.flightreservation.entities.Passenger;
import com.yeuksing.flightreservation.entities.Reservation;
import com.yeuksing.flightreservation.repos.FlightRepository;
import com.yeuksing.flightreservation.repos.PassengerRepository;
import com.yeuksing.flightreservation.repos.ReservationRepository;


@Service
public class ReservationServiceImpl implements ReservationService {
	
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		//Make payment
		
		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();
		
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		
		
		
		return savedReservation;
	}
	
	
	
}
