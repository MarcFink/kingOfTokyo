package KingOfTokyoClient;

public class GUIUpdateThread extends Thread {
	/* 
	 * @author Attinkara Robin
	 * */
	ClientView clientView;
	
	
	public GUIUpdateThread(ClientView clientView){
		
		this.clientView=clientView;
		
		
		
	}
	
	public void run(){
		while(true){
			clientView.updateGUI();
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
