package test.openg;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import test.openg.config.GLShader;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GLShader.setContext(getApplicationContext());
        MySurfaceView view = new MySurfaceView(this);
        setContentView(view);
    }
}
