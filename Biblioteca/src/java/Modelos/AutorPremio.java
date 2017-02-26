/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asole
 */
@Entity
@Table(name = "autor_premio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AutorPremio.findAll", query = "SELECT a FROM AutorPremio a"),
    @NamedQuery(name = "AutorPremio.findByCodAutor", query = "SELECT a FROM AutorPremio a WHERE a.autorPremioPK.codAutor = :codAutor"),
    @NamedQuery(name = "AutorPremio.findByCodPremio", query = "SELECT a FROM AutorPremio a WHERE a.autorPremioPK.codPremio = :codPremio"),
    @NamedQuery(name = "AutorPremio.findByAno", query = "SELECT a FROM AutorPremio a WHERE a.autorPremioPK.ano = :ano")})
public class AutorPremio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AutorPremioPK autorPremioPK;
    @JoinColumn(name = "cod_premio", referencedColumnName = "cod_premio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Premios premios;
    @JoinColumn(name = "cod_autor", referencedColumnName = "cod_autor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Autores autores;

    public AutorPremio() {
    }

    public AutorPremio(AutorPremioPK autorPremioPK) {
        this.autorPremioPK = autorPremioPK;
    }

    public AutorPremio(int codAutor, int codPremio, int ano) {
        this.autorPremioPK = new AutorPremioPK(codAutor, codPremio, ano);
    }

    public AutorPremioPK getAutorPremioPK() {
        return autorPremioPK;
    }

    public void setAutorPremioPK(AutorPremioPK autorPremioPK) {
        this.autorPremioPK = autorPremioPK;
    }

    public Premios getPremios() {
        return premios;
    }

    public void setPremios(Premios premios) {
        this.premios = premios;
    }

    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (autorPremioPK != null ? autorPremioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutorPremio)) {
            return false;
        }
        AutorPremio other = (AutorPremio) object;
        if ((this.autorPremioPK == null && other.autorPremioPK != null) || (this.autorPremioPK != null && !this.autorPremioPK.equals(other.autorPremioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.AutorPremio[ autorPremioPK=" + autorPremioPK + " ]";
    }
    
}
