package jsf;

import jpa.entities.DependenciaEconomica;
import jsf.util.JsfUtil;
import jpa.sessions.DependenciaEconomicaFacade;

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

@ManagedBean(name = "dependenciaEconomicaController")
@SessionScoped
public class DependenciaEconomicaController implements Serializable {

    private DependenciaEconomica current;
    private LazyDataModel<DependenciaEconomica> lazyModel = null;
    @EJB
    private jpa.sessions.DependenciaEconomicaFacade ejbFacade;

    public DependenciaEconomicaController() {
    }

    public DependenciaEconomica getSelected() {
        if (current == null) {
            current = new DependenciaEconomica();
        }
        return current;
    }

    public void setSelected(DependenciaEconomica entity) {
        current = entity;
    }

    private DependenciaEconomicaFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<DependenciaEconomica> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<DependenciaEconomica>() {
                @Override
                public List<DependenciaEconomica> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<DependenciaEconomica> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(DependenciaEconomica entity) {
                    return entity.getIdDependenciaEconomica();
                }

                @Override
                public DependenciaEconomica getRowData(String rowKey) {
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
        current = (DependenciaEconomica) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new DependenciaEconomica();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("DependenciaEconomicaCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (DependenciaEconomica) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("DependenciaEconomicaUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("DependenciaEconomicaDeleted"));
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

    @FacesConverter(forClass = DependenciaEconomica.class)
    public static class DependenciaEconomicaControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DependenciaEconomicaController controller = (DependenciaEconomicaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "dependenciaEconomicaController");
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
            if (object instanceof DependenciaEconomica) {
                DependenciaEconomica o = (DependenciaEconomica) object;
                return getStringKey(o.getIdDependenciaEconomica());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + DependenciaEconomica.class.getName());
            }
        }
    }
}
