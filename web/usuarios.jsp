<%-- 
    Document   : usuarios
    Created on : 14/06/2017, 08:28:37 PM
    Author     : Laura Arvizu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
    </head>
    
    <body>
        
    <center>
        <h1>Listado de usuarios</h1>
        <table border="0">
            <tbody>
                <tr>
                    <td>
                        <ul>
                            <li><a href="usuarios">Usuarios</a></li>
                            <li><a href="productos">Productos</a></li>
                            <li><a href="salir">Cerrar Sesión</a></li>                            
                        </ul>
                    </td>
                    <td>
                         <input type="button" value="AGREGAR" name="btnAgregar" onclick=".href = 'usuarios/agregar'"/>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>USUARIO</th>
                                    <th>ROL ASIGNADO</th>
                                    <th>ESTATUS</th>
                                    <th>OPCIONES</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="dato" items="${listado}">   
                                    <tr>
                                        <td>${dato.usuario}</td>
                                        <td>${dato.rolDelUsuario.rol}</td>
                                        <td>${dato.estatus}</td>
                                        <td>
                                            <input type="button" onclick="location.href = 'usuario/editar?usuario=${dato.usuario}'" value="EDITAR" name="btnEditar" />
                                            <input type="button" value="BORRAR" name="btnBorrar" />
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </td>
                </tr>
            </tbody>
        </table>  

    </center>
</body>
</html>
