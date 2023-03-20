package designpattern.mediator.after;

public abstract class Colleague {
    private Mediator mediator;
    private String name;
    private String message;

    public Colleague(String name) {
        this.name = name;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void send() {
        mediator.mediate(this);
    }

    public abstract void receive(Colleague colleague);
}
