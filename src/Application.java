import Phone.Phone;
import Storage.Storage;

public class Application {

    static Storage<Phone> brokenPhones = new Storage<Phone>();
    static Storage<Phone> workingPhones = new Storage<Phone>();
    static Storage<Phone> storage = new Storage<Phone>();
    static Phone temp;

    public static void main(String[] args) {

        storage.add(new Phone());
        storage.add(new Phone());
        storage.add(new Phone());
        storage.add(new Phone());
        storage.add(new Phone());

        checkPhones();

        System.out.println("Working phones");
        displayPhoneSerials(workingPhones);
        System.out.println("Broken phones");
        displayPhoneSerials(brokenPhones);
    }

    /**
     * Looping trough all phones, so their screens can be validated as working or broken
     */
    public static void checkPhones(){
        while (true) {

            if ((temp = storage.top()) == null) {
                break;
            } else {
                temp.showPhone();
            }
            if (temp.isPhoneClosed()) {
                if (temp.isPhoneBroken()) brokenPhones.add(temp);
                else workingPhones.add(temp);

                storage.remove();

            }
        }
    }

    /**
     * Displays the serials of a phone containing storage
     * @param storage Structure that holds the phones
     */
    public static void displayPhoneSerials(Storage<Phone> storage) {
        while (storage.top() != null) {
            System.out.println(storage.top().getSerial());
            storage.remove();
        }
    }
}
