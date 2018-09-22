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
import model.dao.ClienteDao;
import model.dao.EnderecoDao;
import model.dao.entidades.Cliente;
import model.dao.entidades.Endereco;

/**
 *
 * @author Ageeu
 */
@Named(value = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {
    
    private List<Cliente> lista;
    private Cliente cliente = new Cliente();
    private ClienteDao daoclnt = new ClienteDao();
    private EnderecoDao daodnr = new EnderecoDao();
    private Endereco endereco = new Endereco();

    public ClienteBean() {
        this.lista = daoclnt.listaClientes();
    }

    public String cadastrarCliente() {  
        Cliente infoC = daoclnt.buscarCliente(getCliente().getCpf());
        
        if (infoC == null) {
            daodnr.salvar(endereco);
            cliente.setIdEndereco(endereco);
            daoclnt.salvar(getCliente());    
            
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário cadastrado!",
                            "Cadastrado!"));
            
            this.lista = daoclnt.listaClientes();
            
            cliente = new Cliente();
            endereco = new Endereco();
            
            return "listaClientes";
            
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cliente já cadastrado!",
                            "Erro no cadastro do cliente!"));
            return null;
        }
    }
    
    public void excluirCliente() {
        daodnr.remover(cliente.getIdEndereco().getIdEndereco(), Endereco.class);
        daoclnt.remover(cliente.getIdCliente(), Cliente.class);
        
        this.lista = daoclnt.listaClientes();
        
    }
    
    public List<Cliente> getLista() {
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}
