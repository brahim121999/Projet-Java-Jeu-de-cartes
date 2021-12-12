package CodePrincipal;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.Map.Entry;

import CapaciteSpeciale.Capacite_speciale;
import enumeration.rarete;

public class Administrateur extends Utilisateur {
	
	private Jeu jeu;
	
	public Administrateur(String pseudo, String mdp, Jeu jeu) {
		super(pseudo, mdp);
		this.jeu=jeu;
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
	/*===============================================================================================*/
	/*===============================================================================================*/
	/*===============================================================================================*/
	
	@Override
	public int compareTo(Player player) {return 0;}
	
	public void calculScoreHebdo() {}
	
	public void ajouterCarte(Integer id_joueur) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		int nb_capacite_spe = jeu.getListeCapaciteSpeciale().size();
		
		//creation des cartes communes
		for(int i=0; i<1000; i++) {
			double alea1 = Math.random();
			//2 chances sur 10 d'avoir une capacite speciale
			if(alea1 >= 0.8) {
				Integer alea2 = (int)(Math.random() * nb_capacite_spe);
				rarete rarete = enumeration.rarete.commune;
				Carte carte = new Carte(id_joueur, rarete,this.jeu, 500);
				Capacite_speciale capacite = jeu.getListeCapaciteSpeciale().get(alea2).getClass().getDeclaredConstructor().newInstance();
				capacite.setCarte(carte);
				capacite.ajouterCarte();
			}
			else {
				rarete rarete = enumeration.rarete.commune;
				Carte carte = new Carte(id_joueur, rarete, this.jeu, 500);
				carte.ajouterCarte();
			}
		}
		//creation des cartes peu communes
		for(int i=0; i<100; i++) {
			double alea1 = Math.random();
			//2 chances sur 10 d'avoir une capacite speciale
			if(alea1 >= 0.8) {
				Integer alea2 = (int)(Math.random() * nb_capacite_spe);
				rarete rarete = enumeration.rarete.peu_commune;
				Carte carte = new Carte(id_joueur, rarete, this.jeu, 1000);
				Capacite_speciale capacite = jeu.getListeCapaciteSpeciale().get(alea2).getClass().getDeclaredConstructor().newInstance();
				capacite.setCarte(carte);
				capacite.ajouterCarte();
			}
			else {
				rarete rarete = enumeration.rarete.peu_commune;
				Carte carte = new Carte(id_joueur, rarete, this.jeu, 1000);
				carte.ajouterCarte();
			}
		}
		//creation des cartes rares
		for(int i=0; i<10; i++) {
			double alea1 = Math.random();
			//2 chances sur 10 d'avoir une capacite speciale
			if(alea1 >= 0.8) {
				Integer alea2 = (int)(Math.random() * nb_capacite_spe);
				rarete rarete = enumeration.rarete.rare;
				Carte carte = new Carte(id_joueur, rarete, this.jeu, 2000);
				Capacite_speciale capacite = jeu.getListeCapaciteSpeciale().get(alea2).getClass().getDeclaredConstructor().newInstance();
				capacite.setCarte(carte);
				capacite.ajouterCarte();
			}
			else {
				rarete rarete = enumeration.rarete.rare;
				Carte carte = new Carte(id_joueur, rarete, this.jeu, 2000);
				carte.ajouterCarte();
			}
		}
	}
	
	// pour ajouter un joueur dans le jeu
	public void ajouterJoueur(Jeu jeu, String nom, boolean poste, List<Integer> liste_equipe) {
		Joueur joueur = new Joueur(jeu, nom, poste, liste_equipe);
		
		//On ajoute le joueur a la liste des joueurs du jeu
		jeu.getListeJoueur().put(joueur.getId_joueur(), joueur);
		
		//On ajoute le joueur a la liste des joueurs de ses equipes
		for(Integer e : liste_equipe) {
			jeu.getEquipe(e).addPlayer(joueur.getId_joueur());
		}
	}
	
	// pour ajouter une equipe dans le jeu
	public void ajouterEquipe(Jeu jeu, String nom) {
		Equipe equipe = new Equipe(jeu, nom);
		jeu.getListeEquipe().put(equipe.getId_equipe(), equipe);
	}
	
	public void AddAllCSVToDataset() throws IOException {
		// lis les CSV et en extrait les donnees dans des datasets, puis les ajoute à la liste des datasets de la semaine
		String path = new File("").getAbsolutePath().concat("\\Data\\" + jeu.getSemaine().toString() + "\\");
		File folder = new File(path);
		File[] fichiers = folder.listFiles();
		
		for(File fichier : fichiers) {
            jeu.addDataset(new Dataset(fichier.getAbsolutePath(), this.jeu));
         }
	}
	
	public void CalculPerformancesJoueurs() {
		// actualise les performances des joueurs
		for(Entry<Integer, Joueur> mapentry : jeu.getListeJoueur().entrySet()) {
			mapentry.getValue().calculScoreHebdo();
		}
	}
	
	public void CalculPerformancesPlayers() {
		// actualise les performances des joueurs
		for(Entry<Integer, Player> mapentry : jeu.getListePlayer().entrySet()) {
			mapentry.getValue().calculScoreHebdo();
		}
	}
	
	public void CalculClassement() {
		// on actualise le classement des joueurs
		List<Player> classement = new ArrayList<Player>();
		
		for(Entry<Integer, Player> mapentry : jeu.getListePlayer().entrySet()) {
			classement.add(mapentry.getValue());
		}
		Collections.sort(classement);
		jeu.setClassement(classement);
	}
	
	public void miseAjourHebdo() throws IOException {
		// methode a lancer par l'admin en fin de semaine pour calculer tout les scores des players
		this.jeu.setSemaine(jeu.getSemaine() + 1);
		jeu.setListeDataset(new HashMap<Integer, Dataset>());
		
		AddAllCSVToDataset();
		CalculPerformancesJoueurs();
		CalculPerformancesPlayers();
		CalculClassement();
		
		// on attribue les recompenses aux trois premiers players du classement hebdomadaire
		Integer id_carte_rare = 0;
		Integer id_carte_peu_commune = 0;
		Integer id_carte_commune = 0;
		for(Entry<Integer, Carte> mapentry : jeu.getListeCarteSysteme().entrySet()) {
			if(mapentry.getValue().getRarete() == rarete.rare) {
				id_carte_rare = mapentry.getKey();
				break;
			}
		}
		
		for(Entry<Integer, Carte> mapentry : jeu.getListeCarteSysteme().entrySet()) {
			if(mapentry.getValue().getRarete() == rarete.peu_commune) {
				id_carte_peu_commune = mapentry.getKey();
				break;
			}
		}
		
		for(Entry<Integer, Carte> mapentry : jeu.getListeCarteSysteme().entrySet()) {
			if(mapentry.getValue().getRarete() == rarete.commune) {
				id_carte_commune = mapentry.getKey();
				break;
			}
		}
		
		if(id_carte_rare != 0) {
			jeu.getListeCarteSysteme().remove(id_carte_rare);
			jeu.getClassement().get(0).getListeCarte().add(id_carte_rare);
		}
		
		if(id_carte_peu_commune != 0) {
			jeu.getListeCarteSysteme().remove(id_carte_peu_commune);
			jeu.getClassement().get(0).getListeCarte().add(id_carte_peu_commune);
		}
		
		if(id_carte_commune != 0) {
			jeu.getListeCarteSysteme().remove(id_carte_commune);
			jeu.getClassement().get(0).getListeCarte().add(id_carte_commune);
		}
	}
}
