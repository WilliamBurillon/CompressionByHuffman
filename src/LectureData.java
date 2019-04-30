import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;



public class LectureData {
	private String fileName;
	
	public LectureData (String fileName) {
		this.fileName=fileName;
	}
	
	public ArrayList<String[]> arrayListValue(){
		
		ArrayList<String[]> al = new ArrayList<String[]>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.fileName));
			String line;
			
			while ((line = br.readLine()) != null) {
			   // process the line.
				
				if(line.equals("")) {
					System.out.println("on est sur un /n");
					String[] nLine = {"\n", br.readLine().substring(1)};
					al.add(nLine);
				}
				else if (line.charAt(0)== ' ') {
					System.out.println("la line" + line);
					String[] laLine = {  " ", line.substring(2)};
					al.add(laLine);
				}
				
				else if (line.length()>1){
					String[] newLine= line.split(" ");
					al.add(newLine);
					
				}
				
				/*else if (line.length()==1) {
					
				}*/
				   
				
			}
			
			br.close();
	        }
	        catch (Exception e){
				System.out.println(e.toString());
				}
		return al;
	}
	public ArrayList<String[]> arrayListValue2(){
			
			ArrayList<String[]> al = new ArrayList<String[]>();
			try {
				BufferedReader br = new BufferedReader(new FileReader(this.fileName));
				String line;
				
				while ((line = br.readLine()) != null) {
				   // process the line.
					if(line.equals("")) {
						String[] nLine = {"\n", br.readLine().substring(3)};
						al.add(nLine);
					}
					else if (line.length()>1){
						String[] newLine= line.split(" : ");
						al.add(newLine);
						
					}
					
				}
				
				br.close();
		        }
		        catch (Exception e){
					System.out.println(e.toString());
					}
			return al;
		}
		
	
	public ArrayList<String[]> dicoText(){
		
		ArrayList<String> lesLettre = new ArrayList<String>();
		ArrayList<Integer> freqs = new ArrayList<Integer>();
		ArrayList<String[]> res = new ArrayList<String[]>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.fileName));
			String line;
			while ((line = br.readLine()) != null) {
				
				if (!lesLettre.contains("\n")) {
					lesLettre.add("\n");
					freqs.add(1);
				}
				else {
					freqs.set(lesLettre.lastIndexOf("\n"), freqs.get(lesLettre.lastIndexOf("\n"))+1);
				}
				
				for (int i =0; i< line.length();i++){
					
					if (!lesLettre.contains(String.valueOf(line.charAt(i)))){
						lesLettre.add(String.valueOf(line.charAt(i)));
						freqs.add(lesLettre.lastIndexOf(String.valueOf(line.charAt(i))),1);
						
					}
					else {
						freqs.set(lesLettre.lastIndexOf(String.valueOf(line.charAt(i))), freqs.get(lesLettre.lastIndexOf(String.valueOf(line.charAt(i))))+1);
					}
				}
				
				
			}
		
		
		br.close();
        }
        catch (Exception e){
			System.out.println(e.toString());
			}
		
		for (int i =0; i < lesLettre.size();i++) {
			String[] a = {lesLettre.get(i),(String.valueOf(freqs.get(i)))};
			res.add(a);
		}
		
		try {
			File file = new File(this.fileName.substring(0, this.fileName.length()-4)+"_Freq.dat");
			//		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), cs));
				   PrintWriter writer1 = new PrintWriter(file);
				   
				   for (int i =0; i<(res.size()-1);i++) {
					   
					   writer1.write(res.get(i)[0]+ " " + res.get(i)[1] + "\n" );
					  // writer1.write("\n");
				   }
				   writer1.write(res.get(res.size()-1)[0]+ " "+ res.get(res.size()-1)[1]);
				   
				   writer1.close();
				   
		} catch  (Exception e){
			System.out.println(e.toString());
			}
		
		return res; 
	}
	
	public void writeInFile(String lettre, String code) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(this.fileName),true));
			
			writer.write(lettre + " : "+ code);
			writer.write("\n");
			writer.close();
		}catch (IOException e)
		{
		e.printStackTrace();
		} 
	}
	
	
}
