import java.net.*;
import java.io.*;

public class Client {
	public static void main(String args[])throws Exception
	{
		Socket soc=new Socket("localhost",2535);
		DataInputStream dis=new DataInputStream(soc.getInputStream());
		DataOutputStream dos=new DataOutputStream(soc.getOutputStream());
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
		soc.close();
	}

}