package javaExam;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
 
public class pdfExam {
	
	public static void merge(File source, File dest) throws IOException {

		// copy file in folder
		Files.copy(source.toPath(), dest.toPath());
	}
	
  public static void main(String args[]) throws IOException {
	  
	  
    try {
    	for(int i = 0; i <= 100; i++) {
    		Document document = new Document();
    		OutputStream outputStream = new FileOutputStream(new File("C:\\Users\\Lenovo\\eclipse-workspace\\javaExam\\src\\javaExam\\TestFiles\\TestFile" + i + ".pdf"));
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
  //copy method

    Scanner sc = new Scanner(System.in);
    try {
    List<String> matchWords = new ArrayList<>();
    System.out.println("Enter a word to be searched?");
    String searchWord = sc.next();
    for (int counter = 0; counter <= 100; counter++) {
    PdfReader readFile = new PdfReader("C:\\Users\\Lenovo\\eclipse-workspace\\javaExam\\src\\javaExam\\TestFiles\\TestFile" + counter + ".pdf");
    String text = PdfTextExtractor.getTextFromPage(readFile, 1);

    if (text.contains(searchWord)) {
    	matchWords.add("C:\\Users\\Lenovo\\eclipse-workspace\\javaExam\\src\\javaExam\\TestFiles\\TestFile" + counter + ".pdf");
    }
    	readFile.close();
    }

    for (String matchFiles : matchWords) {
    	String fileName = matchFiles.substring(matchFiles.lastIndexOf("\\") + 1);
    	Document document = new Document();
    	OutputStream outputStream = new FileOutputStream(new File("C:\\Users\\Lenovo\\eclipse-workspace\\javaExam\\src\\javaExam\\CopyFiles\\" + fileName));
    	PdfCopy copy = new PdfCopy(document, outputStream);
    	document.open();
    	PdfReader reader = new PdfReader(matchFiles);
    	copy.addDocument(reader);
    	reader.close();
    	document.close();
    	outputStream.close();
    	System.out.println("File(pdf) " + fileName + " has been copied");
    	}

    } catch (Exception e) {

    e.printStackTrace();

    }
    	
  }
}