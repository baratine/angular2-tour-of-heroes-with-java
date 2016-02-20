package toh;

import java.util.logging.Level;
import java.util.logging.Logger;

import static io.baratine.web.Web.include;
import static io.baratine.web.Web.start;

/**
 * A bootstrap for Baratine Server
 */
public class TourOfHeroesServer
{
  public void run()
  {
    include(TourOfHeroesService.class);

    Logger log = Logger.getLogger("com");

    log.setLevel(Level.FINER);

    start();
  }

  public static void main(String[] args)
  {
    TourOfHeroesServer server = new TourOfHeroesServer();
    server.run();
  }
}
