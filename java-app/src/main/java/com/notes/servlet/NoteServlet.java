package com.notes.servlet;
import com.notes.util.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/notes")
public class NoteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> notes = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT content FROM notes")) {
            while (rs.next()) {
                notes.add(rs.getString("content"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("notes", notes);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("content");
        if (content != null && !content.trim().isEmpty()) {
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement("INSERT INTO notes (content) VALUES (?)")) {
                pstmt.setString(1, content);
                pstmt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("notes");
    }
}
