/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import model.dao.DividaDao;
import model.dao.entidades.Divida;
import org.primefaces.model.chart.PieChartModel;
 
@ManagedBean
@RequestScoped
public class RelatorioBean implements Serializable {
 
   private PieChartModel graficoModel;
   private DividaDao dao = new DividaDao();
 
    @PostConstruct
    public void init() {
        criarModelTorta();
    }
    
    
    public PieChartModel getGraficoModel() {
        return graficoModel;
    }
     
    private void criarModelTorta() {
        criarGraficoRelatorio();
    }
 
    private void criarGraficoRelatorio() {
        List<Divida> lista = dao.listaDividas();
         graficoModel = new PieChartModel();
 
        int contPago = 0; 
        int contNegativado = 0;
        
        for (Divida d : lista) {
            if(d.getStatus().equals("Pago")){
                contPago++;
            } else if (d.getStatus().equals("Negativado")) {
                contNegativado++;
            }
        }
        
        graficoModel.set("Pago", contPago);
        graficoModel.set("Negativado", contNegativado);
         
        graficoModel.setTitle("Relatórios de Dividas");
        graficoModel.setLegendPosition("w");
        graficoModel.setShadow(false);
    }
  
 
}
