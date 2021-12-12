package CodePrincipal;

import java.util.*;

import enumeration.rarete;

public class Player extends Utilisateur implements Comparable<Player>{
	
	private float balance;
	private ArrayList<Integer> liste_carte;
	private ArrayList<Integer> carte_semaine_suivante;
	public ArrayList<Integer> carte_en_vente;
	public ArrayList<Integer> echange;
	public float score_player;
	private Jeu jeu;
	
	
	public Player(String pseudo, String mdp, Jeu jeu) {
		super(pseudo, mdp);
		this.balance = 10000;
		this.liste_carte= new ArrayList<Integer>();
		this.carte_semaine_suivante = new ArrayList<Integer>(4);
		this.carte_en_vente = new ArrayList<Integer>();
		this.echange = new ArrayList<Integer>();
		this.score_player = 0;
		this.jeu = jeu;
		jeu.getListePlayer().put(this.id_utilisateur, this);
	}
	
	/*===============================================================================================*/
	/*======================================= GETTER / SETTER =======================================*/
	/*===============================================================================================*/
	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String nom) {
		this.pseudo=nom;
	}
	
	public String getMdp() {
		return mdp;
	}
	
	public void setMdp(String password) {
		this.mdp=password;
	}
	
	public Integer getId() {
		return id_utilisateur;
	}
	
	public float getBalance() {
		return this.balance;
	}
	
	public ArrayList<Integer> getListeCarte(){
		return this.liste_carte;
	}
	
	public ArrayList<Integer> getCarteSemaineSuivante() {
		return this.carte_semaine_suivante;
	}
	
	public void setCarteSemaineSuivante(ArrayList<Integer> suivante ) {
		this.carte_semaine_suivante = suivante;
	}
	
	public ArrayList<Integer> getCarteEnVente() {
		return this.carte_en_vente;
	}

	public ArrayList<Integer> getCarteEchange() {
		return this.echange;
	}
	
	public float getScore() {
		return this.score_player;
	}
	
	public void setScore(int score) {
		this.score_player = score;
	}
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
	
	@Override
	public int compareTo(Player player) {
		return (int)(player.getScore() - this.score_player);
	}
	
	// deposer de l'argent
	public void augmenterBalance(float m) {
		this.balance += m;
	}
	
	// retirer de l'argent
	public void diminuerBalance(float m) {
		this.balance -= m  ;
	}
	
	// on ajoute la carte dans la liste des cartes en vente du joueur et dans la liste des cartes en vente du jeu
	public void ajoutCarteEnVente(Integer id_carte, Integer prix) {
		Carte carte = jeu.getCarte(id_carte);
		carte.setPrix(prix);
		
		if(!this.liste_carte.contains(id_carte)) {
			System.out.println("Vous ne possedez pas la carte");
		}
		else if(!carte.getDisponibilite()) {
			System.out.println("La carte a deja ete mise en vente ou proposee en echange");
		}
		else {
			carte.setDisponibilite(false);
			jeu.mettreEnVente(carte);
			this.carte_en_vente.add(id_carte);
			System.out.println("La carte a ete mise en vente avec succes");
		}
	}
	
	// on ajoute la carte dans la liste des cartes a echanger du joueur et dans la liste des cartes a echanger du jeu
	public void ajoutCarteEchange(Integer id_carte, rarete rarete_attendue, Integer joueur_attendu) {
		Carte carte = jeu.getCarte(id_carte);
		
		if(!this.liste_carte.contains(id_carte)) {
			System.out.println("Vous ne possï¿½dez pas la carte");
		}
		else if(!carte.getDisponibilite()) {
			System.out.println("La carte a deja mise en vente ou proposee en echange");
		}
		else {
			carte.setDisponibilite(false);
			Echange echange = new Echange(jeu, id_utilisateur, id_carte, rarete_attendue, joueur_attendu);
			jeu.mettreEnEchange(echange);
			this.echange.add(echange.getIdEchange());
			System.out.println("La carte a ete proposee en echange avec succes");
		}
	}
	
	// on supprime la carte de la liste des cartes en vente du joueur et de la liste des cartes en vente du jeu
	public void supprimeCarteEnVente(Integer id_carte) {
		Carte carte = jeu.getCarte(id_carte);
		
		if(!this.carte_en_vente.contains(id_carte)) {
			System.out.println("La carte n'est actuellement pas en vente");
		}
		else {
			carte.setDisponibilite(true);
			jeu.supprimerDeLaVente(id_carte);
			this.carte_en_vente.remove(id_carte);
			System.out.println("Suppression reussie");
		}
	}
	
	// on supprime la carte de la liste des cartes a echanger du joueur et de la liste des cartes a echanger du jeu
	public void supprimeCarteEchange(Integer id_echange) {
		Echange echange = jeu.getEchange(id_echange);
		
		if(!this.echange.contains(id_echange)) {
			System.out.println("La carte n'est actuellement pas proposee en echange");
		}
		else {
			jeu.getCarte(echange.getCarteAEchange()).setDisponibilite(true);
			jeu.supprimerDeEchange(id_echange);
			this.echange.remove(id_echange);
			System.out.println("Suppression reussie");
		}
	}
	
	// pour initier un echange
	public void echanger(Integer id_echange, Integer id_carte) {
		
		Echange echange = jeu.getEchange(id_echange);
		Carte notre_carte = jeu.getCarte(id_carte);
		Integer id_autre_carte = echange.getCarteAEchange();
		Carte autre_carte = jeu.getCarte(id_autre_carte);
		Integer id_autre_utilisteur = echange.getProprietaire();
		Player autre_utilisateur = (Player) jeu.getUtilisateur(id_autre_utilisteur);
		
		if(notre_carte.getRarete() != echange.getRarete()) {
			System.out.println("La carte que vous souhaitez echanger n'a pas la bonne rarete");
		}
		else if(notre_carte.getIdJoueur() != echange.getJoueurAttendu()) {
			System.out.println("La carte que vous souhaitez echanger n'est pas du bon joueur");
		}
		else if(!jeu.getCarte(id_carte).getDisponibilite()) {
			System.out.println("La carte que vous souhaitez echanger n'est pas disponible");
		}
		else if(notre_carte.getIdUtilisateur() != this.id_utilisateur) {
			System.out.println("Vous ne possedez pas la carte que vous souhaitez echanger");
		}
		else {
			// on ajoute sa carte a nos carte
			autre_carte.setIdUtilisateur(id_utilisateur);
			liste_carte.add(id_autre_carte);
			autre_utilisateur.supprimeCarteEchange(id_echange);
			autre_utilisateur.getListeCarte().remove(id_autre_carte);
			
			// on ajoute notre carte a ses carte
			notre_carte.setIdUtilisateur(id_autre_utilisteur);
			autre_utilisateur.getListeCarte().add(id_carte);
			liste_carte.remove(id_carte);
			notre_carte.setDisponibilite(true);
		}
	}
	
	// pour initier un achat
	public void acheterCarte(Integer id_carte) {

        Carte carte = jeu.getCarte(id_carte);
        Integer id_autre_utilisateur = carte.getIdUtilisateur(); // 0 si possedea par le jeu , n'importe quel autre entier sinon


        if (this.balance < carte.getPrix()) {
            System.out.println("Solde insuffisant");
        }

        else if (id_autre_utilisateur == 0) {

            this.balance -= carte.getPrix();
            this.liste_carte.add(carte.getIdCarte());
            carte.setIdUtilisateur(id_utilisateur);
            this.jeu.getListeEnVente().remove(id_carte);
            this.jeu.getListeCarte().get(carte.getIdCarte()).setDisponibilite(true);
            System.out.println("Achat reussi !");

        }
        else {
            Player autre_utilisateur = (Player) jeu.getUtilisateur(id_autre_utilisateur);
            autre_utilisateur.balance += carte.getPrix();
            this.balance -= carte.getPrix();
            this.liste_carte.add(id_carte);
            autre_utilisateur.supprimeCarteEnVente(id_carte);
            autre_utilisateur.getListeCarte().remove(id_carte);
            carte.setIdUtilisateur(this.getId());
            this.jeu.getListeCarte().get(carte.getIdCarte()).setDisponibilite(true);
            System.out.println("Achat reussi !");

        }
    }
	
	public void calculScoreHebdo() {
		float score = 0;
		for (Integer id_carte : this.carte_semaine_suivante) {
			score += jeu.getCarte(id_carte).calculScore();
		}
		this.score_player = score;
		this.balance += score * 1000;
	}
	
	public void afficher() {
		System.out.println("=== Player n° : " + id_utilisateur + " ===");
		System.out.println("balance : " + balance);
		System.out.println("liste des cartes : " + liste_carte);
		System.out.println("carte semaine suivante : " + carte_semaine_suivante);
		System.out.println("cartes en vente : " + carte_en_vente);
		System.out.println("echanges en attente : " + echange);
	}
	
	public void afficherDetail() {
		System.out.println("=== Player n° : " + id_utilisateur + " ===");
		System.out.println("balance : " + balance);
		System.out.println("liste des cartes : ");
		for (Integer c : liste_carte) {
			jeu.getCarte(c).afficher();
		}
		System.out.println("carte semaine suivante : ");
		for (Integer c : carte_semaine_suivante) {
			jeu.getCarte(c).afficher();
		}
		System.out.println("cartes en vente : ");
		for (Integer c : carte_en_vente) {
			jeu.getCarte(c).afficher();
		}
		System.out.println("echanges en attente : ");
		for (Integer e : echange) {
			jeu.getEchange(e).afficher();
		}
	}
}
