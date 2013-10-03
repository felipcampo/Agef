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
@Table(name = "sisben")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sisben.findAll", query = "SELECT s FROM Sisben s"),
    @NamedQuery(name = "Sisben.findByIdSisben", query = "SELECT s FROM Sisben s WHERE s.idSisben = :idSisben"),
    @NamedQuery(name = "Sisben.findByDescrSisben", query = "SELECT s FROM Sisben s WHERE s.descrSisben = :descrSisben")})
public class Sisben implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sisben")
    private Short idSisben;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "descr_sisben")
    private String descrSisben;
    @OneToMany(mappedBy = "idSisben")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public Sisben() {
    }

    public Sisben(Short idSisben) {
        this.idSisben = idSisben;
    }

    public Sisben(Short idSisben, String descrSisben) {
        this.idSisben = idSisben;
        this.descrSisben = descrSisben;
    }

    public Short getIdSisben() {
        return idSisben;
    }

    public void setIdSisben(Short idSisben) {
        this.idSisben = idSisben;
    }

    public String getDescrSisben() {
        return descrSisben;
    }

    public void setDescrSisben(String descrSisben) {
        this.descrSisben = descrSisben;
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
        hash += (idSisben != null ? idSisben.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sisben)) {
            return false;
        }
        Sisben other = (Sisben) object;
        if ((this.idSisben == null && other.idSisben != null) || (this.idSisben != null && !this.idSisben.equals(other.idSisben))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Sisben[ idSisben=" + idSisben + " ]";
    }
    
}
