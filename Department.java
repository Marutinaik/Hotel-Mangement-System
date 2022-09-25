

package hotel.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;


public class Department  extends JFrame implements ActionListener{
    
   
    JButton b1,b2;
    JTable t1;
    
    Department(){
    

    JLabel l3=new JLabel("Department");
    l3.setBounds(80,10,100,20);
    add(l3);
    
    JLabel l4=new JLabel("Budget");
    l4.setBounds(350,10,100,20);
    add(l4);
    
    t1=new JTable();
    t1.setBounds(0,50,500,300);
    add(t1);
    
    
    b1=new JButton("Submit");
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    b1.setBounds(100,400,120,30);
    b1.addActionListener(this);
    add(b1);
    
    
    b2=new JButton("Back");
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
    b2.addActionListener(this);
    b2.setBounds(250,400,120,30);
    add(b2);
    
    
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setBounds(500,200,500,500);
    setVisible(true);
    }
   
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==b1){
    try{
      String str="select *from department";
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
    new Department();
    
    }
    
}
