package com.gl.project3.tickettracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.project3.tickettracker.entity.Ticket;

@Repository
public interface TicketTrackerRepository extends JpaRepository<Ticket, Integer> {

	@Query("SELECT t FROM Ticket t WHERE t.title LIKE %?1% OR t.description LIKE %?1%")
	public List<Ticket> searchTickets(String query);

}
