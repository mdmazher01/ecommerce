package com.mazher.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazher.ecom.dao.TrackRepo;
import com.mazher.ecom.entity.Track;

@Service
public class Track_Service {
	
	
	@Autowired
	TrackRepo trackrepo;

	public List<Track> getAllTrackingData(String trackingid) {
		return trackrepo.findTrackRecordsByTrackingid(trackingid);
	}

	public List<Track> getAll() {
		return trackrepo.findAll();
	}

	public void updateTrack(Long id, Track track) {
		Track data = trackrepo.findById(id).get();
		data.setOrderconfirmed(track.isOrderconfirmed());
		data.setPickedbycourier(track.isPickedbycourier());
		data.setOntheway(track.isOntheway());
		data.setOutfordelivery(track.isOutfordelivery());
		data.setDelivered(track.isDelivered());
		data.setPending(track.isPending());
		trackrepo.save(data);
		
	}

	public List<Track> getById(Long id) {
		return trackrepo.findByIdGetList(id);
	}

	
	
}
