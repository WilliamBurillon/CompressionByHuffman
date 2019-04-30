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
		
		private String name;
		private String encodeFile;
		
		public CompressFile(String name, String encodeFile) {
			this.name = name;
			this.encodeFile=encodeFile;
		}
		
		/*public void binFileToArray() {
				ArrayList<Byte> byteArray = new ArrayList<Byte>();
			
			try {
				//BufferedWriter writer = new BufferedWriter(new FileWriter(new File("decodetext.txt"),true));
				BufferedReader br = new BufferedReader(new FileReader(this.name));
				
				
				String line = br.readLine();
				while (line != null) {
					String by = "";
					while (by.length()<7)
						
				}
				
			}catch  (Exception e){
				System.out.println(e.toString());
				}
		}*/
		
		public void encodeFile() {
			
			
			try {
			//	Charset cs = Charset.forName("ASCII");
				File file = new File(encodeFile+"_compressed.txt");
		//		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), cs));
			   PrintWriter writer1 = new PrintWriter(file,"ISO-8859-1");
			//	BufferedWriter writer = new BufferedWriter(new FileWriter(new File("compressedtext.txt"),true));
				BufferedReader br = new BufferedReader(new FileReader(this.name));
				String line = br.readLine();
				String by="";
				for (int i = 0; i<line.length();i++) {
					by = by + line.charAt(i);
					
					if( by.length()==8){
					
						System.out.println("by : " +by);
						int leByte = Integer.parseInt(by,2);
						char leChar = (char)leByte;
						System.out.println(leChar);
						System.out.println(Integer.toBinaryString(leChar));
						writer1.write(leChar);
						by="";
					}
				
					
				}
				if (by.length()>0 && by.length()<8)	{
					System.out.println("oker");
					String res3=by;
					while (res3.length()<8) {
						res3 =   res3 + "0";
					}
					System.out.println(res3);
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
