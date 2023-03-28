import java.io.*;

public class FileLogger {

    private FileLoggerConfiguration cfg;

    public FileLogger(FileLoggerConfiguration cfg) {
        this.cfg = cfg;
    }

    public void log(String level, String message) throws FileMaxSizeReachedException {
        try {
            File file = new File(cfg.getFileName() + "." + cfg.getFileFormat());
            if (file.length() + message.length() > cfg.getFileSizeMax()) {
                createFile();
                throw new FileMaxSizeReachedException(String.format("Max size of file is: %d, your size of file %s.%s is: %s",
                        cfg.getFileSizeMax(), cfg.getFileName(), cfg.getFileFormat(), file.length() + message.length()));
            }
            FileWriter myWriter = new FileWriter(file, true);
            String outMessage = " Current time: " + Date.date() + ";" + " Level: " + level + " Message: " + message + ";" + "\n";
            myWriter.write(outMessage);
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong while writing in");
        }
    }

    public void debug(String message) {
        try {
            log("DEBUG;", message);
        } catch (FileMaxSizeReachedException e) {
            throw new RuntimeException(e);
        }
    }

    public void info(String message) {
        try {
            log("INFO;", message);
        } catch (FileMaxSizeReachedException e) {
            throw new RuntimeException(e);
        }
    }

    public void validationDebugInfo() {
        if (cfg.getLoggingLevel() == LoggingLevel.DEBUG) {
            debug("Message for DEBUG");
            info("Message for INFO");
        } else {
            info("Message for INFO");
        }
    }

    public void createFile() throws IOException {
        String fileName = cfg.getFileName() + "." + cfg.getFileFormat();
        File file = new File(fileName);
        file.createNewFile();
    }
}
