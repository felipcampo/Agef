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
@Table(name = "ocupacion_jefe_hogar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OcupacionJefeHogar.findAll", query = "SELECT o FROM OcupacionJefeHogar o"),
    @NamedQuery(name = "OcupacionJefeHogar.findByIdOcupacionJefeHogar", query = "SELECT o FROM OcupacionJefeHogar o WHERE o.idOcupacionJefeHogar = :idOcupacionJefeHogar"),
    @NamedQuery(name = "OcupacionJefeHogar.findByDescrOcupacionJefe", query = "SELECT o FROM OcupacionJefeHogar o WHERE o.descrOcupacionJefe = :descrOcupacionJefe")})
public class OcupacionJefeHogar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ocupacion_jefe_hogar")
    private Short idOcupacionJefeHogar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "descr_ocupacion_jefe")
    private String descrOcupacionJefe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOcupacionJefeHogar")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public OcupacionJefeHogar() {
    }

    public OcupacionJefeHogar(Short idOcupacionJefeHogar) {
        this.idOcupacionJefeHogar = idOcupacionJefeHogar;
    }

    public OcupacionJefeHogar(Short idOcupacionJefeHogar, String descrOcupacionJefe) {
        this.idOcupacionJefeHogar = idOcupacionJefeHogar;
        this.descrOcupacionJefe = descrOcupacionJefe;
    }

    public Short getIdOcupacionJefeHogar() {
        return idOcupacionJefeHogar;
    }

    public void setIdOcupacionJefeHogar(Short idOcupacionJefeHogar) {
        this.idOcupacionJefeHogar = idOcupacionJefeHogar;
    }

    public String getDescrOcupacionJefe() {
        return descrOcupacionJefe;
    }

    public void setDescrOcupacionJefe(String descrOcupacionJefe) {
        this.descrOcupacionJefe = descrOcupacionJefe;
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
        hash += (idOcupacionJefeHogar != null ? idOcupacionJefeHogar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OcupacionJefeHogar)) {
            return false;
        }
        OcupacionJefeHogar other = (OcupacionJefeHogar) object;
        if ((this.idOcupacionJefeHogar == null && other.idOcupacionJefeHogar != null) || (this.idOcupacionJefeHogar != null && !this.idOcupacionJefeHogar.equals(other.idOcupacionJefeHogar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.OcupacionJefeHogar[ idOcupacionJefeHogar=" + idOcupacionJefeHogar + " ]";
    }
    
}
