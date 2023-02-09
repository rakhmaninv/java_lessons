package hw_6;

public class Laptop {
    private String cpu; 
    private Integer ram;
    private Integer storage;
    private String os;
    private Boolean gpu;

    public Laptop(String cpu, int ram, int storage, String os, boolean gpu) {
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.gpu = gpu;
    }

    public String getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public boolean haveGpu() {
        return gpu;
    }


    @Override
    public String toString() {
        return "laptop [cpu=" + cpu + ", ram=" + ram + ", storage=" + storage + ", os=" + os + ", gpu=" + gpu + "]";
    }
    
    
}
