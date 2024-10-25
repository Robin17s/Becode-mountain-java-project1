package domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConvertingData {

	public ConvertingData() {
		
	}
	
	public List<DataItem> executeFilteringOfMonthlyConvertings(DataRepository rep, String country, String commodity, String transportMode, String measure, int month, int year){
		List<DataItem> list = rep.getDataList();
		country = country.toLowerCase();
		commodity = commodity.toLowerCase();
		transportMode = transportMode.toLowerCase();
		measure = measure.toLowerCase();
		
		List<DataItem> filteredList = filterListByCountry(list, country);
		filteredList = filterListByCommodity(filteredList, commodity);
		filteredList = filterListByTransportation(filteredList, transportMode);
		filteredList = filterListByMeasure(filteredList, measure);
		filteredList = filterListByMonth(filteredList, month, year);
		
		return filteredList;
	}
	
	public List<DataItem> executeFilteringOfYearlyConvertings(DataRepository rep, String country, String commodity, String transportMode, String measure, int year){
		List<DataItem> list = rep.getDataList();
		country = country.toLowerCase();
		commodity = commodity.toLowerCase();
		transportMode = transportMode.toLowerCase();
		measure = measure.toLowerCase();
		
		List<DataItem> filteredList = filterListByCountry(list, country);
		filteredList = filterListByCommodity(filteredList, commodity);
		filteredList = filterListByTransportation(filteredList, transportMode);
		filteredList = filterListByMeasure(filteredList, measure);
		filteredList = filterListByYear(filteredList, year);
		
		return filteredList;
	}
	
	public long getMonthlyTotal(DataRepository rep, String country, String commodity, String transportMode, String measure, int month, int year) {
		List<DataItem> filteredList = executeFilteringOfMonthlyConvertings(rep, country, commodity, transportMode, measure, month, year);
		
		long total = 0;
		for(DataItem item : filteredList) {
			total += item.getValue();
		}
		
		return total;
	}
	
	public double getMonthlyAverage(DataRepository rep, String country, String commodity, String transportMode, String measure, int month, int year) {
		List<DataItem> filteredList = executeFilteringOfMonthlyConvertings(rep, country, commodity, transportMode, measure, month, year);
		
		long total = 0;
		for(DataItem item : filteredList) {
			total += item.getValue();
		}
		
		return (double) total / filteredList.size();
	}
	
	public long getYearlyTotal(DataRepository rep, String country, String commodity, String transportMode, String measure, int year) {
		List<DataItem> filteredList = executeFilteringOfYearlyConvertings(rep, country, commodity, transportMode, measure, year);
		
		long total = 0;
		for(DataItem item : filteredList) {
			total += item.getValue();
		}
		
		return total;
	}
	
	public double getYearlyAverage(DataRepository rep, String country, String commodity, String transportMode, String measure, int year) {
		List<DataItem> filteredList = executeFilteringOfYearlyConvertings(rep, country, commodity, transportMode, measure, year);
		
		long total = 0;
		for(DataItem item : filteredList) {
			total += item.getValue();
		}
		
		return (double) total / filteredList.size();
	}
	
	public List<DataItem> filterListByCountry(List<DataItem> list, String country){		
		List<DataItem> filteredList = new ArrayList<>();
		
		if(!(country.isBlank() || country.isEmpty())) {
			filteredList = list.stream().filter(dataItem -> dataItem.getCountry().equals(country)).toList();
		} else {
			filteredList = list.stream().filter(dataItem -> dataItem.getCountry().equals("all")).toList();
		}
		
		return filteredList;
	}
	
	public List<DataItem> filterListByCommodity(List<DataItem> list, String commodity){
		List<DataItem> filteredList = new ArrayList<>();
		
		if(!(commodity.isBlank() || commodity.isEmpty())) {
			filteredList = list.stream().filter(dataItem -> dataItem.getCommodity().equals(commodity)).toList();
		} else {
			filteredList = list.stream().filter(dataItem -> dataItem.getCommodity().equals("all")).toList();
		}
		
		return filteredList;
	}
	
	public List<DataItem> filterListByTransportation(List<DataItem> list, String transportMode){
		List<DataItem> filteredList = new ArrayList<>();
		
		if(!(transportMode.isBlank() || transportMode.isEmpty())) {
			filteredList = list.stream().filter(dataItem -> dataItem.getTransportMode().equals(transportMode)).toList();
		} else {
			filteredList = list.stream().filter(dataItem -> dataItem.getTransportMode().equals("all")).toList();			
		}
		
		return filteredList;
	}

	public List<DataItem> filterListByMeasure(List<DataItem> list, String measure){
		List<DataItem> filteredList = new ArrayList<>();
		
		if(!(measure.isBlank() || measure.isEmpty())) {
			filteredList = list.stream().filter(dataItem -> dataItem.getMeasure().equals(measure)).toList();
		} else {
			filteredList = list.stream().filter(dataItem -> dataItem.getMeasure().equals("$")).toList();			
		}
		
		return filteredList;
	}
	
	public List<DataItem> filterListByMonth(List<DataItem> list, int month, int year){
		return list.stream().filter(dataItem -> dataItem.getYear() == year && dataItem.getDate().getMonthValue() == month).toList();
	}
	
	public List<DataItem> filterListByYear(List<DataItem> list, int year){
		return list.stream().filter(dataItem -> dataItem.getYear() == year).toList();
	}
}
