package test.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import test.Test;
import utils.Request;

public class ChatFrame extends JFrame implements IChatView {

	private static final long serialVersionUID = 983790661010527762L;

	private Test chat;

	private JTextField messageTF;
	private JComboBox friendsCB;
	private JComboBox friendsCB1;

	private JTextArea messagesTA;

	public ChatFrame(Test chatComponent) {
		// super(chatComponent.getIdName());
		System.out.println(" ChatFrame ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chat = chatComponent;

		this.setTitle(chat.getIdName());
		setSize(250, 400);
		getContentPane().setLayout(new BorderLayout(0, 0));

		messagesTA = new JTextArea();
		getContentPane().add(messagesTA, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel friend = new JPanel();
		panel.add(friend, BorderLayout.WEST);
		friendsCB = new JComboBox();
		friend.add(friendsCB, BorderLayout.WEST);

		friendsCB1 = new JComboBox();
		friend.add(friendsCB1, BorderLayout.EAST);

		messageTF = new JTextField();
		panel.add(messageTF, BorderLayout.CENTER);
		messageTF.setColumns(10);

		JButton sendB = new JButton("Recherche");
		sendB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Request req = new Request(chat.getIdName(),
						messageTF.getText(), 5);
				
				//req.addVerified(chat.getIdName());
				String requete = req.serializeJSON();

				chat.outputRecherche(requete);
				messagesTA.append("BROADCAST <- " + messageTF.getText() + "\n");

			}
		});
		panel.add(sendB, BorderLayout.EAST);
		panel.setVisible(true);
		setVisible(true);
		System.out.println(" panel ");
	}

	@Override
	public void addNeighbour(String name) {
		friendsCB.addItem(name);
	}

	@Override
	public void messageArrived(String expeditor, String message) {
		messagesTA.append(expeditor + " -> " + message + "\n");

	}

}
