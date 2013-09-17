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
 * @author ADSI
 */
@Entity
@Table(name = "control_caso_bie_aprendiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlCasoBieAprendiz.findAll", query = "SELECT c FROM ControlCasoBieAprendiz c"),
    @NamedQuery(name = "ControlCasoBieAprendiz.findByIdControlCasoBieAprendiz", query = "SELECT c FROM ControlCasoBieAprendiz c WHERE c.idControlCasoBieAprendiz = :idControlCasoBieAprendiz"),
    @NamedQuery(name = "ControlCasoBieAprendiz.findByFecInicioControlBie", query = "SELECT c FROM ControlCasoBieAprendiz c WHERE c.fecInicioControlBie = :fecInicioControlBie"),
    @NamedQuery(name = "ControlCasoBieAprendiz.findByFecFinControlBie", query = "SELECT c FROM ControlCasoBieAprendiz c WHERE c.fecFinControlBie = :fecFinControlBie"),
    @NamedQuery(name = "ControlCasoBieAprendiz.findByNumSegBie", query = "SELECT c FROM ControlCasoBieAprendiz c WHERE c.numSegBie = :numSegBie")})
public class ControlCasoBieAprendiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_control_caso_bie_aprendiz")
    private Integer idControlCasoBieAprendiz;
    @Lob
    @Size(max = 65535)
    @Column(name = "comentario_ins")
    private String comentarioIns;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_inicio_control_bie")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecInicioControlBie;
    @Column(name = "fec_fin_control_bie")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFinControlBie;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "logros_control")
    private String logrosControl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "num_seg_bie")
    private String numSegBie;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "objectivo_ses")
    private String objectivoSes;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "tema_abo")
    private String temaAbo;
    @JoinColumn(name = "id_usuario_funcionario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioFuncionario;
    @JoinColumn(name = "id_usuario_intructor", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioIntructor;
    @JoinColumn(name = "id_usuario_aprendiz", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioAprendiz;
    @JoinColumn(name = "id_matriz_caracterizacion", referencedColumnName = "id_matriz_caracterizacion")
    @ManyToOne(optional = false)
    private MatrizCaracterizacion idMatrizCaracterizacion;
    @JoinColumn(name = "id_caso_bienestar", referencedColumnName = "id_caso_bienestar")
    @ManyToOne(optional = false)
    private CasoBienestar idCasoBienestar;

    public ControlCasoBieAprendiz() {
    }

    public ControlCasoBieAprendiz(Integer idControlCasoBieAprendiz) {
        this.idControlCasoBieAprendiz = idControlCasoBieAprendiz;
    }

    public ControlCasoBieAprendiz(Integer idControlCasoBieAprendiz, Date fecInicioControlBie, String logrosControl, String numSegBie, String objectivoSes, String temaAbo) {
        this.idControlCasoBieAprendiz = idControlCasoBieAprendiz;
        this.fecInicioControlBie = fecInicioControlBie;
        this.logrosControl = logrosControl;
        this.numSegBie = numSegBie;
        this.objectivoSes = objectivoSes;
        this.temaAbo = temaAbo;
    }

    public Integer getIdControlCasoBieAprendiz() {
        return idControlCasoBieAprendiz;
    }

    public void setIdControlCasoBieAprendiz(Integer idControlCasoBieAprendiz) {
        this.idControlCasoBieAprendiz = idControlCasoBieAprendiz;
    }

    public String getComentarioIns() {
        return comentarioIns;
    }

    public void setComentarioIns(String comentarioIns) {
        this.comentarioIns = comentarioIns;
    }

    public Date getFecInicioControlBie() {
        return fecInicioControlBie;
    }

    public void setFecInicioControlBie(Date fecInicioControlBie) {
        this.fecInicioControlBie = fecInicioControlBie;
    }

    public Date getFecFinControlBie() {
        return fecFinControlBie;
    }

    public void setFecFinControlBie(Date fecFinControlBie) {
        this.fecFinControlBie = fecFinControlBie;
    }

    public String getLogrosControl() {
        return logrosControl;
    }

    public void setLogrosControl(String logrosControl) {
        this.logrosControl = logrosControl;
    }

    public String getNumSegBie() {
        return numSegBie;
    }

    public void setNumSegBie(String numSegBie) {
        this.numSegBie = numSegBie;
    }

    public String getObjectivoSes() {
        return objectivoSes;
    }

    public void setObjectivoSes(String objectivoSes) {
        this.objectivoSes = objectivoSes;
    }

    public String getTemaAbo() {
        return temaAbo;
    }

    public void setTemaAbo(String temaAbo) {
        this.temaAbo = temaAbo;
    }

    public Usuario getIdUsuarioFuncionario() {
        return idUsuarioFuncionario;
    }

    public void setIdUsuarioFuncionario(Usuario idUsuarioFuncionario) {
        this.idUsuarioFuncionario = idUsuarioFuncionario;
    }

    public Usuario getIdUsuarioIntructor() {
        return idUsuarioIntructor;
    }

    public void setIdUsuarioIntructor(Usuario idUsuarioIntructor) {
        this.idUsuarioIntructor = idUsuarioIntructor;
    }

    public Usuario getIdUsuarioAprendiz() {
        return idUsuarioAprendiz;
    }

    public void setIdUsuarioAprendiz(Usuario idUsuarioAprendiz) {
        this.idUsuarioAprendiz = idUsuarioAprendiz;
    }

    public MatrizCaracterizacion getIdMatrizCaracterizacion() {
        return idMatrizCaracterizacion;
    }

    public void setIdMatrizCaracterizacion(MatrizCaracterizacion idMatrizCaracterizacion) {
        this.idMatrizCaracterizacion = idMatrizCaracterizacion;
    }

    public CasoBienestar getIdCasoBienestar() {
        return idCasoBienestar;
    }

    public void setIdCasoBienestar(CasoBienestar idCasoBienestar) {
        this.idCasoBienestar = idCasoBienestar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControlCasoBieAprendiz != null ? idControlCasoBieAprendiz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlCasoBieAprendiz)) {
            return false;
        }
        ControlCasoBieAprendiz other = (ControlCasoBieAprendiz) object;
        if ((this.idControlCasoBieAprendiz == null && other.idControlCasoBieAprendiz != null) || (this.idControlCasoBieAprendiz != null && !this.idControlCasoBieAprendiz.equals(other.idControlCasoBieAprendiz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ControlCasoBieAprendiz[ idControlCasoBieAprendiz=" + idControlCasoBieAprendiz + " ]";
    }
    
}
