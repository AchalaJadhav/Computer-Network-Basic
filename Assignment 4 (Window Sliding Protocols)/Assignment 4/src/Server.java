import java.net.*;
import java.io.*;

public class Server {
	public static void main(String args[])throws Exception
	{
		ServerSocket soc=new ServerSocket(2535);
		
		Socket socket=soc.accept();  
		
		DataInputStream dis=new DataInputStream(socket.getInputStream());
		DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String str1="",str2="";
		
		while(str1.equals("exit")==false)
		{
			str1=br.readLine();
			dos.writeUTF(str1);
			dos.flush();
			str2=dis.readUTF();
			System.out.println("Server says: "+str2);  
		}
		dos.close();
		socket.close();
		soc.close();
	}
}