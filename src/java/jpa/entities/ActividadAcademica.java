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
@Table(name = "actividad_academica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadAcademica.findAll", query = "SELECT a FROM ActividadAcademica a"),
    @NamedQuery(name = "ActividadAcademica.findByIdActividadAcademica", query = "SELECT a FROM ActividadAcademica a WHERE a.idActividadAcademica = :idActividadAcademica"),
    @NamedQuery(name = "ActividadAcademica.findByDescrActividadAcademica", query = "SELECT a FROM ActividadAcademica a WHERE a.descrActividadAcademica = :descrActividadAcademica")})
public class ActividadAcademica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_actividad_academica")
    private Short idActividadAcademica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descr_actividad_academica")
    private String descrActividadAcademica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividadAcademica")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public ActividadAcademica() {
    }

    public ActividadAcademica(Short idActividadAcademica) {
        this.idActividadAcademica = idActividadAcademica;
    }

    public ActividadAcademica(Short idActividadAcademica, String descrActividadAcademica) {
        this.idActividadAcademica = idActividadAcademica;
        this.descrActividadAcademica = descrActividadAcademica;
    }

    public Short getIdActividadAcademica() {
        return idActividadAcademica;
    }

    public void setIdActividadAcademica(Short idActividadAcademica) {
        this.idActividadAcademica = idActividadAcademica;
    }

    public String getDescrActividadAcademica() {
        return descrActividadAcademica;
    }

    public void setDescrActividadAcademica(String descrActividadAcademica) {
        this.descrActividadAcademica = descrActividadAcademica;
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
        hash += (idActividadAcademica != null ? idActividadAcademica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadAcademica)) {
            return false;
        }
        ActividadAcademica other = (ActividadAcademica) object;
        if ((this.idActividadAcademica == null && other.idActividadAcademica != null) || (this.idActividadAcademica != null && !this.idActividadAcademica.equals(other.idActividadAcademica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ActividadAcademica[ idActividadAcademica=" + idActividadAcademica + " ]";
    }
    
}
