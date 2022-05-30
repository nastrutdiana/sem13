package ro.ase.cts.unitestslab.sem13;

import java.util.ArrayList;
import java.util.List;

public class AplicatieBancara {
    private List<ContBancar> listaConturi = new ArrayList<>();

    public void adaugaCont(ContBancar contBancar){
        listaConturi.add(contBancar);
    }

    public void transferBancar(ContBancar expeditor, ContBancar destinatar, double suma){
        expeditor.setSuma(expeditor.getSuma() - suma);
        destinatar.setSuma(destinatar.getSuma() + suma);
    }

    public void stergereCont(ContBancar cont){
        for(ContBancar c : listaConturi){
            if (c.equals(cont)){
                listaConturi.remove(c);
            }
        }
    }

    public void blocareCont(ContBancar cont){
        cont.setBlocat(true);
    }
}
