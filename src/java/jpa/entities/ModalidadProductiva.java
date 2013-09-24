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
import javax.persistence.Lob;
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
 * @author ADSI
 */
@Entity
@Table(name = "modalidad_productiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModalidadProductiva.findAll", query = "SELECT m FROM ModalidadProductiva m"),
    @NamedQuery(name = "ModalidadProductiva.findByIdModalidadProductiva", query = "SELECT m FROM ModalidadProductiva m WHERE m.idModalidadProductiva = :idModalidadProductiva"),
    @NamedQuery(name = "ModalidadProductiva.findByDetalleMododalidad", query = "SELECT m FROM ModalidadProductiva m WHERE m.detalleMododalidad = :detalleMododalidad"),
    @NamedQuery(name = "ModalidadProductiva.findByDuracionMod", query = "SELECT m FROM ModalidadProductiva m WHERE m.duracionMod = :duracionMod")})
public class ModalidadProductiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_modalidad_productiva")
    private Integer idModalidadProductiva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "detalle_mododalidad")
    private String detalleMododalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion_mod")
    private int duracionMod;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "informacion_requisitos")
    private String informacionRequisitos;
    @JoinColumn(name = "id_contrato_proyecto", referencedColumnName = "id_contrato_proyecto")
    @ManyToOne
    private ContratoProyecto idContratoProyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModalidadProductiva")
    private List<SeguimientoProductiva> seguimientoProductivaList;

    public ModalidadProductiva() {
    }

    public ModalidadProductiva(Integer idModalidadProductiva) {
        this.idModalidadProductiva = idModalidadProductiva;
    }

    public ModalidadProductiva(Integer idModalidadProductiva, String detalleMododalidad, int duracionMod, String informacionRequisitos) {
        this.idModalidadProductiva = idModalidadProductiva;
        this.detalleMododalidad = detalleMododalidad;
        this.duracionMod = duracionMod;
        this.informacionRequisitos = informacionRequisitos;
    }

    public Integer getIdModalidadProductiva() {
        return idModalidadProductiva;
    }

    public void setIdModalidadProductiva(Integer idModalidadProductiva) {
        this.idModalidadProductiva = idModalidadProductiva;
    }

    public String getDetalleMododalidad() {
        return detalleMododalidad;
    }

    public void setDetalleMododalidad(String detalleMododalidad) {
        this.detalleMododalidad = detalleMododalidad;
    }

    public int getDuracionMod() {
        return duracionMod;
    }

    public void setDuracionMod(int duracionMod) {
        this.duracionMod = duracionMod;
    }

    public String getInformacionRequisitos() {
        return informacionRequisitos;
    }

    public void setInformacionRequisitos(String informacionRequisitos) {
        this.informacionRequisitos = informacionRequisitos;
    }

    public ContratoProyecto getIdContratoProyecto() {
        return idContratoProyecto;
    }

    public void setIdContratoProyecto(ContratoProyecto idContratoProyecto) {
        this.idContratoProyecto = idContratoProyecto;
    }

    @XmlTransient
    public List<SeguimientoProductiva> getSeguimientoProductivaList() {
        return seguimientoProductivaList;
    }

    public void setSeguimientoProductivaList(List<SeguimientoProductiva> seguimientoProductivaList) {
        this.seguimientoProductivaList = seguimientoProductivaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModalidadProductiva != null ? idModalidadProductiva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModalidadProductiva)) {
            return false;
        }
        ModalidadProductiva other = (ModalidadProductiva) object;
        if ((this.idModalidadProductiva == null && other.idModalidadProductiva != null) || (this.idModalidadProductiva != null && !this.idModalidadProductiva.equals(other.idModalidadProductiva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ModalidadProductiva[ idModalidadProductiva=" + idModalidadProductiva + " ]";
    }
    
}
