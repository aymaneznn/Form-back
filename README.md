## Formulaire Service

Bienvenue dans la documentation du service Formulaire ! Ce service gère la logique métier associée aux formulaires, questions, réponses et autres entités de l'application.

### Fonctionnalités Principales

#### Récupérer tous les formulaires

- **Méthode**: `GET`
- **Endpoint**: `/formulaire/all`
- **Description**: Récupère la liste de tous les formulaires existants.
- **Réponse réussie**: Liste des formulaires au format DTO (Data Transfer Object).
- **Réponse échouée**: Erreur interne du serveur (500) en cas de problème lors de la récupération.

#### Créer un formulaire

- **Méthode**: `POST`
- **Endpoint**: `/formulaire/create-formulaire`
- **Description**: Crée un nouveau formulaire avec les détails fournis.
- **Réponse réussie**: 200 OK
- **Réponse échouée**:
  - 400 Bad Request si l'utilisateur associé n'existe pas
  - 500 Internal Server Error en cas d'erreur imprévue

#### Supprimer un formulaire

- **Méthode**: `DELETE`
- **Endpoint**: `/formulaire/delete-formulaire/{idFormulaire}`
- **Description**: Supprime le formulaire avec l'ID spécifié.
- **Réponse réussie**: 200 OK
- **Réponse échouée**:
  - 404 Not Found si le formulaire n'est pas trouvé
  - 500 Internal Server Error en cas d'erreur imprévue

#### Récupérer les questions d'un formulaire

- **Méthode**: `GET`
- **Endpoint**: `/question/get-questions-by-formulaire/{idFormulaire}`
- **Description**: Récupère la liste des questions associées au formulaire avec l'ID spécifié.
- **Réponse réussie**: Liste des questions au format DTO.
- **Réponse échouée**: Erreur interne du serveur (500) en cas de problème lors de la récupération.

#### Récupérer le type de question d'une question

- **Méthode**: `GET`
- **Endpoint**: `/question/get-types-questions-by-question/{idQuestion}`
- **Description**: Récupère le type de question associé à la question avec l'ID spécifié.
- **Réponse réussie**: Type de question au format DTO.
- **Réponse échouée**:
  - 404 Not Found si la question n'est pas trouvée
  - 500 Internal Server Error en cas d'erreur imprévue

#### Créer une question

- **Méthode**: `POST`
- **Endpoint**: `/question/create-question`
- **Description**: Crée une nouvelle question avec les détails fournis.
- **Réponse réussie**: 200 OK
- **Réponse échouée**:
  - 400 Bad Request si le formulaire ou le type de question associé n'existe pas
  - 500 Internal Server Error en cas d'erreur imprévue

#### Supprimer une question

- **Méthode**: `DELETE`
- **Endpoint**: `/question/delete-question/{idQuestion}`
- **Description**: Supprime la question avec l'ID spécifié.
- **Réponse réussie**: 200 OK
- **Réponse échouée**:
  - 404 Not Found si la question n'est pas trouvée
  - 500 Internal Server Error en cas d'erreur imprévue

#### Récupérer les réponses d'une question

- **Méthode**: `GET`
- **Endpoint**: `/reponse/get-reponses-by-question/{idQuestion}`
- **Description**: Récupère la liste des réponses associées à la question avec l'ID spécifié.
- **Réponse réussie**: Liste des réponses au format DTO.
- **Réponse échouée**: Erreur interne du serveur (500) en cas de problème lors de la récupération.

#### Récupérer les réponses d'un formulaire

- **Méthode**: `GET`
- **Endpoint**: `/reponse/get-reponses-by-formulaire/{idFormulaire}`
- **Description**: Récupère la liste des réponses associées au formulaire avec l'ID spécifié.
- **Réponse réussie**: Liste des réponses au format DTO.
- **Réponse échouée**: Erreur interne du serveur (500) en cas de problème lors de la récupération.

#### Créer une réponse

- **Méthode**: `POST`
- **Endpoint**: `/reponse/create-reponse`
- **Description**: Crée une nouvelle réponse avec les détails fournis.
- **Réponse réussie**: 200 OK
- **Réponse échouée**: Erreur interne du serveur (500) en cas de problème lors
