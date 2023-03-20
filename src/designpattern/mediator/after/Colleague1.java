package designpattern.mediator.after;

public class Colleague1 extends Colleague {
    public Colleague1(String name) {
        super(name);
    }

    @Override
    public void receive(Colleague colleague) {
        System.out.println(colleague.getName() + " >> " + super.getName() + " : " + colleague.getMessage());
    }
}
