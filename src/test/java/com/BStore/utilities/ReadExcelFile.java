package com.BStore.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile 
{
	public static FileInputStream inputStream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static String getCellValue(String filename, String sheetName, int rowNo, int cellNo)
	{
		try
		{
			//Created an object of FileInputStream to read data from file
			inputStream = new FileInputStream(filename);

			//Excel->worbook->Sheet->row->cell
			//Create object of XSSFworkbook to handle xlsx file
			workBook = new XSSFWorkbook(inputStream);

			//To access worbook sheet
			excelSheet = workBook.getSheet(sheetName);

			cell = workBook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);

			workBook.close();

			return cell.getStringCellValue();
		} 
		catch (Exception e) 
		{
			System.out.println("Issue detected getCellValue method: " + e);
			return "";
		}

	}


	public static int getRowCount(String filename, String sheetName)
	{

		try
		{

			//Created an object of FileInputStream to read data from file
			inputStream = new FileInputStream(filename);

			//Excel->worbook->Sheet->row->cell
			//Create object of XSSFworkbook to handle xlsx file
			workBook = new XSSFWorkbook(inputStream);

			//To access worbook sheet
			excelSheet = workBook.getSheet(sheetName);

			//Get total row count
			int totalRows = excelSheet.getLastRowNum() + 1;

			workBook.close();

			return totalRows;
		} 
		catch (Exception e) 
		{
			System.out.println("Issue detected getRowCount method: " + e);
			return 0;
		}

	}

	public static int getColCount(String filename, String sheetName)
	{
		try 
		{
			//Created an object of FileInputStream to read data from file
			inputStream = new FileInputStream(filename);

			//Excel->worbook->Sheet->row->cell
			//Create object of XSSFworkbook to handle xlsx file
			workBook = new XSSFWorkbook(inputStream);

			//To access worbook sheet
			excelSheet = workBook.getSheet(sheetName);

			//Get total no. of Cell
			int totalCells = excelSheet.getRow(0).getLastCellNum();

			workBook.close();

			return totalCells;
		} 
		catch (Exception e) 
		{
			System.out.println("Issue detected getRowCount method: " + e);
			return 0;
		}
	}


}
