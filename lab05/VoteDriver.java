package lab05;

import javax.swing.JFrame;


public class VoteDriver 
{
	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Vote");
		Vote demo = new Vote();	
		frame.getContentPane().add(demo.getContent());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}