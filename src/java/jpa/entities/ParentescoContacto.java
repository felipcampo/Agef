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
@Table(name = "parentesco_contacto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParentescoContacto.findAll", query = "SELECT p FROM ParentescoContacto p"),
    @NamedQuery(name = "ParentescoContacto.findByIdParentescoContacto", query = "SELECT p FROM ParentescoContacto p WHERE p.idParentescoContacto = :idParentescoContacto"),
    @NamedQuery(name = "ParentescoContacto.findByDescrParentescoContacto", query = "SELECT p FROM ParentescoContacto p WHERE p.descrParentescoContacto = :descrParentescoContacto")})
public class ParentescoContacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parentesco_contacto")
    private Short idParentescoContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descr_parentesco_contacto")
    private String descrParentescoContacto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idParentescoContacto")
    private List<ContactoEmergencia> contactoEmergenciaList;

    public ParentescoContacto() {
    }

    public ParentescoContacto(Short idParentescoContacto) {
        this.idParentescoContacto = idParentescoContacto;
    }

    public ParentescoContacto(Short idParentescoContacto, String descrParentescoContacto) {
        this.idParentescoContacto = idParentescoContacto;
        this.descrParentescoContacto = descrParentescoContacto;
    }

    public Short getIdParentescoContacto() {
        return idParentescoContacto;
    }

    public void setIdParentescoContacto(Short idParentescoContacto) {
        this.idParentescoContacto = idParentescoContacto;
    }

    public String getDescrParentescoContacto() {
        return descrParentescoContacto;
    }

    public void setDescrParentescoContacto(String descrParentescoContacto) {
        this.descrParentescoContacto = descrParentescoContacto;
    }

    @XmlTransient
    public List<ContactoEmergencia> getContactoEmergenciaList() {
        return contactoEmergenciaList;
    }

    public void setContactoEmergenciaList(List<ContactoEmergencia> contactoEmergenciaList) {
        this.contactoEmergenciaList = contactoEmergenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParentescoContacto != null ? idParentescoContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParentescoContacto)) {
            return false;
        }
        ParentescoContacto other = (ParentescoContacto) object;
        if ((this.idParentescoContacto == null && other.idParentescoContacto != null) || (this.idParentescoContacto != null && !this.idParentescoContacto.equals(other.idParentescoContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ParentescoContacto[ idParentescoContacto=" + idParentescoContacto + " ]";
    }
    
}
