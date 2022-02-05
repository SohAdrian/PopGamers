
public class Game {

	protected String gameName;
	
	public Game(String gameName, String gamePicture, String gameDescription, String genre) {
		super();
		this.gameName = gameName;
		this.gamePicture = gamePicture;
		this.gameDescription = gameDescription;
		this.genre = genre;
	}
	
	protected String gamePicture;
	protected String gameDescription;
	protected String genre;
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

}
