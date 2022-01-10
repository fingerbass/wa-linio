package managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private static final Properties props = new Properties();

    public Properties getProp() {
        InputStream inputStream = null;
        String propsFilename = "config.properties";

        if (props.isEmpty()) {
            try {
                inputStream = new FileInputStream(propsFilename);
                props.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return props;
    }
}
