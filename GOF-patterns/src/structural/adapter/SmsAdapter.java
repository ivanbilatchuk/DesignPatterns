package structural.adapter;

public class SmsAdapter implements Notification{
    private ExternalSmsLib legacyService = new ExternalSmsLib();

    @Override
    public void send(String title, String message) {
        String phone = "+38000000000";
        legacyService.deliverSms(phone, "[" + title + "] " + message);
    }
}
