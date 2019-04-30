import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Unzip {
		public String leFichier;
		//public String leRes;
		
		
		public Unzip(String leFichier) {//,String leRes ) {
			this.leFichier=leFichier;
			//this.leRes=leRes;
		}
		
		
		public String unzipToString() {
				String res = "";
			try {
			
				//BufferedReader br = new BufferedReader(new FileReader(this.leFichier));
				//FileReader fr = new FileReader(this.leFichier);
				BufferedReader br  = new BufferedReader(
					    new InputStreamReader(new FileInputStream(this.leFichier), "ISO-8859-1"));
				String line ;
				
				while ((line = br.readLine()) != null) {
					
					for (int i=0;i<line.length();i++ ) {
						char leChar = line.charAt(i);
						//System.out.println("leChar" +leChar);
						//System.out.println((int)leChar);
						String leRes = Integer.toBinaryString(leChar);
						//System.out.println(leRes);
						if (leRes.length()<8) {
						String res3=leRes;
						while (res3.length()<8) {
							res3 = "0" + res3;
							
							
						}
						res = res+ res3;
						//leRes="";
						
						}
						
						else {
							res = res+leRes;
							//leRes="";
							
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
