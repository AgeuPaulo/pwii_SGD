/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.dao.UsuarioDao;
import model.dao.entidades.Usuario;

/**
 *
 * @author Ageeu
 */
@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

    private Usuario usuario = new Usuario();
    private List<Usuario> lista;
    private UsuarioDao userdao = new UsuarioDao();
    
    
    public UsuarioBean() {
        this.lista = userdao.listaUsuarios();     
    }
    
    public String salvarUser(){
        userdao.salvar(usuario);
        this.lista = userdao.listaUsuarios();
        usuario = new Usuario();
        
        return "index";
    }
    
    public String logar() {
        usuario = userdao.checarUsuario(usuario.getUsername(), usuario.getSenha());
        if (usuario == null) {
            usuario = new Usuario();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                            "Erro no Login!"));
            return null;
        } else {
            return "dashboard";
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }  
}
