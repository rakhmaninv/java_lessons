package hw_6;

public class Laptop {
    private Integer id;
    private String cpu; 
    private Integer ram;
    private Integer storage;
    private String os;
    private Boolean gpu;

    private static Integer incrementalId = 0;

    public Laptop(String cpu, Integer ram, Integer storage, String os, Boolean gpu) {
        this.id = setId();
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.gpu = gpu;
    }
    
    public Integer getId() {
        return id;
    }
    
    private Integer setId() {
        incrementalId++;
        return incrementalId;
    }

    public String getCpu() {
        return cpu;
    }

    public Integer getRam() {
        return ram;
    }

    public Integer getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public Boolean haveGpu() {
        return gpu;
    }


    @Override
    public String toString() {
        return "laptop " + id + "-> cpu=" + cpu + "\tram=" + ram + "\tstorage=" + storage + "\tos=" + os + "\tgpu=" + gpu;
    }
    
    
}
