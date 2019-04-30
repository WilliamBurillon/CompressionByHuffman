import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;


public class Codage {
	
	private String fileName;
	
	public Codage (String  fileName) {
		
		this.fileName = fileName;
	}

	
	public void code(File textACoder, ArrayList<String[]> dico) {
		
		try {
			
			BufferedReader br1 = new BufferedReader(new FileReader(textACoder));
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(this.fileName + ".dat"),true));
			//BufferedWriter writer2 = new BufferedWriter(new FileWriter(new File(this.fileName + "_dico.dat"),true));
			String line;
			
			while ((line = br1.readLine())!=null) {
				
				for (int i =0; i < line.length();i++) {
					
					String car = String.valueOf(line.charAt(i));
					//System.out.println(car);
					for (int j = 0; j< dico.size();j++) {
						
						if (dico.get(j)[0].equals( car)){
							writer.write(dico.get(j)[1]);
							
							
						}
					}
					
					
				}
				writer.write(dico.get(0)[1]);
			}
			writer.close();
			br1.close();
		/*	for (int i =0;i<dico.size();i++) {
				writer2.write(dico.get(i)[0] + " "+ dico.get(i)[1]);
				writer2.write("\n");
			}
			writer2.close();*/
		}catch (IOException e)
		{
		e.printStackTrace();
		} 
	}
}
