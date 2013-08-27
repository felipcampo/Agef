/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leoandresm
 */
@Entity
@Table(name = "estado_juicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoJuicio.findAll", query = "SELECT e FROM EstadoJuicio e"),
    @NamedQuery(name = "EstadoJuicio.findByIdEstadoJuicio", query = "SELECT e FROM EstadoJuicio e WHERE e.idEstadoJuicio = :idEstadoJuicio"),
    @NamedQuery(name = "EstadoJuicio.findByNomEstadoJuicio", query = "SELECT e FROM EstadoJuicio e WHERE e.nomEstadoJuicio = :nomEstadoJuicio")})
public class EstadoJuicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_estado_juicio")
    private String idEstadoJuicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_estado_juicio")
    private String nomEstadoJuicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoJuicio")
    private List<SeguimientoInstructor> seguimientoInstructorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoJuicio")
    private List<CriterioSeguimientoProyecto> criterioSeguimientoProyectoList;
    @OneToMany(mappedBy = "idEstadoJuicio")
    private List<SeguimientoProyecto> seguimientoProyectoList;

    public EstadoJuicio() {
    }

    public EstadoJuicio(String idEstadoJuicio) {
        this.idEstadoJuicio = idEstadoJuicio;
    }

    public EstadoJuicio(String idEstadoJuicio, String nomEstadoJuicio) {
        this.idEstadoJuicio = idEstadoJuicio;
        this.nomEstadoJuicio = nomEstadoJuicio;
    }

    public String getIdEstadoJuicio() {
        return idEstadoJuicio;
    }

    public void setIdEstadoJuicio(String idEstadoJuicio) {
        this.idEstadoJuicio = idEstadoJuicio;
    }

    public String getNomEstadoJuicio() {
        return nomEstadoJuicio;
    }

    public void setNomEstadoJuicio(String nomEstadoJuicio) {
        this.nomEstadoJuicio = nomEstadoJuicio;
    }

    @XmlTransient
    public List<SeguimientoInstructor> getSeguimientoInstructorList() {
        return seguimientoInstructorList;
    }

    public void setSeguimientoInstructorList(List<SeguimientoInstructor> seguimientoInstructorList) {
        this.seguimientoInstructorList = seguimientoInstructorList;
    }

    @XmlTransient
    public List<CriterioSeguimientoProyecto> getCriterioSeguimientoProyectoList() {
        return criterioSeguimientoProyectoList;
    }

    public void setCriterioSeguimientoProyectoList(List<CriterioSeguimientoProyecto> criterioSeguimientoProyectoList) {
        this.criterioSeguimientoProyectoList = criterioSeguimientoProyectoList;
    }

    @XmlTransient
    public List<SeguimientoProyecto> getSeguimientoProyectoList() {
        return seguimientoProyectoList;
    }

    public void setSeguimientoProyectoList(List<SeguimientoProyecto> seguimientoProyectoList) {
        this.seguimientoProyectoList = seguimientoProyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoJuicio != null ? idEstadoJuicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoJuicio)) {
            return false;
        }
        EstadoJuicio other = (EstadoJuicio) object;
        if ((this.idEstadoJuicio == null && other.idEstadoJuicio != null) || (this.idEstadoJuicio != null && !this.idEstadoJuicio.equals(other.idEstadoJuicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EstadoJuicio[ idEstadoJuicio=" + idEstadoJuicio + " ]";
    }
    
}
