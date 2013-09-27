/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MAURICIO
 */
@Entity
@Table(name = "estado_ficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoFicha.findAll", query = "SELECT e FROM EstadoFicha e"),
    @NamedQuery(name = "EstadoFicha.findByIdEstadoFicha", query = "SELECT e FROM EstadoFicha e WHERE e.idEstadoFicha = :idEstadoFicha"),
    @NamedQuery(name = "EstadoFicha.findByNomEstadoFicha", query = "SELECT e FROM EstadoFicha e WHERE e.nomEstadoFicha = :nomEstadoFicha")})
public class EstadoFicha implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_ficha")
    private Short idEstadoFicha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_estado_ficha")
    private String nomEstadoFicha;
    @ManyToMany(mappedBy = "estadoFichaList")
    private List<FichaCaracterizacion> fichaCaracterizacionList;

    public EstadoFicha() {
    }

    public EstadoFicha(Short idEstadoFicha) {
        this.idEstadoFicha = idEstadoFicha;
    }

    public EstadoFicha(Short idEstadoFicha, String nomEstadoFicha) {
        this.idEstadoFicha = idEstadoFicha;
        this.nomEstadoFicha = nomEstadoFicha;
    }

    public Short getIdEstadoFicha() {
        return idEstadoFicha;
    }

    public void setIdEstadoFicha(Short idEstadoFicha) {
        this.idEstadoFicha = idEstadoFicha;
    }

    public String getNomEstadoFicha() {
        return nomEstadoFicha;
    }

    public void setNomEstadoFicha(String nomEstadoFicha) {
        this.nomEstadoFicha = nomEstadoFicha;
    }

    @XmlTransient
    public List<FichaCaracterizacion> getFichaCaracterizacionList() {
        return fichaCaracterizacionList;
    }

    public void setFichaCaracterizacionList(List<FichaCaracterizacion> fichaCaracterizacionList) {
        this.fichaCaracterizacionList = fichaCaracterizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoFicha != null ? idEstadoFicha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoFicha)) {
            return false;
        }
        EstadoFicha other = (EstadoFicha) object;
        if ((this.idEstadoFicha == null && other.idEstadoFicha != null) || (this.idEstadoFicha != null && !this.idEstadoFicha.equals(other.idEstadoFicha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EstadoFicha[ idEstadoFicha=" + idEstadoFicha + " ]";
    }
    
}
