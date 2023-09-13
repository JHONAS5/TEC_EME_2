<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.produ"%>
<%  
    if (session.getAttribute("listaper")==null){
        ArrayList<produ> lisaux = new ArrayList<produ>();
        session.setAttribute("listaper", lisaux);
    }
    ArrayList<produ> lista = (ArrayList<produ>) session.getAttribute("listaper");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <div style="text-align:center;">
        
        <table border="2" style="margin: 0 auto;" bordercolor="red">
            <tr>
                 <th>
                    <h1 style="color:blue;">SEGUNDO PARCIAL TEM-742</h1>
                    <h2 style="color:blue;">Nombre: Jhonatan Arenas Gutierrez</h2>
                    <h2 style="color:blue;">Carnet: 9973552</h2>
                </th>
            </tr>
        </table>
        <h1 >GESTION DE PRODUCTOS</h1><br>
        <a href="MainServlet?op=nuevo" style="color:red;">Nuevo Registro</a>
        <table border="2" style="margin: 0 auto;" bordercolor="blue" >
            <tr BGCOLOR="sky blue">
                <th style="color:red;">ID</th>
                <th style="color:red;">Descripcion</th>
                <th style="color:red;">Cantidad</th>
                <th style="color:red;">Precio</th>
                <th style="color:red;">Categoria</th>
                <th style="color:red;"></th>
                <th style="color:red;"></th>
            </tr>
            <%
            if (lista != null){
                for(produ item : lista){             
            %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getDescripcion()%></td>
                <td><%= item.getCantidad()%></td>
                <td><%= item.getPrecio()%></td>
                <td><%= item.getCategoria()%></td>
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
    </div>
</html>
