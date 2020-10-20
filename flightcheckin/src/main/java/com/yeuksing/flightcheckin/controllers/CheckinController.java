package com.yeuksing.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yeuksing.flightcheckin.integration.ReservationRestClient;
import com.yeuksing.flightcheckin.integration.dto.Reservation;
import com.yeuksing.flightcheckin.integration.dto.ReservationUpdateRequest;


@Controller
public class CheckinController {
	
	@Autowired
	ReservationRestClient restClient;
	
	
	
	
	
	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckIn";
	}
	
	
	@RequestMapping("/startCheckIn")
	public String startCheckIn(Long reservationId, ModelMap modelMap) {
		Reservation reservation = restClient.findReservation(reservationId);
		modelMap.addAttribute("reservation",reservation);
		
		
		
		
		return "displayReservationDetails";
	}
	
	
	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId")Long reservationId, @RequestParam("numberOfBags")int numberOfBags) {
		ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
		reservationUpdateRequest.setId(reservationId);
		reservationUpdateRequest.setCheckedIn(true);
		reservationUpdateRequest.setNumberOfBags(numberOfBags);
		restClient.updateReservation(reservationUpdateRequest);
		
		
		return "checkInConfirmation";
	}
	
	
}
