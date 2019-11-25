package com.example.quiz;

public class Item {
int id;
String drink;
String size;
String suger;
String ice;
String dosing;
String price;
String time;
String custom_id ;
public Item() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDrink() {
	return drink;
}
public void setDrink(String drink) {
	this.drink = drink;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public String getSuger() {
	return suger;
}
public void setSuger(String suger) {
	this.suger = suger;
}
public String getIce() {
	return ice;
}
public void setIce(String ice) {
	this.ice = ice;
}
public String getDosing() {
	return dosing;
}
public void setDosing(String dosing) {
	this.dosing = dosing;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getCustom_id() {
	return custom_id;
}
public void setCustom_id(String custom_id) {
	this.custom_id = custom_id;
}
public String toString() {
	return "Item [id=" + id + ", drink=" + drink + ", size=" + size + ", suger=" + suger + ", ice=" + ice + ", dosing="
			+ dosing + ", price=" + price + ", time=" + time + ", custom_id=" + custom_id + "]";
}
}

