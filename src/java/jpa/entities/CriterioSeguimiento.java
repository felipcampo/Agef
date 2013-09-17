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
 * @author ADSI
 */
@Entity
@Table(name = "criterio_seguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriterioSeguimiento.findAll", query = "SELECT c FROM CriterioSeguimiento c"),
    @NamedQuery(name = "CriterioSeguimiento.findByIdCriterioSeguimiento", query = "SELECT c FROM CriterioSeguimiento c WHERE c.idCriterioSeguimiento = :idCriterioSeguimiento"),
    @NamedQuery(name = "CriterioSeguimiento.findByValCep", query = "SELECT c FROM CriterioSeguimiento c WHERE c.valCep = :valCep"),
    @NamedQuery(name = "CriterioSeguimiento.findByIdSeguimientoProductiva", query = "SELECT c FROM CriterioSeguimiento c WHERE c.idSeguimientoProductiva = :idSeguimientoProductiva")})
public class CriterioSeguimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_criterio_seguimiento")
    private Integer idCriterioSeguimiento;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "obs_cep")
    private String obsCep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "val_cep")
    private boolean valCep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_seguimiento_productiva")
    private String idSeguimientoProductiva;
    @JoinColumn(name = "id_criterio_evaluacion", referencedColumnName = "id_criterio_evaluacion")
    @ManyToOne(optional = false)
    private CriterioEvaluacion idCriterioEvaluacion;

    public CriterioSeguimiento() {
    }

    public CriterioSeguimiento(Integer idCriterioSeguimiento) {
        this.idCriterioSeguimiento = idCriterioSeguimiento;
    }

    public CriterioSeguimiento(Integer idCriterioSeguimiento, String obsCep, boolean valCep, String idSeguimientoProductiva) {
        this.idCriterioSeguimiento = idCriterioSeguimiento;
        this.obsCep = obsCep;
        this.valCep = valCep;
        this.idSeguimientoProductiva = idSeguimientoProductiva;
    }

    public Integer getIdCriterioSeguimiento() {
        return idCriterioSeguimiento;
    }

    public void setIdCriterioSeguimiento(Integer idCriterioSeguimiento) {
        this.idCriterioSeguimiento = idCriterioSeguimiento;
    }

    public String getObsCep() {
        return obsCep;
    }

    public void setObsCep(String obsCep) {
        this.obsCep = obsCep;
    }

    public boolean getValCep() {
        return valCep;
    }

    public void setValCep(boolean valCep) {
        this.valCep = valCep;
    }

    public String getIdSeguimientoProductiva() {
        return idSeguimientoProductiva;
    }

    public void setIdSeguimientoProductiva(String idSeguimientoProductiva) {
        this.idSeguimientoProductiva = idSeguimientoProductiva;
    }

    public CriterioEvaluacion getIdCriterioEvaluacion() {
        return idCriterioEvaluacion;
    }

    public void setIdCriterioEvaluacion(CriterioEvaluacion idCriterioEvaluacion) {
        this.idCriterioEvaluacion = idCriterioEvaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCriterioSeguimiento != null ? idCriterioSeguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriterioSeguimiento)) {
            return false;
        }
        CriterioSeguimiento other = (CriterioSeguimiento) object;
        if ((this.idCriterioSeguimiento == null && other.idCriterioSeguimiento != null) || (this.idCriterioSeguimiento != null && !this.idCriterioSeguimiento.equals(other.idCriterioSeguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.CriterioSeguimiento[ idCriterioSeguimiento=" + idCriterioSeguimiento + " ]";
    }
    
}
