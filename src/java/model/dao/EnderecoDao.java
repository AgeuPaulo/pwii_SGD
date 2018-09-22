/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.dao.entidades.Endereco;

/**
 *
 * @author Ageeu
 */
public class EnderecoDao extends GenericDao<Endereco> {

    EntityManager em = jUtil.getEM();

    public List<Endereco> listaEnderecos() {
        List<Endereco> enderecos = null;
        Query queryUsr = em.createQuery("select u from Endereco u", Endereco.class);
        enderecos = queryUsr.getResultList();
        return enderecos;
    }

}
