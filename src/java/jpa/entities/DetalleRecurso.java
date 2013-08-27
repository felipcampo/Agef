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
 * @author leoandresm
 */
@Entity
@Table(name = "detalle_recurso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleRecurso.findAll", query = "SELECT d FROM DetalleRecurso d"),
    @NamedQuery(name = "DetalleRecurso.findByIdDatalleRecurso", query = "SELECT d FROM DetalleRecurso d WHERE d.idDatalleRecurso = :idDatalleRecurso"),
    @NamedQuery(name = "DetalleRecurso.findByNombHerrEquiMate", query = "SELECT d FROM DetalleRecurso d WHERE d.nombHerrEquiMate = :nombHerrEquiMate"),
    @NamedQuery(name = "DetalleRecurso.findByUnidadMedida", query = "SELECT d FROM DetalleRecurso d WHERE d.unidadMedida = :unidadMedida"),
    @NamedQuery(name = "DetalleRecurso.findByCantidad", query = "SELECT d FROM DetalleRecurso d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleRecurso.findByValorUnitario", query = "SELECT d FROM DetalleRecurso d WHERE d.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "DetalleRecurso.findByValorTotal", query = "SELECT d FROM DetalleRecurso d WHERE d.valorTotal = :valorTotal"),
    @NamedQuery(name = "DetalleRecurso.findByFuenteRecurso", query = "SELECT d FROM DetalleRecurso d WHERE d.fuenteRecurso = :fuenteRecurso"),
    @NamedQuery(name = "DetalleRecurso.findByRubroProsupuestal", query = "SELECT d FROM DetalleRecurso d WHERE d.rubroProsupuestal = :rubroProsupuestal")})
public class DetalleRecurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_datalle_recurso")
    private Integer idDatalleRecurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nomb_herr_equi_mate")
    private String nombHerrEquiMate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_unitario")
    private int valorUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_total")
    private int valorTotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "fuente_recurso")
    private String fuenteRecurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rubro_prosupuestal")
    private String rubroProsupuestal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDatalleRecurso")
    private List<GuiaAprendizaje> guiaAprendizajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDatalleRecurso")
    private List<ProyectoFormativo> proyectoFormativoList;

    public DetalleRecurso() {
    }

    public DetalleRecurso(Integer idDatalleRecurso) {
        this.idDatalleRecurso = idDatalleRecurso;
    }

    public DetalleRecurso(Integer idDatalleRecurso, String nombHerrEquiMate, String unidadMedida, int cantidad, int valorUnitario, int valorTotal, String fuenteRecurso, String rubroProsupuestal) {
        this.idDatalleRecurso = idDatalleRecurso;
        this.nombHerrEquiMate = nombHerrEquiMate;
        this.unidadMedida = unidadMedida;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.fuenteRecurso = fuenteRecurso;
        this.rubroProsupuestal = rubroProsupuestal;
    }

    public Integer getIdDatalleRecurso() {
        return idDatalleRecurso;
    }

    public void setIdDatalleRecurso(Integer idDatalleRecurso) {
        this.idDatalleRecurso = idDatalleRecurso;
    }

    public String getNombHerrEquiMate() {
        return nombHerrEquiMate;
    }

    public void setNombHerrEquiMate(String nombHerrEquiMate) {
        this.nombHerrEquiMate = nombHerrEquiMate;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFuenteRecurso() {
        return fuenteRecurso;
    }

    public void setFuenteRecurso(String fuenteRecurso) {
        this.fuenteRecurso = fuenteRecurso;
    }

    public String getRubroProsupuestal() {
        return rubroProsupuestal;
    }

    public void setRubroProsupuestal(String rubroProsupuestal) {
        this.rubroProsupuestal = rubroProsupuestal;
    }

    @XmlTransient
    public List<GuiaAprendizaje> getGuiaAprendizajeList() {
        return guiaAprendizajeList;
    }

    public void setGuiaAprendizajeList(List<GuiaAprendizaje> guiaAprendizajeList) {
        this.guiaAprendizajeList = guiaAprendizajeList;
    }

    @XmlTransient
    public List<ProyectoFormativo> getProyectoFormativoList() {
        return proyectoFormativoList;
    }

    public void setProyectoFormativoList(List<ProyectoFormativo> proyectoFormativoList) {
        this.proyectoFormativoList = proyectoFormativoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDatalleRecurso != null ? idDatalleRecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleRecurso)) {
            return false;
        }
        DetalleRecurso other = (DetalleRecurso) object;
        if ((this.idDatalleRecurso == null && other.idDatalleRecurso != null) || (this.idDatalleRecurso != null && !this.idDatalleRecurso.equals(other.idDatalleRecurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.DetalleRecurso[ idDatalleRecurso=" + idDatalleRecurso + " ]";
    }
    
}
