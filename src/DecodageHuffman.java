import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class DecodageHuffman {
		
		/* this class is useful to decode the binary String */
		private String leDico;
		private String leFichierBinaire;
		
		public DecodageHuffman (String leDico, String leBin) {
			this.leDico=leDico;
			this.leFichierBinaire = leBin;
			
		}
		
		
		public void decode() {
			/* reading the the dictionary with the binary code of each char
			 * In : .dat file which represents the dictionnary
			 * 		String which reprensents the binary code
			 * Out : the decoded file 
			 */
			LectureData lectDic = new LectureData(this.leDico);
			ArrayList<String[]> dicToArray = lectDic.arrayListValue2();
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(new File("decodetext.txt"),true));
				
				String line= leFichierBinaire;
				System.out.println(line);
			//	
					String car = "";
					// read the String bit by bit and add it to car
					for (int i =0; i < line.length();i++) {
						 car = car +  String.valueOf(line.charAt(i));
						// if the bit code is in the dictionary, so get the char related to it
						for (int j = 0 ; j<dicToArray.size();j++) {
							if (car.equals(dicToArray.get(j)[1])){
								writer.write(dicToArray.get(j)[0]);
								car = "";
								
							}
								
							}
						}
					
					if (line!=null) {
						writer.write("\n");
					}
				
				writer.close();
				
				}catch  (Exception e){
					System.out.println(e.toString());
					}
		}
}
