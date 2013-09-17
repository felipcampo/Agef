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
@Table(name = "grado_juicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GradoJuicio.findAll", query = "SELECT g FROM GradoJuicio g"),
    @NamedQuery(name = "GradoJuicio.findByIdGradoJuicio", query = "SELECT g FROM GradoJuicio g WHERE g.idGradoJuicio = :idGradoJuicio"),
    @NamedQuery(name = "GradoJuicio.findByDescrGradoJuicio", query = "SELECT g FROM GradoJuicio g WHERE g.descrGradoJuicio = :descrGradoJuicio")})
public class GradoJuicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grado_juicio")
    private Short idGradoJuicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descr_grado_juicio")
    private String descrGradoJuicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGradoJuicio")
    private List<SeguimientoInstructor> seguimientoInstructorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGradoJuicio")
    private List<CriterioSeguimientoProyecto> criterioSeguimientoProyectoList;

    public GradoJuicio() {
    }

    public GradoJuicio(Short idGradoJuicio) {
        this.idGradoJuicio = idGradoJuicio;
    }

    public GradoJuicio(Short idGradoJuicio, String descrGradoJuicio) {
        this.idGradoJuicio = idGradoJuicio;
        this.descrGradoJuicio = descrGradoJuicio;
    }

    public Short getIdGradoJuicio() {
        return idGradoJuicio;
    }

    public void setIdGradoJuicio(Short idGradoJuicio) {
        this.idGradoJuicio = idGradoJuicio;
    }

    public String getDescrGradoJuicio() {
        return descrGradoJuicio;
    }

    public void setDescrGradoJuicio(String descrGradoJuicio) {
        this.descrGradoJuicio = descrGradoJuicio;
    }

    @XmlTransient
    public List<SeguimientoInstructor> getSeguimientoInstructorList() {
        return seguimientoInstructorList;
    }

    public void setSeguimientoInstructorList(List<SeguimientoInstructor> seguimientoInstructorList) {
        this.seguimientoInstructorList = seguimientoInstructorList;
    }

    @XmlTransient
    public List<CriterioSeguimientoProyecto> getCriterioSeguimientoProyectoList() {
        return criterioSeguimientoProyectoList;
    }

    public void setCriterioSeguimientoProyectoList(List<CriterioSeguimientoProyecto> criterioSeguimientoProyectoList) {
        this.criterioSeguimientoProyectoList = criterioSeguimientoProyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGradoJuicio != null ? idGradoJuicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradoJuicio)) {
            return false;
        }
        GradoJuicio other = (GradoJuicio) object;
        if ((this.idGradoJuicio == null && other.idGradoJuicio != null) || (this.idGradoJuicio != null && !this.idGradoJuicio.equals(other.idGradoJuicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.GradoJuicio[ idGradoJuicio=" + idGradoJuicio + " ]";
    }
    
}
