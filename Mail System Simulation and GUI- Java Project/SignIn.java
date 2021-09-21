import java.util.* ;
import java.awt.event.* ;
import java.awt.* ;
import javax.swing.* ;

public class SignIn {
	
	private JFrame 	frame=new JFrame("Sign In to Your Account") ; ;
	private JFrame f ;
	public SignIn(JFrame f){
	this.f=f ;
	makeFrame() ;
	}
	
	
	private void makeFrame(){
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE) ;
		displayLogin() ;
		frame.setVisible(true) ;
	}
		
	private void displayLogin() {
		frame.setLayout(null);
		frame.setBounds(300,50,700,650) ;
		JLabel background=getBackground(700,650,"image.jpg") ;
		JPanel panel=new JPanel(new GridLayout(2,2)) ;
		JButton b1=new JButton("LOGIN") ;
		JButton b2=new JButton("Back") ;
		JLabel l1=new JLabel("Enter Username : ") ;
		l1.setFont(new Font("serif",Font.BOLD,16));
		l1.setForeground(Color.WHITE);
		JLabel l2=new JLabel("Enter Password : ") ;
		l2.setFont(new Font("serif",Font.BOLD,16));
		l2.setForeground(Color.WHITE);
		JTextField t1=new JTextField() ;
		JPasswordField p1=new JPasswordField() ;
		panel.add(l1) ;
		panel.add(t1) ;
		panel.add(l2) ;
		panel.add(p1) ;
		panel.setBounds(190,230,300,60);
		JPanel panelbutton=new JPanel(new FlowLayout(FlowLayout.CENTER)) ;
		panelbutton.add(b2) ;
		panelbutton.add(b1) ;
		panelbutton.setBounds(240,290,200,50);
		panel.setOpaque(false);
		panelbutton.setOpaque(false);
		background.add(panel) ;
		background.add(panelbutton) ;
		frame.add(background) ;
		frame.validate();
		frame.repaint();
		b1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){	
		String u=t1.getText() ; 
		String p=p1.getText() ;
		JOptionPane dialog=new JOptionPane() ;
		boolean login=false ;
		for(MailClient m:MailLogin.users){
		if((u.equals(m.login.getUserName()))&&(p.equals(m.login.getPassword()))){
			dialog.showMessageDialog(frame,"Login Successful","Login",JOptionPane.INFORMATION_MESSAGE) ;
			
			//System.out.println("Logged into "+u+"'s account.");
			
			frame.setVisible(false) ;
			displayMailFunctions(u) ;
			login=true ;
			}
		}
		if(login==false){
			dialog.showMessageDialog(frame,"Login not Successful\nTry Again !","Error",JOptionPane.ERROR_MESSAGE) ;	
		} } } ) ; 	
		b2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
		frame.setVisible(false) ;
		f.setVisible(true); } } ) ;
	}
	
	public void displayMailFunctions(String user){
		JFrame functionFrame=new JFrame() ;
		Container content_pane=functionFrame.getContentPane() ;
		JOptionPane dialog=new JOptionPane() ;
		String server=null ;
		for(MailClient mc1:MailLogin.users) {
			if(mc1.getUser().equals(user)) {
				server=mc1.getServerName() ;
			}
		}
		functionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE) ;
		functionFrame.setTitle(server+" user : "+user) ;
		functionFrame.setSize(1200,700) ;
		JLabel background=getBackground(1200,700,"image.jpg") ;
		content_pane.setLayout(null) ;
		FlowLayout fl=new FlowLayout(FlowLayout.CENTER) ;
		fl.setVgap(60) ;
		JPanel buttonPanel=new JPanel(fl) ;
		buttonPanel.setBounds(10,10,180,600) ;
		buttonPanel.setOpaque(false);
		JInternalFrame mails=new JInternalFrame("Mails") ;
		mails.setLayout(null) ;
		mails.setBounds(280,10,800,600) ;
		mails.setOpaque(false);
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
		ArrayList<JButton> buttons=new ArrayList<JButton>() ;
		compose.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			mails.getContentPane().removeAll();
			mails.setTitle("Compose New Email");
			JPanel composePanel=new JPanel() ;
			composePanel.setLayout(null);
			composePanel.setBounds(0,0,800,600) ;
			composePanel.setVisible(true);
			JLabel from=new JLabel("From : ") ;
			from.setFont(new Font("Serif", Font.BOLD, 20));
			from.setBounds(10,0,100,40) ;
			JLabel fromField=new JLabel(user) ;
			fromField.setFont(new Font("Serif", Font.BOLD, 20));
			fromField.setBounds(80,0,250,40);
			JLabel to=new JLabel("To : ") ;
			to.setFont(new Font("Serif", Font.BOLD, 20));
			to.setBounds(10,70,50,40) ;
			JTextField toField=new JTextField() ;
			toField.setBounds(100,70,250,40) ;
			toField.setFont(new Font("Serif", Font.BOLD, 20));
			JLabel subject= new JLabel("Subject : ") ;
			subject.setFont(new Font("Serif", Font.BOLD, 20));
			subject.setBounds(10,130,120,40) ;
			JTextField subjectField=new JTextField() ;
			subjectField.setFont(new Font("Serif", Font.BOLD, 20));
			subjectField.setBounds(100,130,250,40) ;
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
			composePanel.add(subject) ;
			composePanel.add(subjectField) ;
			composePanel.add(message) ;
			composePanel.add(messageField) ;
			composePanel.add(send) ;
			mails.add(composePanel) ;
			mails.updateUI();
			mails.setVisible(true);
			send.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
				String t=toField.getText() ;
				String m=messageField.getText() ;
				String s=subjectField.getText() ;
				boolean sent=false ;
				if(t.isEmpty()||m.isEmpty()||s.isEmpty()) {
					dialog.showMessageDialog(composePanel,"The Fields Cannot be Empty !","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
				for(MailClient mc:MailLogin.users) {
					if(mc.getUser().equals(user)) {	
					mc.sendMail(t,m,s);	
					sent=true ;
					//System.out.println("1");
					}
				}
				if(sent==true) {
				dialog.showMessageDialog(composePanel,"Message Sent Successfully","Messege Sent",JOptionPane.INFORMATION_MESSAGE);
				mails.remove(composePanel) ;
				mails.dispose() ;
				}	}
			} } );
			
			} } ) ;
		unread_email.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			buttons.removeAll(buttons) ;
			mails.getContentPane().removeAll();
			JPanel unreadMails=new JPanel() ;
			unreadMails.setLayout(null);
			unreadMails.setBounds(0, 0, 800,600);
			for(MailClient mc2:MailLogin.users) {
				if(mc2.getUser().equals(user)) {
				if((mc2.server.unreadEmail(user))==0) {
				dialog.showMessageDialog(functionFrame,"No new Unread Emails !","Unread Emails",
				JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					for(MailItem m:mc2.server.items) {
						if((m.getTo().equals(user))&&(m.getStatus()==false)){
							mc2.unreadItems.add(m) ;
						}
					}
					mails.setTitle("Unread Emails");
					int j=0 ;
					JButton b=null ;
				for(int i=0;i<(mc2.unreadItems.size());i++) {
					while(i<mc2.unreadItems.size()) {
						b=getButton(i+1,j) ;
						buttons.add(b) ;
						unreadMails.add(b) ;
						j=j+30 ;
						break ;
					}
				}
				mails.add(unreadMails) ;
				mails.updateUI();
				unreadMails.setVisible(true) ;
				unreadMails.updateUI() ;
				mails.setVisible(true);
				Iterator<JButton> it=buttons.iterator() ;
				int i=1 ;
				for(MailItem mi:mc2.unreadItems) {
				JButton bts=it.next() ;
				while(i<=mc2.unreadItems.size()) {
				bts.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
							mi.setStatus(true) ;
							dialog.showMessageDialog(unreadMails,"From : "+mi.getFrom()+"\n\n\nTo : "+user+"\n\nSubject : "+
							mi.getSubject()+"\n\nMessage : "+mi.getMessage()+"\n\n","MAIL",JOptionPane.INFORMATION_MESSAGE);
							mc2.readItems.add(mi) ;
							mc2.unreadItems.remove(mi) ;
							unreadMails.remove(bts) ;
							unreadMails.updateUI();
						} } ) ;
				i+=1 ;
				break ;
				} } } } } } } ) ;
		logout.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			dialog.showMessageDialog(content_pane,"ThankYou for using Our Service !\nHope to see You Again !",
					"ThankYou :)",JOptionPane.INFORMATION_MESSAGE) ;
			functionFrame.dispose(); 
			f.setVisible(true);
	 	} } ) ;
		read_email.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			buttons.removeAll(buttons) ;
 			mails.getContentPane().removeAll();
 			JPanel readMails=new JPanel(null) ;
			readMails.setBounds(0, 0, 800,600);
			for(MailClient mc3:MailLogin.users) {
				if(mc3.getUser().equals(user)) {
				if(mc3.readItems.isEmpty()) {
				dialog.showMessageDialog(functionFrame,"No Email have been Read yet !","Read Emails",
						JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					mails.setTitle("Read Emails");
					int j=0 ;
					JButton b=null ;
				for(int i=0;i<(mc3.readItems.size());i++) {
					while(i<(mc3.readItems.size())) {
						b=getButton(i+1,j) ;
						readMails.add(b) ;
						buttons.add(b);
						j=j+30 ;
						break ;
					}
				}
				mails.add(readMails) ;
				mails.updateUI();
				readMails.setVisible(true) ;
				readMails.updateUI() ;
				mails.setVisible(true);
			Iterator<JButton> it=buttons.iterator() ; 
			int i=1 ;
			for(MailItem mi:mc3.readItems) {
			JButton bts=it.next() ;
			while(i<=mc3.readItems.size()) {
			bts.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {	
			dialog.showMessageDialog(readMails,"From : "+mi.getFrom()+"\n\nTo : "+user+"\n\nSubject : "+
			mi.getSubject()+"\n\nMessage : "+mi.getMessage()+"\n\n","MAIL",JOptionPane.INFORMATION_MESSAGE);
			} } ) ;
			i+=1 ;
			break ;
			}
			} } } } } } ) ;
		
		sent_email.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			buttons.removeAll(buttons) ;
 			mails.getContentPane().removeAll();
 			JPanel sentMails=new JPanel(null) ;
			sentMails.setBounds(0, 0, 800,600) ;
			for(MailClient mc3:MailLogin.users) {
				if(mc3.getUser().equals(user)) {
				if(mc3.sentItems.isEmpty()) {
				dialog.showMessageDialog(functionFrame,"No Emails have been Sent yet !","Sent Emails",
				JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					mails.setTitle("Sent Emails");
					int j=0 ;
					JButton b=null ;
				for(int i=0;i<(mc3.sentItems.size());i++) {
					while(i<=(mc3.sentItems.size())) {
						b=getButton(i+1,j) ;
						sentMails.add(b) ;
						buttons.add(b);
						j=j+30 ;
						break ;
					}
				}
				mails.add(sentMails) ;
				mails.updateUI();
				sentMails.setVisible(true) ;
				sentMails.updateUI() ;
				mails.setVisible(true);
			Iterator<JButton> it=buttons.iterator() ; 
			int i =1 ;
			for(MailItem mit:mc3.sentItems) {
			JButton bts=it.next() ;
			while(i<=mc3.sentItems.size()) {
			bts.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			dialog.showMessageDialog(sentMails,"From : "+mit.getFrom()+"\n\nTo : "+mit.getTo()+"\n\nSubject : "+
			mit.getSubject()+"\n\nMessage : "+mit.getMessage()+"\n\n","MAIL",JOptionPane.INFORMATION_MESSAGE);
			} } ) ;
			i+=1 ;
			break ;
			}
			}
			} } } } } ) ;
								
		background.add(buttonPanel) ;
		background.add(mails) ;
		content_pane.add(background) ;
		functionFrame.setVisible(true) ;
		
		}
	
		private JButton getButton(int mailNum,int increment) {
			JButton button=new JButton("Mail "+mailNum) ;
			button.setBounds(0,increment,800,40);
			return(button) ;
		}
		
		private JLabel getBackground(int w,int h,String images) {
			ImageIcon image=new ImageIcon(images) ;
			JLabel background=new JLabel(image) ;
			background.setBounds(0,0,w,h);
			return(background) ;
		}
}