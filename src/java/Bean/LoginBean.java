/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import entidades.Cliente;
import java.util.List;
import DAO.ClienteDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Geampiere_GB
 */
@ManagedBean
@ViewScoped
public class LoginBean {

    private Cliente user;
    private List<Cliente> list;

    public LoginBean() {
        user = new Cliente();
    }

    public Cliente getUser() {
        return user;
    }

    public void setUser(Cliente user) {
        this.user = user;
    }

    public List<Cliente> getList() {
        return list;
    }

    public void setList(List<Cliente> list) {
        this.list = list;
    }
    
    public List<Cliente> getListaCliente() {
        ClienteDAO ad = new ClienteDAO();
        list = ad.listarCliente();
        return list;
    }
    public void buscar(){
        ClienteDAO ad = new ClienteDAO();
        ad.buscarUsuarioCliente(user);
        
    }
    
    public void guardar(){
        ClienteDAO ad = new ClienteDAO();
        ad.agregar(user);
    }
    
    
}
