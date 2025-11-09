import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileInput {
	
	public FileInput() {
		
		fillLibrary();
		
	}
	
private static void fillLibrary() {
	
	try {
		
		Scanner inputFile = new Scanner(new File("LaptopDetails.csv"));
			
		inputFile.useDelimiter(",");
		
		for(int index = 0; index < LaptopStoreApplication.laptopArray.length; index++) {
			
			System.out.println(index);
			
			String brand = inputFile.next();
			int qualityRating = inputFile.nextInt();
			String model = inputFile.next();
			String type = inputFile.next();
			double price = inputFile.nextDouble();
			String cpuBrand = inputFile.next();
			String cpuType = inputFile.next();
			String cpuModel = inputFile.next();
			double cpuCore = inputFile.nextDouble();
			int speedRating = inputFile.nextInt();
			int ram = inputFile.nextInt();
			int ssd = inputFile.nextInt();
			int memoryRating = inputFile.nextInt();
			String gpuModel = inputFile.next();
			int usbPorts = inputFile.nextInt();
			String operatingSystem = inputFile.next();
			double displaySize = inputFile.nextDouble();
			int resolutionWidth = inputFile.nextInt();
			int resolutionHeight = inputFile.nextInt();
			boolean touchscreen = inputFile.nextBoolean();
			double weight = inputFile.nextDouble();
			String hyperlink = inputFile.next();
			
			LaptopStoreApplication.laptopArray[index] = new Laptop(brand, qualityRating, model, type, price, cpuBrand,
						 cpuType, cpuModel, cpuCore, speedRating, ram, ssd, memoryRating,
						 gpuModel, usbPorts, operatingSystem, displaySize, resolutionWidth,
						 resolutionHeight, touchscreen, weight, hyperlink);
		
		}
		
		inputFile.close();
		
	} catch (FileNotFoundException e) {
	
		System.out.println("File Error");
		
	}
	
}

}
