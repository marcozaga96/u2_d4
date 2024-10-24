package marcozagaria.u2_d4.repository;


import marcozagaria.u2_d4.entities.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Integer> {
    Topping findByName(String name);
}
