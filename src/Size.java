import java.awt.*;

public class Size {
    final int widthScreen, heightScreen, heightMFrame, widthMFrame, heightForeground;
    public Size() {
        heightScreen = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        widthScreen = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        heightMFrame = 600;
        widthMFrame = 400;
        heightForeground = 100;
    }
}
