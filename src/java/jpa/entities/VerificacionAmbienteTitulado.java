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
 * @author leoandresm
 */
@Entity
@Table(name = "verificacion_ambiente_titulado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VerificacionAmbienteTitulado.findAll", query = "SELECT v FROM VerificacionAmbienteTitulado v"),
    @NamedQuery(name = "VerificacionAmbienteTitulado.findByIdVerificacionAmbienteTitulado", query = "SELECT v FROM VerificacionAmbienteTitulado v WHERE v.idVerificacionAmbienteTitulado = :idVerificacionAmbienteTitulado"),
    @NamedQuery(name = "VerificacionAmbienteTitulado.findByLocalizacion", query = "SELECT v FROM VerificacionAmbienteTitulado v WHERE v.localizacion = :localizacion"),
    @NamedQuery(name = "VerificacionAmbienteTitulado.findByDenominacion", query = "SELECT v FROM VerificacionAmbienteTitulado v WHERE v.denominacion = :denominacion"),
    @NamedQuery(name = "VerificacionAmbienteTitulado.findByTipoAmbiente", query = "SELECT v FROM VerificacionAmbienteTitulado v WHERE v.tipoAmbiente = :tipoAmbiente"),
    @NamedQuery(name = "VerificacionAmbienteTitulado.findByViabilidadAmbiente", query = "SELECT v FROM VerificacionAmbienteTitulado v WHERE v.viabilidadAmbiente = :viabilidadAmbiente"),
    @NamedQuery(name = "VerificacionAmbienteTitulado.findByCiudad", query = "SELECT v FROM VerificacionAmbienteTitulado v WHERE v.ciudad = :ciudad"),
    @NamedQuery(name = "VerificacionAmbienteTitulado.findByFecha", query = "SELECT v FROM VerificacionAmbienteTitulado v WHERE v.fecha = :fecha")})
public class VerificacionAmbienteTitulado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_verificacion_ambiente_titulado")
    private Integer idVerificacionAmbienteTitulado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "localizacion")
    private String localizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "denominacion")
    private String denominacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_ambiente")
    private String tipoAmbiente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "viabilidad_ambiente")
    private boolean viabilidadAmbiente;
    @Size(max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_lista_verificacion", referencedColumnName = "id_lista_verificacion")
    @ManyToOne(optional = false)
    private ListaVerificacion idListaVerificacion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_proyecto_formativo", referencedColumnName = "id_proyecto_formativo")
    @ManyToOne(optional = false)
    private ProyectoFormativo idProyectoFormativo;
    @OneToMany(mappedBy = "idVerificacionAmbienteTitulado")
    private List<Alistamiento> alistamientoList;

    public VerificacionAmbienteTitulado() {
    }

    public VerificacionAmbienteTitulado(Integer idVerificacionAmbienteTitulado) {
        this.idVerificacionAmbienteTitulado = idVerificacionAmbienteTitulado;
    }

    public VerificacionAmbienteTitulado(Integer idVerificacionAmbienteTitulado, String localizacion, String denominacion, String tipoAmbiente, boolean viabilidadAmbiente, Date fecha) {
        this.idVerificacionAmbienteTitulado = idVerificacionAmbienteTitulado;
        this.localizacion = localizacion;
        this.denominacion = denominacion;
        this.tipoAmbiente = tipoAmbiente;
        this.viabilidadAmbiente = viabilidadAmbiente;
        this.fecha = fecha;
    }

    public Integer getIdVerificacionAmbienteTitulado() {
        return idVerificacionAmbienteTitulado;
    }

    public void setIdVerificacionAmbienteTitulado(Integer idVerificacionAmbienteTitulado) {
        this.idVerificacionAmbienteTitulado = idVerificacionAmbienteTitulado;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getTipoAmbiente() {
        return tipoAmbiente;
    }

    public void setTipoAmbiente(String tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
    }

    public boolean getViabilidadAmbiente() {
        return viabilidadAmbiente;
    }

    public void setViabilidadAmbiente(boolean viabilidadAmbiente) {
        this.viabilidadAmbiente = viabilidadAmbiente;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ListaVerificacion getIdListaVerificacion() {
        return idListaVerificacion;
    }

    public void setIdListaVerificacion(ListaVerificacion idListaVerificacion) {
        this.idListaVerificacion = idListaVerificacion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ProyectoFormativo getIdProyectoFormativo() {
        return idProyectoFormativo;
    }

    public void setIdProyectoFormativo(ProyectoFormativo idProyectoFormativo) {
        this.idProyectoFormativo = idProyectoFormativo;
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
        hash += (idVerificacionAmbienteTitulado != null ? idVerificacionAmbienteTitulado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VerificacionAmbienteTitulado)) {
            return false;
        }
        VerificacionAmbienteTitulado other = (VerificacionAmbienteTitulado) object;
        if ((this.idVerificacionAmbienteTitulado == null && other.idVerificacionAmbienteTitulado != null) || (this.idVerificacionAmbienteTitulado != null && !this.idVerificacionAmbienteTitulado.equals(other.idVerificacionAmbienteTitulado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.VerificacionAmbienteTitulado[ idVerificacionAmbienteTitulado=" + idVerificacionAmbienteTitulado + " ]";
    }
    
}
