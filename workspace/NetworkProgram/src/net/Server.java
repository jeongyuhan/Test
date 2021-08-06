package net;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author 
 *
 */

public class Server {
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("127.0.0.1", 1234));
			while(true) {
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
				
				InputStream is = socket.getInputStream();
				byte[] b = new byte[100];
				int readByte = is.read(b);
				String message = new String(b, 0, readByte, "UTF-8");
				System.out.println("클라이언트 " + isa.getHostName() + "(으)로부터 " + message + "를 받았습니다.");				
				is.close();
				socket.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try{				
				if(!serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
