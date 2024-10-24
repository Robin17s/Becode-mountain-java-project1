package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Help {
	
	private HashMap<String, String> commandList;
	private List<String> list;

	public Help() {
		commandList = createCommandList();
		list = createArraylistOfCommands();
	}
	
	public HashMap<String, String> createCommandList(){
		HashMap<String, String> temp = new HashMap<>();
		
		temp.put("help", "Returns a list of available commands with a brief description.");
		temp.put("help <command>", "Provides a full explanation of what the \"\" does and the parameters it requires.");
		temp.put("monthly_total", "Returns the sum of both the export and import for a specified month of a specified year.");
		temp.put("monthly_average", "Returns the average of both the export and import of a specified month of a specified year.");
		temp.put("yearly_total", "Provides an overview of all the monthly totals for a particular year. This command returns the total of each month for both import and export and then gives the yearly total for both import and export.");
		temp.put("yearly_average", "Provides an overview of all the monthly averages for a particular year, for both import and export. Then it gives the yearly average for both import and export.");
		temp.put("overview", "Returns all the unique values that span the data set: years, countries, commodities, transportation modes, and measures.");
		
		return temp;
	}
	
	public ArrayList<String> createArraylistOfCommands(){
		ArrayList<String> temp = new ArrayList<String>();
		
		temp.add("help: Returns a list of available commands with a brief description.");
		temp.add("help <command>: Provides a full explanation of what the \"\" does and the parameters it requires.");
		temp.add("monthly_total: Returns the sum of both the export and import for a specified month of a specified year.");
		temp.add("monthly_average: Returns the average of both the export and import of a specified month of a specified year.");
		temp.add("yearly_total: Provides an overview of all the monthly totals for a particular year. This command returns the total of each month for both import and export and then gives the yearly total for both import and export.");
		temp.add("yearly_average: Provides an overview of all the monthly averages for a particular year, for both import and export. Then it gives the yearly average for both import and export.");
		temp.add("overview: Returns all the unique values that span the data set: years, countries, commodities, transportation modes, and measures.");
		
		return temp;
	}
	
	public String descriptionOfCommand(String command) {
		command = command.toLowerCase();
		command = command.trim();
		
		if(command.isEmpty() || command.isBlank()) {
			String string = "";
			
			for(int i = 0; i < commandList.size(); i++) {
				string += String.format("%s%n%n", list.get(i));
			}
			
			return string;
		} else {
			return commandList.getOrDefault(command, "this command does not exist") + "\n\n";
		}
	}
}
