package restaurante;

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

import java.util.Random;

public class Restaurante {
    private int numMeseros;
    Cliente[] clientes;
    Mesero[] meseros;
    Random random = new Random();
    private boolean meseroExtra = false;

    public Restaurante() {
        numMeseros = 0;

    }
    
    public void generarMesas(int num) {
        clientes = new Cliente[num];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(random.nextInt(10) + 1);
        }
    }

    public void crearMeseros() {
        numMeseros = (int) clientes.length / 3;

        int cont = 0;

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].getNumPedidos() > 5) {
                cont++;
            }
        }
        if (cont > ((int) clientes.length / 2)) {
            meseroExtra = true;
        }

    }

    public void mesas_atender() {
        if(!meseroExtra){
             meseros = new Mesero[numMeseros];
             
             
        }else{
            meseros = new Mesero[numMeseros+1];
            
        }
      //reparte los clientes
        System.out.println(meseros.length+" Meserooosss");
        int cont = 0;
        for (int i = 0; i < meseros.length; i++) {
            
            if (clientes.length % meseros.length == 0) {
                meseros[i] = new Mesero("usuario " + i, (int) clientes.length / meseros.length);
                for (int j = 0; j < (int) clientes.length / meseros.length; j++) {
                    meseros[i].setMesasAsigandas(j, clientes[cont].getNumPedidos());
                    cont++;
                }
            } else {

                if (meseros.length - 1 != i) {
                    meseros[i] = new Mesero("usuario " + i, (int) clientes.length / numMeseros);
                    for (int j = 0; j < (int) clientes.length / numMeseros; j++) {
                        meseros[i].setMesasAsigandas(j, clientes[cont].getNumPedidos());
                        cont++;
                    }
                } else {
                        meseros[i] = new Mesero("usuario " + i, clientes.length % numMeseros);
//                        System.out.println(clientes.length % numMeseros + "-----k----");
                        for (int j = 0; j < clientes.length % numMeseros; j++) {
                            meseros[i].setMesasAsigandas(j, clientes[cont].getNumPedidos());
                            cont++;
                        }

                }
            }
        }
//       
    }

    public Mesero[] getMeseros() {
        return meseros;
    }

    public int getNumMeseros() {
        return numMeseros;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

}

