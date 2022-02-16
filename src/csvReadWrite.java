import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;

public class csvReadWrite {

	public static void main(String[] args) throws Exception  
	{  
		String filePath="G:\\Java-eclipse-pro\\Java-Pro\\Fedex_20211029095644(FEDEX).csv";
		readCSV(filePath,1,1,"Nandi",filePath);


}
	public static void readCSV(String csvPath,int row,int col,String newStr,String newFileName) {
		try {
			List<String[]> data = new ArrayList<String[]>();
	        // Create an object of filereader
	        // class with CSV file as a parameter.
	        FileReader filereader = new FileReader(csvPath);
	 
	        // create csvReader object passing
	        // file reader as a parameter
	        @SuppressWarnings("resource")
			CSVReader csvReader = new CSVReader(filereader);
	        String[] nextRecord;
	        String str="";
	        int rowNum=-1;
	        int colNum=-1;
	        StringBuffer sb = null;
	        
	        // we are going to read data line by line
	        while ((nextRecord = csvReader.readNext()) != null) {
	        	rowNum=++rowNum;
	        	colNum=-1;
	        	for (String cell : nextRecord) {
	        		colNum=++colNum;
	        		//System.out.println(row+" "+rowNum+" "+col+" "+colNum);
	        		if(row==rowNum && col==colNum) {
	        			cell=newStr;
	        			//System.out.print(cell + ",");
	        		}
	                 str=str+cell+",";
	                 
	            }
	        	if (str.endsWith(",")) {
	        		str = str.substring(0, str.length() - 1) + "";
	        	}
	        	str=str+"\r\n";
	        }
	        
	        File fout = new File(newFileName);
         	FileOutputStream fos = new FileOutputStream(fout);
         	OutputStreamWriter osw = new OutputStreamWriter(fos);
         		osw.write(str+"\r\n");
         		System.out.print(str+"\r\n");
         	osw.close();
	        
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
