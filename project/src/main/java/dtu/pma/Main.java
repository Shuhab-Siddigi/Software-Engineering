package dtu.pma;

import javax.swing.JButton;
import javax.swing.JFrame;

import dtu.pma.GUI.Frame;
import java.awt.*;
public class Main 
{
    
    
    public static void main( String[] args )
    {

        Frame frame = new Frame("Project Management System");

        JButton b=new JButton("click");//creating instance of JButton  
        b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
                  
        frame.add(b);//adding button in JFrame  
    }
}