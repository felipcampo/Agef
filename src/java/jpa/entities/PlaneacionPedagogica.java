/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leoandresm
 */
@Entity
@Table(name = "planeacion_pedagogica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlaneacionPedagogica.findAll", query = "SELECT p FROM PlaneacionPedagogica p"),
    @NamedQuery(name = "PlaneacionPedagogica.findByIdPlaneacionPedagogica", query = "SELECT p FROM PlaneacionPedagogica p WHERE p.idPlaneacionPedagogica = :idPlaneacionPedagogica"),
    @NamedQuery(name = "PlaneacionPedagogica.findByFechaPlaneacion", query = "SELECT p FROM PlaneacionPedagogica p WHERE p.fechaPlaneacion = :fechaPlaneacion"),
    @NamedQuery(name = "PlaneacionPedagogica.findByFechaInicio", query = "SELECT p FROM PlaneacionPedagogica p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "PlaneacionPedagogica.findByFechaFinal", query = "SELECT p FROM PlaneacionPedagogica p WHERE p.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "PlaneacionPedagogica.findByCiudad", query = "SELECT p FROM PlaneacionPedagogica p WHERE p.ciudad = :ciudad")})
public class PlaneacionPedagogica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_planeacion_pedagogica")
    private Integer idPlaneacionPedagogica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_planeacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPlaneacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_final")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "estrategias_didacticas")
    private String estrategiasDidacticas;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "recursos_didacticos")
    private String recursosDidacticos;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "escenarios")
    private String escenarios;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "criterio_evaluacion")
    private String criterioEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "decr_evidencia_aprendizaje")
    private String decrEvidenciaAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_subactividad_proyecto", referencedColumnName = "id_subactividad_proyecto")
    @ManyToOne(optional = false)
    private SubactividadProyecto idSubactividadProyecto;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_proyecto_formativo", referencedColumnName = "id_proyecto_formativo")
    @ManyToOne(optional = false)
    private ProyectoFormativo idProyectoFormativo;
    @OneToMany(mappedBy = "idPlaneacionPedagogica")
    private List<Alistamiento> alistamientoList;

    public PlaneacionPedagogica() {
    }

    public PlaneacionPedagogica(Integer idPlaneacionPedagogica) {
        this.idPlaneacionPedagogica = idPlaneacionPedagogica;
    }

    public PlaneacionPedagogica(Integer idPlaneacionPedagogica, Date fechaPlaneacion, Date fechaInicio, Date fechaFinal, String ciudad, String estrategiasDidacticas, String recursosDidacticos, String escenarios, String criterioEvaluacion, String decrEvidenciaAprendizaje, String observaciones) {
        this.idPlaneacionPedagogica = idPlaneacionPedagogica;
        this.fechaPlaneacion = fechaPlaneacion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.ciudad = ciudad;
        this.estrategiasDidacticas = estrategiasDidacticas;
        this.recursosDidacticos = recursosDidacticos;
        this.escenarios = escenarios;
        this.criterioEvaluacion = criterioEvaluacion;
        this.decrEvidenciaAprendizaje = decrEvidenciaAprendizaje;
        this.observaciones = observaciones;
    }

    public Integer getIdPlaneacionPedagogica() {
        return idPlaneacionPedagogica;
    }

    public void setIdPlaneacionPedagogica(Integer idPlaneacionPedagogica) {
        this.idPlaneacionPedagogica = idPlaneacionPedagogica;
    }

    public Date getFechaPlaneacion() {
        return fechaPlaneacion;
    }

    public void setFechaPlaneacion(Date fechaPlaneacion) {
        this.fechaPlaneacion = fechaPlaneacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstrategiasDidacticas() {
        return estrategiasDidacticas;
    }

    public void setEstrategiasDidacticas(String estrategiasDidacticas) {
        this.estrategiasDidacticas = estrategiasDidacticas;
    }

    public String getRecursosDidacticos() {
        return recursosDidacticos;
    }

    public void setRecursosDidacticos(String recursosDidacticos) {
        this.recursosDidacticos = recursosDidacticos;
    }

    public String getEscenarios() {
        return escenarios;
    }

    public void setEscenarios(String escenarios) {
        this.escenarios = escenarios;
    }

    public String getCriterioEvaluacion() {
        return criterioEvaluacion;
    }

    public void setCriterioEvaluacion(String criterioEvaluacion) {
        this.criterioEvaluacion = criterioEvaluacion;
    }

    public String getDecrEvidenciaAprendizaje() {
        return decrEvidenciaAprendizaje;
    }

    public void setDecrEvidenciaAprendizaje(String decrEvidenciaAprendizaje) {
        this.decrEvidenciaAprendizaje = decrEvidenciaAprendizaje;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public SubactividadProyecto getIdSubactividadProyecto() {
        return idSubactividadProyecto;
    }

    public void setIdSubactividadProyecto(SubactividadProyecto idSubactividadProyecto) {
        this.idSubactividadProyecto = idSubactividadProyecto;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ProyectoFormativo getIdProyectoFormativo() {
        return idProyectoFormativo;
    }

    public void setIdProyectoFormativo(ProyectoFormativo idProyectoFormativo) {
        this.idProyectoFormativo = idProyectoFormativo;
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
        hash += (idPlaneacionPedagogica != null ? idPlaneacionPedagogica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaneacionPedagogica)) {
            return false;
        }
        PlaneacionPedagogica other = (PlaneacionPedagogica) object;
        if ((this.idPlaneacionPedagogica == null && other.idPlaneacionPedagogica != null) || (this.idPlaneacionPedagogica != null && !this.idPlaneacionPedagogica.equals(other.idPlaneacionPedagogica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.PlaneacionPedagogica[ idPlaneacionPedagogica=" + idPlaneacionPedagogica + " ]";
    }
    
}
