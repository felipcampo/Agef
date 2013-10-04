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
@Table(name = "tipo_criterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCriterio.findAll", query = "SELECT t FROM TipoCriterio t"),
    @NamedQuery(name = "TipoCriterio.findByIdTipoCriterio", query = "SELECT t FROM TipoCriterio t WHERE t.idTipoCriterio = :idTipoCriterio"),
    @NamedQuery(name = "TipoCriterio.findByNomTipoCriterio", query = "SELECT t FROM TipoCriterio t WHERE t.nomTipoCriterio = :nomTipoCriterio")})
public class TipoCriterio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_criterio")
    private Short idTipoCriterio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_tipo_criterio")
    private String nomTipoCriterio;
    @OneToMany(mappedBy = "idTipoCriterio")
    private List<CriterioEvaluacion> criterioEvaluacionList;

    public TipoCriterio() {
    }

    public TipoCriterio(Short idTipoCriterio) {
        this.idTipoCriterio = idTipoCriterio;
    }

    public TipoCriterio(Short idTipoCriterio, String nomTipoCriterio) {
        this.idTipoCriterio = idTipoCriterio;
        this.nomTipoCriterio = nomTipoCriterio;
    }

    public Short getIdTipoCriterio() {
        return idTipoCriterio;
    }

    public void setIdTipoCriterio(Short idTipoCriterio) {
        this.idTipoCriterio = idTipoCriterio;
    }

    public String getNomTipoCriterio() {
        return nomTipoCriterio;
    }

    public void setNomTipoCriterio(String nomTipoCriterio) {
        this.nomTipoCriterio = nomTipoCriterio;
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
        hash += (idTipoCriterio != null ? idTipoCriterio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCriterio)) {
            return false;
        }
        TipoCriterio other = (TipoCriterio) object;
        if ((this.idTipoCriterio == null && other.idTipoCriterio != null) || (this.idTipoCriterio != null && !this.idTipoCriterio.equals(other.idTipoCriterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomTipoCriterio;
    }
    
}
