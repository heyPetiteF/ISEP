package com.webapp;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class DatabaseServlet extends HttpServlet {
    private static final String url = "jdbc:postgresql://localhost/company";
    private static final String user = "postgres";
    private static final String pass = "123456";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Database Result</title>");
            out.println("</head>");
            out.println("<body>");


            try {
                Class.forName("org.postgresql.Driver");
                try (Connection conn = DriverManager.getConnection(url, user, pass)) {
                    Statement statement = conn.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM emp");
                    while (rs.next()) {
                        out.println("<p>" + rs.getString("ename") + "</p>");
                    }
                }
            } catch (Exception e) {
                out.println("<p>Error: " + e.getMessage() + "</p>");
                e.printStackTrace();
            }

            out.println("</body>");
            out.println("</html>");
        }
    }
}
