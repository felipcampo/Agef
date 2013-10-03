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
@Table(name = "tipo_alistamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAlistamiento.findAll", query = "SELECT t FROM TipoAlistamiento t"),
    @NamedQuery(name = "TipoAlistamiento.findByIdTipoAlistamiento", query = "SELECT t FROM TipoAlistamiento t WHERE t.idTipoAlistamiento = :idTipoAlistamiento"),
    @NamedQuery(name = "TipoAlistamiento.findByNomTipoAlistamiento", query = "SELECT t FROM TipoAlistamiento t WHERE t.nomTipoAlistamiento = :nomTipoAlistamiento")})
public class TipoAlistamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_alistamiento")
    private Short idTipoAlistamiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_tipo_alistamiento")
    private String nomTipoAlistamiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoAlistamiento")
    private List<Alistamiento> alistamientoList;

    public TipoAlistamiento() {
    }

    public TipoAlistamiento(Short idTipoAlistamiento) {
        this.idTipoAlistamiento = idTipoAlistamiento;
    }

    public TipoAlistamiento(Short idTipoAlistamiento, String nomTipoAlistamiento) {
        this.idTipoAlistamiento = idTipoAlistamiento;
        this.nomTipoAlistamiento = nomTipoAlistamiento;
    }

    public Short getIdTipoAlistamiento() {
        return idTipoAlistamiento;
    }

    public void setIdTipoAlistamiento(Short idTipoAlistamiento) {
        this.idTipoAlistamiento = idTipoAlistamiento;
    }

    public String getNomTipoAlistamiento() {
        return nomTipoAlistamiento;
    }

    public void setNomTipoAlistamiento(String nomTipoAlistamiento) {
        this.nomTipoAlistamiento = nomTipoAlistamiento;
    }

    @XmlTransient
    public List<Alistamiento> getAlistamientoList() {
        return alistamientoList;
    }

    public void setAlistamientoList(List<Alistamiento> alistamientoList) {
        this.alistamientoList = alistamientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoAlistamiento != null ? idTipoAlistamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAlistamiento)) {
            return false;
        }
        TipoAlistamiento other = (TipoAlistamiento) object;
        if ((this.idTipoAlistamiento == null && other.idTipoAlistamiento != null) || (this.idTipoAlistamiento != null && !this.idTipoAlistamiento.equals(other.idTipoAlistamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TipoAlistamiento[ idTipoAlistamiento=" + idTipoAlistamiento + " ]";
    }
    
}
