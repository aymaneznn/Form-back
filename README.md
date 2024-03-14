
---

# API REST de Form Creator

Ce module expose les fonctionnalités de Form Creator en tant qu'API REST.

## Introduction

Ce module vous permet de gérer des formulaires, des questions et des réponses dans votre application via des appels API REST. Il est conçu pour être utilisé avec un backend développé en Java avec le framework Spring Boot et une base de données relationnelle.

## Modèles de données

Ce module utilise plusieurs entités pour représenter les données des formulaires, des questions, des réponses et des utilisateurs :

- **Formulaire**: Représente un formulaire avec des champs tels que le titre, la description, la date de création, etc.
- **Question**: Représente une question dans un formulaire avec des détails tels que le texte de la question, le type de question, etc.
- **Réponse**: Représente une réponse à une question spécifique dans un formulaire.
- **TypesQuestion**: Représente les différents types de questions possibles, tels que texte libre, choix multiple, etc.
- **Utilisateur**: Représente un utilisateur de l'application.

## Contrôleurs

Ce module expose plusieurs endpoints pour interagir avec les données des formulaires, des questions et des réponses :

### FormulaireController

#### ``GET /formulaire/all``
Récupère tous les formulaires disponibles.
**Exemple de retour :**
```json
[
    {
        "formulaireId": "1",
        "titre": "Formulaire de satisfaction",
        "description": "Formulaire pour recueillir les commentaires des clients",
        "creerPar": {
            "id": 1,
            "nom": "John",
            "prenom": "Doe"
        },
        "creerLe": "2024-03-14",
        "modifieLe": null
    },
    {
        "formulaireId": "2",
        "titre": "Formulaire d'inscription",
        "description": "Formulaire pour s'inscrire à un événement",
        "creerPar": {
            "id": 2,
            "nom": "Jane",
            "prenom": "Doe"
        },
        "creerLe": "2024-03-15",
        "modifieLe": null
    }
]
```

#### ``POST /formulaire/create-formulaire``
Crée un nouveau formulaire en fournissant les données du formulaire dans le corps de la requête.
**Exemple de corps de requête :**
```json
{
    "titre": "Nouveau formulaire",
    "description": "Description du nouveau formulaire",
    "creerPar": {
        "id": 1
    }
}
```

#### ``DELETE /formulaire/delete-formulaire/{idFormulaire}``
Supprime le formulaire avec l'ID spécifié.

### QuestionController

#### ``GET /question/get-questions-by-formulaire/{idFormulaire}``
Récupère toutes les questions associées à un formulaire spécifique.
**Exemple de retour :**
```json
[
    {
        "id": 1,
        "formulaire": {
            "formulaireId": "1",
            "titre": "Formulaire de satisfaction"
        },
        "question": "Quelle est votre satisfaction générale?",
        "typeQuestion": {
            "id": 1,
            "type": "Choix multiple"
        },
        "optionsQuestion": "Très satisfait, Satisfait, Neutre, Insatisfait, Très insatisfait"
    },
    {
        "id": 2,
        "formulaire": {
            "formulaireId": "1",
            "titre": "Formulaire de satisfaction"
        },
        "question": "Quel est votre niveau de recommandation?",
        "typeQuestion": {
            "id": 1,
            "type": "Choix multiple"
        },
        "optionsQuestion": "Très probable, Probable, Neutre, Peu probable, Très peu probable"
    }
]
```

#### ``POST /question/create-question``
Crée une nouvelle question en fournissant les données de la question dans le corps de la requête.
**Exemple de corps de requête :**
```json
{
    "formulaire": {
        "id": 1
    },
    "question": "Nouvelle question",
    "typeQuestion": {
        "id": 1
    },
    "optionsQuestion": "Option 1, Option 2, Option 3"
}
```

#### ``DELETE /question/delete-question/{idQuestion}``
Supprime la question avec l'ID spécifié.

### ReponseController

#### ``GET /reponse/get-reponses-by-question/{idQuestion}``
Récupère toutes les réponses associées à une question spécifique.
**Exemple de retour :**
```json
[
    {
        "id": 1,
        "formulaire": {
            "formulaireId": "1",
            "titre": "Formulaire de satisfaction"
        },
        "question": {
            "id": 1,
            "question": "Quelle est votre satisfaction générale?"
        },
        "typeReponse": {
            "id": 1,
            "type": "Choix unique"
        },
        "utilisateur": {
            "id": 1,
            "nom": "John",
            "prenom": "Doe"
        },
        "posterLe": "2024-03-14",
        "donneesReponse": {
            "satisfaction": "Très satisfait"
        },
        "idGroupReponse": "GRP123"
    }
]
```

#### ``POST /reponse/create-reponse``
Crée une nouvelle réponse en fournissant les données de la réponse dans le corps de la requête.
**Exemple de corps de requête :**
```json
{
    "formulaire": {
        "id": 1
    },
    "question": {
        "id": 1
    },
    "typeReponse": {
        "id": 1
    },
    "utilisateur": {
        "id": 1
    },
    "donneesReponse": {
        "satisfaction": "Très satisfait"
    },
    "idGroupReponse": "GRP123"
}
```

#### ``DELETE /reponse/delete-reponse/{idReponse}``
Supprime la réponse avec l'ID spécifié.

## Utilisation

Pour utiliser cette API, vous pouvez envoyer des requêtes HTTP aux différents endpoints exposés par les contrôleurs. Assurez-vous de fournir les données requises dans le format JSON attendu par chaque endpoint.



---
