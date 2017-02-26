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
@Table(name = "paises")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paises.findAll", query = "SELECT p FROM Paises p ORDER BY p.nomPais"),
    @NamedQuery(name = "Paises.findByCodPais", query = "SELECT p FROM Paises p WHERE p.codPais = :codPais"),
    @NamedQuery(name = "Paises.findByNomPais", query = "SELECT p FROM Paises p WHERE p.nomPais = :nomPais"),
    @NamedQuery(name = "Paises.findByBandera", query = "SELECT p FROM Paises p WHERE p.bandera = :bandera")})
public class Paises implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_pais")
    private Integer codPais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nom_pais")
    private String nomPais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "bandera")
    private String bandera;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPais")
    private Collection<Premios> premiosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nacionalidad")
    private Collection<Autores> autoresCollection;

    public Paises() {
    }

    public Paises(Integer codPais) {
        this.codPais = codPais;
    }

    public Paises(Integer codPais, String nomPais, String bandera) {
        this.codPais = codPais;
        this.nomPais = nomPais;
        this.bandera = bandera;
    }

    public Integer getCodPais() {
        return codPais;
    }

    public void setCodPais(Integer codPais) {
        this.codPais = codPais;
    }

    public String getNomPais() {
        return nomPais;
    }

    public void setNomPais(String nomPais) {
        this.nomPais = nomPais;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    @XmlTransient
    public Collection<Premios> getPremiosCollection() {
        return premiosCollection;
    }

    public void setPremiosCollection(Collection<Premios> premiosCollection) {
        this.premiosCollection = premiosCollection;
    }

    @XmlTransient
    public Collection<Autores> getAutoresCollection() {
        return autoresCollection;
    }

    public void setAutoresCollection(Collection<Autores> autoresCollection) {
        this.autoresCollection = autoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPais != null ? codPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paises)) {
            return false;
        }
        Paises other = (Paises) object;
        if ((this.codPais == null && other.codPais != null) || (this.codPais != null && !this.codPais.equals(other.codPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Paises[ codPais=" + codPais + " ]";
    }
    
}
