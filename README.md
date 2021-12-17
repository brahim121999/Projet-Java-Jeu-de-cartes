# 2021 - BOURSAULT BRAHAM - JAVA

Les fichiers des données des matchs doivent être ajoutés dans le dossier "Data", au format csv et dans des dossiers renommés selon le numéro de la semaine des matchs.

Pour lancer le jeu, il suffit d'exécuter le main. Si vous êtes sur linux, il faut changer le chemin dans la méthode calculScorehebdo() en remplaçant les "\\" par des "/" au préalable.

Le jeu contient déjà quelques cartes/joueurs/equipes/capacités spéciales/comptes player/admin.
Pour en ajouter, il suffit de se connecter avec le compte admin et de suivre les instructions fournies par le jeu.

Logs des comptes :

compte admin :
- id : 1
- mot de passe : 0000

comptes player :
- id : 2
- mot de passe : 0000

- id : 3
- mot de passe : 0000

- id : 4
- mot de passe : 0000

Le jeu permet aussi de se créer un compte.
À noter que le jeu démarre au début de la semaine 1 (les résultats des matchs pour les équipes FCNantes et France ont déjà été ajouté à Data et la mise à jour hebdomadaire de la semaine )

Ce qui n'a pas été fait :

- interface graphique (actuellement, interface texte)
- sérialisation des données du jeu pour la persistance de l'etat du jeu (actuellement le jeu se reset à chaque lancement)
