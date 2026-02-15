# Projet_stage_BUT3
Projet de test pour découvrir les langages et outils que j’utiliserai lors de mon stage de fin de 3ᵉ année de BUT Informatique.

## Langages et outils utilisé : 

- Backend : Java (17) + SpringBoot (4.0)
- Frontend : Vue.js 3 (+ Vuetify framework CSS)
- ORM : Hibernate
- BD : PostgresSQL (9.6)

## L’application est conteneurisée avec devcontainer.

### Prérequis pour lancer via devContainer :
- VsCode
- Extension devContainer
- Docker

## Une fois le projet ouvert dans le devContainer :

### Backend : 

```
cd /backend
mvn spring-boot:run 
```

### Frontend : 

```
cd /frontend
npm install
npm run dev -- --host
```
