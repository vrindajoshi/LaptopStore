import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PacManIntro extends JFrame implements ActionListener{
	
	static int selectedTheme;
	
	private String[] themes = {"DEFAULT", "PINK"};
	
	private JPanel mainPanel = new JPanel();
	
	private JPanel main2Panel = new JPanel();
	private ImageIcon titlePic = new ImageIcon("images/pacManTitle.png");
	
	private JLabel objectiveLabel = new JLabel("<html>OBJECTIVE: Lorem ipsum dolor sit amet, consectetur"
			+ " adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim "
			+ "veniam, quis nostrud exercitation ullamco laboris.</html>");

	private JLabel howToPlayLabel = new JLabel("<html>HOW TO PLAY: Lorem ipsum dolor sit amet, consectetur adipiscing "
			+ "elit, sed do eiusmod tempor incididunt</html>");
	
	private JButton startButton = new JButton("START");
	
	static JTextField nameEntry = new JTextField();
	
	private JLabel nameEntryLabel = new JLabel("ENTER NAME");
	
	private JLabel themePickerLabel = new JLabel("CHOOSE THEME");
	
	private JComboBox themePicker = new JComboBox(themes);
				
	public PacManIntro() {
				
		setSize(600, 600);
		setTitle("PacMan");
		setLayout(null);
		
		bkgdPanel();
		
		contentsPanel();
		
		startButton();
		
		setVisible(true);		
		
	}

	private void startButton() {
		
		startButton.setBounds(330, 400, 100, 40);
		startButton.setFont(new Font("Garamond", Font.BOLD, 20));
		startButton.setBackground(Color.LIGHT_GRAY);
		startButton.setLayout(null);
		startButton.addActionListener(this);
		main2Panel.add(startButton);
		
	}

	private void contentsPanel() {

		main2Panel.setBounds(40, 40, 480, 480);
		main2Panel.setLayout(null);
		main2Panel.setBackground(Color.MAGENTA);

		mainPanel.add(main2Panel);

		JLabel titleLabel = new JLabel(new ImageIcon(titlePic.getImage().getScaledInstance(425, 400, java.awt.Image.SCALE_SMOOTH)));
		
		titleLabel.setBounds(40, 0, 400, 170);
		titleLabel.setLayout(null);
		main2Panel.add(titleLabel);
		
		
		objectiveLabel.setBounds(40, 150, 400, 100);
		objectiveLabel.setFont(new Font("Garamond", Font.PLAIN, 18));
		objectiveLabel.setLayout(null);
		main2Panel.add(objectiveLabel);
		
		howToPlayLabel.setBounds(40, 250, 400, 90);
		howToPlayLabel.setFont(new Font("Garamond", Font.PLAIN, 18));
		howToPlayLabel.setLayout(null);
		main2Panel.add(howToPlayLabel);
		
		nameEntryLabel.setBounds(40, 400, 125, 30);
		nameEntryLabel.setFont(new Font("Garamond", Font.BOLD, 15));
		nameEntryLabel.setLayout(null);
		main2Panel.add(nameEntryLabel);
		
		nameEntry.setBounds(165, 400, 125, 30);
		nameEntry.setFont(new Font("Garamond", Font.BOLD, 18));
		nameEntry.setBorder(null);
		nameEntry.setLayout(null);
		main2Panel.add(nameEntry);
		
		themePickerLabel.setBounds(40, 350, 150, 30);
		themePickerLabel.setFont(new Font("Garamond", Font.BOLD, 15));
		themePickerLabel.setLayout(null);
		main2Panel.add(themePickerLabel);
		
		themePicker.setSelectedIndex(0);
		themePicker.setBounds(180, 350, 125, 30);
		main2Panel.add(themePicker);


		//themePicker.addActionListener(this);
		
	}

	private void bkgdPanel() {

		mainPanel.setBounds(0, 0, 600, 600);
		mainPanel.setBackground(Color.BLACK);
		mainPanel.setLayout(null);
		add(mainPanel);
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		selectedTheme = themePicker.getSelectedIndex();
		System.out.println(selectedTheme);
		new PacManGUI();
		ScorePanel.userNameLabel.setText(nameEntry.getText().toUpperCase());
		setVisible(false);
	}
		
}
	
	