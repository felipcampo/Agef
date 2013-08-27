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
@Table(name = "tipo_oferta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoOferta.findAll", query = "SELECT t FROM TipoOferta t"),
    @NamedQuery(name = "TipoOferta.findByIdTipoOferta", query = "SELECT t FROM TipoOferta t WHERE t.idTipoOferta = :idTipoOferta"),
    @NamedQuery(name = "TipoOferta.findByDescrTipOfe", query = "SELECT t FROM TipoOferta t WHERE t.descrTipOfe = :descrTipOfe")})
public class TipoOferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_oferta")
    private Integer idTipoOferta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descr_tip_ofe")
    private String descrTipOfe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoOferta")
    private List<FichaCaracterizacion> fichaCaracterizacionList;

    public TipoOferta() {
    }

    public TipoOferta(Integer idTipoOferta) {
        this.idTipoOferta = idTipoOferta;
    }

    public TipoOferta(Integer idTipoOferta, String descrTipOfe) {
        this.idTipoOferta = idTipoOferta;
        this.descrTipOfe = descrTipOfe;
    }

    public Integer getIdTipoOferta() {
        return idTipoOferta;
    }

    public void setIdTipoOferta(Integer idTipoOferta) {
        this.idTipoOferta = idTipoOferta;
    }

    public String getDescrTipOfe() {
        return descrTipOfe;
    }

    public void setDescrTipOfe(String descrTipOfe) {
        this.descrTipOfe = descrTipOfe;
    }

    @XmlTransient
    public List<FichaCaracterizacion> getFichaCaracterizacionList() {
        return fichaCaracterizacionList;
    }

    public void setFichaCaracterizacionList(List<FichaCaracterizacion> fichaCaracterizacionList) {
        this.fichaCaracterizacionList = fichaCaracterizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoOferta != null ? idTipoOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoOferta)) {
            return false;
        }
        TipoOferta other = (TipoOferta) object;
        if ((this.idTipoOferta == null && other.idTipoOferta != null) || (this.idTipoOferta != null && !this.idTipoOferta.equals(other.idTipoOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TipoOferta[ idTipoOferta=" + idTipoOferta + " ]";
    }
    
}
