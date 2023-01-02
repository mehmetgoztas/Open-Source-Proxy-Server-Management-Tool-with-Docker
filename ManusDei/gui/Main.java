package ManusDei.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import java.awt.*;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Proxy Gui");
        frame.setTitle("Proxy Gui");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(520, 520);

        Bar menuBar = new Bar();
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        
        Menu file = new Menu("File");
        Menu help = new Menu("Help");

        menuBar.add(file);
        menuBar.add(help);

        MenuItem aboutDeveloper = new MenuItem("About Developer");
        help.add(aboutDeveloper);

        
        MenuItem start = new MenuItem("Start");
        MenuItem stop = new MenuItem("Stop");
        MenuItem report = new MenuItem("Report");
        MenuItem addHostToFilter = new MenuItem("Add host to filter");
        MenuItem displayCurrentFilteredHost = new MenuItem("Display current filtered host");
        MenuItem exit = new MenuItem("Exit");

        start.addActionListener(v -> {
            try{
                Handler.start();
            } catch(Exception ex) {ex.printStackTrace();}
        });

        stop.addActionListener(v -> {
            try{
                Handler.stop();
             } catch(Exception ex) { ex.printStackTrace(); }
        });

        report.addActionListener(v -> {
            try{
                Handler.report();
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        addHostToFilter.addActionListener(v -> {
            try{
                Handler.addHostToFilter();
            } catch(Exception ex) {ex.printStackTrace();}
        
        });

        displayCurrentFilteredHost.addActionListener(v -> {
            try{ 
                Handler.displayCurrentFilter();
            } catch(Exception ex) { 
                ex.printStackTrace();
            }
        });
        
        exit.addActionListener(v -> {
			frame.setVisible(false);
            frame.dispose();
		});

        aboutDeveloper.addActionListener(v -> {
            JOptionPane.showMessageDialog(null, "Mehmet Goztas 20180702061", "About Developer", JOptionPane.INFORMATION_MESSAGE);
        });


        file.add(start);
        file.add(stop);
        file.add(report);
        file.add(addHostToFilter);
        file.add(displayCurrentFilteredHost);
        file.add(exit);

        frame.setVisible(true); 
    }
}
