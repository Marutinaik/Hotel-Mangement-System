
package hotel.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener {
    
    JButton b1,b2,b3;
    Choice c1;
    JTextField t1,t2,t3,t4,t5;
    
    UpdateCheck(){
    
    JLabel l1=new JLabel("Check-In Details");
    l1.setFont(new Font("Tahoma",Font.PLAIN,20));
    l1.setForeground(Color.BLUE);
    l1.setBounds(90,20,200,30);
    add(l1);
    
    
    JLabel l2=new JLabel("Customer-ID");
    l2.setBounds(20,80,150,30);
    add(l2);
    
    c1=new Choice();
    try{
     conn c=new conn();
     ResultSet rs=c.s.executeQuery("select *from customer");
     while(rs.next()){
       c1.add(rs.getString("number"));
     }
     }catch(Exception e){}
    
    c1.setBounds(200,80,150,25);
    add(c1);
    
    JLabel l3=new JLabel("Room Number");
    l3.setBounds(20,120,200,30);
    add(l3);
    
    t1=new JTextField();
    t1.setBounds(200,120,150,25);
    add(t1);
    
    JLabel l4=new JLabel("Name");
    l4.setBounds(20,160,200,30);
    add(l4);
    
    t2=new JTextField();
    t2.setBounds(200,160,150,25);
    add(t2);
    
    JLabel l5=new JLabel("Check-In");
    l5.setBounds(20,200,200,30);
    add(l5);
    
    t3=new JTextField();
    t3.setBounds(200,200,150,25);
    add(t3);
    
    JLabel l6=new JLabel("Amount Paid");
    l6.setBounds(20,240,200,30);
    add(l6);
    
    t4=new JTextField();
    t4.setBounds(200,240,150,25);
    add(t4);
    
    JLabel l7=new JLabel("Pending Amount");
    l7.setBounds(20,280,200,30);
    add(l7);
    
    t5=new JTextField();
    t5.setBounds(200,280,150,25);
    add(t5);
    
    
    b1=new JButton("Check");
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    b1.addActionListener(this);
    b1.setBounds(30,340,100,30);
    add(b1);
    
    b2=new JButton("Update");
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    b2.addActionListener(this);
    b2.setBounds(150,340,100,30);
    add(b2);
    
    b3=new JButton("Back");
    b3.setBackground(Color.BLACK);
    b3.setForeground(Color.WHITE);
    b3.addActionListener(this);
    b3.setBounds(270,340,100,30);
    add(b3);
    
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel\\mangement\\system\\icons\\nine.jpg"));
    Image i2=i1.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel l8=new JLabel(i3);      
    l8.setBounds(350,10,500,400);
    add(l8);
    
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setBounds(270,200,880,450);
    setVisible(true);
    
    }
    
    
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b1){
try{
   String room=null; 
   String deposit=null;
   int amountpaid;
   String price=null;
   conn c=new conn();
   String id=c1.getSelectedItem();
   String str="select *from customer where number='"+id+"'";
   ResultSet rs=c.s.executeQuery(str);
   while(rs.next()){
   t1.setText(rs.getString("room"));
   t2.setText(rs.getString("name"));
   t3.setText(rs.getString("status"));
   t4.setText(rs.getString("deposit"));
   room=rs.getString("room");
   deposit=rs.getString("deposit");
   }
   
   ResultSet rs2=c.s.executeQuery("select *from room where room_number='"+room+"' ");
    while(rs2.next()){
    price=rs2.getString("price");
    amountpaid=Integer.parseInt(price)-Integer.parseInt(deposit);
    t5.setText(Integer.toString(amountpaid));
    }
}catch(Exception e){
System.out.println(e);
}
}else if(ae.getSource()==b2){
  try{
              conn c = new conn();
              String s1 = c1.getSelectedItem();
              String s2 = t1.getText(); //room_number;    
              String s3 = t2.getText(); //name    
              String s4 = t3.getText(); //status;    
              String s5 = t4.getText(); //deposit    
              c.s.executeUpdate("update customer set room = '"+s2+"', name = '"+s3+"', status = '"+s4+"', deposit = '"+s5+"' where number = '"+s1+"'");
              JOptionPane.showMessageDialog(null, "Data Updated Successfully");
              new Reception().setVisible(true);
                                setVisible(false);
                            }catch(Exception ee){
                                System.out.println(ee);
                            }	
    
}else if(ae.getSource()==b3){
   new Reception().setVisible(true);
   this.setVisible(false);
}

}    
    
public static void main(String[] args){
new UpdateCheck().setVisible(true);

}



}
