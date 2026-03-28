# 🔍 CampusHub - Service Registry (Eureka)

[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.5-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Eureka](https://img.shields.io/badge/Netflix_Eureka-Service_Discovery-orange?style=for-the-badge&logo=netflix)](https://github.com/Netflix/eureka)

> Le **Service Registry** est l'annuaire dynamique de CampusHub. Basé sur Netflix Eureka, il permet à chaque microservice de se déclarer et de localiser ses pairs sans configuration d'adresses IP statiques.

---

## 🚀 Fonctionnalités Clés

- **Auto-enregistrement** : Les microservices s'inscrivent automatiquement au démarrage.
- **Health Monitoring** : Surveillance par heartbeat pour détecter les instances défaillantes.
- **Load Balancing** : Base indispensable pour l'équilibrage de charge côté client (Ribbon/OpenFeign).
- **Interface de Supervision** : Dashboard web complet accessible sur le port `8761`.

---

## ⚙️ Configuration & Installation

### Build du package (Crucial)
```bash
# Générer le JAR en sautant les tests
./mvnw clean package -DskipTests
```

### Lancement Local
```bash
./mvnw spring-boot:run
```

### Déploiement Docker
```bash
docker build -t campushub-registry-service .
```

### Dashboard
Une fois lancé, accédez à : `http://localhost:8761` pour visualiser l'état de santé de l'écosystème.

---
<p align="center">L'intelligence collective au service de l'architecture distribuée</p>
