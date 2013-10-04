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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "criterio_seguimiento_instructor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriterioSeguimientoInstructor.findAll", query = "SELECT c FROM CriterioSeguimientoInstructor c"),
    @NamedQuery(name = "CriterioSeguimientoInstructor.findByIdCriterioSeguimientoInstructor", query = "SELECT c FROM CriterioSeguimientoInstructor c WHERE c.idCriterioSeguimientoInstructor = :idCriterioSeguimientoInstructor"),
    @NamedQuery(name = "CriterioSeguimientoInstructor.findByEstoyAcuerdo", query = "SELECT c FROM CriterioSeguimientoInstructor c WHERE c.estoyAcuerdo = :estoyAcuerdo")})
public class CriterioSeguimientoInstructor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_criterio_seguimiento_instructor")
    private Integer idCriterioSeguimientoInstructor;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "obs_cri_ins")
    private String obsCriIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estoy_acuerdo")
    private boolean estoyAcuerdo;
    @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")
    @ManyToOne
    private FichaCaracterizacion idFichaCaracterizacion;
    @JoinColumn(name = "id_seguimiento_instructor", referencedColumnName = "id_seguimiento_instructor")
    @ManyToOne
    private SeguimientoInstructor idSeguimientoInstructor;
    @JoinColumn(name = "id_evaluacion_criterio_seguimiento_instructor", referencedColumnName = "id_evaluacion_criterio_seguimiento_instructor")
    @ManyToOne(optional = false)
    private EvaluacionCriterioSeguimientoInstructor idEvaluacionCriterioSeguimientoInstructor;
    @JoinColumn(name = "id_criterio_evaluacion", referencedColumnName = "id_criterio_evaluacion")
    @ManyToOne(optional = false)
    private CriterioEvaluacion idCriterioEvaluacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCriterioSeguimientoInstructor")
    private List<SeguimientoInstructor> seguimientoInstructorList;

    public CriterioSeguimientoInstructor() {
    }

    public CriterioSeguimientoInstructor(Integer idCriterioSeguimientoInstructor) {
        this.idCriterioSeguimientoInstructor = idCriterioSeguimientoInstructor;
    }

    public CriterioSeguimientoInstructor(Integer idCriterioSeguimientoInstructor, String obsCriIns, boolean estoyAcuerdo) {
        this.idCriterioSeguimientoInstructor = idCriterioSeguimientoInstructor;
        this.obsCriIns = obsCriIns;
        this.estoyAcuerdo = estoyAcuerdo;
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

    public boolean getEstoyAcuerdo() {
        return estoyAcuerdo;
    }

    public void setEstoyAcuerdo(boolean estoyAcuerdo) {
        this.estoyAcuerdo = estoyAcuerdo;
    }

    public FichaCaracterizacion getIdFichaCaracterizacion() {
        return idFichaCaracterizacion;
    }

    public void setIdFichaCaracterizacion(FichaCaracterizacion idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    public SeguimientoInstructor getIdSeguimientoInstructor() {
        return idSeguimientoInstructor;
    }

    public void setIdSeguimientoInstructor(SeguimientoInstructor idSeguimientoInstructor) {
        this.idSeguimientoInstructor = idSeguimientoInstructor;
    }

    public EvaluacionCriterioSeguimientoInstructor getIdEvaluacionCriterioSeguimientoInstructor() {
        return idEvaluacionCriterioSeguimientoInstructor;
    }

    public void setIdEvaluacionCriterioSeguimientoInstructor(EvaluacionCriterioSeguimientoInstructor idEvaluacionCriterioSeguimientoInstructor) {
        this.idEvaluacionCriterioSeguimientoInstructor = idEvaluacionCriterioSeguimientoInstructor;
    }

    public CriterioEvaluacion getIdCriterioEvaluacion() {
        return idCriterioEvaluacion;
    }

    public void setIdCriterioEvaluacion(CriterioEvaluacion idCriterioEvaluacion) {
        this.idCriterioEvaluacion = idCriterioEvaluacion;
    }

    @XmlTransient
    public List<SeguimientoInstructor> getSeguimientoInstructorList() {
        return seguimientoInstructorList;
    }

    public void setSeguimientoInstructorList(List<SeguimientoInstructor> seguimientoInstructorList) {
        this.seguimientoInstructorList = seguimientoInstructorList;
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
