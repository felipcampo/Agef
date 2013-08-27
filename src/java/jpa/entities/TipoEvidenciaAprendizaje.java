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
@Table(name = "tipo_evidencia_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEvidenciaAprendizaje.findAll", query = "SELECT t FROM TipoEvidenciaAprendizaje t"),
    @NamedQuery(name = "TipoEvidenciaAprendizaje.findByIdTipoEvidenciaAprendizaje", query = "SELECT t FROM TipoEvidenciaAprendizaje t WHERE t.idTipoEvidenciaAprendizaje = :idTipoEvidenciaAprendizaje"),
    @NamedQuery(name = "TipoEvidenciaAprendizaje.findByDescrTipoEvidencia", query = "SELECT t FROM TipoEvidenciaAprendizaje t WHERE t.descrTipoEvidencia = :descrTipoEvidencia")})
public class TipoEvidenciaAprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_evidencia_aprendizaje")
    private Short idTipoEvidenciaAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "descr_tipo_evidencia")
    private String descrTipoEvidencia;
    @ManyToMany(mappedBy = "tipoEvidenciaAprendizajeList")
    private List<EvidenciaAprendizaje> evidenciaAprendizajeList;

    public TipoEvidenciaAprendizaje() {
    }

    public TipoEvidenciaAprendizaje(Short idTipoEvidenciaAprendizaje) {
        this.idTipoEvidenciaAprendizaje = idTipoEvidenciaAprendizaje;
    }

    public TipoEvidenciaAprendizaje(Short idTipoEvidenciaAprendizaje, String descrTipoEvidencia) {
        this.idTipoEvidenciaAprendizaje = idTipoEvidenciaAprendizaje;
        this.descrTipoEvidencia = descrTipoEvidencia;
    }

    public Short getIdTipoEvidenciaAprendizaje() {
        return idTipoEvidenciaAprendizaje;
    }

    public void setIdTipoEvidenciaAprendizaje(Short idTipoEvidenciaAprendizaje) {
        this.idTipoEvidenciaAprendizaje = idTipoEvidenciaAprendizaje;
    }

    public String getDescrTipoEvidencia() {
        return descrTipoEvidencia;
    }

    public void setDescrTipoEvidencia(String descrTipoEvidencia) {
        this.descrTipoEvidencia = descrTipoEvidencia;
    }

    @XmlTransient
    public List<EvidenciaAprendizaje> getEvidenciaAprendizajeList() {
        return evidenciaAprendizajeList;
    }

    public void setEvidenciaAprendizajeList(List<EvidenciaAprendizaje> evidenciaAprendizajeList) {
        this.evidenciaAprendizajeList = evidenciaAprendizajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEvidenciaAprendizaje != null ? idTipoEvidenciaAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEvidenciaAprendizaje)) {
            return false;
        }
        TipoEvidenciaAprendizaje other = (TipoEvidenciaAprendizaje) object;
        if ((this.idTipoEvidenciaAprendizaje == null && other.idTipoEvidenciaAprendizaje != null) || (this.idTipoEvidenciaAprendizaje != null && !this.idTipoEvidenciaAprendizaje.equals(other.idTipoEvidenciaAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TipoEvidenciaAprendizaje[ idTipoEvidenciaAprendizaje=" + idTipoEvidenciaAprendizaje + " ]";
    }
    
}
