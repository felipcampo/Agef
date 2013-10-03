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
@Table(name = "medio_transporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedioTransporte.findAll", query = "SELECT m FROM MedioTransporte m"),
    @NamedQuery(name = "MedioTransporte.findByIdMedioTransporte", query = "SELECT m FROM MedioTransporte m WHERE m.idMedioTransporte = :idMedioTransporte"),
    @NamedQuery(name = "MedioTransporte.findByDescrMedioTransporte", query = "SELECT m FROM MedioTransporte m WHERE m.descrMedioTransporte = :descrMedioTransporte")})
public class MedioTransporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medio_transporte")
    private Short idMedioTransporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descr_medio_transporte")
    private String descrMedioTransporte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedioTransporte")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public MedioTransporte() {
    }

    public MedioTransporte(Short idMedioTransporte) {
        this.idMedioTransporte = idMedioTransporte;
    }

    public MedioTransporte(Short idMedioTransporte, String descrMedioTransporte) {
        this.idMedioTransporte = idMedioTransporte;
        this.descrMedioTransporte = descrMedioTransporte;
    }

    public Short getIdMedioTransporte() {
        return idMedioTransporte;
    }

    public void setIdMedioTransporte(Short idMedioTransporte) {
        this.idMedioTransporte = idMedioTransporte;
    }

    public String getDescrMedioTransporte() {
        return descrMedioTransporte;
    }

    public void setDescrMedioTransporte(String descrMedioTransporte) {
        this.descrMedioTransporte = descrMedioTransporte;
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
        hash += (idMedioTransporte != null ? idMedioTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedioTransporte)) {
            return false;
        }
        MedioTransporte other = (MedioTransporte) object;
        if ((this.idMedioTransporte == null && other.idMedioTransporte != null) || (this.idMedioTransporte != null && !this.idMedioTransporte.equals(other.idMedioTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.MedioTransporte[ idMedioTransporte=" + idMedioTransporte + " ]";
    }
    
}
