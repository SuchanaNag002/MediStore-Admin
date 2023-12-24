<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Dashboard</title>
</head>
<body>
    <h1>Welcome to Your Patient Dashboard</h1>
    
    
    <div>
        <% 
            com.Modals.Patient patient = (com.Modals.Patient) request.getSession().getAttribute("patient");
            if(patient != null) {
                out.println("<p>Your email: " + patient.getEmail() + "</p>");
            } else {
                out.println("<p>Email not available</p>");
            }
        %>
        <a href="medStore.jsp" class="store-button">Go to Store</a>
    </div>
    
    <!-- Other content of the dashboard -->
    
</body>
</html>
