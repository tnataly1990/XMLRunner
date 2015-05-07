package commands;

/**
 * Created by Nataly on 07.05.2015.
 */
public enum Commands {
    VALIDATE("validate"), COUNT("count"), PRINT("print"), SEARCH("search");

    private String nameInXml;

    public String getNameInXml() {
        return nameInXml;
    }

    Commands(String nameInXml) {
        this.nameInXml = nameInXml;
    }
}
