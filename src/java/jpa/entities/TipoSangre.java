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
@Table(name = "tipo_sangre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoSangre.findAll", query = "SELECT t FROM TipoSangre t"),
    @NamedQuery(name = "TipoSangre.findByIdTipoSangre", query = "SELECT t FROM TipoSangre t WHERE t.idTipoSangre = :idTipoSangre"),
    @NamedQuery(name = "TipoSangre.findByDescrTipoSangre", query = "SELECT t FROM TipoSangre t WHERE t.descrTipoSangre = :descrTipoSangre")})
public class TipoSangre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_sangre")
    private Short idTipoSangre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "descr_tipo_sangre")
    private String descrTipoSangre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoSangre")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public TipoSangre() {
    }

    public TipoSangre(Short idTipoSangre) {
        this.idTipoSangre = idTipoSangre;
    }

    public TipoSangre(Short idTipoSangre, String descrTipoSangre) {
        this.idTipoSangre = idTipoSangre;
        this.descrTipoSangre = descrTipoSangre;
    }

    public Short getIdTipoSangre() {
        return idTipoSangre;
    }

    public void setIdTipoSangre(Short idTipoSangre) {
        this.idTipoSangre = idTipoSangre;
    }

    public String getDescrTipoSangre() {
        return descrTipoSangre;
    }

    public void setDescrTipoSangre(String descrTipoSangre) {
        this.descrTipoSangre = descrTipoSangre;
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
        hash += (idTipoSangre != null ? idTipoSangre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSangre)) {
            return false;
        }
        TipoSangre other = (TipoSangre) object;
        if ((this.idTipoSangre == null && other.idTipoSangre != null) || (this.idTipoSangre != null && !this.idTipoSangre.equals(other.idTipoSangre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TipoSangre[ idTipoSangre=" + idTipoSangre + " ]";
    }
    
}
