package com.yeuksing.flightreservation.services;

import org.springframework.stereotype.Service;

import com.yeuksing.flightreservation.dto.ReservationRequest;
import com.yeuksing.flightreservation.entities.Reservation;


@Service
public interface ReservationService {
	
	
	
	public Reservation bookFlight(ReservationRequest request);
	
}
