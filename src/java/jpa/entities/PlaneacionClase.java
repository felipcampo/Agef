/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MAURICIO
 */
@Entity
@Table(name = "planeacion_clase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlaneacionClase.findAll", query = "SELECT p FROM PlaneacionClase p"),
    @NamedQuery(name = "PlaneacionClase.findByIdPlaneacionClase", query = "SELECT p FROM PlaneacionClase p WHERE p.idPlaneacionClase = :idPlaneacionClase"),
    @NamedQuery(name = "PlaneacionClase.findByProyeccionMeses", query = "SELECT p FROM PlaneacionClase p WHERE p.proyeccionMeses = :proyeccionMeses"),
    @NamedQuery(name = "PlaneacionClase.findByHora", query = "SELECT p FROM PlaneacionClase p WHERE p.hora = :hora"),
    @NamedQuery(name = "PlaneacionClase.findByProgramaCumplido", query = "SELECT p FROM PlaneacionClase p WHERE p.programaCumplido = :programaCumplido")})
public class PlaneacionClase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "id_planeacion_clase")
    private String idPlaneacionClase;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "conocimiento_concep_princip")
    private String conocimientoConcepPrincip;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "conocimiento_proceso")
    private String conocimientoProceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "proyeccion_meses")
    private String proyeccionMeses;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora")
    @Temporal(TemporalType.DATE)
    private Date hora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "programa_cumplido")
    private boolean programaCumplido;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_usuario_instructor", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioInstructor;
    @JoinColumn(name = "id_usuario_gestor", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioGestor;
    @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")
    @ManyToOne(optional = false)
    private FichaCaracterizacion idFichaCaracterizacion;
    @JoinColumn(name = "id_criterio_evaluacion", referencedColumnName = "id_criterio_evaluacion")
    @ManyToOne(optional = false)
    private CriterioEvaluacion idCriterioEvaluacion;

    public PlaneacionClase() {
    }

    public PlaneacionClase(String idPlaneacionClase) {
        this.idPlaneacionClase = idPlaneacionClase;
    }

    public PlaneacionClase(String idPlaneacionClase, String conocimientoConcepPrincip, String conocimientoProceso, String proyeccionMeses, Date hora, boolean programaCumplido) {
        this.idPlaneacionClase = idPlaneacionClase;
        this.conocimientoConcepPrincip = conocimientoConcepPrincip;
        this.conocimientoProceso = conocimientoProceso;
        this.proyeccionMeses = proyeccionMeses;
        this.hora = hora;
        this.programaCumplido = programaCumplido;
    }

    public String getIdPlaneacionClase() {
        return idPlaneacionClase;
    }

    public void setIdPlaneacionClase(String idPlaneacionClase) {
        this.idPlaneacionClase = idPlaneacionClase;
    }

    public String getConocimientoConcepPrincip() {
        return conocimientoConcepPrincip;
    }

    public void setConocimientoConcepPrincip(String conocimientoConcepPrincip) {
        this.conocimientoConcepPrincip = conocimientoConcepPrincip;
    }

    public String getConocimientoProceso() {
        return conocimientoProceso;
    }

    public void setConocimientoProceso(String conocimientoProceso) {
        this.conocimientoProceso = conocimientoProceso;
    }

    public String getProyeccionMeses() {
        return proyeccionMeses;
    }

    public void setProyeccionMeses(String proyeccionMeses) {
        this.proyeccionMeses = proyeccionMeses;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public boolean getProgramaCumplido() {
        return programaCumplido;
    }

    public void setProgramaCumplido(boolean programaCumplido) {
        this.programaCumplido = programaCumplido;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Usuario getIdUsuarioInstructor() {
        return idUsuarioInstructor;
    }

    public void setIdUsuarioInstructor(Usuario idUsuarioInstructor) {
        this.idUsuarioInstructor = idUsuarioInstructor;
    }

    public Usuario getIdUsuarioGestor() {
        return idUsuarioGestor;
    }

    public void setIdUsuarioGestor(Usuario idUsuarioGestor) {
        this.idUsuarioGestor = idUsuarioGestor;
    }

    public FichaCaracterizacion getIdFichaCaracterizacion() {
        return idFichaCaracterizacion;
    }

    public void setIdFichaCaracterizacion(FichaCaracterizacion idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
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
        hash += (idPlaneacionClase != null ? idPlaneacionClase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaneacionClase)) {
            return false;
        }
        PlaneacionClase other = (PlaneacionClase) object;
        if ((this.idPlaneacionClase == null && other.idPlaneacionClase != null) || (this.idPlaneacionClase != null && !this.idPlaneacionClase.equals(other.idPlaneacionClase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.PlaneacionClase[ idPlaneacionClase=" + idPlaneacionClase + " ]";
    }
    
}
