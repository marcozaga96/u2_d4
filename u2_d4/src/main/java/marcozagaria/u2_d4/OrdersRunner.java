package marcozagaria.u2_d4;

import marcozagaria.u2_d4.entities.*;
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

            Topping topping1 = pizzaService.findTopping("Tomato");
            Topping topping2 = pizzaService.findTopping("Cheese");
            Topping topping3 = pizzaService.findTopping("Ham");
            Topping topping4 = pizzaService.findTopping("Salami");
            Topping topping5 = pizzaService.findTopping("Pineapple");

            List<Topping> alltoppings = Arrays.asList(appConfig.toppingTomatoBean(), appConfig.toppingCheeseBean(), appConfig.toppingHamBean(), appConfig.toppingSalamiBean(), appConfig.toppingPineappleBean());
            //pizzaService.saveAllTopping(alltoppings);

            List<Topping> toppingsMargherita = Arrays.asList(topping1, topping2);
            List<Topping> toppingshawaiian = Arrays.asList(topping1, topping2, topping5);
            List<Topping> toppingssalami = Arrays.asList(topping1, topping2, topping4);
            List<Topping> toppingssalamiXl = Arrays.asList(topping1, topping2, topping3, topping4);

            List<Drink> drinks = Arrays.asList(appConfig.lemonadeBean(), appConfig.waterBean(), appConfig.lemonadeBean());
            //pizzaService.saveAllDrink(drinks);

            Pizza newPizzaMargherita = new Pizza("margherita", toppingsMargherita, false);
            Pizza newPizzahawaiian = new Pizza("hawaiian", toppingsMargherita, false);
            Pizza newPizzasalami = new Pizza("salami", toppingsMargherita, false);
            Pizza newPizzasalamiXl = new Pizza("salami_xl", toppingsMargherita, true);
            //pizzaService.savePizza(newPizzahawaiian);
            //pizzaService.savePizza(newPizzasalami);
            //pizzaService.savePizza(newPizzasalamiXl);
            //pizzaService.savePizza(newPizzaMargherita);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            ctx.close();
        }
    }
}
