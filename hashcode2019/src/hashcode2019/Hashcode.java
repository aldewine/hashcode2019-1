package hashcode2019;

import java.util.List;

public class Hashcode {

	public static void main(String[] args) {
		/*
		List<String> fileLines1 = FileService.fileReader("a_example.txt");
		Slideshow slideshow1 = FileManagerService.createSlideshow(fileLines1);
		FileService.fileWriter("output1.out", slideshow1);
		System.out.println("first is done!");
		*/
		
		/*
		List<String> fileLines2 = FileService.fileReader("b_lovely_landscapes.txt");
		System.out.println("second is init!");
		Slideshow slideshow2 = FileManagerService.createSlideshow(fileLines2);
		FileService.fileWriter("output2.out", slideshow2);
		System.out.println("second is done!");
		*/
		
		
		List<String> fileLines3 = FileService.fileReader("c_memorable_moments.txt");
		Slideshow slideshow3 = FileManagerService.createSlideshow(fileLines3);
		FileService.fileWriter("output3.out", slideshow3);
		System.out.println("third is done!");
		
		
		/*
		List<String> fileLines4 = FileService.fileReader("d_pet_pictures.txt");
		Slideshow slideshow4 = FileManagerService.createSlideshow(fileLines4);
		FileService.fileWriter("output4.out", slideshow4);
		System.out.println("fourth is done!");
		*/

		/*
		List<String> fileLines5 = FileService.fileReader("e_shiny_selfies.txt");
		Slideshow slideshow5 = FileManagerService.createSlideshow(fileLines5);
		FileService.fileWriter("output5.out", slideshow5);
		System.out.println("fifth is done!");*/
		
		
	}
}
