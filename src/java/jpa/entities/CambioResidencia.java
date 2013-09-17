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
 * @author ADSI
 */
@Entity
@Table(name = "cambio_residencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CambioResidencia.findAll", query = "SELECT c FROM CambioResidencia c"),
    @NamedQuery(name = "CambioResidencia.findByIdCambioResidencia", query = "SELECT c FROM CambioResidencia c WHERE c.idCambioResidencia = :idCambioResidencia"),
    @NamedQuery(name = "CambioResidencia.findByDescrCambioResidencia", query = "SELECT c FROM CambioResidencia c WHERE c.descrCambioResidencia = :descrCambioResidencia")})
public class CambioResidencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cambio_residencia")
    private Short idCambioResidencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descr_cambio_residencia")
    private String descrCambioResidencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCambioResidencia")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public CambioResidencia() {
    }

    public CambioResidencia(Short idCambioResidencia) {
        this.idCambioResidencia = idCambioResidencia;
    }

    public CambioResidencia(Short idCambioResidencia, String descrCambioResidencia) {
        this.idCambioResidencia = idCambioResidencia;
        this.descrCambioResidencia = descrCambioResidencia;
    }

    public Short getIdCambioResidencia() {
        return idCambioResidencia;
    }

    public void setIdCambioResidencia(Short idCambioResidencia) {
        this.idCambioResidencia = idCambioResidencia;
    }

    public String getDescrCambioResidencia() {
        return descrCambioResidencia;
    }

    public void setDescrCambioResidencia(String descrCambioResidencia) {
        this.descrCambioResidencia = descrCambioResidencia;
    }

    @XmlTransient
    public List<MatrizCaracterizacion> getMatrizCaracterizacionList() {
        return matrizCaracterizacionList;
    }

    public void setMatrizCaracterizacionList(List<MatrizCaracterizacion> matrizCaracterizacionList) {
        this.matrizCaracterizacionList = matrizCaracterizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCambioResidencia != null ? idCambioResidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CambioResidencia)) {
            return false;
        }
        CambioResidencia other = (CambioResidencia) object;
        if ((this.idCambioResidencia == null && other.idCambioResidencia != null) || (this.idCambioResidencia != null && !this.idCambioResidencia.equals(other.idCambioResidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.CambioResidencia[ idCambioResidencia=" + idCambioResidencia + " ]";
    }
    
}
