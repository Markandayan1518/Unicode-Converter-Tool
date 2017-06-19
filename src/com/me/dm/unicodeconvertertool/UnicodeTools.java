package com.me.dm.unicodeconvertertool;

import com.me.dm.unicodeconvertertool.handler.UnescapeUnicodeTransferHandler;
import com.me.dm.unicodeconvertertool.handler.EscapeUnicodeTransferHandler;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class UnicodeTools {

	private JFrame frmUnicodetools;
	
	private File textFile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnicodeTools window = new UnicodeTools();
					window.frmUnicodetools.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UnicodeTools() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUnicodetools = new JFrame();
		frmUnicodetools.setTitle("Unicode Converter Tools");
		frmUnicodetools.getContentPane().setBackground(Color.DARK_GRAY);
		frmUnicodetools.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmUnicodetools.getContentPane().add(tabbedPane);
		
		JPanel panelUnescape = new JPanel();
		tabbedPane.addTab("Unescape", null, panelUnescape, null);
		panelUnescape.setLayout(new BorderLayout(0, 0));
		
		JLabel lbUnescape_DropZone = new JLabel("Drop a escape text fille to here...");
		lbUnescape_DropZone.setHorizontalAlignment(SwingConstants.CENTER);
		lbUnescape_DropZone.setTransferHandler(new UnescapeUnicodeTransferHandler(textFile, lbUnescape_DropZone));
		panelUnescape.add(lbUnescape_DropZone);
		
		JPanel panelEscape = new JPanel();
		tabbedPane.addTab("Escape", null, panelEscape, null);
		panelEscape.setLayout(new BorderLayout(0, 0));
		
		JLabel lbEscape_DropZone = new JLabel("Drop a unescape text fille to here...");
		panelEscape.add(lbEscape_DropZone);
		lbEscape_DropZone.setTransferHandler(new EscapeUnicodeTransferHandler(textFile, lbEscape_DropZone));
		lbEscape_DropZone.setHorizontalAlignment(SwingConstants.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frmUnicodetools.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnMain = new JMenu("Unicode Converter Tools");
		menuBar.add(mnMain);

		frmUnicodetools.setBounds(100, 100, 600, 400);
		frmUnicodetools.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
