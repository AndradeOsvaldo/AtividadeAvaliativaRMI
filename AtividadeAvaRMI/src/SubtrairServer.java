import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;
import java.rmi.registry.*;

public class SubtrairServer implements ISubtrair {
	public SubtrairServer() {}  // Construtor

	public static void main(String[] args) {
		try {
			SubtrairServer server = new SubtrairServer();
			//Exporta o server para o stub ("apendice ou toco") do RMI na porta 0
			ISubtrair stub = (ISubtrair) UnicastRemoteObject.exportObject(server, 0);
			
			Registry registry = LocateRegistry.getRegistry();
			// Registra a stub no RMI para que ela seja obtida pelos clientes
			registry.bind("Servidor", stub);
			
			System.out.println("Servidor inicializado com sucesso.");
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}

	public float subtrair(
			float a,
			float b) throws RemoteException {
		System.out.println("Executando metodo neste host, subtração de dois números!!");
		
		float subtracao = a - b;
		
		return subtracao;
	}
}
