package com.learn.spdemo.service.impl;

import com.learn.spdemo.service.IFileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
@Slf4j
public class FileServiceImpl implements IFileService {

    @Override
    public void getExcleValue(String path) {
        //File f = new File(path);
        InputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            bufferedInputStream =new BufferedInputStream(fileInputStream);
            XSSFWorkbook workbook = new XSSFWorkbook(bufferedInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            for (int i = 0; i <= lastRowNum; i++) {
                XSSFRow row = sheet.getRow(i);
                int lastCol = row.getLastCellNum();
                for (int j = 0; j < lastCol; j++){
                    if (row.getCell(j) != null){
                        if (row.getCell(j).getCellTypeEnum() == CellType.NUMERIC) {
                            log.info(String.valueOf(row.getCell(j).getNumericCellValue()));
                        } else if (row.getCell(j).getCellTypeEnum() == CellType.STRING){
                            log.info(row.getCell(j).getStringCellValue());
                        } else {
                            log.error("---------------------"+row.getCell(j).getCellTypeEnum()+"----------------------");
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
