package io.hummerrisk.commons.constants;

/**
 * @author harris
 */
public class PackageConstants {

    public final static String DEFAULT_BASE_DIR = "/opt/hummerrisk/file/";

    public final static String IMAGE_JPG_EXTENSION = ".jpg";

    /**
     * 默认大小 500M
     */
    public static final long DEFAULT_MAX_SIZE = 1024 * 1024 * 1024 * 5;

    int GB = 1024 * 1024 * 1024;
    int MB = 1024 * 1024;
    int KB = 1024;

    /**
     * 默认的文件名最大长度 100
     */
    public static final int DEFAULT_FILE_NAME_LENGTH = 100;

    public final static String DEPENDENCY_CHECK = "dependency-check ";
    public final static String PROJECT = "--project ";
    public final static String SCAN = "--scan ";
    public final static String OUT = "-o ";
    public final static String LOG = "-log ";
    public final static String FORMAT = "-f ";//HTML, XML, CSV, JSON,JUNIT, SARIF, or ALL
    public final static String HTML = "HTML";
    public final static String XML = "XML";
    public final static String CSV = "CSV";
    public final static String JSON = "JSON";
    public final static String JUNIT = "JUNIT";
    public final static String SARIF = "SARIF";
    public final static String ALL = "ALL";

}
