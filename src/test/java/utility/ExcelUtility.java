package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Workbook book;
	public static Sheet sheet;
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static Cell cell;
	public static String TESTDATA_SHEET_PATH = "./src/test/resources/Employees.xlsx";
	public static CellType celltype;

	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		FileInputStream file = null;
		Object[][] data = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
			book = WorkbookFactory.create(file);
			sheet = book.getSheet(sheetName);
			// System.out.println(sheet.getLastRowNum() + "--------" +
			// sheet.getRow(0).getLastCellNum());
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					cell = sheet.getRow(i + 1).getCell(k);
					celltype = cell.getCellType();
					if (celltype.equals(CellType.NUMERIC))
						data[i][k] = cell.getNumericCellValue();
					else if (celltype.equals(CellType.STRING))
						data[i][k] = cell.getStringCellValue();
					// System.out.println(data[i][k]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public static void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
		fi = new FileInputStream(TESTDATA_SHEET_PATH);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(TESTDATA_SHEET_PATH);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	public static void main(String[] args) {
		try {
			Object[][] obj = getTestData("Sheet1");
//			System.out.println(Arrays.deepToString(obj));
			for (Object[] k : obj) {
				for (Object l : k) {
					System.out.print(l + " ");
				}
				System.out.println("");
			}

		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
