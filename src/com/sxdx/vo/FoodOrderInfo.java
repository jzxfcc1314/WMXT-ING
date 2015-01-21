package com.sxdx.vo;



public class FoodOrderInfo {
	private int orderID;
	private String customerName;
	private String address;
	private String telephone;
	private String allFoodInfo;
	private double totalPrice;
	private String wordLeft;
	private String state;
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAllFoodInfo() {
		return allFoodInfo;
	}
	public void setAllFoodInfo(String allFoodInfo) {
		this.allFoodInfo = allFoodInfo;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getWordLeft() {
		return wordLeft;
	}
	public void setWordLeft(String wordLeft) {
		this.wordLeft = wordLeft;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public FoodOrderInfo(String customerName, String address,String telephone, 
			String allFoodInfo, double totalPrice, String wordLeft, String state) {
		super();
		this.customerName = customerName;
		this.address = address;
		this.telephone = telephone;
		this.allFoodInfo = allFoodInfo;
		this.totalPrice = totalPrice;
		this.wordLeft = wordLeft;
		this.state = state;

	}
	public FoodOrderInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
