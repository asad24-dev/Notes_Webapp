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
  <h2>Add Note:</h2>
  <form action="add-note.html" method="post">
    <label for="title">Enter Title:</label><br>
    <input type="text" id="title" name="title" required/><br>
    <label for="note_text">Enter contents:</label><br>
    <input type="text" id="note_text" name="note_text"/><br>
    <label for="url">Enter a URL:</label><br>
    <input type="text" id="url" name="url"/><br>
    <label for="image_url">Enter an image url:</label><br>
    <input type="text" id="image_url" name="image_url"/><br>
    <label for="category">Choose a category:</label><br>
    <select id="category" name="category">
      <option value="note">Note</option>
      <option value="todolist">To-Do List</option>
      <option value="Reminder">Reminder</option>
    </select>
    <div></div>
    <br>
    <input type = "submit" value="Submit">
  </form>
</div>
</body>
</html>