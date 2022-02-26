package devops.popgamers;

import java.util.Comparator;
import java.util.Objects;

public class Game {

	protected String gameName;
	
	public Game(String gameName, String gamePicture, String gameDescription, String genre) {
		super();
		//this.gameId = gameId;
		this.gameName = gameName;
		this.gamePicture = gamePicture;
		this.gameDescription = gameDescription;
		this.genre = genre;
	}
	
	//protected String gameId;
	protected String gamePicture;
	protected String gameDescription;
	protected String genre;
	
//	/**
//	 * @return the gameId
//	 */
//	public String getGameId() {
//		return gameId;
//	}
//	/**
//	 * @param gameId the gameId to set
//	 */
//	public void setGameId(String gameId) {
//		this.gameId = gameId;
//	}
	
	/**
	 * @return the gameName
	 */
	public String getGameName() {
		return gameName;
	}
	/**
	 * @param gameName the gameName to set
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	/**
	 * @return the gamePicture
	 */
	public String getgamePicture() {
		return gamePicture;
	}
	/**
	 * @param gamePicture the gamePicture to set
	 */
	public void setgamePicture(String gamePicture) {
		this.gamePicture = gamePicture;
	}
	/**
	 * @return the gameDescription
	 */
	public String getGameDescription() {
		return gameDescription;
	}
	/**
	 * @param gameDescription the gameDescription to set
	 */
	public void setGameDescription(String gameDescription) {
		this.gameDescription = gameDescription;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(gameName, gamePicture, gameDescription, genre);
	}


	public static Comparator<Game> GameNameComparator = new Comparator<Game>() {
		@Override
		public int compare(Game g1, Game g2) {
			return (int) (g1.getGameName().compareTo(g2.getGameName()));
		}
	};
	
	public static Comparator<Game> GameGenreComparator = new Comparator<Game>() {
		@Override
		public int compare(Game g1, Game g2) {
			return (int) (g1.getGenre().compareTo(g2.getGenre()));
		}
	};
}
