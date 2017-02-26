/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author asole
 */
@Entity
@Table(name = "premios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Premios.findAll", query = "SELECT p FROM Premios p ORDER BY p.nomPremio"),
    @NamedQuery(name = "Premios.findByCodPremio", query = "SELECT p FROM Premios p WHERE p.codPremio = :codPremio"),
    @NamedQuery(name = "Premios.findByNomPremio", query = "SELECT p FROM Premios p WHERE p.nomPremio = :nomPremio"),
    @NamedQuery(name = "Premios.findByNomLibro", query = "SELECT p FROM Premios p WHERE p.librosCollection = :nomlibro"),
    @NamedQuery(name = "Premios.findByTipo", query = "SELECT p FROM Premios p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Premios.findByTipoLibro", query = "SELECT p FROM Premios p WHERE p.tipo = 'L' ORDER BY p.nomPremio")})
public class Premios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_premio")
    private Integer codPremio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_premio")
    private String nomPremio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private Character tipo;
    @ManyToMany(mappedBy = "premiosCollection")
    private Collection<Libros> librosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "premios")
    private Collection<AutorPremio> autorPremioCollection;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais")
    @ManyToOne(optional = false)
    private Paises codPais;

    public Premios() {
    }

    public Premios(Integer codPremio) {
        this.codPremio = codPremio;
    }

    public Premios(Integer codPremio, String nomPremio, Character tipo) {
        this.codPremio = codPremio;
        this.nomPremio = nomPremio;
        this.tipo = tipo;
    }

    public Integer getCodPremio() {
        return codPremio;
    }

    public void setCodPremio(Integer codPremio) {
        this.codPremio = codPremio;
    }

    public String getNomPremio() {
        return nomPremio;
    }

    public void setNomPremio(String nomPremio) {
        this.nomPremio = nomPremio;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Libros> getLibrosCollection() {
        return librosCollection;
    }

    public void setLibrosCollection(Collection<Libros> librosCollection) {
        this.librosCollection = librosCollection;
    }

    @XmlTransient
    public Collection<AutorPremio> getAutorPremioCollection() {
        return autorPremioCollection;
    }

    public void setAutorPremioCollection(Collection<AutorPremio> autorPremioCollection) {
        this.autorPremioCollection = autorPremioCollection;
    }

    public Paises getCodPais() {
        return codPais;
    }

    public void setCodPais(Paises codPais) {
        this.codPais = codPais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPremio != null ? codPremio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Premios)) {
            return false;
        }
        Premios other = (Premios) object;
        if ((this.codPremio == null && other.codPremio != null) || (this.codPremio != null && !this.codPremio.equals(other.codPremio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Premios[ codPremio=" + codPremio + " ]";
    }
    
}
