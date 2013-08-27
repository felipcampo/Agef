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
@Table(name = "estado_aspirante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoAspirante.findAll", query = "SELECT e FROM EstadoAspirante e"),
    @NamedQuery(name = "EstadoAspirante.findByIdEstadoAspirante", query = "SELECT e FROM EstadoAspirante e WHERE e.idEstadoAspirante = :idEstadoAspirante"),
    @NamedQuery(name = "EstadoAspirante.findByNomEstAsp", query = "SELECT e FROM EstadoAspirante e WHERE e.nomEstAsp = :nomEstAsp")})
public class EstadoAspirante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_aspirante")
    private Integer idEstadoAspirante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_est_asp")
    private String nomEstAsp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoAspirante")
    private List<Usuario> usuarioList;
    @OneToMany(mappedBy = "idEstadoAspirante")
    private List<SeguimientoProyecto> seguimientoProyectoList;

    public EstadoAspirante() {
    }

    public EstadoAspirante(Integer idEstadoAspirante) {
        this.idEstadoAspirante = idEstadoAspirante;
    }

    public EstadoAspirante(Integer idEstadoAspirante, String nomEstAsp) {
        this.idEstadoAspirante = idEstadoAspirante;
        this.nomEstAsp = nomEstAsp;
    }

    public Integer getIdEstadoAspirante() {
        return idEstadoAspirante;
    }

    public void setIdEstadoAspirante(Integer idEstadoAspirante) {
        this.idEstadoAspirante = idEstadoAspirante;
    }

    public String getNomEstAsp() {
        return nomEstAsp;
    }

    public void setNomEstAsp(String nomEstAsp) {
        this.nomEstAsp = nomEstAsp;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
        hash += (idEstadoAspirante != null ? idEstadoAspirante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoAspirante)) {
            return false;
        }
        EstadoAspirante other = (EstadoAspirante) object;
        if ((this.idEstadoAspirante == null && other.idEstadoAspirante != null) || (this.idEstadoAspirante != null && !this.idEstadoAspirante.equals(other.idEstadoAspirante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EstadoAspirante[ idEstadoAspirante=" + idEstadoAspirante + " ]";
    }
    
}
