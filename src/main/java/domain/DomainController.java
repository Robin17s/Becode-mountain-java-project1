package domain;

public class DomainController {

	private DataRepository repository;
	private Help help;
	private ConvertingData convertingData;
	
	public DomainController() {
		repository = new DataRepository();
		help = new Help();
		convertingData = new ConvertingData();
	}
	
	public String getHelp(String command) {
		return help.descriptionOfCommand(command);
	}
	
	public long getMonthlyTotal(String country, String commodity, String transportMode, String measure, int month, int year) {
		return convertingData.getMonthlyTotal(repository, country, commodity, transportMode, measure, month, year);
	}
	
	public double getMonthlyAverage(String country, String commodity, String transportMode, String measure, int month, int year) {
		return convertingData.getMonthlyAverage(repository, country, commodity, transportMode, measure, month, year);
	}
	
	public long getYearlyTotal(String country, String commodity, String transportMode, String measure, int year) {
		return convertingData.getYearlyTotal(repository, country, commodity, transportMode, measure, year);
	}
	
	public double getYearlyAverage(String country, String commodity, String transportMode, String measure, int year) {
		return convertingData.getYearlyAverage(repository, country, commodity, transportMode, measure, year);
	}
}
