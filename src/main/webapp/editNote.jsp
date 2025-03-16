<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.Model" %>
<%@ page import="uk.ac.ucl.model.ModelFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
        <li><a href="allnotes.html?category=">All Notes</a></li>
        <li><a href="search.html">Search Notes</a></li>
        <button id="dark-mode-toggle">🌙 Toggle Dark Mode</button>
    </ul>
</nav>

<div class="main">
    <h1>Edit Note</h1>
    <%
        // Retrieve the note ID from the URL
        String noteId = request.getParameter("id");
        // Check if ID is present
        if (noteId != null) {
            Model model = ModelFactory.getModel();
            // Retrieve the note details using the ID
            List<String> noteDetails = model.getNoteById(Integer.parseInt(noteId));
            if (noteDetails != null) {
                String noteTitle = noteDetails.size() > 1 ? noteDetails.get(0) : "";
                String noteCategory = noteDetails.size() > 2 ? noteDetails.get(1) : "";
                String noteContent = noteDetails.size() > 3 ? noteDetails.get(2) : "";
                String noteUrl = noteDetails.size() > 4 ? noteDetails.get(3) : "";
                String imageUrl = noteDetails.size() > 5 ? noteDetails.get(4) : "";
    %>

    <!-- Form for editing the note -->
    <form action="edit-note.html" method="post">
        <input type="hidden" name="id" value="<%= noteId %>">

        <label for="title">Title:</label>
        <input type="text" id="title" name="title" value="<%= noteTitle %>" required>

        <label for="category">Category:</label>
        <select id="category" name="category">
            <option value="note">Note</option>
            <option value="todolist">To-Do List</option>
            <option value="Reminder">Reminder</option>
        </select>

        <label for="content">Content:</label>
        <textarea id="content" name="content" rows="5" required><%= noteContent %></textarea>

        <label for="url">URL:</label>
        <textarea id="url" name="url" rows="5"><%= noteUrl %></textarea>

        <label for="image-url">Image URL:</label>
        <textarea id="image-url" name="image-url" rows="5"><%= imageUrl %></textarea>

        <button type="submit">Save Changes</button>
    </form>

    <%
            } else {
                out.println("<p>Error: Note not found.</p>");
            }
        } else {
            out.println("<p>Error: No note ID provided.</p>");
        }
    %>
</div>
</body>
</html>