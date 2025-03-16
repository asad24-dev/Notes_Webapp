package uk.ac.ucl.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import java.io.IOException;
import java.util.List;

@WebServlet("/viewnote.html")
public class ViewNoteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the ID from the request parameter
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            response.sendRedirect("AllNotes.jsp"); // Redirect if no ID is provided
            return;
        }

        int id = Integer.parseInt(idParam);

        // Fetch note from Model
        Model model = ModelFactory.getModel();
        List<String> note = model.getNoteById(id);

        if (note == null || note.isEmpty()) {
            request.setAttribute("error", "Note not found.");
        } else {
            request.setAttribute("id", id);
            request.setAttribute("category", note.get(0));
            request.setAttribute("title", note.get(1));
            request.setAttribute("content", note.get(2));
            request.setAttribute("url", note.size() > 3 ? note.get(3) : ""); // Optional URL
            request.setAttribute("image_url", note.size() > 4 ? note.get(4) : ""); // Optional image
        }

        // Forward to JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewnote.jsp");
        dispatcher.forward(request, response);
    }
}
