package demo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import hacking.sneks.Snek;
import snake.Snake;

public class Main {
	public static void main(String[] args) {
		Snek snake = new Snake();
		
		JLabel haha = new JLabel(new ImageIcon("snek2.jpg"));
		snake.<String>add("hello");
		snake.<JLabel>add(haha);
		snake.<Integer>add(1);
		snake.<MouseListener>add(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("snek is angry!!");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				haha.setIcon(new ImageIcon("smoking snek.jpg"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				haha.setIcon(new ImageIcon("snek2.jpg"));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		
		MouseListener listener = snake.<MouseListener>get(0);
		Integer integer = snake.<Integer>get(1);
		JLabel label = snake.<JLabel>get(2);
		String string = snake.<String>get(3);
		
		System.out.println(listener);
		System.out.println(integer + 123);
		System.out.println(label);
		System.out.println(string.toUpperCase());
		System.out.println(snake.size());
		
		label.addMouseListener(listener);
		JFrame frame = new JFrame("no name");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(label);
		frame.pack();
	}
}
