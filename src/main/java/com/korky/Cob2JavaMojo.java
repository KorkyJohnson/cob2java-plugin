package com.korky;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
 
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

    public void execute() throws MojoExecutionException
    {
        getLog().info( greeting );
    }
}
