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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "fase_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaseProyecto.findAll", query = "SELECT f FROM FaseProyecto f"),
    @NamedQuery(name = "FaseProyecto.findByIdFaseProyecto", query = "SELECT f FROM FaseProyecto f WHERE f.idFaseProyecto = :idFaseProyecto"),
    @NamedQuery(name = "FaseProyecto.findByDurHorFas", query = "SELECT f FROM FaseProyecto f WHERE f.durHorFas = :durHorFas"),
    @NamedQuery(name = "FaseProyecto.findByDescrNomFasPro", query = "SELECT f FROM FaseProyecto f WHERE f.descrNomFasPro = :descrNomFasPro")})
public class FaseProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fase_proyecto")
    private Short idFaseProyecto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descr_fase_proyecto")
    private String descrFaseProyecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dur_hor_fas")
    private short durHorFas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descr_nom_fas_pro")
    private String descrNomFasPro;
    @ManyToMany(mappedBy = "faseProyectoList")
    private List<ProyectoFormativo> proyectoFormativoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFaseProyecto")
    private List<PlanMejoramiento> planMejoramientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFaseProyecto")
    private List<ActividadProyecto> actividadProyectoList;

    public FaseProyecto() {
    }

    public FaseProyecto(Short idFaseProyecto) {
        this.idFaseProyecto = idFaseProyecto;
    }

    public FaseProyecto(Short idFaseProyecto, String descrFaseProyecto, short durHorFas, String descrNomFasPro) {
        this.idFaseProyecto = idFaseProyecto;
        this.descrFaseProyecto = descrFaseProyecto;
        this.durHorFas = durHorFas;
        this.descrNomFasPro = descrNomFasPro;
    }

    public Short getIdFaseProyecto() {
        return idFaseProyecto;
    }

    public void setIdFaseProyecto(Short idFaseProyecto) {
        this.idFaseProyecto = idFaseProyecto;
    }

    public String getDescrFaseProyecto() {
        return descrFaseProyecto;
    }

    public void setDescrFaseProyecto(String descrFaseProyecto) {
        this.descrFaseProyecto = descrFaseProyecto;
    }

    public short getDurHorFas() {
        return durHorFas;
    }

    public void setDurHorFas(short durHorFas) {
        this.durHorFas = durHorFas;
    }

    public String getDescrNomFasPro() {
        return descrNomFasPro;
    }

    public void setDescrNomFasPro(String descrNomFasPro) {
        this.descrNomFasPro = descrNomFasPro;
    }

    @XmlTransient
    public List<ProyectoFormativo> getProyectoFormativoList() {
        return proyectoFormativoList;
    }

    public void setProyectoFormativoList(List<ProyectoFormativo> proyectoFormativoList) {
        this.proyectoFormativoList = proyectoFormativoList;
    }

    @XmlTransient
    public List<PlanMejoramiento> getPlanMejoramientoList() {
        return planMejoramientoList;
    }

    public void setPlanMejoramientoList(List<PlanMejoramiento> planMejoramientoList) {
        this.planMejoramientoList = planMejoramientoList;
    }

    @XmlTransient
    public List<ActividadProyecto> getActividadProyectoList() {
        return actividadProyectoList;
    }

    public void setActividadProyectoList(List<ActividadProyecto> actividadProyectoList) {
        this.actividadProyectoList = actividadProyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFaseProyecto != null ? idFaseProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FaseProyecto)) {
            return false;
        }
        FaseProyecto other = (FaseProyecto) object;
        if ((this.idFaseProyecto == null && other.idFaseProyecto != null) || (this.idFaseProyecto != null && !this.idFaseProyecto.equals(other.idFaseProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descrNomFasPro;
    }
    
}
