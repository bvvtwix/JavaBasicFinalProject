package data;

public enum BrowserModes {

    KIOSK("--kiosk"),
    HEADLESS("headless"),
    MAXIMAZE("--start-maximized"),
    NOMODE("test");

    private String param;

    BrowserModes(String param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return param;
    }

}




