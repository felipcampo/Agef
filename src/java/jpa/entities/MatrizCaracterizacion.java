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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "matriz_caracterizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MatrizCaracterizacion.findAll", query = "SELECT m FROM MatrizCaracterizacion m"),
    @NamedQuery(name = "MatrizCaracterizacion.findByIdMatrizCaracterizacion", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.idMatrizCaracterizacion = :idMatrizCaracterizacion"),
    @NamedQuery(name = "MatrizCaracterizacion.findByDescrEstrato", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.descrEstrato = :descrEstrato"),
    @NamedQuery(name = "MatrizCaracterizacion.findByDescrConformacionHogar", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.descrConformacionHogar = :descrConformacionHogar"),
    @NamedQuery(name = "MatrizCaracterizacion.findByTienePadre", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.tienePadre = :tienePadre"),
    @NamedQuery(name = "MatrizCaracterizacion.findByTieneMadre", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.tieneMadre = :tieneMadre"),
    @NamedQuery(name = "MatrizCaracterizacion.findByNumeroHijos", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.numeroHijos = :numeroHijos"),
    @NamedQuery(name = "MatrizCaracterizacion.findByNumeroPersonasAcargo", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.numeroPersonasAcargo = :numeroPersonasAcargo"),
    @NamedQuery(name = "MatrizCaracterizacion.findByUltimoTituloAspirante", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.ultimoTituloAspirante = :ultimoTituloAspirante"),
    @NamedQuery(name = "MatrizCaracterizacion.findByTrabajoAnterior", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.trabajoAnterior = :trabajoAnterior"),
    @NamedQuery(name = "MatrizCaracterizacion.findByTrabajoActual", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.trabajoActual = :trabajoActual"),
    @NamedQuery(name = "MatrizCaracterizacion.findByHoraTrabajoSemanal", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.horaTrabajoSemanal = :horaTrabajoSemanal"),
    @NamedQuery(name = "MatrizCaracterizacion.findByPromedioIngresoLaboralMes", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.promedioIngresoLaboralMes = :promedioIngresoLaboralMes"),
    @NamedQuery(name = "MatrizCaracterizacion.findByTieneEps", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.tieneEps = :tieneEps"),
    @NamedQuery(name = "MatrizCaracterizacion.findByTieneSisben", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.tieneSisben = :tieneSisben"),
    @NamedQuery(name = "MatrizCaracterizacion.findBySubsidioAlimenticio", query = "SELECT m FROM MatrizCaracterizacion m WHERE m.subsidioAlimenticio = :subsidioAlimenticio")})
public class MatrizCaracterizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_matriz_caracterizacion")
    private Integer idMatrizCaracterizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descr_estrato")
    private short descrEstrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descr_conformacion_hogar")
    private short descrConformacionHogar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiene_padre")
    private boolean tienePadre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiene_madre")
    private boolean tieneMadre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_hijos")
    private short numeroHijos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_personas_acargo")
    private short numeroPersonasAcargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ultimo_titulo_aspirante")
    private String ultimoTituloAspirante;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "expectativa_curso")
    private String expectativaCurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trabajo_anterior")
    private boolean trabajoAnterior;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trabajo_actual")
    private boolean trabajoActual;
    @Column(name = "hora_trabajo_semanal")
    private Short horaTrabajoSemanal;
    @Column(name = "promedio_ingreso_laboral_mes")
    private Integer promedioIngresoLaboralMes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiene_eps")
    private boolean tieneEps;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiene_sisben")
    private boolean tieneSisben;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacion_medica")
    private String observacionMedica;
    @Column(name = "subsidio_alimenticio")
    private Boolean subsidioAlimenticio;
    @Lob
    @Size(max = 65535)
    @Column(name = "justificacion_subsidio")
    private String justificacionSubsidio;
    @ManyToMany(mappedBy = "matrizCaracterizacionList")
    private List<ServicioVivienda> servicioViviendaList;
    @JoinTable(name = "tipo_familia_matriz", joinColumns = {
        @JoinColumn(name = "id_matriz_caracterizacion", referencedColumnName = "id_matriz_caracterizacion")}, inverseJoinColumns = {
        @JoinColumn(name = "id_tipo_familia", referencedColumnName = "id_tipo_familia")})
    @ManyToMany
    private List<TipoFamilia> tipoFamiliaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMatrizCaracterizacion")
    private List<ControlCasoBieAprendiz> controlCasoBieAprendizList;
    @JoinColumn(name = "id_cambio_residencia", referencedColumnName = "id_cambio_residencia")
    @ManyToOne(optional = false)
    private CambioResidencia idCambioResidencia;
    @JoinColumn(name = "id_nivel_formacion", referencedColumnName = "id_nivel_formacion")
    @ManyToOne(optional = false)
    private NivelFormacion idNivelFormacion;
    @JoinColumn(name = "id_tipo_vivienda", referencedColumnName = "id_tipo_vivienda")
    @ManyToOne(optional = false)
    private TipoVivienda idTipoVivienda;
    @JoinColumn(name = "id_contacto_emergencia", referencedColumnName = "id_contacto_emergencia")
    @ManyToOne(optional = false)
    private ContactoEmergencia idContactoEmergencia;
    @JoinColumn(name = "id_nivel_alimentacion", referencedColumnName = "id_nivel_alimentacion")
    @ManyToOne(optional = false)
    private NivelAlimentacion idNivelAlimentacion;
    @JoinColumn(name = "id_sisben", referencedColumnName = "id_sisben")
    @ManyToOne
    private Sisben idSisben;
    @JoinColumn(name = "id_tipo_sangre", referencedColumnName = "id_tipo_sangre")
    @ManyToOne(optional = false)
    private TipoSangre idTipoSangre;
    @JoinColumn(name = "id_eps", referencedColumnName = "id_eps")
    @ManyToOne
    private Eps idEps;
    @JoinColumn(name = "id_medio_transporte", referencedColumnName = "id_medio_transporte")
    @ManyToOne(optional = false)
    private MedioTransporte idMedioTransporte;
    @JoinColumn(name = "id_actividad_academica", referencedColumnName = "id_actividad_academica")
    @ManyToOne(optional = false)
    private ActividadAcademica idActividadAcademica;
    @JoinColumn(name = "id_escolaridad_aspirante", referencedColumnName = "id_escolaridad")
    @ManyToOne(optional = false)
    private Escolaridad idEscolaridadAspirante;
    @JoinColumn(name = "id_motivo_inscripcion", referencedColumnName = "id_motivo_inscripcion")
    @ManyToOne(optional = false)
    private MotivoInscripcion idMotivoInscripcion;
    @JoinColumn(name = "id_ficha_caracterizacion", referencedColumnName = "id_ficha_caracterizacion")
    @ManyToOne(optional = false)
    private FichaCaracterizacion idFichaCaracterizacion;
    @JoinColumn(name = "id_programa_estado", referencedColumnName = "id_programa_estado")
    @ManyToOne(optional = false)
    private ProgramaEstado idProgramaEstado;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_caracterizacion_poblacion", referencedColumnName = "id_caracterizacion_poblacion")
    @ManyToOne(optional = false)
    private CaracterizacionPoblacion idCaracterizacionPoblacion;
    @JoinColumn(name = "id_jefe_hogar", referencedColumnName = "id_jefe_hogar")
    @ManyToOne(optional = false)
    private JefeHogar idJefeHogar;
    @JoinColumn(name = "id_ocupacion_jefe_hogar", referencedColumnName = "id_ocupacion_jefe_hogar")
    @ManyToOne(optional = false)
    private OcupacionJefeHogar idOcupacionJefeHogar;
    @JoinColumn(name = "id_ingreso_mensual", referencedColumnName = "id_ingreso_mensual")
    @ManyToOne(optional = false)
    private IngresoMensual idIngresoMensual;
    @JoinColumn(name = "id_escolaridad_padre", referencedColumnName = "id_escolaridad")
    @ManyToOne
    private Escolaridad idEscolaridadPadre;
    @JoinColumn(name = "id_escolaridad_madre", referencedColumnName = "id_escolaridad")
    @ManyToOne
    private Escolaridad idEscolaridadMadre;
    @JoinColumn(name = "id_dependencia_economica", referencedColumnName = "id_dependencia_economica")
    @ManyToOne(optional = false)
    private DependenciaEconomica idDependenciaEconomica;
    @JoinColumn(name = "id_nivel_conocimento_informatica", referencedColumnName = "id_nivel_conocimento")
    @ManyToOne(optional = false)
    private NivelConocimento idNivelConocimentoInformatica;
    @JoinColumn(name = "id_nivel_conocimento_ingles", referencedColumnName = "id_nivel_conocimento")
    @ManyToOne(optional = false)
    private NivelConocimento idNivelConocimentoIngles;

    public MatrizCaracterizacion() {
    }

    public MatrizCaracterizacion(Integer idMatrizCaracterizacion) {
        this.idMatrizCaracterizacion = idMatrizCaracterizacion;
    }

    public MatrizCaracterizacion(Integer idMatrizCaracterizacion, short descrEstrato, short descrConformacionHogar, boolean tienePadre, boolean tieneMadre, short numeroHijos, short numeroPersonasAcargo, String ultimoTituloAspirante, String expectativaCurso, boolean trabajoAnterior, boolean trabajoActual, boolean tieneEps, boolean tieneSisben) {
        this.idMatrizCaracterizacion = idMatrizCaracterizacion;
        this.descrEstrato = descrEstrato;
        this.descrConformacionHogar = descrConformacionHogar;
        this.tienePadre = tienePadre;
        this.tieneMadre = tieneMadre;
        this.numeroHijos = numeroHijos;
        this.numeroPersonasAcargo = numeroPersonasAcargo;
        this.ultimoTituloAspirante = ultimoTituloAspirante;
        this.expectativaCurso = expectativaCurso;
        this.trabajoAnterior = trabajoAnterior;
        this.trabajoActual = trabajoActual;
        this.tieneEps = tieneEps;
        this.tieneSisben = tieneSisben;
    }

    public Integer getIdMatrizCaracterizacion() {
        return idMatrizCaracterizacion;
    }

    public void setIdMatrizCaracterizacion(Integer idMatrizCaracterizacion) {
        this.idMatrizCaracterizacion = idMatrizCaracterizacion;
    }

    public short getDescrEstrato() {
        return descrEstrato;
    }

    public void setDescrEstrato(short descrEstrato) {
        this.descrEstrato = descrEstrato;
    }

    public short getDescrConformacionHogar() {
        return descrConformacionHogar;
    }

    public void setDescrConformacionHogar(short descrConformacionHogar) {
        this.descrConformacionHogar = descrConformacionHogar;
    }

    public boolean getTienePadre() {
        return tienePadre;
    }

    public void setTienePadre(boolean tienePadre) {
        this.tienePadre = tienePadre;
    }

    public boolean getTieneMadre() {
        return tieneMadre;
    }

    public void setTieneMadre(boolean tieneMadre) {
        this.tieneMadre = tieneMadre;
    }

    public short getNumeroHijos() {
        return numeroHijos;
    }

    public void setNumeroHijos(short numeroHijos) {
        this.numeroHijos = numeroHijos;
    }

    public short getNumeroPersonasAcargo() {
        return numeroPersonasAcargo;
    }

    public void setNumeroPersonasAcargo(short numeroPersonasAcargo) {
        this.numeroPersonasAcargo = numeroPersonasAcargo;
    }

    public String getUltimoTituloAspirante() {
        return ultimoTituloAspirante;
    }

    public void setUltimoTituloAspirante(String ultimoTituloAspirante) {
        this.ultimoTituloAspirante = ultimoTituloAspirante;
    }

    public String getExpectativaCurso() {
        return expectativaCurso;
    }

    public void setExpectativaCurso(String expectativaCurso) {
        this.expectativaCurso = expectativaCurso;
    }

    public boolean getTrabajoAnterior() {
        return trabajoAnterior;
    }

    public void setTrabajoAnterior(boolean trabajoAnterior) {
        this.trabajoAnterior = trabajoAnterior;
    }

    public boolean getTrabajoActual() {
        return trabajoActual;
    }

    public void setTrabajoActual(boolean trabajoActual) {
        this.trabajoActual = trabajoActual;
    }

    public Short getHoraTrabajoSemanal() {
        return horaTrabajoSemanal;
    }

    public void setHoraTrabajoSemanal(Short horaTrabajoSemanal) {
        this.horaTrabajoSemanal = horaTrabajoSemanal;
    }

    public Integer getPromedioIngresoLaboralMes() {
        return promedioIngresoLaboralMes;
    }

    public void setPromedioIngresoLaboralMes(Integer promedioIngresoLaboralMes) {
        this.promedioIngresoLaboralMes = promedioIngresoLaboralMes;
    }

    public boolean getTieneEps() {
        return tieneEps;
    }

    public void setTieneEps(boolean tieneEps) {
        this.tieneEps = tieneEps;
    }

    public boolean getTieneSisben() {
        return tieneSisben;
    }

    public void setTieneSisben(boolean tieneSisben) {
        this.tieneSisben = tieneSisben;
    }

    public String getObservacionMedica() {
        return observacionMedica;
    }

    public void setObservacionMedica(String observacionMedica) {
        this.observacionMedica = observacionMedica;
    }

    public Boolean getSubsidioAlimenticio() {
        return subsidioAlimenticio;
    }

    public void setSubsidioAlimenticio(Boolean subsidioAlimenticio) {
        this.subsidioAlimenticio = subsidioAlimenticio;
    }

    public String getJustificacionSubsidio() {
        return justificacionSubsidio;
    }

    public void setJustificacionSubsidio(String justificacionSubsidio) {
        this.justificacionSubsidio = justificacionSubsidio;
    }

    @XmlTransient
    public List<ServicioVivienda> getServicioViviendaList() {
        return servicioViviendaList;
    }

    public void setServicioViviendaList(List<ServicioVivienda> servicioViviendaList) {
        this.servicioViviendaList = servicioViviendaList;
    }

    @XmlTransient
    public List<TipoFamilia> getTipoFamiliaList() {
        return tipoFamiliaList;
    }

    public void setTipoFamiliaList(List<TipoFamilia> tipoFamiliaList) {
        this.tipoFamiliaList = tipoFamiliaList;
    }

    @XmlTransient
    public List<ControlCasoBieAprendiz> getControlCasoBieAprendizList() {
        return controlCasoBieAprendizList;
    }

    public void setControlCasoBieAprendizList(List<ControlCasoBieAprendiz> controlCasoBieAprendizList) {
        this.controlCasoBieAprendizList = controlCasoBieAprendizList;
    }

    public CambioResidencia getIdCambioResidencia() {
        return idCambioResidencia;
    }

    public void setIdCambioResidencia(CambioResidencia idCambioResidencia) {
        this.idCambioResidencia = idCambioResidencia;
    }

    public NivelFormacion getIdNivelFormacion() {
        return idNivelFormacion;
    }

    public void setIdNivelFormacion(NivelFormacion idNivelFormacion) {
        this.idNivelFormacion = idNivelFormacion;
    }

    public TipoVivienda getIdTipoVivienda() {
        return idTipoVivienda;
    }

    public void setIdTipoVivienda(TipoVivienda idTipoVivienda) {
        this.idTipoVivienda = idTipoVivienda;
    }

    public ContactoEmergencia getIdContactoEmergencia() {
        return idContactoEmergencia;
    }

    public void setIdContactoEmergencia(ContactoEmergencia idContactoEmergencia) {
        this.idContactoEmergencia = idContactoEmergencia;
    }

    public NivelAlimentacion getIdNivelAlimentacion() {
        return idNivelAlimentacion;
    }

    public void setIdNivelAlimentacion(NivelAlimentacion idNivelAlimentacion) {
        this.idNivelAlimentacion = idNivelAlimentacion;
    }

    public Sisben getIdSisben() {
        return idSisben;
    }

    public void setIdSisben(Sisben idSisben) {
        this.idSisben = idSisben;
    }

    public TipoSangre getIdTipoSangre() {
        return idTipoSangre;
    }

    public void setIdTipoSangre(TipoSangre idTipoSangre) {
        this.idTipoSangre = idTipoSangre;
    }

    public Eps getIdEps() {
        return idEps;
    }

    public void setIdEps(Eps idEps) {
        this.idEps = idEps;
    }

    public MedioTransporte getIdMedioTransporte() {
        return idMedioTransporte;
    }

    public void setIdMedioTransporte(MedioTransporte idMedioTransporte) {
        this.idMedioTransporte = idMedioTransporte;
    }

    public ActividadAcademica getIdActividadAcademica() {
        return idActividadAcademica;
    }

    public void setIdActividadAcademica(ActividadAcademica idActividadAcademica) {
        this.idActividadAcademica = idActividadAcademica;
    }

    public Escolaridad getIdEscolaridadAspirante() {
        return idEscolaridadAspirante;
    }

    public void setIdEscolaridadAspirante(Escolaridad idEscolaridadAspirante) {
        this.idEscolaridadAspirante = idEscolaridadAspirante;
    }

    public MotivoInscripcion getIdMotivoInscripcion() {
        return idMotivoInscripcion;
    }

    public void setIdMotivoInscripcion(MotivoInscripcion idMotivoInscripcion) {
        this.idMotivoInscripcion = idMotivoInscripcion;
    }

    public FichaCaracterizacion getIdFichaCaracterizacion() {
        return idFichaCaracterizacion;
    }

    public void setIdFichaCaracterizacion(FichaCaracterizacion idFichaCaracterizacion) {
        this.idFichaCaracterizacion = idFichaCaracterizacion;
    }

    public ProgramaEstado getIdProgramaEstado() {
        return idProgramaEstado;
    }

    public void setIdProgramaEstado(ProgramaEstado idProgramaEstado) {
        this.idProgramaEstado = idProgramaEstado;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public CaracterizacionPoblacion getIdCaracterizacionPoblacion() {
        return idCaracterizacionPoblacion;
    }

    public void setIdCaracterizacionPoblacion(CaracterizacionPoblacion idCaracterizacionPoblacion) {
        this.idCaracterizacionPoblacion = idCaracterizacionPoblacion;
    }

    public JefeHogar getIdJefeHogar() {
        return idJefeHogar;
    }

    public void setIdJefeHogar(JefeHogar idJefeHogar) {
        this.idJefeHogar = idJefeHogar;
    }

    public OcupacionJefeHogar getIdOcupacionJefeHogar() {
        return idOcupacionJefeHogar;
    }

    public void setIdOcupacionJefeHogar(OcupacionJefeHogar idOcupacionJefeHogar) {
        this.idOcupacionJefeHogar = idOcupacionJefeHogar;
    }

    public IngresoMensual getIdIngresoMensual() {
        return idIngresoMensual;
    }

    public void setIdIngresoMensual(IngresoMensual idIngresoMensual) {
        this.idIngresoMensual = idIngresoMensual;
    }

    public Escolaridad getIdEscolaridadPadre() {
        return idEscolaridadPadre;
    }

    public void setIdEscolaridadPadre(Escolaridad idEscolaridadPadre) {
        this.idEscolaridadPadre = idEscolaridadPadre;
    }

    public Escolaridad getIdEscolaridadMadre() {
        return idEscolaridadMadre;
    }

    public void setIdEscolaridadMadre(Escolaridad idEscolaridadMadre) {
        this.idEscolaridadMadre = idEscolaridadMadre;
    }

    public DependenciaEconomica getIdDependenciaEconomica() {
        return idDependenciaEconomica;
    }

    public void setIdDependenciaEconomica(DependenciaEconomica idDependenciaEconomica) {
        this.idDependenciaEconomica = idDependenciaEconomica;
    }

    public NivelConocimento getIdNivelConocimentoInformatica() {
        return idNivelConocimentoInformatica;
    }

    public void setIdNivelConocimentoInformatica(NivelConocimento idNivelConocimentoInformatica) {
        this.idNivelConocimentoInformatica = idNivelConocimentoInformatica;
    }

    public NivelConocimento getIdNivelConocimentoIngles() {
        return idNivelConocimentoIngles;
    }

    public void setIdNivelConocimentoIngles(NivelConocimento idNivelConocimentoIngles) {
        this.idNivelConocimentoIngles = idNivelConocimentoIngles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatrizCaracterizacion != null ? idMatrizCaracterizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatrizCaracterizacion)) {
            return false;
        }
        MatrizCaracterizacion other = (MatrizCaracterizacion) object;
        if ((this.idMatrizCaracterizacion == null && other.idMatrizCaracterizacion != null) || (this.idMatrizCaracterizacion != null && !this.idMatrizCaracterizacion.equals(other.idMatrizCaracterizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.MatrizCaracterizacion[ idMatrizCaracterizacion=" + idMatrizCaracterizacion + " ]";
    }
    
}
