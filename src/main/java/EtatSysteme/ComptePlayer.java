package EtatSysteme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

import CodePrincipal.Player;
import CodePrincipal.Jeu;
import CodePrincipal.Joueur;
import CodePrincipal.Systeme;
import enumeration.rarete;

public class ComptePlayer extends EtatSysteme{

	@Override
	public void action(Systeme systeme) {
		Jeu jeu = systeme.getJeu();
		
		System.out.println("########## Menu ##########");
		System.out.println("Afficher mes infos : a");
		System.out.println("Afficher le classement des joueurs : c");
		System.out.println("Afficher les cartes en vente : v");
		System.out.println("Afficher les echanges proposes : e");
		System.out.println("Mettre une carte en vente : mv");
		System.out.println("proposer un echange : pe");
		System.out.println("Deconnexion : d");
		System.out.println("##########################");
		
		
		@SuppressWarnings("resource")
		Scanner saisieUtilisateur = new Scanner(System.in);
		Player player = (Player) systeme.getUtilisateur_courant();
		boolean bool = true;
		while(bool) {
			saisieUtilisateur = new Scanner(System.in);
			String str = saisieUtilisateur.next();
			if (str.equals("a")) {
				player.afficher();
			}

			else if (str.equals("c")) {
				System.out.println("Classement des players : ");
				jeu.afficherClassementPlayer();
			}
			
			else if (str.equals("v")) {
				System.out.println("Liste des cartes en vente disponibles : ");
				jeu.afficherCarteAVendre();
			}
			else if (str.contentEquals("e")) {
				System.out.println("Liste des cartes en échange disponibles : ");
				jeu.afficherEchange();
			}
			else if (str.contentEquals("mv")) {
				System.out.println("Veuillez saisir l'id de la carte : ");
				saisieUtilisateur = new Scanner(System.in);
				String id_carte = saisieUtilisateur.next();
				System.out.println("Veuillez saisir le prix de la carte : ");
				saisieUtilisateur = new Scanner(System.in);
				String prix = saisieUtilisateur.next();
				
				try {
					  Integer id_carte2 = Integer.valueOf(id_carte);
					  Integer prix2 = Integer.valueOf(prix);
					  player.ajoutCarteEnVente(id_carte2, prix2);
				} 
				catch (NumberFormatException e) {
					System.out.println("Saisie incorrecte ");
				}
			}
			else if (str.contentEquals("pe")) {
				
				System.out.println("Veuillez saisir l'id de la carte que vous souhaitez mettre en echange : ");
				saisieUtilisateur = new Scanner(System.in);
				String id_carte = saisieUtilisateur.next();
				System.out.println("Pour la rarete veuillez saisir : r , pc ou c");
				saisieUtilisateur = new Scanner(System.in);
				String rarete_attendue = saisieUtilisateur.next();
				System.out.println("Veuillez saisir l'id du joueur souhaité : ");
				saisieUtilisateur = new Scanner(System.in);
				String joueur_attendu = saisieUtilisateur.next();
				
				try {
					Integer id_carte2 = Integer.valueOf(id_carte);
					Integer joueur = Integer.valueOf(joueur_attendu);
					
					if (rarete_attendue.equals("r")) {
						rarete rar = rarete.rare;
						player.ajoutCarteEchange(id_carte2, rar, joueur);
					}
					else if (rarete_attendue.contentEquals("pc")) {
						rarete rar = rarete.peu_commune;
						player.ajoutCarteEchange(id_carte2, rar, joueur);
					}
					else if (rarete_attendue.equals("c")) {
						rarete rar = rarete.rare;
						player.ajoutCarteEchange(id_carte2, rar, joueur);
					}
					else {
						System.out.println("Saisie incoreste");
					}
					
				}
				catch (NumberFormatException e) {
					System.out.println("Saisie incorrecte");
				}
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
