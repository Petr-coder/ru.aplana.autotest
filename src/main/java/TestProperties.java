import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Maria on 07.09.2017.
 */
public class TestProperties {
        private final Properties properties = new Properties();

        private static TestProperties INSTANCE = null;

        private TestProperties(){
            System.setProperty("environment", "application");
            try {
                properties.load(new FileInputStream(new File("C:\\Users\\PMikhaylov.APPLINE\\IdeaProjects\\ru.aplana.autotest\\environment.properties")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static TestProperties getInstance() {
            if (INSTANCE == null){
                INSTANCE = new TestProperties();
            }
            return INSTANCE;
        }

        public Properties getProperties() {

            return properties;
        }
}