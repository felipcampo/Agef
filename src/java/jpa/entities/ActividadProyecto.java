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
 * @author MAURICIO
 */
@Entity
@Table(name = "actividad_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadProyecto.findAll", query = "SELECT a FROM ActividadProyecto a"),
    @NamedQuery(name = "ActividadProyecto.findByIdActividadProyecto", query = "SELECT a FROM ActividadProyecto a WHERE a.idActividadProyecto = :idActividadProyecto"),
    @NamedQuery(name = "ActividadProyecto.findByDescrActividadProyecto", query = "SELECT a FROM ActividadProyecto a WHERE a.descrActividadProyecto = :descrActividadProyecto"),
    @NamedQuery(name = "ActividadProyecto.findByDuracionActividad", query = "SELECT a FROM ActividadProyecto a WHERE a.duracionActividad = :duracionActividad")})
public class ActividadProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_actividad_proyecto")
    private String idActividadProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descr_actividad_proyecto")
    private String descrActividadProyecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion_actividad")
    private int duracionActividad;
    @JoinTable(name = "actividad_criterio", joinColumns = {
        @JoinColumn(name = "id_actividad_proyecto", referencedColumnName = "id_actividad_proyecto")}, inverseJoinColumns = {
        @JoinColumn(name = "id_criterio_evaluacion", referencedColumnName = "id_criterio_evaluacion")})
    @ManyToMany
    private List<CriterioEvaluacion> criterioEvaluacionList;
    @JoinTable(name = "actividad_proyecto_formativo", joinColumns = {
        @JoinColumn(name = "id_actividad_proyecto", referencedColumnName = "id_actividad_proyecto")}, inverseJoinColumns = {
        @JoinColumn(name = "id_proyecto_formativo", referencedColumnName = "id_proyecto_formativo")})
    @ManyToMany
    private List<ProyectoFormativo> proyectoFormativoList;
    @JoinTable(name = "competencia_actividad", joinColumns = {
        @JoinColumn(name = "id_actividad_proyecto", referencedColumnName = "id_actividad_proyecto")}, inverseJoinColumns = {
        @JoinColumn(name = "id_competencia", referencedColumnName = "id_competencia")})
    @ManyToMany
    private List<Competencia> competenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividadProyecto")
    private List<ProgramacionProyecto> programacionProyectoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividadProyecto")
    private List<GuiaAprendizaje> guiaAprendizajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividadProyecto")
    private List<Competencia> competenciaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividadProyecto")
    private List<PlanMejoramiento> planMejoramientoList;
    @JoinColumn(name = "id_fase_proyecto", referencedColumnName = "id_fase_proyecto")
    @ManyToOne(optional = false)
    private FaseProyecto idFaseProyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividadProyecto")
    private List<Alistamiento> alistamientoList;

    public ActividadProyecto() {
    }

    public ActividadProyecto(String idActividadProyecto) {
        this.idActividadProyecto = idActividadProyecto;
    }

    public ActividadProyecto(String idActividadProyecto, String descrActividadProyecto, int duracionActividad) {
        this.idActividadProyecto = idActividadProyecto;
        this.descrActividadProyecto = descrActividadProyecto;
        this.duracionActividad = duracionActividad;
    }

    public String getIdActividadProyecto() {
        return idActividadProyecto;
    }

    public void setIdActividadProyecto(String idActividadProyecto) {
        this.idActividadProyecto = idActividadProyecto;
    }

    public String getDescrActividadProyecto() {
        return descrActividadProyecto;
    }

    public void setDescrActividadProyecto(String descrActividadProyecto) {
        this.descrActividadProyecto = descrActividadProyecto;
    }

    public int getDuracionActividad() {
        return duracionActividad;
    }

    public void setDuracionActividad(int duracionActividad) {
        this.duracionActividad = duracionActividad;
    }

    @XmlTransient
    public List<CriterioEvaluacion> getCriterioEvaluacionList() {
        return criterioEvaluacionList;
    }

    public void setCriterioEvaluacionList(List<CriterioEvaluacion> criterioEvaluacionList) {
        this.criterioEvaluacionList = criterioEvaluacionList;
    }

    @XmlTransient
    public List<ProyectoFormativo> getProyectoFormativoList() {
        return proyectoFormativoList;
    }

    public void setProyectoFormativoList(List<ProyectoFormativo> proyectoFormativoList) {
        this.proyectoFormativoList = proyectoFormativoList;
    }

    @XmlTransient
    public List<Competencia> getCompetenciaList() {
        return competenciaList;
    }

    public void setCompetenciaList(List<Competencia> competenciaList) {
        this.competenciaList = competenciaList;
    }

    @XmlTransient
    public List<ProgramacionProyecto> getProgramacionProyectoList() {
        return programacionProyectoList;
    }

    public void setProgramacionProyectoList(List<ProgramacionProyecto> programacionProyectoList) {
        this.programacionProyectoList = programacionProyectoList;
    }

    @XmlTransient
    public List<GuiaAprendizaje> getGuiaAprendizajeList() {
        return guiaAprendizajeList;
    }

    public void setGuiaAprendizajeList(List<GuiaAprendizaje> guiaAprendizajeList) {
        this.guiaAprendizajeList = guiaAprendizajeList;
    }

    @XmlTransient
    public List<Competencia> getCompetenciaList1() {
        return competenciaList1;
    }

    public void setCompetenciaList1(List<Competencia> competenciaList1) {
        this.competenciaList1 = competenciaList1;
    }

    @XmlTransient
    public List<PlanMejoramiento> getPlanMejoramientoList() {
        return planMejoramientoList;
    }

    public void setPlanMejoramientoList(List<PlanMejoramiento> planMejoramientoList) {
        this.planMejoramientoList = planMejoramientoList;
    }

    public FaseProyecto getIdFaseProyecto() {
        return idFaseProyecto;
    }

    public void setIdFaseProyecto(FaseProyecto idFaseProyecto) {
        this.idFaseProyecto = idFaseProyecto;
    }

    @XmlTransient
    public List<Alistamiento> getAlistamientoList() {
        return alistamientoList;
    }

    public void setAlistamientoList(List<Alistamiento> alistamientoList) {
        this.alistamientoList = alistamientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividadProyecto != null ? idActividadProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadProyecto)) {
            return false;
        }
        ActividadProyecto other = (ActividadProyecto) object;
        if ((this.idActividadProyecto == null && other.idActividadProyecto != null) || (this.idActividadProyecto != null && !this.idActividadProyecto.equals(other.idActividadProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ActividadProyecto[ idActividadProyecto=" + idActividadProyecto + " ]";
    }
    
}
