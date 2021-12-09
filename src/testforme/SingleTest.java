package testforme;

public class SingleTest {

    private volatile static SingleTest singleTest;

    public SingleTest() {
    }

    public SingleTest getSingleTest() {

        if (singleTest == null) {
            synchronized (SingleTest.class) {
                if (singleTest == null) {
                    singleTest = new SingleTest();
                }
            }
        }
        return singleTest;
    }


}
