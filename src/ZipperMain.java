import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ZipperMain extends JFrame{
	FileChooser file = new FileChooser();
	
	public ZipperMain()
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1,2));
		mainPanel.setBackground(Color.WHITE);
		JButton chooseBtn = new JButton("Select Folder");
		JButton zipBtn = new JButton("Make Zip");
		chooseBtn.setBackground(Color.BLUE);
		chooseBtn.setForeground(Color.YELLOW);
		zipBtn.setBackground(Color.blue);
		zipBtn.setForeground(Color.YELLOW);
		mainPanel.add(chooseBtn);
		mainPanel.add(zipBtn);
		add(mainPanel);
		
		chooseBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				file.chooseFile();
			}
			
		});
		
		zipBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try {
					file.zipFolder(file.fileName(), file.fileName()+".zip");
					System.out.println("filed zipped");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZipperMain main = new ZipperMain();
		main.setTitle("Zipper");
		main.setVisible(true);
		main.setLocationRelativeTo(null);
		main.setSize(400, 100);
	}

}
