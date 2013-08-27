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
 * @author leoandresm
 */
@Entity
@Table(name = "subactividad_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubactividadProyecto.findAll", query = "SELECT s FROM SubactividadProyecto s"),
    @NamedQuery(name = "SubactividadProyecto.findByIdSubactividadProyecto", query = "SELECT s FROM SubactividadProyecto s WHERE s.idSubactividadProyecto = :idSubactividadProyecto"),
    @NamedQuery(name = "SubactividadProyecto.findByDescrNombreSubPro", query = "SELECT s FROM SubactividadProyecto s WHERE s.descrNombreSubPro = :descrNombreSubPro")})
public class SubactividadProyecto implements Serializable {
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
    @JoinColumn(name = "id_actividad_proyecto", referencedColumnName = "id_actividad_proyecto")
    @ManyToOne(optional = false)
    private ActividadProyecto idActividadProyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSubactividadProyecto")
    private List<EvidenciaAprendizaje> evidenciaAprendizajeList;

    public SubactividadProyecto() {
    }

    public SubactividadProyecto(String idSubactividadProyecto) {
        this.idSubactividadProyecto = idSubactividadProyecto;
    }

    public SubactividadProyecto(String idSubactividadProyecto, String descrNombreSubPro) {
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

    public ActividadProyecto getIdActividadProyecto() {
        return idActividadProyecto;
    }

    public void setIdActividadProyecto(ActividadProyecto idActividadProyecto) {
        this.idActividadProyecto = idActividadProyecto;
    }

    @XmlTransient
    public List<EvidenciaAprendizaje> getEvidenciaAprendizajeList() {
        return evidenciaAprendizajeList;
    }

    public void setEvidenciaAprendizajeList(List<EvidenciaAprendizaje> evidenciaAprendizajeList) {
        this.evidenciaAprendizajeList = evidenciaAprendizajeList;
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
        if (!(object instanceof SubactividadProyecto)) {
            return false;
        }
        SubactividadProyecto other = (SubactividadProyecto) object;
        if ((this.idSubactividadProyecto == null && other.idSubactividadProyecto != null) || (this.idSubactividadProyecto != null && !this.idSubactividadProyecto.equals(other.idSubactividadProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.SubactividadProyecto[ idSubactividadProyecto=" + idSubactividadProyecto + " ]";
    }
    
}
