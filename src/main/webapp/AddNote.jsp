<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.Model" %>
<%@ page import="uk.ac.ucl.model.ModelFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Add List</title>
</head>
<body>
<div class="main">
  <h2>Add list:</h2>
  <form action="add-note.html" method="post">
    <label for="title">Enter Title:</label><br>
    <input type="text" id="title" name="title" required/><br>    <!-- list name, required! -->
    <label for="note_text">Enter contents:</label><br>
    <input type="text" id="note_text" name="note_text"/><br>             <!-- text content -->
<%--    <label for="url">Enter a URL:</label><br>--%>
<%--    <input type="url" id="url" name="url"/><br>                          <!-- url content -->--%>
<%--    <label for="image_url">Enter an image url:</label><br>--%>
<%--    <input type="url" id="image_url" name="image_url"/><br>              <!-- image content -->--%>

<%--    <label for="lists_available">Choose a list to link:</label><br>--%>
<%--    <select id="lists_available" name="lists_available">--%>
<%--      <option value="">None</option>--%>
<%--      <%--%>
<%--        Model model = ModelFactory.getModel();--%>
<%--        List<String> list_names = model.getListNames();--%>
<%--        List<Integer> list_ids = model.getListIds();--%>
<%--        for (int i = 0; i < list_names.size(); i++)--%>
<%--        {--%>
<%--          //drop-down menu shows all lists available to be linked to the current list--%>
<%--      %>--%>
<%--      <option value=<%=list_ids.get(i)%>><%=list_ids.get(i) + ")" + " " + list_names.get(i)%></option> &lt;%&ndash; value = list ID &ndash;%&gt;--%>
<%--      <%}%>--%>
<%--    </select>--%>
    <div></div>
    <br>
    <input type = "submit" value="Submit">
  </form>
</div>
</body>
</html>