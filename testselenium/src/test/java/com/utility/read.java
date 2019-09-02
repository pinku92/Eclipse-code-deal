package com.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.retirement.retElements;
import com.retirement.retirementhomeMethod;

public class read extends retirementhomeMethod {
	public static int rwct = 0;
	String FirstNam;

	public String InputData(int rowNum, int colNum, String sheetName)
			throws EncryptedDocumentException, InvalidFormatException {
		try {
			FileInputStream f = new FileInputStream("C:/Users/PinkuJacob.C/Desktop/testdata.xlsx");
			Workbook wb = WorkbookFactory.create(f);
			Sheet s = wb.getSheet(sheetName);
			rwct = s.getLastRowNum();
			Row row = s.getRow(rowNum);
			Cell cel = row.getCell(colNum);
			this.setFirstNam(((org.apache.poi.ss.usermodel.Cell) cel).getStringCellValue());
			FirstNam = ((org.apache.poi.ss.usermodel.Cell) cel).getStringCellValue();
		} catch (IOException e) {
			System.out.println("File is empty");
		}
		return FirstNam;
	}

	public String getFirstName() {
		return FirstNam;

	}

	public void setFirstNam(String firstNam) {
		FirstNam = firstNam;
	}
}
