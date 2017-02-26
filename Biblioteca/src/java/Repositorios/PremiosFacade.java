/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Modelos.AutorPremio;
import Modelos.Autores;
import Modelos.Libros;
import Modelos.Premios;
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
public class PremiosFacade extends AbstractFacade<Premios> {

    @PersistenceContext(unitName = "BibliotecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PremiosFacade() {
        super(Premios.class);
    }
    
    public List<Premios> premios_ordenados() {
        EntityManager em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Premios.findByTipoLibro");
        return q.getResultList();
    }
    
    public List<AutorPremio> premios_autor(Autores autor){
        EntityManager em = getEntityManager();
        Query q;
        q = em.createNamedQuery("AutorPremio.findByCodAutor").setParameter("codAutor", autor.getCodAutor());//parametro primero el nombre del parametro en la consulta "elAutor", parametro autor
        return q.getResultList();
    }
    
    public List<Premios> premios_libro(Libros libro){
        EntityManager em = getEntityManager();
        Query q;
        q = em.createNamedQuery("Premios.findByNomLibro").setParameter("nomlibro", libro);//parametro primero el nombre del parametro en la consulta "elAutor", parametro autor
        return q.getResultList();
    }
    
}
