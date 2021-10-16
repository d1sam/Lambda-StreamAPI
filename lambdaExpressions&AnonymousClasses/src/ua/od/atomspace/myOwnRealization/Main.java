package ua.od.atomspace.myOwnRealization;

public class Main {
    public static void smthMethod() {
        System.out.println("Какая-то логика!");
    }

    public static void main(String[] args) {
        ControllerShower controllerShower = new ControllerShower();
        Phone phone = new Phone();
        Web web = new Web();
        controllerShower.addDevice(phone);
        controllerShower.addDevice(web);
        controllerShower.addDevice(new Showable() {
            @Override
            public void showUserInterface(int countPixels) {
                System.out.println("Страница открыта в десктоп на " + countPixels + " пикселей!");
            }
        });
        controllerShower.addDevice(countPixels -> {
            System.out.println("Страница открыта в чем-то на " + countPixels + " пикселей!");
        });
        controllerShower.addDevice(countPixels -> {
            Main.smthMethod();
        });
        controllerShower.showOnAllDevice();

    }
}
