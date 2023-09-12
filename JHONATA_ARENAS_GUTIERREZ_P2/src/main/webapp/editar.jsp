<%@page import="com.emergentes.Tarea"%>
<%
    Tarea reg = (Tarea) request.getAttribute("miobjper");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <h1>Registro de Tareas</h1>
    <h1>Nombre: Jhonatan Arenas Gutierrez</h1>
        <form action="MainServlet" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id" value="<%= reg.getId() %>" size="2" readonly></td>
                </tr>
                <tr>
                    <td>Tarea</td>
                    <td><input type="text" name="tipo" value="<%= reg.getTipo() %>"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"  value="Enviar"></td>
                </tr>
            </table>
            
        </form>
</html>
