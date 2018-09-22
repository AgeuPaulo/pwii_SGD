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
import model.dao.TipoDao;
import model.dao.entidades.Tipo;

/**
 *
 * @author Ageeu
 */
@Named(value = "tipoBean")
@SessionScoped
public class TipoBean implements Serializable {

     private List<Tipo> lista;
    private Tipo tipo = new Tipo();
    private TipoDao daoT = new TipoDao();

    public TipoBean() {
        this.lista = daoT.listaTipos();
    }


    public void salvarTipo() {
        
        this.daoT.salvar(this.tipo);
        
        this.lista = this.daoT.listaTipos();
        
        mensagem("Aviso", "Cadastro realizado com sucesso");
    }

    public List<Tipo> getLista() {
        return lista;
    }

    public void setLista(List<Tipo> lista) {
        this.lista = lista;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void mensagem(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    
}
