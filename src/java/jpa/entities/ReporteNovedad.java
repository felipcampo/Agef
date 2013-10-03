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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MAURICIO
 */
@Entity
@Table(name = "reporte_novedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteNovedad.findAll", query = "SELECT r FROM ReporteNovedad r"),
    @NamedQuery(name = "ReporteNovedad.findByIdReporteNovedad", query = "SELECT r FROM ReporteNovedad r WHERE r.idReporteNovedad = :idReporteNovedad"),
    @NamedQuery(name = "ReporteNovedad.findByConAccCor", query = "SELECT r FROM ReporteNovedad r WHERE r.conAccCor = :conAccCor"),
    @NamedQuery(name = "ReporteNovedad.findByFecRep", query = "SELECT r FROM ReporteNovedad r WHERE r.fecRep = :fecRep"),
    @NamedQuery(name = "ReporteNovedad.findByFecUltPlaMej", query = "SELECT r FROM ReporteNovedad r WHERE r.fecUltPlaMej = :fecUltPlaMej"),
    @NamedQuery(name = "ReporteNovedad.findByNumAccCor", query = "SELECT r FROM ReporteNovedad r WHERE r.numAccCor = :numAccCor"),
    @NamedQuery(name = "ReporteNovedad.findByFechaHecho", query = "SELECT r FROM ReporteNovedad r WHERE r.fechaHecho = :fechaHecho")})
public class ReporteNovedad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reporte_novedad")
    private Integer idReporteNovedad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "con_acc_cor")
    private int conAccCor;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "des_ant")
    private String desAnt;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "des_fal")
    private String desFal;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "des_pru")
    private String desPru;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_rep")
    @Temporal(TemporalType.DATE)
    private Date fecRep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_ult_pla_mej")
    @Temporal(TemporalType.DATE)
    private Date fecUltPlaMej;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "hechos")
    private String hechos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_acc_cor")
    private int numAccCor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hecho")
    @Temporal(TemporalType.DATE)
    private Date fechaHecho;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "testigos_pruebas")
    private String testigosPruebas;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id_resultado_aprendizaje")
    @ManyToOne(optional = false)
    private ResultadoAprendizaje idResultadoAprendizaje;
    @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")
    @ManyToOne(optional = false)
    private FichaCaracterizacion idFichaCaracterizacion;
    @JoinColumn(name = "id_desercion", referencedColumnName = "id_desercion")
    @ManyToOne(optional = false)
    private Desercion idDesercion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReporteNovedad")
    private List<Comite> comiteList;

    public ReporteNovedad() {
    }

    public ReporteNovedad(Integer idReporteNovedad) {
        this.idReporteNovedad = idReporteNovedad;
    }

    public ReporteNovedad(Integer idReporteNovedad, int conAccCor, String desAnt, String desFal, String desPru, Date fecRep, Date fecUltPlaMej, String hechos, int numAccCor, Date fechaHecho, String testigosPruebas) {
        this.idReporteNovedad = idReporteNovedad;
        this.conAccCor = conAccCor;
        this.desAnt = desAnt;
        this.desFal = desFal;
        this.desPru = desPru;
        this.fecRep = fecRep;
        this.fecUltPlaMej = fecUltPlaMej;
        this.hechos = hechos;
        this.numAccCor = numAccCor;
        this.fechaHecho = fechaHecho;
        this.testigosPruebas = testigosPruebas;
    }

    public Integer getIdReporteNovedad() {
        return idReporteNovedad;
    }

    public void setIdReporteNovedad(Integer idReporteNovedad) {
        this.idReporteNovedad = idReporteNovedad;
    }

    public int getConAccCor() {
        return conAccCor;
    }

    public void setConAccCor(int conAccCor) {
        this.conAccCor = conAccCor;
    }

    public String getDesAnt() {
        return desAnt;
    }

    public void setDesAnt(String desAnt) {
        this.desAnt = desAnt;
    }

    public String getDesFal() {
        return desFal;
    }

    public void setDesFal(String desFal) {
        this.desFal = desFal;
    }

    public String getDesPru() {
        return desPru;
    }

    public void setDesPru(String desPru) {
        this.desPru = desPru;
    }

    public Date getFecRep() {
        return fecRep;
    }

    public void setFecRep(Date fecRep) {
        this.fecRep = fecRep;
    }

    public Date getFecUltPlaMej() {
        return fecUltPlaMej;
    }

    public void setFecUltPlaMej(Date fecUltPlaMej) {
        this.fecUltPlaMej = fecUltPlaMej;
    }

    public String getHechos() {
        return hechos;
    }

    public void setHechos(String hechos) {
        this.hechos = hechos;
    }

    public int getNumAccCor() {
        return numAccCor;
    }

    public void setNumAccCor(int numAccCor) {
        this.numAccCor = numAccCor;
    }

    public Date getFechaHecho() {
        return fechaHecho;
    }

    public void setFechaHecho(Date fechaHecho) {
        this.fechaHecho = fechaHecho;
    }

    public String getTestigosPruebas() {
        return testigosPruebas;
    }

    public void setTestigosPruebas(String testigosPruebas) {
        this.testigosPruebas = testigosPruebas;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ResultadoAprendizaje getIdResultadoAprendizaje() {
        return idResultadoAprendizaje;
    }

    public void setIdResultadoAprendizaje(ResultadoAprendizaje idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }

    public FichaCaracterizacion getIdFichaCaracterizacion() {
        return idFichaCaracterizacion;
    }

    public void setIdFichaCaracterizacion(FichaCaracterizacion idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    public Desercion getIdDesercion() {
        return idDesercion;
    }

    public void setIdDesercion(Desercion idDesercion) {
        this.idDesercion = idDesercion;
    }

    @XmlTransient
    public List<Comite> getComiteList() {
        return comiteList;
    }

    public void setComiteList(List<Comite> comiteList) {
        this.comiteList = comiteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReporteNovedad != null ? idReporteNovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReporteNovedad)) {
            return false;
        }
        ReporteNovedad other = (ReporteNovedad) object;
        if ((this.idReporteNovedad == null && other.idReporteNovedad != null) || (this.idReporteNovedad != null && !this.idReporteNovedad.equals(other.idReporteNovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ReporteNovedad[ idReporteNovedad=" + idReporteNovedad + " ]";
    }
    
}
