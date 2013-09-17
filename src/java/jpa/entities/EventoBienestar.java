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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADSI
 */
@Entity
@Table(name = "evento_bienestar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventoBienestar.findAll", query = "SELECT e FROM EventoBienestar e"),
    @NamedQuery(name = "EventoBienestar.findByIdEventoBienestar", query = "SELECT e FROM EventoBienestar e WHERE e.idEventoBienestar = :idEventoBienestar"),
    @NamedQuery(name = "EventoBienestar.findByTituloEvento", query = "SELECT e FROM EventoBienestar e WHERE e.tituloEvento = :tituloEvento"),
    @NamedQuery(name = "EventoBienestar.findByDescrEvento", query = "SELECT e FROM EventoBienestar e WHERE e.descrEvento = :descrEvento"),
    @NamedQuery(name = "EventoBienestar.findByFechaInicio", query = "SELECT e FROM EventoBienestar e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "EventoBienestar.findByFechaFin", query = "SELECT e FROM EventoBienestar e WHERE e.fechaFin = :fechaFin")})
public class EventoBienestar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_evento_bienestar")
    private Integer idEventoBienestar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "titulo_evento")
    private String tituloEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descr_evento")
    private String descrEvento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public EventoBienestar() {
    }

    public EventoBienestar(Integer idEventoBienestar) {
        this.idEventoBienestar = idEventoBienestar;
    }

    public EventoBienestar(Integer idEventoBienestar, String tituloEvento, String descrEvento, Date fechaInicio, Date fechaFin) {
        this.idEventoBienestar = idEventoBienestar;
        this.tituloEvento = tituloEvento;
        this.descrEvento = descrEvento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdEventoBienestar() {
        return idEventoBienestar;
    }

    public void setIdEventoBienestar(Integer idEventoBienestar) {
        this.idEventoBienestar = idEventoBienestar;
    }

    public String getTituloEvento() {
        return tituloEvento;
    }

    public void setTituloEvento(String tituloEvento) {
        this.tituloEvento = tituloEvento;
    }

    public String getDescrEvento() {
        return descrEvento;
    }

    public void setDescrEvento(String descrEvento) {
        this.descrEvento = descrEvento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEventoBienestar != null ? idEventoBienestar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventoBienestar)) {
            return false;
        }
        EventoBienestar other = (EventoBienestar) object;
        if ((this.idEventoBienestar == null && other.idEventoBienestar != null) || (this.idEventoBienestar != null && !this.idEventoBienestar.equals(other.idEventoBienestar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EventoBienestar[ idEventoBienestar=" + idEventoBienestar + " ]";
    }
    
}
