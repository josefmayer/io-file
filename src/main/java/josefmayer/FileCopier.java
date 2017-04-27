package josefmayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileCopier {

    public  void readDirs() throws Exception{
        File inboxDirectory = new File("data/inbox");
        File outboxDirectory = new File("data/outbox");

        File logDirectory = new File("log");
        File logFile = new File("log/logFile");
        FileOutputStream out = new FileOutputStream(logFile, true);

        outboxDirectory.mkdir();
        logDirectory.mkdir();

        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        sb.append(("*** System Information: *** \n"));
        sb.append("os.arch: " + System.getProperty("os.arch") + "\n");
        sb.append("os.name: " + System.getProperty("os.name") + "\n");
        sb.append("os.version: " + System.getProperty("os.version") + "\n");
        sb.append("java.version: " + System.getProperty("java.version") + "\n\n\n");
        sb.append("*** Files Testing: *** \n");

        sb.append("file size in bytes\n");
        sb.append("read time in ns\n");
        sb.append("write time in ns\n");



        File[] files = inboxDirectory.listFiles();

        for (File source : files) {
            if (source.isFile()) {
                File dest = new File(
                        outboxDirectory.getPath()
                                + File.separator
                                + source.getName());
                copyFile(source, dest, sb);
            }
        }

        sb.append("\n\n");
        System.out.println(sb);
        out.write(sb.toString().getBytes());


    }


    private void copyFile(File source, File dest, StringBuffer sb) throws IOException {
        long startTime, stopTime;

        FileOutputStream out = new FileOutputStream(dest);
        byte[] buffer = new byte[(int) source.length()];
        FileInputStream in = new FileInputStream(source);

        sb.append("\n");
        sb.append("file name: " + source.getName() + "\n");
        sb.append("size: " + source.length() + "\n");

        startTime = System.nanoTime();
        in.read(buffer);
        stopTime = System.nanoTime();
        sb.append("read:  " + (stopTime - startTime) + "\n");

        try {
            startTime = System.nanoTime();
            out.write(buffer);
            stopTime = System.nanoTime();
            sb.append("write: " + (stopTime - startTime) + "\n");

        } finally {
            out.close();
            in.close();
        }
    }


}
