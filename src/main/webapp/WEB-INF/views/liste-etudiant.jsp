<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="sn.isep.dbe.modele.Etudiant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des étudiants</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<header>
    <h1>Système de gestion scolaire</h1>
    <nav>
        <ul>
            <li><a href="/accueil">Accueil</a></li>
            <li><a href="" class="active">Etudiants</a></li>
            <li><a href="/cours/lister">Cours</a></li>
            <li><a href="/filieres/lister">Filières</a></li>
            <li><a href="/notes/lister">Notes</a></li>
        </ul>
    </nav>
</header>

<main>
    <section class="student-list">
        <div class="list-header">
            <h2>Liste des étudiants</h2>
            <a href="/etudiants/ajouter" class="btn">+ Nouvel étudiant</a>
        </div>

        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Email</th>
                <th>Téléphone</th>
                <th>Carte Étudiant</th>
                <th>Actions</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${etudiants}" var="etudiant">
                <tr>
                    <td>${etudiant.id}</td>
                    <td>${etudiant.nom}</td>
                    <td>${etudiant.prenom}</td>
                    <td>${etudiant.email}</td>
                    <td>${etudiant.telephone}</td>
                    <td>${etudiant.carteEtudiant}</td>
                    <td class="actions">
                        <a class="btn-details" href="/etudiants/details?id=${etudiant.id}">Détails</a>
                        <a href="${pageContext.request.contextPath}/etudiants/modifier?id=${etudiant.id}" class="btn-edit">Modifier</a>
                        <a class="btn-delete" href="/etudiants/supprimer?id=${etudiant.id}">Supprimer</a>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>
</body>
</html>
