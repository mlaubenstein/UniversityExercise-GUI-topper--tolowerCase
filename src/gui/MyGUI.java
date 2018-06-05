package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyGUI extends javax.swing.JFrame implements ActionListener {
    JPanel jPanel;
    final JTextArea     TXTAREA;
    final JButton       BTN_TOUPPER;
    final JButton 	    BTN_TOLOWER;
    final JButton 	    BTN_SWAP;
    final JButton       BTN_CENSOR;

    public MyGUI(){

        jPanel = new JPanel (  );

        this.setTitle               ("MyGuiFrame");
        this.setVisible             ( true );
        this.getContentPane().add   ( jPanel ) ;

        setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );

        TXTAREA	    = new JTextArea();
        BTN_TOUPPER	= new JButton("BTN_TOUPPER");
        BTN_TOLOWER	= new JButton("BTN_TOLOWER");
        BTN_SWAP	= new JButton("BTN_SWAP"   );
        BTN_CENSOR  = new JButton("BTN_CENSOR" );

        BTN_SWAP    .setName ( "BTN_SWAP"   );
        TXTAREA     .setName ( "TXTAREA"    );
        BTN_TOUPPER .setName ( "BTN_TOUPPER");
        BTN_TOLOWER .setName ( "BTN_TOLOWER");
        BTN_CENSOR  .setName ( "BTN_CENSOR" );

        BTN_TOUPPER .addActionListener ( this );
        BTN_TOLOWER .addActionListener ( this );
        BTN_SWAP    .addActionListener ( this );

        jPanel.setLayout ( new java.awt.BorderLayout (  )  );
        jPanel.add       ( TXTAREA,     BorderLayout.NORTH );
        jPanel.add       ( BTN_SWAP,    BorderLayout.SOUTH );
        jPanel.add       ( BTN_TOLOWER, BorderLayout.WEST  );
        jPanel.add       ( BTN_TOUPPER, BorderLayout.EAST  );

        pack ();

    }
    public void actionPerformed (ActionEvent event){
        String  swappedText;
        char[]  array;

        if      (event.getSource ()==this.BTN_TOUPPER) TXTAREA.setText ( TXTAREA.getText ().toUpperCase ()  );

        else if (event.getSource ()==this.BTN_TOLOWER) TXTAREA.setText ( TXTAREA.getText ().toLowerCase ()  );

        else if (event.getSource ()==this.BTN_SWAP){

            array       =TXTAREA.getText().toCharArray();
            swappedText = "";

            for(int i=0; i<array.length; i++)
            {
                if      (Character.isLowerCase(array[i]))  array[i]=Character.toUpperCase(array[i]);
                else if (Character.isUpperCase(array[i]))  array[i]=Character.toLowerCase(array[i]);
                swappedText=swappedText+array[i];
            }
            TXTAREA.setText( swappedText );

        }
    }


}
