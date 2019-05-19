package Forms;
import Clases.Constantes;
import Clases.Cubilete;
import Clases.Tablero;
import java.awt.Image;
import javax.swing.ImageIcon;
import TSocket.TClient.Cliente.TSClientClienteSocket;
import TSocket.TClient.Cliente.TSocketInfo;
import com.google.gson.Gson;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
public final class FormClienteJuego extends javax.swing.JFrame {
    
    TSClientClienteSocket cliente;
    Tablero tablero;
    Cubilete cubilete;
    int canTirosRealizados,tamGrande,tamPeque,aux;
    String jugada,miNombre,miId;
    boolean enTurno,puedePedirJugadas;
    boolean[] modificable;
    LinkedList listaJugadores;
    
    public FormClienteJuego() {
        initComponents();
        tablero=new Tablero();
        miNombre="Joselo";
        miId="null";
        tamGrande=imagenDado1.getWidth();
        tamPeque=tamGrande-20;
        mostrarDadosIniciales();
        canTirosRealizados=0;
        jugador1.setText(miNombre);
        //cliente = new TSClientClienteSocket("192.168.43.121",9090){//ELITO
        //cliente = new TSClientClienteSocket("192.168.1.104",9090){//JROGE
        cliente = new TSClientClienteSocket("127.0.0.1",9090){//LOCAL
            @Override
            public void onRead(String mensaje){String[] msj=mensaje.split("_");
                switch(msj[2]){
                    case Constantes.MOSTRAR_DADOS:mostrarDados(msj[3]);break;
                    case Constantes.ES_TU_TURNO:iniciarTurno();break;
                    case Constantes.LISTA_DE_JUGADAS:mostrarListaDeJugadas(msj[3]);break;
                    case Constantes.NOMBRE_JUGADOR_EN_TURNO:jugadorEnTurno.setText(msj[3]);break;
                    case Constantes.NUEVO_ID:setMiNuevoId(msj[3]);break;
                    case Constantes.NOMBRE_JUGADORES:mostrarNombreDeJugadores(msj[3]);break;
                    case Constantes.CAMBIAR_TABLERO:setTablero(msj[3],msj[4]);break;
                }
            }
            @Override
            public void onWrite(String mensaje){}
            @Override
            public void onConnected(TSocketInfo socketInfo){
                    System.out.println("CONECTADO");}
            @Override
            public void onDisconnect(TSocketInfo socketInfo){
                    System.out.println("DESCONECTADO");}
            @Override
            public void onReconnect(TSocketInfo socketInfo){
                    System.out.println("RECONECTADO");}
            @Override
            public void onError(int errorCode){}
        };cliente.connect();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonLanzar = new javax.swing.JButton();
        imagenDado1 = new javax.swing.JLabel();
        imagenDado2 = new javax.swing.JLabel();
        imagenDado3 = new javax.swing.JLabel();
        imagenDado4 = new javax.swing.JLabel();
        imagenDado5 = new javax.swing.JLabel();
        jugadorEnTurno = new javax.swing.JLabel();
        jugador5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableroJugador1 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableroJugador3 = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableroJugador2 = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableroJugador4 = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        tableroJugador5 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaJugadas = new javax.swing.JList<>();
        jugador2 = new javax.swing.JLabel();
        jugador3 = new javax.swing.JLabel();
        jugador1 = new javax.swing.JLabel();
        jugador4 = new javax.swing.JLabel();
        ultimaJugadaJugador2 = new javax.swing.JLabel();
        ultimaJugadaJugador3 = new javax.swing.JLabel();
        ultimaJugadaJugador4 = new javax.swing.JLabel();
        ultimaJugadaJugador5 = new javax.swing.JLabel();
        ultimaJugadaJugador1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonLanzar.setBackground(new java.awt.Color(0, 153, 153));
        botonLanzar.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        botonLanzar.setText("LANZAR DADOS");
        botonLanzar.setEnabled(false);
        botonLanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLanzarActionPerformed(evt);
            }
        });

        imagenDado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Dado1.jpg"))); // NOI18N
        imagenDado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagenDado1MouseClicked(evt);
            }
        });

        imagenDado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Dado2.png"))); // NOI18N
        imagenDado2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagenDado2MouseClicked(evt);
            }
        });

        imagenDado3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Dado3.png"))); // NOI18N
        imagenDado3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagenDado3MouseClicked(evt);
            }
        });

        imagenDado4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Dado4.png"))); // NOI18N
        imagenDado4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagenDado4MouseClicked(evt);
            }
        });

        imagenDado5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Dado5.png"))); // NOI18N
        imagenDado5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagenDado5MouseClicked(evt);
            }
        });

        jugadorEnTurno.setBackground(new java.awt.Color(153, 153, 0));
        jugadorEnTurno.setFont(new java.awt.Font("Courier New", 1, 30)); // NOI18N
        jugadorEnTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugadorEnTurno.setText("jugadorEnTurno");

        jugador5.setBackground(new java.awt.Color(153, 153, 0));
        jugador5.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        jugador5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugador5.setText("jugador5");

        tableroJugador1.setBackground(new java.awt.Color(247, 193, 152));
        tableroJugador1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        tableroJugador1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableroJugador1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableroJugador1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableroJugador1.setDoubleBuffered(true);
        tableroJugador1.setDragEnabled(true);
        tableroJugador1.setDropMode(javax.swing.DropMode.ON);
        tableroJugador1.setFocusable(false);
        tableroJugador1.setGridColor(new java.awt.Color(0, 0, 0));
        tableroJugador1.setMinimumSize(new java.awt.Dimension(45, 150));
        tableroJugador1.setOpaque(false);
        tableroJugador1.setPreferredSize(new java.awt.Dimension(75, 95));
        tableroJugador1.setRequestFocusEnabled(false);
        tableroJugador1.setRowHeight(25);
        tableroJugador1.setRowSelectionAllowed(false);
        tableroJugador1.setShowGrid(true);
        tableroJugador1.setUpdateSelectionOnSort(false);
        tableroJugador1.setVerifyInputWhenFocusTarget(false);
        jScrollPane6.setViewportView(tableroJugador1);
        if (tableroJugador1.getColumnModel().getColumnCount() > 0) {
            tableroJugador1.getColumnModel().getColumn(0).setResizable(false);
            tableroJugador1.getColumnModel().getColumn(1).setResizable(false);
            tableroJugador1.getColumnModel().getColumn(2).setResizable(false);
        }

        tableroJugador3.setBackground(new java.awt.Color(247, 193, 152));
        tableroJugador3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        tableroJugador3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableroJugador3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableroJugador3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableroJugador3.setDoubleBuffered(true);
        tableroJugador3.setDragEnabled(true);
        tableroJugador3.setDropMode(javax.swing.DropMode.ON);
        tableroJugador3.setFocusable(false);
        tableroJugador3.setGridColor(new java.awt.Color(0, 0, 0));
        tableroJugador3.setMinimumSize(new java.awt.Dimension(45, 150));
        tableroJugador3.setOpaque(false);
        tableroJugador3.setPreferredSize(new java.awt.Dimension(75, 95));
        tableroJugador3.setRequestFocusEnabled(false);
        tableroJugador3.setRowHeight(25);
        tableroJugador3.setRowSelectionAllowed(false);
        tableroJugador3.setShowGrid(true);
        tableroJugador3.setUpdateSelectionOnSort(false);
        tableroJugador3.setVerifyInputWhenFocusTarget(false);
        jScrollPane9.setViewportView(tableroJugador3);
        if (tableroJugador3.getColumnModel().getColumnCount() > 0) {
            tableroJugador3.getColumnModel().getColumn(0).setResizable(false);
            tableroJugador3.getColumnModel().getColumn(1).setResizable(false);
            tableroJugador3.getColumnModel().getColumn(2).setResizable(false);
        }

        tableroJugador2.setBackground(new java.awt.Color(247, 193, 152));
        tableroJugador2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableroJugador2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableroJugador2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableroJugador2.setDoubleBuffered(true);
        tableroJugador2.setDragEnabled(true);
        tableroJugador2.setDropMode(javax.swing.DropMode.ON);
        tableroJugador2.setFocusable(false);
        tableroJugador2.setGridColor(new java.awt.Color(0, 0, 0));
        tableroJugador2.setMinimumSize(new java.awt.Dimension(45, 150));
        tableroJugador2.setOpaque(false);
        tableroJugador2.setPreferredSize(new java.awt.Dimension(75, 95));
        tableroJugador2.setRequestFocusEnabled(false);
        tableroJugador2.setRowHeight(25);
        tableroJugador2.setRowSelectionAllowed(false);
        tableroJugador2.setShowGrid(true);
        tableroJugador2.setUpdateSelectionOnSort(false);
        tableroJugador2.setVerifyInputWhenFocusTarget(false);
        jScrollPane10.setViewportView(tableroJugador2);
        if (tableroJugador2.getColumnModel().getColumnCount() > 0) {
            tableroJugador2.getColumnModel().getColumn(0).setResizable(false);
            tableroJugador2.getColumnModel().getColumn(1).setResizable(false);
            tableroJugador2.getColumnModel().getColumn(2).setResizable(false);
        }

        tableroJugador4.setBackground(new java.awt.Color(247, 193, 152));
        tableroJugador4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        tableroJugador4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableroJugador4.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableroJugador4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableroJugador4.setDoubleBuffered(true);
        tableroJugador4.setDragEnabled(true);
        tableroJugador4.setDropMode(javax.swing.DropMode.ON);
        tableroJugador4.setFocusable(false);
        tableroJugador4.setGridColor(new java.awt.Color(0, 0, 0));
        tableroJugador4.setMinimumSize(new java.awt.Dimension(45, 150));
        tableroJugador4.setOpaque(false);
        tableroJugador4.setPreferredSize(new java.awt.Dimension(75, 95));
        tableroJugador4.setRequestFocusEnabled(false);
        tableroJugador4.setRowHeight(25);
        tableroJugador4.setRowSelectionAllowed(false);
        tableroJugador4.setShowGrid(true);
        tableroJugador4.setUpdateSelectionOnSort(false);
        tableroJugador4.setVerifyInputWhenFocusTarget(false);
        jScrollPane11.setViewportView(tableroJugador4);
        if (tableroJugador4.getColumnModel().getColumnCount() > 0) {
            tableroJugador4.getColumnModel().getColumn(0).setResizable(false);
            tableroJugador4.getColumnModel().getColumn(1).setResizable(false);
            tableroJugador4.getColumnModel().getColumn(2).setResizable(false);
        }

        tableroJugador5.setBackground(new java.awt.Color(247, 193, 152));
        tableroJugador5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        tableroJugador5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableroJugador5.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableroJugador5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableroJugador5.setDoubleBuffered(true);
        tableroJugador5.setDragEnabled(true);
        tableroJugador5.setDropMode(javax.swing.DropMode.ON);
        tableroJugador5.setFocusable(false);
        tableroJugador5.setGridColor(new java.awt.Color(0, 0, 0));
        tableroJugador5.setMinimumSize(new java.awt.Dimension(45, 150));
        tableroJugador5.setOpaque(false);
        tableroJugador5.setPreferredSize(new java.awt.Dimension(75, 95));
        tableroJugador5.setRequestFocusEnabled(false);
        tableroJugador5.setRowHeight(25);
        tableroJugador5.setRowSelectionAllowed(false);
        tableroJugador5.setShowGrid(true);
        tableroJugador5.setUpdateSelectionOnSort(false);
        tableroJugador5.setVerifyInputWhenFocusTarget(false);
        jScrollPane12.setViewportView(tableroJugador5);
        if (tableroJugador5.getColumnModel().getColumnCount() > 0) {
            tableroJugador5.getColumnModel().getColumn(0).setResizable(false);
            tableroJugador5.getColumnModel().getColumn(1).setResizable(false);
            tableroJugador5.getColumnModel().getColumn(2).setResizable(false);
        }

        listaJugadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaJugadasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaJugadas);

        jugador2.setBackground(new java.awt.Color(153, 153, 0));
        jugador2.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        jugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugador2.setText("jugador2");
        jugador2.setPreferredSize(new java.awt.Dimension(80, 20));

        jugador3.setBackground(new java.awt.Color(153, 153, 0));
        jugador3.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        jugador3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugador3.setText("jugador3");

        jugador1.setBackground(new java.awt.Color(153, 153, 0));
        jugador1.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        jugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugador1.setText("jugador1");

        jugador4.setBackground(new java.awt.Color(153, 153, 0));
        jugador4.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        jugador4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugador4.setText("jugador4");

        ultimaJugadaJugador2.setText("ultimaJugadaJugador2");

        ultimaJugadaJugador3.setText("ultimaJugadaJugador3");

        ultimaJugadaJugador4.setText("ultimaJugadaJugador4");

        ultimaJugadaJugador5.setText("ultimaJugadaJugador5");

        ultimaJugadaJugador1.setText("ultimaJugadaJugador1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(jugadorEnTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addComponent(jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ultimaJugadaJugador2))
                .addGap(140, 140, 140)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imagenDado1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(imagenDado3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(imagenDado2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(imagenDado5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imagenDado4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(171, 171, 171)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ultimaJugadaJugador4)))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(540, 540, 540)
                .addComponent(jugador5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ultimaJugadaJugador3))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ultimaJugadaJugador1)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(botonLanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ultimaJugadaJugador5)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugadorEnTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ultimaJugadaJugador2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ultimaJugadaJugador4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imagenDado1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(imagenDado3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addComponent(imagenDado2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(imagenDado5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(imagenDado4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugador5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ultimaJugadaJugador3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ultimaJugadaJugador5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(botonLanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ultimaJugadaJugador1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonLanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLanzarActionPerformed
        if (canTirosRealizados == 0) {
            cubilete=new Cubilete();
        }
        Gson json=new Gson();
        String cubileteJSON=json.toJson(cubilete);
        if(puedePedirJugadas){
            cliente.sendMensaje(Constantes.JUEGO+Constantes.LISTA_DE_JUGADAS+"_"+cubileteJSON);
        }else if (canTirosRealizados <= 2) {
            cliente.sendMensaje(Constantes.JUEGO+Constantes.GENERAR_DADOS+"_"+cubileteJSON);
        }else{
            setTableroDeJugador1();
            String tableroJSON=json.toJson(tablero);
            cliente.sendMensaje(Constantes.JUEGO+Constantes.JUGADA_ESCOGIDA+"_"+jugada+"_"+tableroJSON);
            jugada="";
            actualizarListaJugadas("");
            mostrarDadosIniciales();
            enTurno=false;
        }
        botonLanzar.setEnabled(false);
    }//GEN-LAST:event_botonLanzarActionPerformed
 
    private void imagenDado1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenDado1MouseClicked
        if(enTurno&&modificable[0])actualizarImagenDado(1);
    }//GEN-LAST:event_imagenDado1MouseClicked

    private void imagenDado2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenDado2MouseClicked
        if(enTurno&&modificable[1])actualizarImagenDado(2);
    }//GEN-LAST:event_imagenDado2MouseClicked

    private void imagenDado3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenDado3MouseClicked
        if(enTurno&&modificable[2])actualizarImagenDado(3);
    }//GEN-LAST:event_imagenDado3MouseClicked

    private void imagenDado4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenDado4MouseClicked
        if(enTurno&&modificable[3])actualizarImagenDado(4);
    }//GEN-LAST:event_imagenDado4MouseClicked

    private void imagenDado5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenDado5MouseClicked
        if(enTurno&&modificable[4])actualizarImagenDado(5);
    }//GEN-LAST:event_imagenDado5MouseClicked

    private void listaJugadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaJugadasMouseClicked
        if(enTurno&&canTirosRealizados==3){
            botonLanzar.setText("CONFIRMAR JUGADA");
            botonLanzar.setEnabled(true);
            jugada=listaJugadas.getSelectedValue();
        }
    }//GEN-LAST:event_listaJugadasMouseClicked

    private void iniciarTurno(){
        mostrarDadosIniciales();
        cliente.sendMensaje(Constantes.JUEGO + Constantes.NOMBRE_JUGADOR_EN_TURNO + "_" + miNombre);
        enTurno = true;
        botonLanzar.setEnabled(true);
        canTirosRealizados = 0;
        puedePedirJugadas = false;
        botonLanzar.setText("LANZAR DADOS");
    }
    private void mostrarDados(String cubileteJSON) {
        canTirosRealizados++;
        aux = canTirosRealizados;
        setCubilete(cubileteJSON);
        actualizarDados();
        mostrarGif();
        Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                if (canTirosRealizados == 3) {
                    todosSeleccionados();
                    if (enTurno) {
                        botonLanzar.setText("VER JUGADAS");
                        puedePedirJugadas = true;
                    }
                }
                actualizarDados();
                if (enTurno) {
                    botonLanzar.setEnabled(true);
                }
                timer.cancel();
            }
        };
        timer.schedule(tarea, 1000, 1000);
    }
    private void mostrarListaDeJugadas(String listaDeJugadas){
        actualizarListaJugadas(listaDeJugadas);
        puedePedirJugadas = false;
        botonLanzar.setText("SELECCIONAR JUGADA");
    }
    private void setTableroDeJugador1(){
        System.out.println("PASA");
        DefaultTableModel modelo=(DefaultTableModel) tableroJugador1.getModel();
        if(modelo.getValueAt(0,0).equals(" "))tablero.setAlUno(0);
        else tablero.setAlUno(Integer.parseInt((String) modelo.getValueAt(0,0)));
        if(modelo.getValueAt(0,1) .equals(" "))tablero.setEscalera(0);
        else tablero.setEscalera(Integer.parseInt((String) modelo.getValueAt(0,1)));
        if(modelo.getValueAt(0,2).equals(" "))tablero.setAlCuatro(0);
        else tablero.setAlCuatro(Integer.parseInt((String) modelo.getValueAt(0,2)));
        if(modelo.getValueAt(1,0).equals(" "))tablero.setAlDos(0);
        else tablero.setAlDos(Integer.parseInt((String) modelo.getValueAt(1,0)));
        if(modelo.getValueAt(1,1).equals(" "))tablero.setFull(0);
        else tablero.setFull(Integer.parseInt((String) modelo.getValueAt(1,1)));
        if(modelo.getValueAt(1,2).equals(" "))tablero.setAlCinco(0);
        else tablero.setAlCinco(Integer.parseInt((String) modelo.getValueAt(1,2)));
        if(modelo.getValueAt(2,0).equals(" "))tablero.setAlTres(0);
        else tablero.setAlTres(Integer.parseInt((String) modelo.getValueAt(2,0)));
        if(modelo.getValueAt(2,1).equals(" "))tablero.setPoquer(0);
        else tablero.setPoquer(Integer.parseInt((String) modelo.getValueAt(2,1)));
        if(modelo.getValueAt(2,2).equals(" "))tablero.setAlSeis(0);
        else tablero.setAlSeis(Integer.parseInt((String) modelo.getValueAt(2,2)));
        if(modelo.getValueAt(3,1).equals(" "))tablero.setGrande(0);
        else tablero.setGrande(Integer.parseInt((String) modelo.getValueAt(3,1)));
        tableroJugador1.setModel(modelo);
    }
    private void setMiNuevoId(String nuevoId){
        miId = nuevoId;
        cliente.sendMensaje(Constantes.JUEGO + Constantes.NUEVO_NOMBRE + "_" + miNombre);
    }
    private void mostrarNombreDeJugadores(String listaNombres){
        actualizarNombresJugadores(listaNombres);
        String[] nums = miId.split("r");
        setEnJugadores(false, Integer.parseInt(nums[1]));
        if(miId.equals("Jugador1")){
            iniciarTurno();
        }
    }
    
    public void setCubilete(String cubile){
        Gson json=new Gson();
        cubilete=json.fromJson(cubile, Cubilete.class);
        modificable[0]=!cubilete.getDado(0).fueElegido();
        modificable[1]=!cubilete.getDado(1).fueElegido();
        modificable[2]=!cubilete.getDado(2).fueElegido();
        modificable[3]=!cubilete.getDado(3).fueElegido();
        modificable[4]=!cubilete.getDado(4).fueElegido();
    }
    public void mostrarGif(){
        ImageIcon image = new ImageIcon(getClass().getResource(("/Imagenes/GIFMezcla.gif")));
        ImageIcon icon = new ImageIcon(image.getImage().
        getScaledInstance(tamGrande, tamGrande, Image.SCALE_DEFAULT));
        if(!cubilete.getDado(0).fueElegido){imagenDado1.setIcon(icon);}
        if(!cubilete.getDado(1).fueElegido){imagenDado2.setIcon(icon);}
        if(!cubilete.getDado(2).fueElegido){imagenDado3.setIcon(icon);}
        if(!cubilete.getDado(3).fueElegido){imagenDado4.setIcon(icon);}
        if(!cubilete.getDado(4).fueElegido){imagenDado5.setIcon(icon);}
    }
    //Si altera valores-No altera tamaños
    public void actualizarImagenDado(int i){
        boolean b=cubilete.getDado(i-1).fueElegido();
        cubilete.getDado(i-1).setFueElegido(!b);
        actualizarDados();
    }
    public void mostrarDadosIniciales(){
        modificable=new boolean[5];
        for(int i=1;i<=5;i++){
            modificable[i-1]=false;
        }
        ImageIcon image;ImageIcon icon;
        image = new ImageIcon(getClass().getResource(("/Imagenes/Dado1.png")));
        icon = new ImageIcon(image.getImage().
                getScaledInstance(tamGrande, tamGrande, Image.SCALE_DEFAULT));
        imagenDado1.setIcon(icon);
        
        image = new ImageIcon(getClass().getResource(("/Imagenes/Dado2.png")));
        icon = new ImageIcon(image.getImage().
                getScaledInstance(tamGrande, tamGrande, Image.SCALE_DEFAULT));
        imagenDado2.setIcon(icon);
        
        image = new ImageIcon(getClass().getResource(("/Imagenes/Dado3.png")));
        icon = new ImageIcon(image.getImage().
                getScaledInstance(tamGrande, tamGrande, Image.SCALE_DEFAULT));
        imagenDado3.setIcon(icon);
        
        image = new ImageIcon(getClass().getResource(("/Imagenes/Dado4.png")));
        icon = new ImageIcon(image.getImage().
                getScaledInstance(tamGrande, tamGrande, Image.SCALE_DEFAULT));
        imagenDado4.setIcon(icon);
        
        image = new ImageIcon(getClass().getResource(("/Imagenes/Dado5.png")));
        icon = new ImageIcon(image.getImage().
                getScaledInstance(tamGrande, tamGrande, Image.SCALE_DEFAULT));
        imagenDado5.setIcon(icon);
    }
    //No altera valores-Si altera tamaños
    public void todosSeleccionados(){
        cubilete.seleccionarTodos();
        todasImagenesPeque();
    }
    //No altera valores-Si altera tamaños
    public void todasImagenesPeque() {
        ImageIcon image;ImageIcon icon;
        image = new ImageIcon(getClass().
                getResource(("/Imagenes/Dado" + cubilete.getDado(0).getValor() + ".png")));
        icon = new ImageIcon(image.getImage().getScaledInstance(
                tamPeque, tamPeque, Image.SCALE_DEFAULT));
        imagenDado1.setIcon(icon);
        
        image = new ImageIcon(getClass().
                getResource(("/Imagenes/Dado" + cubilete.getDado(1).getValor() + ".png")));
        icon = new ImageIcon(image.getImage().getScaledInstance(
                tamPeque, tamPeque, Image.SCALE_DEFAULT));
        imagenDado2.setIcon(icon);
        
        image = new ImageIcon(getClass().
                getResource(("/Imagenes/Dado" + cubilete.getDado(2).getValor() + ".png")));
        icon = new ImageIcon(image.getImage().getScaledInstance(
                tamPeque, tamPeque, Image.SCALE_DEFAULT));
        imagenDado3.setIcon(icon);
        
        image = new ImageIcon(getClass().
                getResource(("/Imagenes/Dado" + cubilete.getDado(3).getValor() + ".png")));
        icon = new ImageIcon(image.getImage().getScaledInstance(
                tamPeque, tamPeque, Image.SCALE_DEFAULT));
        imagenDado4.setIcon(icon);
        
        image = new ImageIcon(getClass().
                getResource(("/Imagenes/Dado" + cubilete.getDado(4).getValor() + ".png")));
        icon = new ImageIcon(image.getImage().getScaledInstance(
                tamPeque, tamPeque, Image.SCALE_DEFAULT));
        imagenDado5.setIcon(icon);
    }
    public void actualizarListaJugadas(String list){
        DefaultListModel listModelJugadores = new DefaultListModel();
        String[] jugadas = list.split(",");
        for(int i=1;i<=jugadas.length;i++){
            if(jugadas[i-1].contains(" al ")){
                listModelJugadores.addElement(jugadas[i-1]);
            }else{
                if(jugadas[i-1].equals(Constantes.JUGADA_GRANDE)&&
                        jugada.equals(Constantes.JUGADA_DE_MANO)){
                    listModelJugadores.addElement(Constantes.JUGADA_DORMIDA);
                }else if(jugada.equals(Constantes.JUGADA_DE_MANO)){
                    listModelJugadores.addElement(jugadas[i-1]+Constantes.JUGADA_DE_MANO);
                }else{
                    listModelJugadores.addElement(jugadas[i-1]);
                }
            }
        }
        listaJugadas.setModel(listModelJugadores);
    }
    //Si altera valores-No altera tamaños
    public void actualizarDados() {
        ImageIcon icon;ImageIcon image;
        if(!cubilete.getDado(0).fueElegido()){
            image = new ImageIcon(getClass().getResource(
                    ("/Imagenes/Dado" + cubilete.getDado(0).getValor() + ".png")));
            icon = new ImageIcon(image.getImage().getScaledInstance(
                     tamGrande,tamGrande,Image.SCALE_DEFAULT));
        }else{
            image = new ImageIcon(getClass().getResource(
                    ("/Imagenes/Dado" + cubilete.getDado(0).getValor() + ".png")));
            icon = new ImageIcon(image.getImage().getScaledInstance(
                    tamPeque,tamPeque,Image.SCALE_DEFAULT));    
        }imagenDado1.setIcon(icon);
        
        if(!cubilete.getDado(1).fueElegido()){
            image = new ImageIcon(getClass().getResource(
                    ("/Imagenes/Dado" + cubilete.getDado(1).getValor() + ".png")));
            icon = new ImageIcon(image.getImage().getScaledInstance(
                     tamGrande,tamGrande,Image.SCALE_DEFAULT));
        }else{
            image = new ImageIcon(getClass().getResource(
                    ("/Imagenes/Dado" + cubilete.getDado(1).getValor() + ".png")));
            icon = new ImageIcon(image.getImage().getScaledInstance(
                    tamPeque,tamPeque,Image.SCALE_DEFAULT));    
        }imagenDado2.setIcon(icon);
        
        if(!cubilete.getDado(2).fueElegido()){
            image = new ImageIcon(getClass().getResource(
                    ("/Imagenes/Dado" + cubilete.getDado(2).getValor() + ".png")));
            icon = new ImageIcon(image.getImage().getScaledInstance(
                     tamGrande,tamGrande,Image.SCALE_DEFAULT));
        }else{
            image = new ImageIcon(getClass().getResource(
                    ("/Imagenes/Dado" + cubilete.getDado(2).getValor() + ".png")));
            icon = new ImageIcon(image.getImage().getScaledInstance(
                    tamPeque,tamPeque,Image.SCALE_DEFAULT));    
        }imagenDado3.setIcon(icon);
        
        if(!cubilete.getDado(3).fueElegido()){
            image = new ImageIcon(getClass().getResource(
                    ("/Imagenes/Dado" + cubilete.getDado(3).getValor() + ".png")));
            icon = new ImageIcon(image.getImage().getScaledInstance(
                     tamGrande,tamGrande,Image.SCALE_DEFAULT));
        }else{
            image = new ImageIcon(getClass().getResource(
                    ("/Imagenes/Dado" + cubilete.getDado(3).getValor() + ".png")));
            icon = new ImageIcon(image.getImage().getScaledInstance(
                    tamPeque,tamPeque,Image.SCALE_DEFAULT));    
        }imagenDado4.setIcon(icon);
        
        if(!cubilete.getDado(4).fueElegido()){
            image = new ImageIcon(getClass().getResource(
                    ("/Imagenes/Dado" + cubilete.getDado(4).getValor() + ".png")));
            icon = new ImageIcon(image.getImage().getScaledInstance(
                     tamGrande,tamGrande,Image.SCALE_DEFAULT));
        }else{
            image = new ImageIcon(getClass().getResource(
                    ("/Imagenes/Dado" + cubilete.getDado(4).getValor() + ".png")));
            icon = new ImageIcon(image.getImage().getScaledInstance(
                    tamPeque,tamPeque,Image.SCALE_DEFAULT));    
        }imagenDado5.setIcon(icon);
        if(cubilete.estanTodosElegidos()){
            botonLanzar.setText("VER JUGADAS");
            if(canTirosRealizados==1){
                jugada=Constantes.JUGADA_DE_MANO;
            }
            puedePedirJugadas=true;
            aux=canTirosRealizados;
            canTirosRealizados=3;
        }else{
            botonLanzar.setText("LANZAR DADOS");
            jugada="";
            puedePedirJugadas=false;
            canTirosRealizados=aux;
        }
    }
    public void actualizarNombresJugadores(String lista){
        Gson json=new Gson();
        listaJugadores= json.fromJson(lista,LinkedList.class);
        jugador2.setText("");
        tableroJugador2.setVisible(false);
        jugador3.setText("");
        tableroJugador3.setVisible(false);
        jugador4.setText("");
        tableroJugador4.setVisible(false);
        jugador5.setText("");
        tableroJugador5.setVisible(false);
        setEnJugadores(true,0);
    }
    public void setEnJugadores(boolean ponerNombres,int numJugador){
        for (int i = 1; i <= listaJugadores.size(); i++) {
            String[] cosas = listaJugadores.get(i - 1).toString().split(", ");
            String[] jugadorNum = cosas[0].split("=");
            String[] jugadorNom = cosas[1].split("=");
            String[] num = jugadorNum[1].split("r");
            String nom = jugadorNom[1];
            nom=nom.substring(0,nom.length()-1);
            int numero = Integer.parseInt(num[1]);
            String[] miNum = miId.split("r");
            int miNumero = Integer.parseInt(miNum[1]);
            int dif=miNumero-numero;
            if(ponerNombres){
                setEnJugadores(false,numero);
            }
            if(dif>0){
                switch(dif){
                    case 1:
                        if(ponerNombres) {
                            jugador3.setText(nom);
                            jugador3.setVisible(true);
                            tableroJugador3.setVisible(true);
                        } else if(numero==numJugador){
                            actualizarTablero(3);
                        }
                        break;
                    case 2:
                        if(ponerNombres){
                            jugador2.setText(nom);
                            jugador2.setVisible(true);
                            tableroJugador2.setVisible(true);
                        } else if(numero==numJugador){
                            actualizarTablero(2);
                        }
                        break;
                    case 3:
                        if(ponerNombres){
                            jugador4.setText(nom);
                            jugador4.setVisible(true);
                            tableroJugador4.setVisible(true);
                        } else if(numero==numJugador){
                            actualizarTablero(4);
                        }
                        break;
                    case 4:
                        if(ponerNombres){
                            jugador5.setText(nom);
                            jugador5.setVisible(true);
                            tableroJugador5.setVisible(true);
                        } else if(numero==numJugador){
                            actualizarTablero(5);
                        }
                        break;
                }
            }else if(dif<0){
                switch(dif){
                    case -1:
                        if(ponerNombres){
                        jugador5.setText(nom);
                        jugador5.setVisible(true);
                        tableroJugador5.setVisible(true);
                        } else if(numero==numJugador){
                            actualizarTablero(5);
                        }
                        break;
                    case -2:
                        if(ponerNombres){
                            jugador4.setText(nom);
                            jugador4.setVisible(true);
                            tableroJugador4.setVisible(true);
                        } else if(numero==numJugador){
                            actualizarTablero(4);
                        }
                        break;
                    case -3:
                        if(ponerNombres){
                            jugador2.setText(nom);
                            jugador2.setVisible(true);
                            tableroJugador2.setVisible(true);
                        } else if(numero==numJugador){
                            actualizarTablero(2);
                        }
                        break;
                    case -4:
                        if(ponerNombres){
                            jugador3.setText(nom);
                            jugador3.setVisible(true);
                            tableroJugador3.setVisible(true);
                        } else if(numero==numJugador){
                            actualizarTablero(3);
                        }
                        break;
                }
            }else{
                if(!ponerNombres&&numero==numJugador){
                    actualizarTablero(1);
                }
            }
        }
    }
    public void actualizarTablero(int numTablero){
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("_");
        modelo.addColumn("_");
        modelo.addColumn("_");
        String[] filas=new String[3];
        if(tablero.getUno()==0)filas[0]=" ";
        else filas[0]=Integer.toString(tablero.getUno());
        if(tablero.getEscalera()==0)filas[1]=" ";
        else filas[1]=Integer.toString(tablero.getEscalera());
        if(tablero.getCuatro()==0)filas[2]=" ";
        else filas[2]=Integer.toString(tablero.getCuatro());
        modelo.addRow(filas);
        
        if(tablero.getDos()==0)filas[0]=" ";
        else filas[0]=Integer.toString(tablero.getDos());
        if(tablero.getFull()==0)filas[1]=" ";
        else filas[1]=Integer.toString(tablero.getFull());
        if(tablero.getCinco()==0)filas[2]=" ";
        else filas[2]=Integer.toString(tablero.getCinco());
        modelo.addRow(filas);
        
        if(tablero.getTres()==0)filas[0]=" ";
        else filas[0]=Integer.toString(tablero.getTres());
        if(tablero.getPoquer()==0)filas[1]=" ";
        else filas[1]=Integer.toString(tablero.getPoquer());
        if(tablero.getSeis()==0)filas[2]=" ";
        else filas[2]=Integer.toString(tablero.getSeis());
        modelo.addRow(filas);
        
        filas[0]=" ";
        if(tablero.getGrande()==0)filas[1]=" ";
        else filas[1]=Integer.toString(tablero.getGrande());
        filas[2]=" ";
        modelo.addRow(filas);
        switch(numTablero){
            case 1:
                tableroJugador1.setModel(modelo);
                tableroJugador1.setFocusable(false);
                break;
            case 2:
                tableroJugador2.setModel(modelo);
                tableroJugador2.setFocusable(false);
                break;
            case 3:
                tableroJugador3.setModel(modelo);
                tableroJugador3.setFocusable(false);
                break;
            case 4:
                tableroJugador4.setModel(modelo);
                tableroJugador4.setFocusable(false);
                break;
            case 5:
                tableroJugador5.setModel(modelo);
                tableroJugador5.setFocusable(false);
                break;
        }
    }
    public void setTablero(String tableroJSON, String idJugador) {
        Gson json=new Gson();
        tablero=json.fromJson(tableroJSON, Tablero.class);
        String[] num = idJugador.split("r");
        int numero = Integer.parseInt(num[1]);
        setEnJugadores(false, numero);
    }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormClienteJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormClienteJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormClienteJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormClienteJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormClienteJuego().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonLanzar;
    private javax.swing.JLabel imagenDado1;
    private javax.swing.JLabel imagenDado2;
    private javax.swing.JLabel imagenDado3;
    private javax.swing.JLabel imagenDado4;
    private javax.swing.JLabel imagenDado5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel jugador1;
    private javax.swing.JLabel jugador2;
    private javax.swing.JLabel jugador3;
    private javax.swing.JLabel jugador4;
    private javax.swing.JLabel jugador5;
    private javax.swing.JLabel jugadorEnTurno;
    private javax.swing.JList<String> listaJugadas;
    private javax.swing.JTable tableroJugador1;
    private javax.swing.JTable tableroJugador2;
    private javax.swing.JTable tableroJugador3;
    private javax.swing.JTable tableroJugador4;
    private javax.swing.JTable tableroJugador5;
    private javax.swing.JLabel ultimaJugadaJugador1;
    private javax.swing.JLabel ultimaJugadaJugador2;
    private javax.swing.JLabel ultimaJugadaJugador3;
    private javax.swing.JLabel ultimaJugadaJugador4;
    private javax.swing.JLabel ultimaJugadaJugador5;
    // End of variables declaration//GEN-END:variables
}