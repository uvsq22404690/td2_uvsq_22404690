# TP Maven-JUnit
L'objet de cet exercice est de réaliser une classe `ChaineCryptee` qui permettra de chiffrer/déchiffrer une chaîne de caractères (**composée de lettres majuscules et d'espace**).
Le chiffrement utilise une méthode par décalage.
La valeur du décalage représente la clé de chiffrement.
Par exemple, une clé de valeur trois transformera un `'A'` en `'D'`.

La classe `ChaineCryptee` disposera
* des attributs pour la chaîne *en clair* et le décalage,
* un constructeur pour initialiser les instances à partir d'une chaîne en clair et du décalage,
* la méthode `String decrypte()` qui retourne la chaîne en clair,
* la méthode `String crypte()` qui retourne la chaîne chiffrée,
Vous pourrez utilisez pour cela la [méthode `decaleCaractere`](https://gist.github.com/hal91190/4f3a0941e652e82a5e1c572834d97827),
* la possibilité d'initialiser une instance à partir d'une chaîne cryptée et d'un décalage.
Pour éviter l'ambiguïté au niveau du constructeur, vous utiliserez le [modèle de conception Fabrication](http://fr.wikipedia.org/wiki/Fabrique_%28patron_de_conception%29#Autres_avantages_et_variantes).
Pour cela,
    * créez les méthodes de classe `ChaineCryptee deCryptee(String, int)` et `ChaineCryptee deEnClair(String, int)`,
    * rendez le constructeur privé.
La création des instances se fait maintenant à l'aide des deux méthodes de classe.

De plus, le projet sera géré avec [Maven](https://maven.apache.org/) et vous utiliserez une approche pilotée par les tests pour la réalisation, i.e. écrivez toujours un test avant le code et pensez au refactoring.
Le framework de tests devra être [JUnit 4](https://junit.org/junit4/) (ou [5](https://junit.org/junit5/) si vous préférez).
Vous rédigerez votre code source en respectant les [conventions de codage](https://google.github.io/styleguide/javaguide.html) du guide de stype _Google_.
Enfin, la prise en compte des contraintes se fera par de la gestion d’erreurs et des exceptions.

Il pourra éventuellement être nécessaire de [configurer le proxy](http://maven.apache.org/guides/mini/guide-proxies.html) (http://wwwcache.uvsq.fr:3128) pour accéder au dépôt Maven.

À chaque étape, validez vos modifications avec `git` et si nécessaire, exécutez le cycle maven adapté pour vérifier vos manipulations.

1.  Quelles conventions utilise Maven pour l’arborescence des répertoires ?
    > L'arborescence d'un projet Maven se constitut du dossier principal ou on y accède avec le chemin du dossier
ainsi contenant plusieurs sous dossiers, le dossier /src arbite le code source et les ressources, /main pour le code principal  
    (java et ressources) et /test pour trouver les testes unitaires, le dossier /target est généré par Maven et contient des fichiers
crées lors de la compilation et du packaging, le fichier pom.xml décrit les dépéndences et les configurations du projet. Toute cette structure
est importante pour le faciliter le développement et la gestion de l'application en question
1.  Examinez le projet Maven ainsi que le fichier de description et répondez aux questions suivantes :
    1.  Dans quel répertoire se trouvent les fichiers sources du projet ? Les sources des tests ?
        > Les fichiers sources du projet se trouvent dans "/src/main/java" et les sources des tests son situées dans le répértoire 
"/src/test/java"
    1. Quelles sont les coordonnées du projet ?
    > <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>; Junit pour l'organisation qui développe le projet (groupID) et l'identifiant unique du projet (artifactID),
ses informations se trouvent dans le ffichier pom.xml et ces élements représentent un clé dans la gestion des dépendences de MAVEN
    1. À quoi sert la propriété `project.build.sourceEncoding` ?
        > la propriété project.build.sourceEncoding se que on retrouve dans notre fichier pom.xml La propriété project.build.sourceEncoding dans le fichier pom.xml définit l'encodage des fichiers source de notre projet. 
Elle garantit que tous les développeurs, peu importe leur environnement, utilisent le même encodage, ce qui évite des erreurs de compilation et des problèmes avec les caractères spéciaux. 
En utilisant par exemple UTF-8, on assures la cohérence et la lisibilité du code pour tous.
 
    1. Quelles versions des sources et de la JVM sont utilisés ?
        > Dans le fichier pom.xml, on utilise les propriétés maven.compiler.source et maven.compiler.target 
pour spécifier les versions des sources et de la JVM. Par exemple, si on veut utiliser Java 8 ce qui est le cas dans notre projet
"<maven.compiler.source>1.8</maven.compiler.source>
<maven.compiler.target>1.8</maven.compiler.target>" Cela garantit que notre code est compilé et exécuté avec la version de Java qu'on a choisie. 
C'est important pour éviter les problèmes d'incompatibilité et s'assurer que tout fonctionne correctement.
    1. Quelle version de JUnit est configurée ? À quoi sert la balise `scope` ?
        > La version de JUnit qui est configurée est la 4.11
<dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
       La balise scope dans le fichier pom.xml détermine où et comment une dépendance est utilisée. Par exemple, en définissant scope sur test, on indiques que la dépendance (comme JUnit) est uniquement pour les tests et ne sera pas incluse dans le code final de l'application. 
Cela permet de garder le paquet léger et de séparer les outils de test du code de production.
    1. À quoi sert la section `pluginManagement` ?
        > La section pluginManagement dans un projet Maven sert à définir, une fois pour toutes, comment les plugins doivent être utilisés (version, configuration) pour tout le projet et ses sous-projets. Ensuite, les sous-projets peuvent simplement dire "j'utilise ce plugin" sans avoir à répéter toute la configuration. C'est pratique pour garder tout bien organisé et éviter les incohérences.
1.  Modifiez la configuration du projet de la façon suivante :
    1.  fixez la version des sources et des .class pour utiliser la version 17 de Java
    1.  utilisez la dernière version stable de JUnit 4 (cf. [MVNRepository](https://mvnrepository.com/))
1.  Ajoutez un fichier `.gitignore` adapté aux projets Maven (cf. [A collection of .gitignore templates](https://github.com/github/gitignore)) et ajoutez-y les fichiers et répertoires de votre IDE.
1.  Quelle commande Maven permet de :
    1.  créer un `jar` du projet ?
        > La commande mvn package permet de créer un jar dans le répertoire target/ à condition que notre projet utilise le packaging par défaut jar dans notre pom.xml
    1. lancer les tests ?
        > mvn test nous permet de lancer des test qui sont définis sur src/test/....ChaineCrypteeTest.java dans notre cas 
    1. supprimer tous les fichiers issus de la compilation ?
        > La commande mvn clean permet de procéder au nettoyage du projet Maven en supprimant tous les fichiers et dossiers créés lors des compilations précédentes, y compris le répertoire target/. Cela offre la possibilité de partir sur une base solide avant de reconstruire le projet. Cela est bénéfique afin d'éviter les désaccords ou les erreurs qui pourraient se produire en raison de fichiers obsolètes ou corrompus.
1.  Ajoutez une classe `ChaineCryptee` et une classe `ChaineCrypteeTest` dans les répertoires et packages appropriés.
    Supprimez les classes d'exemple `App` et `AppTest`.
1.  Énumérez une liste de cas de tests à réaliser en n'oubliant pas les cas d'erreur.
    > RÉPONDRE ICI
1.  Pour chaque cas de test,
    1. écrivez le test JUnit correspondant dans la classe de test,
    1. vérifiez qu’il échoue,
    1. implémentez la fonctionnalité dans la classe,
    1. vérifiez que le test passe,
    1. appliquez un étape de refactoring sur les tests et la classe si nécessaire.
1.  Comment se comporte votre classe si la chaîne passée au constructeur est `null` ?
Vous pouvez utiliser le débogueur pour identifier le problème (s'il y a un problème) au niveau de `crypte`.
    > RÉPONDRE ICI
    1. ajoutez un test pour prendre en compte la chaîne `null`,
    1. si nécessaire, modifiez la classe pour faire passer le test
1. Changez la représentation interne de la classe : seule la chaîne cryptée est stockée (plus la chaîne en clair).
    * effectuez les modifications nécessaires sans changer l'interface de la classe (les tests ne seront donc pas impactés).
1.  Modifiez le POM pour intégrer la vérification des conventions de codage avec [`checkstyle`](http://maven.apache.org/plugins/maven-checkstyle-plugin/) en utilisant les conventions _Google_.
1.  Ajoutez une méthode `main` qui démontre quelques fonctionnalités de la classe, puis modifiez le POM pour que le jar généré soit exécutable (cf. [Apache Maven JAR Plugin](https://maven.apache.org/plugins/maven-jar-plugin/index.html))
1.  Modifiez la méthode `main` pour que les différents affichages se fassent à l'aide de la bibliothèque de logging [`SLF4J`](http://www.slf4j.org/)
1. En utilisant le plugin [assembly](https://maven.apache.org/plugins/maven-assembly-plugin/) (ou le plugin [shade](https://maven.apache.org/plugins/maven-shade-plugin/)), générez une archive du projet contenant ses dépendances (uber-jar)
