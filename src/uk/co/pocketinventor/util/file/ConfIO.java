package uk.co.pocketinventor.util.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ConfIO {
	
	public ConfIO() {
		// Do Nothing
	}
	
	private static String createPath(String location, String name) {
		if (location.charAt(location.length()-1) != System.getProperty("file.separator").charAt(0)) {
			location+=System.getProperty("file.separator");
		}
		return location + name;
	}
	
	public static boolean create(String location, String name, Property...properties) {
		String fileLocation = createPath(location, name);
		
		if (!new File(location).exists()) {
			System.err.println("Config file location could not be accessed");
			return false;
		}
		
		if (!new File(fileLocation).exists()) {
			try (PrintWriter writer = new PrintWriter(fileLocation, "UTF-8")) {
				String data = "";
				for (Property p : properties) {
					if (p.isComment) {
						data+="#" + p.comment + "\n";
					} else {
						data+= p.name + " = " + p.value + "\n";
					}
				}
				writer.write(data);
				writer.close();
				return true;
			} catch (FileNotFoundException e) {
				System.err.println("Could not write to the selected location");
				return false;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		System.err.println("File already exists. File not created.");
		return false;
	}

	
	public static class Property {
		
		public boolean isComment = false;
		
		public String name, value, comment;
		
		public Property(String comment) {
			this.comment = comment;
			isComment = true;
		}
		
		public Property(String name, String value) {
			this.name = name;
			this.value = value;
		}
		
	}//End Property
	
}//End ConfIO