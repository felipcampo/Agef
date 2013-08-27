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
@Table(name = "estado_plan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoPlan.findAll", query = "SELECT e FROM EstadoPlan e"),
    @NamedQuery(name = "EstadoPlan.findByIdEstadoPlan", query = "SELECT e FROM EstadoPlan e WHERE e.idEstadoPlan = :idEstadoPlan"),
    @NamedQuery(name = "EstadoPlan.findByNomEstadoPlan", query = "SELECT e FROM EstadoPlan e WHERE e.nomEstadoPlan = :nomEstadoPlan")})
public class EstadoPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_plan")
    private Short idEstadoPlan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nom_estado_plan")
    private String nomEstadoPlan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoPlan")
    private List<PlanMejoramiento> planMejoramientoList;

    public EstadoPlan() {
    }

    public EstadoPlan(Short idEstadoPlan) {
        this.idEstadoPlan = idEstadoPlan;
    }

    public EstadoPlan(Short idEstadoPlan, String nomEstadoPlan) {
        this.idEstadoPlan = idEstadoPlan;
        this.nomEstadoPlan = nomEstadoPlan;
    }

    public Short getIdEstadoPlan() {
        return idEstadoPlan;
    }

    public void setIdEstadoPlan(Short idEstadoPlan) {
        this.idEstadoPlan = idEstadoPlan;
    }

    public String getNomEstadoPlan() {
        return nomEstadoPlan;
    }

    public void setNomEstadoPlan(String nomEstadoPlan) {
        this.nomEstadoPlan = nomEstadoPlan;
    }

    @XmlTransient
    public List<PlanMejoramiento> getPlanMejoramientoList() {
        return planMejoramientoList;
    }

    public void setPlanMejoramientoList(List<PlanMejoramiento> planMejoramientoList) {
        this.planMejoramientoList = planMejoramientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoPlan != null ? idEstadoPlan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoPlan)) {
            return false;
        }
        EstadoPlan other = (EstadoPlan) object;
        if ((this.idEstadoPlan == null && other.idEstadoPlan != null) || (this.idEstadoPlan != null && !this.idEstadoPlan.equals(other.idEstadoPlan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EstadoPlan[ idEstadoPlan=" + idEstadoPlan + " ]";
    }
    
}
