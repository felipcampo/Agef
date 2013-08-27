package jsf;

import jpa.entities.FichaUsuario;
import jsf.util.JsfUtil;
import jpa.sessions.FichaUsuarioFacade;

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

@ManagedBean(name = "fichaUsuarioController")
@SessionScoped
public class FichaUsuarioController implements Serializable {

    private FichaUsuario current;
    private LazyDataModel<FichaUsuario> lazyModel = null;
    @EJB
    private jpa.sessions.FichaUsuarioFacade ejbFacade;

    public FichaUsuarioController() {
    }

    public FichaUsuario getSelected() {
        if (current == null) {
            current = new FichaUsuario();
            current.setFichaUsuarioPK(new jpa.entities.FichaUsuarioPK());
        }
        return current;
    }

    public void setSelected(FichaUsuario entity) {
        current = entity;
    }

    private FichaUsuarioFacade getFacade() {
        return ejbFacade;
    }

    public LazyDataModel<FichaUsuario> getLazyModel() {
        if (lazyModel == null) {
            lazyModel = new LazyDataModel<FichaUsuario>() {
                @Override
                public List<FichaUsuario> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {

                    lazyModel.setRowCount(getFacade().count(filters));
                    List<FichaUsuario> result = getFacade().getResultList(first, pageSize, sortField, sortOrder, filters);
                    if (result.isEmpty()) {
                        lazyModel.setRowCount(getFacade().count(new HashMap<String, String>()));
                    }
                    return result;
                }

                @Override
                public Object getRowKey(FichaUsuario entity) {
                    return entity.getFichaUsuarioPK();
                }

                @Override
                public FichaUsuario getRowData(String rowKey) {
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
        current = (FichaUsuario) getLazyModel().getRowData();
        return "View";
    }

    public String prepareCreate() {
        current = new FichaUsuario();
        current.setFichaUsuarioPK(new jpa.entities.FichaUsuarioPK());
        return "Create";
    }

    public String create() {
        try {
            current.getFichaUsuarioPK().setIdUsuario(current.getUsuario().getIdUsuario());
            current.getFichaUsuarioPK().setIdFichaCaracterizacion(current.getFichaCaracterizacion().getIdFichaCaracterizacion());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("FichaUsuarioCreated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (FichaUsuario) getLazyModel().getRowData();
        return "Edit";
    }

    public String update() {
        try {
            current.getFichaUsuarioPK().setIdUsuario(current.getUsuario().getIdUsuario());
            current.getFichaUsuarioPK().setIdFichaCaracterizacion(current.getFichaCaracterizacion().getIdFichaCaracterizacion());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("FichaUsuarioUpdated"));
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/properties/Bundle").getString("FichaUsuarioDeleted"));
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

    @FacesConverter(forClass = FichaUsuario.class)
    public static class FichaUsuarioControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FichaUsuarioController controller = (FichaUsuarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "fichaUsuarioController");
            return controller.ejbFacade.find(getKey(value));
        }

        jpa.entities.FichaUsuarioPK getKey(String value) {
            jpa.entities.FichaUsuarioPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new jpa.entities.FichaUsuarioPK();
            key.setIdUsuario(Integer.parseInt(values[0]));
            key.setIdFichaCaracterizacion(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(jpa.entities.FichaUsuarioPK value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value.getIdUsuario());
            sb.append(SEPARATOR);
            sb.append(value.getIdFichaCaracterizacion());
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof FichaUsuario) {
                FichaUsuario o = (FichaUsuario) object;
                return getStringKey(o.getFichaUsuarioPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + FichaUsuario.class.getName());
            }
        }
    }
}
