/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.bean.RolBean;
import modelo.bean.UsuarioBean;
import modelo.dao.RolDao;
import modelo.dao.UsuarioDao;

/**
 *
 * @author Laura Arvizu
 */
@WebServlet(name = "CtrlUsuario", urlPatterns = {"/usuarios", "/usuarios/editar", "/usuarios/agregar", "/usuarios/borrar"})
public class CtrlUsuario extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rutaUser = request.getServletPath();
        if (rutaUser.equalsIgnoreCase("/usuarios")) {
            List listado = new ArrayList<UsuarioBean>();
            try {
                listado = UsuarioDao.listar();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("listado", listado);
            request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        } else if (rutaUser.equalsIgnoreCase("/usuario/editar")) {
            String usuario = request.getParameter("usuario");
            if (!usuario.isEmpty()) {
                try {
                    UsuarioBean u = UsuarioDao.consultar(usuario);
                    if (u != null) {
                        request.setAttribute("titulo", "Consultar Usuarios");
                        request.setAttribute("action", "usuarios/editar");
                        request.setAttribute("roles", RolDao.listar());
                        request.setAttribute("usuario", u);
                        request.getRequestDispatcher("../frmUsuarios.jsp").forward(request, response);
                    } else {
                        //No existe el usuario
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CtrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (rutaUser.equalsIgnoreCase("/usuario/agregar")) {

            try {
                request.setAttribute("titulo", "Agregar Usuario");
                request.setAttribute("action", "usuarios/agregar");
                request.setAttribute("roles", RolDao.listar());
                request.setAttribute("usuario", new UsuarioBean());
                request.getRequestDispatcher("../frmUsuarios.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(CtrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rutaUser = request.getServletPath();
        
        UsuarioBean u = new UsuarioBean();

        switch (rutaUser) {
            case "/usuarios/editar":
                
                u.setUsuario(request.getParameter("usuario"));
                u.setPassword(request.getParameter("password"));
                u.setIdRol(Integer.parseInt(request.getParameter("roles")));
                u.setEstatus(true);
        {
            
            int r=-1;
            try {
                r = UsuarioDao.editar(u);
                if (r>0){
                    response.sendRedirect("../usuarios");
                }
                
            } catch (Exception ex) {
                Logger.getLogger(CtrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                
                
                
                break;
            case "/usuarios/agregar":
    
                u.setUsuario(request.getParameter("usuario"));
                u.setPassword(request.getParameter("password"));
                u.setIdRol(Integer.parseInt(request.getParameter("roles")));
                u.setEstatus(true);
        {
            
            int r=-1;
            try {
                r = UsuarioDao.agregar(u);
                if (r>0){
                    response.sendRedirect("../usuarios");
                }
                
            } catch (Exception ex) {
                Logger.getLogger(CtrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case "/usuarios/borrar":
                break;
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
