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
@Table(name = "subactividad_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubactividadAprendizaje.findAll", query = "SELECT s FROM SubactividadAprendizaje s"),
    @NamedQuery(name = "SubactividadAprendizaje.findByIdSubactividadProyecto", query = "SELECT s FROM SubactividadAprendizaje s WHERE s.idSubactividadProyecto = :idSubactividadProyecto"),
    @NamedQuery(name = "SubactividadAprendizaje.findByDescrNombreSubPro", query = "SELECT s FROM SubactividadAprendizaje s WHERE s.descrNombreSubPro = :descrNombreSubPro")})
public class SubactividadAprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_subactividad_proyecto")
    private String idSubactividadProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descr_nombre_sub_pro")
    private String descrNombreSubPro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSubactividadProyecto")
    private List<PlaneacionPedagogica> planeacionPedagogicaList;
    @JoinColumn(name = "id_actividad_aprendizaje", referencedColumnName = "id_actividad_aprendizaje")
    @ManyToOne(optional = false)
    private ActividadAprendizaje idActividadAprendizaje;

    public SubactividadAprendizaje() {
    }

    public SubactividadAprendizaje(String idSubactividadProyecto) {
        this.idSubactividadProyecto = idSubactividadProyecto;
    }

    public SubactividadAprendizaje(String idSubactividadProyecto, String descrNombreSubPro) {
        this.idSubactividadProyecto = idSubactividadProyecto;
        this.descrNombreSubPro = descrNombreSubPro;
    }

    public String getIdSubactividadProyecto() {
        return idSubactividadProyecto;
    }

    public void setIdSubactividadProyecto(String idSubactividadProyecto) {
        this.idSubactividadProyecto = idSubactividadProyecto;
    }

    public String getDescrNombreSubPro() {
        return descrNombreSubPro;
    }

    public void setDescrNombreSubPro(String descrNombreSubPro) {
        this.descrNombreSubPro = descrNombreSubPro;
    }

    @XmlTransient
    public List<PlaneacionPedagogica> getPlaneacionPedagogicaList() {
        return planeacionPedagogicaList;
    }

    public void setPlaneacionPedagogicaList(List<PlaneacionPedagogica> planeacionPedagogicaList) {
        this.planeacionPedagogicaList = planeacionPedagogicaList;
    }

    public ActividadAprendizaje getIdActividadAprendizaje() {
        return idActividadAprendizaje;
    }

    public void setIdActividadAprendizaje(ActividadAprendizaje idActividadAprendizaje) {
        this.idActividadAprendizaje = idActividadAprendizaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubactividadProyecto != null ? idSubactividadProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubactividadAprendizaje)) {
            return false;
        }
        SubactividadAprendizaje other = (SubactividadAprendizaje) object;
        if ((this.idSubactividadProyecto == null && other.idSubactividadProyecto != null) || (this.idSubactividadProyecto != null && !this.idSubactividadProyecto.equals(other.idSubactividadProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descrNombreSubPro;
    }
    
}
