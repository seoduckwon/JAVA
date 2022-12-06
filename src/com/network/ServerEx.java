package com.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class ServerEx {

	public static void main(String[] args) {
		
	
	ServerSocket server = null;
	Socket socket = null;
	BufferedReader in = null;
	BufferedWriter out = null;
	Scanner sc = new Scanner(System.in);
	
	try {
		server = new ServerSocket(9999); //정상적인 포트가 없을 경우 캐
		System.out.println("연결 대기");
		
		socket = server.accept(); //accept의 return 타입은 socket
		System.out.println("연결 되었습니다.");
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		while(true) {
			String inMsg = in.readLine();
			if((inMsg).equalsIgnoreCase("bye")) { // equalsIgnoreCase 대소문자 무시  
			System.out.println("클라이언트가 나갔습니다"); 
			break;
			}else {
				System.out.println("클라이언트 : "+inMsg);
				
				System.out.println("보내기 >>");
				String outMsg = sc.nextLine();
				out.write(outMsg + "\n");
				out.flush();
				
				
			}
		}
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		
		try {
			sc.close();
			out.close();
			in.close();
			socket.close();
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

}