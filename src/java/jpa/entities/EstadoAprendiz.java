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
@Table(name = "estado_aprendiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoAprendiz.findAll", query = "SELECT e FROM EstadoAprendiz e"),
    @NamedQuery(name = "EstadoAprendiz.findByIdEstadoAprendiz", query = "SELECT e FROM EstadoAprendiz e WHERE e.idEstadoAprendiz = :idEstadoAprendiz"),
    @NamedQuery(name = "EstadoAprendiz.findByNomEstApr", query = "SELECT e FROM EstadoAprendiz e WHERE e.nomEstApr = :nomEstApr")})
public class EstadoAprendiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_aprendiz")
    private Short idEstadoAprendiz;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_est_apr")
    private String nomEstApr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoAprendiz")
    private List<FichaUsuario> fichaUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoAprendiz")
    private List<ControlAsistencia> controlAsistenciaList;

    public EstadoAprendiz() {
    }

    public EstadoAprendiz(Short idEstadoAprendiz) {
        this.idEstadoAprendiz = idEstadoAprendiz;
    }

    public EstadoAprendiz(Short idEstadoAprendiz, String nomEstApr) {
        this.idEstadoAprendiz = idEstadoAprendiz;
        this.nomEstApr = nomEstApr;
    }

    public Short getIdEstadoAprendiz() {
        return idEstadoAprendiz;
    }

    public void setIdEstadoAprendiz(Short idEstadoAprendiz) {
        this.idEstadoAprendiz = idEstadoAprendiz;
    }

    public String getNomEstApr() {
        return nomEstApr;
    }

    public void setNomEstApr(String nomEstApr) {
        this.nomEstApr = nomEstApr;
    }

    @XmlTransient
    public List<FichaUsuario> getFichaUsuarioList() {
        return fichaUsuarioList;
    }

    public void setFichaUsuarioList(List<FichaUsuario> fichaUsuarioList) {
        this.fichaUsuarioList = fichaUsuarioList;
    }

    @XmlTransient
    public List<ControlAsistencia> getControlAsistenciaList() {
        return controlAsistenciaList;
    }

    public void setControlAsistenciaList(List<ControlAsistencia> controlAsistenciaList) {
        this.controlAsistenciaList = controlAsistenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoAprendiz != null ? idEstadoAprendiz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoAprendiz)) {
            return false;
        }
        EstadoAprendiz other = (EstadoAprendiz) object;
        if ((this.idEstadoAprendiz == null && other.idEstadoAprendiz != null) || (this.idEstadoAprendiz != null && !this.idEstadoAprendiz.equals(other.idEstadoAprendiz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EstadoAprendiz[ idEstadoAprendiz=" + idEstadoAprendiz + " ]";
    }
    
}
