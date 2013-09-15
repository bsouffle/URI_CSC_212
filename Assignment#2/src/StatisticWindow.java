import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class StatisticWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton buttonRemove;
	private JButton buttonRandom;
	private JButton buttonMaximum;
	private JButton buttonMinimum;

	private JPanel statsPanel = new JPanel() {
        @Override
        public void paintComponent(Graphics g) {
        	super.paintComponent(g);
            
            mDataOrganizer.paint(g);
        }
    };
	
	private DataOrganizer mDataOrganizer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticWindow frame = new StatisticWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StatisticWindow() {
		setTitle("CSC 212 - Statistics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		buttonRemove = new JButton("Remove");
		buttonRemove.setForeground(Color.WHITE);
		buttonRemove.setBackground(Color.BLACK);
		buttonRemove.addActionListener(this);
		buttonRemove.setBounds(25, 174, 101, 33);
		contentPane.add(buttonRemove);
		
		buttonRandom = new JButton("Random");
		buttonRandom.setForeground(Color.BLACK);
		buttonRandom.setBackground(Color.YELLOW);
		buttonRandom.addActionListener(this);
		buttonRandom.setBounds(25, 26, 101, 33);
		contentPane.add(buttonRandom);
		
		buttonMaximum = new JButton("Maximum");
		buttonMaximum.addActionListener(this);
		buttonMaximum.setBounds(25, 79, 101, 33);
		contentPane.add(buttonMaximum);
		
		buttonMinimum = new JButton("Minimum");
		buttonMinimum.addActionListener(this);
		buttonMinimum.setBounds(25, 123, 101, 33);
		contentPane.add(buttonMinimum);
		
		statsPanel.setBounds(168, 26, 311, 181);
		contentPane.add(statsPanel);
		
		mDataOrganizer = new DataOrganizer();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonRandom){
			mDataOrganizer.generateAndDisplayRandomStats();
		}
		else if(e.getSource() == buttonMaximum){
			mDataOrganizer.selectMaximum();
		}
		else if(e.getSource() == buttonMinimum){
			mDataOrganizer.selectMinimum();
		}
		else if(e.getSource() == buttonRemove){
			mDataOrganizer.removeSelected();
		}

		statsPanel.repaint();
	}
}
