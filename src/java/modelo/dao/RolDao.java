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
import modelo.conexion.Conexion;

/**
 *
 * @author Laura Arvizu
 */
public class RolDao {
     public static List<RolBean> listar() throws SQLException{
        List<RolBean> lista = new ArrayList<>();
        Connection c = Conexion.getInstance().abrirConexion();
        PreparedStatement pst = c.prepareStatement("SELECT r.idRol,"
                + " r.rol FROM rol r");
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            lista.add(new RolBean(rs.getInt("idRol"),rs.getString("rol")));
        }
        return lista;
    }
    
}
