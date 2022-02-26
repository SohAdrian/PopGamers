/**
 * 
 */
package devops.popgamers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import devops.popgamers.Game;
//import devops.popgamers.GameCollection;

/**
 * @author Adria
 *
 */
class GameCollectionTest {

	private GameCollection gc;
	private Game g1;
	private Game g2;
	private Game g3;
	private Game g4;
	private final int GAME_COLLECTION_SIZE = 4;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		gc = new GameCollection();
		g1 = new Game("League of Legend (LoL)", "LoL Picture", "LoL Description", "MOBA");
		g2 = new Game("Splatoon", "Splatoon Picture", "Splatoon Description", "TPS");
		g3 = new Game("Valorant", "Valorant Picture", "Valorant Description", "MOBA/Action");
		g4 = new Game("Plant Vs Zombie 2", "PVZ2 Picture", "PVZ 2 Description", "Survival");
		gc.addGame(g1);
		gc.addGame(g2);
		gc.addGame(g3);
		gc.addGame(g4);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link devops.popgamers.GameCollection#getGames()}.
	 */
	@Test
	void testGetGames() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link devops.popgamers.GameCollection#addGame(devops.popgamers.Game)}.
	 */
	@Test
	void testAddGame() {
		List<Game> testGc = gc.getGames();
		// Assert that Game Collection is equals to game collection size 4
		assertEquals(testGc.size(), GAME_COLLECTION_SIZE);
		// Act
		gc.addGame(g1);
		// Assert that Game Collection is equals is equals to game collection size 4 + 1
		assertEquals(gc.getGames().size(), GAME_COLLECTION_SIZE + 1);
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link devops.popgamers.GameCollection#sortGameByGameName()}.
	 */
	@Test
	void testSortGameByGameName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link devops.popgamers.GameCollection#sortGameByGenre()}.
	 */
	@Test
	void testSortGameByGenre() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link devops.popgamers.GameCollection#findGameByGameName(java.lang.String)}.
	 */
	@Test
	void testFindGameByGameName() {
		List<Game> testGc = gc.getGames();
		
		//fail("Not yet implemented");
		
	}

}
