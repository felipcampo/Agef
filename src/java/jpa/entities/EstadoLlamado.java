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
@Table(name = "estado_llamado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoLlamado.findAll", query = "SELECT e FROM EstadoLlamado e"),
    @NamedQuery(name = "EstadoLlamado.findByIdEstadoLlamado", query = "SELECT e FROM EstadoLlamado e WHERE e.idEstadoLlamado = :idEstadoLlamado"),
    @NamedQuery(name = "EstadoLlamado.findByNomEstadoLlamado", query = "SELECT e FROM EstadoLlamado e WHERE e.nomEstadoLlamado = :nomEstadoLlamado")})
public class EstadoLlamado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_llamado")
    private Short idEstadoLlamado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nom_estado_llamado")
    private String nomEstadoLlamado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoLlamado")
    private List<LlamadoAtencionVerbal> llamadoAtencionVerbalList;

    public EstadoLlamado() {
    }

    public EstadoLlamado(Short idEstadoLlamado) {
        this.idEstadoLlamado = idEstadoLlamado;
    }

    public EstadoLlamado(Short idEstadoLlamado, String nomEstadoLlamado) {
        this.idEstadoLlamado = idEstadoLlamado;
        this.nomEstadoLlamado = nomEstadoLlamado;
    }

    public Short getIdEstadoLlamado() {
        return idEstadoLlamado;
    }

    public void setIdEstadoLlamado(Short idEstadoLlamado) {
        this.idEstadoLlamado = idEstadoLlamado;
    }

    public String getNomEstadoLlamado() {
        return nomEstadoLlamado;
    }

    public void setNomEstadoLlamado(String nomEstadoLlamado) {
        this.nomEstadoLlamado = nomEstadoLlamado;
    }

    @XmlTransient
    public List<LlamadoAtencionVerbal> getLlamadoAtencionVerbalList() {
        return llamadoAtencionVerbalList;
    }

    public void setLlamadoAtencionVerbalList(List<LlamadoAtencionVerbal> llamadoAtencionVerbalList) {
        this.llamadoAtencionVerbalList = llamadoAtencionVerbalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoLlamado != null ? idEstadoLlamado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoLlamado)) {
            return false;
        }
        EstadoLlamado other = (EstadoLlamado) object;
        if ((this.idEstadoLlamado == null && other.idEstadoLlamado != null) || (this.idEstadoLlamado != null && !this.idEstadoLlamado.equals(other.idEstadoLlamado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EstadoLlamado[ idEstadoLlamado=" + idEstadoLlamado + " ]";
    }
    
}
