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



//database에! CreateTable 부터 실행해주세요
//Server 먼저 실행
//그 다음 Client 실행

//실행 안될 경우 jdbc연결

public class Main {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		new CreateTable();
		
		//참조변수 선언으로 변경
		ServerGui serverGui = new ServerGui();
		serverGui.setVisible(true);
		
		try {
			serverSocket = new ServerSocket(8888);
		} catch(IOException e) {
			e.printStackTrace();
		}


		while(true) {
			try {
				System.out.println("소켓생성완료");
				Socket socket = serverSocket.accept();
				OutputStream out = socket.getOutputStream();

				// 소켓의 입력스트림을 얻는다.
				InputStream in = socket.getInputStream();
				DataInputStream dis = new DataInputStream(in);

				String client_msg = dis.readUTF();
				System.out.println(client_msg);

				String[] res = client_msg.split(" ");

				new Insert(res[0], Integer.parseInt(res[1]));
				// 소켓으로 부터 받은 데이터를 출력한다.
				//System.out.println("서버로부터 받은 메시지 :"+dis.readUTF());      
				System.out.println("연결을 종료합니다.");

				socket.close();
				
				//추가! 새로운 프레임 보여주기(업데이트(자동))
				serverGui.setVisible(false);
				serverGui = new ServerGui();
				serverGui.setVisible(true);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // while
	} // main
}

