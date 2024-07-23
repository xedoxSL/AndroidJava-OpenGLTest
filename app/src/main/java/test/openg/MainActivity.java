package test.openg;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import test.openg.config;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MySurfaceView view = new MySurfaceView(this);
        setContentView(view);
    }
}
