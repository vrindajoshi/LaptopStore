import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class LaptopStoreResultsFrame extends JFrame implements ActionListener {
	
	//colors
	Color lightBlue = new Color(85, 127, 136);
	Color darkBlue = new Color(1, 34, 45);

	//GUI elements
	JLabel logoLabel = new JLabel(new ImageIcon("logo.jpg"));	
	
	//menu bar
	JMenuBar menuBar = new JMenuBar();
	JMenu mHome = new JMenu("Home");
	JMenu mBrowse = new JMenu("Browse All Laptops");
	JMenu mQuiz = new JMenu("Take Quiz");
	
	// background image //new ImageIcon("sdp_background.jpg"
	JLabel bkgdImage = new JLabel(new ImageIcon("sdp_background.jpg"));
	JPanel whitePanel = new JPanel();
	
	JPanel scrollPanel = new JPanel();
	JScrollPane scrollPane = new JScrollPane(scrollPanel);
	
	// arrays
	JPanel[] laptopFrameArray = new JPanel[3];
	JLabel[][] labelArrayMatrix = new JLabel[3][4];	
	JButton[] exploreMoreArray = new JButton[3];

	
	//title
	JLabel resultsTitle = new JLabel("Survey Results");
	
	//LAPTOP FRAMES __________________________________________
	
	JPanel laptop1Panel = new JPanel();
	LaptopImg laptop1 = LaptopStoreApplication.laptopArray[0];
	JLabel laptop1image = new JLabel(new ImageIcon(laptop1.getImageAddress()));
	JLabel laptop1Title = new JLabel(laptop1.getBrand()+" "+laptop1.getModel());
	JLabel laptop1Price = new JLabel("$"+laptop1.getPrice());
	JButton laptop1ExploreMore = new JButton("Explore More");
	JLabel ranklabel1 = new JLabel("1");
	
	JPanel laptop2Panel = new JPanel();
	LaptopImg laptop2 = LaptopStoreApplication.laptopArray[1];
	JLabel laptop2image = new JLabel(new ImageIcon(laptop2.getImageAddress()));
	JLabel laptop2Title = new JLabel(laptop2.getBrand()+" "+laptop2.getModel());
	JLabel laptop2Price = new JLabel("$"+laptop2.getPrice());
	JButton laptop2ExploreMore = new JButton("Explore More");
	JLabel ranklabel2 = new JLabel("2");

	JPanel laptop3Panel = new JPanel();
	LaptopImg laptop3 = LaptopStoreApplication.laptopArray[2];
	JLabel laptop3image = new JLabel(new ImageIcon(laptop3.getImageAddress()));
	JLabel laptop3Title = new JLabel(laptop3.getBrand()+" "+laptop3.getModel());
	JLabel laptop3Price = new JLabel("$"+laptop3.getPrice());
	JButton laptop3ExploreMore = new JButton("Explore More");
	JLabel ranklabel3 = new JLabel("3");
		
	//constructor		
	public LaptopStoreResultsFrame() {
		
		//
		laptopFrameArray[0] = laptop1Panel;
		laptopFrameArray[1] = laptop2Panel;
		laptopFrameArray[2] = laptop3Panel;
		
		//
		labelArrayMatrix[0][0] = laptop1image;
		labelArrayMatrix[1][0] = laptop2image;
		labelArrayMatrix[2][0] = laptop3image;
		
		labelArrayMatrix[0][1] = laptop1Title;
		labelArrayMatrix[1][1] = laptop2Title;
		labelArrayMatrix[2][1] = laptop3Title;
		
		labelArrayMatrix[0][2] = laptop1Price;
		labelArrayMatrix[1][2] = laptop2Price;
		labelArrayMatrix[2][2] = laptop3Price;
		
		labelArrayMatrix[0][3] = ranklabel1;
		labelArrayMatrix[1][3] = ranklabel2;
		labelArrayMatrix[2][3] = ranklabel3;
		
		//
		exploreMoreArray[0] = laptop1ExploreMore;
		exploreMoreArray[1] = laptop2ExploreMore;
		exploreMoreArray[2] = laptop3ExploreMore;
		
		//setup frame
		setIconImage(new ImageIcon("logo.jpg").getImage());
		setTitle("Laptop Store");		
		setSize(1920,1080);
		setLayout(null);
		
		menuBar.add(mHome);
		menuBar.add(mBrowse);
		menuBar.add(mQuiz);
		setJMenuBar(menuBar);

		// bkgd image
		bkgdImage.setBounds(-10,0,1920,1080);
		bkgdImage.setLayout(null);
		add(bkgdImage);
		
		// white bkgd
		whitePanel.setBounds(50, 40, 1200, 120);
		whitePanel.setLayout(null);
		bkgdImage.add(whitePanel);
		
		//laptops panel
		scrollPanel.setBounds(50, 140, 1200, 180*3);
		scrollPanel.setBackground(new Color(255,55,255));
		scrollPanel.setLayout(null);
		//scrollPanel.setLayout(new RowLayout());
		bkgdImage.add(scrollPanel);
		
		
		// LAPTOP FRAMES
		for (int index = 0; index < laptopFrameArray.length; index++) {
			
			// show laptop frames
			laptopFrameArray[index].setBounds(0, 180*index, 1200, 180);
			laptopFrameArray[index].setBackground(new Color(255,255,255));
			laptopFrameArray[index].setLayout(null);
			scrollPanel.add(laptopFrameArray[index]);
		
			// show image
			labelArrayMatrix[index][0].setBounds(30+75, 0, 200, 200);
			labelArrayMatrix[index][0].setLayout(null);
			laptopFrameArray[index].add(labelArrayMatrix[index][0]);
			
			// show title
			labelArrayMatrix[index][1].setBounds(250+75, 30, 4000, 50);
			labelArrayMatrix[index][1].setFont(new Font("Garamond", Font.BOLD, 25));
			labelArrayMatrix[index][1].setForeground(darkBlue);
			labelArrayMatrix[index][1].setLayout(null);
			laptopFrameArray[index].add(labelArrayMatrix[index][1]);
			
			// show price
			labelArrayMatrix[index][2].setBounds(250+75, 55, 100, 50);
			labelArrayMatrix[index][2].setFont(new Font("Garamond", Font.PLAIN, 15));
			labelArrayMatrix[index][2].setForeground(darkBlue);
			labelArrayMatrix[index][2].setLayout(null);
			laptopFrameArray[index].add(labelArrayMatrix[index][2]);
			
			labelArrayMatrix[index][3].setBounds(40, 40, 50, 100);
			labelArrayMatrix[index][3].setFont(new Font("Garamond", Font.PLAIN, 60));
			labelArrayMatrix[index][3].setForeground(lightBlue);
			labelArrayMatrix[index][3].setBackground(darkBlue);
			labelArrayMatrix[index][3].setLayout(null);
			laptopFrameArray[index].add(labelArrayMatrix[index][3]);
			
			// show explore more button
			exploreMoreArray[index].setBounds(250+75, 100, 150, 50);
			exploreMoreArray[index].setFont(new Font("Garamond", Font.BOLD, 15));
			exploreMoreArray[index].setBackground(lightBlue);
			exploreMoreArray[index].setForeground(Color.WHITE);
			exploreMoreArray[index].setLayout(null);
			laptopFrameArray[index].add(exploreMoreArray[index]);
			
			exploreMoreArray[index].addActionListener(this);
		}
		
		// header 
		resultsTitle.setBounds(40, 30, 500, 60);
		resultsTitle.setFont(new Font("Garamond", Font.BOLD, 50));
		resultsTitle.setForeground(darkBlue);
		resultsTitle.setLayout(null);
		whitePanel.add(resultsTitle);
	
		//show the frame
		setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		new AboutFrame();
		
	}
}
