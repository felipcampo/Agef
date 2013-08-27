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
@Table(name = "tipo_formacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoFormacion.findAll", query = "SELECT t FROM TipoFormacion t"),
    @NamedQuery(name = "TipoFormacion.findByIdTipoFormacion", query = "SELECT t FROM TipoFormacion t WHERE t.idTipoFormacion = :idTipoFormacion"),
    @NamedQuery(name = "TipoFormacion.findByDescrTipFor", query = "SELECT t FROM TipoFormacion t WHERE t.descrTipFor = :descrTipFor")})
public class TipoFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_formacion")
    private Integer idTipoFormacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descr_tip_for")
    private String descrTipFor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoFormacion")
    private List<FichaCaracterizacion> fichaCaracterizacionList;

    public TipoFormacion() {
    }

    public TipoFormacion(Integer idTipoFormacion) {
        this.idTipoFormacion = idTipoFormacion;
    }

    public TipoFormacion(Integer idTipoFormacion, String descrTipFor) {
        this.idTipoFormacion = idTipoFormacion;
        this.descrTipFor = descrTipFor;
    }

    public Integer getIdTipoFormacion() {
        return idTipoFormacion;
    }

    public void setIdTipoFormacion(Integer idTipoFormacion) {
        this.idTipoFormacion = idTipoFormacion;
    }

    public String getDescrTipFor() {
        return descrTipFor;
    }

    public void setDescrTipFor(String descrTipFor) {
        this.descrTipFor = descrTipFor;
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
        hash += (idTipoFormacion != null ? idTipoFormacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoFormacion)) {
            return false;
        }
        TipoFormacion other = (TipoFormacion) object;
        if ((this.idTipoFormacion == null && other.idTipoFormacion != null) || (this.idTipoFormacion != null && !this.idTipoFormacion.equals(other.idTipoFormacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TipoFormacion[ idTipoFormacion=" + idTipoFormacion + " ]";
    }
    
}
