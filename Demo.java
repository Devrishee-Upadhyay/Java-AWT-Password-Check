package practice;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class First extends Frame implements ActionListener
{  
	Label l1;
	TextField tf1;
	Button b;
	TextArea ta;
	First()
	{  
		
		l1=new Label("Enter passwords");
		l1.setBounds(10,50,90,20);
		
		 tf1=new TextField();  
	    tf1.setBounds(120,50,180,20);  
	    
		 b=new Button("submit");  
		b.setBounds(50,100,80,30);
		
		ta=new TextArea();
		ta.setBounds(50,150,500,400);
		add(l1);
		add(tf1);
		add(b);  
		add(ta);
		setSize(300,300); 
		setLayout(null);  
		setVisible(true);  
		
		
		
		b.addActionListener(this);
	} 
	
	public void actionPerformed(ActionEvent e)
	{
		Demo d=new Demo();
	   String s=tf1.getText();	
	   List<String> temp = new ArrayList<String>(Arrays.asList(s.split(",")));
       int result=0;
       
       String output="";
       for(int i=0;i<temp.size();i++)
       {
      	
      	 if(temp.get(i).length()<6)
      	 {
      		 output=output+temp.get(i)+"  Failure- Password must be atleast 6 characters long.\n";
      	     continue;
      	 }
      	 
      	 if(temp.get(i).length()>12)
      	 {
      		output=output+temp.get(i)+"  Failure- Password must be atleast 12 characters long.\n";
      	     continue;
      	 }
      	 
      	 result=d.match(temp.get(i));
      	 
      	 if(result==1)
      	 {
      		output=output+temp.get(i)+"  Failure-Password must contain atleast one letter from A-Z.\n";
      	 }
      	 else if(result==2)
      	 {
      		output=output+temp.get(i)+ "  Failure-Password must contain atleast one letter from a-z.\n";
      	 }
      	 else if(result==3)
      	 {
      		output=output+temp.get(i)+"  Failure-Password must contain atleast one letter from 0-9.\n";
      		 
      	 }
      	 else if(result==4)
      	 {
      		output=output+temp.get(i)+"  Failure-Password must contain atleast one letter from *$_#=@.\n";
      	 }
      	 else if(result==5)
      	 {
      		output=output+temp.get(i)+"  Failure-Password cannot contain letter from *$_#=@.\n";
      	 }
      	 else
      	 {
      		output=output+temp.get(i)+"  Successful\n"; 
      	 }
       }
       
       ta.setText(output);
	}
}
public class Demo 
{

	public int match(String temp)
	{
				int upcase=0;
				   int lowcase=0;
				   int digit=0;
				   int schar=0;
				   int nchar=0;		   

		   for(int i=0;i<temp.length();i++)
		   {
		       if(Character.isUpperCase(temp.charAt(i)))
		        upcase=1;
		       else if(Character.isLowerCase(temp.charAt(i)))
		        lowcase=1;
		       else if(Character.isDigit(temp.charAt(i)))
		        digit=1;
		       else if(temp.charAt(i)=='*' || temp.charAt(i)=='$' || temp.charAt(i)=='_' || temp.charAt(i)=='#' || temp.charAt(i)=='=' || temp.charAt(i)=='@')
		        schar=1;
		       else if(temp.charAt(i)=='%' || temp.charAt(i)=='!' || temp.charAt(i)==')' || temp.charAt(i)=='(')
		        nchar=1;
		   }
		   if(upcase==0)
		    return 1;
		   else if(lowcase==0)
		    return 2;
		   else if(digit==0)
		    return 3;
		   else if(nchar==1)
		    return 5;
		   else if(schar==0)
		    return 4;
		   else
		    return 6;
	}
	
	
	public static void main(String[] args) 
	{		
		     First f=new First();
             
	}

}
