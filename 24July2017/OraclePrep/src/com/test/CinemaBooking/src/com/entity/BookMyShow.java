package com.entity;

import java.util.HashMap;

import com.service.TicketService;

public class BookMyShow {
	
	public static void main(String []args){
		
		Customer c=new Customer();
		c.setAge("40");
		c.setType("Adult");
		c.setName("Rakesh");
		
		Customer c1=new Customer();
		c1.setAge("40");
		c1.setType("Adult");
		c1.setName("Ranjan");
		
		Customer c2=new Customer();
		c2.setAge("4");
		c2.setType("Child");
		c2.setName("Ramesh");
		
		Customer c3=new Customer();
		c3.setAge("5");
		c3.setType("Child");
		c3.setName("Rohan");
		
		Seat s=new Seat();
		s.setRowNumber("A");
		s.setSeatNumber("10");
		s.setType("Delux");
		
		Seat s1=new Seat();
		s1.setRowNumber("AB");
		s1.setSeatNumber("20");
		s1.setType("Economy");
		
		TicketService tckService=new TicketService();
		
		
		TestConcurrency testConcurr=new TestConcurrency(c,s,tckService);
		Thread t1=new Thread(testConcurr);
		Thread t2=new Thread(new TestConcurrency(c1,s,tckService));
		Thread t3=new Thread(new TestConcurrency(c2,s,tckService));
		Thread t4=new Thread(new TestConcurrency(c3,s1,tckService));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
	private static class TestConcurrency implements Runnable{
		HashMap<Customer,Seat> customer_seat=new HashMap<Customer,Seat>();
		TicketService tcktService;
		TestConcurrency(Customer cust,Seat seat,TicketService tckService){
			customer_seat.put(cust, seat);
			this.tcktService=tckService;
		}
		@Override
		public void run() {
			tcktService.bookTickets(customer_seat);
		}
		
	}
}
