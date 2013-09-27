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
@Table(name = "caracterizacion_poblacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CaracterizacionPoblacion.findAll", query = "SELECT c FROM CaracterizacionPoblacion c"),
    @NamedQuery(name = "CaracterizacionPoblacion.findByIdCaracterizacionPoblacion", query = "SELECT c FROM CaracterizacionPoblacion c WHERE c.idCaracterizacionPoblacion = :idCaracterizacionPoblacion"),
    @NamedQuery(name = "CaracterizacionPoblacion.findByNomCarPob", query = "SELECT c FROM CaracterizacionPoblacion c WHERE c.nomCarPob = :nomCarPob")})
public class CaracterizacionPoblacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_caracterizacion_poblacion")
    private Short idCaracterizacionPoblacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_car_pob")
    private String nomCarPob;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCaracterizacionPoblacion")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public CaracterizacionPoblacion() {
    }

    public CaracterizacionPoblacion(Short idCaracterizacionPoblacion) {
        this.idCaracterizacionPoblacion = idCaracterizacionPoblacion;
    }

    public CaracterizacionPoblacion(Short idCaracterizacionPoblacion, String nomCarPob) {
        this.idCaracterizacionPoblacion = idCaracterizacionPoblacion;
        this.nomCarPob = nomCarPob;
    }

    public Short getIdCaracterizacionPoblacion() {
        return idCaracterizacionPoblacion;
    }

    public void setIdCaracterizacionPoblacion(Short idCaracterizacionPoblacion) {
        this.idCaracterizacionPoblacion = idCaracterizacionPoblacion;
    }

    public String getNomCarPob() {
        return nomCarPob;
    }

    public void setNomCarPob(String nomCarPob) {
        this.nomCarPob = nomCarPob;
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
        hash += (idCaracterizacionPoblacion != null ? idCaracterizacionPoblacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaracterizacionPoblacion)) {
            return false;
        }
        CaracterizacionPoblacion other = (CaracterizacionPoblacion) object;
        if ((this.idCaracterizacionPoblacion == null && other.idCaracterizacionPoblacion != null) || (this.idCaracterizacionPoblacion != null && !this.idCaracterizacionPoblacion.equals(other.idCaracterizacionPoblacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.CaracterizacionPoblacion[ idCaracterizacionPoblacion=" + idCaracterizacionPoblacion + " ]";
    }
    
}
