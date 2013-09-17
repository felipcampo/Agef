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
 * @author ADSI
 */
@Entity
@Table(name = "evidencia_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvidenciaAprendizaje.findAll", query = "SELECT e FROM EvidenciaAprendizaje e"),
    @NamedQuery(name = "EvidenciaAprendizaje.findByIdEvidenciaAprendizaje", query = "SELECT e FROM EvidenciaAprendizaje e WHERE e.idEvidenciaAprendizaje = :idEvidenciaAprendizaje"),
    @NamedQuery(name = "EvidenciaAprendizaje.findByAutentico", query = "SELECT e FROM EvidenciaAprendizaje e WHERE e.autentico = :autentico"),
    @NamedQuery(name = "EvidenciaAprendizaje.findByCalidad", query = "SELECT e FROM EvidenciaAprendizaje e WHERE e.calidad = :calidad"),
    @NamedQuery(name = "EvidenciaAprendizaje.findByFechaEvidenciaAprendizaje", query = "SELECT e FROM EvidenciaAprendizaje e WHERE e.fechaEvidenciaAprendizaje = :fechaEvidenciaAprendizaje"),
    @NamedQuery(name = "EvidenciaAprendizaje.findByPertinente", query = "SELECT e FROM EvidenciaAprendizaje e WHERE e.pertinente = :pertinente"),
    @NamedQuery(name = "EvidenciaAprendizaje.findByValidez", query = "SELECT e FROM EvidenciaAprendizaje e WHERE e.validez = :validez")})
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
    @Column(name = "autentico")
    private boolean autentico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calidad")
    private boolean calidad;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descr_evi_apr")
    private String descrEviApr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_evidencia_aprendizaje")
    @Temporal(TemporalType.DATE)
    private Date fechaEvidenciaAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nom_evi_apr")
    private String nomEviApr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pertinente")
    private boolean pertinente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validez")
    private boolean validez;
    @JoinTable(name = "evidencia_aprendizaje_tipo_evidencia", joinColumns = {
        @JoinColumn(name = "id_evidencia_aprendizaje", referencedColumnName = "id_evidencia_aprendizaje")}, inverseJoinColumns = {
        @JoinColumn(name = "id_tipo_evidencia_aprendizaje", referencedColumnName = "id_tipo_evidencia_aprendizaje")})
    @ManyToMany
    private List<TipoEvidenciaAprendizaje> tipoEvidenciaAprendizajeList;
    @JoinTable(name = "evidencia_criterio", joinColumns = {
        @JoinColumn(name = "id_evidencia_aprendizaje", referencedColumnName = "id_evidencia_aprendizaje")}, inverseJoinColumns = {
        @JoinColumn(name = "id_criterio_evaluacion", referencedColumnName = "id_criterio_evaluacion")})
    @ManyToMany
    private List<CriterioEvaluacion> criterioEvaluacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvidenciaAprendizaje")
    private List<EvaluacionSeguimiento> evaluacionSeguimientoList;
    @JoinColumn(name = "id_criterio_evaluacion", referencedColumnName = "id_criterio_evaluacion")
    @ManyToOne(optional = false)
    private CriterioEvaluacion idCriterioEvaluacion;
    @JoinColumn(name = "id_ambiente", referencedColumnName = "id_ambiente")
    @ManyToOne(optional = false)
    private Ambiente idAmbiente;
    @JoinColumn(name = "id_subactividad_proyecto", referencedColumnName = "id_subactividad_proyecto")
    @ManyToOne(optional = false)
    private SubactividadProyecto idSubactividadProyecto;
    @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id_resultado_aprendizaje")
    @ManyToOne(optional = false)
    private ResultadoAprendizaje idResultadoAprendizaje;
    @OneToMany(mappedBy = "idEvidenciaAprendizaje")
    private List<ProyectoFormativo> proyectoFormativoList;

    public EvidenciaAprendizaje() {
    }

    public EvidenciaAprendizaje(String idEvidenciaAprendizaje) {
        this.idEvidenciaAprendizaje = idEvidenciaAprendizaje;
    }

    public EvidenciaAprendizaje(String idEvidenciaAprendizaje, boolean autentico, boolean calidad, String descrEviApr, Date fechaEvidenciaAprendizaje, String nomEviApr, boolean pertinente, boolean validez) {
        this.idEvidenciaAprendizaje = idEvidenciaAprendizaje;
        this.autentico = autentico;
        this.calidad = calidad;
        this.descrEviApr = descrEviApr;
        this.fechaEvidenciaAprendizaje = fechaEvidenciaAprendizaje;
        this.nomEviApr = nomEviApr;
        this.pertinente = pertinente;
        this.validez = validez;
    }

    public String getIdEvidenciaAprendizaje() {
        return idEvidenciaAprendizaje;
    }

    public void setIdEvidenciaAprendizaje(String idEvidenciaAprendizaje) {
        this.idEvidenciaAprendizaje = idEvidenciaAprendizaje;
    }

    public boolean getAutentico() {
        return autentico;
    }

    public void setAutentico(boolean autentico) {
        this.autentico = autentico;
    }

    public boolean getCalidad() {
        return calidad;
    }

    public void setCalidad(boolean calidad) {
        this.calidad = calidad;
    }

    public String getDescrEviApr() {
        return descrEviApr;
    }

    public void setDescrEviApr(String descrEviApr) {
        this.descrEviApr = descrEviApr;
    }

    public Date getFechaEvidenciaAprendizaje() {
        return fechaEvidenciaAprendizaje;
    }

    public void setFechaEvidenciaAprendizaje(Date fechaEvidenciaAprendizaje) {
        this.fechaEvidenciaAprendizaje = fechaEvidenciaAprendizaje;
    }

    public String getNomEviApr() {
        return nomEviApr;
    }

    public void setNomEviApr(String nomEviApr) {
        this.nomEviApr = nomEviApr;
    }

    public boolean getPertinente() {
        return pertinente;
    }

    public void setPertinente(boolean pertinente) {
        this.pertinente = pertinente;
    }

    public boolean getValidez() {
        return validez;
    }

    public void setValidez(boolean validez) {
        this.validez = validez;
    }

    @XmlTransient
    public List<TipoEvidenciaAprendizaje> getTipoEvidenciaAprendizajeList() {
        return tipoEvidenciaAprendizajeList;
    }

    public void setTipoEvidenciaAprendizajeList(List<TipoEvidenciaAprendizaje> tipoEvidenciaAprendizajeList) {
        this.tipoEvidenciaAprendizajeList = tipoEvidenciaAprendizajeList;
    }

    @XmlTransient
    public List<CriterioEvaluacion> getCriterioEvaluacionList() {
        return criterioEvaluacionList;
    }

    public void setCriterioEvaluacionList(List<CriterioEvaluacion> criterioEvaluacionList) {
        this.criterioEvaluacionList = criterioEvaluacionList;
    }

    @XmlTransient
    public List<EvaluacionSeguimiento> getEvaluacionSeguimientoList() {
        return evaluacionSeguimientoList;
    }

    public void setEvaluacionSeguimientoList(List<EvaluacionSeguimiento> evaluacionSeguimientoList) {
        this.evaluacionSeguimientoList = evaluacionSeguimientoList;
    }

    public CriterioEvaluacion getIdCriterioEvaluacion() {
        return idCriterioEvaluacion;
    }

    public void setIdCriterioEvaluacion(CriterioEvaluacion idCriterioEvaluacion) {
        this.idCriterioEvaluacion = idCriterioEvaluacion;
    }

    public Ambiente getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(Ambiente idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public SubactividadProyecto getIdSubactividadProyecto() {
        return idSubactividadProyecto;
    }

    public void setIdSubactividadProyecto(SubactividadProyecto idSubactividadProyecto) {
        this.idSubactividadProyecto = idSubactividadProyecto;
    }

    public ResultadoAprendizaje getIdResultadoAprendizaje() {
        return idResultadoAprendizaje;
    }

    public void setIdResultadoAprendizaje(ResultadoAprendizaje idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }

    @XmlTransient
    public List<ProyectoFormativo> getProyectoFormativoList() {
        return proyectoFormativoList;
    }

    public void setProyectoFormativoList(List<ProyectoFormativo> proyectoFormativoList) {
        this.proyectoFormativoList = proyectoFormativoList;
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
