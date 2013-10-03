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
 * @author MAURICIO
 */
@Entity
@Table(name = "trimestre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trimestre.findAll", query = "SELECT t FROM Trimestre t"),
    @NamedQuery(name = "Trimestre.findByIdTrimestre", query = "SELECT t FROM Trimestre t WHERE t.idTrimestre = :idTrimestre"),
    @NamedQuery(name = "Trimestre.findByFechaInicio", query = "SELECT t FROM Trimestre t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Trimestre.findByFechaFinal", query = "SELECT t FROM Trimestre t WHERE t.fechaFinal = :fechaFinal")})
public class Trimestre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_trimestre")
    private Short idTrimestre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fecha_inicio")
    private String fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fecha_final")
    private String fechaFinal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrimestre")
    private List<ProgramacionProyecto> programacionProyectoList;

    public Trimestre() {
    }

    public Trimestre(Short idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    public Trimestre(Short idTrimestre, String fechaInicio, String fechaFinal) {
        this.idTrimestre = idTrimestre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public Short getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(Short idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @XmlTransient
    public List<ProgramacionProyecto> getProgramacionProyectoList() {
        return programacionProyectoList;
    }

    public void setProgramacionProyectoList(List<ProgramacionProyecto> programacionProyectoList) {
        this.programacionProyectoList = programacionProyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrimestre != null ? idTrimestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trimestre)) {
            return false;
        }
        Trimestre other = (Trimestre) object;
        if ((this.idTrimestre == null && other.idTrimestre != null) || (this.idTrimestre != null && !this.idTrimestre.equals(other.idTrimestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Trimestre[ idTrimestre=" + idTrimestre + " ]";
    }
    
}
