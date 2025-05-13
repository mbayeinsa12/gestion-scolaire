<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Détails de la note</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<h2>Détails de la note</h2>

<p><strong>ID :</strong> ${note.id}</p>
<p><strong>Valeur :</strong> ${note.valeur}</p>
<p><strong>ID Étudiant :</strong> ${note.idEtudiant}</p>
<p><strong>ID Cours :</strong> ${note.idCours}</p>

<a href="${pageContext.request.contextPath}/notes/lister">Retour à la liste</a>
</body>
</html>
