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
@Table(name = "jefe_hogar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JefeHogar.findAll", query = "SELECT j FROM JefeHogar j"),
    @NamedQuery(name = "JefeHogar.findByIdJefeHogar", query = "SELECT j FROM JefeHogar j WHERE j.idJefeHogar = :idJefeHogar"),
    @NamedQuery(name = "JefeHogar.findByDescrJefeHogar", query = "SELECT j FROM JefeHogar j WHERE j.descrJefeHogar = :descrJefeHogar")})
public class JefeHogar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_jefe_hogar")
    private Short idJefeHogar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "descr_jefe_hogar")
    private String descrJefeHogar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJefeHogar")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public JefeHogar() {
    }

    public JefeHogar(Short idJefeHogar) {
        this.idJefeHogar = idJefeHogar;
    }

    public JefeHogar(Short idJefeHogar, String descrJefeHogar) {
        this.idJefeHogar = idJefeHogar;
        this.descrJefeHogar = descrJefeHogar;
    }

    public Short getIdJefeHogar() {
        return idJefeHogar;
    }

    public void setIdJefeHogar(Short idJefeHogar) {
        this.idJefeHogar = idJefeHogar;
    }

    public String getDescrJefeHogar() {
        return descrJefeHogar;
    }

    public void setDescrJefeHogar(String descrJefeHogar) {
        this.descrJefeHogar = descrJefeHogar;
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
        hash += (idJefeHogar != null ? idJefeHogar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JefeHogar)) {
            return false;
        }
        JefeHogar other = (JefeHogar) object;
        if ((this.idJefeHogar == null && other.idJefeHogar != null) || (this.idJefeHogar != null && !this.idJefeHogar.equals(other.idJefeHogar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.JefeHogar[ idJefeHogar=" + idJefeHogar + " ]";
    }
    
}
