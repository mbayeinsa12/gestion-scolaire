<%--
  Created by IntelliJ IDEA.
  User: BBD
  Date: 12/05/2025
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
    <title>Title</title>
    <h1>Détails Cours</h1>
    <p>Nom : ${cours.nom}</p>
    <p>Description : ${cours.description}</p>
    <a href="${pageContext.request.contextPath}/cours/lister">Retour</a>

</head>
<body>

</body>
</html>
