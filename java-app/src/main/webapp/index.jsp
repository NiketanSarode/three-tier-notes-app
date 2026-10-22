<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><title>Simple Notes App</title></head>
<body style="font-family: Arial; margin: 40px;">
    <h2>Simple Three-Tier Notes App (Docker Compose)</h2>
    <form action="notes" method="post">
        <input type="text" name="content" placeholder="Enter a note..." required>
        <button type="submit">Add Note</button>
    </form>
    <h3>All Notes:</h3>
    <ul>
        <c:forEach var="note" items="${notes}">
            <li><c:out value="${note}" /></li>
        </c:forEach>
    </ul>
</body>
</html>
