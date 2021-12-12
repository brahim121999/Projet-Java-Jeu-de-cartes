package CodePrincipal;

import java.util.List;
import java.util.Map;

public class Joueur {
	private Jeu jeu;
	private static int nb = 0;
	private Integer id_joueur;
	private String nom;
	private boolean poste; 				//0 : gardien, 1 : joueur de champ
	private List<Integer> liste_equipe;
	private Data performance;			// Performance du joueur pour la semaine actuelle
	
	public Joueur(Jeu jeu, String nom, boolean poste, List<Integer> liste_equipe) {
		this.jeu = jeu;
		this.nom = nom;
		this.poste = poste;
		this.liste_equipe = liste_equipe;
		this.performance = new Data();
		this.id_joueur = Joueur.nb;
		Joueur.nb += 1;
	}
	
	/*===============================================================================================*/
	/*======================================= GETTER / SETTER =======================================*/
	/*===============================================================================================*/
	public Jeu getJeu() {
		return this.jeu;
	}
	
	public int getNb() {
		return nb;
	}
	
	public Integer getId_joueur() {
		return this.id_joueur;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public boolean getPoste() {
		return this.poste;
	}
	
	public void setPoste(boolean poste) {
		this.poste = poste;
	}
	
	public List<Integer> getListeEquipe() {
		return this.liste_equipe;
	}
	
	public Data getPerformance() {
		return this.performance;
	}
	
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
	
	@SuppressWarnings("rawtypes")
	public void calculScoreHebdo() {
		this.performance = new Data();
		int cpt = 0;
		
		for(Map.Entry mapentry : jeu.getListeDataset().entrySet()) {
			Dataset dataset = (Dataset) mapentry.getValue();
			
			for(Map.Entry mapentry2 : dataset.getDataset().entrySet()) {
				
				if (this.id_joueur == mapentry2.getKey()) {
					this.performance.addData((Data) mapentry2.getValue());
					cpt += 1;
					System.out.println(cpt);
				}
			}
		}
		if (cpt > 1) {
			this.performance.meanData(cpt);
		}
	}
	
	public void afficher() {
		System.out.println("=== joueur n° : " + id_joueur + " ===");
		System.out.println("nom : " + nom);
		System.out.println("poste : " + poste);
		System.out.println("equipe(s) : ");
		for(Integer e : liste_equipe) {
			System.out.println(jeu.getEquipe(e).getNom());
		}
	}
}
