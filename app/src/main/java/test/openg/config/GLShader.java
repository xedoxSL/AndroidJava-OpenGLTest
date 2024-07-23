package test.openg.config;

import android.app.Application;
import android.content.Context;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GLShader extends Application {

    public static void getShaderText(int resID) {
        
        
    }

    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = this;
    }
}
