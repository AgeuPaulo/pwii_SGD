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
import model.dao.entidades.Cliente;

/**
 *
 * @author Ageeu
 */
public class ClienteDao extends GenericDao<Cliente> {

    EntityManager em = jUtil.getEM();

    public List<Cliente> listaClientes() {
        List<Cliente> clientes = null;
        Query queryCliente = em.createQuery("select u from Cliente u", Cliente.class);
        clientes = queryCliente.getResultList();

        return clientes;
    }

    public Cliente buscarCliente(String cpf) {
        try {
            Cliente c = (Cliente) em.createQuery("SELECT u from Cliente u where u.cpf = :cpf")
                    .setParameter("cpf", cpf).getSingleResult();

            return c;

        } catch (NoResultException e) {
            return null;
        }
    }

}
