/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "version")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Version.findAll", query = "SELECT v FROM Version v"),
    @NamedQuery(name = "Version.findByIdVersion", query = "SELECT v FROM Version v WHERE v.idVersion = :idVersion"),
    @NamedQuery(name = "Version.findByNombreVersion", query = "SELECT v FROM Version v WHERE v.nombreVersion = :nombreVersion")})
public class Version implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_version")
    private String idVersion;
    @Size(max = 255)
    @Column(name = "nombre_version")
    private String nombreVersion;
    @JoinTable(name = "programa_version", joinColumns = {
        @JoinColumn(name = "id_version", referencedColumnName = "id_version")}, inverseJoinColumns = {
        @JoinColumn(name = "id_programa", referencedColumnName = "id_programa")})
    @ManyToMany
    private List<Programa> programaList;

    public Version() {
    }

    public Version(String idVersion) {
        this.idVersion = idVersion;
    }

    public String getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(String idVersion) {
        this.idVersion = idVersion;
    }

    public String getNombreVersion() {
        return nombreVersion;
    }

    public void setNombreVersion(String nombreVersion) {
        this.nombreVersion = nombreVersion;
    }

    @XmlTransient
    public List<Programa> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<Programa> programaList) {
        this.programaList = programaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVersion != null ? idVersion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Version)) {
            return false;
        }
        Version other = (Version) object;
        if ((this.idVersion == null && other.idVersion != null) || (this.idVersion != null && !this.idVersion.equals(other.idVersion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Version[ idVersion=" + idVersion + " ]";
    }
    
}
