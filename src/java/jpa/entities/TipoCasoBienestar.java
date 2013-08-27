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
@Table(name = "tipo_caso_bienestar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCasoBienestar.findAll", query = "SELECT t FROM TipoCasoBienestar t"),
    @NamedQuery(name = "TipoCasoBienestar.findByIdTipoCasoBienestar", query = "SELECT t FROM TipoCasoBienestar t WHERE t.idTipoCasoBienestar = :idTipoCasoBienestar"),
    @NamedQuery(name = "TipoCasoBienestar.findByDescrTipoBienestar", query = "SELECT t FROM TipoCasoBienestar t WHERE t.descrTipoBienestar = :descrTipoBienestar")})
public class TipoCasoBienestar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_caso_bienestar")
    private Integer idTipoCasoBienestar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "descr_tipo_bienestar")
    private String descrTipoBienestar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoCasoBienestar")
    private List<Remision> remisionList;

    public TipoCasoBienestar() {
    }

    public TipoCasoBienestar(Integer idTipoCasoBienestar) {
        this.idTipoCasoBienestar = idTipoCasoBienestar;
    }

    public TipoCasoBienestar(Integer idTipoCasoBienestar, String descrTipoBienestar) {
        this.idTipoCasoBienestar = idTipoCasoBienestar;
        this.descrTipoBienestar = descrTipoBienestar;
    }

    public Integer getIdTipoCasoBienestar() {
        return idTipoCasoBienestar;
    }

    public void setIdTipoCasoBienestar(Integer idTipoCasoBienestar) {
        this.idTipoCasoBienestar = idTipoCasoBienestar;
    }

    public String getDescrTipoBienestar() {
        return descrTipoBienestar;
    }

    public void setDescrTipoBienestar(String descrTipoBienestar) {
        this.descrTipoBienestar = descrTipoBienestar;
    }

    @XmlTransient
    public List<Remision> getRemisionList() {
        return remisionList;
    }

    public void setRemisionList(List<Remision> remisionList) {
        this.remisionList = remisionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCasoBienestar != null ? idTipoCasoBienestar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCasoBienestar)) {
            return false;
        }
        TipoCasoBienestar other = (TipoCasoBienestar) object;
        if ((this.idTipoCasoBienestar == null && other.idTipoCasoBienestar != null) || (this.idTipoCasoBienestar != null && !this.idTipoCasoBienestar.equals(other.idTipoCasoBienestar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TipoCasoBienestar[ idTipoCasoBienestar=" + idTipoCasoBienestar + " ]";
    }
    
}
