import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable{
    private Socket socket;
    //importing hashmap
    private HashMap<String, ClientHandler> clients;
    public ClientHandler(Socket socket, HashMap<String, ClientHandler> clients){
    this.socket = socket;
    this.clients = clients;
    }
    @Override
    public void run(){
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            //firstMessage records teh users Unique id only once, so whnever the code runs the uid wont get cloned
            Message firstMessage = (Message) in.readObject();
            clients.put(firstMessage.UID, this);
            System.out.println(clients);
            //implementing loop
            boolean a=true;
            while (a){
                Message message = (Message)in.readObject();
                System.out.println(message);
                
                        
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error" + e.getMessage());
        }
        
    }
}
