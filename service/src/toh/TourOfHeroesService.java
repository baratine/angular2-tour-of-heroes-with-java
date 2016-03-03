package toh;

import java.util.ArrayList;
import java.util.List;

import io.baratine.service.OnInit;
import io.baratine.service.Result;
import io.baratine.service.Service;
import io.baratine.web.Get;
import io.baratine.web.Path;

/**
 * Service providing a list of Heroes
 */
@Service()
public class TourOfHeroesService
{
  private List<Hero> _heroes = new ArrayList<>();

  @OnInit
  public void init()
  {
    _heroes.add(new Hero(11, "Mr. Nice"));
    _heroes.add(new Hero(12, "Narco"));
    _heroes.add(new Hero(13, "Bombasto"));
    _heroes.add(new Hero(14, "Celeritas"));
    _heroes.add(new Hero(15, "Magneta"));
    _heroes.add(new Hero(16, "RubberMan"));
    _heroes.add(new Hero(17, "Dynama"));
    _heroes.add(new Hero(18, "Dr IQ"));
    _heroes.add(new Hero(19, "Magma"));
    _heroes.add(new Hero(20, "Tornado"));
  }

  @Get("/heroes")
  public void getHeroes(Result<Hero[]> result)
  {
    result.ok(_heroes.toArray(new Hero[_heroes.size()]));
  }

  @Get("/heroes/{id}")
  public void getHero(@Path("id") int id, Result<Hero> result)
  {
    Hero hero = null;

    for (Hero h : _heroes) {
      if (h.getId() == id) {
        hero = h;
        break;
      }
    }

    result.ok(hero);
  }
}
