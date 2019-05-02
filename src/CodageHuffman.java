import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CodageHuffman {
		private String fileName; 
		private String freq;
		
		public CodageHuffman(String file) {
			this.fileName = file;
		}
		
		public CodageHuffman(String file, String freq) {
			
			this.fileName = file;
			this.freq = freq;
			
		}
		public void leCodage() {
		/* This methode is for the semi-dynamic encoding 
		 * In : the .txt File
		 * Out : Compressed .txt File	
		 */
				
			
				// read the texte file, create an ArrayList<String[]> to store the frequency
				// of the char in the text
		     	LectureData reader2 = new LectureData(this.fileName + ".txt");
		        ArrayList<String[]> test =reader2.dicoText();
		   

		        //Node Creation
		        ArrayList<Noeud> nodeList = new ArrayList<Noeud>();
		        for (int i =0; i< test.size();i++) {
		        	
		        	Noeud leNode = new Noeud(test.get(i)[0],Integer.parseInt( test.get(i)[1]));
		        	nodeList.add(leNode);	
		        }
		        
		       //creation of an empty ArrayList<Noeud>, which will be useful to manipulate
		       // the node (to create a value copy of the first ArrayList)
		       ArrayList<Noeud> nodeListExec = new ArrayList<Noeud>();
		       
		      
		       
		       // the function of this part is to create a file where the binary code of 
		       //each character will be storage
		       HuffmanForest hF = new HuffmanForest(nodeListExec);
		       String newFile = this.fileName+"_dico.dat";
		       LectureData newDat = new LectureData(newFile);
		       for (int i = 0; i<test.size();i++) {
		    	   // for each character, we will create a copy of the original nodeList
		    	   nodeListExec.clear();
		    	   for (int j = 0 ; j<nodeList.size();j++) {
		           	nodeListExec.add(nodeList.get(j).clone());
		           }
		    	   
		    	   //create a Huffman Tree
		    	   hF = new HuffmanForest(nodeListExec);
		           while (hF.getForet().size()>1){
		           	hF.remakeForest();
		          
		           }
		           
		           // make a Deep path of this tree to find the binary code related to the current character
		           // and this code will be write in the dictionary file
		           newDat.writeInFile(test.get(i)[0], hF.getForet().get(0).deepPath("", test.get(i)[0]));
		    	   
		    	   
		       }
		       
		       /*Encoding and compressing part :
		        * - create a ArrayList<String[]> for the binary code
		        * -Use the Codage class to encode the file
		        * -Use the CompressFile class to compresss the binary file
		        */
		       LectureData reader1 = new LectureData(this.fileName+"_dico.dat");
		       ArrayList<String[]> dataList2 = reader1.arrayListValue2();
		       File f = new File(this.fileName+".txt");
		       Codage c = new Codage(this.fileName+"_huffCode");
		       c.code(f, dataList2);
		       CompressFile cp = new CompressFile(this.fileName +"_huffCode.dat" ,this.fileName);
		       cp.encodeFile();
		       
		       // Display of the binary code, if it isn't to long 
		       System.out.println("Code relating to the file : " );
		       try {
					BufferedReader br = new BufferedReader(new FileReader(this.fileName+"_huffCode.dat"));
					String line;
					
					while ((line = br.readLine()) != null) {
					   // process the line.
						System.out.println(line);	
					}
					
					br.close();
			        }
			        catch (Exception e){
						System.out.println(e.toString());
						}
		       
		       // Display of the binary dictionary
		       System.out.println("\n");
		       System.out.println("the relating dictionnary : " + "\n");
		       for (int i = 0; i< dataList2.size();i++) {
		    	   System.out.println(dataList2.get(i)[0]+ " : " + dataList2.get(i)[1]);
		       }
		}
		
		public void leCodageStatique() {
			LectureData reader = new LectureData(this.freq);
			ArrayList<String[]> test =reader.arrayListValue();
			System.out.println(test.size());
			/* for (int j=0; j< test.size();j++) {
		    	  System.out.println("la lettre " + test.get(j)[0] + " / la freq : "+ test.get(j)[1]);
		      }
		        */
			//Creation des Noeuds
			ArrayList<Noeud> nodeList = new ArrayList<Noeud>();
	        for (int i =0; i< test.size();i++) {
	        	System.out.println(i);
	        	Noeud leNode = new Noeud(test.get(i)[0],Integer.parseInt( test.get(i)[1]));
	        	nodeList.add(leNode);	
	        }
	        
	        //
	        
	        ArrayList<Noeud> nodeListExec = new ArrayList<Noeud>();
		       
		      /* for (int j = 0 ; j<nodeList.size();j++) {
		         	nodeListExec.add(nodeList.get(j).clone());
		         }*/
		      
		       HuffmanForest hF = new HuffmanForest(nodeListExec);
		       
		       
		       String newFile = this.fileName+"_dico.dat";
		       LectureData newDat = new LectureData(newFile);
		       
		      // marche sauf pour E 
		       //pour tous les elements du tableau de freq, on crée un arbre et on retourne son code de Huffman
		       
		       for (int i = 0; i<test.size();i++) {
		    	   
		    	   nodeListExec.clear();
		    	   for (int j = 0 ; j<nodeList.size();j++) {
		           	nodeListExec.add(nodeList.get(j).clone());
		           }
		    	   
		    	   hF = new HuffmanForest(nodeListExec);
		           while (hF.getForet().size()>1){
		           	hF.remakeForest();
		          // System.out.println(hF.getForet().size());
		           }
		           
		          // ecrit dans le fichier le codage de huffman 
		          // System.out.println(test.get(i)[0] + " : "+  hF.getForet().get(0).deepPath("", test.get(i)[0]));
		           newDat.writeInFile(test.get(i)[0], hF.getForet().get(0).deepPath("", test.get(i)[0]));
		    	   
		    	   
		       }
		       LectureData reader1 = new LectureData(this.fileName+"_dico.dat");
		       // pas de valuer dans dataListe
		       ArrayList<String[]> dataList2 = reader1.arrayListValue2();
		       System.out.println(dataList2.size());
		   
		       File f = new File(this.fileName+".txt");
		       Codage c = new Codage(this.fileName+"_huffCode");
		       c.code(f, dataList2);
		       CompressFile cp = new CompressFile(this.fileName +"_huffCode.dat" ,this.fileName);
		       cp.encodeFile();
		       
		       System.out.println("Code relating to the file : " );
		       try {
					BufferedReader br = new BufferedReader(new FileReader(this.fileName+"_huffCode.dat"));
					String line;
					
					while ((line = br.readLine()) != null) {
					   // process the line.
						System.out.println(line);
						   
						
					}
					
					br.close();
			        }
			        catch (Exception e){
						System.out.println(e.toString());
						}
		       System.out.println("\n");
		       System.out.println("the relating dictionnary : " + "\n");
		       for (int i = 0; i< dataList2.size();i++) {
		    	   System.out.println(dataList2.get(i)[0]+ " : " + dataList2.get(i)[1]);
		       }
		       
		       
		}
}
