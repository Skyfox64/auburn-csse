// File   : filechooser/CountWords.java
// Purpose: Counts words in file.
//          Illustrates menus, JFileChooser, Scanner..
// Author : Fred Swartz
// Date   : 2005-02-23, 2005-12-02

   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   import java.io.*;
   import java.util.*;

//////////////////////////////////////////////////////// CountWords
   public class CountWords extends JFrame {
   
    //... Instance variables
      JTextField   m_fileNameTF  = new JTextField(15);
      JTextField   m_wordCountTF = new JTextField(4);
      JFileChooser m_fileChooser = new JFileChooser();
   
    //================================================== constructor
      CountWords() {
         m_fileNameTF.setEditable(false);
         m_wordCountTF.setEditable(false);
         JButton openButton = new JButton("Open");
      
        //... Add listeners
         openButton.addActionListener(new OpenAction());
      
        //... Create contant pane, layout components
         JPanel content = new JPanel();
         content.setLayout(new FlowLayout());
         content.add(openButton);
         content.add(m_fileNameTF);
         content.add(new JLabel("Word Count"));
         content.add(m_wordCountTF);
      
        //... Set window characteristics
         this.setTitle("Count Words");
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setContentPane(content);
         this.pack();
      }
   
    //============================================= countWordsInFile
      private int countWordsInFile(File f) {
      
         int numberOfWords = 0;  // For counting words.
      
         try {
            Scanner wordScanner = new Scanner(f);
            wordScanner.useDelimiter("[^A-Za-z]+");
         
            while (wordScanner.hasNext()) {
               String word = wordScanner.next();
               numberOfWords++;
            }
            wordScanner.close();     // Close Scanner's file.
         
         } 
            catch (FileNotFoundException fnfex) {
               JOptionPane.showMessageDialog(CountWords.this,
                        "You gave me an unreadable file");
            }
         return numberOfWords;
      }
   
   
    ///////////////////////////////////////////////////// OpenAction
      class OpenAction implements ActionListener {
         public void actionPerformed(ActionEvent ae) {
            //... Open a file dialog.
            int retval = m_fileChooser.showOpenDialog(CountWords.this);
            if (retval == JFileChooser.APPROVE_OPTION) {
                //... The user selected a file, process it.
               File file = m_fileChooser.getSelectedFile();
            
                //... Update user interface.
               m_fileNameTF.setText(file.getName());
               m_wordCountTF.setText("" + countWordsInFile(file));
            }
         }
      }
   
    //========================================================= main
      public static void main(String[] args) {
         JFrame window = new CountWords();
         window.setVisible(true);
      }
   }