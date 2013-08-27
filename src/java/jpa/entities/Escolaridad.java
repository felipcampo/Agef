/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author leoandresm
 */
@Entity
@Table(name = "escolaridad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escolaridad.findAll", query = "SELECT e FROM Escolaridad e"),
    @NamedQuery(name = "Escolaridad.findByIdEscolaridad", query = "SELECT e FROM Escolaridad e WHERE e.idEscolaridad = :idEscolaridad"),
    @NamedQuery(name = "Escolaridad.findByDescrEscolaridad", query = "SELECT e FROM Escolaridad e WHERE e.descrEscolaridad = :descrEscolaridad")})
public class Escolaridad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_escolaridad")
    private Short idEscolaridad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descr_escolaridad")
    private String descrEscolaridad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEscolaridadAspirante")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;
    @OneToMany(mappedBy = "idEscolaridadPadre")
    private List<MatrizCaracterizacion> matrizCaracterizacionList1;
    @OneToMany(mappedBy = "idEscolaridadMadre")
    private List<MatrizCaracterizacion> matrizCaracterizacionList2;

    public Escolaridad() {
    }

    public Escolaridad(Short idEscolaridad) {
        this.idEscolaridad = idEscolaridad;
    }

    public Escolaridad(Short idEscolaridad, String descrEscolaridad) {
        this.idEscolaridad = idEscolaridad;
        this.descrEscolaridad = descrEscolaridad;
    }

    public Short getIdEscolaridad() {
        return idEscolaridad;
    }

    public void setIdEscolaridad(Short idEscolaridad) {
        this.idEscolaridad = idEscolaridad;
    }

    public String getDescrEscolaridad() {
        return descrEscolaridad;
    }

    public void setDescrEscolaridad(String descrEscolaridad) {
        this.descrEscolaridad = descrEscolaridad;
    }

    @XmlTransient
    public List<MatrizCaracterizacion> getMatrizCaracterizacionList() {
        return matrizCaracterizacionList;
    }

    public void setMatrizCaracterizacionList(List<MatrizCaracterizacion> matrizCaracterizacionList) {
        this.matrizCaracterizacionList = matrizCaracterizacionList;
    }

    @XmlTransient
    public List<MatrizCaracterizacion> getMatrizCaracterizacionList1() {
        return matrizCaracterizacionList1;
    }

    public void setMatrizCaracterizacionList1(List<MatrizCaracterizacion> matrizCaracterizacionList1) {
        this.matrizCaracterizacionList1 = matrizCaracterizacionList1;
    }

    @XmlTransient
    public List<MatrizCaracterizacion> getMatrizCaracterizacionList2() {
        return matrizCaracterizacionList2;
    }

    public void setMatrizCaracterizacionList2(List<MatrizCaracterizacion> matrizCaracterizacionList2) {
        this.matrizCaracterizacionList2 = matrizCaracterizacionList2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEscolaridad != null ? idEscolaridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escolaridad)) {
            return false;
        }
        Escolaridad other = (Escolaridad) object;
        if ((this.idEscolaridad == null && other.idEscolaridad != null) || (this.idEscolaridad != null && !this.idEscolaridad.equals(other.idEscolaridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Escolaridad[ idEscolaridad=" + idEscolaridad + " ]";
    }
    
}
