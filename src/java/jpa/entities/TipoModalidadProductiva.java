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
@Table(name = "tipo_modalidad_productiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoModalidadProductiva.findAll", query = "SELECT t FROM TipoModalidadProductiva t"),
    @NamedQuery(name = "TipoModalidadProductiva.findByIdTipoModalidadProductiva", query = "SELECT t FROM TipoModalidadProductiva t WHERE t.idTipoModalidadProductiva = :idTipoModalidadProductiva"),
    @NamedQuery(name = "TipoModalidadProductiva.findByDescrNomTdm", query = "SELECT t FROM TipoModalidadProductiva t WHERE t.descrNomTdm = :descrNomTdm")})
public class TipoModalidadProductiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_modalidad_productiva")
    private Integer idTipoModalidadProductiva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descr_nom_tdm")
    private String descrNomTdm;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoModalidadProductiva")
    private List<ModalidadProductiva> modalidadProductivaList;

    public TipoModalidadProductiva() {
    }

    public TipoModalidadProductiva(Integer idTipoModalidadProductiva) {
        this.idTipoModalidadProductiva = idTipoModalidadProductiva;
    }

    public TipoModalidadProductiva(Integer idTipoModalidadProductiva, String descrNomTdm) {
        this.idTipoModalidadProductiva = idTipoModalidadProductiva;
        this.descrNomTdm = descrNomTdm;
    }

    public Integer getIdTipoModalidadProductiva() {
        return idTipoModalidadProductiva;
    }

    public void setIdTipoModalidadProductiva(Integer idTipoModalidadProductiva) {
        this.idTipoModalidadProductiva = idTipoModalidadProductiva;
    }

    public String getDescrNomTdm() {
        return descrNomTdm;
    }

    public void setDescrNomTdm(String descrNomTdm) {
        this.descrNomTdm = descrNomTdm;
    }

    @XmlTransient
    public List<ModalidadProductiva> getModalidadProductivaList() {
        return modalidadProductivaList;
    }

    public void setModalidadProductivaList(List<ModalidadProductiva> modalidadProductivaList) {
        this.modalidadProductivaList = modalidadProductivaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoModalidadProductiva != null ? idTipoModalidadProductiva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoModalidadProductiva)) {
            return false;
        }
        TipoModalidadProductiva other = (TipoModalidadProductiva) object;
        if ((this.idTipoModalidadProductiva == null && other.idTipoModalidadProductiva != null) || (this.idTipoModalidadProductiva != null && !this.idTipoModalidadProductiva.equals(other.idTipoModalidadProductiva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TipoModalidadProductiva[ idTipoModalidadProductiva=" + idTipoModalidadProductiva + " ]";
    }
    
}
