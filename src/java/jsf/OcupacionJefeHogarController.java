package jsf;

import jpa.entities.OcupacionJefeHogar;
import jsf.util.JsfUtil;
import jpa.sessions.OcupacionJefeHogarFacade;

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

@ManagedBean(name = "ocupacionJefeHogarController")
@SessionScoped
public class OcupacionJefeHogarController implements Serializable {

    private OcupacionJefeHogar current;
    private LazyDataModel<OcupacionJefeHogar> lazyModel = null;
    @EJB
    private jpa.sessions.OcupacionJefeHogarFacade ejbFacade;

    public OcupacionJefeHogarController() {
    }

    public OcupacionJefeHogar getSelected() {
        if (current == null) {
            current = new OcupacionJefeHogar();
        }
        return current;
    }

    public void setSelected(OcupacionJefeHogar entity) {
        current = entity;
    }

    private OcupacionJefeHogarFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<OcupacionJefeHogar> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<OcupacionJefeHogar>() {
                @Override
                public List<OcupacionJefeHogar> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<OcupacionJefeHogar> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(OcupacionJefeHogar entity) {
                    return entity.getIdOcupacionJefeHogar();
                }

                @Override
                public OcupacionJefeHogar getRowData(String rowKey) {
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
        current = (OcupacionJefeHogar) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new OcupacionJefeHogar();
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("OcupacionJefeHogarCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (OcupacionJefeHogar) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("OcupacionJefeHogarUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("OcupacionJefeHogarDeleted"));
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

    @FacesConverter(forClass = OcupacionJefeHogar.class)
    public static class OcupacionJefeHogarControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OcupacionJefeHogarController controller = (OcupacionJefeHogarController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ocupacionJefeHogarController");
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
            if (object instanceof OcupacionJefeHogar) {
                OcupacionJefeHogar o = (OcupacionJefeHogar) object;
                return getStringKey(o.getIdOcupacionJefeHogar());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + OcupacionJefeHogar.class.getName());
            }
        }
    }
}
