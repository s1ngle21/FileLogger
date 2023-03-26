import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        try {

            FileLoggerConfiguration cfg = FileLoggerConfigurationLoader.load("cfg.txt");

            FileLogger logger = new FileLogger(cfg);
            logger.validationDebugInfo();

        } catch (FileNotFoundException e) {
            System.out.println("Can not find a file");
        } catch (FileMaxSizeReachedException e) {
            System.out.println("Have been reached max file size");
        }
    }
}
