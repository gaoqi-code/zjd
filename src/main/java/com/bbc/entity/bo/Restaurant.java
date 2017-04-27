package com.bbc.entity.bo;

public class Restaurant {

	private Integer restaurantId;
	private String restaurantName;
	private String restaurantDesc;
	private String restaurantMobile;
	private String restaurantAddr;
	private String restaurantStar;
	private String restaurantIcon;
	private Integer isSendMessage;
	
	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantIcon() {
		return restaurantIcon;
	}
	public void setRestaurantIcon(String restaurantIcon) {
		this.restaurantIcon = restaurantIcon;
	}
	public String getRestaurantMobile() {
		return restaurantMobile;
	}
	public void setRestaurantMobile(String restaurantMobile) {
		this.restaurantMobile = restaurantMobile;
	}
	public String getRestaurantAddr() {
		return restaurantAddr;
	}
	public void setRestaurantAddr(String restaurantAddr) {
		this.restaurantAddr = restaurantAddr;
	}
	public String getRestaurantDesc() {
		return restaurantDesc;
	}
	public void setRestaurantDesc(String restaurantDesc) {
		this.restaurantDesc = restaurantDesc;
	}
	public String getRestaurantStar() {
		return restaurantStar;
	}
	public void setRestaurantStar(String restaurantStar) {
		this.restaurantStar = restaurantStar;
	}
	public Integer getIsSendMessage() {
		return isSendMessage;
	}
	public void setIsSendMessage(Integer isSendMessage) {
		this.isSendMessage = isSendMessage;
	}
}
