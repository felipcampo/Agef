/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leoandresm
 */
@Entity
@Table(name = "seguimiento_productiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeguimientoProductiva.findAll", query = "SELECT s FROM SeguimientoProductiva s"),
    @NamedQuery(name = "SeguimientoProductiva.findByIdSeguimientoProductiva", query = "SELECT s FROM SeguimientoProductiva s WHERE s.idSeguimientoProductiva = :idSeguimientoProductiva"),
    @NamedQuery(name = "SeguimientoProductiva.findByFecRepFin", query = "SELECT s FROM SeguimientoProductiva s WHERE s.fecRepFin = :fecRepFin"),
    @NamedQuery(name = "SeguimientoProductiva.findByFecRepIni", query = "SELECT s FROM SeguimientoProductiva s WHERE s.fecRepIni = :fecRepIni"),
    @NamedQuery(name = "SeguimientoProductiva.findByJuicioEva", query = "SELECT s FROM SeguimientoProductiva s WHERE s.juicioEva = :juicioEva"),
    @NamedQuery(name = "SeguimientoProductiva.findByReconocimentoEspeciales", query = "SELECT s FROM SeguimientoProductiva s WHERE s.reconocimentoEspeciales = :reconocimentoEspeciales"),
    @NamedQuery(name = "SeguimientoProductiva.findByRequierePlanMejoramiento", query = "SELECT s FROM SeguimientoProductiva s WHERE s.requierePlanMejoramiento = :requierePlanMejoramiento"),
    @NamedQuery(name = "SeguimientoProductiva.findByTipoInforme", query = "SELECT s FROM SeguimientoProductiva s WHERE s.tipoInforme = :tipoInforme")})
public class SeguimientoProductiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull    
    @Column(name = "id_seguimiento_productiva")
    private String idSeguimientoProductiva;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "esp_rec")
    private String espRec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_rep_fin")
    @Temporal(TemporalType.DATE)
    private Date fecRepFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_rep_ini")
    @Temporal(TemporalType.DATE)
    private Date fecRepIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "juicio_eva")
    private boolean juicioEva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reconocimento_especiales")
    private boolean reconocimentoEspeciales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "requiere_plan_mejoramiento")
    private boolean requierePlanMejoramiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tipo_informe")
    private String tipoInforme;
    @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")
    @ManyToOne(optional = false)
    private FichaCaracterizacion idFichaCaracterizacion;
    @JoinColumn(name = "id_concertacion_plan_trabajo_productiva", referencedColumnName = "id_concertacion_plan_trabajo_productiva")
    @ManyToOne(optional = false)
    private ConcertacionPlanTrabajoProductiva idConcertacionPlanTrabajoProductiva;
    @JoinColumn(name = "id_visita_etapa_productiva", referencedColumnName = "id_visita_etapa_productiva")
    @ManyToOne
    private VisitaEtapaProductiva idVisitaEtapaProductiva;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_modalidad_productiva", referencedColumnName = "id_modalidad_productiva")
    @ManyToOne(optional = false)
    private ModalidadProductiva idModalidadProductiva;
    @JoinColumn(name = "id_centro_formacion", referencedColumnName = "id_centro_formacion")
    @ManyToOne(optional = false)
    private CentroFormacion idCentroFormacion;
    @JoinColumn(name = "id_incidente_productiva", referencedColumnName = "id_incidente_productiva")
    @ManyToOne(optional = false)
    private IncidenteProductiva idIncidenteProductiva;

    public SeguimientoProductiva() {
    }

    public SeguimientoProductiva(String idSeguimientoProductiva) {
        this.idSeguimientoProductiva = idSeguimientoProductiva;
    }

    public SeguimientoProductiva(String idSeguimientoProductiva, String espRec, Date fecRepFin, Date fecRepIni, boolean juicioEva, boolean reconocimentoEspeciales, boolean requierePlanMejoramiento, String tipoInforme) {
        this.idSeguimientoProductiva = idSeguimientoProductiva;
        this.espRec = espRec;
        this.fecRepFin = fecRepFin;
        this.fecRepIni = fecRepIni;
        this.juicioEva = juicioEva;
        this.reconocimentoEspeciales = reconocimentoEspeciales;
        this.requierePlanMejoramiento = requierePlanMejoramiento;
        this.tipoInforme = tipoInforme;
    }

    public String getIdSeguimientoProductiva() {
        return idSeguimientoProductiva;
    }

    public void setIdSeguimientoProductiva(String idSeguimientoProductiva) {
        this.idSeguimientoProductiva = idSeguimientoProductiva;
    }

    public String getEspRec() {
        return espRec;
    }

    public void setEspRec(String espRec) {
        this.espRec = espRec;
    }

    public Date getFecRepFin() {
        return fecRepFin;
    }

    public void setFecRepFin(Date fecRepFin) {
        this.fecRepFin = fecRepFin;
    }

    public Date getFecRepIni() {
        return fecRepIni;
    }

    public void setFecRepIni(Date fecRepIni) {
        this.fecRepIni = fecRepIni;
    }

    public boolean getJuicioEva() {
        return juicioEva;
    }

    public void setJuicioEva(boolean juicioEva) {
        this.juicioEva = juicioEva;
    }

    public boolean getReconocimentoEspeciales() {
        return reconocimentoEspeciales;
    }

    public void setReconocimentoEspeciales(boolean reconocimentoEspeciales) {
        this.reconocimentoEspeciales = reconocimentoEspeciales;
    }

    public boolean getRequierePlanMejoramiento() {
        return requierePlanMejoramiento;
    }

    public void setRequierePlanMejoramiento(boolean requierePlanMejoramiento) {
        this.requierePlanMejoramiento = requierePlanMejoramiento;
    }

    public String getTipoInforme() {
        return tipoInforme;
    }

    public void setTipoInforme(String tipoInforme) {
        this.tipoInforme = tipoInforme;
    }

    public FichaCaracterizacion getIdFichaCaracterizacion() {
        return idFichaCaracterizacion;
    }

    public void setIdFichaCaracterizacion(FichaCaracterizacion idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    public ConcertacionPlanTrabajoProductiva getIdConcertacionPlanTrabajoProductiva() {
        return idConcertacionPlanTrabajoProductiva;
    }

    public void setIdConcertacionPlanTrabajoProductiva(ConcertacionPlanTrabajoProductiva idConcertacionPlanTrabajoProductiva) {
        this.idConcertacionPlanTrabajoProductiva = idConcertacionPlanTrabajoProductiva;
    }

    public VisitaEtapaProductiva getIdVisitaEtapaProductiva() {
        return idVisitaEtapaProductiva;
    }

    public void setIdVisitaEtapaProductiva(VisitaEtapaProductiva idVisitaEtapaProductiva) {
        this.idVisitaEtapaProductiva = idVisitaEtapaProductiva;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ModalidadProductiva getIdModalidadProductiva() {
        return idModalidadProductiva;
    }

    public void setIdModalidadProductiva(ModalidadProductiva idModalidadProductiva) {
        this.idModalidadProductiva = idModalidadProductiva;
    }

    public CentroFormacion getIdCentroFormacion() {
        return idCentroFormacion;
    }

    public void setIdCentroFormacion(CentroFormacion idCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
    }

    public IncidenteProductiva getIdIncidenteProductiva() {
        return idIncidenteProductiva;
    }

    public void setIdIncidenteProductiva(IncidenteProductiva idIncidenteProductiva) {
        this.idIncidenteProductiva = idIncidenteProductiva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeguimientoProductiva != null ? idSeguimientoProductiva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguimientoProductiva)) {
            return false;
        }
        SeguimientoProductiva other = (SeguimientoProductiva) object;
        if ((this.idSeguimientoProductiva == null && other.idSeguimientoProductiva != null) || (this.idSeguimientoProductiva != null && !this.idSeguimientoProductiva.equals(other.idSeguimientoProductiva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.SeguimientoProductiva[ idSeguimientoProductiva=" + idSeguimientoProductiva + " ]";
    }
    
}
