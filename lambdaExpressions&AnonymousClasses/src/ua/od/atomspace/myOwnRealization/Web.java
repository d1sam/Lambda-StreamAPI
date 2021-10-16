package ua.od.atomspace.myOwnRealization;

public class Web implements Showable{
    @Override
    public void showUserInterface(int countPixels) {
        System.out.println("Страница открыта в вебе на "+countPixels+" пикселей!");
    }
}
