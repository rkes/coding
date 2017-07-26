package com.entity;

public class Ticket {

	private String seatNumber;

	private String rowNumber;

	private Price price;

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
	}

	public enum Price {
		PREMIUM_CHILD("Premium", "Child"), PREMIUM_ADULT("Premium", "Adult"), DELUX_ADULT("Delux",
				"Adult"), DELUX_CHILD("Delux",
						"Child"), ECONOMY_CHILD("Economy", "Child"), ECONOMY_ADULT("Economy", "Adult");
		private double price;

		Price(String typeOfSeat, String typeOfCustomer) {
			double sum = 0;
			switch (typeOfSeat) {
			case "Premium":
				sum = 90;
				break;
			case "Delux":
				sum = 50;
				break;
			case "Economy":
				sum = 40;
				break;
			}
			if (typeOfCustomer.equals("Child")) {
				sum = sum * 0.9;
			}
			this.price = sum;
		}

		public static final Price getPrice(String seatType, String custType) {
			if(seatType.equals("Premium")&&custType.equals("Child"))
				return PREMIUM_CHILD;
			else if(seatType.equals("Premium")&&custType.equals("Adult"))
				return PREMIUM_ADULT;
			else if(seatType.equals("Delux")&&custType.equals("Adult"))
				return DELUX_ADULT;
			else if(seatType.equals("Delux")&&custType.equals("Child"))
				return DELUX_CHILD;
			else if(seatType.equals("Economy")&&custType.equals("Child"))
				return ECONOMY_CHILD;
			else
				return ECONOMY_ADULT;
			
		}

		public String toString() {
			return new String(this.price + "");
		}
	}

}
