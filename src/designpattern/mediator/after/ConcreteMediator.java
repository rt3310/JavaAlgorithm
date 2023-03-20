package designpattern.mediator.after;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {
    private List<Colleague> colleagues;

    public ConcreteMediator() {
        this.colleagues = new ArrayList<>();
    }

    @Override
    public void addColleague(Colleague colleague) {
        this.colleagues.add(colleague);
    }

    @Override
    public void mediate(Colleague colleague) {
        for (Colleague receiver : colleagues) {
            receiver.receive(colleague);
        }
    }
}
