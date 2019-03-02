package hashcode2019;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileService {
	public static List<String> fileReader(String path) {
		try {
			return Files.readAllLines(Paths.get(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void fileWriter(String path, Slideshow sh) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.write(sh.getSlides().size() + "\n");
			for(Slide slide : sh.getSlides()) {
				writer.write(slide.getId() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
