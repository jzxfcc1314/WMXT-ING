package com.sxdx.vo;

public class FoodOrderInfo {
	private int orderID;
	private String customerName;
	private String address;
	private String zipCode;
	private String telephone;
	private String movePhone;
	private String notice;
	private double totalPrice;
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
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMovePhone() {
		return movePhone;
	}
	public void setMovePhone(String movePhone) {
		this.movePhone = movePhone;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public FoodOrderInfo(String customerName, String address,
			String zipCode, String telephone, String movePhone, String notice,
			double totalPrice) {
		super();
		this.orderID = orderID;
		this.customerName = customerName;
		this.address = address;
		this.zipCode = zipCode;
		this.telephone = telephone;
		this.movePhone = movePhone;
		this.notice = notice;
		this.totalPrice = totalPrice;
	}

}
