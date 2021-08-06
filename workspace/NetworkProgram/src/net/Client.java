package net;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress("127.0.0.1", 1234));
			
			Scanner sc = new Scanner(System.in);
			System.out.println("서버에 전송할 메시지 >>>");
			String message = sc.nextLine();
			
			OutputStream os = socket.getOutputStream();
			os.write(message.getBytes("UTF-8"));
			os.flush();
			os.close();
			System.out.println("서버로 " + message + " 데이터를 전송했습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(!socket.isClosed()) {
					socket.close();
				}				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
