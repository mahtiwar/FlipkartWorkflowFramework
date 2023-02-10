package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadXlsData {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ReadXlsData read = new ReadXlsData();
		read.getData("Sheet1");
	}
	public String[][] getData(String excelSheetName) throws FileNotFoundException, IOException {
		File excelReader = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(excelReader);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet("Sheet1");
		
		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		Row rowCells = sheetName.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		System.out.println(totalCols);
		
		DataFormatter format = new DataFormatter();
		String testdata[][]= new String[totalRows][totalCols];
		
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCols;j++) {
				testdata[i-1][j]= format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testdata[i-1][j]);
			}
		}
		return testdata;
		
	}
}
