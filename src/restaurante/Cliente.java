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

public class Cliente {
    private int satisfaccion = 30 ;
    private int numPedidos;
    private boolean  estado = false;
    private float  tiempoOrden = numPedidos*1f;
    private double  tiempoEspera;
    
    public Cliente(int numPedidos) {
        this.numPedidos = numPedidos;
    }

    Cliente() {
        
    }

    public int getNumPedidos() {
        return numPedidos;
    }

    public int getSatisfaccion() {
        return satisfaccion;
    }

    public boolean isEstado() {
        return estado;
    }

    public float getTiempoOrden() {
        return tiempoOrden;
    }

    public double getTiempoEspera() {
        return tiempoEspera;
    }

    public void setSatisfaccion(int satisfaccion) {
        this.satisfaccion = satisfaccion;
    }

    public void setNumPedidos(int numPedidos) {
        this.numPedidos = numPedidos;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setTiempoOrden(float tiempoOrden) {
        this.tiempoOrden = tiempoOrden;
    }

    public void setTiempoEspera(double tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }
    
}
