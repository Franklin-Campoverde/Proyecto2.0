/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.List;
import DAO.ClienteDAO;
import entidades.Cliente;
import java.math.BigDecimal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Geampiere_GB
 */
@ManagedBean
@ViewScoped
public class RegistroBean {

    private Cliente persona;

    public RegistroBean() {
        persona = new Cliente();
    }

    public Cliente getPersona() {
        return persona;
    }

    public void setPersona(Cliente persona) {
        this.persona = persona;
    }

    
    public void crearPersona(){
        List<Cliente> dao = new ClienteDAO().listarCliente();
        Cliente cliente;
        if(!dao.isEmpty()){
            if(dao.size()>1)
                cliente = dao.get(dao.size()-1);
            else
                cliente = dao.get(0);
            persona.setIdCliente(cliente.getIdCliente().add(new BigDecimal("1")));
        }else
            persona.setIdCliente(new BigDecimal("1"));
         
        new ClienteDAO().agregar(persona);
    }
    
    
}
