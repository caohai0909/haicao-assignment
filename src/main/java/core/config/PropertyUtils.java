package core.config;

import java.io.*;
import java.util.Properties;
//import java.util.Properties;
import static core.common.BuiltInAction.*;
public class PropertyUtils {

    public static Properties property;
    private static String configPath = "\\configuration.properties";

    public static void initializePropertyFile()  {
        property = new Properties();
        try {
            InputStream inputStream = new FileInputStream(getProjectPath() + configPath);
            property.load(inputStream);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }














//    private static PropertyUtils INSTANCE = null;
//    private final Properties props = new Properties();
//
//    private PropertyUtils() {
//        this.loadProperties("configuration.properties");
//        this.props.putAll(System.getProperties());
//    }
//
//    private static PropertyUtils getInstance() {
//        if (PropertyUtils.INSTANCE == null) {
//            PropertyUtils.INSTANCE = new PropertyUtils();
//        }
//        return PropertyUtils.INSTANCE;
//    }
//
//    public static String getProperty(final String key, final String defaultValue) {
//        return PropertyUtils.getInstance().props.getProperty(key, defaultValue);
//    }
//
//    public void loadProperties(final String path) {
//        InputStream inputStream = null;
//        try {
//            inputStream = ClassLoader.getSystemResourceAsStream(path);
//            if (inputStream != null) {
//                this.props.load(inputStream);
//            } else {
//                //throw new UnableToLoadPropertiesException("property file '" + path + "' not found in the classpath");
//                System.out.println("property file '" + path + "' not found in the classpath");
//            }
//        } catch (final Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                inputStream.close();
//            } catch (final IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static Properties getProps() {
//        return PropertyUtils.getInstance().props;
//    }

//    private static String getAbsolutePath(String appRelativePath) {
//        File file = new File(appRelativePath);
//        return file.getAbsolutePath();
//    }

}
//class UnableToLoadPropertiesException extends RuntimeException {
//
//    public UnableToLoadPropertiesException(final String s) {
//        super(s);
//    }
//}
