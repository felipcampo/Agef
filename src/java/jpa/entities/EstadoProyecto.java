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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "estado_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoProyecto.findAll", query = "SELECT e FROM EstadoProyecto e"),
    @NamedQuery(name = "EstadoProyecto.findByIdEstadoProyecto", query = "SELECT e FROM EstadoProyecto e WHERE e.idEstadoProyecto = :idEstadoProyecto"),
    @NamedQuery(name = "EstadoProyecto.findByNomEstPro", query = "SELECT e FROM EstadoProyecto e WHERE e.nomEstPro = :nomEstPro")})
public class EstadoProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_proyecto")
    private Short idEstadoProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_est_pro")
    private String nomEstPro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoProyecto")
    private List<ProyectoFormativo> proyectoFormativoList;

    public EstadoProyecto() {
    }

    public EstadoProyecto(Short idEstadoProyecto) {
        this.idEstadoProyecto = idEstadoProyecto;
    }

    public EstadoProyecto(Short idEstadoProyecto, String nomEstPro) {
        this.idEstadoProyecto = idEstadoProyecto;
        this.nomEstPro = nomEstPro;
    }

    public Short getIdEstadoProyecto() {
        return idEstadoProyecto;
    }

    public void setIdEstadoProyecto(Short idEstadoProyecto) {
        this.idEstadoProyecto = idEstadoProyecto;
    }

    public String getNomEstPro() {
        return nomEstPro;
    }

    public void setNomEstPro(String nomEstPro) {
        this.nomEstPro = nomEstPro;
    }

    @XmlTransient
    public List<ProyectoFormativo> getProyectoFormativoList() {
        return proyectoFormativoList;
    }

    public void setProyectoFormativoList(List<ProyectoFormativo> proyectoFormativoList) {
        this.proyectoFormativoList = proyectoFormativoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoProyecto != null ? idEstadoProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoProyecto)) {
            return false;
        }
        EstadoProyecto other = (EstadoProyecto) object;
        if ((this.idEstadoProyecto == null && other.idEstadoProyecto != null) || (this.idEstadoProyecto != null && !this.idEstadoProyecto.equals(other.idEstadoProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EstadoProyecto[ idEstadoProyecto=" + idEstadoProyecto + " ]";
    }
    
}
