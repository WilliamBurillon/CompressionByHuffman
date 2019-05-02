import java.util.ArrayList;

class Noeud <E> implements Cloneable{
   
	
	private String lettre;
	private Noeud<E> gauche, droit,pere;
	private int val;
   
   
   public Noeud (){ 
      lettre = null;
      val=0;
      gauche = null;
      droit = null;
      pere = null;
   }
   
      //Constructor for leafs, with the letters
   public Noeud (String lettre,int val){
	   this.lettre=lettre;
	   this.val=val;
	   
	   gauche = null;
	   droit = null;
	   pere = null;
	   
   }

   
   //constructor for node with character
   public Noeud ( int val, Noeud<E> g,
                  Noeud<E> d){
      this.val = val;
      this.lettre=null;
      gauche = g;
      droit = d;
      pere=null;
   }
   //method that allow us to clone a Node 
   public Noeud clone() {
	   Noeud node = null;
	   try {
	    	
		   //getting then node instance, and it values but not it adress in memory  
	      	node = (Noeud) super.clone();
	    } catch(CloneNotSupportedException cnse) {
	      	
	      	cnse.printStackTrace(System.err);
	    }
	    
	    return node;
	}
   
// some getters and setters
public String getLettre() {
	return lettre;
}

public Noeud<E> getPere() {
	return pere;
}

public void setPere(Noeud<E> pere) {
	this.pere = pere;
}

public void setLettre(String lettre) {
	this.lettre = lettre;
}

public Noeud<E> getGauche() {
	return gauche;
}

public void setGauche(Noeud<E> gauche) {
	this.gauche = gauche;
}

public Noeud<E> getDroit() {
	return droit;
}

public void setDroit(Noeud<E> droit) {
	this.droit = droit;
}

public int getVal() {
	return val;
}

public void setVal(int val) {
	this.val = val;
}
// some useful function for tree
public boolean isLeaf() {
	boolean res = false;
	if (this.gauche == null && this.droit==null){
		res = true;
	}
	return res;
}

public boolean isFound(String lettre) {
	boolean res = false;
	if (this.isLeaf() && this.lettre.equals(lettre)){
		res= true;
	}
	return res;
}

public boolean isRoot() {
	boolean res = false;
	if (this.pere == null) {
		res = true;
	}
	return res;
}


public ArrayList<Noeud> nodeList(ArrayList<String[]> list){
	
	ArrayList<Noeud> nodeList = new ArrayList<Noeud>();
    
	// Creation des feuilles
	      
	         for (int i =0; i< list.size();i++) {
	        	
	        	Noeud leNode = new Noeud(list.get(i)[0],Integer.parseInt( list.get(i)[1]));
	        	nodeList.add(leNode);
	        		
	        	
	        }
	         return nodeList;
	        		 
}


public String deepPath(String path, String l ) {
	/* the function of this recursibe method is to make a deep path to find the binary code of a char
	 * In : String l 
	 * In - Out : the path, initiate to ""
	 */
	
	
	// this 3 tests is useful for the algorithm to avoid backwards
	if(this.getVal()==-2) {
		return "not found";
	}
	
	if (this.isRoot() && this.val == -1) {
		this.val =-2;
		
	}
	
	if(this.getVal()>=0) {
		
	
	this.setVal(-1);
	}
	//when the char is find, return the path (the binary code of l)
	if (this.isFound(l)) {
		return path;
	}
	
	else {
		//if the actual node has a left child and it has never been wandered, then add 0
		// to the path 
		if (this.gauche != null && this.gauche.getVal()!=-1) {
			return this.gauche.deepPath(path+"0" , l);
		}
		//if the actual node has a right child and it has never been wandered, then add 1
		// to the path 
		else if ( this.droit!= null && this.droit.getVal()!=-1 )
			{
			return this.droit.deepPath(path + "1", l);
		}
		//if the father has ever been wandered, so go to father and delete the last bit from
		//the path 
		else if (this.pere.getVal() == -1 ){
			path = path.substring(0, path.length()-1);
			return this.pere.deepPath(path, l);
		}
		
		else {
			return "not Found";
		}
		
	}
}
}
