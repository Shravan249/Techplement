package com.techplement.guis;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.techplement.services.EmailSender;

@SuppressWarnings("serial")
public class EmailSenderUI extends JFrame {

	public EmailSenderUI() {
		setTitle("Swing Email Sender Program");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400); // Increased height to accommodate larger text area
		setLocationRelativeTo(null); // Center the window
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		JLabel toLabel = new JLabel("To:");
		JTextField toField = new JTextField(20);
		JLabel subjectLabel = new JLabel("Subject:");
		JTextField subjectField = new JTextField(20);
		JLabel messageLabel = new JLabel("Message:");
		JTextArea messageArea = new JTextArea(15, 20); // Increased rows to 15
		JScrollPane messageScrollPane = new JScrollPane(messageArea);
		JButton sendButton = new JButton("Send");

		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(toLabel, gbc);
		gbc.gridy++;
		panel.add(subjectLabel, gbc);
		gbc.gridy++;
		panel.add(messageLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		panel.add(toField, gbc);
		gbc.gridy++;
		panel.add(subjectField, gbc);
		gbc.gridy++;
		panel.add(messageScrollPane, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 3;
		panel.add(sendButton, gbc);

		add(panel, BorderLayout.CENTER);

		sendButton.addActionListener(e -> {
			EmailSender emailSender = new EmailSender();
			try {
				emailSender.sendMessage(toField.getText(), subjectField.getText(), messageArea.getText());
			} catch (IOException e1) {
				System.err.println("Something went wrong");
				e1.printStackTrace();
			}
		});
	}

}
