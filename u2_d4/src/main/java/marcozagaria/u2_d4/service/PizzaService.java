package marcozagaria.u2_d4.service;

import lombok.extern.slf4j.Slf4j;
import marcozagaria.u2_d4.entities.Drink;
import marcozagaria.u2_d4.entities.Pizza;
import marcozagaria.u2_d4.entities.Topping;
import marcozagaria.u2_d4.repository.DrinkRepository;
import marcozagaria.u2_d4.repository.PizzaRepository;
import marcozagaria.u2_d4.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private ToppingRepository toppingRepository;
    @Autowired
    private DrinkRepository drinkRepository;

    public void savePizza(Pizza newPizza) {
        pizzaRepository.save(newPizza);
        log.info("la pizza " + newPizza.getName() + " è stata salvata correttamente!");
    }

    public void saveTopping(Topping newTopping) {
        toppingRepository.save(newTopping);
        log.info("il topping " + newTopping.getName() + " è stato salvato correttamente!");
    }

    public void saveDrink(Drink newDrink) {
        drinkRepository.save(newDrink);
        log.info("il drink " + newDrink.getName() + " è stato salvato correttamente!");
    }

    public void saveAllTopping(List<Topping> newTopping) {
        for (Topping topping : newTopping) {
            try {
                this.saveTopping(topping);
            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
        }
    }

    public void saveAllDrink(List<Drink> newDrink) {
        for (Drink drink : newDrink) {
            try {
                this.saveDrink(drink);
            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
        }
    }
    

    public Topping findTopping(String name) {
        return toppingRepository.findByName(name);
    }
}
