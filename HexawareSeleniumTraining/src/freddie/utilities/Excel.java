package freddie.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	// This function will read an Excel file (xlsx) and return the data as a double array
	public static String[][] getXLSX(String filename) {
		String[][] dataTable = null;
		
		try {
			// Create the file input stream to read Excel
			File file = new File(filename);
			FileInputStream xlFile = new FileInputStream(file);
			XSSFWorkbook xlBook = new XSSFWorkbook(xlFile);
			XSSFSheet xlSheet = xlBook.getSheetAt(0);
			
			// Get the number of rows & columns and define the dataTable accordingly
			int numRows = xlSheet.getLastRowNum() + 1;
			int numCols = xlSheet.getRow(0).getLastCellNum();
			dataTable = new String[numRows][numCols];
			System.out.println("There are " + numRows + " test records");
			System.out.println("There are " + numCols + " data fields");
			
			// Iterate through the data
			for (int i=0; i < numRows; i++) {
				XSSFRow xlRow = xlSheet.getRow(i);
				for (int j=0; j < numCols; j++) {
					XSSFCell xlCell = xlRow.getCell(j);
					// Add cell to data structure 
					dataTable[i][j] = xlCell.toString();
				}
			}			
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Could not find file: " + filename);
		} catch (IOException e) {
			System.out.println("ERROR: Could not read file.");
		}
		
		return dataTable;
	}
	
	
	// This function will read an Excel file (xls) and return the data as a double array
	public static String[][] getXLS(String filename) {
		String[][] dataTable = null;
		
		try {
			// Create the file input stream to read Excel
			File file = new File(filename);
			FileInputStream xlFile = new FileInputStream(file);
			HSSFWorkbook xlBook = new HSSFWorkbook(xlFile);
			HSSFSheet xlSheet = xlBook.getSheetAt(0);
			
			// Get the number of rows & columns and define the dataTable accordingly
			int numRows = xlSheet.getLastRowNum() + 1;
			int numCols = xlSheet.getRow(0).getLastCellNum();
			dataTable = new String[numRows][numCols];
			System.out.println("There are " + numRows + " test records");
			System.out.println("There are " + numCols + " data fields");
			
			// Iterate through the data
			for (int i=0; i < numRows; i++) {
				HSSFRow xlRow = xlSheet.getRow(i);
				for (int j=0; j < numCols; j++) {
					HSSFCell xlCell = xlRow.getCell(j);
					// Add cell to data structure 
					dataTable[i][j] = xlCell.toString();
				}
			}			
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Could not find file: " + filename);
		} catch (IOException e) {
			System.out.println("ERROR: Could not read file.");
		}
		
		return dataTable;
	}
	
	// This method takes a HSSFCell value (a field in Excel file) and returns the value in String format
	private static String cellToString(HSSFCell cell) {
			int type = cell.getCellType();
			Object result;
			switch (type) {
				case HSSFCell.CELL_TYPE_NUMERIC: //0
					result = cell.getNumericCellValue();
					break;
				case HSSFCell.CELL_TYPE_STRING: //1
					result = cell.getStringCellValue();
					break;
				case HSSFCell.CELL_TYPE_FORMULA: //2
					throw new RuntimeException("We can't evaluate formulas in Java");
				case HSSFCell.CELL_TYPE_BLANK: //3
					result = "-";
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN: //4
					result = cell.getBooleanCellValue();
					break;
				case HSSFCell.CELL_TYPE_ERROR: //5
					throw new RuntimeException ("This cell has an error");
				default:
					throw new RuntimeException("We don't support this cell type: " + type);
				}
			return result.toString();
		}

}
