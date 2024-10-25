package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.ConvertingData;
import domain.DataItem;

public class ConvertingDataTest {
	
	private ConvertingData cd;
	private List<DataItem> list;

	@BeforeEach
	public void setUp() throws Exception {
		DataItem item1 = new DataItem();
		DataItem item2 = new DataItem();
		DataItem item3 = new DataItem();
		
		item1.setDirection("Exports");
		item1.setYear(2015);
		item1.setDate(LocalDate.of(2015, 1, 1));
		item1.setWeekday("Thursday");
		item1.setCountry("All");
		item1.setCommodity("All");
		item1.setTransportMode("All");
		item1.setMeasure("$");
		item1.setValue(104000000);
		item1.setCumulative(104000000);
		
		item2.setDirection("Exports");
		item2.setYear(2015);
		item2.setDate(LocalDate.of(2015, 1, 15));
		item2.setWeekday("Thursday");
		item2.setCountry("All");
		item2.setCommodity("All");
		item2.setTransportMode("All");
		item2.setMeasure("$");
		item2.setValue(95000000);
		item2.setCumulative(104000000);
		
		item3.setDirection("Imports");
		item3.setYear(2017);
		item3.setDate(LocalDate.of(2017, 6, 20));
		item3.setWeekday("Monday");
		item3.setCountry("United states");
		item3.setCommodity("Mechanical machinery and equip");
		item3.setTransportMode("Air");
		item3.setMeasure("tonnes");
		item3.setValue(150000000);
		item3.setCumulative(200000000);
		
		list = new ArrayList<>();
		list.add(item1);
		list.add(item2);
		list.add(item3);
		
		cd = new ConvertingData();
	}

	@Test
	public void filterListByYear_2ItemsAreSufficient() {
		assertEquals(2, cd.filterListByYear(list, 2015).size());
	}
	
	@Test
	public void filterListByYear_1ItemsAreSufficient() {
		assertEquals(1, cd.filterListByYear(list, 2017).size());
	}
	
	@Test
	public void filterListByYear_0ItemsAreSufficient() {
		assertEquals(0, cd.filterListByYear(list, 2010).size());
	}
	
	@Test
	public void filterListByMonth_2ItemsAreSufficient() {
		assertEquals(2, cd.filterListByMonth(list, 1, 2015).size());
	}
	
	@Test
	public void filterListByMonth_1ItemsAreSufficient() {
		assertEquals(1, cd.filterListByMonth(list, 6, 2017).size());
	}
	
	@Test
	public void filterListByMonth_0ItemsAreSufficient() {
		assertEquals(0, cd.filterListByMonth(list, 1, 2010).size());
	}
	
	@Test
	public void filterListByCountry_2ItemsAreSufficient() {
		assertEquals(2, cd.filterListByCountry(list, "all").size());
	}
	
	@Test
	public void filterListByCountry_1ItemsAreSufficient() {
		assertEquals(1, cd.filterListByCountry(list, "united states").size());
	}
	
	@Test
	public void filterListByCountry_0ItemsAreSufficient() {
		assertEquals(0, cd.filterListByCountry(list, "china").size());
	}
	
	@Test
	public void filterListByCommodoty_2ItemsAreSufficient() {
		assertEquals(2, cd.filterListByCommodity(list, "all").size());
	}
	
	@Test
	public void filterListByCommodoty_1ItemsAreSufficient() {
		assertEquals(1, cd.filterListByCommodity(list, "mechanical machinery and equip").size());
	}
	
	@Test
	public void filterListByCommodoty_0ItemsAreSufficient() {
		assertEquals(0, cd.filterListByCommodity(list, "food").size());
	}
	
	@Test
	public void filterListByTransportation_2ItemsAreSufficient() {
		assertEquals(2, cd.filterListByTransportation(list, "all").size());
	}
	
	@Test
	public void filterListByTransportation_1ItemsAreSufficient() {
		assertEquals(1, cd.filterListByTransportation(list, "air").size());
	}
	
	@Test
	public void filterListByTransportation_0ItemsAreSufficient() {
		assertEquals(0, cd.filterListByTransportation(list, "sea").size());
	}
	
	@Test
	public void filterListByMeasure_2ItemsAreSufficient() {
		assertEquals(2, cd.filterListByMeasure(list, "$").size());
	}
	
	@Test
	public void filterListByMeasure_1ItemsAreSufficient() {
		assertEquals(1, cd.filterListByMeasure(list, "tonnes").size());
	}
	
	@Test
	public void filterListByMeasure_0ItemsAreSufficient() {
		assertEquals(0, cd.filterListByMeasure(list, "kilo").size());
	}

}
