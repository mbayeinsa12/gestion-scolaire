<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="sn.isep.dbe.modele.Cours" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un Cours</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<header>
    <h1>Système de gestion scolaire</h1>
    <nav>
        <ul>
            <li><a href="/accueil">Accueil</a></li>
            <li><a href="/etudiants/lister">Etudiants</a></li>
            <li><a href="/cours/lister" class="active">Cours</a></li>
            <li><a href="/filieres/lister">Filières</a></li>
            <li><a href="/notes/lister">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="form-container">
        <h2>Ajouter un nouveau cours</h2>

        <form action="/cours/ajouter" method="post">
            <div class="form-group">
                <label for="code">Code</label>
                <input type="text" name="code" id="code" placeholder="Code" required>
            </div>

            <div class="form-group">
                <label for="nom">Nom</label>
                <input type="text" name="nom" id="nom" placeholder="Nom" required>
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <textarea name="description" id="description" placeholder="Description du cours" rows="4"></textarea>
            </div>


            <div class="form-group">
                <label for="volumeHoraire">Volume Horaire</label>
                <input type="number" name="volumeHoraire" id="volumeHoraire" placeholder="Volume Horaire" required>
            </div>


            <div class="form-group">
                <label for="filiereId">Filière</label>
                <select name="filiereId" id="filiereId">
                    <c:forEach items="${filieres}" var="filiere">
                        <option value="${filiere.id}">${filiere.nom}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-buttons">
                <button type="submit" class="btn btn-primary">Ajouter</button>
                <a href="/cours/lister" class="btn btn-secondary">Annuler</a>
            </div>
        </form>
    </section>
</main>
</body>
</html>
