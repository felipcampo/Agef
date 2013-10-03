/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MAURICIO
 */
@Entity
@Table(name = "control_operativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlOperativo.findAll", query = "SELECT c FROM ControlOperativo c"),
    @NamedQuery(name = "ControlOperativo.findByIdControlOperativo", query = "SELECT c FROM ControlOperativo c WHERE c.idControlOperativo = :idControlOperativo"),
    @NamedQuery(name = "ControlOperativo.findByEleConOpe", query = "SELECT c FROM ControlOperativo c WHERE c.eleConOpe = :eleConOpe"),
    @NamedQuery(name = "ControlOperativo.findByFecDilConOpe", query = "SELECT c FROM ControlOperativo c WHERE c.fecDilConOpe = :fecDilConOpe"),
    @NamedQuery(name = "ControlOperativo.findBySitConOpe", query = "SELECT c FROM ControlOperativo c WHERE c.sitConOpe = :sitConOpe")})
public class ControlOperativo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_control_operativo")
    private Integer idControlOperativo;
    @Size(max = 255)
    @Column(name = "ele_con_ope")
    private String eleConOpe;
    @Column(name = "fec_dil_con_ope")
    @Temporal(TemporalType.DATE)
    private Date fecDilConOpe;
    @Size(max = 255)
    @Column(name = "sit_con_ope")
    private String sitConOpe;
    @ManyToMany(mappedBy = "controlOperativoList")
    private List<Usuario> usuarioList;
    @JoinColumn(name = "id_alistamiento", referencedColumnName = "id_alistamiento")
    @ManyToOne(optional = false)
    private Alistamiento idAlistamiento;

    public ControlOperativo() {
    }

    public ControlOperativo(Integer idControlOperativo) {
        this.idControlOperativo = idControlOperativo;
    }

    public Integer getIdControlOperativo() {
        return idControlOperativo;
    }

    public void setIdControlOperativo(Integer idControlOperativo) {
        this.idControlOperativo = idControlOperativo;
    }

    public String getEleConOpe() {
        return eleConOpe;
    }

    public void setEleConOpe(String eleConOpe) {
        this.eleConOpe = eleConOpe;
    }

    public Date getFecDilConOpe() {
        return fecDilConOpe;
    }

    public void setFecDilConOpe(Date fecDilConOpe) {
        this.fecDilConOpe = fecDilConOpe;
    }

    public String getSitConOpe() {
        return sitConOpe;
    }

    public void setSitConOpe(String sitConOpe) {
        this.sitConOpe = sitConOpe;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Alistamiento getIdAlistamiento() {
        return idAlistamiento;
    }

    public void setIdAlistamiento(Alistamiento idAlistamiento) {
        this.idAlistamiento = idAlistamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControlOperativo != null ? idControlOperativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlOperativo)) {
            return false;
        }
        ControlOperativo other = (ControlOperativo) object;
        if ((this.idControlOperativo == null && other.idControlOperativo != null) || (this.idControlOperativo != null && !this.idControlOperativo.equals(other.idControlOperativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ControlOperativo[ idControlOperativo=" + idControlOperativo + " ]";
    }
    
}
