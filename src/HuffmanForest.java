import java.util.ArrayList;
public class HuffmanForest implements Cloneable{
	private ArrayList<Noeud> foret;
	
	public HuffmanForest(ArrayList<Noeud> foret) {
		this.foret = foret;
	}
	@Override
	
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
		
		Noeud resMin = this.foret.get(0);
		for (Noeud n : this.foret) {
			if(n.getVal()<resMin.getVal()) {
				resMin = n;
				
			}
			
		}
		this.foret.remove(resMin);
		Noeud resMax = this.foret.get(0);
		for (Noeud n : this.foret) {
			if(n.getVal()<resMax.getVal()) {
				resMax = n;
				
			}
			
			
		}
		this.foret.remove(resMax);
		int newValue = resMin.getVal() + resMax.getVal();
		Noeud nouveauNoeud = new Noeud(newValue, resMax,resMin);
		resMax.setPere(nouveauNoeud);
		resMin.setPere(nouveauNoeud);
		this.foret.add(nouveauNoeud);
		
	}

}
