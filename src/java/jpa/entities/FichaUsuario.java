/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leoandresm
 */
@Entity
@Table(name = "ficha_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FichaUsuario.findAll", query = "SELECT f FROM FichaUsuario f"),
    @NamedQuery(name = "FichaUsuario.findByIdUsuario", query = "SELECT f FROM FichaUsuario f WHERE f.fichaUsuarioPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "FichaUsuario.findByIdFichaCaracterizacion", query = "SELECT f FROM FichaUsuario f WHERE f.fichaUsuarioPK.idFichaCaracterizacion = :idFichaCaracterizacion")})
public class FichaUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FichaUsuarioPK fichaUsuarioPK;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "id_estado_aprendiz", referencedColumnName = "id_estado_aprendiz")
    @ManyToOne(optional = false)
    private EstadoAprendiz idEstadoAprendiz;
    @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FichaCaracterizacion fichaCaracterizacion;

    public FichaUsuario() {
    }

    public FichaUsuario(FichaUsuarioPK fichaUsuarioPK) {
        this.fichaUsuarioPK = fichaUsuarioPK;
    }

    public FichaUsuario(int idUsuario, int idFichaCaracterizacion) {
        this.fichaUsuarioPK = new FichaUsuarioPK(idUsuario, idFichaCaracterizacion);
    }

    public FichaUsuarioPK getFichaUsuarioPK() {
        return fichaUsuarioPK;
    }

    public void setFichaUsuarioPK(FichaUsuarioPK fichaUsuarioPK) {
        this.fichaUsuarioPK = fichaUsuarioPK;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstadoAprendiz getIdEstadoAprendiz() {
        return idEstadoAprendiz;
    }

    public void setIdEstadoAprendiz(EstadoAprendiz idEstadoAprendiz) {
        this.idEstadoAprendiz = idEstadoAprendiz;
    }

    public FichaCaracterizacion getFichaCaracterizacion() {
        return fichaCaracterizacion;
    }

    public void setFichaCaracterizacion(FichaCaracterizacion fichaCaracterizacion) {
        this.fichaCaracterizacion = fichaCaracterizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fichaUsuarioPK != null ? fichaUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichaUsuario)) {
            return false;
        }
        FichaUsuario other = (FichaUsuario) object;
        if ((this.fichaUsuarioPK == null && other.fichaUsuarioPK != null) || (this.fichaUsuarioPK != null && !this.fichaUsuarioPK.equals(other.fichaUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.FichaUsuario[ fichaUsuarioPK=" + fichaUsuarioPK + " ]";
    }
    
}
