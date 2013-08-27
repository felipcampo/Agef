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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
 * @author leoandresm
 */
@Entity
@Table(name = "criterio_evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriterioEvaluacion.findAll", query = "SELECT c FROM CriterioEvaluacion c"),
    @NamedQuery(name = "CriterioEvaluacion.findByIdCriterioEvaluacion", query = "SELECT c FROM CriterioEvaluacion c WHERE c.idCriterioEvaluacion = :idCriterioEvaluacion"),
    @NamedQuery(name = "CriterioEvaluacion.findByNomCriterio", query = "SELECT c FROM CriterioEvaluacion c WHERE c.nomCriterio = :nomCriterio")})
public class CriterioEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_criterio_evaluacion")
    private String idCriterioEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "detalles_criterio")
    private String detallesCriterio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_criterio")
    private String nomCriterio;
    @JoinTable(name = "actividad_criterio", joinColumns = {
        @JoinColumn(name = "id_criterio_evaluacion", referencedColumnName = "id_criterio_evaluacion")}, inverseJoinColumns = {
        @JoinColumn(name = "id_actividad_proyecto", referencedColumnName = "id_actividad_proyecto")})
    @ManyToMany
    private List<ActividadProyecto> actividadProyectoList;
    @ManyToMany(mappedBy = "criterioEvaluacionList")
    private List<EvidenciaAprendizaje> evidenciaAprendizajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCriterioEvaluacion")
    private List<CriterioSeguimientoInstructor> criterioSeguimientoInstructorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCriterioEvaluacion")
    private List<PlaneacionClase> planeacionClaseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCriterioEvaluacion")
    private List<EvidenciaAprendizaje> evidenciaAprendizajeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCriterioEvaluacion")
    private List<CriterioSeguimientoProyecto> criterioSeguimientoProyectoList;
    @JoinColumn(name = "id_factor_productiva", referencedColumnName = "id_factor_productiva")
    @ManyToOne(optional = false)
    private FactorProductiva idFactorProductiva;
    @JoinColumn(name = "id_titulo_criterio", referencedColumnName = "id_titulo_criterio")
    @ManyToOne(optional = false)
    private TituloCriterio idTituloCriterio;
    @JoinColumn(name = "id_tipo_criterio", referencedColumnName = "id_tipo_criterio")
    @ManyToOne(optional = false)
    private TipoCriterio idTipoCriterio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCriterioEvaluacion")
    private List<CriterioSeguimiento> criterioSeguimientoList;

    public CriterioEvaluacion() {
    }

    public CriterioEvaluacion(String idCriterioEvaluacion) {
        this.idCriterioEvaluacion = idCriterioEvaluacion;
    }

    public CriterioEvaluacion(String idCriterioEvaluacion, String detallesCriterio, String nomCriterio) {
        this.idCriterioEvaluacion = idCriterioEvaluacion;
        this.detallesCriterio = detallesCriterio;
        this.nomCriterio = nomCriterio;
    }

    public String getIdCriterioEvaluacion() {
        return idCriterioEvaluacion;
    }

    public void setIdCriterioEvaluacion(String idCriterioEvaluacion) {
        this.idCriterioEvaluacion = idCriterioEvaluacion;
    }

    public String getDetallesCriterio() {
        return detallesCriterio;
    }

    public void setDetallesCriterio(String detallesCriterio) {
        this.detallesCriterio = detallesCriterio;
    }

    public String getNomCriterio() {
        return nomCriterio;
    }

    public void setNomCriterio(String nomCriterio) {
        this.nomCriterio = nomCriterio;
    }

    @XmlTransient
    public List<ActividadProyecto> getActividadProyectoList() {
        return actividadProyectoList;
    }

    public void setActividadProyectoList(List<ActividadProyecto> actividadProyectoList) {
        this.actividadProyectoList = actividadProyectoList;
    }

    @XmlTransient
    public List<EvidenciaAprendizaje> getEvidenciaAprendizajeList() {
        return evidenciaAprendizajeList;
    }

    public void setEvidenciaAprendizajeList(List<EvidenciaAprendizaje> evidenciaAprendizajeList) {
        this.evidenciaAprendizajeList = evidenciaAprendizajeList;
    }

    @XmlTransient
    public List<CriterioSeguimientoInstructor> getCriterioSeguimientoInstructorList() {
        return criterioSeguimientoInstructorList;
    }

    public void setCriterioSeguimientoInstructorList(List<CriterioSeguimientoInstructor> criterioSeguimientoInstructorList) {
        this.criterioSeguimientoInstructorList = criterioSeguimientoInstructorList;
    }

    @XmlTransient
    public List<PlaneacionClase> getPlaneacionClaseList() {
        return planeacionClaseList;
    }

    public void setPlaneacionClaseList(List<PlaneacionClase> planeacionClaseList) {
        this.planeacionClaseList = planeacionClaseList;
    }

    @XmlTransient
    public List<EvidenciaAprendizaje> getEvidenciaAprendizajeList1() {
        return evidenciaAprendizajeList1;
    }

    public void setEvidenciaAprendizajeList1(List<EvidenciaAprendizaje> evidenciaAprendizajeList1) {
        this.evidenciaAprendizajeList1 = evidenciaAprendizajeList1;
    }

    @XmlTransient
    public List<CriterioSeguimientoProyecto> getCriterioSeguimientoProyectoList() {
        return criterioSeguimientoProyectoList;
    }

    public void setCriterioSeguimientoProyectoList(List<CriterioSeguimientoProyecto> criterioSeguimientoProyectoList) {
        this.criterioSeguimientoProyectoList = criterioSeguimientoProyectoList;
    }

    public FactorProductiva getIdFactorProductiva() {
        return idFactorProductiva;
    }

    public void setIdFactorProductiva(FactorProductiva idFactorProductiva) {
        this.idFactorProductiva = idFactorProductiva;
    }

    public TituloCriterio getIdTituloCriterio() {
        return idTituloCriterio;
    }

    public void setIdTituloCriterio(TituloCriterio idTituloCriterio) {
        this.idTituloCriterio = idTituloCriterio;
    }

    public TipoCriterio getIdTipoCriterio() {
        return idTipoCriterio;
    }

    public void setIdTipoCriterio(TipoCriterio idTipoCriterio) {
        this.idTipoCriterio = idTipoCriterio;
    }

    @XmlTransient
    public List<CriterioSeguimiento> getCriterioSeguimientoList() {
        return criterioSeguimientoList;
    }

    public void setCriterioSeguimientoList(List<CriterioSeguimiento> criterioSeguimientoList) {
        this.criterioSeguimientoList = criterioSeguimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCriterioEvaluacion != null ? idCriterioEvaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriterioEvaluacion)) {
            return false;
        }
        CriterioEvaluacion other = (CriterioEvaluacion) object;
        if ((this.idCriterioEvaluacion == null && other.idCriterioEvaluacion != null) || (this.idCriterioEvaluacion != null && !this.idCriterioEvaluacion.equals(other.idCriterioEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.CriterioEvaluacion[ idCriterioEvaluacion=" + idCriterioEvaluacion + " ]";
    }
    
}
