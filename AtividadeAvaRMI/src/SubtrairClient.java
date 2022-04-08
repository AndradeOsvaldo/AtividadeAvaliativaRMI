
import java.rmi.registry.*;
import java.util.Scanner;

public class SubtrairClient {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		float a;
		float b;
		float subtracao;
		try {
			// Procura o registro do RMI no Servidor
			// Se o servidor estiver em outro host basta substituir pelo seu IP
			Registry registry = LocateRegistry.getRegistry("localhost");

			// Procura a stub do servidor
			ISubtrair stub = (ISubtrair) registry.lookup("Servidor");

			// Chama o m�todo do servidor e imprime a mensagem
			System.out.println("Invocando metodo do servidor");
			
			System.out.println("Digite o primeiro n�mero, o valor de A:");
			a = read.nextFloat();
			
			System.out.println("Digite o segundo n�mero, o valor de B:");
			b = read.nextFloat();
			subtracao = stub.subtrair(a, b);
			
			
			System.out.println("O valor da subta��o �: " + subtracao); 
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}

		
	}


