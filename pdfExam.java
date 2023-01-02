package javaExam;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
 
public class pdfExam {
	
  public static void main(String args[]) throws IOException {
	  
	  
    try {
    	for(int i = 0; i <= 100; i++) {
    		Document document = new Document();
    		OutputStream outputStream = new FileOutputStream(new File("C:\\Users\\Lenovo\\eclipse-workspace\\javaExam\\src\\javaExam\\TestFiles\\TestFile " + i + " .pdf"));
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
    String directory = "C:\\Users\\Lenovo\\eclipse-workspace\\javaExam\\src\\javaExam\\TestFiles";
    System.out.println(" Enter a word to be searched? ");
    	String searchWord = sc.next();
    	File dir = new File(directory);          
    	File[] pdfFiles = dir.listFiles((d, name) -> name.endsWith(".pdf"));

    	for (File pdfFile : pdfFiles) {
    		try {
    			PdfReader reader = new PdfReader(pdfFile.getAbsolutePath());
    			int numPages = reader.getNumberOfPages();
    			boolean found = false;
    			for (int i = 1; i <= numPages; i++) {
    				String pageText = PdfTextExtractor.getTextFromPage(reader, i);
    				if (pageText.toLowerCase().contains(searchWord.toLowerCase())) {
    					found = true;
    					//System.out.println(searchWord);
    		
    					break;
    			}
    		}
 
    			if (found) {
    				System.out.println("Found " + searchWord + " in " + pdfFile.getName());
    			}
    		}
    		catch (Exception e) {
    			e.printStackTrace();
    		}
   
    
    	
    	}
    	
    	
    	
    	
  
    	File file = new File("C:\\\\Users\\\\Lenovo\\\\eclipse-workspace\\\\javaExam\\\\src\\\\javaExam\\\\TestFiles");
    	File dir1 = new File("C:\\Users\\Lenovo\\eclipse-workspace\\javaExam\\src\\javaExam\\CopyFiles"); 
    	try { 
    		
    		Files.copy(file.toPath(), dir1.toPath());
    	}
    	
    	catch (Exception e) {
			e.printStackTrace();
    	}
    
    	
  }
}