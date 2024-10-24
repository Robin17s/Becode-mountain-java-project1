package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.DomainController;

public class UserInterface {
	
	private DomainController dc;
	private Scanner input;
	
	public UserInterface(DomainController dc) {
		this.dc = dc;
		input = new Scanner(System.in);
	}

	public void main() {
		String command = "";
		while(true) {
			System.out.print("Give a command (or type 'stop' if you want to quit):");
			command = input.nextLine();
			
			if(command.toLowerCase().equals("stop")) {
				break;
			}
			
			switch(command.toLowerCase()) {
			case "help" -> executeHelp();
			case "yearly_total" -> executeYearlyTotal();
			case "yearly_average" -> executeYearlyAverage();
			case "monthly_total" -> executeMonthlyTotal();
			case "monthly_average" -> executeMonthlyAverage();
			case "overview" -> dc.giveOverview();
			}
		}
	}
	
	public void executeHelp() {
		System.out.print("Do you want the description of a specific command (leave empty if you want all the descriptions):");
		String specificCommand = input.nextLine();
		
		System.out.print(dc.getHelp(specificCommand));
	}
	
	public void executeYearlyTotal() {
		int year = askForYear();
		
		List<String> temp = new ArrayList<String>();
		temp = askForParameters(temp);
		
		for(int month = 1; month <= 12; month++) {
			System.out.printf("Total of %s/%s: %d%n", month, year, dc.getMonthlyTotal(temp.get(0), temp.get(1), temp.get(2), temp.get(3), month, year));
		}
		
		System.out.printf("Total of complete year %d: %d%n", year, dc.getYearlyTotal(temp.get(0), temp.get(1), temp.get(2), temp.get(3), year));
	}
	
	public void executeYearlyAverage() {
		int year = askForYear();
		
		List<String> temp = new ArrayList<String>();
		temp = askForParameters(temp);
		
		for(int month = 1; month <= 12; month++) {
			System.out.printf("Total of %s/%s: %d%n", month, year, dc.getMonthlyAverage(temp.get(0), temp.get(1), temp.get(2), temp.get(3), month, year));
		}
		
		System.out.printf("Total of complete year %d: %d%n", year, dc.getYearlyAverage(temp.get(0), temp.get(1), temp.get(2), temp.get(3), year));
	}

	public void executeMonthlyTotal() {
		List<Integer> monthAndYear = askForMonthAndYear();
		
		List<String> temp = new ArrayList<String>();
		temp = askForParameters(temp);
		
		System.out.printf("Total of %s/%s: %d%n", monthAndYear.get(0), monthAndYear.get(1), dc.getMonthlyTotal(temp.get(0), temp.get(1), temp.get(2), temp.get(3), monthAndYear.get(0), monthAndYear.get(1)));
	}

	public void executeMonthlyAverage() {
		List<Integer> monthAndYear = askForMonthAndYear();
		
		List<String> temp = new ArrayList<String>();
		temp = askForParameters(temp);
		
		System.out.printf("Total of %s/%s: %d%n", monthAndYear.get(0), monthAndYear.get(1), dc.getMonthlyAverage(temp.get(0), temp.get(1), temp.get(2), temp.get(3), monthAndYear.get(0), monthAndYear.get(1)));
	}
	
	public List<String> askForParameters(List<String> temp){
		System.out.println("What country? (leave empty for all):");
		temp.add(input.nextLine());
		System.out.println("What commodity? (leave empty for all):");
		temp.add(input.nextLine());
		System.out.println("What transport mode? (leave empty for all):");
		temp.add(input.nextLine());
		System.out.println("What measure? (leave empty for all):");
		temp.add(input.nextLine());
		
		return temp;
	}
	
	public int askForYear() {
		System.out.println("What year do you want the data from?");
		int year = Integer.valueOf(input.nextLine());
		
		return year;
	}
	
	public List<Integer> askForMonthAndYear(){
		List<Integer> list = new ArrayList<>();
		
		System.out.println("What month do you want the data from? (1-12)");
		list.add(Integer.valueOf(input.nextLine()));
		
		System.out.println("What year do you want the data from?");
		list.add(Integer.valueOf(input.nextLine()));
		
		return list;
	}
	
}
