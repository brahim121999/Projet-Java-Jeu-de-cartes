package CodePrincipal;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
	private Jeu jeu;
	private static int nb = 0;
	private int id_joueur;
	private String nom;
	private boolean poste; 				//0 : gardien, 1 : joueur de champ
	private List<Integer> liste_equipe;
	private List<Integer> liste_score;	//Liste des scores du joueur par semaine, de la semaine 0 a la semaine actuelle
	
	public Joueur(Jeu jeu, String nom, boolean poste, List<Integer> liste_equipe) {
		this.jeu = jeu;
		this.nom = nom;
		this.poste = poste;
		this.liste_equipe = liste_equipe;
		this.liste_score = new ArrayList<Integer>();
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
	
	public int getId_joueur() {
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
	
	public List<Integer> getListeScore() {
		return this.liste_score;
	}
	
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
	
	public void calculScoreHebdo() {
		// a  completer
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
