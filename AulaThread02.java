package curso.Thread;

import javax.swing.JOptionPane;

public class AulaThread02 {

	public static void main(String[] args) throws InterruptedException {
	
		/*Thread processando em paralelo*/
	  Thread threadEmail = 	new Thread(thread1);
	  threadEmail.start();
		
		/*Thread dois  processando em paralelo*/
		Thread threadNota  = new Thread(thread2);
		threadNota.start();
		
		
			
	
			
			/*Fluxo do sistema*/
			JOptionPane.showMessageDialog(null, "sistema continha excutando para o usuario");		
			
	}

	private static Runnable thread1 = new Runnable() {
		
		@Override
		public void run() {
			/*codigo a ser executado em paralelo e segundo plano*/
		   	for(int i=0; i < 10; i++) {
			
			/*EXECUTAR ESSE ENVIO COM TEMPO DE PARADA OU COM TEMPO DETERMINADO*/
				System.out.println("Executando a rotina de envio de e-mails: "+ i);
				try {
					Thread.sleep(1600);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		/*fim do codigo paralelo */	
			
			
		}
	};
	
	private static Runnable thread2 = new Runnable() {
		
		@Override
		public void run() {
			/*codigo a ser executado em paralelo e segundo plano*/
		   	for(int i=0; i < 10; i++) {
			
			/*EXECUTAR ESSE ENVIO COM TEMPO DE PARADA OU COM TEMPO DETERMINADO*/
				System.err.println("ENVIO DE NOTA FISCAL: "+ i);
				try {
					Thread.sleep(1600);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
	};
}


