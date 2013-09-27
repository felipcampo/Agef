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
@Table(name = "situacion_militar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SituacionMilitar.findAll", query = "SELECT s FROM SituacionMilitar s"),
    @NamedQuery(name = "SituacionMilitar.findByIdSituacionMilitar", query = "SELECT s FROM SituacionMilitar s WHERE s.idSituacionMilitar = :idSituacionMilitar"),
    @NamedQuery(name = "SituacionMilitar.findByDescrSituacionMilitar", query = "SELECT s FROM SituacionMilitar s WHERE s.descrSituacionMilitar = :descrSituacionMilitar")})
public class SituacionMilitar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_situacion_militar")
    private Short idSituacionMilitar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descr_situacion_militar")
    private String descrSituacionMilitar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSituacionMilitar")
    private List<Usuario> usuarioList;

    public SituacionMilitar() {
    }

    public SituacionMilitar(Short idSituacionMilitar) {
        this.idSituacionMilitar = idSituacionMilitar;
    }

    public SituacionMilitar(Short idSituacionMilitar, String descrSituacionMilitar) {
        this.idSituacionMilitar = idSituacionMilitar;
        this.descrSituacionMilitar = descrSituacionMilitar;
    }

    public Short getIdSituacionMilitar() {
        return idSituacionMilitar;
    }

    public void setIdSituacionMilitar(Short idSituacionMilitar) {
        this.idSituacionMilitar = idSituacionMilitar;
    }

    public String getDescrSituacionMilitar() {
        return descrSituacionMilitar;
    }

    public void setDescrSituacionMilitar(String descrSituacionMilitar) {
        this.descrSituacionMilitar = descrSituacionMilitar;
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
        hash += (idSituacionMilitar != null ? idSituacionMilitar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SituacionMilitar)) {
            return false;
        }
        SituacionMilitar other = (SituacionMilitar) object;
        if ((this.idSituacionMilitar == null && other.idSituacionMilitar != null) || (this.idSituacionMilitar != null && !this.idSituacionMilitar.equals(other.idSituacionMilitar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.SituacionMilitar[ idSituacionMilitar=" + idSituacionMilitar + " ]";
    }
    
}
