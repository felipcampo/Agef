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
@Table(name = "estado_caso_bienestar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCasoBienestar.findAll", query = "SELECT e FROM EstadoCasoBienestar e"),
    @NamedQuery(name = "EstadoCasoBienestar.findByIdEstadoCasoBienestar", query = "SELECT e FROM EstadoCasoBienestar e WHERE e.idEstadoCasoBienestar = :idEstadoCasoBienestar"),
    @NamedQuery(name = "EstadoCasoBienestar.findByDescrEstCasBie", query = "SELECT e FROM EstadoCasoBienestar e WHERE e.descrEstCasBie = :descrEstCasBie")})
public class EstadoCasoBienestar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_caso_bienestar")
    private Integer idEstadoCasoBienestar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "descr_est_cas_bie")
    private String descrEstCasBie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoCasoBienestar")
    private List<CasoBienestar> casoBienestarList;

    public EstadoCasoBienestar() {
    }

    public EstadoCasoBienestar(Integer idEstadoCasoBienestar) {
        this.idEstadoCasoBienestar = idEstadoCasoBienestar;
    }

    public EstadoCasoBienestar(Integer idEstadoCasoBienestar, String descrEstCasBie) {
        this.idEstadoCasoBienestar = idEstadoCasoBienestar;
        this.descrEstCasBie = descrEstCasBie;
    }

    public Integer getIdEstadoCasoBienestar() {
        return idEstadoCasoBienestar;
    }

    public void setIdEstadoCasoBienestar(Integer idEstadoCasoBienestar) {
        this.idEstadoCasoBienestar = idEstadoCasoBienestar;
    }

    public String getDescrEstCasBie() {
        return descrEstCasBie;
    }

    public void setDescrEstCasBie(String descrEstCasBie) {
        this.descrEstCasBie = descrEstCasBie;
    }

    @XmlTransient
    public List<CasoBienestar> getCasoBienestarList() {
        return casoBienestarList;
    }

    public void setCasoBienestarList(List<CasoBienestar> casoBienestarList) {
        this.casoBienestarList = casoBienestarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoCasoBienestar != null ? idEstadoCasoBienestar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCasoBienestar)) {
            return false;
        }
        EstadoCasoBienestar other = (EstadoCasoBienestar) object;
        if ((this.idEstadoCasoBienestar == null && other.idEstadoCasoBienestar != null) || (this.idEstadoCasoBienestar != null && !this.idEstadoCasoBienestar.equals(other.idEstadoCasoBienestar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EstadoCasoBienestar[ idEstadoCasoBienestar=" + idEstadoCasoBienestar + " ]";
    }
    
}
