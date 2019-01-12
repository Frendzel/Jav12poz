package pl.sda.boardgame;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BoardGameTest {

    BoardGame boardGame = new BoardGame();

    @Before
    public void init() {
        //given
        boardGame.init();
    }

    @Test
    public void checkSizeTest() {
        //when
        List<BoardGame> games = boardGame.getGames();
        //then
        assertEquals(games.size(), 100);
        games.forEach(System.out::println);
    }

    //2. Find game with the highest rating
    @Test
    public void should_find_the_highest_rank_from_all_initialized_games() throws Exception {
        //when
        BoardGame highestRating = boardGame.getHighestRating();
        //then
        assertNotNull(highestRating);
        //when
        Double theHighestRank = boardGame.getTheHighestRank();
        //then
        assertNotNull(theHighestRank);
        assertEquals(highestRating.getRating(), theHighestRank);
    }

    //3. Find game with the highest rating which has letter a in the name
    @Test
    public void should_find_the_highest_rank_from_games_with_letter_a() {
        //when
        BoardGame highestRating = boardGame.getHighestRatingWithA();
        //then
        assertTrue(highestRating.getName().contains("a"));
    }


}