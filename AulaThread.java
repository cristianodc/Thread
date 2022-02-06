package curso.Thread;

public class AulaThread {

	public static void main(String[] args) throws InterruptedException {
		
		for(int i=0; i < 10; i++) {
		
		
	 	/*EXECUTAR ESSE ENVIO COM TEMPO DE PARADA OU COM TEMPO DETERMINADO*/
			System.out.println("Executando a rotina de envio de e-mails: "+ i);
			Thread.sleep(1000);
		}
		
		
		System.out.println("CHEGOU AO FIM DA THREAD ");
	}

}
