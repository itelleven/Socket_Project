import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;



//database��! CreateTable ���� �������ּ���
//Server ���� ����
//�� ���� Client ����

//���� �ȵ� ��� jdbc����

public class Main {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		new CreateTable();
		
		//�������� �������� ����
		ServerGui serverGui = new ServerGui();
		serverGui.setVisible(true);
		
		try {
			serverSocket = new ServerSocket(8888);
		} catch(IOException e) {
			e.printStackTrace();
		}


		while(true) {
			try {
				System.out.println("���ϻ����Ϸ�");
				Socket socket = serverSocket.accept();
				OutputStream out = socket.getOutputStream();

				// ������ �Է½�Ʈ���� ��´�.
				InputStream in = socket.getInputStream();
				DataInputStream dis = new DataInputStream(in);

				String client_msg = dis.readUTF();
				System.out.println(client_msg);

				String[] res = client_msg.split(" ");

				new Insert(res[0], Integer.parseInt(res[1]));
				// �������� ���� ���� �����͸� ����Ѵ�.
				//System.out.println("�����κ��� ���� �޽��� :"+dis.readUTF());      
				System.out.println("������ �����մϴ�.");

				socket.close();
				
				//�߰�! ���ο� ������ �����ֱ�(������Ʈ(�ڵ�))
				serverGui.setVisible(false);
				serverGui = new ServerGui();
				serverGui.setVisible(true);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // while
	} // main
}

