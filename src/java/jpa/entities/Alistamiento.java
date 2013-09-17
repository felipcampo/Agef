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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADSI
 */
@Entity
@Table(name = "alistamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alistamiento.findAll", query = "SELECT a FROM Alistamiento a"),
    @NamedQuery(name = "Alistamiento.findByIdAlistamiento", query = "SELECT a FROM Alistamiento a WHERE a.idAlistamiento = :idAlistamiento"),
    @NamedQuery(name = "Alistamiento.findByTerminal", query = "SELECT a FROM Alistamiento a WHERE a.terminal = :terminal"),
    @NamedQuery(name = "Alistamiento.findByFechaAlistamiento", query = "SELECT a FROM Alistamiento a WHERE a.fechaAlistamiento = :fechaAlistamiento")})
public class Alistamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_alistamiento")
    private Integer idAlistamiento;
    @Column(name = "terminal")
    private Boolean terminal;
    @Column(name = "fecha_alistamiento")
    @Temporal(TemporalType.DATE)
    private Date fechaAlistamiento;
    @ManyToMany(mappedBy = "alistamientoList")
    private List<GuiaAprendizaje> guiaAprendizajeList;
    @JoinColumn(name = "id_tipo_alistamiento", referencedColumnName = "id_tipo_alistamiento")
    @ManyToOne(optional = false)
    private TipoAlistamiento idTipoAlistamiento;
    @JoinColumn(name = "id_guia_aprendizaje", referencedColumnName = "id_guia_aprendizaje")
    @ManyToOne
    private GuiaAprendizaje idGuiaAprendizaje;
    @JoinColumn(name = "id_evaluacion_seguimiento", referencedColumnName = "id_evaluacion_seguimiento")
    @ManyToOne
    private EvaluacionSeguimiento idEvaluacionSeguimiento;
    @JoinColumn(name = "id_planeacion_pedagogica", referencedColumnName = "id_planeacion_pedagogica")
    @ManyToOne
    private PlaneacionPedagogica idPlaneacionPedagogica;
    @JoinColumn(name = "id_programacion_proyecto", referencedColumnName = "id_programacion_proyecto")
    @ManyToOne
    private ProgramacionProyecto idProgramacionProyecto;
    @JoinColumn(name = "id_verificacion_ambiente_titulado", referencedColumnName = "id_verificacion_ambiente_titulado")
    @ManyToOne
    private VerificacionAmbienteTitulado idVerificacionAmbienteTitulado;
    @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")
    @ManyToOne(optional = false)
    private FichaCaracterizacion idFichaCaracterizacion;
    @JoinColumn(name = "id_actividad_proyecto", referencedColumnName = "id_actividad_proyecto")
    @ManyToOne(optional = false)
    private ActividadProyecto idActividadProyecto;
    @JoinColumn(name = "id_proyecto_formativo", referencedColumnName = "id_proyecto_formativo")
    @ManyToOne
    private ProyectoFormativo idProyectoFormativo;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlistamiento")
    private List<ControlOperativo> controlOperativoList;

    public Alistamiento() {
    }

    public Alistamiento(Integer idAlistamiento) {
        this.idAlistamiento = idAlistamiento;
    }

    public Integer getIdAlistamiento() {
        return idAlistamiento;
    }

    public void setIdAlistamiento(Integer idAlistamiento) {
        this.idAlistamiento = idAlistamiento;
    }

    public Boolean getTerminal() {
        return terminal;
    }

    public void setTerminal(Boolean terminal) {
        this.terminal = terminal;
    }

    public Date getFechaAlistamiento() {
        return fechaAlistamiento;
    }

    public void setFechaAlistamiento(Date fechaAlistamiento) {
        this.fechaAlistamiento = fechaAlistamiento;
    }

    @XmlTransient
    public List<GuiaAprendizaje> getGuiaAprendizajeList() {
        return guiaAprendizajeList;
    }

    public void setGuiaAprendizajeList(List<GuiaAprendizaje> guiaAprendizajeList) {
        this.guiaAprendizajeList = guiaAprendizajeList;
    }

    public TipoAlistamiento getIdTipoAlistamiento() {
        return idTipoAlistamiento;
    }

    public void setIdTipoAlistamiento(TipoAlistamiento idTipoAlistamiento) {
        this.idTipoAlistamiento = idTipoAlistamiento;
    }

    public GuiaAprendizaje getIdGuiaAprendizaje() {
        return idGuiaAprendizaje;
    }

    public void setIdGuiaAprendizaje(GuiaAprendizaje idGuiaAprendizaje) {
        this.idGuiaAprendizaje = idGuiaAprendizaje;
    }

    public EvaluacionSeguimiento getIdEvaluacionSeguimiento() {
        return idEvaluacionSeguimiento;
    }

    public void setIdEvaluacionSeguimiento(EvaluacionSeguimiento idEvaluacionSeguimiento) {
        this.idEvaluacionSeguimiento = idEvaluacionSeguimiento;
    }

    public PlaneacionPedagogica getIdPlaneacionPedagogica() {
        return idPlaneacionPedagogica;
    }

    public void setIdPlaneacionPedagogica(PlaneacionPedagogica idPlaneacionPedagogica) {
        this.idPlaneacionPedagogica = idPlaneacionPedagogica;
    }

    public ProgramacionProyecto getIdProgramacionProyecto() {
        return idProgramacionProyecto;
    }

    public void setIdProgramacionProyecto(ProgramacionProyecto idProgramacionProyecto) {
        this.idProgramacionProyecto = idProgramacionProyecto;
    }

    public VerificacionAmbienteTitulado getIdVerificacionAmbienteTitulado() {
        return idVerificacionAmbienteTitulado;
    }

    public void setIdVerificacionAmbienteTitulado(VerificacionAmbienteTitulado idVerificacionAmbienteTitulado) {
        this.idVerificacionAmbienteTitulado = idVerificacionAmbienteTitulado;
    }

    public FichaCaracterizacion getIdFichaCaracterizacion() {
        return idFichaCaracterizacion;
    }

    public void setIdFichaCaracterizacion(FichaCaracterizacion idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    public ActividadProyecto getIdActividadProyecto() {
        return idActividadProyecto;
    }

    public void setIdActividadProyecto(ActividadProyecto idActividadProyecto) {
        this.idActividadProyecto = idActividadProyecto;
    }

    public ProyectoFormativo getIdProyectoFormativo() {
        return idProyectoFormativo;
    }

    public void setIdProyectoFormativo(ProyectoFormativo idProyectoFormativo) {
        this.idProyectoFormativo = idProyectoFormativo;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<ControlOperativo> getControlOperativoList() {
        return controlOperativoList;
    }

    public void setControlOperativoList(List<ControlOperativo> controlOperativoList) {
        this.controlOperativoList = controlOperativoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlistamiento != null ? idAlistamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alistamiento)) {
            return false;
        }
        Alistamiento other = (Alistamiento) object;
        if ((this.idAlistamiento == null && other.idAlistamiento != null) || (this.idAlistamiento != null && !this.idAlistamiento.equals(other.idAlistamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Alistamiento[ idAlistamiento=" + idAlistamiento + " ]";
    }
    
}
