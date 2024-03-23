package shader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.jogamp.opengl.GL4;

public class Shader {
    
    public static int program;
    private static String vertexSource = "";
    private static String fragmentSource = "";
    private static int vertex;
    private static int fragment;

    public static final void loadAndCompileShaders(GL4 gl) {

        // Read lines of glsl shader source files

        try (BufferedReader reader = new BufferedReader(new FileReader("src/shader/vertex.glsl"))) {

            String line = "";

            while ((line = reader.readLine()) != null) {

                vertexSource += line + "\n";

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        try (BufferedReader reader = new BufferedReader(new FileReader("src/shader/fragment.glsl"))) {

            String line = "";

            while ((line = reader.readLine()) != null) {

                fragmentSource += line + "\n";

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        // Compile shaders
        vertex = gl.glCreateShader(GL4.GL_VERTEX_SHADER);
        gl.glShaderSource(vertex, 1, new String[] {vertexSource}, null);
        gl.glCompileShader(vertex);

        fragment = gl.glCreateShader(GL4.GL_FRAGMENT_SHADER);
        gl.glShaderSource(fragment, 1, new String[] {fragmentSource}, null);
        gl.glCompileShader(fragment);

    }



    public static final void createProgram(GL4 gl) {

        // Create program
        program = gl.glCreateProgram();

        // Attach shaders and link program to context
        gl.glAttachShader(program, vertex);
        gl.glAttachShader(program, fragment);
        gl.glLinkProgram(program);

        // Delete shaders as they are now linked to the program
        gl.glDeleteShader(vertex);
        gl.glDeleteShader(fragment);

    }



    public static final void useProgram(GL4 gl) {

        gl.glUseProgram(program);
        
    }



    public static final void setBool(String name, boolean value, GL4 gl) {

        int boolIntValue = value ? 1 : 0;
        gl.glUniform1i(gl.glGetUniformLocation(program, name), boolIntValue);

    }



    public static final void setInt(String name, int value, GL4 gl) {

        gl.glUniform1i(gl.glGetUniformLocation(program, name), value);

    }



    public static final void setFloat(String name, float value, GL4 gl) {

        gl.glUniform1i(gl.glGetUniformLocation(program, name), Math.round(value));

    }

}
