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
 * @author ADSI
 */
@Entity
@Table(name = "nivel_alimentacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelAlimentacion.findAll", query = "SELECT n FROM NivelAlimentacion n"),
    @NamedQuery(name = "NivelAlimentacion.findByIdNivelAlimentacion", query = "SELECT n FROM NivelAlimentacion n WHERE n.idNivelAlimentacion = :idNivelAlimentacion"),
    @NamedQuery(name = "NivelAlimentacion.findByDescrNivelAlimentacion", query = "SELECT n FROM NivelAlimentacion n WHERE n.descrNivelAlimentacion = :descrNivelAlimentacion")})
public class NivelAlimentacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nivel_alimentacion")
    private Short idNivelAlimentacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "descr_nivel_alimentacion")
    private String descrNivelAlimentacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelAlimentacion")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public NivelAlimentacion() {
    }

    public NivelAlimentacion(Short idNivelAlimentacion) {
        this.idNivelAlimentacion = idNivelAlimentacion;
    }

    public NivelAlimentacion(Short idNivelAlimentacion, String descrNivelAlimentacion) {
        this.idNivelAlimentacion = idNivelAlimentacion;
        this.descrNivelAlimentacion = descrNivelAlimentacion;
    }

    public Short getIdNivelAlimentacion() {
        return idNivelAlimentacion;
    }

    public void setIdNivelAlimentacion(Short idNivelAlimentacion) {
        this.idNivelAlimentacion = idNivelAlimentacion;
    }

    public String getDescrNivelAlimentacion() {
        return descrNivelAlimentacion;
    }

    public void setDescrNivelAlimentacion(String descrNivelAlimentacion) {
        this.descrNivelAlimentacion = descrNivelAlimentacion;
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
        hash += (idNivelAlimentacion != null ? idNivelAlimentacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelAlimentacion)) {
            return false;
        }
        NivelAlimentacion other = (NivelAlimentacion) object;
        if ((this.idNivelAlimentacion == null && other.idNivelAlimentacion != null) || (this.idNivelAlimentacion != null && !this.idNivelAlimentacion.equals(other.idNivelAlimentacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.NivelAlimentacion[ idNivelAlimentacion=" + idNivelAlimentacion + " ]";
    }
    
}
