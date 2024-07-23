package test.openg.triangle_test;

import android.opengl.GLES32;
import static android.opengl.GLSurfaceView.Renderer;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.egl.EGLConfig;

public class TriangleRenderer implements Renderer {

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES32.glClearColor(0.0f, 1.0f, 0.0f, 1.0f); // Установка цвета очистки фона (зеленым)
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int w, int h) {
        GLES32.glViewport(0, 0, w, h); // Установуа области отрисовки (на весь доступный View)
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES32.glClear(GLES32.GL_COLOR_BUFFER_BIT); // Очистка & заливка фона
    }
}
