import java.util.* ;
import java.awt.event.* ;
import java.awt.* ;
import javax.swing.* ;

public class SignUp extends JFrame{

	private Container content_pane ;
	private JOptionPane dialog  ;
	private JFrame f ;
	private MailServer servers ;
	
	public SignUp(JFrame f,MailServer servers){
	this.f=f ;
	this.servers=servers ;
	//content_pane=getContentPane() ;
	dialog= new JOptionPane() ;
 	setDefaultCloseOperation(DISPOSE_ON_CLOSE) ;
	displaySignUp() ;
 	}
	
	private void displaySignUp(){
		setLayout(null) ;
		setBounds(300,50,700,650) ;
		setTitle("Sign-Up for new Account") ;
		ImageIcon image=new ImageIcon("image.jpg") ;
		JLabel background=new JLabel(image) ;
		background.setBounds(0,0,700,650);
		JLabel server=new JLabel("Enter Server for Account : ") ;
		server.setFont(new Font("Serif", Font.BOLD, 16));
		server.setForeground(Color.WHITE);
		JLabel username=new JLabel("Enter Username for Account : ") ;
		username.setFont(new Font("Serif", Font.BOLD, 16));
		username.setForeground(Color.WHITE);
		JLabel password=new JLabel("Enter Password for Account : ") ;
		password.setFont(new Font("Serif", Font.BOLD, 16));
		password.setForeground(Color.white);
		JLabel passwordrep=new JLabel("Repeat Password for Account : ") ;
		passwordrep.setFont(new Font("Serif", Font.BOLD, 16));
		passwordrep.setForeground(Color.WHITE);
		JTextField serverInput=new JTextField() ;
		JTextField usertext=new JTextField() ;
		JPasswordField passtext=new JPasswordField() ;
		JPasswordField passtextrep=new JPasswordField() ;
		JButton signup=new JButton("SIGN UP") ;
		JButton back=new JButton("Back") ;
		JPanel panel=new JPanel(new GridLayout(4,4))  ;
		JPanel buttonpanel=new JPanel(new FlowLayout(FlowLayout.CENTER)) ;
		panel.add(server);
		panel.add(serverInput);
		panel.add(username) ;
		panel.add(usertext) ;
		panel.add(password) ;
		panel.add(passtext) ;
		panel.add(passwordrep) ;
		panel.add(passtextrep) ;
		buttonpanel.add(back) ;
		buttonpanel.add(signup) ;
		panel.setBounds(130,230,450,100) ;
		buttonpanel.setBounds(260,330,200,50);
		panel.setOpaque(false);
		buttonpanel.setOpaque(false);
		background.add(panel) ;
		background.add(buttonpanel) ;
		add(background) ;
		validate() ;
		repaint() ;
		signup.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			String serverName=serverInput.getText();
			String usname=usertext.getText() ;
			String pass=passtext.getText() ;
			String passrep=passtextrep.getText() ;
			if((usname.isEmpty())||(pass.isEmpty())||(passrep.isEmpty())){
			dialog.showMessageDialog(content_pane,"Fields can not be left empty !","Error",JOptionPane.ERROR_MESSAGE) ;
			}
			else{
			if(pass.equals(passrep)){
			MailLogin.users.add(new MailClient(servers,serverName,usname,pass)) ;
			
		//	System.out.println("Account added : "+usname);
			
			dialog.showMessageDialog(content_pane,"Sign-Up Successful !",":)",JOptionPane.INFORMATION_MESSAGE) ;
			setVisible(false) ;
			f.setVisible(true);
			}
			else{
			dialog.showMessageDialog(content_pane,"The two Passwords do not match !","ERROR",JOptionPane.ERROR_MESSAGE) ;
			} } } } ) ;
		back.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			setVisible(false) ;
			f.setVisible(true);
			} } ) ;
		setVisible(true) ;
}

}