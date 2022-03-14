package com.korky;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

// import org.apache.commons.io.*;
 
/**
 * Says "Hi" to the user.
 *
 */
@Mojo( name = "c2j")

public class Cob2JavaMojo extends AbstractMojo
{
    /**
     * The greeting to display.
     */
    @Parameter( property = "c2j.greeting", defaultValue = "Hello C2J!" )
    private String greeting;

    public String infile = "input.txt";
    public String outfile = "output.txt";

    public void execute() throws MojoExecutionException
    {
        getLog().info( greeting );
        try {
            CopyFile(infile,outfile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            getLog().error("CopyFile() failed");
            e.printStackTrace();
        }
    }

    public void CopyFile (String infile, String outfile) throws IOException {  
        FileInputStream in = null;
        FileOutputStream out = null;
  
        try {
           in = new FileInputStream("C:\\proj\\cob2java\\src\\main\\resources\\.cbl\\input.cbl");
           out = new FileOutputStream("C:\\proj\\cob2java\\src\\main\\resources\\.java\\input.java");
           
           int c;
           while ((c = in.read()) != -1) {
              out.write(c);
           }
        }finally {
           if (in != null) {
              in.close();
           }
           if (out != null) {
              out.close();
           }
        }
     }
}