# AccountManagement

Micro-service de gestion des comptes utilisateur.

## Prérequis

Avant de pouvoir lancer l'application en mode production, il est requis de mettre en place une base de données MySQL.
Téléchargez la dernière version de MySQL Community Server sur le site de [MySQL](https://dev.mysql.com/downloads/mysql/).

Après avoir installé et paramétré MySQL, créez une base de donnée nommée `am`.

Assurez vous d'utiliser le port par défaut `3306` ou changez le port dans le fichier `\src\main\resources\application.properties`.

## Démarage rapide

### En mode développement

Démarrez l'application avec les commandes suivantes :
```Shell
cd .\AccountManagement\
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

#### Base de données

Une base H2 est déployée en mode développement. Elle est accessible à l'adresse :
<http://localhost:8080/h2>

### En mode production

Démarrez le serveur MySQL avec la commande suivante :
```Shell
mysqld --console
```

Démarrez l'application avec les commandes suivantes :
```Shell
cd .\AccountManagement\
mvn spring-boot:run
```