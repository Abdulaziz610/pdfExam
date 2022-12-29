package javaExam;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
 
public class pdfExam {
	
  public static void main(String args[]) throws IOException {
	  
	  
    try {
    	for(int i = 0; i <= 100; i++) {
    		Document document = new Document();
    		OutputStream outputStream = new FileOutputStream(new File("C:\\Users\\Lenovo\\eclipse-workspace\\javaExam\\src\\javaExam\\TestFile " + i + " .pdf"));
    		PdfWriter.getInstance(document, outputStream);
    		document.open();
    		if(i <= 15) {
    			document.add(new Paragraph("Arabic"));
    			document.add(new Paragraph("English"));
    		}
    		else if(i > 16 && i <= 40) {
    			document.add(new Paragraph("Arabic"));
    			document.add(new Paragraph("English"));
    			document.add(new Paragraph("French"));
    			
    		}
    		else if(i > 40 && i <= 80) {
    			document.add(new Paragraph("Spain"));
    			document.add(new Paragraph("French"));
    		}
    		else {
    			document.add(new Paragraph("German"));
    			document.add(new Paragraph("English"));
    			document.add(new Paragraph("French"));
    			
    		} 
    		document.close();
    		outputStream.close();
    	}
        System.out.println("Pdf Files has been created successfully.");
       } 
    	catch (Exception e) {
    	e.printStackTrace();
    }
    
    Scanner sc = new Scanner(System.in);
    File filePath = new File("C:\\Users\\Lenovo\\eclipse-workspace\\javaExam\\src\\javaExam\\TestFileOutput");
    File fileList[] = filePath.listFiles();
    System.out.println(" Enter a word to be searched ");
    String sWord = sc.next();
    
    	for(File outFile: fileList) {
    		try {
    			PdfReader fileReader = new PdfReader(outFile.getPath());
    		}
    		
    	 	catch (Exception e) {
    	    	e.printStackTrace();
    	    }
    	    
    		
    	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
