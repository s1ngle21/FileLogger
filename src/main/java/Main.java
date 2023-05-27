public class Main {

    public static void main(String[] args) {
        FileLoggerConfiguration cfg = FileLoggerConfigurationLoader.load("cfg.txt");
        FileLogger logger = new FileLogger(cfg);
        logger.debug("Message for Debug");
        logger.info("Message for Info");
    }
}
