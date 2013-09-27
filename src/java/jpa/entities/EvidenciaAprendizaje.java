/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MAURICIO
 */
@Entity
@Table(name = "evidencia_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvidenciaAprendizaje.findAll", query = "SELECT e FROM EvidenciaAprendizaje e"),
    @NamedQuery(name = "EvidenciaAprendizaje.findByIdEvidenciaAprendizaje", query = "SELECT e FROM EvidenciaAprendizaje e WHERE e.idEvidenciaAprendizaje = :idEvidenciaAprendizaje"),
    @NamedQuery(name = "EvidenciaAprendizaje.findByFechaEvidenciaAprendizaje", query = "SELECT e FROM EvidenciaAprendizaje e WHERE e.fechaEvidenciaAprendizaje = :fechaEvidenciaAprendizaje")})
public class EvidenciaAprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_evidencia_aprendizaje")
    private String idEvidenciaAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nom_evi_apr")
    private String nomEviApr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_evidencia_aprendizaje")
    @Temporal(TemporalType.DATE)
    private Date fechaEvidenciaAprendizaje;
    @ManyToMany(mappedBy = "evidenciaAprendizajeList")
    private List<CriterioEvaluacion> criterioEvaluacionList;
    @JoinTable(name = "evidencia_aprendizaje_tipo_evidencia", joinColumns = {
        @JoinColumn(name = "id_evidencia_aprendizaje", referencedColumnName = "id_evidencia_aprendizaje")}, inverseJoinColumns = {
        @JoinColumn(name = "id_tipo_evidencia_aprendizaje", referencedColumnName = "id_tipo_evidencia_aprendizaje")})
    @ManyToMany
    private List<TipoEvidenciaAprendizaje> tipoEvidenciaAprendizajeList;
    @JoinTable(name = "evidencia_criterio", joinColumns = {
        @JoinColumn(name = "id_evidencia_aprendizaje", referencedColumnName = "id_evidencia_aprendizaje")}, inverseJoinColumns = {
        @JoinColumn(name = "id_criterio_evaluacion", referencedColumnName = "id_criterio_evaluacion")})
    @ManyToMany
    private List<CriterioEvaluacion> criterioEvaluacionList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvidenciaAprendizaje")
    private List<ActividadPlan> actividadPlanList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvidenciaAprendizaje")
    private List<EvaluacionSeguimiento> evaluacionSeguimientoList;
    @JoinColumn(name = "id_tipo_evidencia_aprendizaje", referencedColumnName = "id_tipo_evidencia_aprendizaje")
    @ManyToOne(optional = false)
    private TipoEvidenciaAprendizaje idTipoEvidenciaAprendizaje;
    @JoinColumn(name = "id_criterio_evaluacion", referencedColumnName = "id_criterio_evaluacion")
    @ManyToOne(optional = false)
    private CriterioEvaluacion idCriterioEvaluacion;

    public EvidenciaAprendizaje() {
    }

    public EvidenciaAprendizaje(String idEvidenciaAprendizaje) {
        this.idEvidenciaAprendizaje = idEvidenciaAprendizaje;
    }

    public EvidenciaAprendizaje(String idEvidenciaAprendizaje, String nomEviApr, Date fechaEvidenciaAprendizaje) {
        this.idEvidenciaAprendizaje = idEvidenciaAprendizaje;
        this.nomEviApr = nomEviApr;
        this.fechaEvidenciaAprendizaje = fechaEvidenciaAprendizaje;
    }

    public String getIdEvidenciaAprendizaje() {
        return idEvidenciaAprendizaje;
    }

    public void setIdEvidenciaAprendizaje(String idEvidenciaAprendizaje) {
        this.idEvidenciaAprendizaje = idEvidenciaAprendizaje;
    }

    public String getNomEviApr() {
        return nomEviApr;
    }

    public void setNomEviApr(String nomEviApr) {
        this.nomEviApr = nomEviApr;
    }

    public Date getFechaEvidenciaAprendizaje() {
        return fechaEvidenciaAprendizaje;
    }

    public void setFechaEvidenciaAprendizaje(Date fechaEvidenciaAprendizaje) {
        this.fechaEvidenciaAprendizaje = fechaEvidenciaAprendizaje;
    }

    @XmlTransient
    public List<CriterioEvaluacion> getCriterioEvaluacionList() {
        return criterioEvaluacionList;
    }

    public void setCriterioEvaluacionList(List<CriterioEvaluacion> criterioEvaluacionList) {
        this.criterioEvaluacionList = criterioEvaluacionList;
    }

    @XmlTransient
    public List<TipoEvidenciaAprendizaje> getTipoEvidenciaAprendizajeList() {
        return tipoEvidenciaAprendizajeList;
    }

    public void setTipoEvidenciaAprendizajeList(List<TipoEvidenciaAprendizaje> tipoEvidenciaAprendizajeList) {
        this.tipoEvidenciaAprendizajeList = tipoEvidenciaAprendizajeList;
    }

    @XmlTransient
    public List<CriterioEvaluacion> getCriterioEvaluacionList1() {
        return criterioEvaluacionList1;
    }

    public void setCriterioEvaluacionList1(List<CriterioEvaluacion> criterioEvaluacionList1) {
        this.criterioEvaluacionList1 = criterioEvaluacionList1;
    }

    @XmlTransient
    public List<ActividadPlan> getActividadPlanList() {
        return actividadPlanList;
    }

    public void setActividadPlanList(List<ActividadPlan> actividadPlanList) {
        this.actividadPlanList = actividadPlanList;
    }

    @XmlTransient
    public List<EvaluacionSeguimiento> getEvaluacionSeguimientoList() {
        return evaluacionSeguimientoList;
    }

    public void setEvaluacionSeguimientoList(List<EvaluacionSeguimiento> evaluacionSeguimientoList) {
        this.evaluacionSeguimientoList = evaluacionSeguimientoList;
    }

    public TipoEvidenciaAprendizaje getIdTipoEvidenciaAprendizaje() {
        return idTipoEvidenciaAprendizaje;
    }

    public void setIdTipoEvidenciaAprendizaje(TipoEvidenciaAprendizaje idTipoEvidenciaAprendizaje) {
        this.idTipoEvidenciaAprendizaje = idTipoEvidenciaAprendizaje;
    }

    public CriterioEvaluacion getIdCriterioEvaluacion() {
        return idCriterioEvaluacion;
    }

    public void setIdCriterioEvaluacion(CriterioEvaluacion idCriterioEvaluacion) {
        this.idCriterioEvaluacion = idCriterioEvaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvidenciaAprendizaje != null ? idEvidenciaAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvidenciaAprendizaje)) {
            return false;
        }
        EvidenciaAprendizaje other = (EvidenciaAprendizaje) object;
        if ((this.idEvidenciaAprendizaje == null && other.idEvidenciaAprendizaje != null) || (this.idEvidenciaAprendizaje != null && !this.idEvidenciaAprendizaje.equals(other.idEvidenciaAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EvidenciaAprendizaje[ idEvidenciaAprendizaje=" + idEvidenciaAprendizaje + " ]";
    }
    
}
