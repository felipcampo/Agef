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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MAURICIO
 */
@Entity
@Table(name = "seguimiento_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeguimientoProyecto.findAll", query = "SELECT s FROM SeguimientoProyecto s"),
    @NamedQuery(name = "SeguimientoProyecto.findByIdSeguimientoProyecto", query = "SELECT s FROM SeguimientoProyecto s WHERE s.idSeguimientoProyecto = :idSeguimientoProyecto"),
    @NamedQuery(name = "SeguimientoProyecto.findByFechaSeguimientoInicio", query = "SELECT s FROM SeguimientoProyecto s WHERE s.fechaSeguimientoInicio = :fechaSeguimientoInicio"),
    @NamedQuery(name = "SeguimientoProyecto.findByFechaSeguimientoFin", query = "SELECT s FROM SeguimientoProyecto s WHERE s.fechaSeguimientoFin = :fechaSeguimientoFin"),
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
    @Column(name = "evaluacion_proyecto")
    private Long evaluacionProyecto;
    @Column(name = "fecha_programacion_seguimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaProgramacionSeguimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeguimientoProyecto")
    private List<CriterioSeguimientoProyecto> criterioSeguimientoProyectoList;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne
    private Rol idRol;
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    @ManyToOne
    private Area idArea;
    @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id_resultado_aprendizaje")
    @ManyToOne
    private ResultadoAprendizaje idResultadoAprendizaje;
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

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    public Area getIdArea() {
        return idArea;
    }

    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }

    public ResultadoAprendizaje getIdResultadoAprendizaje() {
        return idResultadoAprendizaje;
    }

    public void setIdResultadoAprendizaje(ResultadoAprendizaje idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
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
