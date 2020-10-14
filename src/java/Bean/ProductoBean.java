/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.ProductoDAO;
import entidades.Product;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Geampiere_GB
 */
@Named(value = "productoBean")
@ManagedBean
@ViewScoped
public class ProductoBean {
    private Product producto;
    private List<Product> list;
    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
        producto = new Product();
    }

    public Product getProducto() {
        return producto;
    }

    public void setProducto(Product producto) {
        this.producto = producto;
    }

    public List<Product> getList() {
        ProductoDAO ad = new ProductoDAO();
        list = ad.listarProducto();
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }
    
    public void agregarProducto(){
        ProductoDAO dao = new ProductoDAO();
        dao.agregar(producto);
    }
    public void buscarProducto(Product producto){
        ProductoDAO dao = new ProductoDAO();
        this.producto = dao.buscarProducto(producto);
    }
    
    public void limpiarProducto() {
        producto = new Product();
    }

    
    public void actualizarProducto() {
        ProductoDAO ad = new ProductoDAO();
        ad.modificar(producto);
    }

    public void eliminarProducto() {
        ProductoDAO ad = new ProductoDAO();
        ad.eliminar(producto);
    }
}
