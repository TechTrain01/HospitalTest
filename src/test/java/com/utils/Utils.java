package com.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Utils {
	private static final Logger logger = LogManager.getLogger(Utils.class);

	public static void bringToFront(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.focus();");
	}

	public static void writeDataToExcel(List<HospitalData> hospitalList, String fileName) {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook
				.createSheet("PractoTest -" + PropertiesHandler.getProperty("cityFullName") + " " + fileName);

		// Create header row
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Name");
		headerRow.createCell(1).setCellValue("Opening Times");
		headerRow.createCell(2).setCellValue("Ratings");

		// Populate data rows
		int rowNum = 1;
		for (HospitalData hospital : hospitalList) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(hospital.getName());
			row.createCell(1).setCellValue(hospital.getOpeningTimes());
			row.createCell(2).setCellValue(hospital.getRatings());
		}

		try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
			workbook.write(fileOut);
		} catch (IOException e) {
			System.err.println("Error writing to Excel file: " + e.getMessage());
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				System.err.println("Error closing the workbook: " + e.getMessage());
			}
		}
	}

	//Method that adds the names only to an excel file
	public static void writeNamesToExcel(List<String> hospitalList, String fileName) {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("PractoTest - " + fileName);

		// Create header row
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Top Cities");

		int rowNum = 1;
		for (String city : hospitalList) {
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

}
