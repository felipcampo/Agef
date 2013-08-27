/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leoandresm
 */
@Entity
@Table(name = "criterio_seguimiento_instructor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriterioSeguimientoInstructor.findAll", query = "SELECT c FROM CriterioSeguimientoInstructor c"),
    @NamedQuery(name = "CriterioSeguimientoInstructor.findByIdCriterioSeguimientoInstructor", query = "SELECT c FROM CriterioSeguimientoInstructor c WHERE c.idCriterioSeguimientoInstructor = :idCriterioSeguimientoInstructor")})
public class CriterioSeguimientoInstructor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_criterio_seguimiento_instructor")
    private Integer idCriterioSeguimientoInstructor;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "obs_cri_ins")
    private String obsCriIns;
    @JoinColumn(name = "id_criterio_evaluacion", referencedColumnName = "id_criterio_evaluacion")
    @ManyToOne(optional = false)
    private CriterioEvaluacion idCriterioEvaluacion;
    @JoinColumn(name = "id_evaluacion_criterio_seguimiento_instructor", referencedColumnName = "id_evaluacion_criterio_seguimiento_instructor")
    @ManyToOne(optional = false)
    private EvaluacionCriterioSeguimientoInstructor idEvaluacionCriterioSeguimientoInstructor;
    @JoinColumn(name = "id_seguimiento_instructor", referencedColumnName = "id_seguimiento_instructor")
    @ManyToOne(optional = false)
    private SeguimientoInstructor idSeguimientoInstructor;

    public CriterioSeguimientoInstructor() {
    }

    public CriterioSeguimientoInstructor(Integer idCriterioSeguimientoInstructor) {
        this.idCriterioSeguimientoInstructor = idCriterioSeguimientoInstructor;
    }

    public CriterioSeguimientoInstructor(Integer idCriterioSeguimientoInstructor, String obsCriIns) {
        this.idCriterioSeguimientoInstructor = idCriterioSeguimientoInstructor;
        this.obsCriIns = obsCriIns;
    }

    public Integer getIdCriterioSeguimientoInstructor() {
        return idCriterioSeguimientoInstructor;
    }

    public void setIdCriterioSeguimientoInstructor(Integer idCriterioSeguimientoInstructor) {
        this.idCriterioSeguimientoInstructor = idCriterioSeguimientoInstructor;
    }

    public String getObsCriIns() {
        return obsCriIns;
    }

    public void setObsCriIns(String obsCriIns) {
        this.obsCriIns = obsCriIns;
    }

    public CriterioEvaluacion getIdCriterioEvaluacion() {
        return idCriterioEvaluacion;
    }

    public void setIdCriterioEvaluacion(CriterioEvaluacion idCriterioEvaluacion) {
        this.idCriterioEvaluacion = idCriterioEvaluacion;
    }

    public EvaluacionCriterioSeguimientoInstructor getIdEvaluacionCriterioSeguimientoInstructor() {
        return idEvaluacionCriterioSeguimientoInstructor;
    }

    public void setIdEvaluacionCriterioSeguimientoInstructor(EvaluacionCriterioSeguimientoInstructor idEvaluacionCriterioSeguimientoInstructor) {
        this.idEvaluacionCriterioSeguimientoInstructor = idEvaluacionCriterioSeguimientoInstructor;
    }

    public SeguimientoInstructor getIdSeguimientoInstructor() {
        return idSeguimientoInstructor;
    }

    public void setIdSeguimientoInstructor(SeguimientoInstructor idSeguimientoInstructor) {
        this.idSeguimientoInstructor = idSeguimientoInstructor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCriterioSeguimientoInstructor != null ? idCriterioSeguimientoInstructor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriterioSeguimientoInstructor)) {
            return false;
        }
        CriterioSeguimientoInstructor other = (CriterioSeguimientoInstructor) object;
        if ((this.idCriterioSeguimientoInstructor == null && other.idCriterioSeguimientoInstructor != null) || (this.idCriterioSeguimientoInstructor != null && !this.idCriterioSeguimientoInstructor.equals(other.idCriterioSeguimientoInstructor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.CriterioSeguimientoInstructor[ idCriterioSeguimientoInstructor=" + idCriterioSeguimientoInstructor + " ]";
    }
    
}
