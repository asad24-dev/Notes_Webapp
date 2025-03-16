<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>View Note</title>
    <link rel="stylesheet" href="styles.css">
    <script src="script.js"></script>
</head>
<body>
<nav>
    <ul>
        <li><a href="index.html">Home</a></li>
        <li><a href="allnotes.html?category=">All Notes</a></li>
        <button id="dark-mode-toggle">🌙 Toggle Dark Mode</button>
    </ul>
</nav>

<h1>View Note</h1>

<% String error = (String) request.getAttribute("error"); %>
<% if (error != null) { %>
<p style="color: red;"><%= error %></p>
<% } else { %>
<p><strong>ID:</strong> <%= request.getAttribute("id") %></p><br>
<p><strong>Category:</strong> <%= request.getAttribute("category") %></p><br>
<p><strong>Title:</strong> <%= request.getAttribute("title") %></p><br>

<p><strong>Content:</strong></p>
<p><%= request.getAttribute("content") %></p>

<% String url = (String) request.getAttribute("url"); %>
<% if (url != null && !url.isEmpty()) { %>
<p><strong>URL:</strong> <a href="<%= url %>" target="_blank"><%= url %></a></p>
<% } %>

<% String image_url = (String) request.getAttribute("image_url"); %>
<% if (image_url != null && !image_url.isEmpty()) { %>
<p><strong>Image:</strong></p>
<img src="<%= image_url %>" alt="Note Image" style="max-width: 400px;"/>
<% } %>
<% } %>

</body>
</html>
