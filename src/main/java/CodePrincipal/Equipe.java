package CodePrincipal;

import java.util.List;

public class Equipe {
	private Jeu jeu;
	private static int nb = 0;
	private int id_equipe;
	private String nom;
	private List<Integer> liste_joueur;
	
	public Equipe(Jeu jeu, String nom, List<Integer> liste_joueur) {
		this.jeu = jeu;
		this.nom = nom;
		this.liste_joueur = liste_joueur;
		this.id_equipe = nb;
		Equipe.nb += 1;
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
	
	public int getId_equipe() {
		return this.id_equipe;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public List<Integer> getListe_joueur() {
		return this.liste_joueur;
	}
	
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
}
