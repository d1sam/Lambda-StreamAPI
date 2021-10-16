package ua.od.atomspace.myOwnRealization;

public class Phone implements Showable{

    @Override
    public void showUserInterface(int countPixels) {
        System.out.println("Страница открыта в телефоне на "+countPixels+" пикселей!");
    }
}
