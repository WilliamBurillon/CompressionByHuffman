import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner; 
import java.nio.charset.*;
import java.lang.Math;
public class Main {

	public static void main(String[] args) {
		
		// some Switch(case) used to create a menu and allow the user to zip/unzip a text file

		//instantiate a scanner on the standard-in
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez selectionner un mode :");
		System.out.println("1 -Mode Statique");
		System.out.println("2 - Mode semi-statique");
		int choix = sc.nextInt();
		sc.nextLine();
		switch (choix) {
		case 2 : 
			System.out.println("Vous avez choisi le mode semi-statique");
			System.out.println("Veuillez selectionner une option :");
			System.out.println("1 - Coder un fichier .txt. ");
			System.out.println("2 - Decoder un fichier .dat");
			System.out.print("Votre choix : ");
			int choix2 = sc.nextInt();
			sc.nextLine();
			
			switch (choix2) {
			
			case 1 :
				
				System.out.println("Vous avez choisit de coder un fichier .txt");
				System.out.println("Veuillez rentrer le nom du fichier, sans l'extention .txt");
				System.out.println("Veillez à qu'il soit bien dans le repertoire du projet");
				System.out.println("Nom du fichier:");
				String name = sc.nextLine();
				System.out.println(name);
				CodageHuffman c = new CodageHuffman(name);
				c.leCodage();
				sc.close();
				break;
			case 2 : 
				System.out.println("Vous avez choisit de decoder un fichier .dat utilisant le codage de Huffman ");
				System.out.println("Veuillez rentrer le préfixe du fichier, cad la chaine de caractère avant le '_'");
				System.out.println("Example avec le fichier example_huffCode.dat --> Veuillez rentrer : example");
				String name1 = sc.nextLine();
				Unzip uzp = new Unzip(name1+"_compressed.txt");
				System.out.println("le code du texte en 0 et 1" +uzp.unzipToString());
				System.out.println("compressedText est passer ");
				DecodageHuffman d = new DecodageHuffman(name1+"_dico.dat",uzp.unzipToString());
				d.decode();
				sc.close();
				
				break;
			default :
				System.out.println("veuiller choisir entre 1 et 2 ");
				break;
		
				
			}
			break;
		case 1 :
			System.out.println("Vous avez choisi le mode Statique");
			System.out.println("Veuillez selectionner une option :");
			System.out.println("1 - Coder un fichier .txt à l'aide d'un fichier _Freq.dat");
			System.out.println("2 - Decoder un fichier .dat");
			System.out.print("Votre choix : ");
			int choix3 = sc.nextInt();
			sc.nextLine();
			switch (choix3) {
			case 1 :
				System.out.println("Vous avez choisit de coder un fichier .txt");
				System.out.println("Veuillez rentrer le nom du fichier, sans l'extention .txt");
				System.out.println("Veillez à qu'il soit bien dans le repertoire du projet ");
				System.out.println("Nom du fichier:");
				String name = sc.nextLine();
				System.out.println(name);
				
				
				CodageHuffman c = new CodageHuffman(name,name+"_Freq.dat");
				c.leCodageStatique();
				sc.close();
				break;
			case 2 : 
				System.out.println("Not implemented");
				sc.close();
			}
	
			
		}
		

		
	}
}