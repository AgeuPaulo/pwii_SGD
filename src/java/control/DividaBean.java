/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.dao.DividaDao;
import model.dao.TipoDao;
import model.dao.entidades.Cliente;
import model.dao.entidades.Divida;
import model.dao.entidades.Tipo;

/**
 *
 * @author Ageeu
 */
@Named(value = "dividaBean")
@SessionScoped
public class DividaBean implements Serializable {

    private List<Divida> lista;
    private Cliente cliente = new Cliente();
    private Tipo tipo = new Tipo();
    private Divida divida = new Divida();
    private DividaDao daodvd = new DividaDao();
    private TipoDao daotipo = new TipoDao();

    public DividaBean() {
        this.lista = daodvd.listaDividas();
    }

    public String cadastrarDivida() {
        this.divida.setIdTipo(tipo);
        this.divida.setIdCliente(cliente);

        daodvd.salvar(divida);

        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Divida cadastrado!",
                        "Cadastrada!"));

        lista = daodvd.listaDividas();

        tipo = new Tipo();
        divida = new Divida();
        cliente = new Cliente();

        return "listaDividas";
    }

    public Cliente buscarCliente(Long id) {
        cliente = daodvd.buscarCliente(id);

        return cliente;
    }

    public void excluirDivida() {
        daotipo.remover(divida.getIdTipo().getIdTipo(), Tipo.class);
        daodvd.remover(divida.getIdDivida(), Divida.class);

        this.lista = daodvd.listaDividas();
    }

    public void atualizarDivida() {
        divida = daodvd.atualizar(divida);

        this.lista = daodvd.listaDividas();
    }

    public List<Divida> getLista() {
        return lista;
    }

    public void setLista(List<Divida> lista) {
        this.lista = lista;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Divida getDivida() {
        return divida;
    }

    public void setDivida(Divida divida) {
        this.divida = divida;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}
