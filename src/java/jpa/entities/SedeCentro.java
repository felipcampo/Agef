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
 * @author leoandresm
 */
@Entity
@Table(name = "sede_centro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SedeCentro.findAll", query = "SELECT s FROM SedeCentro s"),
    @NamedQuery(name = "SedeCentro.findByIdSedeCentro", query = "SELECT s FROM SedeCentro s WHERE s.idSedeCentro = :idSedeCentro"),
    @NamedQuery(name = "SedeCentro.findByNomSedeCentro", query = "SELECT s FROM SedeCentro s WHERE s.nomSedeCentro = :nomSedeCentro"),
    @NamedQuery(name = "SedeCentro.findByDirSedeCentro", query = "SELECT s FROM SedeCentro s WHERE s.dirSedeCentro = :dirSedeCentro"),
    @NamedQuery(name = "SedeCentro.findByTelSedeCentro", query = "SELECT s FROM SedeCentro s WHERE s.telSedeCentro = :telSedeCentro")})
public class SedeCentro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sede_centro")
    private Short idSedeCentro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom_sede_centro")
    private String nomSedeCentro;
    @Size(max = 150)
    @Column(name = "dir_sede_centro")
    private String dirSedeCentro;
    @Size(max = 20)
    @Column(name = "tel_sede_centro")
    private String telSedeCentro;
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad")
    @ManyToOne(optional = false)
    private Ciudad idCiudad;
    @JoinColumn(name = "id_centro_formacion", referencedColumnName = "id_centro_formacion")
    @ManyToOne(optional = false)
    private CentroFormacion idCentroFormacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSedeCentro")
    private List<FichaCaracterizacion> fichaCaracterizacionList;
    @OneToMany(mappedBy = "idSedeCentro")
    private List<SeguimientoProyecto> seguimientoProyectoList;

    public SedeCentro() {
    }

    public SedeCentro(Short idSedeCentro) {
        this.idSedeCentro = idSedeCentro;
    }

    public SedeCentro(Short idSedeCentro, String nomSedeCentro) {
        this.idSedeCentro = idSedeCentro;
        this.nomSedeCentro = nomSedeCentro;
    }

    public Short getIdSedeCentro() {
        return idSedeCentro;
    }

    public void setIdSedeCentro(Short idSedeCentro) {
        this.idSedeCentro = idSedeCentro;
    }

    public String getNomSedeCentro() {
        return nomSedeCentro;
    }

    public void setNomSedeCentro(String nomSedeCentro) {
        this.nomSedeCentro = nomSedeCentro;
    }

    public String getDirSedeCentro() {
        return dirSedeCentro;
    }

    public void setDirSedeCentro(String dirSedeCentro) {
        this.dirSedeCentro = dirSedeCentro;
    }

    public String getTelSedeCentro() {
        return telSedeCentro;
    }

    public void setTelSedeCentro(String telSedeCentro) {
        this.telSedeCentro = telSedeCentro;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    public CentroFormacion getIdCentroFormacion() {
        return idCentroFormacion;
    }

    public void setIdCentroFormacion(CentroFormacion idCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
    }

    @XmlTransient
    public List<FichaCaracterizacion> getFichaCaracterizacionList() {
        return fichaCaracterizacionList;
    }

    public void setFichaCaracterizacionList(List<FichaCaracterizacion> fichaCaracterizacionList) {
        this.fichaCaracterizacionList = fichaCaracterizacionList;
    }

    @XmlTransient
    public List<SeguimientoProyecto> getSeguimientoProyectoList() {
        return seguimientoProyectoList;
    }

    public void setSeguimientoProyectoList(List<SeguimientoProyecto> seguimientoProyectoList) {
        this.seguimientoProyectoList = seguimientoProyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSedeCentro != null ? idSedeCentro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SedeCentro)) {
            return false;
        }
        SedeCentro other = (SedeCentro) object;
        if ((this.idSedeCentro == null && other.idSedeCentro != null) || (this.idSedeCentro != null && !this.idSedeCentro.equals(other.idSedeCentro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.SedeCentro[ idSedeCentro=" + idSedeCentro + " ]";
    }
    
}
