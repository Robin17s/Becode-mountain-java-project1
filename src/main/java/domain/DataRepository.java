package domain;

import java.util.ArrayList;
import java.util.List;

import data.CovidMapper;

public class DataRepository {

	private CovidMapper mapper;
	private List<DataItem> dataList;
	
	public DataRepository() {
		mapper = new CovidMapper();
		dataList = mapper.loadCSVFile();
	}
	
	public List<DataItem> getDataList(){
		return dataList;
	}
}
