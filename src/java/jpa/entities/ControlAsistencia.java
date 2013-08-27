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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leoandresm
 */
@Entity
@Table(name = "control_asistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlAsistencia.findAll", query = "SELECT c FROM ControlAsistencia c"),
    @NamedQuery(name = "ControlAsistencia.findByIdControlAsistencia", query = "SELECT c FROM ControlAsistencia c WHERE c.idControlAsistencia = :idControlAsistencia"),
    @NamedQuery(name = "ControlAsistencia.findByAsistencia", query = "SELECT c FROM ControlAsistencia c WHERE c.asistencia = :asistencia"),
    @NamedQuery(name = "ControlAsistencia.findByFecAsistencia", query = "SELECT c FROM ControlAsistencia c WHERE c.fecAsistencia = :fecAsistencia")})
public class ControlAsistencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_control_asistencia")
    private Integer idControlAsistencia;
    @Column(name = "asistencia")
    private Boolean asistencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_asistencia")
    @Temporal(TemporalType.DATE)
    private Date fecAsistencia;
    @JoinColumn(name = "id_usuario2", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario2;
    @JoinColumn(name = "id_usuario1", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario1;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_estado_aprendiz", referencedColumnName = "id_estado_aprendiz")
    @ManyToOne(optional = false)
    private EstadoAprendiz idEstadoAprendiz;
    @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")
    @ManyToOne(optional = false)
    private FichaCaracterizacion idFichaCaracterizacion;

    public ControlAsistencia() {
    }

    public ControlAsistencia(Integer idControlAsistencia) {
        this.idControlAsistencia = idControlAsistencia;
    }

    public ControlAsistencia(Integer idControlAsistencia, Date fecAsistencia) {
        this.idControlAsistencia = idControlAsistencia;
        this.fecAsistencia = fecAsistencia;
    }

    public Integer getIdControlAsistencia() {
        return idControlAsistencia;
    }

    public void setIdControlAsistencia(Integer idControlAsistencia) {
        this.idControlAsistencia = idControlAsistencia;
    }

    public Boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Boolean asistencia) {
        this.asistencia = asistencia;
    }

    public Date getFecAsistencia() {
        return fecAsistencia;
    }

    public void setFecAsistencia(Date fecAsistencia) {
        this.fecAsistencia = fecAsistencia;
    }

    public Usuario getIdUsuario2() {
        return idUsuario2;
    }

    public void setIdUsuario2(Usuario idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }

    public Usuario getIdUsuario1() {
        return idUsuario1;
    }

    public void setIdUsuario1(Usuario idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public EstadoAprendiz getIdEstadoAprendiz() {
        return idEstadoAprendiz;
    }

    public void setIdEstadoAprendiz(EstadoAprendiz idEstadoAprendiz) {
        this.idEstadoAprendiz = idEstadoAprendiz;
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
        hash += (idControlAsistencia != null ? idControlAsistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlAsistencia)) {
            return false;
        }
        ControlAsistencia other = (ControlAsistencia) object;
        if ((this.idControlAsistencia == null && other.idControlAsistencia != null) || (this.idControlAsistencia != null && !this.idControlAsistencia.equals(other.idControlAsistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ControlAsistencia[ idControlAsistencia=" + idControlAsistencia + " ]";
    }
    
}
