<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Détails de la filière</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<h2>Détails de la filière</h2>
<p><strong>Code :</strong> ${filiere.code}</p>
<p><strong>Nom :</strong> ${filiere.nom}</p>
<p><strong>Département :</strong> ${filiere.departement}</p>
<p><strong>Nom du responsable :</strong> ${filiere.nomResponsable}</p>
<p><strong>Prénom du responsable :</strong> ${filiere.prenomResponsable}</p>
<p><strong>Capacité :</strong> ${filiere.capacite}</p>

<a href="lister-filiere">Retour à la liste</a>
</body>
</html>
