package dev.vulcanium.core.libs.io.sigpipe.jbsdiff.ui;

import java.io.File;

public class CLI {
    public CLI() {
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 4) {
            System.out.println("Not enough parameters!");
            printUsage();
        }

        String compression = System.getProperty("jbsdiff.compressor", "bzip2");
        compression = compression.toLowerCase();

        try {
            String command = args[0].toLowerCase();
            File oldFile = new File(args[1]);
            File newFile = new File(args[2]);
            File patchFile = new File(args[3]);
            if (command.equals("diff")) {
                FileUI.diff(oldFile, newFile, patchFile, compression);
            } else if (command.equals("patch")) {
                FileUI.patch(oldFile, newFile, patchFile);
            } else {
                printUsage();
            }
        } catch (Exception var6) {
            var6.printStackTrace();
            System.exit(1);
        }

    }

    public static void printUsage() {
        String usage = String.format("Usage: command <oldfile> <newfile> <patchfile>%n%nCommands:%n    diff%n    patch%n%nUse the jbsdiff.compressor property to select a different compression scheme:%n    java -Djbsdiff.compressor=gz -jar jbsdiff-*.jar diff a.bin b.bin patch.gz%n%nSupported compression schemes: bzip2 (default), gz, pack200, xz.%n%nThe compression algorithm used will be detected automatically during %npatch operations.  NOTE: algorithms other than bzip2 are incompatible %nwith the reference implementation of bsdiff!");
        System.out.println(usage);
        System.exit(1);
    }
}
