package visao;

import cliente.Cliente;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import javax.swing.ImageIcon;
import modelo.Mensagem;

public class TelaCliente extends javax.swing.JFrame {

    Socket cliente;
    Cliente controle;
    boolean habilitado = true;
    Mensagem m;

    public TelaCliente(Cliente controle) throws IOException {
        this.controle = controle;
        m = new Mensagem();
        m = controle.receberMensagem();
        if (controle.getId().equalsIgnoreCase("0")) {
            habilitado = true;
            initComponents();
            labelVez.setText("É a sua Vez");
            labelPontosPlayer1.setText(m.getP1());
            labelPontosPlayer2.setText(m.getP2());
        } else {
            habilitado = false;
            initComponents();
            labelVez.setText("Aguarde...");
            labelPontosPlayer1.setText(m.getP2());
            labelPontosPlayer2.setText(m.getP1());
            System.out.println("Irá receber primeira jogada...");
            m = controle.receberMensagem();
            System.out.println("Recebeu Segunda Jogada");
            atualizarTela(m);
            habilitado = true;
        }
        labelPalavraOculta.setText(m.getPo());

    }

    public void atualizarForca(int numErros) {
        URL url;
        switch (numErros) {
            case 0:
                url = getClass().getResource("../imagem/erro0.jpg");
                break;
            case 1:
                url = getClass().getResource("../imagem/erro1.jpg");
                break;
            case 2:
                url = getClass().getResource("../imagem/erro2.jpg");
                break;
            case 3:
                url = getClass().getResource("../imagem/erro3.jpg");
                break;
            case 4:
                url = getClass().getResource("../imagem/erro4.jpg");
                break;
            case 5:
                url = getClass().getResource("../imagem/erro5.jpg");
                break;
            case 6:
                url = getClass().getResource("../imagem/erro6.jpg");
                break;
            default:
                url = getClass().getResource("../imagem/erro0.jpg");

        }
        Image icone = Toolkit.getDefaultToolkit().getImage(url);
        jLabelImgForca.setIcon(new ImageIcon(icone));
    }

    public void atualizarTela(Mensagem m) throws IOException {
        atualizarForca(Integer.parseInt(m.getNe()));
        if (controle.getId().equalsIgnoreCase("0")) {
            labelPontosPlayer1.setText(m.getP1());
            labelPontosPlayer2.setText(m.getP2());
        } else {
            labelPontosPlayer1.setText(m.getP2());
            labelPontosPlayer2.setText(m.getP1());
        }
        labelPalavraOculta.setText(m.getPo());
        desativarBotao(m.getLetra());
    }

    public void reinicarTela() {
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);
        buttonE.setEnabled(true);
        buttonF.setEnabled(true);
        buttonG.setEnabled(true);
        buttonH.setEnabled(true);
        buttonA.setEnabled(true);
        buttonJ.setEnabled(true);
        buttonK.setEnabled(true);
        buttonL.setEnabled(true);
        buttonM.setEnabled(true);
        buttonN.setEnabled(true);
        buttonO.setEnabled(true);
        buttonP.setEnabled(true);
        buttonQ.setEnabled(true);
        buttonR.setEnabled(true);
        buttonS.setEnabled(true);
        buttonT.setEnabled(true);
        buttonU.setEnabled(true);
        buttonV.setEnabled(true);
        buttonX.setEnabled(true);
        buttonW.setEnabled(true);
        buttonY.setEnabled(true);
        buttonZ.setEnabled(true);

    }

    public void desativarBotao(String letra) {
        switch (letra) {
            case "a":
                buttonA.setEnabled(false);
                break;
            case "b":
                buttonB.setEnabled(false);
                break;
            case "c":
                buttonC.setEnabled(false);
                break;
            case "d":
                buttonD.setEnabled(false);
                break;
            case "e":
                buttonE.setEnabled(false);
                break;
            case "f":
                buttonF.setEnabled(false);
                break;
            case "g":
                buttonG.setEnabled(false);
                break;
            case "h":
                buttonH.setEnabled(false);
                break;
            case "i":
                buttonI.setEnabled(false);
                break;
            case "j":
                buttonJ.setEnabled(false);
                break;
            case "k":
                buttonK.setEnabled(false);
                break;
            case "l":
                buttonL.setEnabled(false);
                break;
            case "m":
                buttonM.setEnabled(false);
                break;
            case "n":
                buttonN.setEnabled(false);
                break;
            case "o":
                buttonO.setEnabled(false);
                break;
            case "p":
                buttonP.setEnabled(false);
                break;
            case "q":
                buttonQ.setEnabled(false);
                break;
            case "r":
                buttonR.setEnabled(false);
                break;
            case "s":
                buttonS.setEnabled(false);
                break;
            case "t":
                buttonT.setEnabled(false);
                break;
            case "u":
                buttonU.setEnabled(false);
                break;
            case "v":
                buttonV.setEnabled(false);
                break;
            case "x":
                buttonX.setEnabled(false);
                break;
            case "w":
                buttonW.setEnabled(false);
                break;
            case "y":
                buttonY.setEnabled(false);
                break;
            case "z":
                buttonZ.setEnabled(false);
                break;

        }
    }

    public void realizarJogada(String letra) throws IOException {
        if (habilitado) {
            Mensagem m;
            controle.enviarMensagem(letra);
            desativarBotao(letra);
            m = controle.receberMensagem();
            atualizarTela(m);
            habilitado = false;
            m = controle.receberMensagem();
            atualizarTela(m);
            habilitado = true;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        buttonH = new java.awt.Button();
        buttonO = new java.awt.Button();
        buttonB = new java.awt.Button();
        buttonA = new java.awt.Button();
        buttonI = new java.awt.Button();
        buttonC = new java.awt.Button();
        buttonJ = new java.awt.Button();
        buttonD = new java.awt.Button();
        buttonK = new java.awt.Button();
        buttonE = new java.awt.Button();
        buttonF = new java.awt.Button();
        buttonG = new java.awt.Button();
        buttonQ = new java.awt.Button();
        buttonR = new java.awt.Button();
        buttonL = new java.awt.Button();
        buttonP = new java.awt.Button();
        buttonM = new java.awt.Button();
        buttonN = new java.awt.Button();
        buttonU = new java.awt.Button();
        buttonT = new java.awt.Button();
        buttonS = new java.awt.Button();
        buttonV = new java.awt.Button();
        buttonW = new java.awt.Button();
        buttonX = new java.awt.Button();
        buttonY = new java.awt.Button();
        buttonZ = new java.awt.Button();
        buttonDesistir = new java.awt.Button();
        buttonResponder = new java.awt.Button();
        jTextField1 = new javax.swing.JTextField();
        labelPalavraOculta = new java.awt.Label();
        labelPontosPlayer1 = new java.awt.Label();
        labelPontosPlayer2 = new java.awt.Label();
        labelVez = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelImgForca = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        buttonH.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonH.setLabel("H");
        buttonH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHActionPerformed(evt);
            }
        });

        buttonO.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonO.setLabel("O");
        buttonO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOActionPerformed(evt);
            }
        });

        buttonB.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonB.setLabel("B");
        buttonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBActionPerformed(evt);
            }
        });

        buttonA.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonA.setLabel("A");
        buttonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAActionPerformed(evt);
            }
        });

        buttonI.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonI.setLabel("I");
        buttonI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIActionPerformed(evt);
            }
        });

        buttonC.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonC.setLabel("C");
        buttonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCActionPerformed(evt);
            }
        });

        buttonJ.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonJ.setLabel("J");
        buttonJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJActionPerformed(evt);
            }
        });

        buttonD.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonD.setLabel("D");
        buttonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDActionPerformed(evt);
            }
        });

        buttonK.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonK.setLabel("K");
        buttonK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKActionPerformed(evt);
            }
        });

        buttonE.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonE.setLabel("E");
        buttonE.setName(""); // NOI18N
        buttonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEActionPerformed(evt);
            }
        });

        buttonF.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonF.setLabel("F");
        buttonF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFActionPerformed(evt);
            }
        });

        buttonG.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonG.setLabel("G");
        buttonG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGActionPerformed(evt);
            }
        });

        buttonQ.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonQ.setLabel("Q");
        buttonQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQActionPerformed(evt);
            }
        });

        buttonR.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonR.setLabel("R");
        buttonR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRActionPerformed(evt);
            }
        });

        buttonL.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonL.setLabel("L");
        buttonL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLActionPerformed(evt);
            }
        });

        buttonP.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonP.setLabel("P");
        buttonP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPActionPerformed(evt);
            }
        });

        buttonM.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonM.setLabel("M");
        buttonM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMActionPerformed(evt);
            }
        });

        buttonN.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonN.setLabel("N");
        buttonN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNActionPerformed(evt);
            }
        });

        buttonU.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonU.setLabel("U");
        buttonU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUActionPerformed(evt);
            }
        });

        buttonT.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonT.setLabel("T");
        buttonT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTActionPerformed(evt);
            }
        });

        buttonS.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonS.setLabel("S");
        buttonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSActionPerformed(evt);
            }
        });

        buttonV.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonV.setLabel("V");
        buttonV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVActionPerformed(evt);
            }
        });

        buttonW.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonW.setLabel("W");
        buttonW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWActionPerformed(evt);
            }
        });

        buttonX.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonX.setLabel("X");
        buttonX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXActionPerformed(evt);
            }
        });

        buttonY.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonY.setLabel("Y");
        buttonY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonYActionPerformed(evt);
            }
        });

        buttonZ.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        buttonZ.setLabel("Z");
        buttonZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonZActionPerformed(evt);
            }
        });

        buttonDesistir.setBackground(new java.awt.Color(153, 0, 0));
        buttonDesistir.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        buttonDesistir.setForeground(new java.awt.Color(255, 255, 255));
        buttonDesistir.setLabel("Desistir");

        buttonResponder.setBackground(new java.awt.Color(0, 102, 0));
        buttonResponder.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        buttonResponder.setForeground(new java.awt.Color(255, 255, 255));
        buttonResponder.setLabel("Responder");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("responder...");
        jTextField1.setEnabled(false);

        labelPalavraOculta.setAlignment(java.awt.Label.CENTER);
        labelPalavraOculta.setBackground(new java.awt.Color(255, 255, 255));
        labelPalavraOculta.setFont(new java.awt.Font("Source Code Pro Light", 1, 48)); // NOI18N
        labelPalavraOculta.setText("JOGO DA FORCA");

        labelPontosPlayer1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelPontosPlayer1.setForeground(new java.awt.Color(255, 255, 255));
        labelPontosPlayer1.setText("0");

        labelPontosPlayer2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelPontosPlayer2.setForeground(new java.awt.Color(255, 255, 255));
        labelPontosPlayer2.setText("0");

        labelVez.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelVez.setForeground(new java.awt.Color(255, 255, 255));
        labelVez.setText("É a sua fez.");

        jLabel1.setFont(new java.awt.Font("Footlight MT Light", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VOCÊ");

        jLabel2.setFont(new java.awt.Font("Footlight MT Light", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ELE");

        jLabelImgForca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/erro0.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPalavraOculta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonO, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonP, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonH, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonI, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonA, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonB, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(labelVez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(buttonJ, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonK, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonL, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(buttonQ, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonR, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonS, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(buttonT, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonU, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(buttonM, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonN, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonC, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonD, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(buttonE, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonF, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonG, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTextField1)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonV, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonW, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonX, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonY, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonZ, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonDesistir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelImgForca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPontosPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPontosPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelImgForca)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelPontosPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelPontosPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(labelPalavraOculta, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonB, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonD, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonG, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonI, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonJ, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonK, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonL, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonN, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonO, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonQ, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonR, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonU, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonS, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonX, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonY, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonZ, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonDesistir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonW, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(labelVez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void buttonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAActionPerformed
        try {
            realizarJogada("a");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonAActionPerformed

    private void buttonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBActionPerformed
        try {
            realizarJogada("b");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonBActionPerformed

    private void buttonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCActionPerformed
        try {
            realizarJogada("c");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonCActionPerformed

    private void buttonDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDActionPerformed
        try {
            realizarJogada("d");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonDActionPerformed

    private void buttonEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEActionPerformed
        try {
            realizarJogada("e");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonEActionPerformed

    private void buttonFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFActionPerformed
        try {
            realizarJogada("f");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonFActionPerformed

    private void buttonGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGActionPerformed
        try {
            realizarJogada("g");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonGActionPerformed

    private void buttonHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHActionPerformed
        try {
            realizarJogada("h");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonHActionPerformed

    private void buttonIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIActionPerformed
        try {
            realizarJogada("i");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonIActionPerformed

    private void buttonJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJActionPerformed
        try {
            realizarJogada("j");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonJActionPerformed

    private void buttonKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKActionPerformed
        try {
            realizarJogada("k");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonKActionPerformed

    private void buttonLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLActionPerformed
        try {
            realizarJogada("l");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonLActionPerformed

    private void buttonMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMActionPerformed
        try {
            realizarJogada("m");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonMActionPerformed

    private void buttonNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNActionPerformed
        try {
            realizarJogada("n");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonNActionPerformed

    private void buttonOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOActionPerformed
        try {
            realizarJogada("o");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonOActionPerformed

    private void buttonPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPActionPerformed
        try {
            realizarJogada("p");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonPActionPerformed

    private void buttonQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQActionPerformed
        try {
            realizarJogada("q");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonQActionPerformed

    private void buttonRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRActionPerformed
        try {
            realizarJogada("r");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonRActionPerformed

    private void buttonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSActionPerformed
        try {
            realizarJogada("s");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonSActionPerformed

    private void buttonTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTActionPerformed
        try {
            realizarJogada("t");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonTActionPerformed

    private void buttonUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUActionPerformed
        try {
            realizarJogada("u");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonUActionPerformed

    private void buttonVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVActionPerformed
        try {
            realizarJogada("v");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonVActionPerformed

    private void buttonWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWActionPerformed
        try {
            realizarJogada("w");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonWActionPerformed

    private void buttonXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXActionPerformed
        try {
            realizarJogada("x");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }

    }//GEN-LAST:event_buttonXActionPerformed

    private void buttonYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonYActionPerformed
        try {
            realizarJogada("y");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonYActionPerformed

    private void buttonZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonZActionPerformed
        try {
            realizarJogada("z");
        } catch (IOException ex) {
            System.out.println("Jogada não foi realizada");
        }
    }//GEN-LAST:event_buttonZActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button buttonA;
    private java.awt.Button buttonB;
    private java.awt.Button buttonC;
    private java.awt.Button buttonD;
    private java.awt.Button buttonDesistir;
    private java.awt.Button buttonE;
    private java.awt.Button buttonF;
    private java.awt.Button buttonG;
    private java.awt.Button buttonH;
    private java.awt.Button buttonI;
    private java.awt.Button buttonJ;
    private java.awt.Button buttonK;
    private java.awt.Button buttonL;
    private java.awt.Button buttonM;
    private java.awt.Button buttonN;
    private java.awt.Button buttonO;
    private java.awt.Button buttonP;
    private java.awt.Button buttonQ;
    private java.awt.Button buttonR;
    private java.awt.Button buttonResponder;
    private java.awt.Button buttonS;
    private java.awt.Button buttonT;
    private java.awt.Button buttonU;
    private java.awt.Button buttonV;
    private java.awt.Button buttonW;
    private java.awt.Button buttonX;
    private java.awt.Button buttonY;
    private java.awt.Button buttonZ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelImgForca;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label labelPalavraOculta;
    private java.awt.Label labelPontosPlayer1;
    private java.awt.Label labelPontosPlayer2;
    private java.awt.Label labelVez;
    // End of variables declaration//GEN-END:variables

}
