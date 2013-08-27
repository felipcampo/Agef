/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leoandresm
 */
@Entity
@Table(name = "caso_bienestar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasoBienestar.findAll", query = "SELECT c FROM CasoBienestar c"),
    @NamedQuery(name = "CasoBienestar.findByIdCasoBienestar", query = "SELECT c FROM CasoBienestar c WHERE c.idCasoBienestar = :idCasoBienestar"),
    @NamedQuery(name = "CasoBienestar.findByFecFinCas", query = "SELECT c FROM CasoBienestar c WHERE c.fecFinCas = :fecFinCas"),
    @NamedQuery(name = "CasoBienestar.findByFecIniCas", query = "SELECT c FROM CasoBienestar c WHERE c.fecIniCas = :fecIniCas")})
public class CasoBienestar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_caso_bienestar")
    private Integer idCasoBienestar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_fin_cas")
    @Temporal(TemporalType.DATE)
    private Date fecFinCas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_ini_cas")
    @Temporal(TemporalType.DATE)
    private Date fecIniCas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCasoBienestar")
    private List<ControlCasoBieAprendiz> controlCasoBieAprendizList;
    @JoinColumn(name = "id_remision", referencedColumnName = "id_remision")
    @ManyToOne(optional = false)
    private Remision idRemision;
    @JoinColumn(name = "id_estado_caso_bienestar", referencedColumnName = "id_estado_caso_bienestar")
    @ManyToOne(optional = false)
    private EstadoCasoBienestar idEstadoCasoBienestar;

    public CasoBienestar() {
    }

    public CasoBienestar(Integer idCasoBienestar) {
        this.idCasoBienestar = idCasoBienestar;
    }

    public CasoBienestar(Integer idCasoBienestar, Date fecFinCas, Date fecIniCas) {
        this.idCasoBienestar = idCasoBienestar;
        this.fecFinCas = fecFinCas;
        this.fecIniCas = fecIniCas;
    }

    public Integer getIdCasoBienestar() {
        return idCasoBienestar;
    }

    public void setIdCasoBienestar(Integer idCasoBienestar) {
        this.idCasoBienestar = idCasoBienestar;
    }

    public Date getFecFinCas() {
        return fecFinCas;
    }

    public void setFecFinCas(Date fecFinCas) {
        this.fecFinCas = fecFinCas;
    }

    public Date getFecIniCas() {
        return fecIniCas;
    }

    public void setFecIniCas(Date fecIniCas) {
        this.fecIniCas = fecIniCas;
    }

    @XmlTransient
    public List<ControlCasoBieAprendiz> getControlCasoBieAprendizList() {
        return controlCasoBieAprendizList;
    }

    public void setControlCasoBieAprendizList(List<ControlCasoBieAprendiz> controlCasoBieAprendizList) {
        this.controlCasoBieAprendizList = controlCasoBieAprendizList;
    }

    public Remision getIdRemision() {
        return idRemision;
    }

    public void setIdRemision(Remision idRemision) {
        this.idRemision = idRemision;
    }

    public EstadoCasoBienestar getIdEstadoCasoBienestar() {
        return idEstadoCasoBienestar;
    }

    public void setIdEstadoCasoBienestar(EstadoCasoBienestar idEstadoCasoBienestar) {
        this.idEstadoCasoBienestar = idEstadoCasoBienestar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCasoBienestar != null ? idCasoBienestar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasoBienestar)) {
            return false;
        }
        CasoBienestar other = (CasoBienestar) object;
        if ((this.idCasoBienestar == null && other.idCasoBienestar != null) || (this.idCasoBienestar != null && !this.idCasoBienestar.equals(other.idCasoBienestar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.CasoBienestar[ idCasoBienestar=" + idCasoBienestar + " ]";
    }
    
}
