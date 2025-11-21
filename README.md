# campushub-registry - Service de Découverte (Eureka Server)

Ce service implémente un serveur Eureka (Service Discovery) pour l'architecture microservices Campushub. Il permet aux microservices de s'enregistrer auprès de lui au démarrage et de découvrir d'autres services par leur nom logique, facilitant ainsi la communication inter-services.

### Fonctionnalités

*   **Enregistrement des services**: Les microservices s'enregistrent auprès d'Eureka Server à leur démarrage.
*   **Découverte des services**: Les clients Eureka peuvent interroger le serveur pour obtenir les emplacements des instances de service.
*   **Équilibrage de charge côté client**: Intégré avec Spring Cloud LoadBalancer, il permet un équilibrage de charge simple entre les instances de service.
*   **Surveillance de l'état des services**: Eureka Server surveille la santé des instances enregistrées.

### Comment ça marche

`campushub-registry` est une application Spring Boot configurée en tant que serveur Eureka. Au démarrage, il tente de se connecter au `campushub-config` pour obtenir ses propres propriétés de configuration. Une fois démarré, il expose une API REST que les autres services utilisent pour s'enregistrer et se découvrir.

### Commandes Utiles

#### Construire le service (localement, sans Docker)

Pour construire le fichier JAR exécutable du service:

```bash
cd campushub-deployment/campushub-registry
./mvnw clean install -Dspring.cloud.config.uri=http://localhost:8888
```
*(Note: L'option `-Dspring.cloud.config.uri=http://localhost:8888` est nécessaire pour que les tests et la construction locale puissent se connecter au service `campushub-config` si celui-ci est démarré via Docker sur votre machine locale.)*

#### Exécuter le service (localement, sans Docker)

Assurez-vous d'avoir construit le JAR au préalable.

```bash
cd campushub-deployment/campushub-registry
java -jar target/campushub-registry-service-0.0.1-SNAPSHOT.jar
```

Le service sera accessible sur `http://localhost:8761`.

#### Construire et exécuter avec Docker Compose

Dans le répertoire `campushub-deployment`, ce service est défini dans le fichier `docker-compose.yml`.

Pour construire l'image Docker (cela inclut la construction du JAR si ce n'est pas déjà fait):

```bash
cd campushub-deployment
docker-compose build campushub-registry
```

Pour démarrer le conteneur du service:

```bash
cd campushub-deployment
docker-compose up -d campushub-registry
```

Pour vérifier les logs du service une fois démarré:

```bash
cd campushub-deployment
docker-compose logs campushub-registry
```