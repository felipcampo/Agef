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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MAURICIO
 */
@Entity
@Table(name = "comite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comite.findAll", query = "SELECT c FROM Comite c"),
    @NamedQuery(name = "Comite.findByIdComite", query = "SELECT c FROM Comite c WHERE c.idComite = :idComite"),
    @NamedQuery(name = "Comite.findByFecCom", query = "SELECT c FROM Comite c WHERE c.fecCom = :fecCom"),
    @NamedQuery(name = "Comite.findByNumAct", query = "SELECT c FROM Comite c WHERE c.numAct = :numAct")})
public class Comite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comite")
    private Integer idComite;
    @Lob
    @Size(max = 65535)
    @Column(name = "comentarios")
    private String comentarios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_com")
    @Temporal(TemporalType.DATE)
    private Date fecCom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_act")
    private int numAct;
    @JoinColumn(name = "id_reporte_novedad", referencedColumnName = "id_reporte_novedad")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_sancion", referencedColumnName = "id_sancion")
    @ManyToOne(optional = false)
    private Sancion idSancion;
    @JoinColumn(name = "id_reporte_novedad", referencedColumnName = "id_reporte_novedad")
    @ManyToOne(optional = false)
    private ReporteNovedad idReporteNovedad;
    @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")
    @ManyToOne(optional = false)
    private FichaCaracterizacion idFichaCaracterizacion;
    @JoinColumn(name = "id_falta", referencedColumnName = "id_falta")
    @ManyToOne(optional = false)
    private Falta idFalta;

    public Comite() {
    }

    public Comite(Integer idComite) {
        this.idComite = idComite;
    }

    public Comite(Integer idComite, Date fecCom, int numAct) {
        this.idComite = idComite;
        this.fecCom = fecCom;
        this.numAct = numAct;
    }

    public Integer getIdComite() {
        return idComite;
    }

    public void setIdComite(Integer idComite) {
        this.idComite = idComite;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Date getFecCom() {
        return fecCom;
    }

    public void setFecCom(Date fecCom) {
        this.fecCom = fecCom;
    }

    public int getNumAct() {
        return numAct;
    }

    public void setNumAct(int numAct) {
        this.numAct = numAct;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Sancion getIdSancion() {
        return idSancion;
    }

    public void setIdSancion(Sancion idSancion) {
        this.idSancion = idSancion;
    }

    public ReporteNovedad getIdReporteNovedad() {
        return idReporteNovedad;
    }

    public void setIdReporteNovedad(ReporteNovedad idReporteNovedad) {
        this.idReporteNovedad = idReporteNovedad;
    }

    public FichaCaracterizacion getIdFichaCaracterizacion() {
        return idFichaCaracterizacion;
    }

    public void setIdFichaCaracterizacion(FichaCaracterizacion idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    public Falta getIdFalta() {
        return idFalta;
    }

    public void setIdFalta(Falta idFalta) {
        this.idFalta = idFalta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComite != null ? idComite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comite)) {
            return false;
        }
        Comite other = (Comite) object;
        if ((this.idComite == null && other.idComite != null) || (this.idComite != null && !this.idComite.equals(other.idComite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Comite[ idComite=" + idComite + " ]";
    }
    
}
