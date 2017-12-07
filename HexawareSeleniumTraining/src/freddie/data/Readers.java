package freddie.data;

import java.util.List;

import freddie.utilities.CSV;
import freddie.utilities.Database;

public class Readers {

	public static void main(String[] args) {
		readCSV();
	}
	
	private static void readCSV() {
		System.out.println("Reading CSV");
		
		String filename = "C:\\HexawareTraining\\Cohort101\\TestData\\LoginData.txt";
		List<String[]> loginData = CSV.get(filename);
		
		for (String[] record : loginData) {
			System.out.println("EMAIL: " + record[0] + "  PASSWORD: " + record[1]);
		}
	}
	
	
	private static void readDB() {
		String[][] dataTable = Database.get("MortgageLoanTestData");
		
		for (int i = 0; i < dataTable.length; i++) {
			for (int j = 0; j < dataTable[i].length; j++) {
				System.out.println(dataTable[i][j]);
			}
			
			/*
			for (String field : dataTable[i]) {
				System.out.println(field);
			}
			*/
			System.out.println();
		}
	}

}
