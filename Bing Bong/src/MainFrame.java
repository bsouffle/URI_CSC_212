import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;

public class MainFrame extends JFrame implements ActionListener, AlarmListener {

	private JPanel contentPane;
	private JButton _resetBtn;
	private JButton _slowerBtn;
	private JButton _throwBtn;
	private JButton _fasterBtn;
	private JButton _removeBtn;

	private Collection<Ball> _collection;
	private Alarm _alarm;
	private boolean _running = false;
	private BallPanel _ballsPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		_resetBtn = new JButton("Reset");
		_resetBtn.addActionListener(this);
		_resetBtn.setBounds(10, 11, 89, 23);
		contentPane.add(_resetBtn);

		_slowerBtn = new JButton("Slower");
		_slowerBtn.addActionListener(this);
		_slowerBtn.setBounds(109, 11, 89, 23);
		contentPane.add(_slowerBtn);

		_throwBtn = new JButton("Throw");
		_throwBtn.addActionListener(this);
		_throwBtn.setBounds(307, 11, 89, 23);
		contentPane.add(_throwBtn);

		_fasterBtn = new JButton("Faster");
		_fasterBtn.addActionListener(this);
		_fasterBtn.setBounds(208, 11, 89, 23);
		contentPane.add(_fasterBtn);

		_removeBtn = new JButton("Remove");
		_removeBtn.addActionListener(this);
		_removeBtn.setBounds(406, 11, 89, 23);
		contentPane.add(_removeBtn);

		_ballsPanel = new BallPanel(485, 430);
		_ballsPanel.setBackground(Color.PINK);
		_ballsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		_ballsPanel.setBounds(10, 45, 485, 430);
		contentPane.add(_ballsPanel);

		_collection = new BallCollection();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == _resetBtn) {
			System.out.println("Reset");

			if (_running) {
				_alarm.interrupt();

				_collection.clear();
				
				repaint();
				
				_running = false;
			}
		}
		else if (e.getSource() == _slowerBtn) {
			System.out.println("Slower");
			
			Ball.setSpeed(Ball.getSpeed() - 0.5f);
		}
		else if (e.getSource() == _fasterBtn) {
			System.out.println("Faster");
			
			Ball.setSpeed(Ball.getSpeed() + 0.5f);
		} 
		else if (e.getSource() == _throwBtn) {
			System.out.println("Throw");

			if (_collection.isEmpty()) {
				_alarm = new Alarm(this);

				_alarm.setPeriod(45);

				_alarm.start();

				_running = true;
			}

			_collection.add(Ball.createRandomBall(485, 305));
		} else if (e.getSource() == _removeBtn) {
			System.out.println("Remove");

			_collection.remove();
		}

	}

	@Override
	public void takeNotice() {
		repaint();
	}

	@Override
	public void paint(Graphics g) {

		_ballsPanel.setCollection(_collection);

		super.paint(g);
	}
}
