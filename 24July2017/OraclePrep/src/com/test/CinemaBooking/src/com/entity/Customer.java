package com.entity;

public final class Customer {

	private String name;
	
	private String age;
	
	private String type;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getType() {
		
		if(this.type.equals("Adult"))
				return CustomerType.ADULT.toString();
		else 
				return CustomerType.CHILD.toString();
	}


	public void setType(String type) {
		this.type = type;
	}


	enum CustomerType{
		ADULT("Adult"),CHILD("Child");
		
		private final String custType; 
		
		CustomerType(String type){
			this.custType=type;
		}
		
		public String toString(){
			return this.custType;
		}
	}

}
