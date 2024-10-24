package domain;

import java.time.LocalDate;

public class DataItem {

	private String direction;
	private int year;
	private LocalDate date;
	private String weekday;
	private String country;
	private String commodity;
	private String	transportMode;
	private String measure;
	private long value;
	private long cumulative;
	
	public DataItem() {
		
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction.toLowerCase();
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getWeekday() {
		return weekday;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday.toLowerCase();
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country.toLowerCase();
	}

	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity.toLowerCase();
	}

	public String getTransportMode() {
		return transportMode;
	}

	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode.toLowerCase();
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure.toLowerCase();
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public long getCumulative() {
		return cumulative;
	}

	public void setCumulative(long cumulative) {
		this.cumulative = cumulative;
	}
	
	
}
