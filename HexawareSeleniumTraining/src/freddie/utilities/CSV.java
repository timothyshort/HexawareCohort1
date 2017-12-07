package freddie.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV {
	
	// This function reads a file and returns the data
	public static List<String[]> get(String file) {
		// Define data structure that will hold the data from the file
		List<String[]> data = new ArrayList<String[]>();
		
		try {
			// 1. Open the file
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String row;
			
			// 2. Read the file (continuously until finished)
			while ((row = br.readLine()) != null) {
				// 3. Split CSV into array
				String[] line = row.split(",");
				
				// 4. Add to the data structure
				data.add(line);
			}
			
			// 5. Close the file
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
			System.out.println(file);
		} catch (IOException e) {
			System.out.println("ERROR: Could not read line.");
		}

		return data;
	}	
}