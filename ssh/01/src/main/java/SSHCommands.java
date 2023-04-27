import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SSHCommands {
    public static void main(String[] args) {
        String hostname = "192.168.2.43";
        String username = "ivan";
        String password = "XXXXXX";
        int port = 22;

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(username, hostname, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            String[] commands = {
                    "pwd",
                    "ls",
                    "gcc -v"
            };

            for (String command : commands) {
                System.out.println("\nExecuting '" + command + "' command:");
                executeSSHCommand(session, command);
            }

            session.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void executeSSHCommand(Session session, String command) throws Exception {
        ChannelExec channel = (ChannelExec) session.openChannel("exec");
        channel.setCommand(command);

        InputStream inputStream = channel.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        channel.connect();

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        channel.disconnect();
    }
}
