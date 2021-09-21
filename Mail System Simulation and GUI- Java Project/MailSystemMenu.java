import java.util.* ;
import java.awt.event.* ;
import java.awt.* ;
import javax.swing.* ;

public class MailSystemMenu extends JFrame{

	private Container contentPane ;
	private MailServer servers ;
	
	public MailSystemMenu(){
		servers=new MailServer() ;
		setTitle("Mail System") ;
		setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		makeMenuBar() ;
		displayMenu() ;
		
	}
	
	private void displayMenu(){
		JFrame f=this ;
		setLayout(null);
		setBounds(300,50,700,650) ;
		ImageIcon image=new ImageIcon("image.jpg") ;
		JLabel background=new JLabel(image) ;
		background.setBounds(0,0,700,650);
		JPanel panel=new JPanel(new FlowLayout(FlowLayout.CENTER)) ;
		JPanel panel1=new JPanel(new BorderLayout()) ;
		JLabel l1=new JLabel("Click on one of the Following Buttons to Begin ! ") ;
		l1.setFont(new Font("Serif", Font.BOLD, 20));
		l1.setForeground(Color.white);
		JButton sign_up=new JButton("SIGN-UP") ;
		JButton login=new JButton("SIGN-IN") ;
		JButton exit=new JButton("EXIT") ;
		panel1.add(l1,BorderLayout.NORTH) ;
		panel.add(sign_up) ;
		panel.add(login) ;
		panel.add(exit) ;
		panel.setBounds(130,250,400,60);
		panel1.setBounds(150,210,450,30);
		panel.setOpaque(false);
		panel1.setOpaque(false);
		add(background) ;
		background.add(panel1) ;
		background.add(panel) ;
		validate() ;
		repaint() ;
		setVisible(true) ;
		sign_up.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
		setVisible(false) ;
		SignUp window=new SignUp(f,servers) ; 
 		} } ) ;
		login.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
		setVisible(false) ;
		SignIn s=new SignIn(f) ;
		} } ) ;
		exit.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
		System.exit(0) ;
		} } ) ;
		
	}
	
	private void makeMenuBar(){
		JFrame f=this ;
		JMenuBar menubar=new JMenuBar() ;
		setJMenuBar(menubar) ;
		JMenu about=new JMenu("About") ;
		menubar.add(about) ;
		JMenuItem exit=new JMenuItem("Exit") ;
		JMenuItem developerInfo=new JMenuItem("Developer Info") ;
		about.add(developerInfo) ;
		about.add(exit) ;
		developerInfo.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
		JOptionPane dialog=new JOptionPane() ;
		dialog.showMessageDialog(f,"Rehman Aziz / 0002-BSCS-2017 \nTafseer-ul-Hassan / 0029-BSCS-2017 \nAmeera / 0035-BSCS-2017 \nNaiza Mushtaq / 0020-BSCS-2017 \nAmna Ijaz / 0026-BSCS-2017",
		"DEVELOPER INFO",JOptionPane.INFORMATION_MESSAGE) ; } } ) ;
		exit.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
		System.exit(0) ; } } ) ;
		}
	
}