import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
public class MailFunctions extends JFrame {

	private String user ;
	private Container content_pane ;
	JOptionPane dialog ;
	
	public MailFunctions(String user){
	this.user=user ;
	content_pane=getContentPane() ;
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
	dialog=new JOptionPane() ;
	displayMailFunctions() ;
	}

	private void displayMailFunctions(){
		
	setTitle("MAIL SYSTEM") ;
	setSize(1200,700) ;
	content_pane.setLayout(null) ;
	FlowLayout fl=new FlowLayout(FlowLayout.CENTER) ;
	fl.setVgap(60) ;
	JPanel buttonPanel=new JPanel(fl) ;
	buttonPanel.setBounds(10,10,180,600) ;
	buttonPanel.setBackground(Color.white);
	JInternalFrame mails=new JInternalFrame("Mails") ;
	mails.setLayout(null) ;
	mails.setBounds(280,10,800,600) ;
	mails.setBackground(Color.YELLOW) ;
	mails.setVisible(true) ;
	JButton compose=new JButton("COMPOSE") ;
	JButton unread_email=new JButton("Unread Emails") ;
	JButton read_email=new JButton("Read Emails") ;
	JButton sent_email=new JButton("Sent Emails") ;
	JButton logout=new JButton("LogOut") ;
	buttonPanel.add(compose) ;
	buttonPanel.add(unread_email) ;
	buttonPanel.add(read_email) ;
	buttonPanel.add(sent_email) ;
	buttonPanel.add(logout) ;
	compose.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
		JPanel composePanel=new JPanel() ;
		composePanel.setLayout(null);
		composePanel.setBounds(0,0,800,600) ;
		composePanel.setOpaque(true);
		composePanel.setBackground(Color.yellow);
		JLabel from=new JLabel("From : ") ;
		from.setFont(new Font("Serif", Font.BOLD, 20));
		from.setBounds(10,0,100,40) ;
		JLabel fromField=new JLabel(user) ;
		fromField.setFont(new Font("Serif", Font.BOLD, 20));
		fromField.setBounds(80,0,250,40);
		JLabel to=new JLabel("To : ") ;
		to.setFont(new Font("Serif", Font.BOLD, 20));
		to.setBounds(10,100,50,40) ;
		JTextField toField=new JTextField() ;
		toField.setBounds(60,100,250,40) ;
		toField.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel message=new JLabel("Message : ") ;
		message.setFont(new Font("Serif", Font.BOLD, 20));
		message.setBounds(10,200,120,40);
		JTextField messageField=new JTextField() ;
		messageField.setFont(new Font("Serif", Font.BOLD, 30));
		messageField.setBounds(0,250,800,260);
		JButton send=new JButton("Send") ;
		send.setBounds(360,520,80,40);
		composePanel.add(from) ;
		composePanel.add(fromField) ;
		composePanel.add(to) ;
		composePanel.add(toField) ;
		composePanel.add(message) ;
		composePanel.add(messageField) ;
		composePanel.add(send) ;
		send.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			String t=to.getText() ;
			String m=message.getText() ;
			for(MailClient mc:MailLogin.users) {
				if(mc.getUser().equals(user)) {	
				mc.sendMail(t,m);	
				}
			}
			dialog.showMessageDialog(composePanel,"Message Sent Successfully","Messege Sent",JOptionPane.INFORMATION_MESSAGE);
			composePanel.setVisible(false);
			mails.remove(composePanel) ;
		} } );
		composePanel.setVisible(true);
		mails.add(composePanel) ;
		mails.updateUI();
		
	} } ) ;
	unread_email.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {

	} } ) ;
	logout.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
		setVisible(false) ;
		dialog.showMessageDialog(content_pane,"ThankYou for using Our Service !\nHope to see You Again !","ThankYou :)",JOptionPane.INFORMATION_MESSAGE) ;
		MailSystemMenu m=new MailSystemMenu() ;
 	} } ) ;
	content_pane.add(buttonPanel) ;
	content_pane.add(mails) ;
	
	setVisible(true) ;
	
	}
}