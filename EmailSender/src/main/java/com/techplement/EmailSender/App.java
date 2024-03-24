package com.techplement.EmailSender;

import javax.swing.SwingUtilities;
import com.techplement.guis.EmailSenderUI;

public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			EmailSenderUI gui = new EmailSenderUI();
			gui.setVisible(true);
		});
	}

}
