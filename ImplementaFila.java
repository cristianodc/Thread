package curso.Thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ImplementaFila extends Thread {

	private static ConcurrentLinkedDeque<ObjetoFilaThread> pilha_filha =
			    new ConcurrentLinkedDeque<ObjetoFilaThread>();
	
	public static void add(ObjetoFilaThread objet) {
		
		pilha_filha.add(objet);
	}
	
	@Override
	public void run() 
	{
		System.err.println("Fila Rodando");
		
		
		while(true)
			{
			Iterator iteracao = pilha_filha.iterator();
			
				synchronized (pilha_filha) 
				{/*SYCHRONIZED BLOQUEIA O ACESSO A LISTA POR OUTROS PROCESSOS*/
					
					while(iteracao.hasNext()) 
					{
						
							ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();
								/*aqui acontece os processos 
								 * gerar envio em massa de email
								 * gerar lista de de PDFs 
								 * 
								 * */
							System.err.println("-------------------------------------");
							System.err.println(processar.getNome());
							System.err.println(processar.getEmail());
								iteracao.remove();
								
									try {
										Thread.sleep(500);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									try {
										Thread.sleep(500);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
						}//FIM WHILE
					
				  }//FIM SYNCHORNIZED
			
				
			}//fim true geralzao
		
		
		
	}//FIM RUN()
	
}
