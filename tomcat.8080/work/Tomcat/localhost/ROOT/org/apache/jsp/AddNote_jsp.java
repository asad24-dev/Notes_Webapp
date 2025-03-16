/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/11.0.4
 * Generated at: 2025-03-16 17:10:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.List;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

public final class AddNote_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(4);
    _jspx_imports_classes.add("uk.ac.ucl.model.Model");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("uk.ac.ucl.model.ModelFactory");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/meta.jsp", out, false);
      out.write("\r\n");
      out.write("  <title>Add List</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles.css\">\r\n");
      out.write("    <script src=\"script.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<nav>\r\n");
      out.write("    <ul>\r\n");
      out.write("        <li><a href=\"index.html\">Home</a></li>\r\n");
      out.write("        <li><a href=\"AddNote.jsp\">Add Note</a></li>\r\n");
      out.write("        <li><a href=\"AllNotes.jsp\">All Notes</a></li>\r\n");
      out.write("        <li><a href=\"search.html\">Search Notes</a></li>\r\n");
      out.write("        <button id=\"dark-mode-toggle\">🌙 Toggle Dark Mode</button>\r\n");
      out.write("    </ul>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<div class=\"main\">\r\n");
      out.write("  <h2>Add Note:</h2>\r\n");
      out.write("  <form action=\"add-note.html\" method=\"post\">\r\n");
      out.write("    <label for=\"title\">Enter Title:</label><br>\r\n");
      out.write("    <input type=\"text\" id=\"title\" name=\"title\" required/><br>\r\n");
      out.write("    <label for=\"note_text\">Enter contents:</label><br>\r\n");
      out.write("    <input type=\"text\" id=\"note_text\" name=\"note_text\"/><br>\r\n");
      out.write("    <label for=\"url\">Enter a URL:</label><br>\r\n");
      out.write("    <input type=\"text\" id=\"url\" name=\"url\"/><br>\r\n");
      out.write("    <label for=\"image_url\">Enter an image url:</label><br>\r\n");
      out.write("    <input type=\"text\" id=\"image_url\" name=\"image_url\"/><br>\r\n");
      out.write("    <label for=\"category\">Choose a category:</label><br>\r\n");
      out.write("    <select id=\"category\" name=\"category\">\r\n");
      out.write("      <option value=\"note\">Note</option>\r\n");
      out.write("      <option value=\"todolist\">To-Do List</option>\r\n");
      out.write("      <option value=\"Reminder\">Reminder</option>\r\n");
      out.write("    </select>\r\n");
      out.write("    <div></div>\r\n");
      out.write("    <br>\r\n");
      out.write("    <input type = \"submit\" value=\"Submit\">\r\n");
      out.write("  </form>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
