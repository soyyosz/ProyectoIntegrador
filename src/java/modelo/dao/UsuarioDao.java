/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.bean.RolBean;
import modelo.bean.UsuarioBean;
import modelo.conexion.Conexion;

/**
 *
 * @author Laura Arvizu
 */
public class UsuarioDao {
    
    public static List<UsuarioBean> listar() throws SQLException{
        List<UsuarioBean> lista = new ArrayList<>();
        Connection c = Conexion.getInstance().abrirConexion();
        PreparedStatement pst = c.prepareStatement("SELECT u.usuario, u.password, u.idRol,u.estatus, r.rol "
                + "FROM usuario u LEFT JOIN rol r ON u.idRol = r.idRol");
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            UsuarioBean u = new UsuarioBean();
            u.setUsuario(rs.getString("usuario"));
            u.setPassword(rs.getString("password"));
            u.setIdRol(rs.getInt("idRol"));
            u.setEstatus(rs.getBoolean("estatus"));
            u.setRolDelUsuario(new RolBean(u.getIdRol(),rs.getString("rol")));
            lista.add(u);
        }
        return lista;
    }
    public static UsuarioBean consultar(String usuario) throws SQLException{
        Connection c = Conexion.getInstance().abrirConexion();
        UsuarioBean u = null;
        PreparedStatement pst = c.prepareStatement("SELECT u.usuario, u.password, u.idRol,u.estatus, r.rol "
                + "FROM usuario u LEFT JOIN rol r ON u.idRol = r.idRol "
                + "WHERE u.usuario like ?");
        pst.setString(1, usuario);
        ResultSet rs = pst.executeQuery();
        String e = usuario;
        if(rs.next()){
            u = new UsuarioBean();
            u.setUsuario(rs.getString("usuario"));
            u.setPassword(rs.getString("password"));
            u.setEstatus(rs.getBoolean("estatus"));
            u.setIdRol(rs.getInt("idRol"));
            u.setRolDelUsuario(new RolBean(u.getIdRol(),rs.getString("rol")));
        }
        return u;
    }
    
    public static int editar(UsuarioBean u) throws SQLException, Exception{
        Connection c = Conexion.getInstance().abrirConexion();
        
        int reg = -1;
        
        PreparedStatement pst = c.prepareStatement("UPDATE usuario"
                + "SET password=?, idRol=?, estatus=? "
                + "WHERE usuario like ?");
        
        pst.setString(1, u.getPassword());
        pst.setInt(2, u.getIdRol());
        pst.setBoolean(3, u.isEstatus());
        pst.setString(4, u.getUsuario());
        
        reg = pst.executeUpdate();
        
        if(reg>0){
            return reg;
            
        } else {
            throw new Exception("Error al actualizar");
        }
        
    }
    
    public static int agregar(UsuarioBean u) throws SQLException, Exception{
        Connection c = Conexion.getInstance().abrirConexion();
        
        int reg = -1;
        
        PreparedStatement pst = c.prepareStatement("INSERT INTO usuario"
                + " VALUES  (?,?,?,?)");
                
        
        pst.setString(1, u.getUsuario());
        pst.setString(2, u.getPassword());
        pst.setInt(3, u.getIdRol());
        pst.setBoolean(4, u.isEstatus());
        
        reg = pst.executeUpdate();
        
        if(reg>0){
            return reg;
            
        } else {
            throw new Exception("Error al actualizar");
        }
        
    }
}
