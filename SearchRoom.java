
package hotel.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;


public class SearchRoom  extends JFrame implements ActionListener{
    
    JComboBox c1;
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;
    
    SearchRoom(){
    
    JLabel l1=new JLabel("Search For Rooms");
    l1.setFont(new Font("Tahoma",Font.PLAIN,22));
    l1.setForeground(Color.BLUE);
    l1.setBounds(400,30,200,30);
    add(l1);
    
    JLabel l7=new JLabel("Type Of Room");
    l7.setBounds(40,100,100,20);
    add(l7);
    
    JLabel l2=new JLabel("Room Number");
    l2.setBounds(60,160,100,20);
    add(l2);
    
    JLabel l3=new JLabel("Availability");
    l3.setBounds(270,160,100,20);
    add(l3);
    
    JLabel l4=new JLabel("Cleaning Status");
    l4.setBounds(450,160,100,20);
    add(l4);
    
    JLabel l5=new JLabel("Price");
    l5.setBounds(670,160,100,20);
    add(l5);
    
    JLabel l6=new JLabel(" Bed Type");
    l6.setBounds(850,160,100,20);
    add(l6);
    
    
    
    c1=new JComboBox(new String[] {"Single","Double"});
    c1.setBounds(170,100,150,25);
    c1.setBackground(Color.WHITE);
    add(c1);
    
    c2=new JCheckBox("Only Display Available");
    c2.setBounds(600,100,170,25);
    c2.setBackground(Color.WHITE);
    add(c2);
    
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
      String str="select *from room where bed_type='"+c1.getSelectedItem()+"'";
      String str2="select *from room where available='available' and bed_type='"+c1.getSelectedItem()+"' ";
      conn c=new conn();
      ResultSet rs=c.s.executeQuery(str);
      t1.setModel(DbUtils.resultSetToTableModel(rs));
      
      if(c2.isSelected()){
      
      ResultSet rs2=c.s.executeQuery(str2);
      t1.setModel(DbUtils.resultSetToTableModel(rs2));
      }
        
    }catch(Exception e){
      System.out.println(e);
       }
    }else if(ae.getSource()==b2){
    new Reception().setVisible(true);
    this.setVisible(false);
    }
    
    
    }
    
    
    public static void main(String[] args){
    new SearchRoom();
    
    }
    
}
