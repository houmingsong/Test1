package com.lovo.mapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lovo.entity.UserBean;

public class Excle2 {
	
	public static void dbToExcle(List<UserBean> list) throws IOException{
		//����Excle
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		//����Execl��
		XSSFSheet spreadsheet = workbook.createSheet("newsheet");
		
		for(int i=0;i<list.size();i++){
	
			//������
		XSSFRow row=	spreadsheet.createRow(i);
			//������
			row.createCell(0).setCellValue(list.get(i).getUsername());
			row.createCell(1).setCellValue(list.get(i).getPassword());
		}
		
		FileOutputStream out = new FileOutputStream(
			      new File("D:\\poi.xlsx"));
			      workbook.write(out);
			      out.close();
			      System.out.println(
			      "typesofcells.xlsx written successfully");
		
		
	}
}
