/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.dao.entidades.Tipo;

/**
 *
 * @author Ageeu
 */
public class TipoDao extends GenericDao<Tipo> {

    public List<Tipo> listaTipos() {
        List<Tipo> usuarios = null;
        EntityManager em = jUtil.getEM();
        Query queryUsr = em.createQuery("select u from Tipo u", Tipo.class);
        usuarios = queryUsr.getResultList();
        return usuarios;
    }
}
