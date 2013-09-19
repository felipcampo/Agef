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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADSI
 */
@Entity
@Table(name = "concertacion_plan_trabajo_productiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConcertacionPlanTrabajoProductiva.findAll", query = "SELECT c FROM ConcertacionPlanTrabajoProductiva c"),
    @NamedQuery(name = "ConcertacionPlanTrabajoProductiva.findByIdConcertacionPlanTrabajoProductiva", query = "SELECT c FROM ConcertacionPlanTrabajoProductiva c WHERE c.idConcertacionPlanTrabajoProductiva = :idConcertacionPlanTrabajoProductiva"),
    @NamedQuery(name = "ConcertacionPlanTrabajoProductiva.findByFecCpt", query = "SELECT c FROM ConcertacionPlanTrabajoProductiva c WHERE c.fecCpt = :fecCpt"),
    @NamedQuery(name = "ConcertacionPlanTrabajoProductiva.findByLugCpt", query = "SELECT c FROM ConcertacionPlanTrabajoProductiva c WHERE c.lugCpt = :lugCpt")})
public class ConcertacionPlanTrabajoProductiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_concertacion_plan_trabajo_productiva")
    private Integer idConcertacionPlanTrabajoProductiva;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "act_des")
    private String actDes;
    @Basic(optional = false)

    @Lob
    @Column(name = "evi_apr")
    private byte[] eviApr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_cpt")
    @Temporal(TemporalType.DATE)
    private Date fecCpt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "lug_cpt")
    private String lugCpt;
    @Lob
    @Size(max = 65535)
    @Column(name = "obs_cpt")
    private String obsCpt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConcertacionPlanTrabajoProductiva")
    private List<SeguimientoProductiva> seguimientoProductivaList;

    public ConcertacionPlanTrabajoProductiva() {
    }

    public ConcertacionPlanTrabajoProductiva(Integer idConcertacionPlanTrabajoProductiva) {
        this.idConcertacionPlanTrabajoProductiva = idConcertacionPlanTrabajoProductiva;
    }

    public ConcertacionPlanTrabajoProductiva(Integer idConcertacionPlanTrabajoProductiva, String actDes, byte[] eviApr, Date fecCpt, String lugCpt) {
        this.idConcertacionPlanTrabajoProductiva = idConcertacionPlanTrabajoProductiva;
        this.actDes = actDes;
        this.eviApr = eviApr;
        this.fecCpt = fecCpt;
        this.lugCpt = lugCpt;
    }

    public Integer getIdConcertacionPlanTrabajoProductiva() {
        return idConcertacionPlanTrabajoProductiva;
    }

    public void setIdConcertacionPlanTrabajoProductiva(Integer idConcertacionPlanTrabajoProductiva) {
        this.idConcertacionPlanTrabajoProductiva = idConcertacionPlanTrabajoProductiva;
    }

    public String getActDes() {
        return actDes;
    }

    public void setActDes(String actDes) {
        this.actDes = actDes;
    }

    public byte[] getEviApr() {
        return eviApr;
    }

    public void setEviApr(byte[] eviApr) {
        this.eviApr = eviApr;
    }

    public Date getFecCpt() {
        return fecCpt;
    }

    public void setFecCpt(Date fecCpt) {
        this.fecCpt = fecCpt;
    }

    public String getLugCpt() {
        return lugCpt;
    }

    public void setLugCpt(String lugCpt) {
        this.lugCpt = lugCpt;
    }

    public String getObsCpt() {
        return obsCpt;
    }

    public void setObsCpt(String obsCpt) {
        this.obsCpt = obsCpt;
    }

    @XmlTransient
    public List<SeguimientoProductiva> getSeguimientoProductivaList() {
        return seguimientoProductivaList;
    }

    public void setSeguimientoProductivaList(List<SeguimientoProductiva> seguimientoProductivaList) {
        this.seguimientoProductivaList = seguimientoProductivaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConcertacionPlanTrabajoProductiva != null ? idConcertacionPlanTrabajoProductiva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConcertacionPlanTrabajoProductiva)) {
            return false;
        }
        ConcertacionPlanTrabajoProductiva other = (ConcertacionPlanTrabajoProductiva) object;
        if ((this.idConcertacionPlanTrabajoProductiva == null && other.idConcertacionPlanTrabajoProductiva != null) || (this.idConcertacionPlanTrabajoProductiva != null && !this.idConcertacionPlanTrabajoProductiva.equals(other.idConcertacionPlanTrabajoProductiva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ConcertacionPlanTrabajoProductiva[ idConcertacionPlanTrabajoProductiva=" + idConcertacionPlanTrabajoProductiva + " ]";
    }
    
}
