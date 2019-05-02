import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;


public class Codage {
	
	
	/*the function of this class is to encoding a text File to a binary File (String)*/	
	
	private String fileName;
	
	public Codage (String  fileName) {
		
		this.fileName = fileName;
	}

	
	public void code(File textACoder, ArrayList<String[]> dico) {
		/*Method to encode the current text file into a binary File
		 * In : the text File
		 * 		a binary dictionary
		 * Out : A binary File
		 */
		try {
			
			BufferedReader br1 = new BufferedReader(new FileReader(textACoder));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(this.fileName + ".dat"),true));
			String line;
			
			while ((line = br1.readLine())!=null) {
				
				for (int i =0; i < line.length();i++) {
				//for each line, getting char by char, cast it into a String and 
				//research is binary code into the dictionary 
					String car = String.valueOf(line.charAt(i));
					for (int j = 0; j< dico.size();j++) {
						// if the car is find in the dictionary, write the it binary code 
						if (dico.get(j)[0].equals( car)){
							writer.write(dico.get(j)[1]);	
						}
					}
				}
				writer.write(dico.get(0)[1]);
			}
			writer.close();
			br1.close();
		
		}catch (IOException e)
		{
		e.printStackTrace();
		} 
	}
}
