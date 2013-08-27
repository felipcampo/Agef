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
import javax.persistence.ManyToMany;
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
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "Ciudad.findByIdCiudad", query = "SELECT c FROM Ciudad c WHERE c.idCiudad = :idCiudad"),
    @NamedQuery(name = "Ciudad.findByNomCiu", query = "SELECT c FROM Ciudad c WHERE c.nomCiu = :nomCiu"),
    @NamedQuery(name = "Ciudad.findByDescrZona", query = "SELECT c FROM Ciudad c WHERE c.descrZona = :descrZona")})
public class Ciudad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_ciudad")
    private String idCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_ciu")
    private String nomCiu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "descr_zona")
    private String descrZona;
    @ManyToMany(mappedBy = "ciudadList")
    private List<Comuna> comunaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad")
    private List<SedeCentro> sedeCentroList;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    @ManyToOne(optional = false)
    private Departamento idDepartamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad")
    private List<Comuna> comunaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudadConcertacion")
    private List<PlanMejoramiento> planMejoramientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudadNacimiento")
    private List<Usuario> usuarioList;

    public Ciudad() {
    }

    public Ciudad(String idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Ciudad(String idCiudad, String nomCiu, String descrZona) {
        this.idCiudad = idCiudad;
        this.nomCiu = nomCiu;
        this.descrZona = descrZona;
    }

    public String getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(String idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNomCiu() {
        return nomCiu;
    }

    public void setNomCiu(String nomCiu) {
        this.nomCiu = nomCiu;
    }

    public String getDescrZona() {
        return descrZona;
    }

    public void setDescrZona(String descrZona) {
        this.descrZona = descrZona;
    }

    @XmlTransient
    public List<Comuna> getComunaList() {
        return comunaList;
    }

    public void setComunaList(List<Comuna> comunaList) {
        this.comunaList = comunaList;
    }

    @XmlTransient
    public List<SedeCentro> getSedeCentroList() {
        return sedeCentroList;
    }

    public void setSedeCentroList(List<SedeCentro> sedeCentroList) {
        this.sedeCentroList = sedeCentroList;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @XmlTransient
    public List<Comuna> getComunaList1() {
        return comunaList1;
    }

    public void setComunaList1(List<Comuna> comunaList1) {
        this.comunaList1 = comunaList1;
    }

    @XmlTransient
    public List<PlanMejoramiento> getPlanMejoramientoList() {
        return planMejoramientoList;
    }

    public void setPlanMejoramientoList(List<PlanMejoramiento> planMejoramientoList) {
        this.planMejoramientoList = planMejoramientoList;
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
        hash += (idCiudad != null ? idCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.idCiudad == null && other.idCiudad != null) || (this.idCiudad != null && !this.idCiudad.equals(other.idCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Ciudad[ idCiudad=" + idCiudad + " ]";
    }
    
}
