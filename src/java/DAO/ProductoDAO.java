/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import entidades.Product;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author elcon
 */
public class ProductoDAO {
    public List<Product> listarProducto() {
        List<Product> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        String hql = "FROM Product";
        try {
            lista = sesion.createQuery(hql).list();
            t.commit();
            sesion.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }
    
    public Product buscarProducto(Product producto) {
        Product lista = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        String hql = "FROM PRODUCT WHERE ID_PRODUCT='"+producto.getIdProduct()+"'";
        try {
            lista = (Product) sesion.createQuery(hql);
            t.commit();
            sesion.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    public void agregar(Product producto) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.save(producto);
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

    public void modificar(Product producto) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.update(producto);
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

    public void eliminar(Product producto) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(producto);
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
