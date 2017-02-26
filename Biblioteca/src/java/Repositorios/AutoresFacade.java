/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Modelos.Autores;
import Modelos.Paises;
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
public class AutoresFacade extends AbstractFacade<Autores> {

    @PersistenceContext(unitName = "BibliotecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutoresFacade() {
        super(Autores.class);
    }

    public List<Autores> autores_ordenados() {
        EntityManager em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Autores.findAll");
        return q.getResultList();
    }

    public List<Autores> pais_autor(Paises pais) {
        EntityManager em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Autores.findByNac").setParameter("pais", pais);//parametro primero el nombre del parametro en la consulta "elAutor", parametro autor
        return q.getResultList();
    }
    
}
