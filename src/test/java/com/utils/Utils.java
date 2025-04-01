package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {
	private static final Logger logger = LogManager.getLogger(Utils.class);
	
	
	public static void writeDataToExcel(List<String> arrayList, String fileName) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("PractoTest - "+fileName);

        int rowNum = 0;
        for (String city : arrayList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(city);
        }

        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            logger.error("Error writing to Excel file", e);
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                logger.error("Error closing the workbook", e);
            }
        }
    }
	
	
	
	public static Object[][] getExcelData(String filePath, int sheetIndex) throws IOException {
		try (FileInputStream file = new FileInputStream(new File(filePath));
				Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(sheetIndex);
			int rowCount = sheet.getPhysicalNumberOfRows();
			Object[][] data = new Object[rowCount - 1][2];
			for (int i = 1; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				data[i - 1][0] = row.getCell(0).getStringCellValue();
				data[i - 1][1] = row.getCell(1).getStringCellValue();
			}
			return data;
		}
	}

}
