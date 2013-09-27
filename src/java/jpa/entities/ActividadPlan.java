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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "actividad_plan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadPlan.findAll", query = "SELECT a FROM ActividadPlan a"),
    @NamedQuery(name = "ActividadPlan.findByIdActividadPlan", query = "SELECT a FROM ActividadPlan a WHERE a.idActividadPlan = :idActividadPlan"),
    @NamedQuery(name = "ActividadPlan.findByDescripcionActividad", query = "SELECT a FROM ActividadPlan a WHERE a.descripcionActividad = :descripcionActividad"),
    @NamedQuery(name = "ActividadPlan.findByFecFin", query = "SELECT a FROM ActividadPlan a WHERE a.fecFin = :fecFin"),
    @NamedQuery(name = "ActividadPlan.findByFecIni", query = "SELECT a FROM ActividadPlan a WHERE a.fecIni = :fecIni"),
    @NamedQuery(name = "ActividadPlan.findByLugar", query = "SELECT a FROM ActividadPlan a WHERE a.lugar = :lugar"),
    @NamedQuery(name = "ActividadPlan.findByPertinencia", query = "SELECT a FROM ActividadPlan a WHERE a.pertinencia = :pertinencia"),
    @NamedQuery(name = "ActividadPlan.findByVigencia", query = "SELECT a FROM ActividadPlan a WHERE a.vigencia = :vigencia"),
    @NamedQuery(name = "ActividadPlan.findByAutenticidad", query = "SELECT a FROM ActividadPlan a WHERE a.autenticidad = :autenticidad"),
    @NamedQuery(name = "ActividadPlan.findByCalidad", query = "SELECT a FROM ActividadPlan a WHERE a.calidad = :calidad"),
    @NamedQuery(name = "ActividadPlan.findByAprendizaje", query = "SELECT a FROM ActividadPlan a WHERE a.aprendizaje = :aprendizaje"),
    @NamedQuery(name = "ActividadPlan.findByFecRevision", query = "SELECT a FROM ActividadPlan a WHERE a.fecRevision = :fecRevision"),
    @NamedQuery(name = "ActividadPlan.findByLugar2", query = "SELECT a FROM ActividadPlan a WHERE a.lugar2 = :lugar2")})
public class ActividadPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_actividad_plan")
    private Integer idActividadPlan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion_actividad")
    private String descripcionActividad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_fin")
    @Temporal(TemporalType.DATE)
    private Date fecFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_ini")
    @Temporal(TemporalType.DATE)
    private Date fecIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lugar")
    private boolean lugar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pertinencia")
    private boolean pertinencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vigencia")
    private boolean vigencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autenticidad")
    private boolean autenticidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calidad")
    private boolean calidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aprendizaje")
    private boolean aprendizaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_revision")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRevision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lugar2")
    private boolean lugar2;
    @JoinColumn(name = "id_evidencia_aprendizaje", referencedColumnName = "id_evidencia_aprendizaje")
    @ManyToOne(optional = false)
    private EvidenciaAprendizaje idEvidenciaAprendizaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividadPlan")
    private List<PlanMejoramiento> planMejoramientoList;

    public ActividadPlan() {
    }

    public ActividadPlan(Integer idActividadPlan) {
        this.idActividadPlan = idActividadPlan;
    }

    public ActividadPlan(Integer idActividadPlan, String descripcionActividad, Date fecFin, Date fecIni, boolean lugar, boolean pertinencia, boolean vigencia, boolean autenticidad, boolean calidad, boolean aprendizaje, Date fecRevision, boolean lugar2) {
        this.idActividadPlan = idActividadPlan;
        this.descripcionActividad = descripcionActividad;
        this.fecFin = fecFin;
        this.fecIni = fecIni;
        this.lugar = lugar;
        this.pertinencia = pertinencia;
        this.vigencia = vigencia;
        this.autenticidad = autenticidad;
        this.calidad = calidad;
        this.aprendizaje = aprendizaje;
        this.fecRevision = fecRevision;
        this.lugar2 = lugar2;
    }

    public Integer getIdActividadPlan() {
        return idActividadPlan;
    }

    public void setIdActividadPlan(Integer idActividadPlan) {
        this.idActividadPlan = idActividadPlan;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public Date getFecIni() {
        return fecIni;
    }

    public void setFecIni(Date fecIni) {
        this.fecIni = fecIni;
    }

    public boolean getLugar() {
        return lugar;
    }

    public void setLugar(boolean lugar) {
        this.lugar = lugar;
    }

    public boolean getPertinencia() {
        return pertinencia;
    }

    public void setPertinencia(boolean pertinencia) {
        this.pertinencia = pertinencia;
    }

    public boolean getVigencia() {
        return vigencia;
    }

    public void setVigencia(boolean vigencia) {
        this.vigencia = vigencia;
    }

    public boolean getAutenticidad() {
        return autenticidad;
    }

    public void setAutenticidad(boolean autenticidad) {
        this.autenticidad = autenticidad;
    }

    public boolean getCalidad() {
        return calidad;
    }

    public void setCalidad(boolean calidad) {
        this.calidad = calidad;
    }

    public boolean getAprendizaje() {
        return aprendizaje;
    }

    public void setAprendizaje(boolean aprendizaje) {
        this.aprendizaje = aprendizaje;
    }

    public Date getFecRevision() {
        return fecRevision;
    }

    public void setFecRevision(Date fecRevision) {
        this.fecRevision = fecRevision;
    }

    public boolean getLugar2() {
        return lugar2;
    }

    public void setLugar2(boolean lugar2) {
        this.lugar2 = lugar2;
    }

    public EvidenciaAprendizaje getIdEvidenciaAprendizaje() {
        return idEvidenciaAprendizaje;
    }

    public void setIdEvidenciaAprendizaje(EvidenciaAprendizaje idEvidenciaAprendizaje) {
        this.idEvidenciaAprendizaje = idEvidenciaAprendizaje;
    }

    @XmlTransient
    public List<PlanMejoramiento> getPlanMejoramientoList() {
        return planMejoramientoList;
    }

    public void setPlanMejoramientoList(List<PlanMejoramiento> planMejoramientoList) {
        this.planMejoramientoList = planMejoramientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividadPlan != null ? idActividadPlan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadPlan)) {
            return false;
        }
        ActividadPlan other = (ActividadPlan) object;
        if ((this.idActividadPlan == null && other.idActividadPlan != null) || (this.idActividadPlan != null && !this.idActividadPlan.equals(other.idActividadPlan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ActividadPlan[ idActividadPlan=" + idActividadPlan + " ]";
    }
    
}
