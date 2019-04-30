import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class DecodageHuffman {
		private String leDico;
		private String leFichierBinaire;
		
		public DecodageHuffman (String leDico, String leBin) {
			this.leDico=leDico;
			this.leFichierBinaire = leBin;
			
		}
		
		
		public void decode() {
			LectureData lectDic = new LectureData(this.leDico);
			ArrayList<String[]> dicToArray = lectDic.arrayListValue2();
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(new File("decodetext.txt"),true));
				//BufferedReader br = new BufferedReader(new FileReader(this.leFichierBinaire));
				String line= leFichierBinaire;
				System.out.println(line);
			//	while ((line )!=null) {
					String car = "";
					for (int i =0; i < line.length();i++) {
						 car = car +  String.valueOf(line.charAt(i));
						for (int j = 0 ; j<dicToArray.size();j++) {
							if (car.equals(dicToArray.get(j)[1])){
								writer.write(dicToArray.get(j)[0]);
								car = "";
								
							}
								
							}
						}
					//line = br.readLine();
					if (line!=null) {
						writer.write("\n");
					}
					//}
				writer.close();
				//br.close();
				}catch  (Exception e){
					System.out.println(e.toString());
					}
		}
}
