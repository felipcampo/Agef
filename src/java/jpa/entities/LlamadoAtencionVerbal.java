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
@Table(name = "llamado_atencion_verbal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LlamadoAtencionVerbal.findAll", query = "SELECT l FROM LlamadoAtencionVerbal l"),
    @NamedQuery(name = "LlamadoAtencionVerbal.findByIdLlamadoAtencionVerbal", query = "SELECT l FROM LlamadoAtencionVerbal l WHERE l.idLlamadoAtencionVerbal = :idLlamadoAtencionVerbal"),
    @NamedQuery(name = "LlamadoAtencionVerbal.findByFecha", query = "SELECT l FROM LlamadoAtencionVerbal l WHERE l.fecha = :fecha")})
public class LlamadoAtencionVerbal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_llamado_atencion_verbal")
    private Integer idLlamadoAtencionVerbal;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "compromiso")
    private String compromiso;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "efecto")
    private String efecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "impacto")
    private String impacto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "situacion")
    private String situacion;
    @JoinColumn(name = "id_usuario3", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario3;
    @JoinColumn(name = "id_usuario2", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario2;
    @JoinColumn(name = "id_estado_llamado", referencedColumnName = "id_estado_llamado")
    @ManyToOne(optional = false)
    private EstadoLlamado idEstadoLlamado;
    @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")
    @ManyToOne(optional = false)
    private FichaCaracterizacion idFichaCaracterizacion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")
    @ManyToOne(optional = false)
    private FichaCaracterizacion idFichaCaracterizacion;
    @JoinColumn(name = "id_estado_llamado", referencedColumnName = "id_estado_llamado")
    @ManyToOne(optional = false)
    private EstadoLlamado idEstadoLlamado;

    public LlamadoAtencionVerbal() {
    }

    public LlamadoAtencionVerbal(Integer idLlamadoAtencionVerbal) {
        this.idLlamadoAtencionVerbal = idLlamadoAtencionVerbal;
    }

    public LlamadoAtencionVerbal(Integer idLlamadoAtencionVerbal, String compromiso, String descripcion, String efecto, Date fecha, String impacto, String situacion) {
        this.idLlamadoAtencionVerbal = idLlamadoAtencionVerbal;
        this.compromiso = compromiso;
        this.descripcion = descripcion;
        this.efecto = efecto;
        this.fecha = fecha;
        this.impacto = impacto;
        this.situacion = situacion;
    }

    public Integer getIdLlamadoAtencionVerbal() {
        return idLlamadoAtencionVerbal;
    }

    public void setIdLlamadoAtencionVerbal(Integer idLlamadoAtencionVerbal) {
        this.idLlamadoAtencionVerbal = idLlamadoAtencionVerbal;
    }

    public String getCompromiso() {
        return compromiso;
    }

    public void setCompromiso(String compromiso) {
        this.compromiso = compromiso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getImpacto() {
        return impacto;
    }

    public void setImpacto(String impacto) {
        this.impacto = impacto;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public Usuario getIdUsuario3() {
        return idUsuario3;
    }

    public void setIdUsuario3(Usuario idUsuario3) {
        this.idUsuario3 = idUsuario3;
    }

    public Usuario getIdUsuario2() {
        return idUsuario2;
    }

    public void setIdUsuario2(Usuario idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }

    public EstadoLlamado getIdEstadoLlamado() {
        return idEstadoLlamado;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public FichaCaracterizacion getIdFichaCaracterizacion() {
        return idFichaCaracterizacion;
    }

    public void setIdFichaCaracterizacion(FichaCaracterizacion idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    public EstadoLlamado getIdEstadoLlamado() {
        return idEstadoLlamado;
    }

    public void setIdEstadoLlamado(EstadoLlamado idEstadoLlamado) {
        this.idEstadoLlamado = idEstadoLlamado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLlamadoAtencionVerbal != null ? idLlamadoAtencionVerbal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LlamadoAtencionVerbal)) {
            return false;
        }
        LlamadoAtencionVerbal other = (LlamadoAtencionVerbal) object;
        if ((this.idLlamadoAtencionVerbal == null && other.idLlamadoAtencionVerbal != null) || (this.idLlamadoAtencionVerbal != null && !this.idLlamadoAtencionVerbal.equals(other.idLlamadoAtencionVerbal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.LlamadoAtencionVerbal[ idLlamadoAtencionVerbal=" + idLlamadoAtencionVerbal + " ]";
    }
    
}
