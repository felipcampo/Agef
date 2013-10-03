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
public class AspiranteFichaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estado_aspirante")
    private short idEstadoAspirante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ficha_caracterizacion")
    private int idFichaCaracterizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;

    public AspiranteFichaPK() {
    }

    public AspiranteFichaPK(short idEstadoAspirante, int idFichaCaracterizacion, int idUsuario) {
        this.idEstadoAspirante = idEstadoAspirante;
        this.idFichaCaracterizacion = idFichaCaracterizacion;
        this.idUsuario = idUsuario;
    }

    public short getIdEstadoAspirante() {
        return idEstadoAspirante;
    }

    public void setIdEstadoAspirante(short idEstadoAspirante) {
        this.idEstadoAspirante = idEstadoAspirante;
    }

    public int getIdFichaCaracterizacion() {
        return idFichaCaracterizacion;
    }

    public void setIdFichaCaracterizacion(int idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEstadoAspirante;
        hash += (int) idFichaCaracterizacion;
        hash += (int) idUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AspiranteFichaPK)) {
            return false;
        }
        AspiranteFichaPK other = (AspiranteFichaPK) object;
        if (this.idEstadoAspirante != other.idEstadoAspirante) {
            return false;
        }
        if (this.idFichaCaracterizacion != other.idFichaCaracterizacion) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.AspiranteFichaPK[ idEstadoAspirante=" + idEstadoAspirante + ", idFichaCaracterizacion=" + idFichaCaracterizacion + ", idUsuario=" + idUsuario + " ]";
    }
    
}
