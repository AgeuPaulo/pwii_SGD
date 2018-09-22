/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.dao.entidades.Cliente;
import model.dao.entidades.Divida;

/**
 *
 * @author Ageeu
 */
public class DividaDao extends GenericDao<Divida> {

    EntityManager em = jUtil.getEM();

    public List<Divida> listaDividas() {
        List<Divida> dividas = null;
        Query queryDivida = em.createQuery("select u from Divida u", Divida.class);
        dividas = queryDivida.getResultList();

        return dividas;
    }

    public Cliente buscarCliente(Long idCliente) {
        EntityManager em = jUtil.getEM();

        if (idCliente == null) {
            throw new IllegalArgumentException("no id provided");
        }
        Cliente c = (Cliente) em.createQuery("SELECT u from Cliente u where u.idCliente = :idCliente")
                .setParameter("idCliente", idCliente).getSingleResult();

        return c;
    }
}
