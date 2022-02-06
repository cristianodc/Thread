package curso.Thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread02 extends JDialog{


	private JPanel painel = new JPanel(new GridBagLayout());
	private Label descricaoHora = new Label("Nome");
	private Label descricaoHora2 = new Label("Email");
	private JTextField mostraTempo = new JTextField();
	private JTextField mostraTempo2 = new JTextField();
	private JButton botao1 = new JButton("Add Lista");
	private JButton stop = new JButton("Stop");
	private ImplementaFila fila = new ImplementaFila();
	
	

	private Thread treadTime;
	private Thread treadTime2;
	public TelaTimeThread02() {
		
		setTitle("Testando Thread");
		setSize(new Dimension(300, 300));
		setLocationRelativeTo(null);
		setResizable(false);
		
		GridBagConstraints gridBag = new GridBagConstraints();
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		gridBag.gridwidth = 2;
		gridBag.insets = new Insets(5, 10, 5, 5);
		gridBag.anchor = GridBagConstraints.WEST;
		descricaoHora.setPreferredSize(new Dimension(195, 25));
		descricaoHora2.setPreferredSize(new Dimension(195, 25));
		mostraTempo.setPreferredSize(new Dimension(200, 25));
		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		botao1.setPreferredSize(new Dimension(92, 25));
		stop.setPreferredSize(new Dimension(92, 25));
		
		painel.add(descricaoHora, gridBag);
		gridBag.gridy ++;
		painel.add(mostraTempo, gridBag);
		gridBag.gridy ++;
		painel.add(descricaoHora2, gridBag);
		gridBag.gridy ++;
		painel.add(mostraTempo2, gridBag);
		gridBag.gridwidth = 1;
		gridBag.gridy ++;
		painel.add(botao1,gridBag);
		gridBag.gridx ++;
		painel.add(stop,gridBag);
		add(painel,BorderLayout.WEST);
		
		botao1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fila == null) {
					fila = new ImplementaFila();
					fila.start();
				}
				for(int i=0; i <20; i++) {
					
					ObjetoFilaThread obj =new ObjetoFilaThread();
					obj.setNome(mostraTempo.getText());
					obj.setEmail(mostraTempo2.getText()+" - " + i);
					fila.add(obj);
					
				}
				
				
			}
		});
		
		stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fila.stop();
				fila= null;
			}
		});
	
		fila.start();
		setVisible(true);//Sempre sera o ultimo comando
		
		
	}
}
