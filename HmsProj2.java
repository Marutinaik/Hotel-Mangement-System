

package hotel.mangement.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HmsProj2  extends JFrame  implements ActionListener{

   public  HmsProj2(){
      setBounds(40,200,1366,565);
     //setSize(400,400);
     
    // setLocation(300,300);
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel\\mangement\\system\\icons\\first.jpg"));
     JLabel l1=new JLabel(i1);
     l1.setBounds(0,0,1364,565);
     add(l1);
     
     JLabel l2=new JLabel("Hotel Management System");
     l2.setBounds(20,430,1000,90);
     l2.setForeground(Color.WHITE);
     l2.setFont(new Font("serif",Font.PLAIN,70));
     l1.add(l2);
     
     JButton b1=new JButton("Next");
     b1.setBackground(Color.GREEN);
     b1.setForeground(Color.BLACK);
     b1.setBounds(1150,450,150,30);
     b1.addActionListener(this);
     l1.add(b1);
     
     setLayout(null);
     setVisible(true);
    /* 
     
       while(true){
        l2.setVisible(false);
        try{
        Thread.sleep(500);
        }catch(Exception e){}
      l2.setVisible(true);
       try{
        Thread.sleep(500);
          }
        catch(Exception e){}
                }
   
           */
     }
   

  
    public void actionPerformed(ActionEvent ae){
    new Login().setVisible(true);
    this.setVisible(false);
    }

 
    public static void main(String[] args) {
     HmsProj2 window=new HmsProj2();
     window.setVisible(true);
    }
    
}
