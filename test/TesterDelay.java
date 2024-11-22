public class TesterDelay {
    public static void process(String str) {
        System.out.print(str);
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();;
            }
            System.out.print(" .");
        }
        System.out.println();
    }
}
