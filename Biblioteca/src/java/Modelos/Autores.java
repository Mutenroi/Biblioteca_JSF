/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author asole
 */
@Entity
@Table(name = "autores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autores.findAll", query = "SELECT a FROM Autores a ORDER BY a.apellido1"),
    @NamedQuery(name = "Autores.findByCodAutor", query = "SELECT a FROM Autores a WHERE a.codAutor = :codAutor"),
    @NamedQuery(name = "Autores.findByNomAutor", query = "SELECT a FROM Autores a WHERE a.nomAutor = :nomAutor"),
    @NamedQuery(name = "Autores.findByApellido1", query = "SELECT a FROM Autores a WHERE a.apellido1 = :apellido1"),
    @NamedQuery(name = "Autores.findByApellido2", query = "SELECT a FROM Autores a WHERE a.apellido2 = :apellido2"),
    @NamedQuery(name = "Autores.findByFNac", query = "SELECT a FROM Autores a WHERE a.fNac = :fNac"),
    @NamedQuery(name = "Autores.findByFDef", query = "SELECT a FROM Autores a WHERE a.fDef = :fDef"),
    @NamedQuery(name = "Autores.findByFoto", query = "SELECT a FROM Autores a WHERE a.foto = :foto"),
    @NamedQuery(name = "Autores.findByNac", query = "SELECT a FROM Autores a WHERE a.nacionalidad = :pais"),
    @NamedQuery(name = "Autores.findByLocalidad", query = "SELECT a FROM Autores a WHERE a.localidad = :localidad")})
public class Autores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_autor")
    private Integer codAutor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom_autor")
    private String nomAutor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "apellido1")
    private String apellido1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "apellido2")
    private String apellido2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "f_nac")
    @Temporal(TemporalType.DATE)
    private Date fNac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "f_def")
    @Temporal(TemporalType.DATE)
    private Date fDef;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "foto")
    private String foto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "localidad")
    private String localidad;
    @JoinTable(name = "autor_libro", joinColumns = {
        @JoinColumn(name = "cod_autor", referencedColumnName = "cod_autor")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_libro", referencedColumnName = "cod_libro")})
    @ManyToMany
    private Collection<Libros> librosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autores")
    private Collection<AutorPremio> autorPremioCollection;
    @JoinColumn(name = "nacionalidad", referencedColumnName = "cod_pais")
    @ManyToOne(optional = false)
    private Paises nacionalidad;

    public Autores() {
    }

    public Autores(Integer codAutor) {
        this.codAutor = codAutor;
    }

    public Autores(Integer codAutor, String nomAutor, String apellido1, String apellido2, Date fNac, Date fDef, String foto, String localidad) {
        this.codAutor = codAutor;
        this.nomAutor = nomAutor;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fNac = fNac;
        this.fDef = fDef;
        this.foto = foto;
        this.localidad = localidad;
    }

    public Integer getCodAutor() {
        return codAutor;
    }

    public void setCodAutor(Integer codAutor) {
        this.codAutor = codAutor;
    }

    public String getNomAutor() {
        return nomAutor;
    }

    public void setNomAutor(String nomAutor) {
        this.nomAutor = nomAutor;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFNac() {
        return fNac;
    }

    public void setFNac(Date fNac) {
        this.fNac = fNac;
    }

    public Date getFDef() {
        return fDef;
    }

    public void setFDef(Date fDef) {
        this.fDef = fDef;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
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

    public Paises getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Paises nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAutor != null ? codAutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autores)) {
            return false;
        }
        Autores other = (Autores) object;
        if ((this.codAutor == null && other.codAutor != null) || (this.codAutor != null && !this.codAutor.equals(other.codAutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Autores[ codAutor=" + codAutor + " ]";
    }
    
}
