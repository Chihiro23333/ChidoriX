package com.bilibili.designpatterncomponent.memento.blackbox;

public class Originator {


    private String state;

    public MementoIF createMemento() {
        return new Memento(state);
    }

    public void restoreTo(MementoIF memento) {
        state = ((Memento) memento).getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private class Memento implements MementoIF {
        private String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }

}
