import java.net.*;
import java.io.*;

public class TCPServer {
	public static void main(String args[])throws Exception
	{
		ServerSocket soc=new ServerSocket(2535);
		
		Socket socket=soc.accept();  
		
		DataInputStream dis=new DataInputStream(socket.getInputStream());
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String str1="",str2="";
		String con="stop";
		/*if(con=="stop"||con=="Stop")
		{
			System.out.println("Executed...");
		}*/
		
		while(!str1.equals("Stop") || !str1.equals("stop"))
		{
			if(con=="stop"||con=="Stop")
			{
				str1=br.readLine();
				dos.writeUTF(str1);
				dos.flush();
				str2=dis.readUTF();
				con=str2;
				System.out.println("Client says: "+str2);  
			}

		}
		dos.close();
		socket.close();
		soc.close();
	}
}