package jsf;

import jpa.entities.SeguimientoProyecto;
import jsf.util.JsfUtil;
import jpa.sessions.SeguimientoProyectoFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import jpa.entities.CriterioEvaluacion;
import jpa.entities.CriterioSeguimientoProyecto;
import jpa.entities.EstadoAprendiz;
import jpa.entities.EvaluacionCriterioSeguimientoProyecto;
import jpa.entities.FichaUsuario;
import jpa.entities.TipoCriterio;
import jpa.sessions.CriterioEvaluacionFacade;
import jpa.sessions.CriterioSeguimientoProyectoFacade;
import jpa.sessions.EvaluacionCriterioSeguimientoProyectoFacade;
import jpa.sessions.FichaUsuarioFacade;
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

    public SeguimientoProyectoController() {
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

    private CriterioEvaluacionFacade getFacadeCriterioEval() {
        return ejbFacadeCriterioEval;
    }

    public List<CriterioSeguimientoProyecto> getListCriteriosSeg() {
        return listCriteriosSeg;
    }

    public List<CriterioEvaluacion> getListCriteriosEval() {
        return listCriteriosEval;
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
            for (CriterioSeguimientoProyecto criterio: listCriteriosSeg) {
                criterio.setIdSeguimientoProyecto(current);
                
                getFacadeCriterioSeg().create(criterio);
            }
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("SeguimientoProyectoCreated"));
            return "View";
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
            currentCriterioSeg.setIdEvaluacionCriterioSeguimientoProyecto(new EvaluacionCriterioSeguimientoProyecto());
            listCriteriosSeg.add(currentCriterioSeg);
        }
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
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

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
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
