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
@Table(name = "dependencia_economica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DependenciaEconomica.findAll", query = "SELECT d FROM DependenciaEconomica d"),
    @NamedQuery(name = "DependenciaEconomica.findByIdDependenciaEconomica", query = "SELECT d FROM DependenciaEconomica d WHERE d.idDependenciaEconomica = :idDependenciaEconomica"),
    @NamedQuery(name = "DependenciaEconomica.findByDescrDependenciaEconomica", query = "SELECT d FROM DependenciaEconomica d WHERE d.descrDependenciaEconomica = :descrDependenciaEconomica")})
public class DependenciaEconomica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dependencia_economica")
    private Short idDependenciaEconomica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descr_dependencia_economica")
    private String descrDependenciaEconomica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDependenciaEconomica")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public DependenciaEconomica() {
    }

    public DependenciaEconomica(Short idDependenciaEconomica) {
        this.idDependenciaEconomica = idDependenciaEconomica;
    }

    public DependenciaEconomica(Short idDependenciaEconomica, String descrDependenciaEconomica) {
        this.idDependenciaEconomica = idDependenciaEconomica;
        this.descrDependenciaEconomica = descrDependenciaEconomica;
    }

    public Short getIdDependenciaEconomica() {
        return idDependenciaEconomica;
    }

    public void setIdDependenciaEconomica(Short idDependenciaEconomica) {
        this.idDependenciaEconomica = idDependenciaEconomica;
    }

    public String getDescrDependenciaEconomica() {
        return descrDependenciaEconomica;
    }

    public void setDescrDependenciaEconomica(String descrDependenciaEconomica) {
        this.descrDependenciaEconomica = descrDependenciaEconomica;
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
        hash += (idDependenciaEconomica != null ? idDependenciaEconomica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DependenciaEconomica)) {
            return false;
        }
        DependenciaEconomica other = (DependenciaEconomica) object;
        if ((this.idDependenciaEconomica == null && other.idDependenciaEconomica != null) || (this.idDependenciaEconomica != null && !this.idDependenciaEconomica.equals(other.idDependenciaEconomica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.DependenciaEconomica[ idDependenciaEconomica=" + idDependenciaEconomica + " ]";
    }
    
}
