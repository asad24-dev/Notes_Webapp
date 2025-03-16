<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>All Notes</title>
    <link rel="stylesheet" href="styles.css">
    <script src="script.js"></script>
</head>


<body>
<nav>
    <ul>
        <li><a href="index.html">Home</a></li>
        <li><a href="AddNote.jsp">Add Note</a></li>
        <li><a href="allnotes.html?category=">All Notes</a></li>
        <li><a href="search.html">Search Notes</a></li>
        <button id="dark-mode-toggle">🌙 Toggle Dark Mode</button>
    </ul>
</nav>

<h1>All Notes</h1>


<form action="allnotes.html" method="GET">
    <label for="category">Filter by Category:</label>
    <select name="category" id="category">
        <option value="">All Categories</option>
        <option value="todolist" <%= "todo".equals(request.getAttribute("selectedCategory")) ? "selected" : "" %>>To-Do List</option>
        <option value="note" <%= "text".equals(request.getAttribute("selectedCategory")) ? "selected" : "" %>>Text Note</option>
        <option value="Reminder" <%= "reminder".equals(request.getAttribute("selectedCategory")) ? "selected" : "" %>>Reminders</option>
    </select>
    <button type="submit">Filter</button>
</form>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Category</th>
        <th>Title</th>
        <th>Actions</th>
    </tr>
    <%
        List<List<String>> notes = (List<List<String>>) request.getAttribute("notes");
        if (notes != null && !notes.isEmpty()) {
            for (List<String> note : notes) {
    %>
    <tr>
        <td><%= note.get(0) %></td>
        <td><%= note.get(1) %></td>
        <td><%= note.get(2) %></td>
        <td>
            <a href="viewnote.html?id=<%= note.get(0) %>">View</a> |
            <a href="editNote.jsp?id=<%= note.get(0) %>">Edit</a> |
            <a href="deletenote.jsp?id=<%= note.get(0) %>">Delete</a>
        </td>
    </tr>
    <% } } else { %>
    <tr><td colspan="4">No notes found.</td></tr>
    <% } %>
</table>

<button onclick="window.location.href='AddNote.jsp';">Add Notes</button>


</body>
</html>
