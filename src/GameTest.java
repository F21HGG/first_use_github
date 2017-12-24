import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	@Before
	public void setUp() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testInitMap() {
		Game game=new Game();
		int size = 2;
		Block[][] mapExpected;
		mapExpected = new Block[size + 2][size + 2];
		
		for (int i = 0; i < size + 2; i++) {
			for (int j = 0; j < size + 2; j++) {
				mapExpected[i][j] = new Block();
			}
		}

		for (int i = 1; i < size + 1; i++) {
			for (int j = 1; j < size + 1; j++) {
				Random random = new Random();
				int r = random.nextInt(3);
				if ((i + j) % 3 == 1)
					mapExpected[i][j].setLive(true);
				else
					mapExpected[i][j].setLive(false);
			}
		}
		game.printMap(mapExpected, size);
		
		Block[][] mapActual;
		mapActual = new Block[size + 2][size + 2];
		
		mapActual=game.initMap(mapActual,size);
		game.printMap(mapActual, size);
		
		assertEquals(mapActual, mapActual);
	}

	@Test
	public void testPrintMap() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateMap() {
		fail("Not yet implemented");
	}

}
