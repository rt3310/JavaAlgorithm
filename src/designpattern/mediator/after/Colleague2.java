package designpattern.mediator.after;

public class Colleague2 extends Colleague {
    public Colleague2(String name) {
        super(name);
    }

    @Override
    public void receive(Colleague colleague) {
        System.out.println(colleague.getName() + " >> " + super.getName() + " : " + colleague.getMessage());
    }
}
