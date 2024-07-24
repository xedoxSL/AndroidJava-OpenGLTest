package test.openg.square_test;

import android.opengl.GLES32;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import test.openg.config.GLShader;
import test.openg.R;

public class GLRect {

    private FloatBuffer floatBuffer;

    // Программа соединения шейдеров
    private int program;

    // Вершины фигуры
    private float[] vertices = {
        -0.5f, 0.5f, 0.0f,
        0.5f, 0.5f, 0.0f,
        0.5f, -0.5f, 0.0f,
        -0.5f, -0.5f, 0.0f
    };

    private int verticesCount = vertices.length / 3; // Количество вершин

    // Цвет фигуры
    private float[] color = {1.0f, 0.0f, 0.0f, 1.0f};

    public GLRect() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(vertices.length * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        floatBuffer = byteBuffer.asFloatBuffer();
        floatBuffer.put(vertices);
        floatBuffer.position(0);

        int vertexShader = GLShader.compileShader(GLES32.GL_VERTEX_SHADER, R.raw.triangle_vertex);
        int fragmentShader =
                GLShader.compileShader(GLES32.GL_FRAGMENT_SHADER, R.raw.triangle_fragment);

        program = GLES32.glCreateProgram();
        GLES32.glAttachShader(program, vertexShader);
        GLES32.glAttachShader(program, fragmentShader);
        GLES32.glLinkProgram(program);
    }

    private int posHandler;
    private int colHandler;

    private int vertexStride = 3 * 4; // 3 компонента * 4 байта

    // Отрисовка фигуры
    public void draw() {
        GLES32.glUseProgram(program);

        posHandler = GLES32.glGetAttribLocation(program, "v_Position");
        GLES32.glEnableVertexAttribArray(posHandler);
        GLES32.glVertexAttribPointer(
                posHandler, 3, GLES32.GL_FLOAT, false, vertexStride, floatBuffer);

        colHandler = GLES32.glGetUniformLocation(program, "u_Color");
        GLES32.glUniform4fv(colHandler, 1, color, 0);
        GLES32.glDrawArrays(GLES32.GL_TRIANGLE_FAN, 0, verticesCount);
        GLES32.glDisableVertexAttribArray(posHandler);
    }
}
