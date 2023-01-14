/**
* SISTEMA : Problema Programacional Restaurante
* MODULO : Erick Humberto Bonilla Perugachi -- Elián José Cóndor Farinango
**** Rommel Alexis Pachacama Guala -- Alexis Fabricio Tenegusñay Pelagallo
* **** Lissette Carolina Vasco Iza
* PROCESO : Programacional
* DESCRIPCIÓN: Elaborar un programa en Netbeans, que resuelva el proble
* **** planteado que es el del Restaurante.
* ANALISTAS : Erick Humberto Bonilla Perugachi -- Elián José Cóndor Farinango
* ***** Rommel Alexis Pachacama Guala -- Alexis Fabricio Tenegusñay Pelagallo
* ***** Lissette Carolina Vasco Iza
* PROGRAMADOR: Erick Humberto Bonilla Perugachi -- Elián José Cóndor Farinango
* **** Rommel Alexis Pachacama Guala -- Alexis Fabricio Tenegusñay Pelagallo
* **** Lissette Carolina Vasco Iza
* FECHA CREACIÓN, MODIFICACIÓN:17 AGOSTO 2022 - 9 SEPTIEMBRE 2022 
*/
package restaurante;

public class Mesero {
   private String nombre;
   private int propina;
   private int numP;
   private int [] mesasAsigandas;

    public Mesero(String nombre,int mesas) {
        this.nombre = nombre;
        mesasAsigandas = new int [mesas];
    }

    public String getNombre() {
        return nombre;
    }

    public int getPropina() {
        return propina;
    }

    public int[] getMesasAsigandas() {
        return mesasAsigandas;
    }

    public void setMesasAsigandas(int index, int cantidad) {
        this.mesasAsigandas[index] = cantidad;
    }

    public void setMesasAsigandas(int[] mesasAsigandas) {
        this.mesasAsigandas = mesasAsigandas;
    }
   
   
}
