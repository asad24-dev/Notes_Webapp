<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.Model" %>
<%@ page import="uk.ac.ucl.model.ModelFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  int id = Integer.parseInt(request.getParameter("id"));
%>
<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Add List</title>
  <link rel="stylesheet" href="styles.css">
  <script src="script.js"></script>
</head>

<body>
<nav>
  <ul>
    <li><a href="index.html">Home</a></li>
    <li><a href="AddNote.jsp">Add Note</a></li>
    <li><a href="AllNotes.jsp">All Notes</a></li>
    <li><a href="search.html">Search Notes</a></li>
    <button id="dark-mode-toggle">🌙 Toggle Dark Mode</button>
  </ul>
</nav>

<div class="main">
  <h1>Are you sure you want to delete this note?</h1>
  <form action="delete-note.html" method="post">
    <input type="hidden" name="id" value="<%= id %>">
    <button type="submit">Yes, Delete</button><br><br>
    <a href="index.html">Cancel</a>
  </form>
</div>
</body>
</html>