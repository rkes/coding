package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.Customer;
import com.entity.Seat;
import com.entity.Ticket;

public class TicketService {
	
	public List<Ticket> bookTickets(HashMap<Customer,Seat> customer_seat){
		
		List<Ticket> tickets=new ArrayList<Ticket>();
		
		for(Map.Entry<Customer,Seat> entry:customer_seat.entrySet()){
			Ticket ticket=new Ticket();
			
			Customer customer=entry.getKey();
			Seat seat=entry.getValue();
			System.out.println(" Booking of "+customer.getName()+" Tried");
			synchronized (seat)
			{
				ticket.setRowNumber(seat.getRowNumber());
				ticket.setSeatNumber(seat.getSeatNumber());
				ticket.setPrice(Ticket.Price.getPrice(seat.getType(), customer.getType()));
				tickets.add(ticket);
				System.out.println(" Booking of "+customer.getName()+" Started");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(" Booking of "+customer.getName()+" Done");
			}
		}
		return tickets;
	}
	
}
