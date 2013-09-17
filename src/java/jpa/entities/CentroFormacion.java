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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "centro_formacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentroFormacion.findAll", query = "SELECT c FROM CentroFormacion c"),
    @NamedQuery(name = "CentroFormacion.findByIdCentroFormacion", query = "SELECT c FROM CentroFormacion c WHERE c.idCentroFormacion = :idCentroFormacion"),
    @NamedQuery(name = "CentroFormacion.findByDirCen", query = "SELECT c FROM CentroFormacion c WHERE c.dirCen = :dirCen"),
    @NamedQuery(name = "CentroFormacion.findByNomCen", query = "SELECT c FROM CentroFormacion c WHERE c.nomCen = :nomCen")})
public class CentroFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_centro_formacion")
    private String idCentroFormacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "dir_cen")
    private String dirCen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_cen")
    private String nomCen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCentroFormacion")
    private List<Programa> programaList;
    @JoinColumn(name = "id_regional", referencedColumnName = "id_regional")
    @ManyToOne(optional = false)
    private Regional idRegional;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCentroFormacion")
    private List<SeguimientoProductiva> seguimientoProductivaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCentroFormativo")
    private List<PraxisPedagogica> praxisPedagogicaList;

    public CentroFormacion() {
    }

    public CentroFormacion(String idCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
    }

    public CentroFormacion(String idCentroFormacion, String dirCen, String nomCen) {
        this.idCentroFormacion = idCentroFormacion;
        this.dirCen = dirCen;
        this.nomCen = nomCen;
    }

    public String getIdCentroFormacion() {
        return idCentroFormacion;
    }

    public void setIdCentroFormacion(String idCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
    }

    public String getDirCen() {
        return dirCen;
    }

    public void setDirCen(String dirCen) {
        this.dirCen = dirCen;
    }

    public String getNomCen() {
        return nomCen;
    }

    public void setNomCen(String nomCen) {
        this.nomCen = nomCen;
    }

    @XmlTransient
    public List<Programa> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<Programa> programaList) {
        this.programaList = programaList;
    }

    public Regional getIdRegional() {
        return idRegional;
    }

    public void setIdRegional(Regional idRegional) {
        this.idRegional = idRegional;
    }

    @XmlTransient
    public List<SeguimientoProductiva> getSeguimientoProductivaList() {
        return seguimientoProductivaList;
    }

    public void setSeguimientoProductivaList(List<SeguimientoProductiva> seguimientoProductivaList) {
        this.seguimientoProductivaList = seguimientoProductivaList;
    }

    @XmlTransient
    public List<PraxisPedagogica> getPraxisPedagogicaList() {
        return praxisPedagogicaList;
    }

    public void setPraxisPedagogicaList(List<PraxisPedagogica> praxisPedagogicaList) {
        this.praxisPedagogicaList = praxisPedagogicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCentroFormacion != null ? idCentroFormacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroFormacion)) {
            return false;
        }
        CentroFormacion other = (CentroFormacion) object;
        if ((this.idCentroFormacion == null && other.idCentroFormacion != null) || (this.idCentroFormacion != null && !this.idCentroFormacion.equals(other.idCentroFormacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.CentroFormacion[ idCentroFormacion=" + idCentroFormacion + " ]";
    }
    
}
