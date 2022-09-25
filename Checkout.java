package hotel.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Checkout extends JFrame implements ActionListener {

    Choice c1;
    JTextField t1;
    JButton b1, b2,b3;

    Checkout() {

        JLabel l1 = new JLabel("Check Out");
        l1.setFont(new Font("Taoma", Font.PLAIN, 18));
        l1.setForeground(Color.BLUE);
        l1.setBounds(100, 20, 100, 30);
        add(l1);

        JLabel l2 = new JLabel("Customer ID");
        l2.setBounds(30, 65, 100, 30);
        add(l2);

        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select *from customer ");
            while (rs.next()) {
                c1.add(rs.getString("number"));
            }
        } catch (Exception e) {
        }
        c1.setBounds(150, 70, 150, 30);
        add(c1);

        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30, 130, 100, 30);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(150, 130, 150, 30);
        add(t1);
        
        b1=new JButton("Checkout");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(30,200,120,30);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(170,200,120,30);
        add(b2);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel\\mangement\\system\\icons\\tick.png"));
        Image i2=i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        b3=new JButton(i3);  
        b3.addActionListener(this);
        b3.setBounds(310,70,20,20);
        add(b3);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("hotel\\mangement\\system\\icons\\sixth.jpg"));
        Image i5=i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel l5=new JLabel(i6);      
        l5.setBounds(350,-10,400,250);
        add(l5);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300, 200, 800, 300);
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==b1){
         String id =c1.getSelectedItem();
         String room=t1.getText();
         String str="delete from customer where number='"+id+"' ";
         String str2="update room set available='Available' where room_number='"+room+"' ";
         conn c=new conn();
         try{
            c.s.executeUpdate(str);
            c.s.executeUpdate(str2);
            JOptionPane.showMessageDialog(null,"Checkout Done");
            new Reception().setVisible(true);
            this.setVisible(false);
         }catch(Exception e){}
       }else if(ae.getSource()==b2){
       new Reception().setVisible(true);
       this.setVisible(false);
       }else if(ae.getSource()==b3){
           conn c=new conn();
           String id=c1.getSelectedItem();
           try{
           ResultSet rs=c.s.executeQuery("select *from customer where number='"+id+"' ");
           while(rs.next()){
               t1.setText(rs.getString("room"));
           }
           }catch(Exception e){
           System.out.println(e);
           }
           }
         }
    

    public static void main(String[] args) {
        new Checkout().setVisible(true);

    }

}
