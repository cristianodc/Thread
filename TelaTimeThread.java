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

public class TelaTimeThread extends JDialog {

	private JPanel painel = new JPanel(new GridBagLayout());
	private Label descricaoHora = new Label("Time thread 1");
	private Label descricaoHora2 = new Label("Time thread 2");
	private JTextField mostraTempo = new JTextField();
	private JTextField mostraTempo2 = new JTextField();
	private JButton botao1 = new JButton("Start");
	private JButton stop = new JButton("Stop");
	
	private Runnable thread = new Runnable() {
		
		@Override
		public void run() {
			while(true) {
				mostraTempo.setText(new SimpleDateFormat("dd/mm/yyyy hh:mm.ss")
						.format(Calendar.getInstance().getTime()));
			   try {
				Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
			}
			
		}
	};
	
private Runnable thread2 = new Runnable() {
		
		@Override
		public void run() {
			while(true) {
				mostraTempo2.setText(new SimpleDateFormat("dd/mm/yyyy hh:mm.ss")
						.format(Calendar.getInstance().getTime()));
			   try {
				Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
		}
	};
	private Thread treadTime;
	private Thread treadTime2;
	public TelaTimeThread() {
		
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
		mostraTempo.setEditable(false);
		mostraTempo2.setEditable(false);
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
				treadTime = new Thread(thread);
				treadTime.start();
				treadTime2 = new Thread(thread2);
				treadTime2.start();
				
				botao1.setEnabled(false);
				stop.setEnabled(true);
				
			}
		});
		
		stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				treadTime.stop();
				treadTime2.stop();
				
				botao1.setEnabled(true);
				stop.setEnabled(false);
			}
		});
		stop.setEnabled(false);
		setVisible(true);//Sempre sera o ultimo comando
		
		
	}
}
