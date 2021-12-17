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

	@SuppressWarnings("resource")
	@Override
	public void action(Systeme systeme) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		Jeu jeu = systeme.getJeu();
		
		System.out.println("########## Menu ##########");
		System.out.println("Mise a jour hebdomadaire : m");
		System.out.println("Etat du jeu : e");
		System.out.println("Ajouter joueur : j");
		System.out.println("Ajouter carte : c");
		System.out.println("Deconnexion : d");
		System.out.println("##########################");
		
		Administrateur admin = (Administrateur) systeme.getUtilisateur_courant();
		boolean bool = true;
		while(bool) {
			Scanner saisieUtilisateur = new Scanner(System.in);
			String str = saisieUtilisateur.next();
			if (str.equals("m")) {
				admin.miseAjourHebdo();
			}

			else if (str.equals("j")) {
				System.out.println("Entrez le nom du joueur");
				saisieUtilisateur = new Scanner(System.in).useDelimiter("|");
				String nom = saisieUtilisateur.next();
				
				System.out.println("Entrez son poste (g : goal, j : joueur de champ)");
				saisieUtilisateur = new Scanner(System.in);
				String poste = saisieUtilisateur.next();
				boolean poste_bool;
				while (!poste.equals("g") && !poste.equals("j")) {
					System.out.println("Saisie incorrecte ! Entrez son poste (g : goal, j : joueur de champ)");
					poste = saisieUtilisateur.next();
				}
				if (poste.equals("g")) {
					poste_bool = false;
				}
				else poste_bool = true;
				
				jeu.afficherListeEquipe();
				System.out.println("Entrez sa liste d'equipe : (ex : 1/2/3)");
				List<Integer> liste_equipe = new ArrayList<Integer>();
				Scanner scan = new Scanner(System.in);  
				String equipe = scan.next();
				String[] equipe2 = equipe.split("/");
					
				for (String j:equipe2) {
					try {
						Integer k = Integer.valueOf(j);
						liste_equipe.add(k);
					} 
					catch (NumberFormatException e) {
							  
						System.out.println("Saisie incorrecte");
					}
				}
				admin.ajouterJoueur(jeu, nom, poste_bool, liste_equipe);
				System.out.println("Ajout réussi !");
			}
			
			else if (str.equals("c")) {
				System.out.println("Liste des joueurs disponible : ");
				for (Entry<Integer, Joueur> j : jeu.getListeJoueur().entrySet()) {
					j.getValue().afficher();
				}
				System.out.println("Entrez l'id du joueur : ");
				int id_joueur = saisieUtilisateur.nextInt();
				admin.ajouterCarte(id_joueur);
			}
			
			else if (str.equals("e")) {
				jeu.afficher();
			}
			
			else if (str.equals("d")) {
				systeme.setUtilisateur_courant(null);
				EtatSysteme etat = new Connexion();
				systeme.setEtat(etat);
				bool = false;
			}
			else if (str.equals("d")) {
				systeme.setUtilisateur_courant(null);
				EtatSysteme etat = new Connexion();
				systeme.setEtat(etat);
				bool = false;
			}
			else {
				System.out.println("Saisie incorrecte");
			}
			
		}
		
	}

}