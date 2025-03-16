package uk.ac.ucl.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uk.ac.ucl.model.Model;


import java.io.IOException;


@WebServlet("/edit-note.html")
public class EditNoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String category = request.getParameter("category");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String URL = request.getParameter("url");
        String image = request.getParameter("image-url");

        Model model = new Model();
        model.editNote(id, category, title, content, URL, image);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/NoteUpdated.jsp");
        dispatch.forward(request, response);// Redirect to the notes list after editing
    }
}
