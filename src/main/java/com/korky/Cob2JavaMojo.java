package com.korky;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 * Says "Hi" to the user.
 *
 */
@Mojo(name = "c2j")

public class Cob2JavaMojo extends AbstractMojo {
   /**
    * The greeting to display.
    */
   @Parameter(property = "c2j.greeting", defaultValue = "Hello C2J!")
   private String greeting;
   /**
    * The folder where all the .cbl files are located.
    */
   @Parameter(property = "c2j.cblFolder")
   private String cblFolder;
   /**
    * The folder where all the .cbl files are located.
    */
   @Parameter(property = "c2j.javaFolder")
   private String javaFolder;

   public void execute() throws MojoExecutionException {
      getLog().info(greeting);
      // try {
      // CopyFile(infile,outfile);
      // } catch (IOException e) {
      // getLog().error("CopyFile() failed");
      // e.printStackTrace();
      // }
      try {
         // SweepFolder(cblFolder);
         renameFile(cblFolder, javaFolder);
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   // try {
   // in = new
   // FileInputStream("C:\\proj\\cob2java\\src\\main\\resources\\.cbl\\input.cbl");
   // out = new
   // FileOutputStream("C:\\proj\\cob2java\\src\\main\\resources\\.java\\input.java");

   // int c;
   // while ((c = in.read()) != -1) {
   // out.write(c);
   // }
   // }finally {
   // if (in != null) {
   // in.close();
   // }
   // if (out != null) {
   // out.close();
   // }
   // }
   // }

   // public static void main(String args) throws Exception {
   // public void SweepFolder(String cblFolder) throws IOException {
   // Path dir = Paths.get(cblFolder);
   // Files.walk(dir).forEach(path -> {
   // try {
   // renameFile(path.toFile(), javaFolder);
   // } catch (IOException e) {
   // // TODO Auto-generated catch block
   // e.printStackTrace();
   // }
   // });
   // }

   public static void renameFile(String cblFolder, String javaFolder) throws IOException {
      File orig = new File(FilenameUtils.concat(cblFolder, "demo.txt"));
      File dest = new File(FilenameUtils.concat(javaFolder, "demo_success.java"));
      FileUtils.copyFile(orig, dest, true); // true to replace file
   }

   // public static void renameFile(File file, String javaFolder) throws
   // IOException {
   // if (file.isDirectory()) {
   // } else {
   // File orig = new
   // File("C:\\proj\\cob2java\\src\\main\\resources\\cbl\\demo.txt");
   // File dest = new
   // File("C:\\proj\\cob2java\\src\\main\\resources\\java\\demo_success.txt");
   // // FileUtils.moveFile(FileUtils.getFile(file), FileUtils.getFile(dest));
   // FileUtils.moveFile(orig, dest);
   // }
   // }
}