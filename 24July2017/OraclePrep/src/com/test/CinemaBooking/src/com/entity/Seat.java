package com.entity;

public class Seat {
	private String rowNumber;
	private String seatNumber;
	private String type;
	public String getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(String rowNumber) {
		this.rowNumber = rowNumber;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getType() {
		switch(this.type){
			case "Delux":
				return SeatType.Delux.toString();
			case "Premium":
				return SeatType.Premium.toString();
			default:
				return SeatType.Economy.toString();
		}
	}
	public void setType(String type) {
		this.type = type;
	}
	enum SeatType{
		Delux("Delux"),Premium("Premium"),Economy("Economy");
		
		private final String seatType; 
		
		SeatType(String type){
			this.seatType=type;
		}
		
		public String toString(){
			return this.seatType;
		}
	}
	
}
