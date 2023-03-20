package designpattern.mediator.before;

public class Colleague2 {

    private String name;
    private Colleague1 colleague1;
    private Colleague3 colleague3;
    private String message;

    public Colleague2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setColleague1(Colleague1 colleague1) {
        this.colleague1 = colleague1;
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
        colleague1.receive(this);
        colleague3.receive(this);
    }

    public void receive(Colleague1 colleague1) {
        System.out.println(colleague1.getName() + " >> " + this.name + " : " + colleague1.getMessage());
    }

    public void receive(Colleague3 colleague3) {
        System.out.println(colleague3.getName() + " >> " + this.name + " : " + colleague3.getMessage());
    }
}