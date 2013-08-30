 
  
import java.io.Serializable; 
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;  
  
@ManagedBean(name="grafico")

public class grafico implements Serializable {  
  
    private PieChartModel pieModel;  
  
    public grafico() {  
        createPieModel();  
    }  
  
    public PieChartModel getPieModel() {  
        return pieModel;  
    }  
  
    private void createPieModel() {  
        pieModel = new PieChartModel();  
  
        pieModel.set("peluche  1", 540);  
        pieModel.set("jorge 2", 325);  
        pieModel.set("henry 3", 702);  
        pieModel.set("jessi 4", 421);  
    }  
} 