/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MAURICIO
 */
@Entity
@Table(name = "criterio_seguimiento_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriterioSeguimientoProyecto.findAll", query = "SELECT c FROM CriterioSeguimientoProyecto c"),
    @NamedQuery(name = "CriterioSeguimientoProyecto.findByIdCriterioSeguimientoProyecto", query = "SELECT c FROM CriterioSeguimientoProyecto c WHERE c.idCriterioSeguimientoProyecto = :idCriterioSeguimientoProyecto")})
public class CriterioSeguimientoProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_criterio_seguimiento_proyecto")
    private Short idCriterioSeguimientoProyecto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "obs_cri_seg")
    private String obsCriSeg;
    @JoinColumn(name = "id_tipo_juicio", referencedColumnName = "id_tipo_juicio")
    @ManyToOne(optional = false)
    private TipoJuicio idTipoJuicio;
    @JoinColumn(name = "id_seguimiento_proyecto", referencedColumnName = "id_seguimiento_proyecto")
    @ManyToOne(optional = false)
    private SeguimientoProyecto idSeguimientoProyecto;
    @JoinColumn(name = "id_grado_juicio", referencedColumnName = "id_grado_juicio")
    @ManyToOne(optional = false)
    private GradoJuicio idGradoJuicio;
    @JoinColumn(name = "id_estado_juicio", referencedColumnName = "id_estado_juicio")
    @ManyToOne(optional = false)
    private EstadoJuicio idEstadoJuicio;
    @JoinColumn(name = "id_criterio_evaluacion", referencedColumnName = "id_criterio_evaluacion")
    @ManyToOne(optional = false)
    private CriterioEvaluacion idCriterioEvaluacion;
    @JoinColumn(name = "id_evaluacion_criterio_seguimiento_proyecto", referencedColumnName = "id_evaluacion_criterio_seguimiento_proyecto")
    @ManyToOne(optional = false)
    private EvaluacionCriterioSeguimientoProyecto idEvaluacionCriterioSeguimientoProyecto;

    public CriterioSeguimientoProyecto() {
    }

    public CriterioSeguimientoProyecto(Short idCriterioSeguimientoProyecto) {
        this.idCriterioSeguimientoProyecto = idCriterioSeguimientoProyecto;
    }

    public CriterioSeguimientoProyecto(Short idCriterioSeguimientoProyecto, String obsCriSeg) {
        this.idCriterioSeguimientoProyecto = idCriterioSeguimientoProyecto;
        this.obsCriSeg = obsCriSeg;
    }

    public Short getIdCriterioSeguimientoProyecto() {
        return idCriterioSeguimientoProyecto;
    }

    public void setIdCriterioSeguimientoProyecto(Short idCriterioSeguimientoProyecto) {
        this.idCriterioSeguimientoProyecto = idCriterioSeguimientoProyecto;
    }

    public String getObsCriSeg() {
        return obsCriSeg;
    }

    public void setObsCriSeg(String obsCriSeg) {
        this.obsCriSeg = obsCriSeg;
    }

    public TipoJuicio getIdTipoJuicio() {
        return idTipoJuicio;
    }

    public void setIdTipoJuicio(TipoJuicio idTipoJuicio) {
        this.idTipoJuicio = idTipoJuicio;
    }

    public SeguimientoProyecto getIdSeguimientoProyecto() {
        return idSeguimientoProyecto;
    }

    public void setIdSeguimientoProyecto(SeguimientoProyecto idSeguimientoProyecto) {
        this.idSeguimientoProyecto = idSeguimientoProyecto;
    }

    public GradoJuicio getIdGradoJuicio() {
        return idGradoJuicio;
    }

    public void setIdGradoJuicio(GradoJuicio idGradoJuicio) {
        this.idGradoJuicio = idGradoJuicio;
    }

    public EstadoJuicio getIdEstadoJuicio() {
        return idEstadoJuicio;
    }

    public void setIdEstadoJuicio(EstadoJuicio idEstadoJuicio) {
        this.idEstadoJuicio = idEstadoJuicio;
    }

    public CriterioEvaluacion getIdCriterioEvaluacion() {
        return idCriterioEvaluacion;
    }

    public void setIdCriterioEvaluacion(CriterioEvaluacion idCriterioEvaluacion) {
        this.idCriterioEvaluacion = idCriterioEvaluacion;
    }

    public EvaluacionCriterioSeguimientoProyecto getIdEvaluacionCriterioSeguimientoProyecto() {
        return idEvaluacionCriterioSeguimientoProyecto;
    }

    public void setIdEvaluacionCriterioSeguimientoProyecto(EvaluacionCriterioSeguimientoProyecto idEvaluacionCriterioSeguimientoProyecto) {
        this.idEvaluacionCriterioSeguimientoProyecto = idEvaluacionCriterioSeguimientoProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCriterioSeguimientoProyecto != null ? idCriterioSeguimientoProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriterioSeguimientoProyecto)) {
            return false;
        }
        CriterioSeguimientoProyecto other = (CriterioSeguimientoProyecto) object;
        if ((this.idCriterioSeguimientoProyecto == null && other.idCriterioSeguimientoProyecto != null) || (this.idCriterioSeguimientoProyecto != null && !this.idCriterioSeguimientoProyecto.equals(other.idCriterioSeguimientoProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.CriterioSeguimientoProyecto[ idCriterioSeguimientoProyecto=" + idCriterioSeguimientoProyecto + " ]";
    }
    
}
