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
import javax.persistence.Lob;
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
@Table(name = "lista_verificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaVerificacion.findAll", query = "SELECT l FROM ListaVerificacion l"),
    @NamedQuery(name = "ListaVerificacion.findByIdListaVerificacion", query = "SELECT l FROM ListaVerificacion l WHERE l.idListaVerificacion = :idListaVerificacion"),
    @NamedQuery(name = "ListaVerificacion.findByCumplimiento", query = "SELECT l FROM ListaVerificacion l WHERE l.cumplimiento = :cumplimiento")})
public class ListaVerificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lista_verificacion")
    private Integer idListaVerificacion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "variables_indicadores")
    private String variablesIndicadores;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cumplimiento")
    private boolean cumplimiento;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idListaVerificacion")
    private List<VerificacionAmbienteTitulado> verificacionAmbienteTituladoList;

    public ListaVerificacion() {
    }

    public ListaVerificacion(Integer idListaVerificacion) {
        this.idListaVerificacion = idListaVerificacion;
    }

    public ListaVerificacion(Integer idListaVerificacion, String variablesIndicadores, boolean cumplimiento, String observaciones) {
        this.idListaVerificacion = idListaVerificacion;
        this.variablesIndicadores = variablesIndicadores;
        this.cumplimiento = cumplimiento;
        this.observaciones = observaciones;
    }

    public Integer getIdListaVerificacion() {
        return idListaVerificacion;
    }

    public void setIdListaVerificacion(Integer idListaVerificacion) {
        this.idListaVerificacion = idListaVerificacion;
    }

    public String getVariablesIndicadores() {
        return variablesIndicadores;
    }

    public void setVariablesIndicadores(String variablesIndicadores) {
        this.variablesIndicadores = variablesIndicadores;
    }

    public boolean getCumplimiento() {
        return cumplimiento;
    }

    public void setCumplimiento(boolean cumplimiento) {
        this.cumplimiento = cumplimiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<VerificacionAmbienteTitulado> getVerificacionAmbienteTituladoList() {
        return verificacionAmbienteTituladoList;
    }

    public void setVerificacionAmbienteTituladoList(List<VerificacionAmbienteTitulado> verificacionAmbienteTituladoList) {
        this.verificacionAmbienteTituladoList = verificacionAmbienteTituladoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idListaVerificacion != null ? idListaVerificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaVerificacion)) {
            return false;
        }
        ListaVerificacion other = (ListaVerificacion) object;
        if ((this.idListaVerificacion == null && other.idListaVerificacion != null) || (this.idListaVerificacion != null && !this.idListaVerificacion.equals(other.idListaVerificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ListaVerificacion[ idListaVerificacion=" + idListaVerificacion + " ]";
    }
    
}
