package jsf;

import jpa.entities.ActividadAcademica;
import jsf.util.JsfUtil;
import jpa.sessions.ActividadAcademicaFacade;

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

@ManagedBean(name = "actividadAcademicaController")
@SessionScoped
public class ActividadAcademicaController implements Serializable {

    private ActividadAcademica current;
    private LazyDataModel<ActividadAcademica> lazyModel = null;
    @EJB
    private jpa.sessions.ActividadAcademicaFacade ejbFacade;

    public ActividadAcademicaController() {
    }

    public ActividadAcademica getSelected() {
        if (current == null) {
            current = new ActividadAcademica();
        }
        return current;
    }

    public void setSelected(ActividadAcademica entity) {
        current = entity;
    }

    private ActividadAcademicaFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<ActividadAcademica> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<ActividadAcademica>() {
                @Override
                public List<ActividadAcademica> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<ActividadAcademica> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(ActividadAcademica entity) {
                    return entity.getIdActividadAcademica();
                }

                @Override
                public ActividadAcademica getRowData(String rowKey) {
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
        current = (ActividadAcademica) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new ActividadAcademica();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("ActividadAcademicaCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (ActividadAcademica) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("ActividadAcademicaUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("ActividadAcademicaDeleted"));
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

    @FacesConverter(forClass = ActividadAcademica.class)
    public static class ActividadAcademicaControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ActividadAcademicaController controller = (ActividadAcademicaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "actividadAcademicaController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Short getKey(String value) {
            java.lang.Short key;
            key = Short.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Short value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ActividadAcademica) {
                ActividadAcademica o = (ActividadAcademica) object;
                return getStringKey(o.getIdActividadAcademica());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ActividadAcademica.class.getName());
            }
        }
    }
}
