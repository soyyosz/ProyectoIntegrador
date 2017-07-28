/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

/**
 *
 * @author Laura Arvizu
 */
public class UsuarioBean {

    private String usuario;
    private String password;
    private int idRol;
    private boolean estatus;
    private RolBean rolDelUsuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public RolBean getRolDelUsuario() {
        return rolDelUsuario;
    }

    public void setRolDelUsuario(RolBean rolDelUsuario) {
        this.rolDelUsuario = rolDelUsuario;
    }

}
