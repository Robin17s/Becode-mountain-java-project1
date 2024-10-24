package data;

import java.nio.file.Paths;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;

import domain.DataItem;

public class CovidMapper {

	private final String filePath = "covid_and_trade.csv";
	
	public CovidMapper() {
	}
	
	public ArrayList<DataItem> loadCSVFile() {
		ArrayList<DataItem> temp = new ArrayList<>();
		try (CSVReader fileReader = new CSVReader(new FileReader(filePath))){
			
			fileReader.readNext();
			
			String[] lineArray;
			
			while((lineArray = fileReader.readNext()) != null) {
				if(lineArray.length < 10) {
					throw new IllegalArgumentException("Line does not have enough fields");
				}
				
				DataItem dataItem = new DataItem();
				dataItem.setDirection(lineArray[0]);
				dataItem.setYear(Integer.valueOf(lineArray[1]));
				String[] dateItems = lineArray[2].split("/");
				dataItem.setDate(LocalDate.of(Integer.valueOf(dateItems[2]), Integer.valueOf(dateItems[1]), Integer.valueOf(dateItems[0])));
				dataItem.setWeekday(lineArray[3]);
				dataItem.setCountry(lineArray[4]);
				dataItem.setCommodity(lineArray[5]);
				dataItem.setTransportMode(lineArray[6]);
				dataItem.setMeasure(lineArray[7]);
				dataItem.setValue(Long.valueOf(lineArray[8]));
				dataItem.setCumulative(Long.valueOf(lineArray[9]));
				
				temp.add(dataItem);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error: " + e.getMessage());
		}
		
		return temp;
	}
	
}
