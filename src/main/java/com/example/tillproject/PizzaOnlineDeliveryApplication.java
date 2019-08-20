package com.example.tillproject;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.asprise.ocr.Ocr;

@SpringBootApplication
@EnableAutoConfiguration
public class PizzaOnlineDeliveryApplication {

	public static void main(String[] args) {
//		Ocr.setUp(); // one time setup
//		Ocr ocr = new Ocr(); // create a new OCR engine
//		ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English
//		//String s = ocr.recognize(new File[] {new File("//Users//durga//Downloads//MTPL - CBIN12704.pdf")}, Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT);
//		String s = ocr.recognize("//Users//durga//Downloads//MTPL - CBIN12704.pdf", -1, -1, -1, -1, -1,
//				   Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT);
//		System.out.println("Result: " + s);
//		// ocr more images here ...
//		ocr.stopEngine();
		SpringApplication.run(PizzaOnlineDeliveryApplication.class, args);
		
		
	}

}
