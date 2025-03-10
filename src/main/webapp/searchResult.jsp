<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Notes App</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
<nav>
  <ul>
    <li><a href="index.html">Home</a></li>
    <li><a href="AddNote.jsp">Add Note</a></li>
    <li><a href="AllNotes.jsp">All Notes</a></li>
    <li><a href="SearchNotes.jsp">Search Notes</a></li>
  </ul>
</nav>
<jsp:include page="/header.jsp"/>
<div>
  <h1>Search Results</h1>
  <%
    List<String> title = (List<String>) request.getAttribute("title");
    List<String> notes = (List<String>) request.getAttribute("notes");
    if (notes != null && !notes.isEmpty()) {
  %>
  <table>
    <thead>
    <tr>
      <th>Title</th>
      <th>Notes</th>
    </tr>
    </thead>
    <tbody>
    <%
      for (int i = 0; i < notes.size(); i++) {
    %>
    <tr>
      <td><%= title.get(i) %></td>  <!-- FIXED: Get corresponding title -->
      <td><%= notes.get(i) %></td>
    </tr>
    <% } %>
    </tbody>
  </table>
  <%
  } else {
  %>
  <p>Nothing found</p>
  <%
    }
  %>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>