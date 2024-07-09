package com.gl.project3.tickettracker.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.project3.tickettracker.dao.TicketTrackerRepository;
import com.gl.project3.tickettracker.entity.Ticket;
import com.gl.project3.tickettracker.service.TicketTrackerService;

@Service
public class TicketTrackerServiceImpl implements TicketTrackerService {

	@Autowired
	TicketTrackerRepository repository;

	@Override
	public List<Ticket> getTickets() {

		return repository.findAll();

	}

	@Override
	public Ticket addNewTicket(Ticket ticket) {
		ticket.setDate(LocalDateTime.now());
		return repository.save(ticket);

	}

	@Override
	public Ticket getTicketById(int id) {
		return this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Ticket Id"));

	}

	@Override
	public void deleteTicketById(int id) {
		repository.deleteById(id);

	}

	@Override
	public Ticket updateTicketById(int id, Ticket existingTicket) {
		Ticket t = this.getTicketById(id);
		t.setTitle(existingTicket.getTitle());
		t.setDescription(existingTicket.getDescription());
		t.setContent(existingTicket.getContent());
		repository.save(t);
		return t;
	}

	@Override
	public List<Ticket> searchTicket(String query) {
		List<Ticket> tickets = repository.searchTickets(query);
		return tickets.stream().collect(Collectors.toList());
	}

}
