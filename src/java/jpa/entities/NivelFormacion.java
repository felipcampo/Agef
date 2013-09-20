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
@Table(name = "nivel_formacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelFormacion.findAll", query = "SELECT n FROM NivelFormacion n"),
    @NamedQuery(name = "NivelFormacion.findByIdNivelFormacion", query = "SELECT n FROM NivelFormacion n WHERE n.idNivelFormacion = :idNivelFormacion"),
    @NamedQuery(name = "NivelFormacion.findByDescrNivFor", query = "SELECT n FROM NivelFormacion n WHERE n.descrNivFor = :descrNivFor")})
public class NivelFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nivel_formacion")
    private Short idNivelFormacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descr_niv_for")
    private String descrNivFor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelFormacion")
    private List<FichaCaracterizacion> fichaCaracterizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelFormacion")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;
    @OneToMany(mappedBy = "idNivelFormacion")
    private List<SeguimientoProyecto> seguimientoProyectoList;

    public NivelFormacion() {
    }

    public NivelFormacion(Short idNivelFormacion) {
        this.idNivelFormacion = idNivelFormacion;
    }

    public NivelFormacion(Short idNivelFormacion, String descrNivFor) {
        this.idNivelFormacion = idNivelFormacion;
        this.descrNivFor = descrNivFor;
    }

    public Short getIdNivelFormacion() {
        return idNivelFormacion;
    }

    public void setIdNivelFormacion(Short idNivelFormacion) {
        this.idNivelFormacion = idNivelFormacion;
    }

    public String getDescrNivFor() {
        return descrNivFor;
    }

    public void setDescrNivFor(String descrNivFor) {
        this.descrNivFor = descrNivFor;
    }

    @XmlTransient
    public List<FichaCaracterizacion> getFichaCaracterizacionList() {
        return fichaCaracterizacionList;
    }

    public void setFichaCaracterizacionList(List<FichaCaracterizacion> fichaCaracterizacionList) {
        this.fichaCaracterizacionList = fichaCaracterizacionList;
    }

    @XmlTransient
    public List<MatrizCaracterizacion> getMatrizCaracterizacionList() {
        return matrizCaracterizacionList;
    }

    public void setMatrizCaracterizacionList(List<MatrizCaracterizacion> matrizCaracterizacionList) {
        this.matrizCaracterizacionList = matrizCaracterizacionList;
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
        hash += (idNivelFormacion != null ? idNivelFormacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelFormacion)) {
            return false;
        }
        NivelFormacion other = (NivelFormacion) object;
        if ((this.idNivelFormacion == null && other.idNivelFormacion != null) || (this.idNivelFormacion != null && !this.idNivelFormacion.equals(other.idNivelFormacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descrNivFor;
    }
    
}
