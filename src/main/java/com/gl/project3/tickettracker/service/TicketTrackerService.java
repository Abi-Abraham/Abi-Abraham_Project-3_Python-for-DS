package com.gl.project3.tickettracker.service;

import java.util.List;
import com.gl.project3.tickettracker.entity.Ticket;

public interface TicketTrackerService {
	
	public List<Ticket> getTickets();

	public Ticket addNewTicket(Ticket ticket);

	public Ticket getTicketById(int id);

	public void deleteTicketById(int id);

	public Ticket updateTicketById(int id, Ticket existingTicket);

	public List<Ticket> searchTicket(String query);

}
