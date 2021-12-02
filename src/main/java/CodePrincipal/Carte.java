package CodePrincipal;
import enumeration.rarete;


public class Carte extends CarteInterface{
	
	private static Integer nb=0;
	private Integer id_carte;
	private Jeu jeu;
	private Integer id_joueur;
	private boolean disponibilite;
	private Integer id_capacite;
	private Integer id_utilisateur;
	private rarete Rarete;
	
	public Carte(Integer id_joueur, rarete Rarete, Integer id_capacite, Jeu jeu) {
		
		this.id_carte=nb;
		Carte.nb+=1;
		this.disponibilite=true;
		this.id_joueur=id_joueur;
		this.Rarete=Rarete;
		this.id_capacite=id_capacite;
		this.jeu=jeu;
		this.id_utilisateur=0;
	}
	
	public void ajouterCarte() {
		jeu.getListeCarte().put(id_carte, this);
		jeu.getListeCarteSysteme().put(id_carte, this);
	}
	
	/*===============================================================================================*/
	/*======================================= GETTER / SETTER =======================================*/
	/*===============================================================================================*/
	public Jeu getJeu() {
		return this.jeu;
	}
	
	public Integer getIdCarte() {
		return this.id_carte;
	}
	
	public Integer getIdJoueur() {
		return this.id_joueur;
	}
	
	public boolean getDisponibilite() {
		return this.disponibilite;
	}
	
	public void setDisponibilite(boolean x) {
		this.disponibilite=x;
	}
	
	public rarete getRarete() {
		return this.Rarete;
	}
	
	public Integer getCapacite() {
		return this.id_capacite;
	}
	
	public Integer getIdUtilisateur() {
		return this.id_utilisateur;
	}
	
	public void setIdUtilisateur(Integer id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
	
	public double calculScore(Classement classement) {
		return 0;
	}
}


