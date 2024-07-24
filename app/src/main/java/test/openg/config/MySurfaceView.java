package test.openg;

import android.content.Context;
import android.opengl.GLSurfaceView;
import test.openg.square_test.RectRenderer;
import test.openg.triangle_test.GLTriangle;
import test.openg.triangle_test.TriangleRenderer;

public class MySurfaceView extends GLSurfaceView {

    public MySurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(3);
        
        // Выбор класса рендера //
        
        // setRenderer(new TriangleRenderer()); // Триугольник
        setRenderer(new RectRenderer()); // Прямоугольник
    }
}
