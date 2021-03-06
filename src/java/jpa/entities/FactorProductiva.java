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
@Table(name = "factor_productiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FactorProductiva.findAll", query = "SELECT f FROM FactorProductiva f"),
    @NamedQuery(name = "FactorProductiva.findByIdFactorProductiva", query = "SELECT f FROM FactorProductiva f WHERE f.idFactorProductiva = :idFactorProductiva"),
    @NamedQuery(name = "FactorProductiva.findByNomFactorProductiva", query = "SELECT f FROM FactorProductiva f WHERE f.nomFactorProductiva = :nomFactorProductiva")})
public class FactorProductiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_factor_productiva")
    private Short idFactorProductiva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_factor_productiva")
    private String nomFactorProductiva;
    @OneToMany(mappedBy = "idFactorProductiva")
    private List<CriterioEvaluacion> criterioEvaluacionList;

    public FactorProductiva() {
    }

    public FactorProductiva(Short idFactorProductiva) {
        this.idFactorProductiva = idFactorProductiva;
    }

    public FactorProductiva(Short idFactorProductiva, String nomFactorProductiva) {
        this.idFactorProductiva = idFactorProductiva;
        this.nomFactorProductiva = nomFactorProductiva;
    }

    public Short getIdFactorProductiva() {
        return idFactorProductiva;
    }

    public void setIdFactorProductiva(Short idFactorProductiva) {
        this.idFactorProductiva = idFactorProductiva;
    }

    public String getNomFactorProductiva() {
        return nomFactorProductiva;
    }

    public void setNomFactorProductiva(String nomFactorProductiva) {
        this.nomFactorProductiva = nomFactorProductiva;
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
        hash += (idFactorProductiva != null ? idFactorProductiva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactorProductiva)) {
            return false;
        }
        FactorProductiva other = (FactorProductiva) object;
        if ((this.idFactorProductiva == null && other.idFactorProductiva != null) || (this.idFactorProductiva != null && !this.idFactorProductiva.equals(other.idFactorProductiva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idFactorProductiva + " " + nomFactorProductiva;
    }
    
}
