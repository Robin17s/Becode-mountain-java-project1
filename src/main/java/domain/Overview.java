package domain;

import java.util.ArrayList;
import java.util.List;

public class Overview {

	public Overview() {
		
	}
	
	public void giveOverview(DataRepository rep) {
		List<DataItem> list = rep.getDataList();
		
		printAllPossibleYears(list);
		printAllPossibleCountries(list);
		printAllPossibleCommodities(list);
		printAllPossibleTransportation(list);
		printAllPossibleMeasures(list);
	}
	
	public void printAllPossibleYears(List<DataItem> list) {
		List<Integer> years = new ArrayList<>();
		
		System.out.println("All years from the dataset:");
		
		for(DataItem data : list) {
			if(!years.contains(data.getYear())) {
				years.add(data.getYear());
			}
		}
		
		for(int year : years) {
			System.out.println(year);
		}
		
		System.out.println();
	}
	
	public void printAllPossibleCountries(List<DataItem> list) {
		List<String> countries = new ArrayList<>();
		
		System.out.println("All countries from the dataset:");
		
		for(DataItem data : list) {
			if(!countries.contains(data.getCountry())) {
				countries.add(data.getCountry());
			}
		}
		
		for(String country : countries) {
			System.out.println(country);
		}
		
		System.out.println();
	}
	
	public void printAllPossibleCommodities(List<DataItem> list) {
		List<String> commodities = new ArrayList<>();
		
		System.out.println("All commodities from the dataset:");
		
		for(DataItem data : list) {
			if(!commodities.contains(data.getCommodity())) {
				commodities.add(data.getCommodity());
			}
		}
		
		for(String commodity : commodities) {
			System.out.println(commodity);
		}
		
		System.out.println();
	}
	
	public void printAllPossibleTransportation(List<DataItem> list) {
		List<String> transportations = new ArrayList<>();
		
		System.out.println("All transportation methods from the dataset:");
		
		for(DataItem data : list) {
			if(!transportations.contains(data.getTransportMode())) {
				transportations.add(data.getTransportMode());
			}
		}
		
		for(String transport : transportations) {
			System.out.println(transport);
		}
		
		System.out.println();
	}
	
	public void printAllPossibleMeasures(List<DataItem> list) {
		List<String> measures = new ArrayList<>();
		
		System.out.println("All measures from the dataset:");
		
		for(DataItem data : list) {
			if(!measures.contains(data.getMeasure())) {
				measures.add(data.getMeasure());
			}
		}
		for(String measure : measures) {
			System.out.println(measure);
		}
		
		System.out.println();
	}
}
