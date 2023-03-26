public class FileLoggerConfiguration {

    private String fileName;
    private LoggingLevel loggingLevel;
    private long fileSizeMax;
    private String fileFormat;

    public FileLoggerConfiguration(String fileName, LoggingLevel loggingLevel, long fileSize, String fileFormat) {
        this.fileName = fileName;
        this.loggingLevel = loggingLevel;
        this.fileSizeMax = fileSize;
        this.fileFormat = fileFormat;
    }

    public String getFileName() {
        return fileName;
    }


    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public long getFileSizeMax() {
        return fileSizeMax;
    }

    public String getFileFormat() {
        return fileFormat;
    }
}
