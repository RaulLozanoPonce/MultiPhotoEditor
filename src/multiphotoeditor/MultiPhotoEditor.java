package multiphotoeditor;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class MultiPhotoEditor extends javax.swing.JFrame {
    
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    
    private BufferedImage image;
    private String fileName;
    private JFileChooser fileChooser;
    private final List<String> formatList;
    
    private int openFrameCount = 0;

    public MultiPhotoEditor(){
        formatList = new ArrayList<>();
        formatList.add("bmp");
        formatList.add("gif");
        formatList.add("jpeg");
        formatList.add("jpg");
        formatList.add("png");
        formatList.add("tiff");
        formatList.add("tif");
        
        initComponents();
        setApp();
        
        setFileFilter();
        setMnemonic();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPanel = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loadImageItem = new javax.swing.JMenuItem();
        saveImageItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitItem = new javax.swing.JMenuItem();
        toolMenu = new javax.swing.JMenu();
        filtersMenu = new javax.swing.JMenu();
        setThresholdItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        helpItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        aboutItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setBounds(new java.awt.Rectangle(100, 100, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        desktopPanel.setBackground(new java.awt.Color(102, 102, 102));
        desktopPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                desktopPanelComponentResized(evt);
            }
        });

        javax.swing.GroupLayout desktopPanelLayout = new javax.swing.GroupLayout(desktopPanel);
        desktopPanel.setLayout(desktopPanelLayout);
        desktopPanelLayout.setHorizontalGroup(
            desktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        desktopPanelLayout.setVerticalGroup(
            desktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        fileMenu.setText("Archivo");

        loadImageItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        loadImageItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Load.png"))); // NOI18N
        loadImageItem.setText("Abrir");
        loadImageItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadImageItemActionPerformed(evt);
            }
        });
        fileMenu.add(loadImageItem);

        saveImageItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveImageItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Save.png"))); // NOI18N
        saveImageItem.setText("Guardar");
        saveImageItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImageItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveImageItem);
        fileMenu.add(jSeparator1);

        exitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Exit.png"))); // NOI18N
        exitItem.setText("Salir");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        toolMenu.setText("Herramientas");

        filtersMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Filters.png"))); // NOI18N
        filtersMenu.setText("Filtros");

        setThresholdItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        setThresholdItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Umbral_Tool.png"))); // NOI18N
        setThresholdItem.setText("Umbralizar");
        setThresholdItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setThresholdItemActionPerformed(evt);
            }
        });
        filtersMenu.add(setThresholdItem);

        toolMenu.add(filtersMenu);

        menuBar.add(toolMenu);

        helpMenu.setText("Ayuda");

        helpItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        helpItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Help_App.png"))); // NOI18N
        helpItem.setText("Ayuda");
        helpItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpItemActionPerformed(evt);
            }
        });
        helpMenu.add(helpItem);
        helpMenu.add(jSeparator3);

        aboutItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        aboutItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/Info_App.png"))); // NOI18N
        aboutItem.setText("Acerca De MultiPhotoEditor");
        aboutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void loadImageItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadImageItemActionPerformed
        if(saveAllImages()) loadImage();
    }//GEN-LAST:event_loadImageItemActionPerformed

    private void setThresholdItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setThresholdItemActionPerformed
        if(image != null){
            String thresholdText = JOptionPane.showInputDialog(null, 
                    "Introducir Umbral [0-255]", "Ajustar Umbral", 
                    JOptionPane.PLAIN_MESSAGE);
            if(thresholdText != null){
                try{
                    int threshold = Integer.parseInt(thresholdText);
                    if(threshold < 0 || threshold > 255){
                        JOptionPane.showMessageDialog(null,
                                "El umbral se debe especificar con un número entero entre 0 y 255.",
                                "Valor erróneo", JOptionPane.ERROR_MESSAGE);
                    }else{
                        initDemoInternalFrame((BufferedImage) HighGui.toBufferedImage(toThreshold(Imgcodecs.imread(fileName), threshold)), false);
                    }
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,
                            "El umbral se debe especificar con un número entero entre 0 y 255.",
                            "Valor erróneo", JOptionPane.ERROR_MESSAGE);
                }
            } else {
            }
        }else{
            JOptionPane.showMessageDialog(null, 
                    "Debe cargar una imagen para poder umbralizar.", 
                    "Imagen no cargada", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_setThresholdItemActionPerformed

    private void aboutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutItemActionPerformed
        JOptionPane.showMessageDialog(null, "Diseñado por:\n ➡ Raúl Lozano Ponce\n ➡ Pablo Perdomo Falcón", "Acerca De MultiPhotoEditor", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_aboutItemActionPerformed

    private void saveImageItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveImageItemActionPerformed
        DemoInternalFrame dif = null;
        if(image != null){
            dif = (DemoInternalFrame) desktopPanel.getSelectedFrame();
        }
        if(dif != null){
            if(!dif.isMainWindow()){
                saveImage(dif);
            }else{
                JOptionPane.showMessageDialog(null, "No se puede guardar la imagen principal.", 
                        "Error al guardar la imagen", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, 
                    "Debe seleccionar una imagen para poder guardar.", 
                    "Imagen no seleccionada", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveImageItemActionPerformed

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        if(closeWindow()) System.exit(0);
    }//GEN-LAST:event_exitItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(closeWindow()) System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void helpItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpItemActionPerformed
        String url_open ="https://es.wikipedia.org/wiki/M%C3%A9todo_del_valor_umbral";
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, 
                    "La página web no ha sido cargada.", 
                    "Página web no cargada", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_helpItemActionPerformed

    private void desktopPanelComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_desktopPanelComponentResized
        for (JInternalFrame frame : desktopPanel.getAllFrames()) {
            int posX = Math.min(frame.getX(), desktopPanel.getWidth() - 50);
            int posY = Math.min(frame.getY(), desktopPanel.getHeight() - 50);
            frame.setLocation(posX, posY);
        }
    }//GEN-LAST:event_desktopPanelComponentResized

    private void setApp(){
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setExtendedState(MultiPhotoEditor.MAXIMIZED_BOTH);
        setMinimumSize(getPreferredSize());
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Photos/Logo.png")));
        setTitle("MultiPhotoEditor");
    }
    
    private void setFileFilter() {
        fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = null;
        filter = new FileNameExtensionFilter("Todos los formatos (BMP,GIF,JPEG,"
                + "PNG,TIFF)", "bmp", "gif", "jpeg", "jpg", "png", "tiff", "tif");
        fileChooser.addChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("Imágenes BMP", "bmp");
        fileChooser.addChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("Imágenes GIF", "gif");
        fileChooser.addChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("Imágenes JPEG", "jpeg", "jpg");
        fileChooser.addChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("Imágenes PNG", "png");
        fileChooser.addChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("Imágenes TIFF", "tiff", "tif");
        fileChooser.addChoosableFileFilter(filter);
    }
    
    private void setMnemonic() {
        fileMenu.setMnemonic('A');
        toolMenu.setMnemonic('E');
        helpMenu.setMnemonic('U');
        filtersMenu.setMnemonic('F');
        loadImageItem.setMnemonic('C');
        saveImageItem.setMnemonic('G');
        exitItem.setMnemonic('S');
        setThresholdItem.setMnemonic('U');
        aboutItem.setMnemonic('A');
        helpItem.setMnemonic('H');
    }
    
    private String getImageFormat(String name) {
        for (int i = 0; i < name.length(); i++) {
            if(name.charAt(i) == '.') return name.substring(i+1);
        }
        return "";
    }
    
    private void loadImage(){
        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            if(isAcceptedPathLoad()) completedLoad();
        }
    }
    
    private boolean isAcceptedPathLoad(){
        fileName = fileChooser.getSelectedFile().getAbsolutePath();
        if(!formatList.contains(getImageFormat(fileName))){
            JOptionPane.showMessageDialog(null, 
                    "El formato del archivo seleccionado no coincide con los que soporta la aplicación.", 
                    "Formato no aceptado", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void completedLoad(){
        try {
            image = ImageIO.read(new File(fileName));
            desktopPanel.removeAll();
            desktopPanel.updateUI();
            openFrameCount = 0;
            initDemoInternalFrame(image, true);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, 
                    "La imagen no ha podido ser cargada correctamente.", 
                    "Imagen no cargada", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean saveAllImages(){
        for (JInternalFrame frame : desktopPanel.getAllFrames()) {
            DemoInternalFrame dif = (DemoInternalFrame) frame;
            if(!dif.isMainWindow()){
                if(!saveOneImage(dif)){
                    return false;
                }
                desktopPanel.updateUI();
            }
        }
        image = null;
        return true;
    }
    
    private boolean saveOneImage(DemoInternalFrame dif){
        String[] buttons = { "Guardar", "Cerrar sin Guardar", "Cancelar" };
        if(!dif.isIsSaved()){
            try {
                dif.setSelected(true);
            } catch (PropertyVetoException ex) {}
            switch(JOptionPane.showOptionDialog(null, 
                    "¿Desea cerrar esta imagen sin guardar?", 
                    "Guardar imagen", JOptionPane.YES_NO_CANCEL_OPTION, 
                    JOptionPane.WARNING_MESSAGE, null, buttons, buttons[0])){
                case -1:
                    return false;
                case 0:
                    if(saveImage(dif)){
                        desktopPanel.remove(dif);
                        break;
                    }else{
                        return false;
                    }
                case 1:
                    desktopPanel.remove(dif);
                    break;
                case 2:
                    return false;
            }
        }else{
            desktopPanel.remove(dif);
        }
        
        return true;
    }
    
    private boolean saveImage(DemoInternalFrame dif){
        if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            if(isAcceptedPathSave(file)){
                completedSave(dif, file);
                return true;
            }
        }
        return false;
    }
    
    private boolean isAcceptedPathSave(File file){
        if(!formatList.contains(getImageFormat(file.getName()))){
            JOptionPane.showMessageDialog(null, 
                    "El formato del archivo seleccionado no coincide con los que soporta la aplicación.", 
                    "Formato no aceptado", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void completedSave(DemoInternalFrame dif, File file){
        if(!checkIfFileExists(file.getAbsolutePath())){
            try {
                ImageIO.write(dif.getImageDemo(), getImageFormat(file.getName()), file);
                dif.setIsSaved(true);
                dif.setDemoTitle();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, 
                        "La imagen no ha podido ser guardada correctamente.", 
                        "Imagen no guardada", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private boolean checkIfFileExists(String path){
        if(new File(path).exists()){
            return JOptionPane.showConfirmDialog(null, 
                    "Ya existe un archivo con el nombre especificado. ¿Desea sobreescribirlo?", 
                    "Nombre existente", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE) != JOptionPane.YES_OPTION;
        }else{
            return false;
        }
    }
    
    private void initDemoInternalFrame(BufferedImage image, boolean mainView){
        DemoInternalFrame dif = new DemoInternalFrame(openFrameCount++, image, mainView);
        dif.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        dif.addInternalFrameListener(new InternalFrameAdapter(){
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                if(!dif.isMainWindow()){
                    saveOneImage(dif);
                }else{
                    if(saveAllImages()){
                        desktopPanel.remove(dif);
                    }
                }
                desktopPanel.updateUI();
            }
        });
        
        dif.setSize(600, 450);
        desktopPanel.add(dif);
        
        try {
            dif.setSelected(true);
        } catch (PropertyVetoException ex) {}
    }
    
    private Mat toThreshold(Mat originalImage, int threshold){
        Mat grayImage = new Mat(originalImage.rows(),originalImage.cols(),CvType.CV_8U);
        Mat thresholdImage = new Mat(originalImage.rows(),originalImage.cols(),CvType.CV_8U);
        Imgproc.cvtColor(originalImage,grayImage,Imgproc.COLOR_BGR2GRAY);
        Imgproc.threshold(grayImage,thresholdImage,threshold,255,Imgproc.THRESH_BINARY);
        return thresholdImage;
    }
    
    private boolean closeWindow(){
        return (saveAllImages() && JOptionPane.showConfirmDialog(null,
                "¿Desea salir de Image Editor?", "Salir",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
    
    public static void main(String args[]) throws Exception {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        new MultiPhotoEditor().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutItem;
    private javax.swing.JDesktopPane desktopPanel;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu filtersMenu;
    private javax.swing.JMenuItem helpItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuItem loadImageItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem saveImageItem;
    private javax.swing.JMenuItem setThresholdItem;
    private javax.swing.JMenu toolMenu;
    // End of variables declaration//GEN-END:variables
    
    private class DemoInternalFrame extends JInternalFrame {
        
        private final BufferedImage imageDemo;
        private final int number;
        private final boolean mainWindow;
        private boolean isSaved;
        private final int xOffset = 50, yOffset = 50;
        private int posX = 0, posY = 0;

        public DemoInternalFrame(int number, BufferedImage imageDemo, boolean mainWindow){
            super("", true, true, true, true);
            this.number = number;
            this.imageDemo = imageDemo;
            this.mainWindow = mainWindow;
            this.isSaved = mainWindow;
            this.posX = (this.xOffset * number) % desktopPanel.getWidth();
            this.posY = (this.yOffset * number) % desktopPanel.getHeight();
            
            setVisible(true);
            setLocation(posX, posY);
            setDemoTitle();
            
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(0, 0, getWidth(), getHeight());
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            Board board = new Board(this.imageDemo);
            scrollPane.setViewportView(board);
            getContentPane().add(scrollPane);
        }

        public BufferedImage getImageDemo() {
            return imageDemo;
        }
        
        public void setDemoTitle(){
            String demo_title = "";
            if(!isSaved) demo_title += "* ";
            demo_title += fileName;
            if(!mainWindow) demo_title += " " + this.number;
            setTitle(demo_title);
        }

        public boolean isIsSaved() {
            return isSaved;
        }

        public void setIsSaved(boolean isSaved) {
            this.isSaved = isSaved;
        }

        public boolean isMainWindow() {
            return mainWindow;
        }
    }
}
