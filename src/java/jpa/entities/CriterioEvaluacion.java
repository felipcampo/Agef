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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MAURICIO
 */
@Entity
@Table(name = "criterio_evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriterioEvaluacion.findAll", query = "SELECT c FROM CriterioEvaluacion c"),
    @NamedQuery(name = "CriterioEvaluacion.findByIdCriterioEvaluacion", query = "SELECT c FROM CriterioEvaluacion c WHERE c.idCriterioEvaluacion = :idCriterioEvaluacion")})
public class CriterioEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_criterio_evaluacion")
    private Integer idCriterioEvaluacion;
    @Lob
    @Size(max = 65535)
    @Column(name = "detalles_criterio")
    private String detallesCriterio;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "nom_criterio")
    private String nomCriterio;
    @JoinTable(name = "evidencia_aprendizaje_criterio_evaluacion", joinColumns = {
        @JoinColumn(name = "id_criterio_evaluacion", referencedColumnName = "id_criterio_evaluacion")}, inverseJoinColumns = {
        @JoinColumn(name = "id_evidencia_aprendizaje", referencedColumnName = "id_evidencia_aprendizaje")})
    @ManyToMany
    private List<EvidenciaAprendizaje> evidenciaAprendizajeList;
    @ManyToMany(mappedBy = "criterioEvaluacionList")
    private List<ActividadProyecto> actividadProyectoList;
    @ManyToMany(mappedBy = "criterioEvaluacionList1")
    private List<EvidenciaAprendizaje> evidenciaAprendizajeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCriterioEvaluacion")
    private List<CriterioSeguimientoInstructor> criterioSeguimientoInstructorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCriterioEvaluacion")
    private List<PlaneacionClase> planeacionClaseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCriterioEvaluacion")
    private List<SeguimientoInstructor> seguimientoInstructorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCriterioEvaluacion")
    private List<EvidenciaAprendizaje> evidenciaAprendizajeList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCriterioEvaluacion")
    private List<CriterioSeguimientoProyecto> criterioSeguimientoProyectoList;
    @JoinColumn(name = "id_titulo_criterio", referencedColumnName = "id_titulo_criterio")
    @ManyToOne
    private TituloCriterio idTituloCriterio;
    @JoinColumn(name = "id_tipo_criterio", referencedColumnName = "id_tipo_criterio")
    @ManyToOne
    private TipoCriterio idTipoCriterio;
    @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id_resultado_aprendizaje")
    @ManyToOne
    private ResultadoAprendizaje idResultadoAprendizaje;
    @JoinColumn(name = "id_factor_productiva", referencedColumnName = "id_factor_productiva")
    @ManyToOne
    private FactorProductiva idFactorProductiva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCriterioEvaluacion")
    private List<CriterioSeguimiento> criterioSeguimientoList;

    public CriterioEvaluacion() {
    }

    public CriterioEvaluacion(Integer idCriterioEvaluacion) {
        this.idCriterioEvaluacion = idCriterioEvaluacion;
    }

    public Integer getIdCriterioEvaluacion() {
        return idCriterioEvaluacion;
    }

    public void setIdCriterioEvaluacion(Integer idCriterioEvaluacion) {
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
    public List<EvidenciaAprendizaje> getEvidenciaAprendizajeList() {
        return evidenciaAprendizajeList;
    }

    public void setEvidenciaAprendizajeList(List<EvidenciaAprendizaje> evidenciaAprendizajeList) {
        this.evidenciaAprendizajeList = evidenciaAprendizajeList;
    }

    @XmlTransient
    public List<ActividadProyecto> getActividadProyectoList() {
        return actividadProyectoList;
    }

    public void setActividadProyectoList(List<ActividadProyecto> actividadProyectoList) {
        this.actividadProyectoList = actividadProyectoList;
    }

    @XmlTransient
    public List<EvidenciaAprendizaje> getEvidenciaAprendizajeList1() {
        return evidenciaAprendizajeList1;
    }

    public void setEvidenciaAprendizajeList1(List<EvidenciaAprendizaje> evidenciaAprendizajeList1) {
        this.evidenciaAprendizajeList1 = evidenciaAprendizajeList1;
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
    public List<SeguimientoInstructor> getSeguimientoInstructorList() {
        return seguimientoInstructorList;
    }

    public void setSeguimientoInstructorList(List<SeguimientoInstructor> seguimientoInstructorList) {
        this.seguimientoInstructorList = seguimientoInstructorList;
    }

    @XmlTransient
    public List<EvidenciaAprendizaje> getEvidenciaAprendizajeList2() {
        return evidenciaAprendizajeList2;
    }

    public void setEvidenciaAprendizajeList2(List<EvidenciaAprendizaje> evidenciaAprendizajeList2) {
        this.evidenciaAprendizajeList2 = evidenciaAprendizajeList2;
    }

    @XmlTransient
    public List<CriterioSeguimientoProyecto> getCriterioSeguimientoProyectoList() {
        return criterioSeguimientoProyectoList;
    }

    public void setCriterioSeguimientoProyectoList(List<CriterioSeguimientoProyecto> criterioSeguimientoProyectoList) {
        this.criterioSeguimientoProyectoList = criterioSeguimientoProyectoList;
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

    public ResultadoAprendizaje getIdResultadoAprendizaje() {
        return idResultadoAprendizaje;
    }

    public void setIdResultadoAprendizaje(ResultadoAprendizaje idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }

    public FactorProductiva getIdFactorProductiva() {
        return idFactorProductiva;
    }

    public void setIdFactorProductiva(FactorProductiva idFactorProductiva) {
        this.idFactorProductiva = idFactorProductiva;
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
