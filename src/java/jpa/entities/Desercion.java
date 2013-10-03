/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADSI
 */
@Entity
@Table(name = "desercion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Desercion.findAll", query = "SELECT d FROM Desercion d"),
    @NamedQuery(name = "Desercion.findByIdDesercion", query = "SELECT d FROM Desercion d WHERE d.idDesercion = :idDesercion"),
    @NamedQuery(name = "Desercion.findByDiasDesercion", query = "SELECT d FROM Desercion d WHERE d.diasDesercion = :diasDesercion"),
    @NamedQuery(name = "Desercion.findByFechaInicial", query = "SELECT d FROM Desercion d WHERE d.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "Desercion.findByFechaFinal", query = "SELECT d FROM Desercion d WHERE d.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "Desercion.findByCausasDesercion", query = "SELECT d FROM Desercion d WHERE d.causasDesercion = :causasDesercion")})
public class Desercion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_desercion")
    private Integer idDesercion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dias_desercion")
    private short diasDesercion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicial")
    @Temporal(TemporalType.DATE)
    private Date fechaInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_final")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "causas_desercion")
    private String causasDesercion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDesercion")
    private List<ReporteNovedad> reporteNovedadList;
    @JoinColumn(name = "id_usuario2", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario2;
    @JoinColumn(name = "id_usuario1", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario1;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Desercion() {
    }

    public Desercion(Integer idDesercion) {
        this.idDesercion = idDesercion;
    }

    public Desercion(Integer idDesercion, short diasDesercion, Date fechaInicial, Date fechaFinal, String causasDesercion, String observaciones) {
        this.idDesercion = idDesercion;
        this.diasDesercion = diasDesercion;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.causasDesercion = causasDesercion;
        this.observaciones = observaciones;
    }

    public Integer getIdDesercion() {
        return idDesercion;
    }

    public void setIdDesercion(Integer idDesercion) {
        this.idDesercion = idDesercion;
    }

    public short getDiasDesercion() {
        return diasDesercion;
    }

    public void setDiasDesercion(short diasDesercion) {
        this.diasDesercion = diasDesercion;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getCausasDesercion() {
        return causasDesercion;
    }

    public void setCausasDesercion(String causasDesercion) {
        this.causasDesercion = causasDesercion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<ReporteNovedad> getReporteNovedadList() {
        return reporteNovedadList;
    }

    public void setReporteNovedadList(List<ReporteNovedad> reporteNovedadList) {
        this.reporteNovedadList = reporteNovedadList;
    }

    public Usuario getIdUsuario2() {
        return idUsuario2;
    }

    public void setIdUsuario2(Usuario idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }

    public Usuario getIdUsuario1() {
        return idUsuario1;
    }

    public void setIdUsuario1(Usuario idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDesercion != null ? idDesercion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desercion)) {
            return false;
        }
        Desercion other = (Desercion) object;
        if ((this.idDesercion == null && other.idDesercion != null) || (this.idDesercion != null && !this.idDesercion.equals(other.idDesercion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Desercion[ idDesercion=" + idDesercion + " ]";
    }
    
}
