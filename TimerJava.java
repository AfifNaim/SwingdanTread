import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerJava extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtIsiwaktu;
	private JLabel lblWaktumundur;
	private Timer t;

	private int start = 1;
	private int tm;
	private boolean isTime = false;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimerJava frame = new TimerJava();
					frame.setSize(new Dimension(220, 100));
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
	public TimerJava() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{96, 85, 0};
		gbl_contentPane.rowHeights = new int[]{21, 13, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		txtIsiwaktu = new JTextField();
		GridBagConstraints gbc_txtIsiwaktu = new GridBagConstraints();
		gbc_txtIsiwaktu.anchor = GridBagConstraints.WEST;
		gbc_txtIsiwaktu.insets = new Insets(0, 0, 5, 5);
		gbc_txtIsiwaktu.gridx = 0;
		gbc_txtIsiwaktu.gridy = 0;
		contentPane.add(txtIsiwaktu, gbc_txtIsiwaktu);
		txtIsiwaktu.setColumns(10);
		
		JButton btnStart = new JButton("start");
		//		btnStart.setActionCommand("startTimer");
		btnStart.addActionListener(this);
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.anchor = GridBagConstraints.NORTH;
		gbc_btnStart.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnStart.insets = new Insets(0, 0, 5, 0);
		gbc_btnStart.gridx = 1;
		gbc_btnStart.gridy = 0;
		contentPane.add(btnStart, gbc_btnStart);
		
		lblWaktumundur = new JLabel("start");
		GridBagConstraints gbc_lblWaktumundur = new GridBagConstraints();
		gbc_lblWaktumundur.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblWaktumundur.insets = new Insets(0, 0, 0, 5);
		gbc_lblWaktumundur.gridx = 0;
		gbc_lblWaktumundur.gridy = 1;
		contentPane.add(lblWaktumundur, gbc_lblWaktumundur);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        getTime();
        playTimer();
//        System.out.println("ayy");

	}
	
	public void playTimer() {
//		System.out.println("test");
		start--;
		if(start>=1){
			this.lblWaktumundur.setText("Time : "+start);
//			System.out.println("time : "+ start);
		}else{
			this.lblWaktumundur.setText("Timeout...");
//			System.out.println("timeout");
			t.stop();
		}
	}
	
	public void getTime() {
		if(isTime == false) {
			tm = Integer.parseInt(txtIsiwaktu.getText());
			start += tm;
			t = new Timer(1000,this);
			t.start();
			isTime = true;
		}
	}
}
