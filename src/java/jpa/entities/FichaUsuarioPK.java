/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author MAURICIO
 */
@Embeddable
public class FichaUsuarioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ficha_caracterizacion")
    private int idFichaCaracterizacion;

    public FichaUsuarioPK() {
    }

    public FichaUsuarioPK(int idUsuario, int idFichaCaracterizacion) {
        this.idUsuario = idUsuario;
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdFichaCaracterizacion() {
        return idFichaCaracterizacion;
    }

    public void setIdFichaCaracterizacion(int idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuario;
        hash += (int) idFichaCaracterizacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichaUsuarioPK)) {
            return false;
        }
        FichaUsuarioPK other = (FichaUsuarioPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idFichaCaracterizacion != other.idFichaCaracterizacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.FichaUsuarioPK[ idUsuario=" + idUsuario + ", idFichaCaracterizacion=" + idFichaCaracterizacion + " ]";
    }
    
}
