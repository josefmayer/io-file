package josefmayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileCopier {

    public static void main(String args[]) throws Exception {
        File inboxDirectory = new File("data/inbox");
        File outboxDirectory = new File("data/outbox");

        outboxDirectory.mkdir();

        File[] files = inboxDirectory.listFiles();

        for (File source : files) {
            if (source.isFile()) {
                File dest = new File(
                        outboxDirectory.getPath()
                                + File.separator
                                + source.getName());
                copyFile(source, dest);
            }
        }
    }


    private static void copyFile(File source, File dest) throws IOException {
        long startTime, stopTime;

        FileOutputStream out = new FileOutputStream(dest);
        byte[] buffer = new byte[(int) source.length()];
        FileInputStream in = new FileInputStream(source);

        System.out.println();
        System.out.println("file name: " + source.getName());
        System.out.println("file size in bytes: " + source.length());
        startTime = System.nanoTime();
        in.read(buffer);
        stopTime = System.nanoTime();
        System.out.println("read  time in ns: " + (stopTime - startTime));

        try {
            startTime = System.nanoTime();
            out.write(buffer);
            stopTime = System.nanoTime();
            System.out.println("write time in ns: " + (stopTime - startTime));

        } finally {
            out.close();
            in.close();
        }
    }

}
