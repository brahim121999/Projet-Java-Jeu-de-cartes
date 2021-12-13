package EtatSysteme;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import CodePrincipal.Administrateur;
import CodePrincipal.Jeu;
import CodePrincipal.Joueur;
import CodePrincipal.Systeme;

public class CompteAdministrateur extends EtatSysteme {

	@Override
	public void action(Systeme systeme) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		Jeu jeu = systeme.getJeu();
		
		System.out.println("########## Menu ##########");
		System.out.println("Mise a jour hebdomadaire : m");
		System.out.println("Ajouter joueur : j");
		System.out.println("Ajouter carte : c");
		System.out.println("Deconnexion : d");
		System.out.println("##########################");
		
		@SuppressWarnings("resource")
		Scanner saisieUtilisateur = new Scanner(System.in).useDelimiter("|");
		String str = saisieUtilisateur.next();
		Administrateur admin = (Administrateur) systeme.getUtilisateur_courant();
		boolean bool = true;
		while(bool) {
			if (str.equals("m")) {
				admin.miseAjourHebdo();
			}

			else if (str.equals("j")) {
				System.out.println("Entrez le nom du joueur");
				String nom = saisieUtilisateur.next();
				
				System.out.println("Entrez son poste (g : goal, j : joueur de champ");
				String poste = saisieUtilisateur.next();
				boolean poste_bool;
				while (!poste.equals("g") && !poste.equals("j")) {
					poste = saisieUtilisateur.next();
				}
				if (poste.equals("g")) {
					poste_bool = false;
				}
				else poste_bool = true;
				
				System.out.println("Entrez sa liste d'equipe (ex : 1|2|3|4");
				List<Integer> liste_equipe = new ArrayList<Integer>();
				while (saisieUtilisateur.hasNextInt()) {
					liste_equipe.add(saisieUtilisateur.nextInt());
				}
				admin.ajouterJoueur(jeu, nom, poste_bool, liste_equipe);
			}
			
			else if (str.equals("c")) {
				System.out.println("Liste des joueurs disponible : ");
				for (Entry<Integer, Joueur> j : jeu.getListeJoueur().entrySet()) {
					j.getValue().afficher();
				}
				int id_joueur = saisieUtilisateur.nextInt();
				admin.ajouterCarte(id_joueur);
			}
			
			else if (str.equals("d")) {
				systeme.setUtilisateur_courant(null);
				EtatSysteme etat = new Connexion();
				systeme.setEtat(etat);
				bool = false;
			}
			
		}
		
	}

}