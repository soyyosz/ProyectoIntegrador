<%-- 
    Document   : frmUsuarios
    Created on : 3/07/2017, 05:21:38 PM
    Author     : Laura Arvizu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${titulo}</h1>
       
        
        <ul>
                            <li><a href="../usuarios">Usuarios</a></li>
                            <li><a href="../productos">Productos</a></li>
                            <li><a href="../salir">Cerrar Sesion</a></li>                            
                        </ul>
        
        <br>
        <br>
        <form action="$(action)" method="POST">
            <label>Usuario</label><input type="text" name="usuario" value="${bean.usuario}"/>
            <br>
            <label>Password</label><input type="text" name="password" value="${bean.password}"/>
            <br>
            <label>Rol Asignado</label>
            <select name="roles">
                
   
                
                <c:forEach var="rol" items="${roles}">
                    <option value="${rol.idRol}" <c:if test="${usuario.IdRol==rol.IdRol}">selected=""</c:if>${rol.rol}</option>
                </c:forEach>
                    
                    <input type="button" value="GUARDAR" name="btnGuardar" />
        </form>
    </body>
</html>
