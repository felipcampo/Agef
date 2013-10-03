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
 * @author MAURICIO
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_titulo_criterio")
    private Short idTituloCriterio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descr_nom_titulo_criterio")
    private String descrNomTituloCriterio;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Rol idRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTituloCriterio")
    private List<SeguimientoInstructor> seguimientoInstructorList;
    @OneToMany(mappedBy = "idTituloCriterio")
    private List<CriterioEvaluacion> criterioEvaluacionList;

    public TituloCriterio() {
    }

    public TituloCriterio(Short idTituloCriterio) {
        this.idTituloCriterio = idTituloCriterio;
    }

    public TituloCriterio(Short idTituloCriterio, String descrNomTituloCriterio) {
        this.idTituloCriterio = idTituloCriterio;
        this.descrNomTituloCriterio = descrNomTituloCriterio;
    }

    public Short getIdTituloCriterio() {
        return idTituloCriterio;
    }

    public void setIdTituloCriterio(Short idTituloCriterio) {
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
