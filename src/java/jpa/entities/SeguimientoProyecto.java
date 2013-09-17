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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADSI
 */
@Entity
@Table(name = "seguimiento_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeguimientoProyecto.findAll", query = "SELECT s FROM SeguimientoProyecto s"),
    @NamedQuery(name = "SeguimientoProyecto.findByIdSeguimientoProyecto", query = "SELECT s FROM SeguimientoProyecto s WHERE s.idSeguimientoProyecto = :idSeguimientoProyecto"),
    @NamedQuery(name = "SeguimientoProyecto.findByFechaSeguimientoInicio", query = "SELECT s FROM SeguimientoProyecto s WHERE s.fechaSeguimientoInicio = :fechaSeguimientoInicio"),
    @NamedQuery(name = "SeguimientoProyecto.findByFechaSeguimientoFin", query = "SELECT s FROM SeguimientoProyecto s WHERE s.fechaSeguimientoFin = :fechaSeguimientoFin"),
    @NamedQuery(name = "SeguimientoProyecto.findByNomInstructor", query = "SELECT s FROM SeguimientoProyecto s WHERE s.nomInstructor = :nomInstructor"),
    @NamedQuery(name = "SeguimientoProyecto.findByEvaluacionProyecto", query = "SELECT s FROM SeguimientoProyecto s WHERE s.evaluacionProyecto = :evaluacionProyecto"),
    @NamedQuery(name = "SeguimientoProyecto.findByFechaProgramacionSeguimiento", query = "SELECT s FROM SeguimientoProyecto s WHERE s.fechaProgramacionSeguimiento = :fechaProgramacionSeguimiento")})
public class SeguimientoProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_seguimiento_proyecto")
    private Integer idSeguimientoProyecto;
    @Column(name = "fecha_seguimiento_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSeguimientoInicio;
    @Column(name = "fecha_seguimiento_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSeguimientoFin;
    @Size(max = 255)
    @Column(name = "nom_instructor")
    private String nomInstructor;
    @Column(name = "evaluacion_proyecto")
    private Long evaluacionProyecto;
    @Column(name = "fecha_programacion_seguimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaProgramacionSeguimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeguimientoProyecto")
    private List<CriterioSeguimientoProyecto> criterioSeguimientoProyectoList;
    @JoinColumn(name = "id_sede_centro", referencedColumnName = "id_sede_centro")
    @ManyToOne
    private SedeCentro idSedeCentro;
    @JoinColumn(name = "rol_id_rol", referencedColumnName = "id_rol")
    @ManyToOne
    private Rol rolIdRol;
    @JoinColumn(name = "id_proyecto_formativo", referencedColumnName = "id_proyecto_formativo")
    @ManyToOne
    private ProyectoFormativo idProyectoFormativo;
    @JoinColumn(name = "id_nivel_formacion", referencedColumnName = "id_nivel_formacion")
    @ManyToOne
    private NivelFormacion idNivelFormacion;
    @JoinColumn(name = "id_jornada_formacion", referencedColumnName = "id_jornada_formacion")
    @ManyToOne
    private JornadaFormacion idJornadaFormacion;
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    @ManyToOne
    private Area idArea;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id_resultado_aprendizaje")
    @ManyToOne
    private ResultadoAprendizaje idResultadoAprendizaje;
    @JoinColumn(name = "id_regional", referencedColumnName = "id_regional")
    @ManyToOne
    private Regional idRegional;
    @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")
    @ManyToOne
    private FichaCaracterizacion idFichaCaracterizacion;

    public SeguimientoProyecto() {
    }

    public SeguimientoProyecto(Integer idSeguimientoProyecto) {
        this.idSeguimientoProyecto = idSeguimientoProyecto;
    }

    public Integer getIdSeguimientoProyecto() {
        return idSeguimientoProyecto;
    }

    public void setIdSeguimientoProyecto(Integer idSeguimientoProyecto) {
        this.idSeguimientoProyecto = idSeguimientoProyecto;
    }

    public Date getFechaSeguimientoInicio() {
        return fechaSeguimientoInicio;
    }

    public void setFechaSeguimientoInicio(Date fechaSeguimientoInicio) {
        this.fechaSeguimientoInicio = fechaSeguimientoInicio;
    }

    public Date getFechaSeguimientoFin() {
        return fechaSeguimientoFin;
    }

    public void setFechaSeguimientoFin(Date fechaSeguimientoFin) {
        this.fechaSeguimientoFin = fechaSeguimientoFin;
    }

    public String getNomInstructor() {
        return nomInstructor;
    }

    public void setNomInstructor(String nomInstructor) {
        this.nomInstructor = nomInstructor;
    }

    public Long getEvaluacionProyecto() {
        return evaluacionProyecto;
    }

    public void setEvaluacionProyecto(Long evaluacionProyecto) {
        this.evaluacionProyecto = evaluacionProyecto;
    }

    public Date getFechaProgramacionSeguimiento() {
        return fechaProgramacionSeguimiento;
    }

    public void setFechaProgramacionSeguimiento(Date fechaProgramacionSeguimiento) {
        this.fechaProgramacionSeguimiento = fechaProgramacionSeguimiento;
    }

    @XmlTransient
    public List<CriterioSeguimientoProyecto> getCriterioSeguimientoProyectoList() {
        return criterioSeguimientoProyectoList;
    }

    public void setCriterioSeguimientoProyectoList(List<CriterioSeguimientoProyecto> criterioSeguimientoProyectoList) {
        this.criterioSeguimientoProyectoList = criterioSeguimientoProyectoList;
    }

    public SedeCentro getIdSedeCentro() {
        return idSedeCentro;
    }

    public void setIdSedeCentro(SedeCentro idSedeCentro) {
        this.idSedeCentro = idSedeCentro;
    }

    public Rol getRolIdRol() {
        return rolIdRol;
    }

    public void setRolIdRol(Rol rolIdRol) {
        this.rolIdRol = rolIdRol;
    }

    public ProyectoFormativo getIdProyectoFormativo() {
        return idProyectoFormativo;
    }

    public void setIdProyectoFormativo(ProyectoFormativo idProyectoFormativo) {
        this.idProyectoFormativo = idProyectoFormativo;
    }

    public NivelFormacion getIdNivelFormacion() {
        return idNivelFormacion;
    }

    public void setIdNivelFormacion(NivelFormacion idNivelFormacion) {
        this.idNivelFormacion = idNivelFormacion;
    }

    public JornadaFormacion getIdJornadaFormacion() {
        return idJornadaFormacion;
    }

    public void setIdJornadaFormacion(JornadaFormacion idJornadaFormacion) {
        this.idJornadaFormacion = idJornadaFormacion;
    }

    public Area getIdArea() {
        return idArea;
    }

    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ResultadoAprendizaje getIdResultadoAprendizaje() {
        return idResultadoAprendizaje;
    }

    public void setIdResultadoAprendizaje(ResultadoAprendizaje idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }

    public Regional getIdRegional() {
        return idRegional;
    }

    public void setIdRegional(Regional idRegional) {
        this.idRegional = idRegional;
    }

    public FichaCaracterizacion getIdFichaCaracterizacion() {
        return idFichaCaracterizacion;
    }

    public void setIdFichaCaracterizacion(FichaCaracterizacion idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeguimientoProyecto != null ? idSeguimientoProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguimientoProyecto)) {
            return false;
        }
        SeguimientoProyecto other = (SeguimientoProyecto) object;
        if ((this.idSeguimientoProyecto == null && other.idSeguimientoProyecto != null) || (this.idSeguimientoProyecto != null && !this.idSeguimientoProyecto.equals(other.idSeguimientoProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.SeguimientoProyecto[ idSeguimientoProyecto=" + idSeguimientoProyecto + " ]";
    }
    
}
