package lab05;
import javax.swing.*;

import java.awt.event.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Random;
public class Dice
{
	private JPanel panel;
	private JButton button;
	private JTextField text;
	private JLabel label;
	private JLabel label2;
	public Dice()
	{
		
		panel = new JPanel();
		button = new JButton("Roll");
		text = new JTextField(3);//3 cols, not 20 chars
		label = new JLabel("Choose How many Sides the dice will have: ");
		label2=new JLabel("");
		

		//Load the listener
		button.addActionListener(buttonListener());	
		
		//load the panel
		panel.add(label);
		panel.add(text);
		panel.add(button);
		panel.add(label2);
	}
	
	public Component getContent()
	{
		return (panel);
	}
	
	private ActionListener buttonListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				int parseinput=0;
				Boolean isNumber=true;
				String newText;
				
				try{
					 parseinput=Integer.parseInt(input);
				}
				 catch(NumberFormatException nfe)  
				  {  
				     newText="Not A Number or No Text"; 
				     label2.setText(newText);
						System.out.println(newText);
						isNumber=false;
				  } 
				
				
			
				
				
				if (isNumber==true && parseinput>0){
					Random random = new Random();
					int  n = random.nextInt(parseinput)+1;
				 newText = "Your "+ parseinput+"-sided die rolled a " + n;
				label.setText(newText);
				System.out.println(newText);
				}
				
			}
		};
		
		return listener;
	}
	
}