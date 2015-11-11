package org.qe.hawkular.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import com.trilead.ssh2.Connection;
import com.trilead.ssh2.Session;
import com.trilead.ssh2.StreamGobbler;

/**
 * SSH client - SSHClient("user", "host", "password")
 * @author vprusa
 */
public class SSHClient {

    protected Connection connection = null;
    protected Session session = null;
    private final String user;
    private final String host;
    private final String pass;
    protected static final Logger log = Logger.getLogger(SSHClient.class.getName());

    public SSHClient(String user, String host, String pass) {
        log.fine("Creating SSHClient that will connect to [" + user + "@" + host + "]");
        this.user = user;
        this.host = host;
        this.pass = pass;
    }

    public static SSHClient fromProperties() {
        String user, host, pass;
        user = System.getProperty("notifSshUsername");
        host = System.getProperty("notifSshHost");
        pass = System.getProperty("notifSshPassword");
        return new SSHClient(user, host, pass);
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    private String lastOutput = null;

    public String getLastOutput() {
        return lastOutput;
    }

    public Integer execCommnad(String cmd) {
        // TODO there is probably better solution without reconnection via session (problem with unfinished cmd when executing another cmd)
        connect();
        log.info("Executiong command via SSH: " + cmd);
        try {
            session.execCommand(cmd);
            InputStream stdout = new StreamGobbler(session.getStdout());
            @SuppressWarnings("resource")
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
            String out = "";
            while (true) {
                String line = br.readLine();
                if (line == null)
                    break;
                out += line + "\n";
            }
            lastOutput = out;
            Integer r = session.getExitStatus();
            log.info(out);
            log.info("ExitCode: " + r);
            close();
            return r;
        } catch (IOException e) {
            e.printStackTrace();
        }
        close();
        return null;
    }

    public void close() {
        session.close();
        connection.close();
    }

    public void connect() {
        try {
            log.info("Connecctiong to " + user + "@" + host);
            connection = new Connection(host);
            connection.connect();
            boolean isAuthenticated = connection.authenticateWithPassword(user, pass);
            if (isAuthenticated == false)
                throw new IOException("Authentication failed.");
            session = connection.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getFile(String remoteFile, String localTargetDirectory) {
        try {
            log.info("Loading file " + remoteFile + " to " + localTargetDirectory);
            connection.createSCPClient().get(remoteFile, localTargetDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}