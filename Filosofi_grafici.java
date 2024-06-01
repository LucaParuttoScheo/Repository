package luca;

import java.awt.EventQueue;
import java.io.File;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Filosofi_grafici extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	static Semaphore[] turno = new Semaphore[] {new Semaphore(0), new Semaphore(0), new Semaphore(0), new Semaphore(0), new Semaphore(0)};
	static int[] stato = new int[]{2,2,2,2,2};
	static Semaphore mutex = new Semaphore(1);
	
	static int AFFAMATO = 0;
	static int MANGIA = 1;
	static int PENSA = 2;
	
	static boolean cond1 = false;
	static boolean cond2 = false;
	static boolean cond3 = false;
	static boolean cond4 = false;
	static boolean cond5 = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filosofi_grafici frame = new Filosofi_grafici();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
Thread f1 = new Thread(() -> {
			
			int i = 0;
			int sx = (i+1)%5;  
			int dx = (i+4)%5;
			
			while(true){ 
				
				try {
					Thread.sleep(new Random().nextInt(1000)+1000);
				} catch (InterruptedException e) {}
				
			    try {
					mutex.acquire();
				} catch (InterruptedException e) {}
			    
			    stato[i] = AFFAMATO;
			    
			    if((stato[dx] != MANGIA) && (stato[sx] != MANGIA)) {
				      stato[i] = MANGIA;
				      turno[i].release();
				    }
			    
			    mutex.release();    
			    
			    try {
					turno[i].acquire();
				} catch (InterruptedException e) {}
			    
			    System.out.println(Thread.currentThread().getName() + " sta mangiando...");
				
				try {
					Thread.sleep(new Random().nextInt(1000)+1000);
				} catch (InterruptedException e) {}
			   
			    try {
					mutex.acquire();
				} catch (InterruptedException e) {}
			    
			    stato[i] = PENSA;
			    if((stato[sx] == AFFAMATO) && (stato[(sx+1)%5] != MANGIA))
			    {
			      stato[sx] = MANGIA;      
			      turno[sx].release(1); // sveglia il vicino a sinistra
			     
			      
			      
			    }
			    if((stato[dx] == AFFAMATO) && (stato[(dx+5)%5] != MANGIA)) 
			    {
			      stato[dx] = MANGIA;      
			      turno[dx].release(1); // sveglia il vicino a destra 
			      
			      
			    } 
			    mutex.release();
			   
			    System.out.println(Thread.currentThread().getName() + " sta pensando...");
				
				try {
					Thread.sleep(new Random().nextInt(1000)+1000);
				} catch (InterruptedException e) {}
			}
			
		});
		
		Thread f2 = new Thread(() -> {
			
			int i = 1;
			int sx = (i+1)%5;  
			int dx = (i+4)%5;
			
			while(true){ 
				
				try {
					Thread.sleep(new Random().nextInt(1000)+1000);
				} catch (InterruptedException e) {}
				
			    try {
					mutex.acquire();
				} catch (InterruptedException e) {}
			    
			    stato[i] = AFFAMATO;
			    
			    if((stato[dx] != MANGIA) && (stato[sx] != MANGIA)) {
				      stato[i] = MANGIA;
				      turno[i].release();
				    }
			    
			    mutex.release();    
			    
			    try {
					turno[i].acquire();
				} catch (InterruptedException e) {}
			    
			    System.out.println(Thread.currentThread().getName() + " sta mangiando...");
				
				try {
					Thread.sleep(new Random().nextInt(1000)+1000);
				} catch (InterruptedException e) {}
			   
			    try {
					mutex.acquire();
				} catch (InterruptedException e) {}
			    
			    stato[i] = PENSA;
			    if((stato[sx] == AFFAMATO) && (stato[(sx+1)%5] != MANGIA))
			    {
			      stato[sx] = MANGIA;      
			      turno[sx].release(1); // sveglia il vicino a sinistra
			      
			      
			      
			    }
			    if((stato[dx] == AFFAMATO) && (stato[(dx+5)%5] != MANGIA)) 
			    {
			      stato[dx] = MANGIA;      
			      turno[dx].release(1); // sveglia il vicino a destra 
			      
			      
			    } 
			    mutex.release();
			   
			    System.out.println(Thread.currentThread().getName() + " sta pensando...");
				
				try {
					Thread.sleep(new Random().nextInt(1000)+1000);
				} catch (InterruptedException e) {}
			}
			
		});
		
		Thread f3 = new Thread(() -> {
			
			int i = 2;
			int sx = (i+1)%5;  
			int dx = (i+4)%5;
			
			while(true){ 
				
				try {
					Thread.sleep(new Random().nextInt(1000)+1000);
				} catch (InterruptedException e) {}
				
			    try {
					mutex.acquire();
				} catch (InterruptedException e) {}
			    
			    stato[i] = AFFAMATO;
			    
			    if((stato[dx] != MANGIA) && (stato[sx] != MANGIA)) {
				      stato[i] = MANGIA;
				      turno[i].release();
				    }
			    
			    mutex.release();    
			    
			    try {
					turno[i].acquire();
				} catch (InterruptedException e) {}
			    
			    System.out.println(Thread.currentThread().getName() + " sta mangiando...");
				
				try {
					Thread.sleep(new Random().nextInt(1000)+1000);
				} catch (InterruptedException e) {}
			   
			    try {
					mutex.acquire();
				} catch (InterruptedException e) {}
			    
			    stato[i] = PENSA;
			    if((stato[sx] == AFFAMATO) && (stato[(sx+1)%5] != MANGIA))
			    {
			      stato[sx] = MANGIA;      
			      turno[sx].release(1); // sveglia il vicino a sinistra
			      
			      
			      
			    }
			    if((stato[dx] == AFFAMATO) && (stato[(dx+5)%5] != MANGIA)) 
			    {
			      stato[dx] = MANGIA;      
			      turno[dx].release(1); // sveglia il vicino a destra 
			      
			      
			    } 
			    mutex.release();
			   
			    System.out.println(Thread.currentThread().getName() + " sta pensando...");
				
				try {
					Thread.sleep(new Random().nextInt(1000)+1000);
				} catch (InterruptedException e) {}
			}
			
		});
		
		Thread f4 = new Thread(() -> {
			
			int i = 3;
			int sx = (i+1)%5;  
			int dx = (i+4)%5;
			
			while(true){ 
				
				try {
					Thread.sleep(new Random().nextInt(1000)+1000);
				} catch (InterruptedException e) {}
				
			    try {
					mutex.acquire();
				} catch (InterruptedException e) {}
			    
			    stato[i] = AFFAMATO;
			    
			    if((stato[dx] != MANGIA) && (stato[sx] != MANGIA)) {
				      stato[i] = MANGIA;
				      turno[i].release();
				    }
			    
			    mutex.release();    
			    
			    try {
					turno[i].acquire();
				} catch (InterruptedException e) {}
			    
			    System.out.println(Thread.currentThread().getName() + " sta mangiando...");
				
				try {
					Thread.sleep(new Random().nextInt(1000)+1000);
				} catch (InterruptedException e) {}
			   
			    try {
					mutex.acquire();
				} catch (InterruptedException e) {}
			    
			    stato[i] = PENSA;
			    if((stato[sx] == AFFAMATO) && (stato[(sx+1)%5] != MANGIA))
			    {
			      stato[sx] = MANGIA;      
			      turno[sx].release(1); // sveglia il vicino a sinistra
			      
			      
			      
			    }
			    if((stato[dx] == AFFAMATO) && (stato[(dx+5)%5] != MANGIA)) 
			    {
			      stato[dx] = MANGIA;      
			      turno[dx].release(1); // sveglia il vicino a destra 
			    
			      
			    } 
			    mutex.release();
			   
			    System.out.println(Thread.currentThread().getName() + " sta pensando...");
				
				try {
					Thread.sleep(new Random().nextInt(1000)+1000);
				} catch (InterruptedException e) {}
			}
			
		});
		
		

Thread f5 = new Thread(() -> {
	
	int i = 4;
	int sx = (i+1)%5;  
	int dx = (i+4)%5;
	
	while(true){ 
		
		try {
			Thread.sleep(new Random().nextInt(1000)+1000);
		} catch (InterruptedException e) {}
		
	    try {
			mutex.acquire();
		} catch (InterruptedException e) {}
	    
	    stato[i] = AFFAMATO;
	    
	    if((stato[dx] != MANGIA) && (stato[sx] != MANGIA)) {
		      stato[i] = MANGIA;
		      turno[i].release();
		    }
	    
	    mutex.release();    
	    
	    try {
			turno[i].acquire();
		} catch (InterruptedException e) {}
	    
	    System.out.println(Thread.currentThread().getName() + " sta mangiando...");
		
		try {
			Thread.sleep(new Random().nextInt(1000)+1000);
		} catch (InterruptedException e) {}
	   
	    try {
			mutex.acquire();
		} catch (InterruptedException e) {}
	    
	    stato[i] = PENSA;
	    if((stato[sx] == AFFAMATO) && (stato[(sx+1)%5] != MANGIA))
	    {
	      stato[sx] = MANGIA;      
	      turno[sx].release(1); // sveglia il vicino a sinistra
	   
	      
	    }
	    if((stato[dx] == AFFAMATO) && (stato[(dx+5)%5] != MANGIA)) 
	    {
	      stato[dx] = MANGIA;      
	      turno[dx].release(1); // sveglia il vicino a destra 
	      
	    } 
	    mutex.release();
	   
	    System.out.println(Thread.currentThread().getName() + " sta pensando...");
		
		try {
			Thread.sleep(new Random().nextInt(1000)+1000);
		} catch (InterruptedException e) {}
	}
	
});

f1.start();
f2.start();
f3.start();
f4.start();
f5.start();


	}

	/**
	 * Create the frame.
	 */
	public Filosofi_grafici() {
		setTitle("Filosofi a cena Parutto Luca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		java.net.URL ib1 = this.getClass().getResource("/b1.png");
		
		JLabel b1 = new JLabel("");
		b1.setIcon(new ImageIcon(ib1));
		b1.setBounds(233, 164, 94, 139);
		contentPane.add(b1);
		
		java.net.URL ib2 = this.getClass().getResource("/b2.png");
		
		JLabel b2 = new JLabel("");
		b2.setIcon(new ImageIcon(ib2));
		b2.setBounds(160, 332, 125, 121);
		contentPane.add(b2);
		
		java.net.URL ib3 = this.getClass().getResource("/b3.png");
		
		JLabel b3 = new JLabel("");
		b3.setIcon(new ImageIcon(ib3));
		b3.setBounds(362, 402, 46, 220);
		contentPane.add(b3);
		
		java.net.URL ib4 = this.getClass().getResource("/b4.png");
		
		JLabel b4 = new JLabel("");
		b4.setIcon(new ImageIcon(ib4));
		b4.setBounds(452, 354, 119, 99);
		contentPane.add(b4);
		
		java.net.URL ib5 = this.getClass().getResource("/b5.png");
		
		JLabel b5 = new JLabel("");
		b5.setIcon(new ImageIcon(ib5));
		b5.setBounds(424, 154, 82, 149);
		contentPane.add(b5);
		
		java.net.URL ib52 = this.getClass().getResource("/b5_1.png");
		
		JLabel b5_2 = new JLabel("");
		b5_2.setIcon(new ImageIcon(ib52));
		b5_2.setBounds(233, 66, 166, 106);
		contentPane.add(b5_2);
		
		java.net.URL ib42 = this.getClass().getResource("/b4_1.png");
		
		JLabel b4_2 = new JLabel("");
		b4_2.setIcon(new ImageIcon(ib42));
		b4_2.setBounds(545, 100, 46, 185);
		contentPane.add(b4_2);
		
		java.net.URL ib32 = this.getClass().getResource("/b3_1.png");
		
		JLabel b3_2 = new JLabel("");
		b3_2.setIcon(new ImageIcon(ib32));
		b3_2.setBounds(538, 385, 134, 185);
		contentPane.add(b3_2);
		
		java.net.URL ib22 = this.getClass().getResource("/b2_1.png");
		
		JLabel b2_2 = new JLabel("");
		b2_2.setIcon(new ImageIcon(ib22));
		b2_2.setBounds(264, 495, 166, 185);
		contentPane.add(b2_2);
		
		java.net.URL hesse = this.getClass().getResource("/hesse1.png");
		
		JLabel lblNewLabel_1_1_2 = new JLabel("");
		lblNewLabel_1_1_2.setIcon(new ImageIcon(hesse));
		lblNewLabel_1_1_2.setBounds(528, 154, 210, 220);
		contentPane.add(lblNewLabel_1_1_2);
		
		java.net.URL ib12 = this.getClass().getResource("/b1_1.png");
		
		JLabel b1_2 = new JLabel("");
		b1_2.setIcon(new ImageIcon(ib12));
		b1_2.setBounds(65, 279, 103, 191);
		contentPane.add(b1_2);
		
		java.net.URL ni = this.getClass().getResource("/nietsche1.png");
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(ni));
		lblNewLabel_1_1_1_1.setBounds(393, 365, 210, 296);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		java.net.URL ka = this.getClass().getResource("/kafka1.png");
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(ka));
		lblNewLabel_1_1_1.setBounds(126, 418, 210, 220);
		contentPane.add(lblNewLabel_1_1_1);
		
		java.net.URL de = this.getClass().getResource("/deleuze1.png");
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(de));
		lblNewLabel_1_1.setBounds(55, 112, 210, 220);
		contentPane.add(lblNewLabel_1_1);
		
		java.net.URL TD = this.getClass().getResource("/TDDDD.png");
		
		java.net.URL terr = this.getClass().getResource("/terrina.png");
		JLabel ciotolona = new JLabel("New label");
		ciotolona.setIcon(new ImageIcon(terr));
		ciotolona.setBounds(308, 292, 134, 115);
		contentPane.add(ciotolona);
		
		java.net.URL cio = this.getClass().getResource("/ciotolina2.png");
		
		JLabel ciotola_1 = new JLabel("");
		ciotola_1.setIcon(new ImageIcon(cio));
		ciotola_1.setBounds(448, 252, 87, 80);
		contentPane.add(ciotola_1);
		JLabel ciotola = new JLabel("");
		ciotola.setIcon(new ImageIcon(cio));
		ciotola.setBounds(326, 119, 87, 80);
		contentPane.add(ciotola);
		
		JLabel ciotola_1_1_1_1 = new JLabel("");
		ciotola_1_1_1_1.setIcon(new ImageIcon(cio));
		ciotola_1_1_1_1.setBounds(153, 294, 87, 80);
		contentPane.add(ciotola_1_1_1_1);
		
		JLabel ciotola_1_1 = new JLabel("");
		ciotola_1_1.setIcon(new ImageIcon(cio));
		ciotola_1_1.setBounds(472, 418, 87, 80);
		contentPane.add(ciotola_1_1);
		
		//ciao prova di commento
		// prove del secondo
		// commentttiiiiiii
		
		JLabel ciotola_1_1_1 = new JLabel("");
		ciotola_1_1_1.setIcon(new ImageIcon(cio));
		ciotola_1_1_1.setBounds(240, 462, 87, 80);
		contentPane.add(ciotola_1_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TD));
		lblNewLabel.setBounds(116, 85, 516, 537);
		contentPane.add(lblNewLabel);
		
		java.net.URL ca = this.getClass().getResource("/camus.png");
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ca));
		lblNewLabel_1.setBounds(264, 0, 210, 159);
		contentPane.add(lblNewLabel_1);
	
		
		
		b1_2.setVisible(false);
		b2_2.setVisible(false);
		b3_2.setVisible(false);
		b4_2.setVisible(false);
		b5_2.setVisible(false);
		
		b1.setVisible(true);
		b2.setVisible(true);
		b3.setVisible(true);
		b4.setVisible(true);
		b5.setVisible(true);
		
		
		
		Thread aggiorno1 = new Thread(() -> {
			
			while(true) {
			
			try {
				mutex.acquire();
			} catch (InterruptedException e) {}
			
			if(stato[0] == 1 && !cond5 && !cond2) {
				cond1 = true;
			
				b1_2.setVisible(true);
				b1.setVisible(false);
				b2.setVisible(false);
			}else if(stato[0] == 2 && cond1){
				cond1 = false;
				
				b1_2.setVisible(false);
				b1.setVisible(true);
				b2.setVisible(true);
			}
			mutex.release();
			
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		});
		
Thread aggiorno2 = new Thread(() -> {
			
			while(true) {
			
			try {
				mutex.acquire();
			} catch (InterruptedException e) {}
			
			if(stato[1] == 1 && !cond1 && !cond3) {
				cond2 = true;
				
				b2_2.setVisible(true);
				b2.setVisible(false);
				b3.setVisible(false);
			}else if(stato[0] == 2 && cond2){
				cond2 = false;
			
				b2_2.setVisible(false);
				b2.setVisible(true);
				b3.setVisible(true);
			}
			mutex.release();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			
		});

Thread aggiorno3 = new Thread(() -> {
	
	while(true) {
	
	try {
		mutex.acquire();
	} catch (InterruptedException e) {}
	
	if(stato[2] == 1 && !cond2 && !cond4) {
		cond3 = true;
		
		b3_2.setVisible(true);
		b3.setVisible(false);
		b4.setVisible(false);
	}else if(stato[2] == 2 && cond3){
		cond3 = false;
		
		b3_2.setVisible(false);
		b3.setVisible(true);
		b4.setVisible(true);
	}
	mutex.release();
	
	try {
		Thread.sleep(30);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
});

Thread aggiorno4 = new Thread(() -> {
	
	while(true) {
	
	try {
		mutex.acquire();
	} catch (InterruptedException e) {}
	
	if(stato[3] == 1 && !cond3 && !cond5) {
		cond4 = true;
		
		b4_2.setVisible(true);
		b4.setVisible(false);
		b5.setVisible(false);
	}else if(stato[3] == 2 && cond4){
		cond4 = false;
		
		b4_2.setVisible(false);
		b4.setVisible(true);
		b5.setVisible(true);
	}
	mutex.release();
	
	try {
		Thread.sleep(30);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
});

Thread aggiorno5 = new Thread(() -> {
	
	while(true) {
	
	try {
		mutex.acquire();
	} catch (InterruptedException e) {}
	
	if(stato[4] == 1 && !cond4 && !cond1) {
		cond5 = true;
		
		b5_2.setVisible(true);
		b5.setVisible(false);
		b1.setVisible(false);
	}else if(stato[4] == 2 && cond5){
		cond5 = false;
		
		b5_2.setVisible(false);
		b5.setVisible(true);
		b1.setVisible(true);
	}
	mutex.release();
	
	try {
		Thread.sleep(30);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
});
		
		aggiorno1.start();
		aggiorno2.start();
		aggiorno3.start();
		aggiorno4.start();
		aggiorno5.start();
		
	}
}
