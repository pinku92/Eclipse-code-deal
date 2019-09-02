package ExcelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static String path;
	public static FileInputStream fis = null;
	public static FileOutputStream fileOut = null;
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	private static XSSFRow row = null;
	private static XSSFCell cell = null;

	public ExcelReader(String path) {
		ExcelReader.path = path;
		try {
			fis = new FileInputStream(path); 
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// returns the row count in a sheet
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}

	}


	public boolean isSheetExist(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			index = workbook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}

	// returns number of columns in a sheet
	public int getColumnCount(String sheetName) {
		// check if sheet exists
		if (!isSheetExist(sheetName))
			return -1;

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);

		if (row == null)
			return -1;

		return row.getLastCellNum();

	}
	
	
	public static void remove( String sheetname) throws IOException {
		
		ExcelReader	xlsreader = new ExcelReader(System.getProperty("user.dir") + "//src//test//java//TestData//Outputs//" + "result.xlsx");
		int RowSize = xlsreader.getRowCount(sheetname);
		System.out.println(RowSize);
		for (int i = 1; i <RowSize; i++) {
			sheet.removeRow(sheet.getRow(i));
		}
		File outWB = new File(System.getProperty("user.dir") + "//src//test//java//TestData//Outputs//" + "result.xlsx");
		OutputStream out = new FileOutputStream(outWB);
		workbook.write(out);
		out.flush();
		out.close();
	}
	public static void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite)
			throws IOException {

		try {
			File file = new File(filePath + "\\" + fileName);
			FileInputStream inputStream = new FileInputStream(file);
//			ZipSecureFile.setMinInflateRatio(0.009);
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int nrow = sheet.getLastRowNum() + 1;
			XSSFRow row = sheet.getRow(nrow);
			if (row == null) {
			//	System.out.println("created new Row");
				row = sheet.createRow(nrow);
			}
			int i1 = 0;
		//	System.out.println("result data length" + s.length);
			for (int i = 0; i < dataToWrite.length; i++) {
				XSSFCell cell = row.getCell(i); 
				if (cell == null) {
				//	System.out.println("created new cell");
					cell = row.createCell(i);
				}
				cell.setCellValue(dataToWrite[i1].toString());
				i1++;
			}
			inputStream.close();
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("data write successfully");
	}

	// returns the data from a cell
	public String getCellData(String sheetName, int colNum, int rowNum) {
		

			int index = workbook.getSheetIndex(sheetName);

			

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum-1);
			
			cell = row.getCell(colNum);
			if (cell == null)
				return "";

			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
					|| cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (DateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR)))
							.substring(2);
					cellText = cal.get(Calendar.MONTH) + 1 + "/"
							+ cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;

					// System.out.println(cellText);

				}
				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
	 {

	 }
			return null;
	}

	
	public static boolean setCellData(String sheetName,String colName,int rowNum, String data){
		try{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);

		if(rowNum<=0)
		return false;

		int index = workbook.getSheetIndex(sheetName);
		int colNum=-1;
		if(index==-1)
		return false;


		sheet = workbook.getSheetAt(index);


		row=sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++){
		//System.out.println(row.getCell(i).getStringCellValue().trim());
		if(row.getCell(i).getStringCellValue().trim().equals(colName))
		colNum=i;
		}
		if(colNum==-1)
		return false;

		sheet.autoSizeColumn(colNum);
		row = sheet.getRow(rowNum-1);
		if (row == null)
		row = sheet.createRow(rowNum-1);

		cell = row.getCell(colNum);
		if (cell == null)
		cell = row.createCell(colNum);

		// cell style
		//CellStyle cs = workbook.createCellStyle();
		//cs.setWrapText(true);
		//cell.setCellStyle(cs);
		cell.setCellValue(data);

		fileOut = new FileOutputStream(path);

		workbook.write(fileOut);

		fileOut.close();

		}
		catch(Exception e){
		e.printStackTrace();
		return false;
		}
		return true;
		}

}
