package Demo;

import java.awt.EventQueue;

import GUI.Pokedex;
import Models.*;

public class Main {

	public static void main(String[] args) {
		
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Pokedex window = new Pokedex();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

