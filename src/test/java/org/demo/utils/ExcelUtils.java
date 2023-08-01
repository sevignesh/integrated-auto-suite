/**
 ** Author: Esakkivignesh **
 ** Description: Excel utility methods **
 **/

package org.demo.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    public static Object[][] readTestData(String filePath, String sheetName) {
        List<Map<String, String>> testDataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in the Excel file.");
            }

            Row headerRow = sheet.getRow(0);
            int rowCount = sheet.getLastRowNum();

            for (int i = 1; i <= rowCount; i++) {
                Row dataRow = sheet.getRow(i);
                Map<String, String> testDataMap = new HashMap<>();

                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                    Cell headerCell = headerRow.getCell(j);
                    Cell dataCell = dataRow.getCell(j);

                    String key = headerCell.getStringCellValue();
                    String value = getStringCellValue(dataCell);

                    testDataMap.put(key, value);
                }

                testDataList.add(testDataMap);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading Excel file : " + e.getMessage());
        }

        return convertListToArray(testDataList);
    }

    private static String getStringCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue();
    }

    private static Object[][] convertListToArray(List<Map<String, String>> testDataList) {
        Object[][] testDataArray = new Object[testDataList.size()][1];
        for (int i = 0; i < testDataList.size(); i++) {
            testDataArray[i][0] = testDataList.get(i);
        }
        return testDataArray;
    }
}
