
import java.net.*;



import java.io.*;
public class Event {
	
	public Event(Person p) {

		try {
			String serverIp = "127.0.0.1";

			System.out.println("������ �������Դϴ�. ����IP :" + serverIp);
			Socket socket = new Socket(serverIp, 8888); 

			// ������ ��½�Ʈ���� ��´�.
			OutputStream out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			
			String msg = p.toString();
			dos.writeUTF(msg);
			// ��Ʈ���� ������ �ݴ´�.
			dos.close();
			socket.close();
			System.out.println("������ ����Ǿ����ϴ�.");
		} catch(ConnectException ce) {
			ce.printStackTrace();
		} catch(IOException ie) {
			ie.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();  
		}  
	} 
}


