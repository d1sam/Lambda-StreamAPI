package ua.od.atomspace.myOwnRealization;

import java.util.ArrayList;

public class ControllerShower {
    protected ArrayList<Showable> list = new ArrayList<>();

    public void addDevice(Showable device) {
        list.add(device);
    }

    public void removeDevice(Showable device) {
        list.remove(device);
    }

    public void showOnAllDevice() {
        for (Showable n : list) {
            boolean flag=false;
            if (n instanceof Phone) {
                flag = true;
                n.showUserInterface(10);
            }
            if (n instanceof Web) {
                flag=true;
                n.showUserInterface(15);
            }
            if(!flag){
            n.showUserInterface(200);
            }
        }
    }
}
