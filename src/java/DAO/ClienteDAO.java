/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import entidades.Cliente;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author elcon
 */
public class ClienteDAO {
    public List<Cliente> listarCliente() {
        List<Cliente> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        String hql = "FROM Cliente";
        try {
            lista = sesion.createQuery(hql).list();
            t.commit();
            sesion.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }
    
    public Cliente buscarUsuarioCliente(Cliente cliente) {
        Cliente lista = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        String hql = "FROM CLIENTE WHERE NOMBRE_USUARIO='"+cliente.getNombreUsuario()
                +"' and CONTRASENA='"+cliente.getContrasena()+"'";
        try {
            lista = (Cliente) sesion.createQuery(hql);
            t.commit();
            sesion.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    public void agregar(Cliente cliente) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.save(cliente);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }

    public void modificar(Cliente cliente) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.update(cliente);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }

    public void eliminar(Cliente cliente) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(cliente);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }
}
