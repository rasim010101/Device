class Tablet extends Device {
    private String os;
    private boolean hasStylus;

    public Tablet(String type, double price, double weight, String os, boolean hasStylus) {
        super(type, price, weight);
        this.os = os;
        this.hasStylus = hasStylus;
    }

    public String getOs() {
        return os;
    }

    public boolean hasStylus() {
        return hasStylus;
    }
}
