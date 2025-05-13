<%--
  Created by IntelliJ IDEA.
  User: BBD
  Date: 12/05/2025
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <title>Title</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
            <h1>Détails Étudiant</h1>
            <p>Nom : ${etudiant.nom}</p>
            <p>Prénom : ${etudiant.prenom}</p>
            <p>Email : ${etudiant.email}</p>
            <p>Filière ID : ${etudiant.idFiliere}</p>
            <a href="${pageContext.request.contextPath}/etudiants/lister">Retour a la page suivant</a>

        </head>

        <body>

        </body>

        </html>