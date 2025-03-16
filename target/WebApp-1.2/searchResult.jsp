<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Notes App</title>
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

<div>
  <h1>Search Results</h1>
  <%
    List<String> id = (List<String>) request.getAttribute("Index");
    List<String> title = (List<String>) request.getAttribute("Title");
    if (id != null && !id.isEmpty()) {
  %>
  <table>
    <thead>
    <tr>
      <th>Index</th>
      <th>Title</th>
      <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
      for (int i = 0; i < id.size(); i++) {
    %>
    <tr>
      <td><%= id.get(i) %></td>  <!-- FIXED: Get corresponding title -->
      <td><%= title.get(i) %></td>
      <td>
        <a href="editNote.jsp?id=<%= id.get(i) %>">Edit</a> |
        <a href="viewnote.html?id=<%= id.get(i) %>">View</a> |
        <a href="deletenote.jsp?id=<%= id.get(i) %>">Delete</a>
      </td>
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
</body>
</html>