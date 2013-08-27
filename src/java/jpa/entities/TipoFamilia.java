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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "tipo_familia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoFamilia.findAll", query = "SELECT t FROM TipoFamilia t"),
    @NamedQuery(name = "TipoFamilia.findByIdTipoFamilia", query = "SELECT t FROM TipoFamilia t WHERE t.idTipoFamilia = :idTipoFamilia"),
    @NamedQuery(name = "TipoFamilia.findByDescrTipFam", query = "SELECT t FROM TipoFamilia t WHERE t.descrTipFam = :descrTipFam")})
public class TipoFamilia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_familia")
    private Integer idTipoFamilia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descr_tip_fam")
    private String descrTipFam;
    @JoinTable(name = "tipo_familia_matriz", joinColumns = {
        @JoinColumn(name = "id_tipo_familia", referencedColumnName = "id_tipo_familia")}, inverseJoinColumns = {
        @JoinColumn(name = "id_matriz_caracterizacion", referencedColumnName = "id_matriz_caracterizacion")})
    @ManyToMany
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public TipoFamilia() {
    }

    public TipoFamilia(Integer idTipoFamilia) {
        this.idTipoFamilia = idTipoFamilia;
    }

    public TipoFamilia(Integer idTipoFamilia, String descrTipFam) {
        this.idTipoFamilia = idTipoFamilia;
        this.descrTipFam = descrTipFam;
    }

    public Integer getIdTipoFamilia() {
        return idTipoFamilia;
    }

    public void setIdTipoFamilia(Integer idTipoFamilia) {
        this.idTipoFamilia = idTipoFamilia;
    }

    public String getDescrTipFam() {
        return descrTipFam;
    }

    public void setDescrTipFam(String descrTipFam) {
        this.descrTipFam = descrTipFam;
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
        hash += (idTipoFamilia != null ? idTipoFamilia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoFamilia)) {
            return false;
        }
        TipoFamilia other = (TipoFamilia) object;
        if ((this.idTipoFamilia == null && other.idTipoFamilia != null) || (this.idTipoFamilia != null && !this.idTipoFamilia.equals(other.idTipoFamilia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TipoFamilia[ idTipoFamilia=" + idTipoFamilia + " ]";
    }
    
}
