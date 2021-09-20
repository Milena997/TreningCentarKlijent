package rs.ac.bg.fon.ai.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.ai.domen.Trening;

public class ModelTabeleTreniranje extends AbstractTableModel{
    
   List<Trening> listPp;
    String[] kolone={"Trener", "Polaznik", "VrstaVezbe", "Grad","Clanarina", "Sala"};

    public ModelTabeleTreniranje() {
        listPp= new ArrayList<>();
    }

    public ModelTabeleTreniranje(List<Trening> listPp) {
        this.listPp = listPp;
    }

   
    
    
    
    
    @Override
    public int getRowCount() {
    return listPp.size();
    }

    @Override
    public int getColumnCount() {
      return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
   Trening p= listPp.get(rowIndex);
   switch (columnIndex) {
            case 0:
                return p.getTrenenr().toString();
            case 1:
                return p.getPolaznik().toString();
            case 2:
                return p.getVv();
            case 3:
                return p.getGrad();
                  case 4:
                return p.getClanarina().getIznos();
                  case 5:
                return p.getSala();
            default:
                return "n/a";
        }
 
    }
    
     @Override
    public String getColumnName(int column) {
   return kolone[column];}
    
//    
     public void dodajTrening(Trening p){
        listPp.add(p);
        fireTableDataChanged();
    }
    public  void obrisiTrening(int row){
        listPp.remove(row);
        fireTableDataChanged();
    }

    public List<Trening> getListaPP() {
        return listPp;
    }
//    

}
