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
 * @author MAURICIO
 */
@Entity
@Table(name = "medios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medios.findAll", query = "SELECT m FROM Medios m"),
    @NamedQuery(name = "Medios.findByIdMedios", query = "SELECT m FROM Medios m WHERE m.idMedios = :idMedios"),
    @NamedQuery(name = "Medios.findByDescripcionMedio", query = "SELECT m FROM Medios m WHERE m.descripcionMedio = :descripcionMedio")})
public class Medios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medios")
    private Short idMedios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "descripcion_medio")
    private String descripcionMedio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedios")
    private List<EvaluacionSeguimiento> evaluacionSeguimientoList;

    public Medios() {
    }

    public Medios(Short idMedios) {
        this.idMedios = idMedios;
    }

    public Medios(Short idMedios, String descripcionMedio) {
        this.idMedios = idMedios;
        this.descripcionMedio = descripcionMedio;
    }

    public Short getIdMedios() {
        return idMedios;
    }

    public void setIdMedios(Short idMedios) {
        this.idMedios = idMedios;
    }

    public String getDescripcionMedio() {
        return descripcionMedio;
    }

    public void setDescripcionMedio(String descripcionMedio) {
        this.descripcionMedio = descripcionMedio;
    }

    @XmlTransient
    public List<EvaluacionSeguimiento> getEvaluacionSeguimientoList() {
        return evaluacionSeguimientoList;
    }

    public void setEvaluacionSeguimientoList(List<EvaluacionSeguimiento> evaluacionSeguimientoList) {
        this.evaluacionSeguimientoList = evaluacionSeguimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedios != null ? idMedios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medios)) {
            return false;
        }
        Medios other = (Medios) object;
        if ((this.idMedios == null && other.idMedios != null) || (this.idMedios != null && !this.idMedios.equals(other.idMedios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Medios[ idMedios=" + idMedios + " ]";
    }
    
}
