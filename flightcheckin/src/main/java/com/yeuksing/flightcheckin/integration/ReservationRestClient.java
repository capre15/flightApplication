package com.yeuksing.flightcheckin.integration;

import com.yeuksing.flightcheckin.integration.dto.Reservation;
import com.yeuksing.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);
}
