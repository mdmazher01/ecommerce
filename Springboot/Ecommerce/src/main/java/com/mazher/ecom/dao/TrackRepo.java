package com.mazher.ecom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazher.ecom.entity.Track;

@Repository
public interface TrackRepo extends JpaRepository<Track, Long>{

	List<Track> findTrackRecordsByTrackingid(String trackingid);
	
	@Query("select u from Track u where u.id=:n")
	List<Track> findByIdGetList(@Param("n") Long id);

}
