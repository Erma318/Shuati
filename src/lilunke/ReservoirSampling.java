package lilunke;

public class ReservoirSampling {
    private int count;
    private Integer sample;
    public ReservoirSampling() {
        this.count = 0;
        this.sample = null;
    }
    public void read(int value) {

    }
    public Integer sample() {
        return sample;
    }

    public static void main(String[] args) {
        ReservoirSampling here = new ReservoirSampling(); // 如果我要使用read和sample，我先要new一个名叫here的object
        here.read(1); // 调用here的read和sample方法
        here.sample();
    }
}
