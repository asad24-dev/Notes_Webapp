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


@WebServlet("/delete-note.html")
public class DeleteNoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get ID from request
        int id = Integer.parseInt(request.getParameter("id"));

        // Call model to delete the note
        Model model = new Model();
        model.deleteNote(id);

        // Redirect to all notes page
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/NoteUpdated.jsp");
        dispatch.forward(request, response);// Redirect to the notes list after editing
    }
}