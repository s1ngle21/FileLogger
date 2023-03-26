import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileLoggerConfigurationLoader {

    public static FileLoggerConfiguration load(String filePath) throws FileNotFoundException {
        File configFile = new File(filePath);
        Scanner scanner = new Scanner(configFile);
        String name = null;
        LoggingLevel loggingLevel = null;
        long maxSize = 0;
        String format = null;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.startsWith("FILE:")) {
                name = line.substring("FILE:".length()).trim();
            } else if (line.startsWith("LEVEL:")) {
                String level = line.substring("LEVEL:".length()).trim();
                loggingLevel = LoggingLevel.valueOf(level.toUpperCase());
            } else if (line.startsWith("MAX-SIZE:")) {
                String size = line.substring("MAX-SIZE:".length()).trim();
                maxSize = Long.parseLong(size);
            } else if (line.startsWith("FORMAT:")) {
                format = line.substring("FORMAT:".length()).trim();
            }
        }
        scanner.close();
        return new FileLoggerConfiguration(name, loggingLevel, maxSize, format);
    }
}
