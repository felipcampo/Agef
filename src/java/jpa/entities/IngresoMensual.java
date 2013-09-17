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
 * @author ADSI
 */
@Entity
@Table(name = "ingreso_mensual")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngresoMensual.findAll", query = "SELECT i FROM IngresoMensual i"),
    @NamedQuery(name = "IngresoMensual.findByIdIngresoMensual", query = "SELECT i FROM IngresoMensual i WHERE i.idIngresoMensual = :idIngresoMensual"),
    @NamedQuery(name = "IngresoMensual.findByDescrIngresoMensualcol", query = "SELECT i FROM IngresoMensual i WHERE i.descrIngresoMensualcol = :descrIngresoMensualcol")})
public class IngresoMensual implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ingreso_mensual")
    private Short idIngresoMensual;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descr_ingreso_mensualcol")
    private String descrIngresoMensualcol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIngresoMensual")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public IngresoMensual() {
    }

    public IngresoMensual(Short idIngresoMensual) {
        this.idIngresoMensual = idIngresoMensual;
    }

    public IngresoMensual(Short idIngresoMensual, String descrIngresoMensualcol) {
        this.idIngresoMensual = idIngresoMensual;
        this.descrIngresoMensualcol = descrIngresoMensualcol;
    }

    public Short getIdIngresoMensual() {
        return idIngresoMensual;
    }

    public void setIdIngresoMensual(Short idIngresoMensual) {
        this.idIngresoMensual = idIngresoMensual;
    }

    public String getDescrIngresoMensualcol() {
        return descrIngresoMensualcol;
    }

    public void setDescrIngresoMensualcol(String descrIngresoMensualcol) {
        this.descrIngresoMensualcol = descrIngresoMensualcol;
    }

    @XmlTransient
    public List<MatrizCaracterizacion> getMatrizCaracterizacionList() {
        return matrizCaracterizacionList;
    }

    public void setMatrizCaracterizacionList(List<MatrizCaracterizacion> matrizCaracterizacionList) {
        this.matrizCaracterizacionList = matrizCaracterizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngresoMensual != null ? idIngresoMensual.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoMensual)) {
            return false;
        }
        IngresoMensual other = (IngresoMensual) object;
        if ((this.idIngresoMensual == null && other.idIngresoMensual != null) || (this.idIngresoMensual != null && !this.idIngresoMensual.equals(other.idIngresoMensual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.IngresoMensual[ idIngresoMensual=" + idIngresoMensual + " ]";
    }
    
}
