package ManusDei.gui;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ManusDei.helper.Helper;

public class Handler {
    public static void start() throws IOException {
        ProcessBuilder process = new ProcessBuilder("docker", "container", "start", "manusproxy");
        process.start();
    }
    public static void stop() throws IOException {
        ProcessBuilder process = new ProcessBuilder("docker", "container", "stop", "manusproxy");
        process.start();
    }
    public static void report() throws IOException {
        Socket socket = new Socket("127.0.0.1", 80);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        dos.writeBytes("PROXYLOG\r\n\r\n");

        String line = "";
        String ip = JOptionPane.showInputDialog("Enter the IP");
        List<String> filteredIp = new ArrayList<>();
        while((line = reader.readLine()) != null) {
            if(line.contains(ip)){
                filteredIp.add(line);
            }
        }
        String logs = "";
        for(int i = 0; i < filteredIp.size(); i++) {
            logs += filteredIp.get(i) + "\n";
        }
        if (logs.equals(new String())) {logs = "Couldn't found data";}
        JOptionPane.showMessageDialog(null , logs, "Proxy Logs", JOptionPane.INFORMATION_MESSAGE);
        socket.close();
    }
    public static void addHostToFilter() throws IOException{
        String url = JOptionPane.showInputDialog("Please add URL");
        Socket socket = new Socket("127.0.0.1", 80);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeBytes("BAN-URL " + url + "\r\n\r\n");
        socket.close();
        Helper writeFile = new Helper(new File(Paths.get("ManusDei", "gui", "ban.txt").toAbsolutePath().toString()));
        writeFile.appendToFile(new URL(url).getHost());
    }
    public static void displayCurrentFilter(){ 
        Helper readFile = new Helper(new File(Paths.get("ManusDei", "gui", "ban.txt").toAbsolutePath().toString()));
        String urls = readFile.readFromFile();
        JOptionPane.showMessageDialog(null, urls, "Filtered URLs", JOptionPane.INFORMATION_MESSAGE);
    }
}
