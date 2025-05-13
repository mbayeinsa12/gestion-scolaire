<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="sn.isep.dbe.modele.Note" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des Notes</title>
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
            <li><a href="" class="active">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="note-list">
        <div class="list-header">
            <h2>Liste des Notes</h2>
            <a href="/notes/ajouter" class="btn">+ Nouvelle Note</a>
        </div>

        <table>
            <thead>
            <tr>
                <th>ID Etudiant</th>
                <th>ID Cours</th>
                <th>Valeur</th>
                <th>Actions</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${notes}" var="note">
                <tr>
                    <td>${note.idEtudiant}</td>
                    <td>${note.idCours}</td>
                    <td>${note.valeur}</td>
                    <td class="actions">
                        <a class="btn-details" href="/notes/details?id=${note.id}">Détails</a>
                        <a href="/notes/modifier?id=${note.id}" class="btn-edit">Modifier</a>
                        <a href="/notes/supprimer?id=${note.id}" class="btn-delete">Supprimer</a>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>
</body>
</html>
