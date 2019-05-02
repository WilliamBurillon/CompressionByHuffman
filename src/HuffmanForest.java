import java.util.ArrayList;
public class HuffmanForest implements Cloneable{
	/* this class represents the huffman tree , or a forest, depending of the current status 
	 * of the ArrayList<Noeud>
	 * */
	
	private ArrayList<Noeud> foret;
	
	public HuffmanForest(ArrayList<Noeud> foret) {
		this.foret = foret;
	}
	@Override
	// metode to clone a ArrayList<Noeud>
	public HuffmanForest clone() throws CloneNotSupportedException {
		return (HuffmanForest) super.clone();
	}
	
	public ArrayList<Noeud> getForet() {
		return foret;
	}

	public void setForet(ArrayList<Noeud> foret) {
		this.foret = foret;
	}

	
	public void remakeForest() {
		/*this function remake The actual forest with the huffman Algo*/
		
		//getting the node with the minimum value
		Noeud resMin = this.foret.get(0);
		for (Noeud n : this.foret) {
			if(n.getVal()<resMin.getVal()) {
				resMin = n;
				
			}
			
		}
		// remove this node from the forest
		this.foret.remove(resMin);
		// getting the seconde node with the minimum value
		Noeud resMax = this.foret.get(0);
		for (Noeud n : this.foret) {
			if(n.getVal()<resMax.getVal()) {
				resMax = n;
				
			}
			
			
		}
		//remove this second node 
		this.foret.remove(resMax);
		//total of this two value 
		int newValue = resMin.getVal() + resMax.getVal();
		//create a new node with this value 
		Noeud nouveauNoeud = new Noeud(newValue, resMax,resMin);
		//this new node will be the father of the 2 last node, and we add it to the forest
		resMax.setPere(nouveauNoeud);
		resMin.setPere(nouveauNoeud);
		this.foret.add(nouveauNoeud);
		
	}

}
