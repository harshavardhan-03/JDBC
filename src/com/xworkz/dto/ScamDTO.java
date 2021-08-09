package com.xworkz.dto;

import java.io.Serializable;
import java.sql.Date;

public class ScamDTO implements Serializable {

	private int id;
	private String name;
	private String type;
	private Date year;
	private String by;
	private double amount; 
	private String location;
	private String description;
	public ScamDTO() {
	}
	public ScamDTO(int id, String name, String type, Date year, String by, double amount,
			String location, String description) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.year = year;
		this.by = by;
		this.amount = amount;
		this.location = location;
		this.description = description;
	}
	@Override
	public int hashCode() {
		return 1;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof ScamDTO) {
			ScamDTO casted = (ScamDTO) obj;
			if (this.name.equals(casted.name) && this.year == casted.year
					&& this.amount == casted.amount) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "ScamDTO [id=" + id + ", name=" + name + ", type=" + type + ", year=" + year + ", by="
				+ by + ", amount=" + amount + ", location=" + location + ", description=" + description
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public String getBy() {
		return by;
	}
	public void setBy(String by) {
		this.by = by;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}