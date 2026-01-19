package subiect1;

public class CustomThread extends Thread {
    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            try {
                System.out.println("Se verifica angajatii...");
                Thread.sleep(1000);

                if (Main.manageri.isEmpty()) {
                    throw new CustomException("Nu exista manageri in lista");
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

            for (Manager manager : Main.manageri) {
                manager.stergeAngajati(manager.getListaAngajati(), (float) ((float) Math.random()*0.5));
            }
        }
    }
}
