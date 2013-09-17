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
@Table(name = "tipo_contrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoContrato.findAll", query = "SELECT t FROM TipoContrato t"),
    @NamedQuery(name = "TipoContrato.findByIdTipoContrato", query = "SELECT t FROM TipoContrato t WHERE t.idTipoContrato = :idTipoContrato"),
    @NamedQuery(name = "TipoContrato.findByDescrTipoContrato", query = "SELECT t FROM TipoContrato t WHERE t.descrTipoContrato = :descrTipoContrato")})
public class TipoContrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_contrato")
    private Short idTipoContrato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descr_tipo_contrato")
    private String descrTipoContrato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoContrato")
    private List<Usuario> usuarioList;

    public TipoContrato() {
    }

    public TipoContrato(Short idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public TipoContrato(Short idTipoContrato, String descrTipoContrato) {
        this.idTipoContrato = idTipoContrato;
        this.descrTipoContrato = descrTipoContrato;
    }

    public Short getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(Short idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public String getDescrTipoContrato() {
        return descrTipoContrato;
    }

    public void setDescrTipoContrato(String descrTipoContrato) {
        this.descrTipoContrato = descrTipoContrato;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoContrato != null ? idTipoContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoContrato)) {
            return false;
        }
        TipoContrato other = (TipoContrato) object;
        if ((this.idTipoContrato == null && other.idTipoContrato != null) || (this.idTipoContrato != null && !this.idTipoContrato.equals(other.idTipoContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TipoContrato[ idTipoContrato=" + idTipoContrato + " ]";
    }
    
}
