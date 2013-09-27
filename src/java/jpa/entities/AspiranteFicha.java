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
 * @author MAURICIO
 */
@Entity
@Table(name = "aspirante_ficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AspiranteFicha.findAll", query = "SELECT a FROM AspiranteFicha a"),
    @NamedQuery(name = "AspiranteFicha.findByIdEstadoAspirante", query = "SELECT a FROM AspiranteFicha a WHERE a.aspiranteFichaPK.idEstadoAspirante = :idEstadoAspirante"),
    @NamedQuery(name = "AspiranteFicha.findByIdFichaCaracterizacion", query = "SELECT a FROM AspiranteFicha a WHERE a.aspiranteFichaPK.idFichaCaracterizacion = :idFichaCaracterizacion"),
    @NamedQuery(name = "AspiranteFicha.findByIdUsuario", query = "SELECT a FROM AspiranteFicha a WHERE a.aspiranteFichaPK.idUsuario = :idUsuario")})
public class AspiranteFicha implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AspiranteFichaPK aspiranteFichaPK;
    @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FichaCaracterizacion fichaCaracterizacion;
    @JoinColumn(name = "id_estado_aspirante", referencedColumnName = "id_estado_aspirante", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EstadoAspirante estadoAspirante;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public AspiranteFicha() {
    }

    public AspiranteFicha(AspiranteFichaPK aspiranteFichaPK) {
        this.aspiranteFichaPK = aspiranteFichaPK;
    }

    public AspiranteFicha(short idEstadoAspirante, int idFichaCaracterizacion, int idUsuario) {
        this.aspiranteFichaPK = new AspiranteFichaPK(idEstadoAspirante, idFichaCaracterizacion, idUsuario);
    }

    public AspiranteFichaPK getAspiranteFichaPK() {
        return aspiranteFichaPK;
    }

    public void setAspiranteFichaPK(AspiranteFichaPK aspiranteFichaPK) {
        this.aspiranteFichaPK = aspiranteFichaPK;
    }

    public FichaCaracterizacion getFichaCaracterizacion() {
        return fichaCaracterizacion;
    }

    public void setFichaCaracterizacion(FichaCaracterizacion fichaCaracterizacion) {
        this.fichaCaracterizacion = fichaCaracterizacion;
    }

    public EstadoAspirante getEstadoAspirante() {
        return estadoAspirante;
    }

    public void setEstadoAspirante(EstadoAspirante estadoAspirante) {
        this.estadoAspirante = estadoAspirante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aspiranteFichaPK != null ? aspiranteFichaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AspiranteFicha)) {
            return false;
        }
        AspiranteFicha other = (AspiranteFicha) object;
        if ((this.aspiranteFichaPK == null && other.aspiranteFichaPK != null) || (this.aspiranteFichaPK != null && !this.aspiranteFichaPK.equals(other.aspiranteFichaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.AspiranteFicha[ aspiranteFichaPK=" + aspiranteFichaPK + " ]";
    }
    
}
