package dev.vulcanium.core.libs.io.sigpipe.jbsdiff.ui;

import io.sigpipe.jbsdiff.*;
import org.apache.commons.compress.compressors.CompressorException;

import java.io.*;

public class FileUI {
    public FileUI() {
    }

    public static void diff(File oldFile, File newFile, File patchFile) throws CompressorException, FileNotFoundException, InvalidHeaderException, IOException {
        diff(oldFile, newFile, patchFile, "bzip2");
    }

    public static void diff(File oldFile, File newFile, File patchFile, String compression) throws CompressorException, FileNotFoundException, InvalidHeaderException, IOException {
        FileInputStream oldIn = new FileInputStream(oldFile);
        byte[] oldBytes = new byte[(int)oldFile.length()];
        oldIn.read(oldBytes);
        oldIn.close();
        FileInputStream newIn = new FileInputStream(newFile);
        byte[] newBytes = new byte[(int)newFile.length()];
        newIn.read(newBytes);
        newIn.close();
        FileOutputStream out = new FileOutputStream(patchFile);
        DiffSettings settings = new DefaultDiffSettings(compression);
        Diff.diff(oldBytes, newBytes, out, settings);
        out.close();
    }

    public static void patch(File oldFile, File newFile, File patchFile) throws CompressorException, FileNotFoundException, InvalidHeaderException, IOException {
        FileInputStream oldIn = new FileInputStream(oldFile);
        byte[] oldBytes = new byte[(int)oldFile.length()];
        oldIn.read(oldBytes);
        oldIn.close();
        FileInputStream patchIn = new FileInputStream(patchFile);
        byte[] patchBytes = new byte[(int)patchFile.length()];
        patchIn.read(patchBytes);
        patchIn.close();
        FileOutputStream out = new FileOutputStream(newFile);
        Patch.patch(oldBytes, patchBytes, out);
        out.close();
    }
}
