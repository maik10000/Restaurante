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

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import restaurante.TiempoCalculo;

public class Puntajes extends javax.swing.JFrame {

   
    public Puntajes(String [] topMeseros) {
        initComponents();
        icono_app(fondoP, "btrama");
        this.setLocationRelativeTo(null);
        in(topMeseros);
    }
    
    public void in(String [] topMeseros){
     String nombres[] = generarNombresAleatorios(topMeseros.length);
      TiempoCalculo p = new TiempoCalculo();
    double pro[]= p.strindouble(topMeseros);
 String texto = "";
    for (int i = 0; i < topMeseros.length; i++) {
        texto += "\t"+nombres[i]+" gano:         $"+pro[i]+" de propina"+"\n"+"\n";
    }
        puntos.setText(texto);
        this.repaint();
}
 public  String[] generarNombresAleatorios(int cantidad) {
        String[] nombresAleatorios = new String[cantidad];

        String[] nombres = {"Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
            "Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
            "Caritina", "Carlota", "Baltazar","josé", "pedro", "Rata Maik", "maría", "luisa", "adriana", "angela", "alan"};
        String[] apellidos = {"Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
            "Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
            "Grigalva","pérez", "rodriguez", "hernández", "martínez", "garcía", "marín", "sánchez", "smith", "rivera", "alderson"};

        for (int i = 0; i < cantidad; i++) {
            nombresAleatorios[i] = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))] + " "
                    + apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];
        }
        return nombresAleatorios;
    }
  public void icono_app(JLabel foto_icono, String nodo) {
        Dimension d = new Dimension(400,220);
        foto_icono.setSize(d);
        ImageIcon im = new ImageIcon("src/imagens/"+nodo.toLowerCase().trim() + ".png");
        ImageIcon icono = new ImageIcon(im.getImage().getScaledInstance(foto_icono.getWidth(), foto_icono.getHeight(), Image.SCALE_DEFAULT));
        foto_icono.setIcon(icono);
        foto_icono.setLocation(foto_icono.getLocation());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        puntos = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        fondoP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Puntajes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("Propinas obtenidas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        puntos.setColumns(20);
        puntos.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        puntos.setRows(5);
        puntos.setOpaque(false);
        jScrollPane1.setViewportView(puntos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 570, 430));

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 580, 150, 30));

        fondoP.setBackground(new java.awt.Color(204, 204, 255));
        fondoP.setOpaque(true);
        jPanel1.add(fondoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 640));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        VentanaJuego vj = new VentanaJuego();
        vj.setVisible(true);
             this.setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondoP;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea puntos;
    // End of variables declaration//GEN-END:variables
}
