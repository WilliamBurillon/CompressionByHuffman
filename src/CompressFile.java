import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class CompressFile {
		
	
	/* the function of this class is to compress a binary File*/
	
		private String name;
		private String encodeFile;
		
		public CompressFile(String name, String encodeFile) {
			this.name = name;
			this.encodeFile=encodeFile;
		}
		
		
		
		public void encodeFile() {
			/* In : binary File
			 * Out : a compress file in ASCII ISO 8859 1 
			 */
			
			try {
				
				//Creation of a File, will be write in ASCII Iso 8859 1 
				//Creation of a BufferedReader to read the binary file 
				File file = new File(encodeFile+"_compressed.txt");
				PrintWriter writer1 = new PrintWriter(file,"ISO-8859-1");
				BufferedReader br = new BufferedReader(new FileReader(this.name));
				String line = br.readLine();
				String by="";
				for (int i = 0; i<line.length();i++) {
					//read bit by bit
					by = by + line.charAt(i);
					// if there is a byte 
					if( by.length()==8){
						//get it int value and cast it into a char, and write into the file
						int leByte = Integer.parseInt(by,2);
						char leChar = (char)leByte;
						writer1.write(leChar);
						by="";
					}
				
					
				}
				if (by.length()>0 && by.length()<8)	{
					// to the end of the binary file, add some 0 to get a byte
					String res3=by;
					while (res3.length()<8) {
						res3 =   res3 + "0";
					}
					int leByte2 = Integer.parseInt(res3,2);
					char leChar2 = (char) leByte2;
					writer1.write(leChar2);
					
				}
				br.close();
				writer1.close();
			}catch  (Exception e){
				System.out.println(e.toString());
				}
		}
		
}
