package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utility {
	
	static FileInputStream file ;
	static XSSFWorkbook book;
	static XSSFSheet sheet;
	
	public static String readStringData(int row ,int column,String sheetname) 
	{
		try {
		file = new FileInputStream("C:\\Users\\user\\git\\Qa-Legend\\Qa_Legend\\src\\main\\resources\\TestData.xlsx");
		book =new XSSFWorkbook(file);
		sheet =book.getSheet(sheetname);
		Row r = sheet.getRow(row);
		Cell c =r.getCell(column);
		return c.getStringCellValue();
		}
		catch(Exception e)
		{
			throw new RuntimeException("Excel sheet not found");
		}
	}
	public static String readIntegerData(int row , int column,String sheetname)
	{
		try
		{
		file = new FileInputStream("C:\\Users\\user\\git\\Qa-Legend\\Qa_Legend\\src\\main\\resources\\TestData.xlsx");
		book =new XSSFWorkbook(file);
		sheet =book.getSheet(sheetname);
		Row r = sheet.getRow(row);
		Cell c =r.getCell(column);
		int  a = (int) c.getNumericCellValue();
		return String.valueOf(a);
		}
		catch(Exception e)
		{
			throw new RuntimeException("Excel sheet not found");
		}
	}
}
