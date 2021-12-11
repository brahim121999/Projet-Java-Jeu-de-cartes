package CodePrincipal;
import enumeration.rarete;


public class Carte extends CarteInterface{
	
	private static int nb=0;
	private Integer id_carte;
	private Jeu jeu;
	private Integer id_joueur;
	private boolean disponibilite;
	private Integer id_utilisateur;
	private rarete rarete;
	private Integer prix;
	
	public Carte(Integer id_joueur, rarete Rarete, Jeu jeu, Integer prix) {
		
		this.id_carte=nb;
		Carte.nb+=1;
		this.disponibilite=true;
		this.id_joueur=id_joueur;
		this.rarete=Rarete;
		this.jeu=jeu;
		this.id_utilisateur=0;
		this.prix=prix;
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
		return this.rarete;
	}
	
	public Integer getIdUtilisateur() {
		return this.id_utilisateur;
	}
	
	public Integer getPrix() {
		return this.prix;
	}
	
	public void setPrix(Integer x) {
		this.prix=x;
	}
	
	public void setIdUtilisateur(Integer id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
	
	public float calculScore() {
		return jeu.getJoueur(this.id_joueur).getPerformance().getNote();
	}
	
	public void afficher() {
		System.out.println("=== carte n° : " + id_carte + " ===");
		System.out.println("id_joueur : " + id_joueur);
		System.out.println("joueur : " + jeu.getJoueur(id_joueur).getNom());
		System.out.println("prix : "+ prix);
		System.out.println("rarete : " + rarete);
		System.out.println("id_utilisateur : " + id_utilisateur);
	}
}


