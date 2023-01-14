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

import java.text.DecimalFormat;
import java.util.Arrays;

public class TiempoCalculo {

    public static float time;
    static double tiempo_espera;
    public int clie[];
    public double tiempo_clie[];
    private String tiempo_final[];
    private String tiempo_final1[];
    private String propinas[];

    public TiempoCalculo() {
        propinas = null ;
        tiempo_final1 = null;
        tiempo_final = null;
        time = 0;
        tiempo_espera = 0;
    }

    public static void main(String[] args) {
        TiempoCalculo p = new TiempoCalculo();
//        int de[] = p.arr(10);
        int[] dee = {2, 5, 7, 8, 3};
//        System.out.println("el arreglo es: " + Arrays.toString(de));
//        System.out.println("el arreglo es: " + Arrays.toString(dee));
////        p.tiempo(de);
////        System.out.println("se demoro :" + time);
        p.inicio(dee);
        System.out.println(time);
//float n = (float)5/10;
//System.out.println(0.1+(float)(5/10));
     
    }

    public void tiempo(int[] clientes) {
        for (int i = 0; i < clientes.length; i++) {

            cocina_mesa();
            tiempo_mesa((float) clientes[i] / 10);

        }
        time = time + (float) 0.10;
    }

    public static void setTime(float time) {
        TiempoCalculo.time = time;
    }

    public static void setTiempo_espera(double tiempo_espera) {
        TiempoCalculo.tiempo_espera = tiempo_espera;
    }

    public void setClie(int[] clie) {
        this.clie = clie;
    }

    public void setTiempo_clie(double[] tiempo_clie) {
        this.tiempo_clie = tiempo_clie;
    }

    public void setTiempo_final(String[] tiempo_final) {
        this.tiempo_final = tiempo_final;
    }

    public void setTiempo_final1(String[] tiempo_final1) {
        this.tiempo_final1 = tiempo_final1;
    }

    public void setPropinas(String[] propinas) {
        this.propinas = propinas;
    }

    public static float getTime() {
        return time;
    }

    public static double getTiempo_espera() {
        return tiempo_espera;
    }

    public int[] getClie() {
        return clie;
    }

    public double[] getTiempo_clie() {
        return tiempo_clie;
    }

    public String[] getTiempo_final() {
        return tiempo_final;
    }

    public String[] getTiempo_final1() {
        return tiempo_final1;
    }

    public String[] getPropinas() {
        return propinas;
    }

    public void inicio(int[] clientes) {
       
         Cliente[] c = new Cliente[clientes.length];
        tiempo(clientes);
        System.out.println("llevan " + time);
        clie = new int[clientes.length];
        tiempo_clie = new double[clientes.length];

        //llena a los clientes con su numero de platos
        for (int i = 0; i < clientes.length; i++) {
            Cliente sc = new Cliente();
            sc.setNumPedidos(clientes[i]);
            c[i] = sc;
        }
        //recorre los clientes y aumenta 20seg a t_espera
        tiempo_clie[0] = c[0].getNumPedidos() + c[0].getTiempoEspera() + time;
        clie[0] = c[0].getNumPedidos();
        for (int i = 1; i < clientes.length; i++) {
            entregaVuelta(c[i], clientes);
            clie[i] = c[i].getNumPedidos();
            tiempo_clie[i] = c[i].getNumPedidos() + c[i].getTiempoEspera() + time + c[i - 1].getNumPedidos() + c[i - 1].getTiempoEspera();
        }
        DecimalFormat df = new DecimalFormat("#.00");
//        System.out.println((tiempo_clie[0] - clientes[0]) + " Clientes");
        double arrelg[] = new double[clientes.length];
        tiempo_final = new String[clientes.length];
        tiempo_final1 = new String[clientes.length];
        propinas = new String[clientes.length];
        for (int i = 0; i < clientes.length; i++) {
            tiempo_final[i] = df.format(tiempo_clie[i]);
            tiempo_final1[i] = tiempo_final[i].replaceAll(",", ".");
//           System.out.println(Double.parseDouble(tiempo_final1[i]));
//            System.out.println(df.format(Double.parseDouble(tiempo_final1[i])%1));//sale ,70
            String aux = df.format(Double.parseDouble(tiempo_final1[i]) % 1).replaceAll(",", "");

//            System.out.println(aux+" aux");
            if (Integer.parseInt(aux) >= 60) {
                int ti[] = tiempo1(Integer.parseInt(aux));
                int tiaux = 0;
//                System.out.println(ti[0]+" ti0");
//                System.out.println(ti[1]+" ti1");
                Double d = Double.parseDouble(tiempo_final1[i]) - Double.parseDouble(aux) / 100;

//                System.out.println(d+" d");
                tiempo_final1[i] = String.valueOf(df.format(d + ti[0] + ((float) ti[1] / 100)));
//                System.out.println(tiempo_final1[i]+" holaappp");

                tiempo_final1[i] = tiempo_final1[i].replaceAll(",", ".");
                propinas[i] = propina(d + ti[0] + ((float) ti[1] / 100));
            }
//            System.out.println(Arrays.toString(tiempo1(Integer.parseInt(aux))));
            propinas[i] = propina(Double.parseDouble(tiempo_final1[i].replaceAll(",", ".")));
        }
//        System.out.println(Arrays.toString(clie));
//        System.out.println(Arrays.toString(tiempo_final) + " tiempo fianl");
//        System.out.println(Arrays.toString(tiempo_final1) + " tiempo fianl1");
//        System.out.println(Arrays.toString(propinas) + " propinas");
//        System.out.println(Arrays.toString(strindouble(propinas)) + " arreglooooo propinas");
//        System.out.println(Arrays.toString(strindouble(tiempo_final1)) + " arreglooooo tiempo final");
//        
      
    }
    public int[] tiempo1(int segundos) {

        int minutos = segundos / 60;

        segundos %= 60;

        int[] ti = {minutos, segundos};

        return ti;
    }
    public String propina(double tiempo) {
        DecimalFormat df = new DecimalFormat("#0.00");
        double total = (float) 1 / tiempo;
        String propina2 = String.valueOf(df.format((total * 10)));
        return propina2;
    }
    public double[] shellarreglo(double arreglo[]) {
        double arreglog[] = new double[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            arreglog[i] = arreglo[i];
        }
        int salto;
        double aux;
        boolean cambios;

        for (salto = arreglog.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {   // Mientras se intercambie algún elemento
                cambios = false;
                for (int i = salto; i < arreglog.length; i++) // se da una pasada
                {
                    if (arreglog[i - salto] > arreglog[i]) {       // y si están desordenados
                        aux = arreglog[i];                  // se reordenan
                        arreglog[i] = arreglog[i - salto];
                        arreglog[i - salto] = aux;
                        cambios = true;              // y se marca como cambio.
                    }

                }
            }
        }

        return arreglog;
    }
//transforma de strig a double
    public double[] strindouble(String[] arre) {
        double arreg[] = new double[arre.length];
        String arreglo[] = new String[arre.length];
        DecimalFormat df = new DecimalFormat("#.00");

        for (int i = 0; i < arre.length; i++) {
            String a = arre[i].replaceAll(",", ".");
            arreglo[i] = String.valueOf(a);

            arreg[i] = Double.parseDouble(arreglo[i]);
        }
        arreg = shellarreglo(arreg);
        return arreg;
    }
    public void cocina_mesa() {
        time = time + (float) 0.10;
    }
//añade tiempo q va de la mesa a la cocina
    public void entregaVuelta(Cliente clientes, int[] arreglo) {
        tiempo_espera = tiempo_espera + 0.20;

        clientes.setTiempoEspera(tiempo_espera);

    }
// añade tiempo a la mesa
    public void tiempo_mesa(float tiempo) {
        time = time + (float) tiempo;
    }

}
