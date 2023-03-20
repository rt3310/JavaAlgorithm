package designpattern.mediator.before;

public class Colleague3 {

    private String name;
    private Colleague1 colleague1;
    private Colleague2 colleague2;
    private String message;


    public Colleague3(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setColleague1(Colleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(Colleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void send() {
        colleague1.receive(this);
        colleague2.receive(this);
    }

    public void receive(Colleague1 colleague1) {
        System.out.println(colleague1.getName() + " >> " + this.name + " : " + colleague1.getMessage());
    }

    public void receive(Colleague2 colleague2) {
        System.out.println(colleague2.getName() + " >> " + this.name + " : " + colleague2.getMessage());
    }
}
