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
import uk.ac.ucl.model.Notes;


import java.io.IOException;
import java.util.List;

// The servlet invoked to perform a search.
// The url http://localhost:8080/runsearch.html is mapped to calling doPost on the servlet object.
// The servlet object is created automatically, you just provide the class.
@WebServlet("/add-note.html")
public class AddNoteServlet extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Use the model to do the search and put the results into the request object sent to the
        // Java Server Page used to display the results.
        Model model = ModelFactory.getModel();
        int noteId = model.getNextId();
        String list_name = request.getParameter("title");
        String list_text = request.getParameter("note_text");
//        Notes note = new Notes();
//        note.setId(noteId);
//        note.setName(list_name);
//        note.setText(list_text);
        model.writeToCsv(noteId, list_name, list_text);

//        List<String> searchResult = model.searchFor(request.getParameter("searchstring"));
//        request.setAttribute("result", searchResult);

        // Invoke the JSP page.
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/NoteUpdated.jsp");
        dispatch.forward(request, response);
    }
}
