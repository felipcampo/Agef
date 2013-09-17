package jsf;

import jpa.entities.CriterioSeguimientoProyecto;
import jsf.util.JsfUtil;
import jpa.sessions.CriterioSeguimientoProyectoFacade;

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

@ManagedBean(name = "criterioSeguimientoProyectoController")
@SessionScoped
public class CriterioSeguimientoProyectoController implements Serializable {

    private CriterioSeguimientoProyecto current;
    private LazyDataModel<CriterioSeguimientoProyecto> lazyModel = null;
    @EJB
    private jpa.sessions.CriterioSeguimientoProyectoFacade ejbFacade;

    public CriterioSeguimientoProyectoController() {
    }

    public CriterioSeguimientoProyecto getSelected() {
        if (current == null) {
            current = new CriterioSeguimientoProyecto();
        }
        return current;
    }

    public void setSelected(CriterioSeguimientoProyecto entity) {
        current = entity;
    }

    private CriterioSeguimientoProyectoFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<CriterioSeguimientoProyecto> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<CriterioSeguimientoProyecto>() {
                @Override
                public List<CriterioSeguimientoProyecto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<CriterioSeguimientoProyecto> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(CriterioSeguimientoProyecto entity) {
                    return entity.getIdCriterioSeguimientoProyecto();
                }

                @Override
                public CriterioSeguimientoProyecto getRowData(String rowKey) {
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
        current = (CriterioSeguimientoProyecto) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new CriterioSeguimientoProyecto();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CriterioSeguimientoProyectoCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (CriterioSeguimientoProyecto) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CriterioSeguimientoProyectoUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("CriterioSeguimientoProyectoDeleted"));
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

    @FacesConverter(forClass = CriterioSeguimientoProyecto.class)
    public static class CriterioSeguimientoProyectoControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CriterioSeguimientoProyectoController controller = (CriterioSeguimientoProyectoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "criterioSeguimientoProyectoController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
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
            if (object instanceof CriterioSeguimientoProyecto) {
                CriterioSeguimientoProyecto o = (CriterioSeguimientoProyecto) object;
                return getStringKey(o.getIdCriterioSeguimientoProyecto());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + CriterioSeguimientoProyecto.class.getName());
            }
        }
    }
}
