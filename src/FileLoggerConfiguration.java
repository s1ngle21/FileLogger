public class FileLoggerConfiguration {

    private String fileName;
    private LoggingLevel loggingLevel;
    private long maxFileSize;
    private String fileFormat;

    public FileLoggerConfiguration(String fileName, LoggingLevel loggingLevel, long fileSize, String fileFormat) {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("File name can not be null or empty!");
        }
        if (loggingLevel == null) {
            throw new IllegalArgumentException("Logging level can not be null!");
        }
        if (maxFileSize < 0) {
            throw new IllegalArgumentException("Size of file must be above zero!");
        }
        if (fileFormat == null || fileFormat.isEmpty()) {
            throw new IllegalArgumentException("File format can not be null or empty!");
        }

        this.fileName = fileName;
        this.loggingLevel = loggingLevel;
        this.maxFileSize = fileSize;
        this.fileFormat = fileFormat;
    }

    public String getFileName() {
        return fileName;
    }


    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public long getFileSizeMax() {
        return maxFileSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }
}
