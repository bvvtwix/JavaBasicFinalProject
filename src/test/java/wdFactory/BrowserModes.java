package wdFactory;

public enum BrowserModes {

    KIOSK("--kiosk"),
    HEADLESS("headless"),
    MAXIMAZE("--start-maximized");

    private String param;

    BrowserModes(String param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return param;
    }

}




