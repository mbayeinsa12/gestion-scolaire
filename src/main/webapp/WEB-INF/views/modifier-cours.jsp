<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="sn.isep.dbe.modele.Cours" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier Cours</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<header>
    <h1>Système de gestion scolaire</h1>
    <nav>
        <ul>
            <li><a href="/accueil">Accueil</a></li>
            <li><a href="/etudiants/lister">Étudiants</a></li>
            <li><a href="/cours/lister" class="active">Cours</a></li>
            <li><a href="/filieres/lister">Filières</a></li>
            <li><a href="/notes/lister">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="form-container">
        <h2>Modifier un cours</h2>

        <form action="/cours/modifier" method="post">
            <input type="hidden" name="id" value="${item.id}">

            <div class="form-group">
                <label for="code">Code</label>
                <input value="${item.code}" type="text" name="code" id="code" placeholder="Code du cours" required>
            </div>

            <div class="form-group">
                <label for="nom">Nom</label>
                <input value="${item.nom}" type="text" name="nom" id="nom" placeholder="Nom du cours" required>
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <textarea name="description" id="description" placeholder="Description">${item.description}</textarea>
            </div>

            <div class="form-group">
                <label for="volumeHoraire">Volume horaire</label>
                <input value="${item.volumeHoraire}" type="number" name="volumeHoraire" id="volumeHoraire" placeholder="Volume horaire" required>
            </div>

            <div class="form-buttons">
                <button type="submit" class="btn btn-primary">Modifier</button>
                <a href="/cours/lister" class="btn btn-secondary">Annuler</a>
            </div>
        </form>
    </section>
</main>
</body>
</html>
