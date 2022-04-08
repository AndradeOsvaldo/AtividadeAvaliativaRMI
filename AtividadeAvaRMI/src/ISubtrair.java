import java.rmi.*;
 
public interface ISubtrair extends Remote {
   public float subtrair(
		   float a,
		   float b) throws RemoteException;
}

