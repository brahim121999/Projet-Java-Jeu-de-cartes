package CodePrincipal;

import java.util.Map;

public class Dataset {
	//represente toutes les donnees sur les joueurs pour une semaine
	
	private int semaine;
	private Map<Integer, Data> dataset; //couple id_joueur / Data
	
	public Dataset(int semaine, String path) {
		this.semaine = semaine;
		
		//importation des données
	}
}
