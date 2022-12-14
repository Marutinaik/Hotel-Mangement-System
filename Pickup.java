

package hotel.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;


public class Pickup  extends JFrame implements ActionListener{
    
    Choice c1;
    JButton b1,b2;
    JTable t1;
    
    Pickup(){
    
    JLabel l1=new JLabel("Pickup Service");
    l1.setFont(new Font("Tahoma",Font.PLAIN,22));
    l1.setForeground(Color.BLUE);
    l1.setBounds(400,30,200,30);
    add(l1);
    
    JLabel l10=new JLabel("Type Of Car");
    l10.setBounds(50,100,100,20);
    add(l10);
    
    c1=new Choice();
    try{
    conn c=new conn();
    ResultSet rs =c.s.executeQuery("select *from driver");
    while(rs.next()){
    c1.add(rs.getString("brand"));
    }
    }catch(Exception e){}
    c1.setBounds(150,100,200,25);
    add(c1);
    
    JLabel l2=new JLabel(" Name");
    l2.setBounds(40,160,100,20);
    add(l2);
    
    JLabel l3=new JLabel("Age");
    l3.setBounds(200,160,100,20);
    add(l3);
    
    JLabel l5=new JLabel("Gender");
    l5.setBounds(330,160,100,20);
    add(l5);
    
    JLabel l6=new JLabel(" company");
    l6.setBounds(470,160,100,20);
    add(l6);
    
    JLabel l7=new JLabel(" Brand");
    l7.setBounds(620,160,100,20);
    add(l7);
    
    JLabel l8=new JLabel(" Availability");
    l8.setBounds(750,160,100,20);
    add(l8);
    
    JLabel l9=new JLabel(" Location");
    l9.setBounds(880,160,100,20);
    add(l9);
    
    t1=new JTable();
    t1.setBounds(0,200,1000,300);
    add(t1);
    
    
    b1=new JButton("Submit");
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    b1.setBounds(300,520,120,30);
    b1.addActionListener(this);
    add(b1);
    
    
    b2=new JButton("Back");
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    b2.addActionListener(this);
    b2.setBounds(500,520,120,30);
    add(b2);
    
    
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setBounds(200,200,1000,650);
    setVisible(true);
    }
   
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==b1){
    try{
      String str="select *from driver where brand='"+c1.getSelectedItem()+"'";
      conn c=new conn();
      ResultSet rs=c.s.executeQuery(str);
      t1.setModel(DbUtils.resultSetToTableModel(rs));
    }catch(Exception e){
      System.out.println(e);
       }
    }else if(ae.getSource()==b2){
    new Reception().setVisible(true);
    this.setVisible(false);
    }
    
    
    }
    
    
    public static void main(String[] args){
    new Pickup();
    
    }
    
}
