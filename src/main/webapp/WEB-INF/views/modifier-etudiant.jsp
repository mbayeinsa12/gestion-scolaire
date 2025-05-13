<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="sn.isep.dbe.modele.Etudiant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier Étudiant</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<header>
    <h1>Système de gestion scolaire</h1>
    <nav>
        <ul>
            <li><a href="/accueil">Accueil</a></li>
            <li><a href="/etudiants/lister" class="active">Etudiants</a></li>
            <li><a href="/cours/lister">Cours</a></li>
            <li><a href="/filieres/lister">Filières</a></li>
            <li><a href="/notes/lister">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="form-container">
        <h2>Modifier un étudiant</h2>

        <form action="/etudiants/modifier" method="post">
            <!-- Champ caché pour l'ID de l'étudiant -->
            <input type="hidden" name="id" value="${item.id}" >

            <div class="form-group">
                <label for="nom">Nom</label>
                <input value="${item.nom}" type="text" name="nom" id="nom" placeholder="Nom" required>
            </div>

            <div class="form-group">
                <label for="prenom">Prénom</label>
                <input value="${item.prenom}" type="text" name="prenom" id="prenom" placeholder="Prénom" required>
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input value="${item.email}" type="email" name="email" id="email" placeholder="Email">
            </div>

            <div class="form-group">
                <label for="telephone">Téléphone</label>
                <input value="${item.telephone}" type="text" name="telephone" id="telephone" placeholder="Téléphone">
            </div>

            <div class="form-group">
                <label for="carteEtudiant">Carte Étudiant</label>
                <input value="${item.carteEtudiant}" type="text" name="carteEtudiant" id="carteEtudiant" placeholder="Carte Étudiant" required>
            </div>

            <div class="form-buttons">
                <button type="submit" class="btn btn-primary">Modifier</button>
                <a href="/etudiants/lister" class="btn btn-secondary">Annuler</a>
            </div>
        </form>
    </section>
</main>
</body>
</html>
