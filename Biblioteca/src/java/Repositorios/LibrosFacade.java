/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Modelos.Autores;
import Modelos.Libros;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author asole
 */
@Stateless
public class LibrosFacade extends AbstractFacade<Libros> {

    @PersistenceContext(unitName = "BibliotecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LibrosFacade() {
        super(Libros.class);
    }
    
    public List<Libros> libros_ordenados() {
        EntityManager em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Libros.findAll");
        return q.getResultList();
    }
    
    public List<Libros> libros_autor(Autores autor){
        EntityManager em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Libros.findByAutor").setParameter("elAutor", autor);//parametro primero el nombre del parametro en la consulta "elAutor", parametro autor
        return q.getResultList();
    }
}
