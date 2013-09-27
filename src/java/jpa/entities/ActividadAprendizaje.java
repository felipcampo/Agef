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
@Table(name = "actividad_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadAprendizaje.findAll", query = "SELECT a FROM ActividadAprendizaje a"),
    @NamedQuery(name = "ActividadAprendizaje.findByIdActividadAprendizaje", query = "SELECT a FROM ActividadAprendizaje a WHERE a.idActividadAprendizaje = :idActividadAprendizaje"),
    @NamedQuery(name = "ActividadAprendizaje.findByNombActividadAprendizaje", query = "SELECT a FROM ActividadAprendizaje a WHERE a.nombActividadAprendizaje = :nombActividadAprendizaje"),
    @NamedQuery(name = "ActividadAprendizaje.findByDescrActividadAprendizaje", query = "SELECT a FROM ActividadAprendizaje a WHERE a.descrActividadAprendizaje = :descrActividadAprendizaje")})
public class ActividadAprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_actividad_aprendizaje")
    private Integer idActividadAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomb_actividad_aprendizaje")
    private String nombActividadAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descr_actividad_aprendizaje")
    private String descrActividadAprendizaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividadAprendizaje")
    private List<SubactividadAprendizaje> subactividadAprendizajeList;

    public ActividadAprendizaje() {
    }

    public ActividadAprendizaje(Integer idActividadAprendizaje) {
        this.idActividadAprendizaje = idActividadAprendizaje;
    }

    public ActividadAprendizaje(Integer idActividadAprendizaje, String nombActividadAprendizaje, String descrActividadAprendizaje) {
        this.idActividadAprendizaje = idActividadAprendizaje;
        this.nombActividadAprendizaje = nombActividadAprendizaje;
        this.descrActividadAprendizaje = descrActividadAprendizaje;
    }

    public Integer getIdActividadAprendizaje() {
        return idActividadAprendizaje;
    }

    public void setIdActividadAprendizaje(Integer idActividadAprendizaje) {
        this.idActividadAprendizaje = idActividadAprendizaje;
    }

    public String getNombActividadAprendizaje() {
        return nombActividadAprendizaje;
    }

    public void setNombActividadAprendizaje(String nombActividadAprendizaje) {
        this.nombActividadAprendizaje = nombActividadAprendizaje;
    }

    public String getDescrActividadAprendizaje() {
        return descrActividadAprendizaje;
    }

    public void setDescrActividadAprendizaje(String descrActividadAprendizaje) {
        this.descrActividadAprendizaje = descrActividadAprendizaje;
    }

    @XmlTransient
    public List<SubactividadAprendizaje> getSubactividadAprendizajeList() {
        return subactividadAprendizajeList;
    }

    public void setSubactividadAprendizajeList(List<SubactividadAprendizaje> subactividadAprendizajeList) {
        this.subactividadAprendizajeList = subactividadAprendizajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividadAprendizaje != null ? idActividadAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadAprendizaje)) {
            return false;
        }
        ActividadAprendizaje other = (ActividadAprendizaje) object;
        if ((this.idActividadAprendizaje == null && other.idActividadAprendizaje != null) || (this.idActividadAprendizaje != null && !this.idActividadAprendizaje.equals(other.idActividadAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ActividadAprendizaje[ idActividadAprendizaje=" + idActividadAprendizaje + " ]";
    }
    
}
