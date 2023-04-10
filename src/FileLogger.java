import java.io.*;

public class FileLogger {

    private FileLoggerConfiguration cfg;

    public FileLogger(FileLoggerConfiguration cfg) {
        this.cfg = cfg;
    }

    public void log(LoggingLevel level, String message) {
        String outMessage = " Current time: " + DateUtils.getCurrentDate("dd.MM.yyyy - HH:mm:ss") + ";" +
                " Level: " + level + " Message: " + message + ";" + "\n";
        File file = new File(cfg.getFileName() + "." + cfg.getFileFormat());
        try (FileWriter myWriter = new FileWriter(file, true)) {
            if (file.length() + message.length() > cfg.getFileSizeMax()) {
                createFile(outMessage);
            }
            myWriter.write(outMessage);
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while writing into a file: " + cfg.getFileName() + "." + cfg.getFileFormat(), e);
        }
    }

    public void debug() {
        if (isDebugEnabled()) {
            log(LoggingLevel.DEBUG, "Message for DEBUG");
        }

    }

    public void info() {
        if (!isDebugEnabled()) {
            log(LoggingLevel.INFO, "Message for INFO");
        }
    }

    public boolean isDebugEnabled() {
        return cfg.getLoggingLevel() == LoggingLevel.DEBUG;
    }


    public void createFile(String message) {
        String fileName = DateUtils.getCurrentDate("HH.mm.ss")+ "_" + cfg.getFileName() + "." + cfg.getFileFormat();
            File file = new File(fileName);
        try (FileWriter myWriter = new FileWriter(file, true)){
            myWriter.write(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
