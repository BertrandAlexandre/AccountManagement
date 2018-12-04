# AccountManagement

Mise en place rapide d'un projet SpringBoot et création d'une API REST dans un environnement Windows bridé.
L'environnement bridé se caractérise par le manque de droits d'administration.

## Aide à la navigation

- [Présentation de l'environnement](#présentation-de-lenvironnement)
- [Initialisation de l'environnement](#initialisation-de-lenvironnement)
  - [Installation et paramétrage de Java](#installation-et-paramétrage-de-java)
    - [Téléchargement de Java](#téléchargement-de-java)
    - [Paramétrage des variables d’environnement utilisateur pour Java](#paramétrage-des-variables-denvironnement-utilisateur-pour-java)
  - [Installation et paramétrage de Maven](#installation-et-paramétrage-de-maven)
    - [Téléchargement de Maven](#téléchargement-de-maven)
    - [Paramétrage des variables d’environnement utilisateur pour Maven](#paramétrage-des-variables-denvironnement-utilisateur-pour-maven)
    - [Paramétrage du proxy pour Maven](#paramétrage-du-proxy-pour-maven)
- [Initialisation du projet](#initialisation-du-projet)
  - [Génération du squelette](#génération-du-squelette)
  - [Gestion des dépendances](#gestion-des-dépendances)
  - [Déploiement du projet](#déploiement-du-projet)
  - [Création du fichier .jar ou .war](#création-du-fichier-jar-ou-war)
- [Développement de l'API](#développement-de-lapi)
  - [Présentation de l'organisation du projet](#présentation-de-lorganisation-du-projet)
  - [Principes de REST](#principes-de-rest)
  - [Configuration des profils](#configuration-des-profils)

## Présentation de l'environnement

Le tableau suivant décrit l'environnement et les caractéristiques du projet :

| Outil                        | Solution   |
| ---------------------------- | ---------- |
| Gestionnaire de dépendances  | Maven      |
| Gestionnaire de déploiement  | Maven      |
| Conteneur applicatif         | Springboot |
| ORM                          | Hibernate  |
| Base de test                 | H2         |
| Base de production           | MySQL      |
| Protocole utilisé pour l’API | REST       |
| Format du corps des réponses | JSON       |
| Gestion des tests unitaires  | JUnit      |

## Initialisation de l'environnement

Pour contourner le manque de droits d'administration, nous mettrons en place un environnement portable et nous utiliserons des configurations locales.

### Installation et paramétrage de Java

#### Téléchargement de Java

Téléchargez le Java Development Kit de la dernière version stable de Java.
Oracle ne distribue pas de version portable. Pour récupérer une version portable, allez sur le site [portableapps](https://portableapps.com/) et recherchez le JDK.

Une fois téléchargé, décompressez le fichier dans un dossier personnel local.

#### Paramétrage des variables d’environnement utilisateur pour Java

Dans le menu Windows ou dans le panneau de configuration cherchez : *« Modifier les variables d’environnement pour votre compte »*.
> La modification des variables d’environnement système requiert des droits d'administration. Elle n’est pas utile si l’on travaille toujours sur le même compte Windows.

Ajoutez la variable d’environnement JAVA_HOME pointant sur le dossier du dernier JDK installé.<br/>
Ajoutez au PATH le dossier `\bin` du dernier JDK installé :
```
%JAVA_HOME%\bin
```

### Installation et paramétrage de Maven

#### Téléchargement de Maven

Téléchargez la dernière version stable de Maven en version binaire zip sur le site [Apache Maven](https://maven.apache.org/download.cgi).

Une fois téléchargé, décompressez le fichier dans un dossier personnel local.

#### Paramétrage des variables d’environnement utilisateur pour Maven

Dans le menu Windows ou dans le panneau de configuration cherchez : *« Modifier les variables d’environnement pour votre compte »*.

> La modification des variables d’environnement système requiert des droits d'administration. Elle n’est pas utile si l’on travaille toujours sur le même compte Windows.

Ajoutez au PATH le dossier `\bin` du dossier d'installation de Maven.

#### Paramétrage du proxy pour Maven

Si un proxy est présent, ouvrez le fichier `.\conf\settings.xml` dans le dossier d'installation de Maven.<br/>
Entre les balises `proxies`, ajoutez les informations relatives au proxy.

> Pensez à paramétrer le proxy pour chaque protocole nécessaire : http, https, ...

## Initialisation du projet

### Génération du squelette

Afin de ganger du temps sur la mise en place du projet, Maven propose l'utilisation d'archetypes.
Ouvrez un invité de commande et positionnez vous dans le repertoire dans lequel vous voulez créer votre projet.<br/>
Saisiez la commande suivante :
```Shell
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes
                       -DarchetypeArtifactId=maven-archetype-quickstart
```

> Attention, si vous utilisez PowerShell, il est nécessaire d'entourer les paramètres avec des quottes.

> Il existe de nombreux archetypes plus spécifiques. Si vous souhaitez une autre configuration de départ, n'hésitez pas à rechercher d'autres archetypes.

Après avoir téléchargé les dépendances liées à l’archetype, springboot vous demandera la configuration de votre projet.<br/>
Voilà un exemple de configuration :
```
Define value for property 'groupId': my.package.project
Define value for property 'artifactId': project-name
Define value for property 'version':
Define value for property 'package':
```

Confirmez la configuration afin que Maven crée le squelette.

Une alternative pour gagner du temps peut être l'utilisation de [Spring Initializr](https://start.spring.io/). Ils vous permettra par ailleurs d'ajouter les dépendances Spring dont vous aurez besoin.

### Gestion des dépendances

Le fichier pom.xml contient les informations générales relatives au projet. Il permet de gérer les dépendances, le déploiement, ...
Vous devrez préciser ici les dépendances nécessaires à votre projet (dépendences Spring, ORM, connecteur SGBD, ...). Vous pourrez également préciser les versions et la portée des dépendances.<br/>
Pour trouver les dépendances et leurs versions, vous pouvez utiliser le site [MVNRepository](https://mvnrepository.com/).

### Déploiement du projet

Afin de déployer le projet avec la configuration de production, ouvrez un invité de commande, positionnez vous dans le repertoire de votre projet et saisisez la commande suivante :
```Shell
mvn spring-boot:run
```

Si vous voulez déployer le projet avec un profil spécifique, saisisez la commande suivante (avec `profileName` le nom du profil) :
```Shell
mvn spring-boot:run -Dspring-boot.run.profiles=profileName
```

> Attention, si vous utilisez PowerShell, il est nécessaire d'entourer le paramètre avec des quottes.

### Création du fichier .jar ou .war

Afin de créer le fichier jar ou war (selon la configuration du fichier `pom.xml`, ouvrez un invité de commande, positionnez vous dans le repertoire de votre projet et saisisez la commande suivante :
```Shell
mvn package
```

## Développement de l'API

### Présentation de l'organisation du projet

Le projet s'organise de la manière suivante :
```text
src/
└── main/
    ├── java/
    │   └── my/
    │       └── package/
    │           └── project/
    │               ├── config/
    │               ├── controller/
    │               ├── dto/
    │               ├── exception/
    │               ├── model/
    │               ├── repository/
    │               └── service/
    └── resources/
        └── application.properties
pom.xml
```

Le tableau suivant décrit les principaux packages de l'application ainsi que leurs rôles :

| Package      | Rôles      |
| ------------ | ---------- |
| config       | Configurations de l'application. |
| controller   | Controlleurs de l'application, ils représentent l'interface de l'API REST. |
| dto          | Objets de Transfert de Donnéees simplifiant les transferts et les accès aux données. |
| exception    | Exceptions et messages d'erreurs courrants de l'application. |
| model        | Entités et énumérations de l'API. Un ORM fera le lien entre ces entités et la base de données. |
| repository   | Dépôts des entités, ils sont utilisés par les services pour accéder aux données dans la base de données. Ils peuvent être utilisés pour faire des requêtes spécifiques sur la base de données. |
| service      | Services réalisant les traitements sur les données (récupération, création, modification, ...). Ils sont utilisés par les controlleurs. |

### Principes de REST

REST est une architecture dont les principales méthodes ressemblent fortement aux méthodes du protocole HTTP.

Les ressources sont représentées sous la forme de collections (ensemble de ressources) :
```
http://localhost:8080/api/ressources
```
> Les collections sont toujours nommées au pluriel. Exemple : __ressources__

Chaque ressource d'une collection est accessible via un identifiant unique :

```
http://localhost:8080/api/ressources/1
```
Les ressources peuvent elle même contenir des collections :
```
http://localhost:8080/api/ressources/1/subressources
```

Les effets des méthodes sur les collections sont les suivants :

| Méthode | Effet                                                                     |
| ------- | ------------------------------------------------------------------------- |
| GET     | Récupère les éléments ou une représentation des éléments d'une collection |
| POST    | Crée un nouvel élément dans une collection                                |
| PUT     | Remplace une collection par une autre collection                          |
| DELETE  | Supprime une collection                                                   |

Les effets des méthodes sur les ressources sont les suivants

| Méthode | Effet                                                                   |
| ------- | ----------------------------------------------------------------------- |
| GET     | Récupère un élément ou une représentation d'un élément d'une collection |
| PUT     | Remplace un élément d'une collection ou le crée s'il n'existe pas       |
| PATCH   | Modifie un élément d'une collection                                     |
| DELETE  | Supprime un élément d'une collection                                    |

### Configuration des profils

Les profils peuvent être utilisés de plusieurs façon. Les deux principales utilisations sont les suivantes :
- Création de composant dont la portée est limitée à un profil. Pour créer un composant, utiliser l'anotation `@component`. Pour spécifier un profil utilisez l'anotation `@Profile("profileName")` (avec `profileName` le nom du profil).
- Paramétrage de l'application via les fichiers `.properties`. Ces fichiers doivent être créés dans le répertoire des ressources `.\src\main\ressources\`. Pour le profil par défaut (profil de production), le fichier se nomera `application.properties`. Pour un profil spécifique, le fichier se nomera `application-profileName.properties` (avec `profileName` le nom du profil).
