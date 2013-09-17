package jsf;

import jpa.entities.CriterioEvaluacion;
import jsf.util.JsfUtil;
import jpa.sessions.CriterioEvaluacionFacade;

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

@ManagedBean(name = "criterioEvaluacionController")
@SessionScoped
public class CriterioEvaluacionController implements Serializable {

    private CriterioEvaluacion current;
    private LazyDataModel<CriterioEvaluacion> lazyModel = null;
    @EJB
    private jpa.sessions.CriterioEvaluacionFacade ejbFacade;

    public CriterioEvaluacionController() {
    }

    public CriterioEvaluacion getSelected() {
        if (current == null) {
            current = new CriterioEvaluacion();
        }
        return current;
    }

    public void setSelected(CriterioEvaluacion entity) {
        current = entity;
    }

    private CriterioEvaluacionFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<CriterioEvaluacion> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<CriterioEvaluacion>() {
                @Override
                public List<CriterioEvaluacion> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<CriterioEvaluacion> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(CriterioEvaluacion entity) {
                    return entity.getIdCriterioEvaluacion();
                }

                @Override
                public CriterioEvaluacion getRowData(String rowKey) {
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
        current = (CriterioEvaluacion) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new CriterioEvaluacion();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CriterioEvaluacionCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (CriterioEvaluacion) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CriterioEvaluacionUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CriterioEvaluacionDeleted"));
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

    @FacesConverter(forClass = CriterioEvaluacion.class)
    public static class CriterioEvaluacionControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CriterioEvaluacionController controller = (CriterioEvaluacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "criterioEvaluacionController");
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
            if (object instanceof CriterioEvaluacion) {
                CriterioEvaluacion o = (CriterioEvaluacion) object;
                return getStringKey(o.getIdCriterioEvaluacion());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + CriterioEvaluacion.class.getName());
            }
        }
    }
}
