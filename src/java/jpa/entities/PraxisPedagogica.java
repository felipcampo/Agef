/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADSI
 */
@Entity
@Table(name = "praxis_pedagogica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PraxisPedagogica.findAll", query = "SELECT p FROM PraxisPedagogica p"),
    @NamedQuery(name = "PraxisPedagogica.findByIdPraxisPedagogica", query = "SELECT p FROM PraxisPedagogica p WHERE p.idPraxisPedagogica = :idPraxisPedagogica"),
    @NamedQuery(name = "PraxisPedagogica.findByCumple", query = "SELECT p FROM PraxisPedagogica p WHERE p.cumple = :cumple"),
    @NamedQuery(name = "PraxisPedagogica.findByFecha", query = "SELECT p FROM PraxisPedagogica p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "PraxisPedagogica.findByRevisor", query = "SELECT p FROM PraxisPedagogica p WHERE p.revisor = :revisor")})
public class PraxisPedagogica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_praxis_pedagogica")
    private Integer idPraxisPedagogica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cumple")
    private boolean cumple;
    @Lob
    @Size(max = 65535)
    @Column(name = "des_pra")
    private String desPra;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones")
    private String observaciones;
    @Lob
    @Size(max = 65535)
    @Column(name = "recomendacion")
    private String recomendacion;
    @Size(max = 255)
    @Column(name = "revisor")
    private String revisor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPraxisPedagogica")
    private List<SeguimientoInstructor> seguimientoInstructorList;
    @JoinColumn(name = "id_proyecto_formativo", referencedColumnName = "id_proyecto_formativo")
    @ManyToOne(optional = false)
    private ProyectoFormativo idProyectoFormativo;
    @JoinColumn(name = "id_centro_formativo", referencedColumnName = "id_centro_formacion")
    @ManyToOne(optional = false)
    private CentroFormacion idCentroFormativo;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public PraxisPedagogica() {
    }

    public PraxisPedagogica(Integer idPraxisPedagogica) {
        this.idPraxisPedagogica = idPraxisPedagogica;
    }

    public PraxisPedagogica(Integer idPraxisPedagogica, boolean cumple) {
        this.idPraxisPedagogica = idPraxisPedagogica;
        this.cumple = cumple;
    }

    public Integer getIdPraxisPedagogica() {
        return idPraxisPedagogica;
    }

    public void setIdPraxisPedagogica(Integer idPraxisPedagogica) {
        this.idPraxisPedagogica = idPraxisPedagogica;
    }

    public boolean getCumple() {
        return cumple;
    }

    public void setCumple(boolean cumple) {
        this.cumple = cumple;
    }

    public String getDesPra() {
        return desPra;
    }

    public void setDesPra(String desPra) {
        this.desPra = desPra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @XmlTransient
    public List<SeguimientoInstructor> getSeguimientoInstructorList() {
        return seguimientoInstructorList;
    }

    public void setSeguimientoInstructorList(List<SeguimientoInstructor> seguimientoInstructorList) {
        this.seguimientoInstructorList = seguimientoInstructorList;
    }

    public ProyectoFormativo getIdProyectoFormativo() {
        return idProyectoFormativo;
    }

    public void setIdProyectoFormativo(ProyectoFormativo idProyectoFormativo) {
        this.idProyectoFormativo = idProyectoFormativo;
    }

    public CentroFormacion getIdCentroFormativo() {
        return idCentroFormativo;
    }

    public void setIdCentroFormativo(CentroFormacion idCentroFormativo) {
        this.idCentroFormativo = idCentroFormativo;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPraxisPedagogica != null ? idPraxisPedagogica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PraxisPedagogica)) {
            return false;
        }
        PraxisPedagogica other = (PraxisPedagogica) object;
        if ((this.idPraxisPedagogica == null && other.idPraxisPedagogica != null) || (this.idPraxisPedagogica != null && !this.idPraxisPedagogica.equals(other.idPraxisPedagogica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return desPra + "" + observaciones;
    }
    
}
