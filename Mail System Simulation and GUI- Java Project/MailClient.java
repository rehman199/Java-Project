import java.util.* ; 

public class MailClient {
	public MailLogin login ;
	public MailServer server ;
	private String user,serverName ;	
	Scanner read=new Scanner(System.in) ;
	
	public ArrayList<MailItem> sentItems=new ArrayList<MailItem>() ;
	public ArrayList<MailItem> readItems=new ArrayList<MailItem>() ;
	public ArrayList<MailItem> unreadItems=new ArrayList<MailItem>() ;
	
	
	public MailClient(MailServer server,String serverName,String user,String pass) {
		this.user=user ;
		login=new MailLogin(user,pass) ;
		this.serverName=serverName ;
		this.server=server ;
	}
	
	public void printMail() {
		if(server.unreadEmail(user)==0)
			System.out.println("No New Unread Email ! ") ;
		else
		server.getMail(user).print();
	}
	
	public void sendMail(String to,String message,String subject) {
		MailItem m=new MailItem(user,to,message,subject) ;
		m.sent(true);
		sentItems.add(m) ;
		server.post(m);
		
	}
	
	public String getUser(){
		return(user) ;
	}
	
	public String getServerName() {
		return(serverName) ; 
	}
}
