/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author leoandresm
 */
@Entity
@Table(name = "criterio_calificacion_falta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriterioCalificacionFalta.findAll", query = "SELECT c FROM CriterioCalificacionFalta c"),
    @NamedQuery(name = "CriterioCalificacionFalta.findByIdCriterioCalificacionFalta", query = "SELECT c FROM CriterioCalificacionFalta c WHERE c.idCriterioCalificacionFalta = :idCriterioCalificacionFalta"),
    @NamedQuery(name = "CriterioCalificacionFalta.findByDescrCriterioFalta", query = "SELECT c FROM CriterioCalificacionFalta c WHERE c.descrCriterioFalta = :descrCriterioFalta")})
public class CriterioCalificacionFalta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_criterio_calificacion_falta")
    private Short idCriterioCalificacionFalta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descr_criterio_falta")
    private String descrCriterioFalta;
    @JoinTable(name = "criterio_falta", joinColumns = {
        @JoinColumn(name = "id_criterio_calificacion_falta", referencedColumnName = "id_criterio_calificacion_falta")}, inverseJoinColumns = {
        @JoinColumn(name = "id_falta", referencedColumnName = "id_falta")})
    @ManyToMany
    private List<Falta> faltaList;

    public CriterioCalificacionFalta() {
    }

    public CriterioCalificacionFalta(Short idCriterioCalificacionFalta) {
        this.idCriterioCalificacionFalta = idCriterioCalificacionFalta;
    }

    public CriterioCalificacionFalta(Short idCriterioCalificacionFalta, String descrCriterioFalta) {
        this.idCriterioCalificacionFalta = idCriterioCalificacionFalta;
        this.descrCriterioFalta = descrCriterioFalta;
    }

    public Short getIdCriterioCalificacionFalta() {
        return idCriterioCalificacionFalta;
    }

    public void setIdCriterioCalificacionFalta(Short idCriterioCalificacionFalta) {
        this.idCriterioCalificacionFalta = idCriterioCalificacionFalta;
    }

    public String getDescrCriterioFalta() {
        return descrCriterioFalta;
    }

    public void setDescrCriterioFalta(String descrCriterioFalta) {
        this.descrCriterioFalta = descrCriterioFalta;
    }

    @XmlTransient
    public List<Falta> getFaltaList() {
        return faltaList;
    }

    public void setFaltaList(List<Falta> faltaList) {
        this.faltaList = faltaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCriterioCalificacionFalta != null ? idCriterioCalificacionFalta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriterioCalificacionFalta)) {
            return false;
        }
        CriterioCalificacionFalta other = (CriterioCalificacionFalta) object;
        if ((this.idCriterioCalificacionFalta == null && other.idCriterioCalificacionFalta != null) || (this.idCriterioCalificacionFalta != null && !this.idCriterioCalificacionFalta.equals(other.idCriterioCalificacionFalta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.CriterioCalificacionFalta[ idCriterioCalificacionFalta=" + idCriterioCalificacionFalta + " ]";
    }
    
}
