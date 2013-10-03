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
 * @author MAURICIO
 */
@Entity
@Table(name = "jornada_formacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JornadaFormacion.findAll", query = "SELECT j FROM JornadaFormacion j"),
    @NamedQuery(name = "JornadaFormacion.findByIdJornadaFormacion", query = "SELECT j FROM JornadaFormacion j WHERE j.idJornadaFormacion = :idJornadaFormacion"),
    @NamedQuery(name = "JornadaFormacion.findByDescrJornadaFormacion", query = "SELECT j FROM JornadaFormacion j WHERE j.descrJornadaFormacion = :descrJornadaFormacion")})
public class JornadaFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_jornada_formacion")
    private Integer idJornadaFormacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descr_jornada_formacion")
    private String descrJornadaFormacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJornadaFormacion")
    private List<FichaCaracterizacion> fichaCaracterizacionList;

    public JornadaFormacion() {
    }

    public JornadaFormacion(Integer idJornadaFormacion) {
        this.idJornadaFormacion = idJornadaFormacion;
    }

    public JornadaFormacion(Integer idJornadaFormacion, String descrJornadaFormacion) {
        this.idJornadaFormacion = idJornadaFormacion;
        this.descrJornadaFormacion = descrJornadaFormacion;
    }

    public Integer getIdJornadaFormacion() {
        return idJornadaFormacion;
    }

    public void setIdJornadaFormacion(Integer idJornadaFormacion) {
        this.idJornadaFormacion = idJornadaFormacion;
    }

    public String getDescrJornadaFormacion() {
        return descrJornadaFormacion;
    }

    public void setDescrJornadaFormacion(String descrJornadaFormacion) {
        this.descrJornadaFormacion = descrJornadaFormacion;
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
        hash += (idJornadaFormacion != null ? idJornadaFormacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JornadaFormacion)) {
            return false;
        }
        JornadaFormacion other = (JornadaFormacion) object;
        if ((this.idJornadaFormacion == null && other.idJornadaFormacion != null) || (this.idJornadaFormacion != null && !this.idJornadaFormacion.equals(other.idJornadaFormacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.JornadaFormacion[ idJornadaFormacion=" + idJornadaFormacion + " ]";
    }
    
}
