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
 * @author MAURICIO
 */
@Entity
@Table(name = "remision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Remision.findAll", query = "SELECT r FROM Remision r"),
    @NamedQuery(name = "Remision.findByIdRemision", query = "SELECT r FROM Remision r WHERE r.idRemision = :idRemision")})
public class Remision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_remision")
    private Integer idRemision;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descr_remision")
    private String descrRemision;
    @JoinColumn(name = "id_tipo_caso_bienestar", referencedColumnName = "id_tipo_caso_bienestar")
    @ManyToOne(optional = false)
    private TipoCasoBienestar idTipoCasoBienestar;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRemision")
    private List<CasoBienestar> casoBienestarList;

    public Remision() {
    }

    public Remision(Integer idRemision) {
        this.idRemision = idRemision;
    }

    public Remision(Integer idRemision, String descrRemision) {
        this.idRemision = idRemision;
        this.descrRemision = descrRemision;
    }

    public Integer getIdRemision() {
        return idRemision;
    }

    public void setIdRemision(Integer idRemision) {
        this.idRemision = idRemision;
    }

    public String getDescrRemision() {
        return descrRemision;
    }

    public void setDescrRemision(String descrRemision) {
        this.descrRemision = descrRemision;
    }

    public TipoCasoBienestar getIdTipoCasoBienestar() {
        return idTipoCasoBienestar;
    }

    public void setIdTipoCasoBienestar(TipoCasoBienestar idTipoCasoBienestar) {
        this.idTipoCasoBienestar = idTipoCasoBienestar;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<CasoBienestar> getCasoBienestarList() {
        return casoBienestarList;
    }

    public void setCasoBienestarList(List<CasoBienestar> casoBienestarList) {
        this.casoBienestarList = casoBienestarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRemision != null ? idRemision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Remision)) {
            return false;
        }
        Remision other = (Remision) object;
        if ((this.idRemision == null && other.idRemision != null) || (this.idRemision != null && !this.idRemision.equals(other.idRemision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Remision[ idRemision=" + idRemision + " ]";
    }
    
}
