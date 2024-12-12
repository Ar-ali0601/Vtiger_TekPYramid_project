package Comcast.Crm.Generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

    public class ExcelUtility {

	public String getDataFromExcelFile(String sheetName , int rowNum ,int cellNum) throws Throwable, IOException {
		
		FileInputStream file = new FileInputStream("./src/test/resources/TestCaseVTiger.xlsx");
		Workbook wb=WorkbookFactory.create(file);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		
		return data;
	}
	
	public void getRowCount(String sheetName , int rowNum ,int cellNum) throws Throwable{
		
		FileInputStream file = new FileInputStream("./src/test/resources/TestCaseVTiger.xlsx");
		Workbook wb=WorkbookFactory.create(file);
		wb.getSheet(sheetName).getRow(rowNum);
		
		
	}
    public void getCellCount(String sheetName , int rowNum ,int cellNum) throws Throwable{
		
		FileInputStream file = new FileInputStream("./src/test/resources/TestCaseVTiger.xlsx");
		Workbook wb=WorkbookFactory.create(file);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		
		FileOutputStream fos= new FileOutputStream("./src/test/resources/TestCaseVTiger.xlsx");
		wb.write(fos);
		wb.close();
}
		
}
