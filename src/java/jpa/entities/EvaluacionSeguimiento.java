/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "evaluacion_seguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvaluacionSeguimiento.findAll", query = "SELECT e FROM EvaluacionSeguimiento e"),
    @NamedQuery(name = "EvaluacionSeguimiento.findByIdEvaluacionSeguimiento", query = "SELECT e FROM EvaluacionSeguimiento e WHERE e.idEvaluacionSeguimiento = :idEvaluacionSeguimiento"),
    @NamedQuery(name = "EvaluacionSeguimiento.findByAprendizaje", query = "SELECT e FROM EvaluacionSeguimiento e WHERE e.aprendizaje = :aprendizaje"),
    @NamedQuery(name = "EvaluacionSeguimiento.findByAutenticidad", query = "SELECT e FROM EvaluacionSeguimiento e WHERE e.autenticidad = :autenticidad"),
    @NamedQuery(name = "EvaluacionSeguimiento.findByCalidad", query = "SELECT e FROM EvaluacionSeguimiento e WHERE e.calidad = :calidad"),
    @NamedQuery(name = "EvaluacionSeguimiento.findByFecIni", query = "SELECT e FROM EvaluacionSeguimiento e WHERE e.fecIni = :fecIni"),
    @NamedQuery(name = "EvaluacionSeguimiento.findByFecFin", query = "SELECT e FROM EvaluacionSeguimiento e WHERE e.fecFin = :fecFin"),
    @NamedQuery(name = "EvaluacionSeguimiento.findByFecRecEvi", query = "SELECT e FROM EvaluacionSeguimiento e WHERE e.fecRecEvi = :fecRecEvi"),
    @NamedQuery(name = "EvaluacionSeguimiento.findByMedio", query = "SELECT e FROM EvaluacionSeguimiento e WHERE e.medio = :medio"),
    @NamedQuery(name = "EvaluacionSeguimiento.findByPertinencia", query = "SELECT e FROM EvaluacionSeguimiento e WHERE e.pertinencia = :pertinencia"),
    @NamedQuery(name = "EvaluacionSeguimiento.findByVigencia", query = "SELECT e FROM EvaluacionSeguimiento e WHERE e.vigencia = :vigencia")})
public class EvaluacionSeguimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_evaluacion_seguimiento")
    private Integer idEvaluacionSeguimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aprendizaje")
    private boolean aprendizaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autenticidad")
    private boolean autenticidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calidad")
    private boolean calidad;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "car_apr")
    private String carApr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_ini")
    @Temporal(TemporalType.DATE)
    private Date fecIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_fin")
    @Temporal(TemporalType.DATE)
    private Date fecFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_rec_evi")
    @Temporal(TemporalType.DATE)
    private Date fecRecEvi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "medio")
    private String medio;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pertinencia")
    private boolean pertinencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vigencia")
    private boolean vigencia;
    @JoinColumn(name = "id_medios", referencedColumnName = "id_medios")
    @ManyToOne(optional = false)
    private Medios idMedios;
    @JoinColumn(name = "id_guia_aprendizaje", referencedColumnName = "id_guia_aprendizaje")
    @ManyToOne(optional = false)
    private GuiaAprendizaje idGuiaAprendizaje;
    @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id_resultado_aprendizaje")
    @ManyToOne(optional = false)
    private ResultadoAprendizaje idResultadoAprendizaje;
    @JoinColumn(name = "id_evidencia_aprendizaje", referencedColumnName = "id_evidencia_aprendizaje")
    @ManyToOne(optional = false)
    private EvidenciaAprendizaje idEvidenciaAprendizaje;
    @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")
    @ManyToOne(optional = false)
    private FichaCaracterizacion idFichaCaracterizacion;
    @JoinColumn(name = "id_usuario1", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario1;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(mappedBy = "idEvaluacionSeguimiento")
    private List<Alistamiento> alistamientoList;

    public EvaluacionSeguimiento() {
    }

    public EvaluacionSeguimiento(Integer idEvaluacionSeguimiento) {
        this.idEvaluacionSeguimiento = idEvaluacionSeguimiento;
    }

    public EvaluacionSeguimiento(Integer idEvaluacionSeguimiento, boolean aprendizaje, boolean autenticidad, boolean calidad, String carApr, Date fecIni, Date fecFin, Date fecRecEvi, String medio, boolean pertinencia, boolean vigencia) {
        this.idEvaluacionSeguimiento = idEvaluacionSeguimiento;
        this.aprendizaje = aprendizaje;
        this.autenticidad = autenticidad;
        this.calidad = calidad;
        this.carApr = carApr;
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.fecRecEvi = fecRecEvi;
        this.medio = medio;
        this.pertinencia = pertinencia;
        this.vigencia = vigencia;
    }

    public Integer getIdEvaluacionSeguimiento() {
        return idEvaluacionSeguimiento;
    }

    public void setIdEvaluacionSeguimiento(Integer idEvaluacionSeguimiento) {
        this.idEvaluacionSeguimiento = idEvaluacionSeguimiento;
    }

    public boolean getAprendizaje() {
        return aprendizaje;
    }

    public void setAprendizaje(boolean aprendizaje) {
        this.aprendizaje = aprendizaje;
    }

    public boolean getAutenticidad() {
        return autenticidad;
    }

    public void setAutenticidad(boolean autenticidad) {
        this.autenticidad = autenticidad;
    }

    public boolean getCalidad() {
        return calidad;
    }

    public void setCalidad(boolean calidad) {
        this.calidad = calidad;
    }

    public String getCarApr() {
        return carApr;
    }

    public void setCarApr(String carApr) {
        this.carApr = carApr;
    }

    public Date getFecIni() {
        return fecIni;
    }

    public void setFecIni(Date fecIni) {
        this.fecIni = fecIni;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public Date getFecRecEvi() {
        return fecRecEvi;
    }

    public void setFecRecEvi(Date fecRecEvi) {
        this.fecRecEvi = fecRecEvi;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean getPertinencia() {
        return pertinencia;
    }

    public void setPertinencia(boolean pertinencia) {
        this.pertinencia = pertinencia;
    }

    public boolean getVigencia() {
        return vigencia;
    }

    public void setVigencia(boolean vigencia) {
        this.vigencia = vigencia;
    }

    public Medios getIdMedios() {
        return idMedios;
    }

    public void setIdMedios(Medios idMedios) {
        this.idMedios = idMedios;
    }

    public GuiaAprendizaje getIdGuiaAprendizaje() {
        return idGuiaAprendizaje;
    }

    public void setIdGuiaAprendizaje(GuiaAprendizaje idGuiaAprendizaje) {
        this.idGuiaAprendizaje = idGuiaAprendizaje;
    }

    public ResultadoAprendizaje getIdResultadoAprendizaje() {
        return idResultadoAprendizaje;
    }

    public void setIdResultadoAprendizaje(ResultadoAprendizaje idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }

    public EvidenciaAprendizaje getIdEvidenciaAprendizaje() {
        return idEvidenciaAprendizaje;
    }

    public void setIdEvidenciaAprendizaje(EvidenciaAprendizaje idEvidenciaAprendizaje) {
        this.idEvidenciaAprendizaje = idEvidenciaAprendizaje;
    }

    public FichaCaracterizacion getIdFichaCaracterizacion() {
        return idFichaCaracterizacion;
    }

    public void setIdFichaCaracterizacion(FichaCaracterizacion idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    public Usuario getIdUsuario1() {
        return idUsuario1;
    }

    public void setIdUsuario1(Usuario idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<Alistamiento> getAlistamientoList() {
        return alistamientoList;
    }

    public void setAlistamientoList(List<Alistamiento> alistamientoList) {
        this.alistamientoList = alistamientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvaluacionSeguimiento != null ? idEvaluacionSeguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionSeguimiento)) {
            return false;
        }
        EvaluacionSeguimiento other = (EvaluacionSeguimiento) object;
        if ((this.idEvaluacionSeguimiento == null && other.idEvaluacionSeguimiento != null) || (this.idEvaluacionSeguimiento != null && !this.idEvaluacionSeguimiento.equals(other.idEvaluacionSeguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EvaluacionSeguimiento[ idEvaluacionSeguimiento=" + idEvaluacionSeguimiento + " ]";
    }
    
}
