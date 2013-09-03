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
@Table(name = "titulo_criterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TituloCriterio.findAll", query = "SELECT t FROM TituloCriterio t"),
    @NamedQuery(name = "TituloCriterio.findByIdTituloCriterio", query = "SELECT t FROM TituloCriterio t WHERE t.idTituloCriterio = :idTituloCriterio"),
    @NamedQuery(name = "TituloCriterio.findByDescrNomTituloCriterio", query = "SELECT t FROM TituloCriterio t WHERE t.descrNomTituloCriterio = :descrNomTituloCriterio")})
public class TituloCriterio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_titulo_criterio")
    private String idTituloCriterio;
    @Size(max = 255)
    @Column(name = "descr_nom_titulo_criterio")
    private String descrNomTituloCriterio;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Rol idRol;
    @OneToMany(mappedBy = "idTituloCriterio")
    private List<SeguimientoInstructor> seguimientoInstructorList;
    @OneToMany(mappedBy = "idTituloCriterio")
    private List<CriterioEvaluacion> criterioEvaluacionList;
    @OneToMany(mappedBy = "idTituloCriterio")
    private List<SeguimientoProyecto> seguimientoProyectoList;

    public TituloCriterio() {
    }

    public TituloCriterio(String idTituloCriterio) {
        this.idTituloCriterio = idTituloCriterio;
    }

    public String getIdTituloCriterio() {
        return idTituloCriterio;
    }

    public void setIdTituloCriterio(String idTituloCriterio) {
        this.idTituloCriterio = idTituloCriterio;
    }

    public String getDescrNomTituloCriterio() {
        return descrNomTituloCriterio;
    }

    public void setDescrNomTituloCriterio(String descrNomTituloCriterio) {
        this.descrNomTituloCriterio = descrNomTituloCriterio;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    @XmlTransient
    public List<SeguimientoInstructor> getSeguimientoInstructorList() {
        return seguimientoInstructorList;
    }

    public void setSeguimientoInstructorList(List<SeguimientoInstructor> seguimientoInstructorList) {
        this.seguimientoInstructorList = seguimientoInstructorList;
    }

    @XmlTransient
    public List<CriterioEvaluacion> getCriterioEvaluacionList() {
        return criterioEvaluacionList;
    }

    public void setCriterioEvaluacionList(List<CriterioEvaluacion> criterioEvaluacionList) {
        this.criterioEvaluacionList = criterioEvaluacionList;
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
        hash += (idTituloCriterio != null ? idTituloCriterio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TituloCriterio)) {
            return false;
        }
        TituloCriterio other = (TituloCriterio) object;
        if ((this.idTituloCriterio == null && other.idTituloCriterio != null) || (this.idTituloCriterio != null && !this.idTituloCriterio.equals(other.idTituloCriterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TituloCriterio[ idTituloCriterio=" + idTituloCriterio + " ]";
    }
    
}
