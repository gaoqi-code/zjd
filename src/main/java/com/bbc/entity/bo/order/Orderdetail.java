package com.bbc.entity.bo.order;

public class Orderdetail {

	private Integer orderId;
	private String menuName;
	private Integer menuId;
	private Integer menuCount;
	private Double price;
	private  Double totalPrice;
	private Integer status;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	
	public Integer getMenuCount() {
		return menuCount;
	}
	public void setMenuCount(Integer menuCount) {
		this.menuCount = menuCount;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
}
