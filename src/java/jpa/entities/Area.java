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
 * @author ADSI
 */
@Entity
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"),
    @NamedQuery(name = "Area.findByIdArea", query = "SELECT a FROM Area a WHERE a.idArea = :idArea"),
    @NamedQuery(name = "Area.findByDescrArea", query = "SELECT a FROM Area a WHERE a.descrArea = :descrArea")})
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_area")
    private Short idArea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descr_area")
    private String descrArea;
    @OneToMany(mappedBy = "idArea")
    private List<SeguimientoProyecto> seguimientoProyectoList;

    public Area() {
    }

    public Area(Short idArea) {
        this.idArea = idArea;
    }

    public Area(Short idArea, String descrArea) {
        this.idArea = idArea;
        this.descrArea = descrArea;
    }

    public Short getIdArea() {
        return idArea;
    }

    public void setIdArea(Short idArea) {
        this.idArea = idArea;
    }

    public String getDescrArea() {
        return descrArea;
    }

    public void setDescrArea(String descrArea) {
        this.descrArea = descrArea;
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
        hash += (idArea != null ? idArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.idArea == null && other.idArea != null) || (this.idArea != null && !this.idArea.equals(other.idArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descrArea;
    }
    
}
