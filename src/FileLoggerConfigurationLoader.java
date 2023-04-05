import java.io.*;


public class FileLoggerConfigurationLoader {

    public static FileLoggerConfiguration load(String filePath) {
        String name = null;
        LoggingLevel loggingLevel = null;
        long maxSize = 0;
        String format = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
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
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new FileLoggerConfiguration(name, loggingLevel, maxSize, format);
    }
}