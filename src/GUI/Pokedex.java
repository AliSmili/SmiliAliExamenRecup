package GUI;

import java.awt.EventQueue;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Models.*;

import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pokedex {

	public JFrame frame;
	private JTextField txtNombre;
	private JTextField txtNumero;
	private JTextField txtNivel;
	private JTextField txtRegion;
	private boolean esCorrecto = true;
	private JButton btnAtras;
	private JButton btnDelante;
	private JLabel lblIndice1;
	private JLabel lblIndice2;


	/**
	 * Create the application.
	 */
	public Pokedex() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 721, 619);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPrincipal = new JLabel("POKEDEX");
		lblPrincipal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPrincipal.setBounds(264, 11, 166, 30);
		frame.getContentPane().add(lblPrincipal);
		
		JLabel lblMatricula = new JLabel("Nombre");
		lblMatricula.setBounds(33, 88, 97, 42);
		frame.getContentPane().add(lblMatricula);
		
		JLabel lblNumero = new JLabel("Número");
		lblNumero.setBounds(33, 171, 97, 42);
		frame.getContentPane().add(lblNumero);
		
		JLabel lblNivelEvolucion = new JLabel("Nivel Evolución");
		lblNivelEvolucion.setBounds(33, 266, 97, 42);
		frame.getContentPane().add(lblNivelEvolucion);
		
		JLabel lblRegion = new JLabel("Región");
		lblRegion.setBounds(33, 341, 97, 42);
		frame.getContentPane().add(lblRegion);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(164, 88, 248, 31);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(164, 171, 248, 31);
		frame.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		txtNivel = new JTextField();
		txtNivel.setBounds(164, 266, 248, 31);
		frame.getContentPane().add(txtNivel);
		txtNivel.setColumns(10);
		
		txtRegion = new JTextField();
		txtRegion.setBounds(164, 341, 248, 31);
		frame.getContentPane().add(txtRegion);
		txtRegion.setColumns(10);
		
		JTextArea txtComentarios = new JTextArea();
		txtComentarios.setBounds(491, 235, 189, 171);
		frame.getContentPane().add(txtComentarios);
		
		JLabel label = new JLabel("Comentarios");
		label.setBounds(496, 195, 97, 42);
		frame.getContentPane().add(label);
		
		JList listTipo = new JList();
		listTipo.setSelectedIndex(0);
		listTipo.setBounds(545, 64, 79, 70);
		frame.getContentPane().add(listTipo);
		
		listTipo.setModel(new AbstractListModel() {
			String[] values = new String[] {"Fuego", "Agua", "Viento","Tierra"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel label_1 = new JLabel("Tipo");
		label_1.setBounds(462, 69, 56, 31);
		frame.getContentPane().add(label_1);
		
		/**
		 * INSERTAR POKEMONS
		 */
		JButton btnInsertar = new JButton("Insertar Nuevo Pokemon");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAtras.setEnabled(false);
				btnDelante.setEnabled(false);
				
				boolean centinela1 = true, centinela2= true, centinela3= true, centinela4= true;
				if(txtNombre.getText() == null || txtNombre.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Hay que introducir un nombre de pokemon ! ");
				centinela1 = false;
				}
				
				
				if( Integer.parseInt(txtNumero.getText()) == 0 || txtNumero.getText()== null || txtNumero.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Hay que introducir un numero de pokemon ! ");
				centinela2 = false;
				}
				
				if(Integer.parseInt(txtNivel.getText())== 0){
				JOptionPane.showMessageDialog(null, "Hay que introducir un nivel de evolucion del pokemon ! ");
				centinela3= false;
				}
				
				if(txtRegion.getText()== null || txtRegion.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Hay que introducir una región! ");
				centinela4= false;
				}
				
				/**
				 * SI TODOS LOS CAMPOS OBLIGATORIOS ESTAN BIEN INSERTADOS,
				 * PODEMOS PROCEDER A AÑIADIR EL POKEMON EN NUESTRA LISTA
				 */
				 
				esCorrecto = centinela1 && centinela2 && centinela3 && centinela4;
				
				if(esCorrecto){
					
					if(!ControlPokem.Buscar(Integer.parseInt(txtNumero.getText()))){
						
					ControlPokem.Aniadir(txtNombre.getText(), Integer.parseInt(txtNumero.getText()), Integer.parseInt(txtNivel.getText()),txtRegion.getText(),(String)listTipo.getSelectedValue(), txtComentarios.getText());
					JOptionPane.showMessageDialog(null, "Se ha insertado el POKEMON con éxito! ");
			
				}else{
					JOptionPane.showMessageDialog(null, "El pokemon que desea insertar ya existe en nuestra lista ! ");
				}
				}

			}
		});
		btnInsertar.setBounds(57, 487, 189, 64);
		frame.getContentPane().add(btnInsertar);
		
		JButton btnBuscar = new JButton("Buscar Pokemon");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/**
				 * BUSCAR POKEMON
				 */
				if(txtNombre.getText() == null || txtNombre.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Hay que introducir el nombre para poder buscar! ");
				}
				if(!ControlPokem.Buscar(Integer.parseInt(txtNumero.getText()))){
					
					//ControlPokem.Aniadir(txtNombre.getText(), Integer.parseInt(txtNumero.getText()), Integer.parseInt(txtNivel.getText()),txtRegion.getText(),(String)listTipo.getSelectedValue(), txtComentarios.getText());
					JOptionPane.showMessageDialog(null, "No se encuentra el pokemon  ! ");
			
				}else{
					
					Pokemon pok ;
					pok = ControlPokem.Obtener(Integer.parseInt(txtNumero.getText()));
					
					txtNivel.setText(""+pok.getNivelEvolucion());
					txtRegion.setText(""+pok.getRegion());
					listTipo.setSelectedValue(listTipo.getSelectedValue(), esCorrecto);
					txtComentarios.setText(""+pok.getComentarios());
					lblIndice1.setText(""+ControlPokem.listaPokemons.indexOf(pok));
					lblIndice2.setText(""+ControlPokem.listaPokemons.size());
					
				}
			}
		});
		btnBuscar.setBounds(275, 487, 189, 64);
		frame.getContentPane().add(btnBuscar);
		
		btnAtras = new JButton("<");
		btnAtras.setBounds(25, 11, 79, 30);
		frame.getContentPane().add(btnAtras);
		
		btnDelante = new JButton(">");
		btnDelante.setBounds(601, 11, 79, 30);
		frame.getContentPane().add(btnDelante);
		
		JLabel lblIterador = new JLabel("/");
		lblIterador.setBounds(510, 11, 22, 25);
		frame.getContentPane().add(lblIterador);
		
		lblIndice1 = new JLabel("");
		lblIndice1.setBounds(453, 11, 22, 25);
		frame.getContentPane().add(lblIndice1);
		
		lblIndice2 = new JLabel("");
		lblIndice2.setBounds(558, 11, 22, 25);
		frame.getContentPane().add(lblIndice2);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(491, 487, 189, 64);
		frame.getContentPane().add(btnSalir);
	}
}
