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
@Table(name = "eps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eps.findAll", query = "SELECT e FROM Eps e"),
    @NamedQuery(name = "Eps.findByIdEps", query = "SELECT e FROM Eps e WHERE e.idEps = :idEps"),
    @NamedQuery(name = "Eps.findByDescrEps", query = "SELECT e FROM Eps e WHERE e.descrEps = :descrEps")})
public class Eps implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_eps")
    private Short idEps;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descr_eps")
    private String descrEps;
    @OneToMany(mappedBy = "idEps")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public Eps() {
    }

    public Eps(Short idEps) {
        this.idEps = idEps;
    }

    public Eps(Short idEps, String descrEps) {
        this.idEps = idEps;
        this.descrEps = descrEps;
    }

    public Short getIdEps() {
        return idEps;
    }

    public void setIdEps(Short idEps) {
        this.idEps = idEps;
    }

    public String getDescrEps() {
        return descrEps;
    }

    public void setDescrEps(String descrEps) {
        this.descrEps = descrEps;
    }

    @XmlTransient
    public List<MatrizCaracterizacion> getMatrizCaracterizacionList() {
        return matrizCaracterizacionList;
    }

    public void setMatrizCaracterizacionList(List<MatrizCaracterizacion> matrizCaracterizacionList) {
        this.matrizCaracterizacionList = matrizCaracterizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEps != null ? idEps.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eps)) {
            return false;
        }
        Eps other = (Eps) object;
        if ((this.idEps == null && other.idEps != null) || (this.idEps != null && !this.idEps.equals(other.idEps))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Eps[ idEps=" + idEps + " ]";
    }
    
}
