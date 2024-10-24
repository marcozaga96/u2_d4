package marcozagaria.u2_d4;

import marcozagaria.u2_d4.entities.AppConfig;
import marcozagaria.u2_d4.entities.Menu;
import marcozagaria.u2_d4.entities.Pizza;
import marcozagaria.u2_d4.entities.Topping;
import marcozagaria.u2_d4.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Profile("!test")
@Component
public class OrdersRunner implements CommandLineRunner {

    @Autowired
    AppConfig appConfig;
    @Autowired
    private PizzaService pizzaService;

    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U2D4Application.class);
        try {
            Menu m = (Menu) ctx.getBean("menu");
            m.printMenu();
            List<Topping> toppings = Arrays.asList(appConfig.toppingTomatoBean(), appConfig.toppingCheeseBean(), appConfig.toppingHamBean(), appConfig.toppingSalamiBean(), appConfig.toppingPineappleBean());
            Pizza newPizza = new Pizza("margherita", toppings, false);
            //pizzaService.saveMany(toppings);
            pizzaService.savePizza(newPizza);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            ctx.close();
        }
    }
}
