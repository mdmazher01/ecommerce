package com.mazher.ecom.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mazher.ecom.entity.Track;
import com.mazher.ecom.service.Track_Service;

@RestController
@RequestMapping("api/track")
@CrossOrigin(origins = "http://localhost:4200")
public class Track_Controller {
	
	@Autowired
	Track_Service trackservice;
	
	@GetMapping("/getTrack/{trackingid}")
	@RolesAllowed("ROLE_CUSTOMER")
	public List<Track> getAllTrackingData(@PathVariable("trackingid") String trackingid) {
		return trackservice.getAllTrackingData(trackingid);
	}
	
	@GetMapping("/getall")
	@RolesAllowed("ROLE_ADMIN")
	public List<Track> getAll(){
		return trackservice.getAll();
	}
	
	@PutMapping("/update/{id}")
	@RolesAllowed("ROLE_ADMIN")
	public void updateTrack(@PathVariable("id") Long id, @RequestBody Track track) {
		trackservice.updateTrack(id,track);
	}
	
	
	@GetMapping("/getById/{id}")
	@RolesAllowed("ROLE_ADMIN")
	public List<Track> getById(@PathVariable("id") Long id){
		return trackservice.getById(id);
	}
	
	
}
