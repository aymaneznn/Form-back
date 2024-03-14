
---

# API REST de Form Creator

Ce module expose les fonctionnalités de Form Creator en tant qu'API REST.

## Introduction

Ce module vous permet de gérer des formulaires, des questions et des réponses dans votre application via des appels API REST. Il est conçu pour être utilisé avec un backend développé en Java avec le framework Spring Boot et une base de données relationnelle.

## Modèles de données

Ce module utilise plusieurs entités pour représenter les données des formulaires, des questions, des réponses et des utilisateurs :

### Formulaire

- **formulaireId**: Identifiant unique du formulaire.
- **titre**: Titre du formulaire.
- **description**: Description du formulaire.
- **creerPar**: L'utilisateur qui a créé le formulaire.
- **creerLe**: Date de création du formulaire.
- **modifieLe**: Date de dernière modification du formulaire.

### Question

- **id**: Identifiant unique de la question.
- **formulaire**: Le formulaire auquel la question est associée.
- **question**: Texte de la question.
- **typeQuestion**: Le type de question (par exemple, texte libre, choix multiple, etc.).
- **optionsQuestion**: Options supplémentaires pour les questions de type sélection (peut être null).

### Réponse

- **id**: Identifiant unique de la réponse.
- **formulaire**: Le formulaire auquel la réponse est associée.
- **question**: La question à laquelle la réponse est donnée.
- **typeReponse**: Le type de réponse (peut être null en fonction du type de question).
- **utilisateur**: L'utilisateur qui a fourni la réponse.
- **posterLe**: Date de soumission de la réponse.
- **donneesReponse**: Données de la réponse (sous forme de map).
- **idGroupReponse**: Identifiant de groupe de la réponse (peut être null).

### TypesQuestion

- **id**: Identifiant unique du type de question.
- **type**: Type de question (par exemple, texte libre, choix multiple, etc.).

### Utilisateur

- **id**: Identifiant unique de l'utilisateur.
- **nom**: Nom de l'utilisateur.
- **prenom**: Prénom de l'utilisateur.
- **password**: Mot de passe de l'utilisateur.

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
