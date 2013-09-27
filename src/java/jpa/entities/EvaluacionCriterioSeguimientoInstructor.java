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
@Table(name = "evaluacion_criterio_seguimiento_instructor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvaluacionCriterioSeguimientoInstructor.findAll", query = "SELECT e FROM EvaluacionCriterioSeguimientoInstructor e"),
    @NamedQuery(name = "EvaluacionCriterioSeguimientoInstructor.findByIdEvaluacionCriterioSeguimientoInstructor", query = "SELECT e FROM EvaluacionCriterioSeguimientoInstructor e WHERE e.idEvaluacionCriterioSeguimientoInstructor = :idEvaluacionCriterioSeguimientoInstructor"),
    @NamedQuery(name = "EvaluacionCriterioSeguimientoInstructor.findByNomEvaluacionCriterioInstructores", query = "SELECT e FROM EvaluacionCriterioSeguimientoInstructor e WHERE e.nomEvaluacionCriterioInstructores = :nomEvaluacionCriterioInstructores")})
public class EvaluacionCriterioSeguimientoInstructor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_evaluacion_criterio_seguimiento_instructor")
    private Short idEvaluacionCriterioSeguimientoInstructor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_evaluacion_criterio_instructores")
    private String nomEvaluacionCriterioInstructores;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvaluacionCriterioSeguimientoInstructor")
    private List<CriterioSeguimientoInstructor> criterioSeguimientoInstructorList;

    public EvaluacionCriterioSeguimientoInstructor() {
    }

    public EvaluacionCriterioSeguimientoInstructor(Short idEvaluacionCriterioSeguimientoInstructor) {
        this.idEvaluacionCriterioSeguimientoInstructor = idEvaluacionCriterioSeguimientoInstructor;
    }

    public EvaluacionCriterioSeguimientoInstructor(Short idEvaluacionCriterioSeguimientoInstructor, String nomEvaluacionCriterioInstructores) {
        this.idEvaluacionCriterioSeguimientoInstructor = idEvaluacionCriterioSeguimientoInstructor;
        this.nomEvaluacionCriterioInstructores = nomEvaluacionCriterioInstructores;
    }

    public Short getIdEvaluacionCriterioSeguimientoInstructor() {
        return idEvaluacionCriterioSeguimientoInstructor;
    }

    public void setIdEvaluacionCriterioSeguimientoInstructor(Short idEvaluacionCriterioSeguimientoInstructor) {
        this.idEvaluacionCriterioSeguimientoInstructor = idEvaluacionCriterioSeguimientoInstructor;
    }

    public String getNomEvaluacionCriterioInstructores() {
        return nomEvaluacionCriterioInstructores;
    }

    public void setNomEvaluacionCriterioInstructores(String nomEvaluacionCriterioInstructores) {
        this.nomEvaluacionCriterioInstructores = nomEvaluacionCriterioInstructores;
    }

    @XmlTransient
    public List<CriterioSeguimientoInstructor> getCriterioSeguimientoInstructorList() {
        return criterioSeguimientoInstructorList;
    }

    public void setCriterioSeguimientoInstructorList(List<CriterioSeguimientoInstructor> criterioSeguimientoInstructorList) {
        this.criterioSeguimientoInstructorList = criterioSeguimientoInstructorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvaluacionCriterioSeguimientoInstructor != null ? idEvaluacionCriterioSeguimientoInstructor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionCriterioSeguimientoInstructor)) {
            return false;
        }
        EvaluacionCriterioSeguimientoInstructor other = (EvaluacionCriterioSeguimientoInstructor) object;
        if ((this.idEvaluacionCriterioSeguimientoInstructor == null && other.idEvaluacionCriterioSeguimientoInstructor != null) || (this.idEvaluacionCriterioSeguimientoInstructor != null && !this.idEvaluacionCriterioSeguimientoInstructor.equals(other.idEvaluacionCriterioSeguimientoInstructor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EvaluacionCriterioSeguimientoInstructor[ idEvaluacionCriterioSeguimientoInstructor=" + idEvaluacionCriterioSeguimientoInstructor + " ]";
    }
    
}
