package com.example.quiz;

public class Custom {
  String idcard;
  String name;
  int  integral;
  String time;
public String getIdcard() {
	return idcard;
}
public void setIdcard(String idcard) {
	this.idcard = idcard;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getIntegral() {
	return integral;
}
public void setIntegral(int integral) {
	this.integral = integral;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public Custom() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Custom [idcard=" + idcard + ", name=" + name + ", integral=" + integral + ", time=" + time + "]";
}

}
