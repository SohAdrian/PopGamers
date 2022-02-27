package devops.popgamers;

import java.util.Comparator;
import java.util.Objects;



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
	
	@Override
	public int hashCode() {
		return Objects.hash(gameName, gamePicture, gameDescription, genre);
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (!(obj instanceof Song))
//			return false;
//		Song other = (Song) obj;
//		return Objects.equals(artiste, other.artiste) && Objects.equals(id, other.id)
//				&& Double.doubleToLongBits(songLength) == Double.doubleToLongBits(other.songLength)
//				&& Objects.equals(title, other.title);
//	}

	public static Comparator<Game> gameNameComparator = new Comparator<Game>() {
		@Override
		public int compare(Game g1, Game g2) {
			return (int) (g1.getGameName().compareTo(g2.getGameName()));
		}
	};
	
	public static Comparator<Game> GenreComparator = new Comparator<Game>() {
		@Override
		public int compare(Game g1, Game g2) {
			return (int) (g1.getGenre().compareTo(g2.getGenre()));
		}
	};

//	public static Comparator<Song> songLengthComparator = new Comparator<Song>() {
//		@Override         
//	    public int compare(Song s1, Song s2) {             
//	      return (s2.getSongLength() < s1.getSongLength() ? -1 :                     
//	              (s2.getSongLength() == s1.getSongLength() ? 0 : 1));           
//	    }     
//	};

}
