package app1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.JFileChooser;

/**
 * @author skulitom
 */
public class NewJFrame extends javax.swing.JFrame {

    int xx, yy, ox, oy, OldDrawPathy, OldDrawPathx, OldPrintx = 0, OldPrinty = 0; // co-ordinates 
    // OldDrawPathx and OldDrawPathy stores old DrawPath co-ordinates
    // OldPrintx and OldPrinty stores the last printed co-ordinates
    // xx and oy are old and current x and y coordinates used by Danger Area
    int count = 1;
    boolean DrawCoRadioSelected, DrawGuRadioSelected, MoveViewRadioSelected, DangerAreaSelected;// radio button identification
    boolean locked = true; //boolean which decides if the button begin was pressed
    int DrawCoRadioCount = 0; //count for radio button identification etc.
    int DrawGuRadioCount = 0;
    int MoveViewRadioCount = 0;
    int DangerAreaCount = 0;
    int Accuracy;
    final String DEFAULT_TEXT_FILE_NAME = "text.rtf";
    
    private BufferedImage paintImage = new BufferedImage(650,400, BufferedImage.TYPE_3BYTE_BGR);
    Graphics2D gfx = paintImage.createGraphics();
    
    public void PaintFromFile(){
        // useful Procedure that saves and then loads the default buffer image
        try{
            save();
                    }
            catch(IOException ox){
            }
    Graphics2D rst = (Graphics2D) jPanel1.getGraphics();
     paintComponent(rst);
    }
    
   
    protected void paintComponent(Graphics g){
    // loads default buffer image
    // USEFULL FOR LOADING PROJECTS AND MOVING VIEW

    super.paintComponents(g);
    g.drawImage(paintImage, 0, 0, null);
    }
    

    public void save() throws IOException{
        // saves default buffer image
        // USEFULL FOR LOADING PROJECTS AND MOVING VIEW
                
        ImageIO.write(paintImage, "PNG", new File("filename.png"));
    }
    
    
    public NewJFrame() {
    // code here prepares the NewJFrame for use
        setIcon();
        // inserts an icon in to the frame
        clearFile();
        // clears old text file
        initComponents();
        this.getContentPane().setBackground(new java.awt.Color(200, 200, 100));
        // This sets the background to green
    }

    public void clearFile() {
        try {

            String content = "";

            File file = new File(DEFAULT_TEXT_FILE_NAME);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            long length = file.length();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        choice1 = new java.awt.Choice();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        buttonGroup6 = new javax.swing.ButtonGroup();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton6 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jRadioButton2.setText("jRadioButton2");

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Draw a Path");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        buttonGroup6.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jRadioButton3.setText("Draw Path");
        jRadioButton3.setMargin(new java.awt.Insets(10, 2, 2, 2));
        jRadioButton3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DrawPathAction(evt);
            }
        });

        buttonGroup6.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jRadioButton4.setText("Draw Guidelines");
        jRadioButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton4.setMargin(new java.awt.Insets(10, 2, 2, 2));
        jRadioButton4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DrawGuideRadio(evt);
            }
        });
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DrawGuidelinesAction(evt);
            }
        });

        buttonGroup6.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jRadioButton5.setText("Move view");
        jRadioButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton5.setMargin(new java.awt.Insets(10, 2, 2, 2));
        jRadioButton5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MoveViewAction(evt);
            }
        });

        jSlider1.setMajorTickSpacing(20);
        jSlider1.setMaximum(9);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setToolTipText("");
        jSlider1.setValue(0);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ZoomSliderStateChanged(evt);
            }
        });

        jLabel1.setText("Accuracy:");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jButton1.setBackground(new java.awt.Color(240, 100, 100));
        jButton1.setText("Click To Begin");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClickToBeginAction(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 400));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        buttonGroup6.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Gadugi", 0, 11)); // NOI18N
        jRadioButton6.setText("Draw Danger Area");
        jRadioButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButton6.setMargin(new java.awt.Insets(10, 2, 2, 2));
        jRadioButton6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DrawDangerAreaStateAction(evt);
            }
        });
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DrawDangerAreaAction(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(240, 240, 100));
        jButton2.setText("Refresh");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshAction(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(100, 100, 240));
        jButton3.setText("Finish & upload");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinishAndUploadAction(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(100, 100, 100));
        jLabel2.setText("By A.S");

        jButton4.setBackground(new java.awt.Color(100, 240, 100));
        jButton4.setText("Default settings");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultSettingsAction(evt);
            }
        });

        jLabel3.setText("Accuracy = 100%");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jRadioButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jRadioButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jRadioButton3, jRadioButton4, jRadioButton5});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(168, 168, 168)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>                        

    private void DrawPathAction(java.awt.event.ItemEvent evt) {                                
        DrawCoRadioCount++;
        // an algorithm which decides if the radio button is on or off
        if (DrawCoRadioCount % 2 == 0) {
            DrawCoRadioSelected = false;
            count = 1; // removes old coordinates so they are not saved to a different function
        } else {
            DrawCoRadioSelected = true;
            if (DrawCoRadioCount > 1) {
                count = 2;
            }

        }

    }                               

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // Incase user clicked the JPanel before clicking click to begin
        if (locked == true) {
            Instructions(); // writes instructions on the GUI in green
            

        }
    }                                    

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {                                     
        // In case user clicked & dragged the mouse in JPanel before clicking click to begin
        if (locked == true) {
            Instructions(); // writes instructions on the GUI in green

        } /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        else{
           /* the code here allows Path lines to be drawn on the screen */    
         if (DrawCoRadioSelected == true) {
            
            gfx.setColor(Color.MAGENTA);
            gfx.setStroke(new BasicStroke(5));
            // relatively thick stroke
            final Point pos = evt.getPoint();
            final int x = pos.x;
            final int y = pos.y;
            // gets current x and y co-ordinates
            if (count > 1) {
                gfx.drawLine(OldDrawPathx, OldDrawPathy, x, y);
            }
            OldDrawPathx = x;// different int variables in order to create a continuous line
            OldDrawPathy = y;
            Print(OldDrawPathx, OldDrawPathy); // prints co-ordinates to text file
            count++;
        } /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        else if (DrawGuRadioSelected == true) {
        /*
        the code here allows guide lines to be drawn on the screen */    
            gfx.setColor(Color.BLUE);
            gfx.setStroke(new BasicStroke(5));
            final Point pos = evt.getPoint();
            final int x = pos.x;
            final int y = pos.y;
            // gets current x and y co-ordinates
            if (count > 1) {
                gfx.drawLine(ox, oy, x, y); // draws a line from old to new co-o
            }
            ox = x;
            oy = y;
            count++;
        } /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        /*
        the code here is only a demonstration that Move view radio button actually works.
        EDIT HERE TO ALLOW USERS TO MOVE THE VIEW IN JPanel.
        BELOW vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv */
        else if (MoveViewRadioSelected == true) {

            
            
            gfx.setColor(Color.RED);
            
            
            
           
            final Point pos = evt.getPoint();
            final int x = pos.x;
            final int y = pos.y;
            gfx.fillOval(x, y, 5, 5);

        } /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        /*
        code here is a bit complicated but the idea behind it is quite simple
        as you might know a 2 dimensional graph is split into 4 quartiles
        when you look at the code here you might notice that every time a rectangle is erased
        or created there are 4 if else statements. Basically each else if statement is for each quartile
        this is because different co-ordinates should be subtracted of each other to create a rectangle that
        can be drawn in any quartile.
        */
        else if (DangerAreaSelected == true) {
            

            //{
            gfx.setColor(new Color(0, 0, 0));

            if (xx - ox <= 0 && yy - oy > 0) {

                gfx.fillRect(xx, oy, ox - xx, (yy - oy));

            } else if (yy - oy <= 0 && xx - ox > 0) {

                gfx.fillRect(ox, yy, (xx - ox), oy - yy);

            } else if (yy - oy <= 0 && xx - ox <= 0) {

                gfx.fillRect(xx, yy, ox - xx, oy - yy);

            } else {

                gfx.fillRect(ox, oy, (xx - ox), (yy - oy));

            }
        //} erases old rectangle
            //{

            gfx.setColor(new Color(160, 160, 60));
            // greenish color... not very inavative but works
            final Point pos = evt.getPoint();
            final int x = pos.x;
            final int y = pos.y;
            // gets current x and y coordinates
            if (count == 1) {
                ox = x;
                oy = y;
            }

            xx = x;
            yy = y;
            if (xx - ox <= 0 && yy - oy > 0) {

                gfx.fillRect(xx, oy, ox - xx, (yy - oy));

            } else if (yy - oy <= 0 && xx - ox > 0) {

                gfx.fillRect(ox, yy, (xx - ox), oy - yy);

            } else if (yy - oy <= 0 && xx - ox <= 0) {

                gfx.fillRect(xx, yy, ox - xx, oy - yy);

            } else {

                gfx.fillRect(ox, oy, (xx - ox), (yy - oy));

            }
            //} Creates a new rectangle
            count++;
         
        } else {
        }
    PaintFromFile();
    // saves and repaints the buffer image
        }
    }                                    
   
    public void Print(int x, int y) {
        // procedure here prints the co-ordinates in an organized fashion
        // to the rtf text file and. it does that according to the accuracy selected
        try {

            if ((OldPrintx - Accuracy <= x) && (x <= OldPrintx + Accuracy)) {
                x = OldPrintx;
            }
            if ((OldPrinty - Accuracy <= y) && (y <= OldPrinty + Accuracy)) {
                y = OldPrinty;
            }
            OldPrintx = x;
            OldPrinty = y;
           //////////////////////////////////////////////////////
            String content = "";
            if (x - 10 < 0) {
                content = "0" + "0" + Integer.toString(x);
            } else if (y - 10 < 0) {
                content = content + "0" + "0" + Integer.toString(y);
            } else if (x - 100 < 0) {
                content = "0" + Integer.toString(x);
            } else if (y - 100 < 0) {
                content = content + "0" + Integer.toString(y);
            } else {
                content = Integer.toString(x);
                content = content + Integer.toString(y);
            }
            //////////////////////////////- ensures that 3 decimals of each co-ordinate are stored
            File file = new File(DEFAULT_TEXT_FILE_NAME);       
            // Selects file name as default
            if (!file.exists()) {
                file.createNewFile();
            }
            // if file doesn’t exists, then create it
            Writer output;
            output = new BufferedWriter(new FileWriter(DEFAULT_TEXT_FILE_NAME, true));
            output.append(content);
            // writes content to a file
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // catches exceptions
    }
    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {                                      
        //
        if (DrawGuRadioSelected || MoveViewRadioSelected || DangerAreaSelected == true) {
            count = 1;
            xx = 0;
            yy = 0;
            ox = 0;
            oy = 0;
        } else if (DrawCoRadioSelected == true) {
            xx = 0;
            yy = 0;
            ox = 0;
            oy = 0;

        }
        if (DangerAreaSelected == true) {

            Graphics2D gfx = (Graphics2D) jPanel1.getGraphics();
            gfx.setColor(new Color(0, 0, 0));
            if (xx - ox <= 0 && yy - oy > 0) {

                gfx.fillRect(xx, oy, ox - xx, (yy - oy));

            } else if (yy - oy <= 0 && xx - ox > 0) {

                gfx.fillRect(ox, yy, (xx - ox), oy - yy);

            } else if (yy - oy <= 0 && xx - ox <= 0) {

                gfx.fillRect(xx, yy, ox - xx, oy - yy);

            } else {

                gfx.fillRect(ox, oy, (xx - ox), (yy - oy));

            }
        }

    }                                     

    private void DrawGuideRadio(java.awt.event.ItemEvent evt) {                                
        // This procedure 
        DrawGuRadioCount++; // defines the radio button used
        if (DrawGuRadioCount % 2 == 0) {
            DrawGuRadioSelected = false;
        } else {
            DrawGuRadioSelected = true;

        }// erases past coordinates
    }                               

    private void MoveViewAction(java.awt.event.ItemEvent evt) {                                
        /*
        the code here is only a demonstration that Move view radio button actually works.
        EDIT HERE TO ALLOW USERS TO MOVE THE VIEW IN JPanel.
        */
        MoveViewRadioCount++;
        if (MoveViewRadioCount % 2 == 0) {
            MoveViewRadioSelected = false;
        } else {
            MoveViewRadioSelected = true;
             
        }
    }                               

    private void ClickToBeginAction(java.awt.event.ActionEvent evt) {                                    
        // This procedure unlocks the java frame
        locked = false;
        Graphics2D gfx = (Graphics2D) jPanel1.getGraphics();
        gfx.setColor(new Color(0, 0, 0));
        gfx.fillRect(0, 0, 700, 500); // erases the screen from graphics
        jButton1.setText("Running...");

    }                                   

    private void RefreshAction(java.awt.event.ActionEvent evt) {                               
        // This procedure clears the screen and refreshes the count rate
        jButton1.setText("REFRESHING");
        // if the program freezes or lags refreshing text would be seen in the red click to begin button
        clearFile();
        gfx.setColor(new Color(0, 0, 0));
        // black colour the default colour of jpanel
        gfx.fillRect(0, 0, 700, 500); // erases the screen from graphics
        //{
        
        count = 1;
        if (DrawCoRadioCount % 2 == 0) {
            DrawCoRadioCount = 0;
        } else {
            DrawCoRadioCount = 1;
        }
        jButton1.setText("Running...");
        //}resets co-ordinates
    }                              

    private void DrawDangerAreaStateAction(java.awt.event.ItemEvent evt) {                                           
        
        DangerAreaCount++;
        if (DangerAreaCount % 2 == 0) {
            DangerAreaSelected = false;
        } else {
            DangerAreaSelected = true;
            count = 1; // resets co-ordinates when clicked again

        }
    }                                          

    private void DrawDangerAreaAction(java.awt.event.ActionEvent evt) {                                      
        //  NOT USED AT THE MOMENT
    }                                     

    private void DrawGuidelinesAction(java.awt.event.ActionEvent evt) {                                      
        // NOT USED AT THE MOMENT
    }                                     

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {                                     
        // This procedure checks and selects a cursor to use depending on which radio button
        // function is used
        Graphics2D rst = (Graphics2D) jPanel1.getGraphics();
        paintComponent(rst);
        if (MoveViewRadioSelected == true) {
            setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        } else if (DangerAreaSelected == true) {
            setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
    }                                    

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {                                    
        // Resets the mouse cursor back to default when mouse is dragged out of the jpanel
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }                                   

    private void ZoomSliderStateChanged(javax.swing.event.ChangeEvent evt) {                                        
        // TODO add your handling code here:
        int value = jSlider1.getValue();
        // int value is assigned value of the slider
        int PercentAccuracy;
        PercentAccuracy = (10 - value)*10;
        // converts accuracy values to percentages
        jLabel3.setText("Accuracy = " + PercentAccuracy + "%");
        Accuracy = value;
        
    }                                       

    private void DefaultSettingsAction(java.awt.event.ActionEvent evt) {                                       
        /*
        This procedure resets everything to default if the button Default Settings is clicked.
        If more functions are added to the program which can change in value it is advised to 
        add code here so that they CHANGE THEIR VALUE BACK TO DEFAULT.
        */ 
        jSlider1.setValue(0);
        
    }                                      

    private void FinishAndUploadAction(java.awt.event.ActionEvent evt) {                                       
       /*
        the code here is only a demonstration of how the upload and save function should work
        there is a lot to improve here. EDIT HERE TO ALLOW USERS TO SAVE AND IMPORT THEIR PROJECTS.
        */
        
        NewJFrame parentFrame = new NewJFrame();
 
       JFileChooser fileChooser = new JFileChooser();
       fileChooser.setDialogTitle("Save the text file in desired location");
 
            int userSelection = fileChooser.showSaveDialog(parentFrame);
 
       if (userSelection == JFileChooser.APPROVE_OPTION) {
    File fileToSave = fileChooser.getSelectedFile();
    
}
    }                                      

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {                                   
        // NOT USED AT THE MOMENT
    
    }                                  
    
    private void Instructions(){
        
            Graphics g = jPanel1.getGraphics();
            g.setColor(Color.green);
            /* green is very contrasting to black and fits with the background
            so its easy to see and the aesthetics of the GUI are not compromised
            take this into account when changing it */
            
            g.setFont(g.getFont().deriveFont(20f));
            g.drawString("Instructions: Please select the draw type on the right", 10, 30);
            g.drawString("and Click begin at the bottom right when ready.", 10, 60);
            // text Witten on the next "line"
            g.setFont(g.getFont().deriveFont(15f));
            // smaller text size
            g.drawString("Remember that the manual with the instructions is provided in your folder", 10, 120);
            g.dispose();
    }
    
    public static void main(String args[]) {

        
        
        // look and feel doesn’t work when written here
        //to change look and feel change to code in the APP1 class
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new NewJFrame().setVisible(true);

            }

        });
    }


    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup6;
    private java.awt.Choice choice1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration                   

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("LOGO.jpg")));// selects an icon for the jframe

    }

}

