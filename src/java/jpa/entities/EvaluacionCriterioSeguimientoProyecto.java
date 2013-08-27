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
@Table(name = "evaluacion_criterio_seguimiento_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvaluacionCriterioSeguimientoProyecto.findAll", query = "SELECT e FROM EvaluacionCriterioSeguimientoProyecto e"),
    @NamedQuery(name = "EvaluacionCriterioSeguimientoProyecto.findByIdEvaluacionCriterioSeguimientoProyecto", query = "SELECT e FROM EvaluacionCriterioSeguimientoProyecto e WHERE e.idEvaluacionCriterioSeguimientoProyecto = :idEvaluacionCriterioSeguimientoProyecto"),
    @NamedQuery(name = "EvaluacionCriterioSeguimientoProyecto.findByNomEvaCri", query = "SELECT e FROM EvaluacionCriterioSeguimientoProyecto e WHERE e.nomEvaCri = :nomEvaCri")})
public class EvaluacionCriterioSeguimientoProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "id_evaluacion_criterio_seguimiento_proyecto")
    private String idEvaluacionCriterioSeguimientoProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_eva_cri")
    private String nomEvaCri;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvaluacionCriterioSeguimientoProyecto")
    private List<CriterioSeguimientoProyecto> criterioSeguimientoProyectoList;

    public EvaluacionCriterioSeguimientoProyecto() {
    }

    public EvaluacionCriterioSeguimientoProyecto(String idEvaluacionCriterioSeguimientoProyecto) {
        this.idEvaluacionCriterioSeguimientoProyecto = idEvaluacionCriterioSeguimientoProyecto;
    }

    public EvaluacionCriterioSeguimientoProyecto(String idEvaluacionCriterioSeguimientoProyecto, String nomEvaCri) {
        this.idEvaluacionCriterioSeguimientoProyecto = idEvaluacionCriterioSeguimientoProyecto;
        this.nomEvaCri = nomEvaCri;
    }

    public String getIdEvaluacionCriterioSeguimientoProyecto() {
        return idEvaluacionCriterioSeguimientoProyecto;
    }

    public void setIdEvaluacionCriterioSeguimientoProyecto(String idEvaluacionCriterioSeguimientoProyecto) {
        this.idEvaluacionCriterioSeguimientoProyecto = idEvaluacionCriterioSeguimientoProyecto;
    }

    public String getNomEvaCri() {
        return nomEvaCri;
    }

    public void setNomEvaCri(String nomEvaCri) {
        this.nomEvaCri = nomEvaCri;
    }

    @XmlTransient
    public List<CriterioSeguimientoProyecto> getCriterioSeguimientoProyectoList() {
        return criterioSeguimientoProyectoList;
    }

    public void setCriterioSeguimientoProyectoList(List<CriterioSeguimientoProyecto> criterioSeguimientoProyectoList) {
        this.criterioSeguimientoProyectoList = criterioSeguimientoProyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvaluacionCriterioSeguimientoProyecto != null ? idEvaluacionCriterioSeguimientoProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionCriterioSeguimientoProyecto)) {
            return false;
        }
        EvaluacionCriterioSeguimientoProyecto other = (EvaluacionCriterioSeguimientoProyecto) object;
        if ((this.idEvaluacionCriterioSeguimientoProyecto == null && other.idEvaluacionCriterioSeguimientoProyecto != null) || (this.idEvaluacionCriterioSeguimientoProyecto != null && !this.idEvaluacionCriterioSeguimientoProyecto.equals(other.idEvaluacionCriterioSeguimientoProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EvaluacionCriterioSeguimientoProyecto[ idEvaluacionCriterioSeguimientoProyecto=" + idEvaluacionCriterioSeguimientoProyecto + " ]";
    }
    
}
