/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "libros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libros.findAll", query = "SELECT l FROM Libros l ORDER BY l.nomLibro"),
    @NamedQuery(name = "Libros.findByCodLibro", query = "SELECT l FROM Libros l WHERE l.codLibro = :codLibro"),
    @NamedQuery(name = "Libros.findByNomLibro", query = "SELECT l FROM Libros l WHERE l.nomLibro = :nomLibro"),
    @NamedQuery(name = "Libros.findByAno", query = "SELECT l FROM Libros l WHERE l.ano = :ano"),
    @NamedQuery(name = "Libros.findByPortada", query = "SELECT l FROM Libros l WHERE l.portada = :portada"),
    @NamedQuery(name = "Libros.findByNomArchivo", query = "SELECT l FROM Libros l WHERE l.nomArchivo = :nomArchivo"),
    @NamedQuery(name = "Libros.findByAutor", query = "SELECT l FROM Libros l WHERE l.autoresCollection = :elAutor ORDER BY l.ano"),
    @NamedQuery(name = "Libros.findByPelicula", query = "SELECT l FROM Libros l WHERE l.pelicula = :pelicula")})
public class Libros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_libro")
    private Integer codLibro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_libro")
    private String nomLibro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    private int ano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "portada")
    private String portada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nom_archivo")
    private String nomArchivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "pelicula")
    private String pelicula;
    @ManyToMany(mappedBy = "librosCollection")
    private Collection<Autores> autoresCollection;
    @JoinTable(name = "libro_premios", joinColumns = {
        @JoinColumn(name = "cod_libro", referencedColumnName = "cod_libro")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_premio", referencedColumnName = "cod_premio")})
    @ManyToMany
    private Collection<Premios> premiosCollection;

    public Libros() {
    }

    public Libros(Integer codLibro) {
        this.codLibro = codLibro;
    }

    public Libros(Integer codLibro, String nomLibro, int ano, String portada, String nomArchivo, String pelicula) {
        this.codLibro = codLibro;
        this.nomLibro = nomLibro;
        this.ano = ano;
        this.portada = portada;
        this.nomArchivo = nomArchivo;
        this.pelicula = pelicula;
    }

    public Integer getCodLibro() {
        return codLibro;
    }

    public void setCodLibro(Integer codLibro) {
        this.codLibro = codLibro;
    }

    public String getNomLibro() {
        return nomLibro;
    }

    public void setNomLibro(String nomLibro) {
        this.nomLibro = nomLibro;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getNomArchivo() {
        return nomArchivo;
    }

    public void setNomArchivo(String nomArchivo) {
        this.nomArchivo = nomArchivo;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    @XmlTransient
    public Collection<Autores> getAutoresCollection() {
        return autoresCollection;
    }

    public void setAutoresCollection(Collection<Autores> autoresCollection) {
        this.autoresCollection = autoresCollection;
    }

    @XmlTransient
    public Collection<Premios> getPremiosCollection() {
        return premiosCollection;
    }

    public void setPremiosCollection(Collection<Premios> premiosCollection) {
        this.premiosCollection = premiosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codLibro != null ? codLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libros)) {
            return false;
        }
        Libros other = (Libros) object;
        if ((this.codLibro == null && other.codLibro != null) || (this.codLibro != null && !this.codLibro.equals(other.codLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.Libros[ codLibro=" + codLibro + " ]";
    }
    
}
