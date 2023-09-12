<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.Tarea"%>
<%  
    if (session.getAttribute("listaper")==null){
        ArrayList<Tarea> lisaux = new ArrayList<Tarea>();
        session.setAttribute("listaper", lisaux);
    }
    ArrayList<Tarea> lista = (ArrayList<Tarea>) session.getAttribute("listaper");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>GESTOR DE TAREAS</h1>
        <h1>Nombre: Jhonatan Arenas Gutierrez</h1>
        <a href="MainServlet?op=nuevo">Nuevo Registro</a>
        <table>
            <tr>
                <th>ID</th>
                <th>Tarea</th>
                <th>Completado</th>
                <th></th>
                <th></th>
            </tr>
            <%
            if (lista != null){
                for(Tarea item : lista){             
            %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getTipo() %></td>
                <td><input type="checkbox" id="compl" value="first_checkbox" /></td>
                <td>
                    <a href="MainServlet?op=editar&id=<%= item.getId() %>">Editar</a>
                </td>
                <td>
                    <a href="MainServlet?op=eliminar&id=<%= item.getId() %>"
                    onclick="return(confirm('Esta seguro de eliminar??'))"
                    >Eliminar</a>
                </td>
            </tr>
            <%
                }
                }
            %>

        </table>
    </body>
</html>
