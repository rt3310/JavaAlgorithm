package designpattern.mediator.after;

public class App {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        Colleague user1 = new Colleague1("user1");
        Colleague user2 = new Colleague2("user2");
        Colleague user3 = new Colleague3("user3");

        user1.setMediator(mediator);
        user2.setMediator(mediator);
        user3.setMediator(mediator);

        mediator.addColleague(user1);
        mediator.addColleague(user2);
        mediator.addColleague(user3);

        user1.setMessage("I'm user1");
        user1.send();
    }
}
