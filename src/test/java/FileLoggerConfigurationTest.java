import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileLoggerConfigurationTest {

    @BeforeEach
    void setup() {

    }
    @AfterEach
    void tearDown() {

    }
    @Test
    public void whenConstructorCalledValidArgumentsShouldBeProvided() {
        String fileName = "log.txt";
        LoggingLevel loggingLevel = LoggingLevel.DEBUG;
        long fileSize = 1024;
        String fileFormat = "txt";

        FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration(fileName, loggingLevel, fileSize, fileFormat);

        assertEquals(fileName, fileLoggerConfiguration.getFileName());
        assertEquals(loggingLevel, fileLoggerConfiguration.getLoggingLevel());
        assertEquals(fileSize, fileLoggerConfiguration.getFileSizeMax());
        assertEquals(fileFormat, fileLoggerConfiguration.getFileFormat());
    }

    @Test
    public void whenConstructorCalledAndFileNameIsNullOrEmptyThrowExceptionWithASpecificMessage() {
        String message = "File name can not be null or empty!";
        String fileName = null;
        LoggingLevel loggingLevel = LoggingLevel.DEBUG;
        long maxFileSize = 1024;
        String fileFormat = "txt";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new FileLoggerConfiguration(fileName, loggingLevel, maxFileSize, fileFormat));
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void whenConstructorCalledAndLoggingLevelIsNullThrowExceptionWithASpecificMessage() {
        String message = "Logging level can not be null!";
        String fileName = "cfg";
        LoggingLevel loggingLevel = null;
        long maxFileSize = 1024;
        String fileFormat = "txt";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new FileLoggerConfiguration(fileName, loggingLevel, maxFileSize, fileFormat));
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void whenConstructorCalledAndFileSizeIsZeroOrLessThrowExceptionWithASpecificMessage() {
        String message = "Size of file must be above zero!";
        String fileName = "cfg";
        LoggingLevel loggingLevel = LoggingLevel.DEBUG;
        long maxFileSize = 0;
        String fileFormat = "txt";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new FileLoggerConfiguration(fileName, loggingLevel, maxFileSize, fileFormat));
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void whenConstructorCalledAndFileFormatIsNullOrEmptyThrowExceptionWithASpecificMessage() {
        String message = "File format can not be null or empty!";
        String fileName = "cfg";
        LoggingLevel loggingLevel = LoggingLevel.DEBUG;
        long maxFileSize = 1024;
        String fileFormat = "";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new FileLoggerConfiguration(fileName, loggingLevel, maxFileSize, fileFormat));
        assertEquals(message, exception.getMessage());
    }
}
