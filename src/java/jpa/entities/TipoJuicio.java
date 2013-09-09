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
@Table(name = "tipo_juicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoJuicio.findAll", query = "SELECT t FROM TipoJuicio t"),
    @NamedQuery(name = "TipoJuicio.findByIdTipoJuicio", query = "SELECT t FROM TipoJuicio t WHERE t.idTipoJuicio = :idTipoJuicio"),
    @NamedQuery(name = "TipoJuicio.findByNomTipJui", query = "SELECT t FROM TipoJuicio t WHERE t.nomTipJui = :nomTipJui")})
public class TipoJuicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_tipo_juicio")
    private String idTipoJuicio;
    @Size(max = 255)
    @Column(name = "nom_tip_jui")
    private String nomTipJui;
    @OneToMany(mappedBy = "idTipoJuicio")
    private List<SeguimientoInstructor> seguimientoInstructorList;
    @OneToMany(mappedBy = "idTipoJuicio")
    private List<CriterioSeguimientoProyecto> criterioSeguimientoProyectoList;

    public TipoJuicio() {
    }

    public TipoJuicio(String idTipoJuicio) {
        this.idTipoJuicio = idTipoJuicio;
    }

    public String getIdTipoJuicio() {
        return idTipoJuicio;
    }

    public void setIdTipoJuicio(String idTipoJuicio) {
        this.idTipoJuicio = idTipoJuicio;
    }

    public String getNomTipJui() {
        return nomTipJui;
    }

    public void setNomTipJui(String nomTipJui) {
        this.nomTipJui = nomTipJui;
    }

    @XmlTransient
    public List<SeguimientoInstructor> getSeguimientoInstructorList() {
        return seguimientoInstructorList;
    }

    public void setSeguimientoInstructorList(List<SeguimientoInstructor> seguimientoInstructorList) {
        this.seguimientoInstructorList = seguimientoInstructorList;
    }

    @XmlTransient
    public List<CriterioSeguimientoProyecto> getCriterioSeguimientoProyectoList() {
        return criterioSeguimientoProyectoList;
    }

    public void setCriterioSeguimientoProyectoList(List<CriterioSeguimientoProyecto> criterioSeguimientoProyectoList) {
        this.criterioSeguimientoProyectoList = criterioSeguimientoProyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoJuicio != null ? idTipoJuicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoJuicio)) {
            return false;
        }
        TipoJuicio other = (TipoJuicio) object;
        if ((this.idTipoJuicio == null && other.idTipoJuicio != null) || (this.idTipoJuicio != null && !this.idTipoJuicio.equals(other.idTipoJuicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TipoJuicio[ idTipoJuicio=" + idTipoJuicio + " ]";
    }
    
}
