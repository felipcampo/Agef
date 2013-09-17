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
@Table(name = "motivo_inscripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MotivoInscripcion.findAll", query = "SELECT m FROM MotivoInscripcion m"),
    @NamedQuery(name = "MotivoInscripcion.findByIdMotivoInscripcion", query = "SELECT m FROM MotivoInscripcion m WHERE m.idMotivoInscripcion = :idMotivoInscripcion"),
    @NamedQuery(name = "MotivoInscripcion.findByDescrMotivoInscripcion", query = "SELECT m FROM MotivoInscripcion m WHERE m.descrMotivoInscripcion = :descrMotivoInscripcion")})
public class MotivoInscripcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_motivo_inscripcion")
    private Short idMotivoInscripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descr_motivo_inscripcion")
    private String descrMotivoInscripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMotivoInscripcion")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public MotivoInscripcion() {
    }

    public MotivoInscripcion(Short idMotivoInscripcion) {
        this.idMotivoInscripcion = idMotivoInscripcion;
    }

    public MotivoInscripcion(Short idMotivoInscripcion, String descrMotivoInscripcion) {
        this.idMotivoInscripcion = idMotivoInscripcion;
        this.descrMotivoInscripcion = descrMotivoInscripcion;
    }

    public Short getIdMotivoInscripcion() {
        return idMotivoInscripcion;
    }

    public void setIdMotivoInscripcion(Short idMotivoInscripcion) {
        this.idMotivoInscripcion = idMotivoInscripcion;
    }

    public String getDescrMotivoInscripcion() {
        return descrMotivoInscripcion;
    }

    public void setDescrMotivoInscripcion(String descrMotivoInscripcion) {
        this.descrMotivoInscripcion = descrMotivoInscripcion;
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
        hash += (idMotivoInscripcion != null ? idMotivoInscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MotivoInscripcion)) {
            return false;
        }
        MotivoInscripcion other = (MotivoInscripcion) object;
        if ((this.idMotivoInscripcion == null && other.idMotivoInscripcion != null) || (this.idMotivoInscripcion != null && !this.idMotivoInscripcion.equals(other.idMotivoInscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.MotivoInscripcion[ idMotivoInscripcion=" + idMotivoInscripcion + " ]";
    }
    
}
