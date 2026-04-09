package structural.facade;

public class JsonFormatter {
    String format(String title, String body) {
        return "{ \"title\": \"" + title + "\", \"body\": \"" + body + "\" }";
    }
}
