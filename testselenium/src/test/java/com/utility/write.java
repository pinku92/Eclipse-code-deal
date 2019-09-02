package com.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class write {

	public static void main(String[] args)throws EncryptedDocumentException, InvalidFormatException, IOException
	{	
		
	}
	public void LoginWrite(int x,int y,String Name,String ExcelName)throws EncryptedDocumentException, InvalidFormatException,IOException
	// TODO Auto-generated method stub
	{
	FileInputStream fs=new FileInputStream("C:/Users/PinkuJacob.C/Desktop/testdata.xlsx");
	Workbook wb =WorkbookFactory.create(fs);
	Sheet s=wb.getSheet(ExcelName);
	Row r=s.getRow(x);
	Cell c=r.createCell(y);
	System.out.println("completed3");
	c.setCellType(c.CELL_TYPE_STRING);
	c.setCellValue(Name);
	FileOutputStream fos=new FileOutputStream("C:/Users/PinkuJacob.C/Desktop/testdata");
	wb.write(fos);
	fos.close();
	
	}
	}
