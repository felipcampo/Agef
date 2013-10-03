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
 * @author ADSI
 */
@Entity
@Table(name = "tipo_vivienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoVivienda.findAll", query = "SELECT t FROM TipoVivienda t"),
    @NamedQuery(name = "TipoVivienda.findByIdTipoVivienda", query = "SELECT t FROM TipoVivienda t WHERE t.idTipoVivienda = :idTipoVivienda"),
    @NamedQuery(name = "TipoVivienda.findByDescrTipVivi", query = "SELECT t FROM TipoVivienda t WHERE t.descrTipVivi = :descrTipVivi")})
public class TipoVivienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_vivienda")
    private Short idTipoVivienda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "descr_tip_vivi")
    private String descrTipVivi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoVivienda")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public TipoVivienda() {
    }

    public TipoVivienda(Short idTipoVivienda) {
        this.idTipoVivienda = idTipoVivienda;
    }

    public TipoVivienda(Short idTipoVivienda, String descrTipVivi) {
        this.idTipoVivienda = idTipoVivienda;
        this.descrTipVivi = descrTipVivi;
    }

    public Short getIdTipoVivienda() {
        return idTipoVivienda;
    }

    public void setIdTipoVivienda(Short idTipoVivienda) {
        this.idTipoVivienda = idTipoVivienda;
    }

    public String getDescrTipVivi() {
        return descrTipVivi;
    }

    public void setDescrTipVivi(String descrTipVivi) {
        this.descrTipVivi = descrTipVivi;
    }

    @XmlTransient
    public List<MatrizCaracterizacion> getMatrizCaracterizacionList() {
        return matrizCaracterizacionList;
    }

    public void setMatrizCaracterizacionList(List<MatrizCaracterizacion> matrizCaracterizacionList) {
        this.matrizCaracterizacionList = matrizCaracterizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoVivienda != null ? idTipoVivienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoVivienda)) {
            return false;
        }
        TipoVivienda other = (TipoVivienda) object;
        if ((this.idTipoVivienda == null && other.idTipoVivienda != null) || (this.idTipoVivienda != null && !this.idTipoVivienda.equals(other.idTipoVivienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TipoVivienda[ idTipoVivienda=" + idTipoVivienda + " ]";
    }
    
}
