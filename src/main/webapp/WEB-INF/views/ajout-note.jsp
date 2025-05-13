<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="sn.isep.dbe.modele.Note" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter une Note</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<header>
    <h1>Système de gestion scolaire</h1>
    <nav>
        <ul>
            <li><a href="/accueil">Accueil</a></li>
            <li><a href="/etudiants/lister">Etudiants</a></li>
            <li><a href="/cours/lister">Cours</a></li>
            <li><a href="/filieres/lister">Filières</a></li>
            <li><a href="/notes/lister" class="active">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="form-container">
        <h2>Ajouter une nouvelle Note</h2>

        <form action="/notes/ajouter" method="post">
            <div class="form-group">
                <label for="idEtudiant">ID Etudiant</label>
                <input type="number" name="idEtudiant" id="idEtudiant" placeholder="ID Etudiant" required>
            </div>

            <div class="form-group">
                <label for="idCours">ID Cours</label>
                <input type="number" name="idCours" id="idCours" placeholder="ID Cours" required>
            </div>

            <div class="form-group">
                <label for="valeur">Valeur de la Note</label>
                <input type="number" name="valeur" id="valeur" step="0.01" placeholder="Valeur de la Note" required>
            </div>

            <div class="form-buttons">
                <button type="submit" class="btn btn-primary">Ajouter</button>
                <a href="/notes/lister" class="btn btn-secondary">Annuler</a>
            </div>
        </form>
    </section>
</main>
</body>
</html>
