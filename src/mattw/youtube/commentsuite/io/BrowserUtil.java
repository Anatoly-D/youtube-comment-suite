package mattw.youtube.commentsuite.io;

import java.awt.*;
import java.net.URL;

/**
 * Attempts to open URLs on the system.
 *
 * @since 2016-08-10
 * @author mattwright324
 */
public class BrowserUtil {

    public BrowserUtil() {}

    public void open(URL url) {
        open(url.toString());
    }

    public void open(String link) {
        link = link.replace(" ", "%20");
        try {
            URL url = new URL(link);
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(url.toURI());
            } else {
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("xdg-open "+url.getPath());
            }
        } catch (Throwable e2) {
            e2.printStackTrace();
        }
    }
}
