/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.dao.entidades.Usuario;

/**
 *
 * @author Ageeu
 */
public class UsuarioDao extends GenericDao<Usuario> {
    
    private EntityManager em = jUtil.getEM();
    
     public List<Usuario> listaUsuarios() {
        List<Usuario> usuarios = null;
        Query queryUsr = em.createQuery("select u from Usuario u", Usuario.class);
        usuarios = queryUsr.getResultList();
        return usuarios;
    }
     
     public Usuario checarUsuario(String username, String senha) {

        try {
            Usuario usuario = (Usuario) em
                    .createQuery(
                            "SELECT u from Usuario u where u.username = :username and u.senha = :senha")
                    .setParameter("username", username)
                    .setParameter("senha", senha).getSingleResult();

            return usuario;
        } catch (NoResultException e) {
            return null;
        }
    }
}
