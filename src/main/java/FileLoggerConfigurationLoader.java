import java.io.*;


public class FileLoggerConfigurationLoader {

    public static FileLoggerConfiguration load(String filePath) {
        String name = null;
        LoggingLevel loggingLevel = null;
        long maxSize = 0;
        String format = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                String[] lineSplit = line.split(":");
                switch (lineSplit[0].trim()) {
                    case "FILE":
                        name = lineSplit[1].trim();
                        break;
                    case "LEVEL":
                        String level = lineSplit[1].trim();
                        loggingLevel = LoggingLevel.valueOf(level.toUpperCase());
                        break;
                    case "MAX-SIZE":
                        String size = lineSplit[1].trim();
                        maxSize = Long.parseLong(size);
                        break;
                    case "FORMAT":
                        format = lineSplit[1].trim();
                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new FileLoggerConfiguration(name, loggingLevel, maxSize, format);
    }
}