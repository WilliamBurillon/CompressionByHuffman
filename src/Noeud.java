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
   
   // methode pour les feuilles avec la lettre qu'elles représente
   public Noeud (String lettre,int val){
	   this.lettre=lettre;
	   this.val=val;
	   
	   gauche = null;
	   droit = null;
	   pere = null;
	   
}

   //méthode pour les noeuds sans lettre
   public Noeud ( int val, Noeud<E> g,
                  Noeud<E> d){
      this.val = val;
      this.lettre=null;
      gauche = g;
      droit = d;
      pere=null;
   }
  /* 
   public Object clone() throws CloneNotSupportedException{
      // copie en profondeur d’un noeud
      Noeud<E> g = null;
      if( gauche != null ) g = (Noeud<E>)gauche.clone();
      Noeud<E> d = null;
      if( droit != null ) d = (Noeud<E>)droit.clone();
      return new Noeud<E>(element, g, d);
   }
   */
   public Noeud clone() {
	   Noeud node = null;
	   try {
	    	// On récupère l'instance à renvoyer par l'appel de la 
	      	// méthode super.clone()
	      	node = (Noeud) super.clone();
	    } catch(CloneNotSupportedException cnse) {
	      	// Ne devrait jamais arriver car nous implémentons 
	      	// l'interface Cloneable
	      	cnse.printStackTrace(System.err);
	    }
	    
	    // On clone l'attribut de type Patronyme qui n'est pas immuable.
	    //personne.patronyme = (Patronyme) patronyme.clone();
	    
	    // on renvoie le clone
	    return node;
	}
   

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
	//System.out.println(this.lettre);
	//System.out.println(path);
	//Dire qu'on a parcourut le noeud
//	System.out.println(this.isRoot());
	
	
	
	if(this.getVal()==-2) {
		return "not found";
	}
	
	if (this.isRoot() && this.val == -1) {
		this.val =-2;
		
	}
	//System.out.println(this.val);
	if(this.getVal()>=0) {
		
	
	this.setVal(-1);
	}
	if (this.isFound(l)) {
		return path;
	}
	
	else {
		
		if (this.gauche != null && this.gauche.getVal()!=-1) {
			//System.out.println("a un gauche");
			return this.gauche.deepPath(path+"0" , l);
		}
		else if ( this.droit!= null && this.droit.getVal()!=-1 )
			{
			//System.out.println("a pas de gauche");
			return this.droit.deepPath(path + "1", l);
		}
		
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
