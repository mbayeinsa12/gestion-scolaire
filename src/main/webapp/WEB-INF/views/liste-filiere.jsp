<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="sn.isep.dbe.modele.Filiere" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: alndiaye
  Date: 30-04-2025
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">

</head>
<body>
<header>
  <h1>Système de gestion scolaire</h1>
  <nav>
    <ul>
      <li><a href="/accueil">Accueil</a></li>
      <li><a href="">Etudiants</a></li>
      <li><a href="">Cours</a></li>
      <li><a href="" class="active">Filières</a></li>
      <li><a href="">Notes</a></li>
    </ul>
  </nav>
</header>

<main>
  <section class="student-list">
    <div class="list-header">
      <h2>Liste des filières</h2>
      <a href="/filieres/ajouter" class="btn">+ Nouvelle filière</a>
    </div>

    <table>
      <thead>
      <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Département</th>
        <th>Responsable</th>
        <th>Capacité</th>
      </tr>
      </thead>

      <tbody>
<%--
      <%
        ArrayList<Filiere> filieres = (ArrayList<Filiere>) request.getAttribute("filieres");
        for (Filiere filiere: filieres) {
          %>

      <tr>
        <td><%=filiere.getId()%></td>
        <td><%=filiere.getCode()%></td>
        <td><%=filiere.getNom()%></td>
        <td><%=filiere.getPrenomResponsable()%> <%=filiere.getNomResponsable()%></td>
        <td><%=filiere.getCapacite()%></td>
      </tr>

      <% }%>--%>

      <c:forEach items="${filieres}" var="filiere">
        <tr>
          <td>${filiere.id}</td>
          <td>${filiere.code}</td>
          <td>${filiere.nom}</td>
          <td>${filiere.prenomResponsable} ${filiere.nomResponsable}</td>
          <td>${filiere.capacite}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </section>
</main>
</body>
</html>
