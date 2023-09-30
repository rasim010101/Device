class Laptop extends Device {
    private String processor;
    private int ramSize;

    public Laptop(String type, double price, double weight, String processor, int ramSize) {
        super(type, price, weight);
        this.processor = processor;
        this.ramSize = ramSize;
    }

    public String getProcessor() {
        return processor;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }
}