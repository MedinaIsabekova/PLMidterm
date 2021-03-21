import java.awt.FileDialog;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;


public class MidEdit extends javax.swing.JFrame {


    private Stack<String> undoStack;
    private Stack<String> redoStack;
    private String helper;
    private boolean opened;
    private boolean saved;
    private String filePath;


    public MidEdit() {
        undoStack = new Stack<String>();
        redoStack = new Stack<String>();
        undoStack.push("");
        redoStack.push("");
        helper = "";
        opened  = false;
        saved = false;
        filePath = null;
        initComponents();
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        NewOption = new javax.swing.JMenuItem();
        OpenOption = new javax.swing.JMenuItem();
        SaveOption = new javax.swing.JMenuItem();
        ExitOption = new javax.swing.JMenuItem();
        EditMenu = new javax.swing.JMenu();
        UndoOption = new javax.swing.JMenuItem();
        RedoOption = new javax.swing.JMenuItem();
        CutOption = new javax.swing.JMenuItem();
        CopyOption = new javax.swing.JMenuItem();
        PasteOption = new javax.swing.JMenuItem();
        DeleteOption = new javax.swing.JMenuItem();
        FindOption = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        GetHelpOption = new javax.swing.JMenuItem();
        AboutMenu = new javax.swing.JMenu();
        AboutMe = new javax.swing.JMenuItem();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Midterm Project on Java");
        setAutoRequestFocus(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        FileMenu.setText("File");

        NewOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        NewOption.setText("New");
        NewOption.setRequestFocusEnabled(false);
        NewOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewOptionActionPerformed(evt);
            }
        });
        FileMenu.add(NewOption);

        OpenOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        OpenOption.setText("Open");
        OpenOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenOptionActionPerformed(evt);
            }
        });
        FileMenu.add(OpenOption);

        SaveOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        SaveOption.setText("Save");
        SaveOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveOptionActionPerformed(evt);
            }
        });
        FileMenu.add(SaveOption);

        ExitOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        ExitOption.setText("Exit");
        ExitOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitOptionActionPerformed(evt);
            }
        });


        FileMenu.add(ExitOption);

        jMenuBar1.add(FileMenu);

        EditMenu.setText("Edit");

        UndoOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        UndoOption.setText("Undo");
        UndoOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoOptionActionPerformed(evt);
            }
        });
        EditMenu.add(UndoOption);

        RedoOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        RedoOption.setText("Redo");
        RedoOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedoOptionActionPerformed(evt);
            }
        });
        EditMenu.add(RedoOption);

        CutOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        CutOption.setText("Cut");
        CutOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CutOptionActionPerformed(evt);
            }
        });
        EditMenu.add(CutOption);

        CopyOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        CopyOption.setText("Copy");
        CopyOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopyOptionActionPerformed(evt);
            }
        });
        EditMenu.add(CopyOption);

        PasteOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        PasteOption.setText("Paste");
        PasteOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasteOptionActionPerformed(evt);
            }
        });
        EditMenu.add(PasteOption);

        DeleteOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        DeleteOption.setText("Delete");
        DeleteOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteOptionActionPerformed(evt);
            }
        });
        EditMenu.add(DeleteOption);

        FindOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        FindOption.setText("Find");
        FindOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindOptionActionPerformed(evt);
            }
        });
        EditMenu.add(FindOption);

        jMenuBar1.add(EditMenu);

        HelpMenu.setText("Help");
        HelpMenu.setComponentPopupMenu(jPopupMenu1);
        HelpMenu.add(jSeparator1);

        GetHelpOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        GetHelpOption.setText("Get Help");
        GetHelpOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetHelpOptionActionPerformed(evt);
            }
        });
        HelpMenu.add(GetHelpOption);

        jMenuBar1.add(HelpMenu);

        AboutMenu.setText("About");

        AboutMe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        AboutMe.setText("About The Developer");
        AboutMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutMeActionPerformed(evt);
            }
        });
        AboutMenu.add(AboutMe);

        jMenuBar1.add(AboutMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }

    private boolean isOpened(){
        return opened;
    }
    private boolean isSaved(){
        return saved;
    }

    private void NewOptionActionPerformed(java.awt.event.ActionEvent evt) {
        if(!isSaved()){
            int choice;
            choice = JOptionPane.showConfirmDialog(null, "Wish to save the current file","File Not Saved",JOptionPane.YES_NO_CANCEL_OPTION);
            if(choice == JOptionPane.YES_OPTION){
                SaveOptionActionPerformed(evt);
            }
            else if(choice == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }
        this.dispose();
        new MidEdit().setVisible(true);
    }

    private void UndoOptionActionPerformed(java.awt.event.ActionEvent evt) {
        String tmp;
        tmp = jTextArea1.getText();
        redoStack.push(tmp);
        try{
            jTextArea1.setText(undoStack.pop());
        }
        catch(EmptyStackException e){
            jTextArea1.setText("i think its throwing empty stack exception");
        }
    }

    private void OpenOptionActionPerformed(java.awt.event.ActionEvent evt) {
        if(!isSaved()&&isOpened()){
            int choice;
            choice = JOptionPane.showConfirmDialog(null, "Wish to save the current file","File Not Saved",JOptionPane.YES_NO_CANCEL_OPTION);
            if(choice == JOptionPane.YES_OPTION){
                SaveOptionActionPerformed(evt);
            }
            else if(choice == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }
        final FileDialog fileDialog = new FileDialog(this,"Select file",FileDialog.LOAD);
        fileDialog.setFile("*.txt; *.java");
        fileDialog.setVisible(true);

        try {
            FileInputStream inp = new FileInputStream(fileDialog.getDirectory()+fileDialog.getFile());
            filePath = fileDialog.getDirectory()+fileDialog.getFile();
            Scanner reader = new Scanner(inp);
            opened = true;
            jTextArea1.setText("");
            while(reader.hasNext()){
                jTextArea1.setText(jTextArea1.getText() + reader.nextLine()+ "\n" );
            }
            reader.close();
            setTitle(fileDialog.getFile() + "Midterm Project on Java");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Seems that the selected file is missing", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void SaveOptionActionPerformed(java.awt.event.ActionEvent evt) {
        File file;
        FileDialog fileDialog = null ;
        if(!isOpened()){
            //save AS
            fileDialog = new FileDialog(this,"Choose Location",FileDialog.SAVE);
            fileDialog.setFile("*.txt; *.java");
            fileDialog.setVisible(true);
            file  = new File(fileDialog.getDirectory()+fileDialog.getFile());
            filePath = fileDialog.getDirectory()+fileDialog.getFile();
            setTitle(fileDialog.getFile() + "  " + getTitle());
            try {
                if(!file.createNewFile()){
                    JOptionPane.showMessageDialog(null, "Can NOT SAVE","Error",JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {

            }
        }
        else{
            file = new File(filePath);
        }
        try {
            FileWriter fout = new FileWriter(file);
            fout.write(jTextArea1.getText());
            fout.append("\n");
            fout.close();
            opened = true;
        } catch (IOException e) {

        }
    }

    private void ExitOptionActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void RedoOptionActionPerformed(java.awt.event.ActionEvent evt) {
        String tmp;
        tmp = jTextArea1.getText();
        undoStack.push(tmp);
        try{
            jTextArea1.setText(redoStack.pop());
        }
        catch(EmptyStackException e){
            jTextArea1.setText("");
        }
    }

    private void CutOptionActionPerformed(java.awt.event.ActionEvent evt) {
        String tmp = jTextArea1.getText();
        undoStack.push(tmp);
        helper = jTextArea1.getSelectedText();
        jTextArea1.replaceRange("", jTextArea1.getSelectionStart(), jTextArea1.getSelectionEnd());
    }

    private void CopyOptionActionPerformed(java.awt.event.ActionEvent evt) {
        helper = jTextArea1.getSelectedText();
    }

    private void PasteOptionActionPerformed(java.awt.event.ActionEvent evt) {
        String tmp = jTextArea1.getText();
        undoStack.push(tmp);
        jTextArea1.insert(helper, jTextArea1.getCaretPosition());
    }

    private void DeleteOptionActionPerformed(java.awt.event.ActionEvent evt) {
        String tmp = jTextArea1.getText();
        undoStack.push(tmp);
        jTextArea1.replaceRange("", jTextArea1.getSelectionStart(), jTextArea1.getSelectionEnd());
    }

    private void FindOptionActionPerformed(java.awt.event.ActionEvent evt) {

        String str="";

        JCheckBox checkbox = new JCheckBox("Ignore Case");
        String message = "Enter text to be found : ";
        Object[] parameter = {message,checkbox};
        boolean FindStatus=true;

        str = JOptionPane.showInputDialog(null, parameter , "Find",JOptionPane.DEFAULT_OPTION);

        String searchIn = jTextArea1.getText();
        if(checkbox.isSelected()){

            if(!searchIn.toLowerCase().contains(str.toLowerCase())){
                FindStatus = false;
                JOptionPane.showMessageDialog(null, "Not Found", "Unsuccessful Search", JOptionPane.ERROR_MESSAGE);

            }
            while(searchIn.toLowerCase().contains(str.toLowerCase())){
                int index=searchIn.toLowerCase().indexOf(str.toLowerCase());
                JOptionPane.showMessageDialog(null, "Found at "+index+" positon\nCursor is at the mentioned position", "Successful Search", JOptionPane.INFORMATION_MESSAGE);
                jTextArea1.setCaretPosition(index);
                String replaceString ="";
                int i=0;
                while(i<str.length()){
                    replaceString+="-";
                    i++;
                }
                searchIn = searchIn.substring(0, index)+replaceString+searchIn.substring(index+str.length(),searchIn.length());
            }
            if(FindStatus){
                FindStatus = false;
                JOptionPane.showMessageDialog(null, "No More Results Found", "Search Finished", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        else{
            if(!searchIn.contains(str)){
                FindStatus = false;
                JOptionPane.showMessageDialog(null, "Not Found", "Unsuccessful Search", JOptionPane.ERROR_MESSAGE);

            }
            while(searchIn.contains(str)){
                int index=searchIn.toLowerCase().indexOf(str.toLowerCase());
                JOptionPane.showMessageDialog(null, "Found at "+index+" positon\nCursor is at the mentioned position", "Successful Search", JOptionPane.INFORMATION_MESSAGE);
                jTextArea1.setCaretPosition(index);
                String replaceString ="";
                int i=0;
                while(i<str.length()){
                    replaceString+="-";
                    i++;
                }
                searchIn = searchIn.substring(0, index)+replaceString+searchIn.substring(index+str.length(),searchIn.length());
            }
            if(FindStatus){
                FindStatus = false;
                JOptionPane.showMessageDialog(null, "No More Results Found", "Search Finished", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        System.out.println(str);

    }

    private void IndentOptionActionPerformed(java.awt.event.ActionEvent evt) {
        boolean HashApperance = false;
        String z = jTextArea1.getText();
        for(int i=0;i<z.length();){
            if(z.charAt(i)=='\n'||z.charAt(i)=='\t'){
                z = z.substring(0,i)+z.substring(i+1,z.length());
            }
            else{
                i++;
            }
        }
        int tabCount=0;
        for(int i=0;i<z.length();i++){
            if(z.charAt(i)=='#'&&i<z.length()-1&&z.charAt(i+1)=='i'){
                HashApperance = true;
            }
            if(z.charAt(i)=='{'){

                tabCount++;
                String half1,half2;
                half1 = z.substring(0,i+1);
                half2 = z.substring(i+1,z.length());
                half1+='\n';
                int k=0;
                while(k<tabCount){
                    half1+="\t";
                    k++;
                }
                z = half1+half2;

            }
            else if(z.charAt(i)=='}'){

                String half1,half2;
                half1 = z.substring(0,i+1);
                half2 = z.substring(i+1,z.length());
                half1=half1.substring(0,i-1)+"}";
                half1+='\n';
                int a=0;
                tabCount--;
                while(a<tabCount){
                    half1+="\t";
                    a++;
                }
                z = half1+half2;

            }
            else if(z.charAt(i)==';'){
                String half1,half2;
                half1 = z.substring(0,i+1);
                half2 = z.substring(i+1,z.length());
                half1+='\n';
                int a=0;
                while(a<tabCount){
                    half1+="\t";
                    a++;
                }
                z = half1+half2;
            }
            else if(z.charAt(i)=='>'&&HashApperance){
                String half1,half2;
                half1 = z.substring(0,i+1);
                half2 = z.substring(i+1,z.length());
                half1+='\n';
                z = half1+half2;
                HashApperance = false;
            }
            jTextArea1.setText(z);
        }
    }

    private void GetHelpOptionActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Open The ABOUT THE DEVELOPER and contact the developer for HELP ", "HELP", JOptionPane.INFORMATION_MESSAGE);
    }

    private void AboutMeActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "About The Developer\nThis Text Editor is created and developed by Medina Isabek kyzy,\nStudent of Computer Science at Ala-Too University\nContact At : medina.isabekkyzy@alatoo.edu.kg", "About The Developer", JOptionPane.PLAIN_MESSAGE);
    }


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MidEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MidEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MidEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MidEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MidEdit().setVisible(true);
            }
        });
    }


    private javax.swing.JMenuItem AboutMe;
    private javax.swing.JMenu AboutMenu;
    private javax.swing.JMenuItem CopyOption;
    private javax.swing.JMenuItem CutOption;
    private javax.swing.JMenuItem DeleteOption;
    private javax.swing.JMenu EditMenu;
    private javax.swing.JMenuItem ExitOption;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuItem FindOption;
    private javax.swing.JMenuItem GetHelpOption;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JMenuItem NewOption;
    private javax.swing.JMenuItem OpenOption;
    private javax.swing.JMenuItem PasteOption;
    private javax.swing.JMenuItem RedoOption;
    private javax.swing.JMenuItem SaveOption;
    private javax.swing.JMenuItem UndoOption;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextArea jTextArea1;


}