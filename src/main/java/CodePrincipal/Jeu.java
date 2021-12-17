package CodePrincipal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CapaciteSpeciale.Capacite_speciale;
import enumeration.rarete;

public class Jeu {
	private Integer semaine;
	private Map<Integer, Administrateur> liste_admin;	//Couple id / objet
	private Map<Integer, Player> liste_player;	//Couple id / objet
	private Map<Integer, Equipe> liste_equipe;
	private Map<Integer, Joueur> liste_joueur;
	private Map<Integer, Carte> liste_carte;			//Liste des cartes implementees dans le jeu
	private Map<Integer, Carte> liste_en_vente;			//Liste des cartes en ventes
	private Map<Integer, Echange> liste_echange;		//Liste des cartes proposees en echange
	private Map<Integer, Carte> liste_carte_systeme;	//Liste des cartes n'appartenant a aucun joueur
	private Map<Integer, Dataset> liste_dataset;		//Liste des dataset de la semaine courante
	private Map<Integer, Capacite_speciale> liste_capacite_speciale;
	private List<Player> classement;					//Classement de la semaine courante
	private static Jeu uniqueInstance = new Jeu();
	
	private Jeu() {
		this.semaine = 0;
		this.liste_admin = new HashMap<Integer, Administrateur>();
		this.liste_player = new HashMap<Integer, Player>();
		this.liste_equipe = new HashMap<Integer, Equipe>();
		this.liste_joueur = new HashMap<Integer, Joueur>();
		this.liste_carte = new HashMap<Integer, Carte>();
		this.liste_en_vente = new HashMap<Integer, Carte>();
		this.liste_echange = new HashMap<Integer, Echange>();
		this.liste_carte_systeme = new HashMap<Integer, Carte>();
		this.liste_dataset = new HashMap<Integer, Dataset>();
		this.liste_capacite_speciale = new HashMap<Integer, Capacite_speciale>();
		this.classement = new ArrayList<Player>();
	}
	
	public static Jeu getInstance() {
		return Jeu.uniqueInstance;
	}
	
	/*===============================================================================================*/
	/*======================================= GETTER / SETTER =======================================*/
	/*===============================================================================================*/
	public Integer getSemaine() {
		return this.semaine;
	}
	
	public void setSemaine(Integer semaine) {
		this.semaine = semaine;
	}
	
	public Map<Integer, Administrateur> getListeAdmin() {
		return this.liste_admin;
	}
	
	public void setListeAdmin(Map<Integer, Administrateur> liste_admin) {
		this.liste_admin = liste_admin;
	}
	
	public Map<Integer, Player> getListePlayer() {
		return this.liste_player;
	}
	
	public void setListePlayer(Map<Integer, Player> liste_player) {
		this.liste_player = liste_player;
	}
	
	public Map<Integer, Equipe> getListeEquipe() {
		return this.liste_equipe;
	}
	
	public void setListeEquipe(Map<Integer, Equipe> liste_equipe) {
		this.liste_equipe = liste_equipe;
	}
	
	public Map<Integer, Joueur> getListeJoueur() {
		return this.liste_joueur;
	}
	
	public void setListeJoueur(Map<Integer, Joueur> liste_joueur) {
		this.liste_joueur = liste_joueur;
	}
	
	public Map<Integer, Carte> getListeCarte() {
		return this.liste_carte;
	}
	
	public void setListeCarte(Map<Integer, Carte> liste_carte) {
		this.liste_carte = liste_carte;
	}
	
	public Map<Integer, Carte> getListeEnVente() {
		return this.liste_en_vente;
	}
	
	public void setListeEnVente(Map<Integer, Carte> liste_en_vente) {
		this.liste_en_vente = liste_en_vente;
	}
	
	public Map<Integer, Echange> getListeEchange() {
		return this.liste_echange;
	}
	
	public void setListeCarteEchange(Map<Integer, Echange> liste_echange) {
		this.liste_echange = liste_echange;
	}
	
	public Map<Integer, Carte> getListeCarteSysteme() {
		return this.liste_carte_systeme;
	}
	
	public void setListeCarteSysteme(Map<Integer, Carte> liste_carte_systeme) {
		this.liste_carte_systeme = liste_carte_systeme;
	}
	
	public Map<Integer, Dataset> getListeDataset() {
		return this.liste_dataset;
	}
	
	public void setListeDataset(Map<Integer, Dataset> liste_dataset) {
		this.liste_dataset = liste_dataset;
	}
	
	public Map<Integer, Capacite_speciale> getListeCapaciteSpeciale() {
		return this.liste_capacite_speciale;
	}
	
	public void setListeCapaciteSpeciale(Map<Integer, Capacite_speciale> liste_capacite_speciale) {
		this.liste_capacite_speciale = liste_capacite_speciale;
	}
	
	public List<Player> getClassement() {
		return this.classement;
	}
	
	public void setClassement(List<Player> classement) {
		this.classement = classement;
	}
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/

	public void afficher() {
		System.out.println("=== jeu ===");
		System.out.println("nombre d'utilisateur : " + liste_player.size());
		System.out.println("nombre d'equipes : " + liste_equipe.size());
		System.out.println("nombre de joueur : " + liste_joueur.size());
		System.out.println("nombre de carte : " + liste_carte.size());
		System.out.println("nombre de carte en vente : " + liste_en_vente.size());
		System.out.println("nombre de d'echange : " + liste_echange.size());
		System.out.println("nombre de carte du systeme : " + liste_carte_systeme.size());
		System.out.println("nombre de dataset : " + liste_dataset.size());
		System.out.println("nombre de capacite speciale : " + liste_capacite_speciale.size());
	}
	
	public Capacite_speciale getCapaciteSpeciale(Integer id) {
		return liste_capacite_speciale.get(id);
	}
	
	public Player getUtilisateur(Integer id) {
		return liste_player.get(id);
	}
	
	public Administrateur getAdministrateur(Integer id) {
		return liste_admin.get(id);
	}
	
	public Carte getCarte(Integer id) {
		return liste_carte.get(id);
	}
	
	public Equipe getEquipe(Integer id) {
		return liste_equipe.get(id);
	}
	
	public Joueur getJoueur(Integer id) {
		return liste_joueur.get(id);
	}
	
	public Echange getEchange(Integer id) {
		return liste_echange.get(id);
	}
	
	public void addDataset(Dataset dataset) {
		this.liste_dataset.put(dataset.getId_dataset(), dataset);
	}
	
	public void mettreEnVente(Carte carte) {
		liste_en_vente.put(carte.getIdCarte(), carte);
	}
	
	public void mettreEnEchange(Echange echange) {
		liste_echange.put(echange.getIdEchange(), echange);
	}
	
	public void supprimerDeLaVente(int id_carte) {
		liste_en_vente.remove(id_carte);
	}
	
	public void supprimerDeEchange(int id_echange) {
		liste_echange.remove(id_echange);
	}
	
	public void afficherClassementPlayer() {
		int cpt = 1;
		for (Player mapentry : this.classement) {
			System.out.println(cpt + " position | ID : " + mapentry.getId() + " | pseudo : " + mapentry.getPseudo() + " | score : " + mapentry.getScore());
			cpt+=1;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void chercherCarteDeJoueurAvendre(int id_joueur, rarete rar) {
		//chercher carte en vente selon parametre
        for (Map.Entry mapentry : this.liste_en_vente.entrySet()) {

            Carte c  = (Carte) mapentry.getValue();
            int id1 = c.getIdJoueur();
            
            if (id_joueur == id1 && c.getRarete() == rar) {
                c.afficher();
            }
        }
    }
	
	@SuppressWarnings("rawtypes")
	public void afficherCarteAVendre() {
		//chercher carte en vente
		for(Map.Entry mapentry : this.liste_en_vente.entrySet()) {
			
			Carte c  = (Carte) mapentry.getValue();
			c.afficher();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void afficherListeEquipe() {
		//chercher carte en vente
		for(Map.Entry mapentry : this.liste_equipe.entrySet()) {
			
			Equipe e  = (Equipe) mapentry.getValue();
			System.out.println("equipe id " + e.getId_equipe() + " : " + e.getNom());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void chercherEchange(int id_joueur, rarete rar) {
		//chercher echange selon parametre
        for (Map.Entry mapentry : this.liste_echange.entrySet()) {

        	Echange e = (Echange) mapentry.getValue();
        	Carte c = getCarte(e.getCarteAEchange());
            Integer id_joueur1 = c.getIdJoueur();
            rarete rarete1 = c.getRarete();

            if (id_joueur == id_joueur1 && rar == rarete1) {
                e.afficher();
            }
        }
    }
	
	@SuppressWarnings("rawtypes")
	public void afficherEchange() {
		//chercher echange
		for(Map.Entry mapentry : this.liste_echange.entrySet()) {
			
			Echange e = (Echange) mapentry.getValue();
			e.afficher();
		}
	}
}
