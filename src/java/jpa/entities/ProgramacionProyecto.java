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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leoandresm
 */
@Entity
@Table(name = "programacion_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramacionProyecto.findAll", query = "SELECT p FROM ProgramacionProyecto p"),
    @NamedQuery(name = "ProgramacionProyecto.findByIdProgramacionProyecto", query = "SELECT p FROM ProgramacionProyecto p WHERE p.idProgramacionProyecto = :idProgramacionProyecto")})
public class ProgramacionProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_programacion_proyecto")
    private Integer idProgramacionProyecto;
    @JoinTable(name = "programacion_proyecto_usuario", joinColumns = {
        @JoinColumn(name = "id_programacion_proyecto", referencedColumnName = "id_programacion_proyecto")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @JoinColumn(name = "id_trimestre", referencedColumnName = "id_trimestre")
    @ManyToOne(optional = false)
    private Trimestre idTrimestre;
    @JoinColumn(name = "id_actividad_proyecto", referencedColumnName = "id_actividad_proyecto")
    @ManyToOne(optional = false)
    private ActividadProyecto idActividadProyecto;
    @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id_resultado_aprendizaje")
    @ManyToOne(optional = false)
    private ResultadoAprendizaje idResultadoAprendizaje;
    @OneToMany(mappedBy = "idProgramacionProyecto")
    private List<Alistamiento> alistamientoList;

    public ProgramacionProyecto() {
    }

    public ProgramacionProyecto(Integer idProgramacionProyecto) {
        this.idProgramacionProyecto = idProgramacionProyecto;
    }

    public Integer getIdProgramacionProyecto() {
        return idProgramacionProyecto;
    }

    public void setIdProgramacionProyecto(Integer idProgramacionProyecto) {
        this.idProgramacionProyecto = idProgramacionProyecto;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Trimestre getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(Trimestre idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    public ActividadProyecto getIdActividadProyecto() {
        return idActividadProyecto;
    }

    public void setIdActividadProyecto(ActividadProyecto idActividadProyecto) {
        this.idActividadProyecto = idActividadProyecto;
    }

    public ResultadoAprendizaje getIdResultadoAprendizaje() {
        return idResultadoAprendizaje;
    }

    public void setIdResultadoAprendizaje(ResultadoAprendizaje idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
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
        hash += (idProgramacionProyecto != null ? idProgramacionProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramacionProyecto)) {
            return false;
        }
        ProgramacionProyecto other = (ProgramacionProyecto) object;
        if ((this.idProgramacionProyecto == null && other.idProgramacionProyecto != null) || (this.idProgramacionProyecto != null && !this.idProgramacionProyecto.equals(other.idProgramacionProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ProgramacionProyecto[ idProgramacionProyecto=" + idProgramacionProyecto + " ]";
    }
    
}
