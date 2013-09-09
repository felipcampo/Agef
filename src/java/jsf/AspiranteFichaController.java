package jsf;

import jpa.entities.AspiranteFicha;
import jsf.util.JsfUtil;
import jsf.util.PaginationHelper;
import jpa.sessions.AspiranteFichaFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("aspiranteFichaController")
@SessionScoped
public class AspiranteFichaController implements Serializable {

    private AspiranteFicha current;
    private DataModel items = null;
    @EJB
    private jpa.sessions.AspiranteFichaFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public AspiranteFichaController() {
    }

    public AspiranteFicha getSelected() {
        if (current == null) {
            current = new AspiranteFicha();
            current.setAspiranteFichaPK(new jpa.entities.AspiranteFichaPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private AspiranteFichaFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {
                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (AspiranteFicha) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new AspiranteFicha();
        current.setAspiranteFichaPK(new jpa.entities.AspiranteFichaPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getAspiranteFichaPK().setIdUsuario(current.getUsuario().getIdUsuario());
            current.getAspiranteFichaPK().setIdFichaCaracterizacion(current.getFichaCaracterizacion().getIdFichaCaracterizacion());
            current.getAspiranteFichaPK().setIdEstadoAspirante(current.getEstadoAspirante().getIdEstadoAspirante());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("properties/Bundle").getString("AspiranteFichaCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (AspiranteFicha) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getAspiranteFichaPK().setIdUsuario(current.getUsuario().getIdUsuario());
            current.getAspiranteFichaPK().setIdFichaCaracterizacion(current.getFichaCaracterizacion().getIdFichaCaracterizacion());
            current.getAspiranteFichaPK().setIdEstadoAspirante(current.getEstadoAspirante().getIdEstadoAspirante());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("properties/Bundle").getString("AspiranteFichaUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("properties/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (AspiranteFicha) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("properties/Bundle").getString("AspiranteFichaDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("properties/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public AspiranteFicha getAspiranteFicha(jpa.entities.AspiranteFichaPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = AspiranteFicha.class)
    public static class AspiranteFichaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AspiranteFichaController controller = (AspiranteFichaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "aspiranteFichaController");
            return controller.getAspiranteFicha(getKey(value));
        }

        jpa.entities.AspiranteFichaPK getKey(String value) {
            jpa.entities.AspiranteFichaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new jpa.entities.AspiranteFichaPK();
            key.setIdEstadoAspirante(Short.parseShort(values[0]));
            key.setIdFichaCaracterizacion(Integer.parseInt(values[1]));
            key.setIdUsuario(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(jpa.entities.AspiranteFichaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdEstadoAspirante());
            sb.append(SEPARATOR);
            sb.append(value.getIdFichaCaracterizacion());
            sb.append(SEPARATOR);
            sb.append(value.getIdUsuario());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof AspiranteFicha) {
                AspiranteFicha o = (AspiranteFicha) object;
                return getStringKey(o.getAspiranteFichaPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + AspiranteFicha.class.getName());
            }
        }
    }
}
