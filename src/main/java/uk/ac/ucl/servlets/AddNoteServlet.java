package uk.ac.ucl.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;


import java.io.IOException;


@WebServlet("/add-note.html")
public class AddNoteServlet extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        Model model = ModelFactory.getModel();
        int noteId = model.getNextId();
        String list_name = request.getParameter("title");
        String list_text = request.getParameter("note_text");
        String url = request.getParameter("url");
        String imageurl = request.getParameter("image_url");
        String category = request.getParameter("category");

        model.writeToCsv(noteId, category, list_name, list_text, url, imageurl);

        // Invoke the JSP page.
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/NoteUpdated.jsp");
        dispatch.forward(request, response);
    }
}
