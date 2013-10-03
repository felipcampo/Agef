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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * @author ADSI
 */
@Entity
@Table(name = "falta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Falta.findAll", query = "SELECT f FROM Falta f"),
    @NamedQuery(name = "Falta.findByIdFalta", query = "SELECT f FROM Falta f WHERE f.idFalta = :idFalta"),
    @NamedQuery(name = "Falta.findByCalificacionFalta", query = "SELECT f FROM Falta f WHERE f.calificacionFalta = :calificacionFalta"),
    @NamedQuery(name = "Falta.findByClasificacionFalta", query = "SELECT f FROM Falta f WHERE f.clasificacionFalta = :clasificacionFalta")})
public class Falta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_falta")
    private Short idFalta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "calificacion_falta")
    private String calificacionFalta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "clasificacion_falta")
    private String clasificacionFalta;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nom_fal")
    private String nomFal;
    @ManyToMany(mappedBy = "faltaList")
    private List<CriterioCalificacionFalta> criterioCalificacionFaltaList;
    @JoinColumn(name = "id_sancion", referencedColumnName = "id_sancion")
    @ManyToOne(optional = false)
    private Sancion idSancion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFalta")
    private List<PlanMejoramiento> planMejoramientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFalta")
    private List<Comite> comiteList;

    public Falta() {
    }

    public Falta(Short idFalta) {
        this.idFalta = idFalta;
    }

    public Falta(Short idFalta, String calificacionFalta, String clasificacionFalta, String nomFal) {
        this.idFalta = idFalta;
        this.calificacionFalta = calificacionFalta;
        this.clasificacionFalta = clasificacionFalta;
        this.nomFal = nomFal;
    }

    public Short getIdFalta() {
        return idFalta;
    }

    public void setIdFalta(Short idFalta) {
        this.idFalta = idFalta;
    }

    public String getCalificacionFalta() {
        return calificacionFalta;
    }

    public void setCalificacionFalta(String calificacionFalta) {
        this.calificacionFalta = calificacionFalta;
    }

    public String getClasificacionFalta() {
        return clasificacionFalta;
    }

    public void setClasificacionFalta(String clasificacionFalta) {
        this.clasificacionFalta = clasificacionFalta;
    }

    public String getNomFal() {
        return nomFal;
    }

    public void setNomFal(String nomFal) {
        this.nomFal = nomFal;
    }

    @XmlTransient
    public List<CriterioCalificacionFalta> getCriterioCalificacionFaltaList() {
        return criterioCalificacionFaltaList;
    }

    public void setCriterioCalificacionFaltaList(List<CriterioCalificacionFalta> criterioCalificacionFaltaList) {
        this.criterioCalificacionFaltaList = criterioCalificacionFaltaList;
    }

    public Sancion getIdSancion() {
        return idSancion;
    }

    public void setIdSancion(Sancion idSancion) {
        this.idSancion = idSancion;
    }

    @XmlTransient
    public List<PlanMejoramiento> getPlanMejoramientoList() {
        return planMejoramientoList;
    }

    public void setPlanMejoramientoList(List<PlanMejoramiento> planMejoramientoList) {
        this.planMejoramientoList = planMejoramientoList;
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
        hash += (idFalta != null ? idFalta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Falta)) {
            return false;
        }
        Falta other = (Falta) object;
        if ((this.idFalta == null && other.idFalta != null) || (this.idFalta != null && !this.idFalta.equals(other.idFalta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Falta[ idFalta=" + idFalta + " ]";
    }
    
}
