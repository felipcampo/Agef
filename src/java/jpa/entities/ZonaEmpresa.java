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
@Table(name = "zona_empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZonaEmpresa.findAll", query = "SELECT z FROM ZonaEmpresa z"),
    @NamedQuery(name = "ZonaEmpresa.findByIdZonaEmpresa", query = "SELECT z FROM ZonaEmpresa z WHERE z.idZonaEmpresa = :idZonaEmpresa"),
    @NamedQuery(name = "ZonaEmpresa.findByDescrZona", query = "SELECT z FROM ZonaEmpresa z WHERE z.descrZona = :descrZona")})
public class ZonaEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_zona_empresa")
    private Short idZonaEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descr_zona")
    private String descrZona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idZonaEmpresa")
    private List<Empresa> empresaList;

    public ZonaEmpresa() {
    }

    public ZonaEmpresa(Short idZonaEmpresa) {
        this.idZonaEmpresa = idZonaEmpresa;
    }

    public ZonaEmpresa(Short idZonaEmpresa, String descrZona) {
        this.idZonaEmpresa = idZonaEmpresa;
        this.descrZona = descrZona;
    }

    public Short getIdZonaEmpresa() {
        return idZonaEmpresa;
    }

    public void setIdZonaEmpresa(Short idZonaEmpresa) {
        this.idZonaEmpresa = idZonaEmpresa;
    }

    public String getDescrZona() {
        return descrZona;
    }

    public void setDescrZona(String descrZona) {
        this.descrZona = descrZona;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZonaEmpresa != null ? idZonaEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZonaEmpresa)) {
            return false;
        }
        ZonaEmpresa other = (ZonaEmpresa) object;
        if ((this.idZonaEmpresa == null && other.idZonaEmpresa != null) || (this.idZonaEmpresa != null && !this.idZonaEmpresa.equals(other.idZonaEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descrZona;
    }
    
}
