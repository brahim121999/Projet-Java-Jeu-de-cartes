package CodePrincipal;

import java.util.List;

public class Joueur {
	private Jeu jeu;
	private static int nb = 0;
	private int id_joueur;
	private String nom;
	private String prenom;
	private boolean poste; 				//0 : gardien, 1 : joueur de champ
	private List<Integer> liste_equipe;
	private List<Integer> liste_score;	//Liste des scores du joueur par semaine, de la semaine 0 à la semaine actuelle
	
	public Joueur(Jeu jeu, String nom, String prenom, boolean poste, List<Integer> liste_equipe, List<Integer> liste_score) {
		this.jeu = jeu;
		this.nom = nom;
		this.prenom = prenom;
		this.poste = poste;
		this.liste_equipe = liste_equipe;
		this.liste_score = liste_score;
		this.id_joueur = Joueur.nb;
		Joueur.nb += 1;
		
		//On ajoute le joueur à la liste des joueurs du jeu
		jeu.getListe_Joueur().add(this);
		
		//On ajoute le joueur à la liste des joueurs de ses équipes
		List<Equipe> equipes = jeu.getListe_equipe();
		for (int i = 0; i < equipes.size(); i++) {
			Equipe equipe = equipes.get(i);
			for (int j = 0; j < liste_equipe.size(); j++) {
				int id_equipe = liste_equipe.get(j);
				if (equipe.getId_equipe() == id_equipe) {
					//On verifie que le joueur n'est pas déjà présent dans la liste des joueurs de l'équipe
					if (!equipe.getListe_joueur().contains(id_joueur)) {
						equipe.getListe_joueur().add(id_joueur);
					}
				}
			}
		}
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
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public boolean getPoste() {
		return this.poste;
	}
	
	public void setPoste(boolean poste) {
		this.poste = poste;
	}
	
	public List<Integer> getListe_equipe() {
		return this.liste_equipe;
	}
	
	public List<Integer> getListe_score() {
		return this.liste_score;
	}
	
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
}
