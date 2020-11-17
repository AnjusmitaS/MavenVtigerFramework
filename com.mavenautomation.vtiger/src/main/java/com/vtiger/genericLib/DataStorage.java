package com.vtiger.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataStorage 
{
    static FileInputStream fis;
    static Properties p=new Properties();
    
    public String getDataFromProperty(String key) throws IOException
    {
    	fis=new FileInputStream("./src/test/resources/DataContainer/file1.properties");
    	p.load(fis);
    	return p.getProperty(key);
    }
    
    public String getDataFromExcel(String sheetName,int rowNum,int cellNum) 
    		                                            throws Exception, IOException
    {
    	fis=new FileInputStream("./src/test/resources/DataContainer/Book1.xlsx");
    	Workbook book = WorkbookFactory.create(fis);
    	return book.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
    }
    
    public void updateCellDataInExcel(String sheetName,int rowNum,int cellNum,String newData) 
    		                                  throws EncryptedDocumentException, IOException
    {
    	 FileInputStream fis=new FileInputStream("./src/test/resources/DataContainer/Book1.xlsx");
     	 Workbook book = WorkbookFactory.create(fis);
         Cell cell = book.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
         cell.setCellValue(newData);
         
         FileOutputStream fos=new FileOutputStream("./src/test/resources/DataContainer/Book1.xlsx");
            book.write(fos);
            fos.flush();
    }
    
    public void addNewCellDataInExcel(String sheetName,int rowNum,int cellNum,String newData)
    		                               throws EncryptedDocumentException, IOException
    {
   	 FileInputStream fis=new FileInputStream("./src/test/resources/DataContainer/Book1.xlsx");
 	 Workbook book = WorkbookFactory.create(fis);
       Cell cell = book.createSheet(sheetName).createRow(rowNum).createCell(cellNum);
       
       FileOutputStream fos=new FileOutputStream("./src/test/resources/DataContainer/Book1.xlsx");
       book.write(fos);
       fos.flush();
    }
}























