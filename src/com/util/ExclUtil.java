package com.util;

 

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExclUtil {

	public static String[][] readExcel(String path) throws BiffException, IOException{
        Workbook rwb = null;
        Cell cell = null;
    
        //����������
        InputStream stream = new FileInputStream(path);
    
        //��ȡExcel�ļ�����
        rwb = Workbook.getWorkbook(stream);
    
        //��ȡ�ļ���ָ�������� Ĭ�ϵĵ�һ��
        Sheet sheet = rwb.getSheet(0);  
        String[][] execl = new String[sheet.getRows()][sheet.getColumns()];
        //����(��ͷ��Ŀ¼����Ҫ����1��ʼ)
        for(int i=0; i<sheet.getRows(); i++){
     
            //����һ������ �����洢ÿһ�е�ֵ
            //String[] str = new String[sheet.getColumns()];
     
            //����
            for(int j=0; j<sheet.getColumns(); j++){
     
                //��ȡ��i�У���j�е�ֵ
                cell = sheet.getCell(j,i);    
               // str[j] = cell.getContents();
                execl[i][j] = cell.getContents();
      
            }
            //�Ѹջ�ȡ���д���list
        }
        return execl;
    }
    
	public static void writeExcel(String[][] excel, String path){
    	  // String[] title = excel[0];
    	         try {   
    	             // ��ÿ�ʼʱ��   
    	             long start = System.currentTimeMillis();   
    	              // ����Excel������   
    	             WritableWorkbook wwb;   
    	              // �½���һ��jxl�ļ�,����d��������testJXL.xls   
    	             OutputStream os = new FileOutputStream(path);   
    	             wwb=Workbook.createWorkbook(os);    
    	             // ��ӵ�һ�����������õ�һ��Sheet������   
    	             WritableSheet sheet = wwb.createSheet("Sheet1", 0);   
    	             Label label;   
    	             for(int i = 0; i < excel.length; i++){   
    	                 // Label(x,y,z) ����Ԫ��ĵ�x+1�У���y+1��, ����z   
    	                 // ��Label������Ӷ�����ָ����Ԫ���λ�ú�����   
    	                // label = new Label(i,0,title[i]); 
    	                 //label = new Label(i, 0, title[i], getHeader());
    	                 // ������õĵ�Ԫ����ӵ���������   
    	                // sheet.addCell(label);   
    	                 for (int j = 0; j < excel[i].length; j++) {
							label = new Label(j, i, excel[i][j]);
							sheet.addCell(label);
						}
    	             }   
    	             // �������������   
    	              /*   
    	               * �������ֵ���Ԫ����Ҫʹ��jxl.write.Number 
    	               * ����ʹ��������·�����������ִ��� 
    	              * */ 
    	            // ����Ʒ���   
    	            // jxl.write.Number number = new jxl.write.Number(0,1,20071001);   
    	            // sheet.addCell(number);   
    	             // ����Ʒ����   
    	             // label = new Label(1,1,"������");   
    	            // sheet.addCell(label);   
    	              /* 
    	             * ���������ʾ���Ĺ�����ʽ 
    	               * jxl���Զ�ʵ���������� 
    	              * ���� 2.456�ᱻ��ʽ��Ϊ2.46,2.454�ᱻ��ʽ��Ϊ2.45 
    	              * */ 
    	            // jxl.write.NumberFormat nf = new jxl.write.NumberFormat("#,###.00");   
    	           //  jxl.write.WritableCellFormat wcf = new jxl.write.WritableCellFormat(nf);   
    	              // ����Ʒ�۸�   
    	            // jxl.write.Number nb = new jxl.write.Number(2,1,200000.45,wcf);   
    	           //  sheet.addCell(nb);   
    	             // ����Ʒ����   
    	            //  jxl.write.Number numb = new jxl.write.Number(3,1,200);   
    	            // sheet.addCell(numb);   
    	             /* 
    	               * ������ʾ���ڵĹ�����ʽ 
    	             * ��:yyyy-MM-dd hh:mm 
    	              * */ 
    	            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
    	           //  String newdate = sdf.format(new Date());   
    	             // ����������   
    	           //  label = new Label(4,1,newdate);   
    	          //   sheet.addCell(label);   
    	             // ������   
    	         //     label = new Label(5,1,"��������");   
    	          //   sheet.addCell(label);   
    	             /* 
    	              * ��ʾ����ֵ 
    	              * */ 
    	          //   jxl.write.Boolean bool = new jxl.write.Boolean(6,1,true);   
    	         //    sheet.addCell(bool);   
    	              /* 
    	              * �ϲ���Ԫ�� 
    	              * ͨ��writablesheet.mergeCells(int x,int y,int m,int n);��ʵ�ֵ� 
    	               * ��ʾ���ӵ�x+1�У�y+1�е�m+1�У�n+1�кϲ� 
    	              *   
    	              * */ 
    	             /*sheet.mergeCells(0,3,2,3);   
    	             label = new Label(0,3,"�ϲ���������Ԫ��");   
    	             sheet.addCell(label);   */
    	             /* 
    	               *   
    	               * ���幫�������ʽ 
    	               * ͨ����ȡһ���������ʽ����Ϊģ�� 
    	              * ����ͨ��web.getSheet(0)��õ�һ��sheet 
    	              * Ȼ��ȡ�õ�һ��sheet�ĵڶ��У���һ��Ҳ����"��Ʒ����"������   
    	             * */ 
    	            /* CellFormat cf = wwb.getSheet(0).getCell(1, 0).getCellFormat();   
    	             WritableCellFormat wc = new WritableCellFormat();   
    	             // ���þ���   
    	              wc.setAlignment(Alignment.CENTRE);   
    	              // ���ñ߿���   
    	            wc.setBorder(Border.ALL, BorderLineStyle.THIN);   
    	             // ���õ�Ԫ��ı�����ɫ   
    	            wc.setBackground(jxl.format.Colour.RED);   
    	             label = new Label(1,5,"����",wc);   
    	            sheet.addCell(label);   
    	  
    	             // ��������   
    	            jxl.write.WritableFont wfont = new jxl.write.WritableFont(WritableFont.createFont("����"),20);   
    	             WritableCellFormat font = new WritableCellFormat(wfont);   
    	             label = new Label(2,6,"����",font);   
    	              sheet.addCell(label);   */
    	                
    	           // д������   
    	            wwb.write();   
    	             // �ر��ļ�   
    	             wwb.close();   
    	            long end = System.currentTimeMillis();   
    	             System.out.println("----��ɸò������õ�ʱ����:"+(end-start)/1000);   
    	         } catch (Exception e) {   
    	             System.out.println("---�����쳣---");   
    	              e.printStackTrace();   
    	        }   
    	 }

}