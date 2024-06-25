package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;
import constants.Messages;

public class Excel_Utility {
	
	static FileInputStream file ;
	static XSSFWorkbook book;
	static XSSFSheet sheet;
	
	public static String readStringData(int row ,int column,String sheetname) 
	{
		try {
		String path =Constants.HOME_DIRECTORY+Constants.TEXTDATA_EXCELPATH;	
		file = new FileInputStream(path);	
		book =new XSSFWorkbook(file);
		sheet =book.getSheet(sheetname);
		Row r = sheet.getRow(row);
		Cell c =r.getCell(column);
		return c.getStringCellValue();
		}
		catch(Exception e)
		{
			throw new RuntimeException(Messages.EXCEL_SHEEETNOTFOUND);
		}
	}
	public static String readIntegerData(int row , int column,String sheetname)
	{
		try
		{
		String path =Constants.HOME_DIRECTORY+Constants.TEXTDATA_EXCELPATH;	
		file = new FileInputStream(path);
		book =new XSSFWorkbook(file);
		sheet =book.getSheet(sheetname);
		Row r = sheet.getRow(row);
		Cell c =r.getCell(column);
		int  a = (int) c.getNumericCellValue();
		return String.valueOf(a);
		}
		catch(Exception e)
		{
			throw new RuntimeException(Messages.EXCEL_SHEEETNOTFOUND);
		}
	}
}
