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
@Table(name = "visita_etapa_productiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VisitaEtapaProductiva.findAll", query = "SELECT v FROM VisitaEtapaProductiva v"),
    @NamedQuery(name = "VisitaEtapaProductiva.findByIdVisitaEtapaProductiva", query = "SELECT v FROM VisitaEtapaProductiva v WHERE v.idVisitaEtapaProductiva = :idVisitaEtapaProductiva"),
    @NamedQuery(name = "VisitaEtapaProductiva.findByDisponibilidadFecha", query = "SELECT v FROM VisitaEtapaProductiva v WHERE v.disponibilidadFecha = :disponibilidadFecha"),
    @NamedQuery(name = "VisitaEtapaProductiva.findByEstadoVisita", query = "SELECT v FROM VisitaEtapaProductiva v WHERE v.estadoVisita = :estadoVisita"),
    @NamedQuery(name = "VisitaEtapaProductiva.findByFechaInicio", query = "SELECT v FROM VisitaEtapaProductiva v WHERE v.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "VisitaEtapaProductiva.findByFechaFin", query = "SELECT v FROM VisitaEtapaProductiva v WHERE v.fechaFin = :fechaFin")})
public class VisitaEtapaProductiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_visita_etapa_productiva")
    private String idVisitaEtapaProductiva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disponibilidad_fecha")
    private boolean disponibilidadFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "estado_visita")
    private String estadoVisita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVisitaEtapaProductiva")
    private List<IncidenteProductiva> incidenteProductivaList;
    @OneToMany(mappedBy = "idVisitaEtapaProductiva")
    private List<SeguimientoProductiva> seguimientoProductivaList;

    public VisitaEtapaProductiva() {
    }

    public VisitaEtapaProductiva(String idVisitaEtapaProductiva) {
        this.idVisitaEtapaProductiva = idVisitaEtapaProductiva;
    }

    public VisitaEtapaProductiva(String idVisitaEtapaProductiva, boolean disponibilidadFecha, String estadoVisita, Date fechaInicio, Date fechaFin) {
        this.idVisitaEtapaProductiva = idVisitaEtapaProductiva;
        this.disponibilidadFecha = disponibilidadFecha;
        this.estadoVisita = estadoVisita;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getIdVisitaEtapaProductiva() {
        return idVisitaEtapaProductiva;
    }

    public void setIdVisitaEtapaProductiva(String idVisitaEtapaProductiva) {
        this.idVisitaEtapaProductiva = idVisitaEtapaProductiva;
    }

    public boolean getDisponibilidadFecha() {
        return disponibilidadFecha;
    }

    public void setDisponibilidadFecha(boolean disponibilidadFecha) {
        this.disponibilidadFecha = disponibilidadFecha;
    }

    public String getEstadoVisita() {
        return estadoVisita;
    }

    public void setEstadoVisita(String estadoVisita) {
        this.estadoVisita = estadoVisita;
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

    @XmlTransient
    public List<IncidenteProductiva> getIncidenteProductivaList() {
        return incidenteProductivaList;
    }

    public void setIncidenteProductivaList(List<IncidenteProductiva> incidenteProductivaList) {
        this.incidenteProductivaList = incidenteProductivaList;
    }

    @XmlTransient
    public List<SeguimientoProductiva> getSeguimientoProductivaList() {
        return seguimientoProductivaList;
    }

    public void setSeguimientoProductivaList(List<SeguimientoProductiva> seguimientoProductivaList) {
        this.seguimientoProductivaList = seguimientoProductivaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVisitaEtapaProductiva != null ? idVisitaEtapaProductiva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitaEtapaProductiva)) {
            return false;
        }
        VisitaEtapaProductiva other = (VisitaEtapaProductiva) object;
        if ((this.idVisitaEtapaProductiva == null && other.idVisitaEtapaProductiva != null) || (this.idVisitaEtapaProductiva != null && !this.idVisitaEtapaProductiva.equals(other.idVisitaEtapaProductiva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.VisitaEtapaProductiva[ idVisitaEtapaProductiva=" + idVisitaEtapaProductiva + " ]";
    }
    
}
