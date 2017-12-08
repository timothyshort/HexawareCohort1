package freddie.data;

import java.util.List;

import freddie.utilities.CSV;
import freddie.utilities.Database;
import freddie.utilities.Excel;
import freddie.utilities.Playground;

public class Readers {

	public static void main(String[] args) {
		readExcel();
	}
	
	private static void readExcel() {
		System.out.println("Reading Excel");
		
		String filename = "C:\\HexawareTraining\\Cohort101\\TestData\\NewAccountData.xlsx";
		String[][] dataTable = Excel.getXLSX(filename);
		
		for (int i=0; i < dataTable.length; i++) {
			for (int j=0; j < dataTable[0].length; j++) {
				System.out.println(dataTable[i][j]);
			}
		}
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
