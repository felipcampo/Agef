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
@Table(name = "resultado_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultadoAprendizaje.findAll", query = "SELECT r FROM ResultadoAprendizaje r"),
    @NamedQuery(name = "ResultadoAprendizaje.findByIdResultadoAprendizaje", query = "SELECT r FROM ResultadoAprendizaje r WHERE r.idResultadoAprendizaje = :idResultadoAprendizaje")})
public class ResultadoAprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_resultado_aprendizaje")
    private Integer idResultadoAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descr_nom_resu_apr")
    private String descrNomResuApr;
    @JoinTable(name = "plan_resultado", joinColumns = {
        @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id_resultado_aprendizaje")}, inverseJoinColumns = {
        @JoinColumn(name = "id_plan_mejoramiento", referencedColumnName = "id_plan_mejoramiento")})
    @ManyToMany
    private List<PlanMejoramiento> planMejoramientoList;
    @ManyToMany(mappedBy = "resultadoAprendizajeList")
    private List<Competencia> competenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResultadoAprendizaje")
    private List<EvaluacionSeguimiento> evaluacionSeguimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResultadoAprendizaje")
    private List<ReporteNovedad> reporteNovedadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResultadoAprendizaje")
    private List<ProgramacionProyecto> programacionProyectoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResultadoAprendizaje")
    private List<PlanMejoramiento> planMejoramientoList1;
    @OneToMany(mappedBy = "idResultadoAprendizaje")
    private List<CriterioEvaluacion> criterioEvaluacionList;
    @OneToMany(mappedBy = "idResultadoAprendizaje")
    private List<SeguimientoProyecto> seguimientoProyectoList;

    public ResultadoAprendizaje() {
    }

    public ResultadoAprendizaje(Integer idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }

    public ResultadoAprendizaje(Integer idResultadoAprendizaje, String descrNomResuApr) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
        this.descrNomResuApr = descrNomResuApr;
    }

    public Integer getIdResultadoAprendizaje() {
        return idResultadoAprendizaje;
    }

    public void setIdResultadoAprendizaje(Integer idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }

    public String getDescrNomResuApr() {
        return descrNomResuApr;
    }

    public void setDescrNomResuApr(String descrNomResuApr) {
        this.descrNomResuApr = descrNomResuApr;
    }

    @XmlTransient
    public List<PlanMejoramiento> getPlanMejoramientoList() {
        return planMejoramientoList;
    }

    public void setPlanMejoramientoList(List<PlanMejoramiento> planMejoramientoList) {
        this.planMejoramientoList = planMejoramientoList;
    }

    @XmlTransient
    public List<Competencia> getCompetenciaList() {
        return competenciaList;
    }

    public void setCompetenciaList(List<Competencia> competenciaList) {
        this.competenciaList = competenciaList;
    }

    @XmlTransient
    public List<EvaluacionSeguimiento> getEvaluacionSeguimientoList() {
        return evaluacionSeguimientoList;
    }

    public void setEvaluacionSeguimientoList(List<EvaluacionSeguimiento> evaluacionSeguimientoList) {
        this.evaluacionSeguimientoList = evaluacionSeguimientoList;
    }

    @XmlTransient
    public List<ReporteNovedad> getReporteNovedadList() {
        return reporteNovedadList;
    }

    public void setReporteNovedadList(List<ReporteNovedad> reporteNovedadList) {
        this.reporteNovedadList = reporteNovedadList;
    }

    @XmlTransient
    public List<ProgramacionProyecto> getProgramacionProyectoList() {
        return programacionProyectoList;
    }

    public void setProgramacionProyectoList(List<ProgramacionProyecto> programacionProyectoList) {
        this.programacionProyectoList = programacionProyectoList;
    }

    @XmlTransient
    public List<PlanMejoramiento> getPlanMejoramientoList1() {
        return planMejoramientoList1;
    }

    public void setPlanMejoramientoList1(List<PlanMejoramiento> planMejoramientoList1) {
        this.planMejoramientoList1 = planMejoramientoList1;
    }

    @XmlTransient
    public List<CriterioEvaluacion> getCriterioEvaluacionList() {
        return criterioEvaluacionList;
    }

    public void setCriterioEvaluacionList(List<CriterioEvaluacion> criterioEvaluacionList) {
        this.criterioEvaluacionList = criterioEvaluacionList;
    }

    @XmlTransient
    public List<SeguimientoProyecto> getSeguimientoProyectoList() {
        return seguimientoProyectoList;
    }

    public void setSeguimientoProyectoList(List<SeguimientoProyecto> seguimientoProyectoList) {
        this.seguimientoProyectoList = seguimientoProyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultadoAprendizaje != null ? idResultadoAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultadoAprendizaje)) {
            return false;
        }
        ResultadoAprendizaje other = (ResultadoAprendizaje) object;
        if ((this.idResultadoAprendizaje == null && other.idResultadoAprendizaje != null) || (this.idResultadoAprendizaje != null && !this.idResultadoAprendizaje.equals(other.idResultadoAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ResultadoAprendizaje[ idResultadoAprendizaje=" + idResultadoAprendizaje + " ]";
    }
    
}
