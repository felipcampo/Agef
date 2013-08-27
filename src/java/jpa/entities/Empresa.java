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
 * @author leoandresm
 */
@Entity
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByIdEmpresa", query = "SELECT e FROM Empresa e WHERE e.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Empresa.findByDirEmp", query = "SELECT e FROM Empresa e WHERE e.dirEmp = :dirEmp"),
    @NamedQuery(name = "Empresa.findByEmailEmpresa", query = "SELECT e FROM Empresa e WHERE e.emailEmpresa = :emailEmpresa"),
    @NamedQuery(name = "Empresa.findByRazonSocialEmpresa", query = "SELECT e FROM Empresa e WHERE e.razonSocialEmpresa = :razonSocialEmpresa"),
    @NamedQuery(name = "Empresa.findByTel1Emp", query = "SELECT e FROM Empresa e WHERE e.tel1Emp = :tel1Emp"),
    @NamedQuery(name = "Empresa.findByTel2Emp", query = "SELECT e FROM Empresa e WHERE e.tel2Emp = :tel2Emp"),
    @NamedQuery(name = "Empresa.findByWwwEmp", query = "SELECT e FROM Empresa e WHERE e.wwwEmp = :wwwEmp")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "dir_emp")
    private String dirEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email_empresa")
    private String emailEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "razon_social_empresa")
    private String razonSocialEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tel1_emp")
    private int tel1Emp;
    @Column(name = "tel2_emp")
    private Integer tel2Emp;
    @Size(max = 255)
    @Column(name = "www_emp")
    private String wwwEmp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private List<ContratoProyecto> contratoProyectoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private List<PlanMejoramiento> planMejoramientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private List<SeguimientoProductiva> seguimientoProductivaList;
    @JoinColumn(name = "id_zona_empresa", referencedColumnName = "id_zona_empresa")
    @ManyToOne(optional = false)
    private ZonaEmpresa idZonaEmpresa;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa(Integer idEmpresa, String dirEmp, String emailEmpresa, String razonSocialEmpresa, int tel1Emp) {
        this.idEmpresa = idEmpresa;
        this.dirEmp = dirEmp;
        this.emailEmpresa = emailEmpresa;
        this.razonSocialEmpresa = razonSocialEmpresa;
        this.tel1Emp = tel1Emp;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getDirEmp() {
        return dirEmp;
    }

    public void setDirEmp(String dirEmp) {
        this.dirEmp = dirEmp;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public String getRazonSocialEmpresa() {
        return razonSocialEmpresa;
    }

    public void setRazonSocialEmpresa(String razonSocialEmpresa) {
        this.razonSocialEmpresa = razonSocialEmpresa;
    }

    public int getTel1Emp() {
        return tel1Emp;
    }

    public void setTel1Emp(int tel1Emp) {
        this.tel1Emp = tel1Emp;
    }

    public Integer getTel2Emp() {
        return tel2Emp;
    }

    public void setTel2Emp(Integer tel2Emp) {
        this.tel2Emp = tel2Emp;
    }

    public String getWwwEmp() {
        return wwwEmp;
    }

    public void setWwwEmp(String wwwEmp) {
        this.wwwEmp = wwwEmp;
    }

    @XmlTransient
    public List<ContratoProyecto> getContratoProyectoList() {
        return contratoProyectoList;
    }

    public void setContratoProyectoList(List<ContratoProyecto> contratoProyectoList) {
        this.contratoProyectoList = contratoProyectoList;
    }

    @XmlTransient
    public List<PlanMejoramiento> getPlanMejoramientoList() {
        return planMejoramientoList;
    }

    public void setPlanMejoramientoList(List<PlanMejoramiento> planMejoramientoList) {
        this.planMejoramientoList = planMejoramientoList;
    }

    @XmlTransient
    public List<SeguimientoProductiva> getSeguimientoProductivaList() {
        return seguimientoProductivaList;
    }

    public void setSeguimientoProductivaList(List<SeguimientoProductiva> seguimientoProductivaList) {
        this.seguimientoProductivaList = seguimientoProductivaList;
    }

    public ZonaEmpresa getIdZonaEmpresa() {
        return idZonaEmpresa;
    }

    public void setIdZonaEmpresa(ZonaEmpresa idZonaEmpresa) {
        this.idZonaEmpresa = idZonaEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Empresa[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
