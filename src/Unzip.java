import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Unzip {
		
		/* this class is made to unzip a compressed file*/
	
		public String leFichier;
		
		
		public Unzip(String leFichier) {//,String leRes ) {
			this.leFichier=leFichier;
			
		}
		
		
		public String unzipToString() {
			/* this function return a String which represent the binary code a compressed text
			 * In : the compresssed text
			 *Out : a String of bit 
			 */
				String res = "";
			try {
			
				// read the compressed text in ASCII Iso 8859 1 
				BufferedReader br  = new BufferedReader(
					    new InputStreamReader(new FileInputStream(this.leFichier), "ISO-8859-1"));
				String line ;
				
				while ((line = br.readLine()) != null) {
					//For each line 
					for (int i=0;i<line.length();i++ ) {
						//gettin the char by char 
						char leChar = line.charAt(i);
						// cast it into a String which represents the binary code of the char
						String leRes = Integer.toBinaryString(leChar);
						
						// if the res is not a byte, so complete it with 0 at the begining
						if (leRes.length()<8) {
						String res3=leRes;
						while (res3.length()<8) {
							res3 = "0" + res3;
						}
						res = res+ res3;
						}
						
						else {
							res = res+leRes;		
						}
						}
					}
				br.close();
				}
				
				
			catch  (Exception e){
				System.out.println(e.toString());
				}
			return res;
			
		}
}
