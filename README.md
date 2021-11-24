# AnimList
Projet App Esiea LUCAS GAMBERT

Bonjour et bienvenue sur le repo de mon projet d'application mobile pour ce semestre à l'ESIEA

Je vous présente **AnimList**, une application pour fan d'anime en tout genre.
Le but de cette application est de pouvoir rechercher n'importe quel anime qui existe et pouvoir voir la note attribuée par les utilisateurs
ainsi qu'un résumé de l'oeuvre que vous voulez découvrir.

### Prérequis
-   Installer Android Studio  
-   Récupérer le projet
```
https://github.com/lucas-gambert/AppliESIEA.git
```

##  Réalisations
- Utilisation d'un recyclerView pour afficher une liste d'animes.
- La page de détail pour consulter des infos sur un anime en particulier.
- Utilisation de l'API Kitsu (https://kitsu.docs.apiary.io/#)
- Graphiques originaux de l'appli sur le thème d'**Akira**.
- Stockage en cache des calls d'API.
- Utilisation de singleton.
- MVMM.
- Utilisation de design pattern.
- Ajout d'une fonction de recherche d'anime.

### Fonctionnement de l'application
<img src="https://github.com/lucas-gambert/AppliESIEA/blob/master/screens/video.gif" alt="Application GIF" height="500">
Pour lancer l'appli, il suffit juste de cliquer sur le petit carré sur votre écran qui porte le nom AnimList et le logo est une petite pilule
sur fond blanc. Cette pilule, logo de l'app, provient d'**Akira**, le manga sur lequel sont basés les graphismes de l'app.
<br/><img src="https://github.com/lucas-gambert/AppliESIEA/blob/master/screens/app.jpg" alt="alt" width="100px" height="100px"><br/>

L'interface est simple, au démarrage de l'app, l'écran de chargement se lance et vous pourrez voir le nom de l'appli dans une typo spéciale,
ainsi qu'une moto, elle aussi présente dans le manga **Akira** et faisant office de logo secondaire.
<br/><img src="https://github.com/lucas-gambert/AppliESIEA/blob/master/screens/loading.jpg" alt="alt" height="500px"><br/>

Une fois l'écran de chargement passé, vous arrivez sur la page principale de l'app où figure une liste prédéfinie d'anime.
<br/><img src="https://github.com/lucas-gambert/AppliESIEA/blob/master/screens/mainmenu.jpg" alt="alt" height="500px"><br/>
Si vous cliquez sur un anime de la liste, vous serez redirigé vers une nouvelle page où vous pourrez consulter les détails de l'anime sur lequel
vous venez de cliquer.
<br/><img src="https://github.com/lucas-gambert/AppliESIEA/blob/master/screens/maindetail.jpg" alt="alt" height="500px"><br/>
En consultant le résumé, s'il y a trois points à la fin de la dernière phrase et qu'elle se coupe de manière brutale, vous pouvez cliquer directement
sur le texte pour consulter la suite.
<br/><img src="https://github.com/lucas-gambert/AppliESIEA/blob/master/screens/maindetailmore.jpg" alt="alt" height="500px"><br/>

Partie recherche :

Sur la page principale de l'app, vous pouvez voir qu'il y a un champs "Rechercher" avec un bouton à sa droite.
<br/><img src="https://github.com/lucas-gambert/AppliESIEA/blob/master/screens/recherche.PNG" alt="alt" height="100px"><br/>
Vous pouvez grâce à ça rechercher n'importe quel anime de l'API en appuyant sur le bouton en forme de loupe après avoir écrit
dans la zone de texte.
<br/><img src="https://github.com/lucas-gambert/AppliESIEA/blob/master/screens/searchresult.jpg" alt="alt" height="500px"><br/>
Pour revenir à l'affichage de base, il suffit de supprimer ce qu'il y a dans la zone de texte et de cliquer sur le bouton de 
recherche.

Merci de m'avoir lu profitez bien de l'application !




