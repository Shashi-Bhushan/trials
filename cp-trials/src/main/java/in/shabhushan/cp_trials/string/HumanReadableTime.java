package in.shabhushan.cp_trials.string;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int hour = seconds / 3600;
        int minute = (seconds % 3600) / 60;
        int second = seconds % 3600 % 60;
        // Do something
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
