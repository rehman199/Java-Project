 

public class MailItem {
	private String from ;
	private String to;
	private String message ;
	private boolean status=false ;
	private int read=0 ;
	private boolean sent=false ;
	private String subject ;
	
	public MailItem(String from,String to,String message,String subject) {
		this.from=from ;
		this.to=to ;
		this.message=message ;
		this.subject=subject ;
	}
	
	public String getMessage() {
		return(message) ;
	}
	
	public void setStatus(boolean s) {
		this.status=s ;
	}
	
	public boolean getStatus() {
		return status ;
	}
	
	public String getTo() {
		return(to) ;
	}
	
	public String getFrom() {
		return(from) ;
 	}
	
	public void sent(boolean status) {
		sent=status ;
	}
	
	public boolean isSent() {
		return sent ;
	}
	
	public String getSubject() {
		return subject ;
	}
	
	public void print() {
		setStatus(true) ;
		System.out.println("From : "+getFrom());
		System.out.println("To   : "+getTo());
		System.out.println(getMessage());
	}
	
}
