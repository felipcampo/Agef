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
@Table(name = "sancion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sancion.findAll", query = "SELECT s FROM Sancion s"),
    @NamedQuery(name = "Sancion.findByIdSancion", query = "SELECT s FROM Sancion s WHERE s.idSancion = :idSancion"),
    @NamedQuery(name = "Sancion.findByDescrSancion", query = "SELECT s FROM Sancion s WHERE s.descrSancion = :descrSancion")})
public class Sancion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sancion")
    private Short idSancion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descr_sancion")
    private String descrSancion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSancion")
    private List<Falta> faltaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSancion")
    private List<Comite> comiteList;

    public Sancion() {
    }

    public Sancion(Short idSancion) {
        this.idSancion = idSancion;
    }

    public Sancion(Short idSancion, String descrSancion) {
        this.idSancion = idSancion;
        this.descrSancion = descrSancion;
    }

    public Short getIdSancion() {
        return idSancion;
    }

    public void setIdSancion(Short idSancion) {
        this.idSancion = idSancion;
    }

    public String getDescrSancion() {
        return descrSancion;
    }

    public void setDescrSancion(String descrSancion) {
        this.descrSancion = descrSancion;
    }

    @XmlTransient
    public List<Falta> getFaltaList() {
        return faltaList;
    }

    public void setFaltaList(List<Falta> faltaList) {
        this.faltaList = faltaList;
    }

    @XmlTransient
    public List<Comite> getComiteList() {
        return comiteList;
    }

    public void setComiteList(List<Comite> comiteList) {
        this.comiteList = comiteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSancion != null ? idSancion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sancion)) {
            return false;
        }
        Sancion other = (Sancion) object;
        if ((this.idSancion == null && other.idSancion != null) || (this.idSancion != null && !this.idSancion.equals(other.idSancion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Sancion[ idSancion=" + idSancion + " ]";
    }
    
}
