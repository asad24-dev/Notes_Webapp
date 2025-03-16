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

@WebServlet("/allnotes.html")
public class AllNotesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();

        // Get category from request
        String category = request.getParameter("category");


        // Get all notes filtered by category
        List<List<String>> notes = model.filterNotesByCategory(category);
        request.setAttribute("notes", notes);
        request.setAttribute("selectedCategory", category);

        // Forward to JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/AllNotes.jsp");
        dispatcher.forward(request, response);
    }
}
