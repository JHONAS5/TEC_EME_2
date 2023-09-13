
package com.emergentes.controlador;

import com.emergentes.produ;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String op = request.getParameter("op");
        produ objper = new produ();
        int id,pos;
        
        HttpSession ses = request.getSession();
        ArrayList<produ> lista = (ArrayList<produ>)ses.getAttribute("listaper");
        
        
        switch (op) {
            case "nuevo":
                //Enviar un objeto vacio a editar
                request.setAttribute("miobjper", objper);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                //Enviar un objeto a editar pero con contenido
                id=Integer.parseInt(request.getParameter("id"));
                //Averiguar la posicion del elemnto en la lista
                pos = buscarPorIndice(request, id);
                //obtener el objeto
                objper = lista.get(pos);
                request.setAttribute("miobjper", objper);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                //Enviar un registro de la coleccion segun el id
                id=Integer.parseInt(request.getParameter("id"));
                //Averiguar la posicion del elemnto en la lista
                pos = buscarPorIndice(request, id);
                if (pos >= 0){
                    lista.remove(pos);
                }
                request.setAttribute("listaper", lista);
                response.sendRedirect("index.jsp");
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList<produ> lista = (ArrayList<produ>) ses.getAttribute("listaper");
        produ objper =new produ();
        objper.setId(id);
        objper.setDescripcion(request.getParameter("descripcion"));
        objper.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        objper.setPrecio(Double.parseDouble(request.getParameter("precio")));
        objper.setCategoria(request.getParameter("categoria"));
        if(id == 0){
            //Nuevo registro
            int idNuevo =obtenerId(request);
            objper.setId(idNuevo);
            lista.add(objper);
        }
        else{
            //edicion de registro
            int pos = buscarPorIndice(request, id);
            lista.set(pos, objper);
        }
        request.setAttribute ("listaper", lista);
        response.sendRedirect("index.jsp");
    }
    
        public int buscarPorIndice(HttpServletRequest request, int id){
        HttpSession ses = request.getSession();
        ArrayList<produ> lista = (ArrayList<produ>) ses.getAttribute("listaper");
        
        int pos = -1;
        
        if (lista != null){
            for(produ ele : lista){
                ++pos;
                if(ele.getId()==id){
                    break;
                }
            }
            }
        return pos;
    }
    
    public int obtenerId(HttpServletRequest request){
        HttpSession ses =request.getSession();
        ArrayList<produ> lista = (ArrayList<produ>) ses.getAttribute("listaper");
        //buscar el ultimo Id
        int idn =0;
        for (produ ele : lista){
            idn = ele.getId();
        }
        return idn +1;
    }

}
