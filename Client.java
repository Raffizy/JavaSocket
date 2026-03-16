// basic client socket test
import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Client{
    
    public static void main(String[] args) { 
    
  
        try {
            Socket socket = new Socket("172.20.13.68",12345);
            System.out.println("Connected to Server");
            //sending output
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            //sending custom messages
            System.out.println("Enter your name:\n");
            Scanner myName = new Scanner(System.in);
            String UID= myName.nextLine();
            System.out.println("Welcome: " + UID + "\nEnter your message:\n");
            Scanner myObj = new Scanner(System.in);
            String myMessage= myObj.nextLine();

            out.writeObject(new Message( UID , myMessage ));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }

            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            
        }
    }
}
