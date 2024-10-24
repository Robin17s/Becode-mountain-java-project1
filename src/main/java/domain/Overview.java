package domain;

import java.util.ArrayList;
import java.util.List;

public class Overview {

	public Overview() {
		
	}
	
	public void giveOverview(DataRepository rep) {
		List<DataItem> list = rep.getDataList();
		
		printAllPossibleYears(list);
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
	}
}
