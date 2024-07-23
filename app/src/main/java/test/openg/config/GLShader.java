package test.openg.config;

import android.content.Context;
import android.opengl.GLES32;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GLShader {

    private static Context appContext;

    public static void setContext(Context context) {
        appContext = context;
    }

    public static String readRaw(int resourceId) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = null;

            InputStream inputStream = appContext.getResources().openRawResource(resourceId);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
                Log.e("", line);
            }
            bufferedReader.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static int compileShader(int type, int resId) {
        int shader = GLES32.glCreateShader(type);
        GLES32.glShaderSource(shader, readRaw(resId));
        GLES32.glCompileShader(shader);
        return shader;
    }
}
