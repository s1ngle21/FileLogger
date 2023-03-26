import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {

    private FileLoggerConfiguration cfg;

    public FileLogger(FileLoggerConfiguration cfg) {
        this.cfg = cfg;
    }

    public void log(String level, String message) throws FileMaxSizeReachedException {
        try {
            File file = new File(cfg.getFileName());

            if (file.length() + message.length() > cfg.getFileSizeMax()) {
                throw new FileMaxSizeReachedException(String.format("Max size of file is: %d, your size of file %s is: %s",
                        cfg.getFileSizeMax(), file.length(), cfg.getFileName()));
            }
            FileWriter myWriter = new FileWriter(file, true);
            String outMessage = " Current time: " + Date.date() + ";" + " Level: " + level + " Message: " + message + ";" + "\n";
            myWriter.write(outMessage);
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong while writing in ");
        }
    }

    public void debug(String message) throws FileMaxSizeReachedException {
        log("DEBUG;", message);
    }

    public void info(String message) throws FileMaxSizeReachedException {
        log("INFO;", message);
    }

    public void validationDebugInfo() throws FileMaxSizeReachedException {
        if (cfg.getLoggingLevel() == LoggingLevel.DEBUG) {
            debug("Message for DEBUG");
            info("Message for INFO");
        } else {
            info("Message for INFO");
        }
    }
}
