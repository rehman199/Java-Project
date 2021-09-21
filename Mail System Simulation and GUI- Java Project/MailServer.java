import java.util.ArrayList ;
public class MailServer {
	
	public static ArrayList<MailItem> items=new ArrayList<MailItem>() ;

	public int unreadEmail(String u) {
		int count=0 ;
		for(MailItem m:items) {
		if((m.getStatus()==false)&&(m.getTo().equals(u))){
			count++ ;
		}
		}
		return count ;
	}
	
	public int readEmail(String u) {
		int count=0 ;
		for(MailItem m:items) {
		if((m.getStatus()==true)&&m.getTo().equals(u)) {
			count++ ;
		}
		}
		return count ;
	}
	
	public int sentEmail(String u) {
		int count=0 ;
		for(MailItem m:items) {
		if((m.isSent()==true)&&m.getFrom().equals(u)) {
			count++ ;
		}
		}
		return count ;
	}
	
	public MailItem getMail(String u) {
		for(MailItem m:items) {
		if(u.equals(m.getTo())&&(m.getStatus()==false)) {
			return(m) ;
		}
		}
		return null ;
	}

	public void post(MailItem item) {
		items.add(item) ;
	}
	
}
