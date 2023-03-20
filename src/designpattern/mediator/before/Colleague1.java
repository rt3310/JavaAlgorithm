package designpattern.mediator.before;

public class Colleague1 {

    private String name;
    private Colleague2 colleague2;
    private Colleague3 colleague3;
    private String message;

    public Colleague1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setColleague2(Colleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    public void setColleague3(Colleague3 colleague3) {
        this.colleague3 = colleague3;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void send() {
        colleague2.receive(this);
        colleague3.receive(this);
    }

    public void receive(Colleague2 colleague2) {
        System.out.println(colleague2.getName() + " >> " + this.name + " : " + colleague2.getMessage());
    }

    public void receive(Colleague3 colleague3) {
        System.out.println(colleague3.getName() + " >> " + this.name + " : " + colleague3.getMessage());
    }
}
