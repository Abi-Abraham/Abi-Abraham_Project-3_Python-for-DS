package com.gl.project3.tickettracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.project3.tickettracker.entity.Ticket;
import com.gl.project3.tickettracker.service.TicketTrackerService;

@Controller
public class TicketTrackerController {

	@Autowired
	TicketTrackerService ticketService;

	@GetMapping("/tickets")
	public String getTickets(Model model) {
		model.addAttribute("tickets", ticketService.getTickets());
		return "tickets";
	}

	@GetMapping("/tickets/new")
	public String createTicketForm(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "new_ticket";
	}

	@PostMapping("/saveticket")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.addNewTicket(ticket);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/edit/{id}")
	public String editTicket(@PathVariable int id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "edit_ticket";
	}

	@PostMapping("/tickets/{id}")
	public String updateTicket(@PathVariable int id, @ModelAttribute("ticket") Ticket ticket) {

		ticketService.updateTicketById(id, ticket);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/{id}")
	public String deleteTicket(@PathVariable int id) {
		ticketService.deleteTicketById(id);
		return "redirect:/tickets";

	}

	@GetMapping("/tickets/view/{id}")
	public String viewTicket(@PathVariable int id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "view_ticket";

	}

	@GetMapping("/tickets/search")
	public String searchTicket(@RequestParam("query") String query, Model model) {
		List<Ticket> tickets = ticketService.searchTicket(query);
		model.addAttribute("tickets", tickets);
		return "/tickets";

	}

}
