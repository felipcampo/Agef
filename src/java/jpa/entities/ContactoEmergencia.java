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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "contacto_emergencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactoEmergencia.findAll", query = "SELECT c FROM ContactoEmergencia c"),
    @NamedQuery(name = "ContactoEmergencia.findByIdContactoEmergencia", query = "SELECT c FROM ContactoEmergencia c WHERE c.idContactoEmergencia = :idContactoEmergencia"),
    @NamedQuery(name = "ContactoEmergencia.findByDescrApellidoContacto", query = "SELECT c FROM ContactoEmergencia c WHERE c.descrApellidoContacto = :descrApellidoContacto"),
    @NamedQuery(name = "ContactoEmergencia.findByDescrNombreContacto", query = "SELECT c FROM ContactoEmergencia c WHERE c.descrNombreContacto = :descrNombreContacto"),
    @NamedQuery(name = "ContactoEmergencia.findByTelefonoContacto", query = "SELECT c FROM ContactoEmergencia c WHERE c.telefonoContacto = :telefonoContacto"),
    @NamedQuery(name = "ContactoEmergencia.findByCorreoContacto", query = "SELECT c FROM ContactoEmergencia c WHERE c.correoContacto = :correoContacto")})
public class ContactoEmergencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_contacto_emergencia")
    private Integer idContactoEmergencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descr_apellido_contacto")
    private String descrApellidoContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descr_nombre_contacto")
    private String descrNombreContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "telefono_contacto")
    private String telefonoContacto;
    @Size(max = 45)
    @Column(name = "correo_contacto")
    private String correoContacto;
    @JoinColumn(name = "id_parentesco_contacto", referencedColumnName = "id_parentesco_contacto")
    @ManyToOne(optional = false)
    private ParentescoContacto idParentescoContacto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContactoEmergencia")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public ContactoEmergencia() {
    }

    public ContactoEmergencia(Integer idContactoEmergencia) {
        this.idContactoEmergencia = idContactoEmergencia;
    }

    public ContactoEmergencia(Integer idContactoEmergencia, String descrApellidoContacto, String descrNombreContacto, String telefonoContacto) {
        this.idContactoEmergencia = idContactoEmergencia;
        this.descrApellidoContacto = descrApellidoContacto;
        this.descrNombreContacto = descrNombreContacto;
        this.telefonoContacto = telefonoContacto;
    }

    public Integer getIdContactoEmergencia() {
        return idContactoEmergencia;
    }

    public void setIdContactoEmergencia(Integer idContactoEmergencia) {
        this.idContactoEmergencia = idContactoEmergencia;
    }

    public String getDescrApellidoContacto() {
        return descrApellidoContacto;
    }

    public void setDescrApellidoContacto(String descrApellidoContacto) {
        this.descrApellidoContacto = descrApellidoContacto;
    }

    public String getDescrNombreContacto() {
        return descrNombreContacto;
    }

    public void setDescrNombreContacto(String descrNombreContacto) {
        this.descrNombreContacto = descrNombreContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getCorreoContacto() {
        return correoContacto;
    }

    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }

    public ParentescoContacto getIdParentescoContacto() {
        return idParentescoContacto;
    }

    public void setIdParentescoContacto(ParentescoContacto idParentescoContacto) {
        this.idParentescoContacto = idParentescoContacto;
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
        hash += (idContactoEmergencia != null ? idContactoEmergencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactoEmergencia)) {
            return false;
        }
        ContactoEmergencia other = (ContactoEmergencia) object;
        if ((this.idContactoEmergencia == null && other.idContactoEmergencia != null) || (this.idContactoEmergencia != null && !this.idContactoEmergencia.equals(other.idContactoEmergencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ContactoEmergencia[ idContactoEmergencia=" + idContactoEmergencia + " ]";
    }
    
}
