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
package Graficos;

import Atxy2k.CustomTextField.RestrictedTextField;
import restaurante.Restaurante;
import java.awt.Dimension;
import java.awt.Image;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import restaurante.TiempoCalculo;

public final class VentanaJuego extends javax.swing.JFrame {

    Restaurante res = new Restaurante();
    private static int UNIDADES = 20;
    private static int DISTANCIA = UNIDADES * 5;
    private int[] posMX = {750, 825, 900, 975};
    private int[] posMY = {100, 200, 300, 400};
    MeserosGraficos[] meserosGraficos;
    MesasGraficos[] mesas;
    HiloMover[] moverMes;
    private String [] topMeseros;
    public VentanaJuego() {
        initComponents();
        validacionesEspacios();
        icono_app(fondo, "trama", new Dimension(fondo.getWidth(), fondo.getHeight()));
        icono_app(cocina, "cocina", new Dimension(cocina.getWidth(), cocina.getHeight()));
        icono_app(pared, "pared", new Dimension(pared.getWidth(), pared.getHeight()));
        icono_app(piso, "piso", new Dimension(piso.getWidth(), piso.getHeight()));
        setLocationRelativeTo(null);
        setResizable(false);
        puntos.setVisible(false);

    }
//dibuja meseros
    public void cargarMeseros() {
        meserosGraficos = new MeserosGraficos[res.getMeseros().length];
        int cont = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (cont < meserosGraficos.length) {
                    meserosGraficos[cont] = new MeserosGraficos(posMX[i], posMY[j]);
                    icono_app(meserosGraficos[cont], "mesero", new Dimension(meserosGraficos[cont].getWidth(), meserosGraficos[cont].getHeight()));
                    piso.add(meserosGraficos[cont]);
                    cont++;
                } else {
                    break;
                }
            }
        }

        juegoM.repaint();
    }
    //dibuja clientes
    public void cargarMesas() {
        mesas = new MesasGraficos[res.getClientes().length];
        int cont = 0;
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (cont < mesas.length) {
                    mesas[cont] = new MesasGraficos(DISTANCIA * i, DISTANCIA * j);
                    icono_app(mesas[cont], "mesa", new Dimension(64, 64));
                    piso.add(mesas[cont]);
                    cont++;
                } else {
                    break;
                }
            }
        }
    }

    public void iniciarProseso(int numClient) {
        res.generarMesas(numClient);
        res.crearMeseros();
        res.mesas_atender();
       topMeseros = new String[res.getMeseros().length];
        for (int i = 0; i < res.getMeseros().length; i++) {
            TiempoCalculo p = new TiempoCalculo();
            if(res.getMeseros()[i].getMesasAsigandas().length==0){
                res.getMeseros()[i].setMesasAsigandas(res.getMeseros()[i-1].getMesasAsigandas());
            }
            p.inicio(res.getMeseros()[i].getMesasAsigandas());
            //propinas
            topMeseros[i] = p.getPropinas()[0];
            //tiempo
        }
//        System.out.println("----------- Arreglo final q queremos--------------");
//        System.out.println(Arrays.toString(topMeseros));
    }
    
     private void validacionesEspacios(){
        RestrictedTextField r = new RestrictedTextField(intClientes);
        r.setOnlyNums(true);

    }
     //carga las iamgenes
    public void icono_app(JLabel foto_icono, String nodo, Dimension d) {

        foto_icono.setSize(d);
        ImageIcon im = new ImageIcon("src/recursos/" + nodo.toLowerCase().trim() + ".png");
        ImageIcon icono = new ImageIcon(im.getImage().getScaledInstance(foto_icono.getWidth(), foto_icono.getHeight(), Image.SCALE_DEFAULT));
        foto_icono.setIcon(icono);
        foto_icono.setLocation(foto_icono.getLocation());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        juegoM = new javax.swing.JPanel();
        piso = new javax.swing.JLabel();
        iniciar = new javax.swing.JButton();
        cocina = new javax.swing.JLabel();
        pared = new javax.swing.JLabel();
        intClientes = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        puntos = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jueguito Restaurante");

        juegoM.setBackground(new java.awt.Color(255, 255, 255));
        juegoM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        piso.setBackground(new java.awt.Color(255, 255, 51));
        piso.setOpaque(true);
        juegoM.add(piso, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 94, 1250, 567));

        iniciar.setText("INICIAR");
        iniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iniciarMouseClicked(evt);
            }
        });
        juegoM.add(iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 694, 157, 37));

        cocina.setBackground(new java.awt.Color(51, 255, 0));
        cocina.setOpaque(true);
        juegoM.add(cocina, new org.netbeans.lib.awtextra.AbsoluteConstraints(1245, 0, 142, 661));

        pared.setBackground(new java.awt.Color(255, 51, 51));
        pared.setOpaque(true);
        juegoM.add(pared, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1250, 100));

        intClientes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        juegoM.add(intClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 700, 80, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese el numero de clientes:");
        juegoM.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 710, -1, 29));

        puntos.setText("Puntajes");
        puntos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                puntosMouseClicked(evt);
            }
        });
        juegoM.add(puntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 700, 130, 30));

        fondo.setBackground(new java.awt.Color(0, 51, 255));
        fondo.setOpaque(true);
        juegoM.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 780));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(juegoM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1352, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(juegoM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void iniciarAnimacion() {
        Random random = new Random();
        moverMes = new HiloMover[res.getMeseros().length];
        int cont = 0;
        for (int i = 0; i < res.getMeseros().length; i++) {
            moverMes[i] = new HiloMover(meserosGraficos[i], "hilo" + i, mesas, arr(res.getMeseros()[i].getMesasAsigandas().length,
                    res.getClientes().length), cont, random.nextInt(3));
            System.out.println(Arrays.toString(arr(res.getMeseros()[i].getMesasAsigandas().length,
                    res.getClientes().length)) + "Arreglo de posiciones");
            moverMes[i].start();
            cont += res.getMeseros()[i].getMesasAsigandas().length;
        }

    }
//pone las posiciones para q se muevan
    public int[] arr(int num, int numClien) {
        if (num == 0) {
            num = 3;
        }
        int de[] = new int[num];
        int cont = 0;
        List<Integer> numbers = new ArrayList<>(numClien);
        for (int i = 0; i < numClien; i++) {
            numbers.add(i);

        }
        Random random = new Random();

        while (cont < de.length) {

            int randomIndex = random.nextInt(numbers.size());

            de[cont] = numbers.get(randomIndex);
            numbers.remove(randomIndex);

            cont++;
        }
        return de;
    }
    boolean banderita = false;
    private void iniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciarMouseClicked
        try {
        if (!banderita) {
                if (mesas != null) {
                    for (int i = 0; i < res.getClientes().length; i++) {
                        piso.remove(mesas[i]);
                    }
                }
                int numClien = Integer.parseInt(intClientes.getText());
                if(numClien>=3 && numClien<=30){
                iniciarProseso(numClien);
                cargarMeseros();
                cargarMesas();
                iniciarAnimacion();
                iniciar.setText("Parar");
                banderita = true;
                puntos.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Ingresa numeros del 3 a 30");
                }
               
            } else {
                iniciar.setText("Reiniciar");
                for (int i = 0; i < res.getMeseros().length; i++) {
                    moverMes[i].stop();
                    piso.remove(meserosGraficos[i]);
                }
                banderita = false;
            }

       
          piso.repaint();
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Ingresa numeros");
        }
    }//GEN-LAST:event_iniciarMouseClicked

    private void puntosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_puntosMouseClicked
       //cambia pantallas
        Puntajes p = new Puntajes(topMeseros);
        p.setVisible(true);
         dispose();
    }//GEN-LAST:event_puntosMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cocina;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton iniciar;
    private javax.swing.JTextField intClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel juegoM;
    private javax.swing.JLabel pared;
    private javax.swing.JLabel piso;
    private javax.swing.JButton puntos;
    // End of variables declaration//GEN-END:variables
}

class HiloMover extends Thread {

    private final MeserosGraficos mesMov;
    private final MesasGraficos[] mesasDes;
    private final String nombre;
    private final int[] mesasAsg;
    private final int x;
    private final int y;
    private boolean terminarAnima = false;
    private int tiempoEspera;

    public HiloMover(MeserosGraficos mesMov, String nombre, MesasGraficos[] mesasDes, int[] mesasAsignadas, int cont, int tiempoEspera) {
        this.mesMov = mesMov;
        this.mesasDes = mesasDes;
        this.nombre = nombre;
        mesasAsg = mesasAsignadas;
        x = mesMov.getX();
        y = mesMov.getY();
        this.tiempoEspera = tiempoEspera;
    }

    public void mover(int possInicial) {
        if (mesMov.getX() != mesasDes[possInicial].getX()) {
            if (mesMov.getX() > mesasDes[possInicial].getX()) {
                mesMov.setLocation(mesMov.getX() - 1, mesMov.getY());
            } else {
                mesMov.setLocation(mesMov.getX() + 1, mesMov.getY());
            }

        }
        if (mesMov.getY() != mesasDes[possInicial].getY()) {
            if (mesMov.getY() > mesasDes[possInicial].getY()) {
                mesMov.setLocation(mesMov.getX(), mesMov.getY() - 1);
            } else {
                mesMov.setLocation(mesMov.getX(), mesMov.getY() + 1);
            }
        }

    }

    public void retornar() {
        if (mesMov.getX() != x) {
            if (mesMov.getX() > x) {
                mesMov.setLocation(mesMov.getX() - 1, mesMov.getY());
            } else {
                mesMov.setLocation(mesMov.getX() + 1, mesMov.getY());
            }

        }
        if (mesMov.getY() != y) {
            if (mesMov.getY() > y) {
                mesMov.setLocation(mesMov.getX(), mesMov.getY() - 1);
            } else {
                mesMov.setLocation(mesMov.getX(), mesMov.getY() + 1);
            }
        }

    }

    public boolean isTerminarAnima() {
        return terminarAnima;
    }

    public void run() {
        int cont = 0;
        try {
            while (!terminarAnima) {
                if (cont == mesasAsg.length) {
                    if (mesMov.getY() == y && mesMov.getX() == x) {
//                        System.out.println("Termino");
                        
                        terminarAnima = true;
                    } else {
                        retornar();
                    }
                } else {
                    if (mesMov.getX() == mesasDes[mesasAsg[cont]].getX() && mesMov.getY() == mesasDes[mesasAsg[cont]].getY() && cont < mesasAsg.length) {
                        Thread.sleep(tiempoEspera * 500);
                        cont++;
                    } else {
                        mover(mesasAsg[cont]);
                    }
                }

                Thread.sleep(5);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloMover.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
