package structural.adapter;

public class ExternalSmsLib {
    void deliverSms(String phone, String text) {
        System.out.println("External SMS to " + phone + ": " + text);
    }
}
