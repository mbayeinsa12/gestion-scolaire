<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="sn.isep.dbe.modele.Cours" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des Cours</title>
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
    <section class="course-list">
        <div class="list-header">
            <h2>Liste des Cours</h2>
            <a href="/cours/ajouter" class="btn">+ Nouveau Cours</a>
        </div>

        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Code</th>
                <th>Nom</th>
                <th>Description</th>
                <th>Volume Horaire</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${cours}" var="cours">
                <tr>
                    <td>${cours.id}</td>
                    <td>${cours.code}</td>
                    <td>${cours.nom}</td>
                    <td>${cours.description}</td>
                    <td>${cours.volumeHoraire}</td>

                    <td class="actions">
                        <a href="${pageContext.request.contextPath}/cours/details?id=${cours.id}" class="btn-details">Détails</a>
                        <a href="${pageContext.request.contextPath}/cours/modifier?id=${cours.id}" class="btn-edit">Modifier</a>
                        <a href="${pageContext.request.contextPath}/cours/supprimer?id=${cours.id}" class="btn-delete">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>
</body>
</html>
