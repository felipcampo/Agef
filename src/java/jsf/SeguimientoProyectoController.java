package jsf;

import jpa.entities.SeguimientoProyecto;
import jsf.util.JsfUtil;
import jpa.sessions.SeguimientoProyectoFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import jpa.entities.CriterioEvaluacion;
import jpa.entities.CriterioSeguimientoProyecto;
import jpa.entities.EstadoAprendiz;
import jpa.entities.EstadoJuicio;
import jpa.entities.EvaluacionCriterioSeguimientoProyecto;
import jpa.entities.FichaCaracterizacion;
import jpa.entities.FichaUsuario;
import jpa.entities.GradoJuicio;
import jpa.entities.Programa;
import jpa.entities.TipoCriterio;
import jpa.entities.TipoJuicio;
import jpa.sessions.CriterioEvaluacionFacade;
import jpa.sessions.CriterioSeguimientoProyectoFacade;
import jpa.sessions.EvaluacionCriterioSeguimientoProyectoFacade;
import jpa.sessions.FichaCaracterizacionFacade;
import jpa.sessions.FichaUsuarioFacade;
import org.apache.jasper.tagplugins.jstl.ForEach;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "seguimientoProyectoController")
@SessionScoped
public class SeguimientoProyectoController implements Serializable {

    private SeguimientoProyecto current;
    private LazyDataModel<SeguimientoProyecto> lazyModel = null;
    private CriterioSeguimientoProyecto currentCriterioSeg;
    List<CriterioSeguimientoProyecto> listCriteriosSeg;
    List<CriterioEvaluacion> listCriteriosEval;
    private FichaCaracterizacion currentFicha;
    private Programa currentPrograma;
    private List<FichaCaracterizacion> listBusquedaFicha;
    @EJB
    private jpa.sessions.SeguimientoProyectoFacade ejbFacade;
    @EJB
    private jpa.sessions.FichaUsuarioFacade ejbFacadeFichaUsuario;
    @EJB
    private jpa.sessions.CriterioSeguimientoProyectoFacade ejbFacadeCriterioSeg;
    @EJB
    private jpa.sessions.CriterioEvaluacionFacade ejbFacadeCriterioEval;
    @EJB
    private jpa.sessions.EvaluacionCriterioSeguimientoProyectoFacade ejbFacadeEvalCriterioSeg;
    @EJB
    private jpa.sessions.FichaCaracterizacionFacade ejbFacadeFicha;

    public SeguimientoProyectoController() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }

    public int cumple() {
        int i = 0;
        if (listCriteriosSeg == null) {
            return 0;
        } else {
            for (CriterioSeguimientoProyecto calificacion : listCriteriosSeg) {
                if (calificacion.getIdEvaluacionCriterioSeguimientoProyecto() != null) {
                    if (calificacion.getIdEvaluacionCriterioSeguimientoProyecto().getIdEvaluacionCriterioSeguimientoProyecto() == 1) {
                        i++;
                    }
                }
            }
            return i;
        }
    }

    public String getTimeDiff() {
        if (current != null) {
            Date dateOne = current.getFechaSeguimientoFin();
            Date dateTwo = current.getFechaSeguimientoInicio();
            String diff;
            long timeDiff = Math.abs(dateOne.getTime() - dateTwo.getTime());
            diff = String.format("%d hour(s) %d min(s)", TimeUnit.MILLISECONDS.toHours(timeDiff),
                    TimeUnit.MILLISECONDS.toMinutes(timeDiff) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeDiff)));
            return diff;
        } else {
            return "";
        }
    }

    public SeguimientoProyecto getSelected() {
        if (current == null) {
            current = new SeguimientoProyecto();
        }
        return current;
    }

    public void setSelected(SeguimientoProyecto entity) {
        current = entity;
    }

    public FichaCaracterizacion getSelectedFicha() {
        if (currentFicha == null) {
            currentFicha = new FichaCaracterizacion();
        }
        return currentFicha;
    }

    public void setSelectedFicha(FichaCaracterizacion entity) {
        currentFicha = entity;
    }

    public Programa getSelectedPrograma() {
        if (currentPrograma == null) {
            currentPrograma = new Programa();
        }
        return currentPrograma;
    }

    public void setSelectedPrograma(Programa entity) {
        currentPrograma = entity;
    }

    private SeguimientoProyectoFacade getFacade() {
        return ejbFacade;
    }

    private FichaUsuarioFacade getFacadeFichaUsuario() {
        return ejbFacadeFichaUsuario;
    }

    private CriterioSeguimientoProyectoFacade getFacadeCriterioSeg() {
        return ejbFacadeCriterioSeg;
    }

    private EvaluacionCriterioSeguimientoProyectoFacade getFacadeEvalCriterioSeg() {
        return ejbFacadeEvalCriterioSeg;
    }

    private FichaCaracterizacionFacade getFacadeFicha() {
        return ejbFacadeFicha;
    }

    private CriterioEvaluacionFacade getFacadeCriterioEval() {
        return ejbFacadeCriterioEval;
    }

    public List<CriterioSeguimientoProyecto> getListCriteriosSeg() {
        return listCriteriosSeg;
    }

    public List<CriterioEvaluacion> getListCriteriosEval() {
        return listCriteriosEval;
    }

    public void buscarFicha() {
        if (getSelectedFicha().getIdFichaCaracterizacion() == null && getSelectedPrograma().getNomPrg().equals("")) {
            JsfUtil.addErrorMessage(ResourceBundle.getBundle("propierties/Bundle").getString("CriteriosVacios"));
        } else {
            try {
                listBusquedaFicha = getFacadeFicha().findByIdAndPrograma(currentFicha, currentPrograma);
            } catch (Exception e) {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("propierties/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public void agregarFicha() {
        current.setIdFichaCaracterizacion(currentFicha);
        currentFicha = new FichaCaracterizacion();
        listBusquedaFicha = new ArrayList<>();
    }

    public List<FichaCaracterizacion> getListBusquedaFicha() {
        return listBusquedaFicha;
    }

    public LazyDataModel<SeguimientoProyecto> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<SeguimientoProyecto>() {
                @Override
                public List<SeguimientoProyecto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<SeguimientoProyecto> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(SeguimientoProyecto entity) {
                    return entity.getIdSeguimientoProyecto();
                }

                @Override
                public SeguimientoProyecto getRowData(String rowKey) {
                    try {
                        return getFacade().find(rowKey);
                    } catch (Exception e) {
                        return null;
                    }
                }
            };
            lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
        }
        return lazyModel;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (SeguimientoProyecto) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new SeguimientoProyecto();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SeguimientoProyectoCreated"));
            return "List";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (SeguimientoProyecto) getLazyModel().getRowData();
        listCriteriosSeg = new ArrayList<>();
        listCriteriosEval = getFacadeCriterioEval().findByTipo(new TipoCriterio((short) 1));
        for (CriterioEvaluacion criterioEval : listCriteriosEval) {

            currentCriterioSeg = new CriterioSeguimientoProyecto();
            currentCriterioSeg.setIdCriterioEvaluacion(criterioEval);
            listCriteriosSeg.add(currentCriterioSeg);
        }


        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            for (CriterioSeguimientoProyecto criterio : listCriteriosSeg) {
                if (criterio.getIdEvaluacionCriterioSeguimientoProyecto() != null) {
                    criterio.setIdSeguimientoProyecto(current);
                    getFacadeCriterioSeg().create(criterio);
                }
            }
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SeguimientoProyectoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        performDestroy();
        recreateModel();
        return "List";
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SeguimientoProyectoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void recreateModel() {
        lazyModel = null;
    }

    public int getAprendicesByMatriculado() {
        return getUsuariosByFicha(new EstadoAprendiz((short) 1)).size();
    }

    public int getAprendicesByCancelado() {
        return getUsuariosByFicha(new EstadoAprendiz((short) 3)).size();
    }

    public int getAprendicesByAplazado() {
        return getUsuariosByFicha(new EstadoAprendiz((short) 4)).size();
    }

    public int getAprendicesByTrasladado() {
        return getUsuariosByFicha(new EstadoAprendiz((short) 5)).size();
    }

    public int getAprendicesByCondicionado() {
        return getUsuariosByFicha(new EstadoAprendiz((short) 8)).size();
    }

    public int getAprendicesByActivos() {
        return getUsuariosByFicha(new EstadoAprendiz((short) 7)).size();
    }

    public List<FichaUsuario> getUsuariosByFicha(EstadoAprendiz estado) {
        return getFacadeFichaUsuario().findByEstado(estado, current.getIdFichaCaracterizacion());
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public SelectItem[] getItemsAvailableSelectOneEval() {
        return JsfUtil.getSelectItems(ejbFacadeEvalCriterioSeg.findAll(), true);
    }

    @FacesConverter(forClass = SeguimientoProyecto.class)
    public static class SeguimientoProyectoControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SeguimientoProyectoController controller = (SeguimientoProyectoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "seguimientoProyectoController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SeguimientoProyecto) {
                SeguimientoProyecto o = (SeguimientoProyecto) object;
                return getStringKey(o.getIdSeguimientoProyecto());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + SeguimientoProyecto.class.getName());
            }
        }
    }
}
