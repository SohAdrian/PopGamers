/**
 * 
 */
package devops.popgamers;

import java.util.*;

/**
 * @author Adria
 *
 */
public class GameCollection {

    private ArrayList<Game> games = new ArrayList<>();
    private int capacity;

    public GameCollection() {
    	/*games.add(new Game("League of Legend (LoL)","LoL Picture", "LoL Description", "MOBA"));
    	games.add(new Game("Splatoon","Splatoon Picture","Splatoon Description", "TPS"));
    	games.add(new Game("Valorant","Valorant Picture", "Valorant Description","MOBA/Action"));
    	games.add(new Game("Plant Vs Zombie 2","PVZ2 Picture", "PVZ 2 Description","Survival"));*/

        this.capacity = 20;
    }

    public GameCollection(int capacity) {
        this.capacity = capacity;
    }

    public List<Game> getGames() {
        return games;
    }

    public void addGame(Game game) {
    	if(games.size() != capacity) {
    		games.add(game);
    	}
    }
    
    public ArrayList<Game> sortGameByGameName() {         
        Collections.sort(games, Game.GameNameComparator);         
        return games;     
    }
    
    public ArrayList<Game> sortGameByGenre() {         
        Collections.sort(games, Game.GameGenreComparator);         
        return games;     
    } 
    
//    public Game findGamesById(String gameId) {
//    	for (Game g : games) { 		      
//            if(g.getGameId().equals(gameId)) return g;
//       }
//    	return null;
//    }

    public Game findGameByGameName(String gameName) {
    	for (Game g : games) { 		      
            if(g.getGameName().equals(gameName)) return g;
       }
    	return null;
    }
}
