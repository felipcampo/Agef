/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MAURICIO
 */
@Entity
@Table(name = "contrato_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContratoProyecto.findAll", query = "SELECT c FROM ContratoProyecto c"),
    @NamedQuery(name = "ContratoProyecto.findByIdContratoProyecto", query = "SELECT c FROM ContratoProyecto c WHERE c.idContratoProyecto = :idContratoProyecto"),
    @NamedQuery(name = "ContratoProyecto.findByFecSub", query = "SELECT c FROM ContratoProyecto c WHERE c.fecSub = :fecSub"),
    @NamedQuery(name = "ContratoProyecto.findByFfiCop", query = "SELECT c FROM ContratoProyecto c WHERE c.ffiCop = :ffiCop"),
    @NamedQuery(name = "ContratoProyecto.findByFinCop", query = "SELECT c FROM ContratoProyecto c WHERE c.finCop = :finCop")})
public class ContratoProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contrato_proyecto")
    private Integer idContratoProyecto;
    @Lob
    @Column(name = "arc_cop")
    private byte[] arcCop;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_sub")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecSub;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ffi_cop")
    @Temporal(TemporalType.DATE)
    private Date ffiCop;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fin_cop")
    @Temporal(TemporalType.DATE)
    private Date finCop;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    public ContratoProyecto() {
    }

    public ContratoProyecto(Integer idContratoProyecto) {
        this.idContratoProyecto = idContratoProyecto;
    }

    public ContratoProyecto(Integer idContratoProyecto, Date fecSub, Date ffiCop, Date finCop) {
        this.idContratoProyecto = idContratoProyecto;
        this.fecSub = fecSub;
        this.ffiCop = ffiCop;
        this.finCop = finCop;
    }

    public Integer getIdContratoProyecto() {
        return idContratoProyecto;
    }

    public void setIdContratoProyecto(Integer idContratoProyecto) {
        this.idContratoProyecto = idContratoProyecto;
    }

    public byte[] getArcCop() {
        return arcCop;
    }

    public void setArcCop(byte[] arcCop) {
        this.arcCop = arcCop;
    }

    public Date getFecSub() {
        return fecSub;
    }

    public void setFecSub(Date fecSub) {
        this.fecSub = fecSub;
    }

    public Date getFfiCop() {
        return ffiCop;
    }

    public void setFfiCop(Date ffiCop) {
        this.ffiCop = ffiCop;
    }

    public Date getFinCop() {
        return finCop;
    }

    public void setFinCop(Date finCop) {
        this.finCop = finCop;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContratoProyecto != null ? idContratoProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContratoProyecto)) {
            return false;
        }
        ContratoProyecto other = (ContratoProyecto) object;
        if ((this.idContratoProyecto == null && other.idContratoProyecto != null) || (this.idContratoProyecto != null && !this.idContratoProyecto.equals(other.idContratoProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ContratoProyecto[ idContratoProyecto=" + idContratoProyecto + " ]";
    }
    
}
