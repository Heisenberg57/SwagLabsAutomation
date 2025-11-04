package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {
    private static Workbook workbook;

    // Load Excel file
    public static void loadExcel(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
    }

    // Get data from specific cell
    public static String getCellData(String sheetName, int row, int col) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row r = sheet.getRow(row);
        Cell c = r.getCell(col);

        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(c);
    }

    // Get total rows
    public static int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        return sheet.getPhysicalNumberOfRows();
    }

    // Close workbook
    public static void closeExcel() throws IOException {
        workbook.close();
    }
}
