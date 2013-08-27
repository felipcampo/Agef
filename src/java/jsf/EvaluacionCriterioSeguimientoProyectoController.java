package jsf;

import jpa.entities.EvaluacionCriterioSeguimientoProyecto;
import jsf.util.JsfUtil;
import jpa.sessions.EvaluacionCriterioSeguimientoProyectoFacade;

import java.io.Serializable;
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
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "evaluacionCriterioSeguimientoProyectoController")
@SessionScoped
public class EvaluacionCriterioSeguimientoProyectoController implements Serializable {

    private EvaluacionCriterioSeguimientoProyecto current;
    private LazyDataModel<EvaluacionCriterioSeguimientoProyecto> lazyModel = null;
    @EJB
    private jpa.sessions.EvaluacionCriterioSeguimientoProyectoFacade ejbFacade;

    public EvaluacionCriterioSeguimientoProyectoController() {
    }

    public EvaluacionCriterioSeguimientoProyecto getSelected() {
        if (current == null) {
            current = new EvaluacionCriterioSeguimientoProyecto();
        }
        return current;
    }

    public void setSelected(EvaluacionCriterioSeguimientoProyecto entity) {
        current = entity;
    }

    private EvaluacionCriterioSeguimientoProyectoFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<EvaluacionCriterioSeguimientoProyecto> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<EvaluacionCriterioSeguimientoProyecto>() {
                @Override
                public List<EvaluacionCriterioSeguimientoProyecto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<EvaluacionCriterioSeguimientoProyecto> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(EvaluacionCriterioSeguimientoProyecto entity) {
                    return entity.getIdEvaluacionCriterioSeguimientoProyecto();
                }

                @Override
                public EvaluacionCriterioSeguimientoProyecto getRowData(String rowKey) {
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
        current = (EvaluacionCriterioSeguimientoProyecto) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new EvaluacionCriterioSeguimientoProyecto();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EvaluacionCriterioSeguimientoProyectoCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (EvaluacionCriterioSeguimientoProyecto) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EvaluacionCriterioSeguimientoProyectoUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("EvaluacionCriterioSeguimientoProyectoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void recreateModel() {
        lazyModel = null;
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    @FacesConverter(forClass = EvaluacionCriterioSeguimientoProyecto.class)
    public static class EvaluacionCriterioSeguimientoProyectoControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EvaluacionCriterioSeguimientoProyectoController controller = (EvaluacionCriterioSeguimientoProyectoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "evaluacionCriterioSeguimientoProyectoController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EvaluacionCriterioSeguimientoProyecto) {
                EvaluacionCriterioSeguimientoProyecto o = (EvaluacionCriterioSeguimientoProyecto) object;
                return getStringKey(o.getIdEvaluacionCriterioSeguimientoProyecto());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + EvaluacionCriterioSeguimientoProyecto.class.getName());
            }
        }
    }
}
