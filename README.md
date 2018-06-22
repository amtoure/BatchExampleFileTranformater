# BatchExampleFileTranformater
Contexte
Une société de service en informatique a décidé de développer un logiciel pour un de ses clients dont
le but est de transformer un fichier TXT dans un format plus pratique.
Ce fichier contient une liste de références ainsi que diverses informations.
Le fichier TXT transmis peut éventuellement contenir des données erronées.
Il est donc nécessaire d’identifier les lignes erronées et détailler le type d’erreur trouvé.
Le format des références est expliqué ci-dessous:
o Numéro de la référence (10 chiffres)
o Couleur, valeurs possibles :
o R = Rouge
o G = Vert
o B = Bleu
o Prix, valeur en euros (ex : 5.23)
o Taille, valeur entière

Exercice
Le but de l’exercice est d’écrire un programme Java 1.6+, capable de prendre un fichier texte en
entrée ainsi que le format de sortie désiré (XML ou JSON).
Exemple de fichier TXT en entrée :
1460100040;R;45.12;27
1460900848;G;12.0;145
1462100044;G;5.56;19
1462100403;B;105.23;97
1462100403;A;100.1;9
Exemple de fichier XML en sortie :
&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot; standalone=&quot;yes&quot;?&gt;
&lt;report&gt;
&lt;inputFile&gt;Ref_07102014.txt&lt;/inputFile&gt;
&lt;references&gt;
&lt;reference color=&quot;R&quot; price=&quot;45.12&quot; size=&quot;27&quot; numReference=&quot;1460100040&quot;/&gt;
&lt;reference color=&quot;G&quot; price=&quot;12.0&quot; size=&quot;145&quot; numReference=&quot;1460900848&quot;/&gt;
&lt;reference color=&quot;G&quot; price=&quot;5.56&quot; size=&quot;19&quot; numReference=&quot;1462100044&quot;/&gt;
&lt;reference color=&quot;B&quot; price=&quot;105.23&quot; size=&quot;97&quot; numReference=&quot;1462100403&quot;/&gt;
&lt;/references&gt;
&lt;errors&gt;
&lt;error line=&quot;5&quot; message=&quot;Incorrect value for color&quot;&gt;
1462100403;A;100.1;9&lt;/error&gt;
&lt;/errors&gt;
&lt;/report&gt;

Exemple de fichier JSON en sortie :

{
&quot;inputFile&quot; : &quot;Ref_07102014.txt&quot;,
&quot;references&quot; : [ {
&quot;numReference&quot; : &quot;1460100040&quot;,
&quot;size&quot; : 27,
&quot;price&quot; : 45.12,
&quot;type&quot; : &quot;R&quot;
}, {
&quot;numReference&quot; : &quot;1460900848&quot;,
&quot;size&quot; : 145,
&quot;price&quot; : 12.0,
&quot;type&quot; : &quot;G&quot;
}, {
&quot;numReference&quot; : &quot;1462100044&quot;,
&quot;size&quot; : 19,
&quot;price&quot; : 5.56,
&quot;type&quot; : &quot;G&quot;
}, {
&quot;numReference&quot; : &quot;1462100403&quot;,
&quot;size&quot; : 97,
&quot;price&quot; : 105.23,
&quot;type&quot; : &quot;B&quot;
} ],
&quot;errors&quot; : [{
&quot;line&quot; : 5,
&quot;message&quot; : &quot;Incorrect value for color&quot;,
&quot;value&quot; : &quot;1462100403;A;100.1;9&quot;
}]
}
Consignes
Merci de respecter les consignes suivantes :
o Pas plus de 3 heures de développement (l’objectif n’est pas de terminer l’exercice dans sa
totalité mais de vérifier votre implémentation)
o Le programme s’exécutera sous la forme d’une commande prenant les paramètres suivants
en entrée :
o Chemin du fichier texte
o Format de sortie (XML/JSON)
o Chemin du fichier en sortie
o L’application devra comporter des tests unitaires
o Le code devra être commenté
o Vous êtes libre d’utiliser tous les outils et librairies à votre disposition
L’attention sera portée sur l’architecture du code, sa qualité, la gestion des erreurs et dans une
moindre mesure le packaging.
