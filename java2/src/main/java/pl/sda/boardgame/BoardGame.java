package pl.sda.boardgame;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Math.random;
import static java.util.Comparator.comparing;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@ToString
@Getter
public class BoardGame {

    private String name;
    private Double rating;
    private final List<BoardGame> games = new ArrayList();

    public List<BoardGame> getGames() {
        return games;
    }

    public BoardGame() {
    }

    public BoardGame(String name, Double rating) {
        this.name = name;
        this.rating = rating;
    }

    public void init() {
        for (int i = 0; i < 100; i++) {
            games.add(new BoardGame(
                    randomAlphabetic(10),
                    random()));
        }
    }

    public Double getTheHighestRank() throws Exception {
        return games
                .stream()
                .mapToDouble(BoardGame::getRating)
                .max()
                .orElseThrow(() -> new Exception("Stream is empty!"));
    }

    public BoardGame getHighestRating() throws Exception {
        return games
                .stream()
                .max(comparing(BoardGame::getRating))
                .orElseThrow(() -> new Exception("Stream is empty!"));
    }

    public BoardGame getHighestRatingWithA() {
        return games
                .stream()
                .filter(g -> g.getName().contains("a"))
                .max(comparing(BoardGame::getRating))
                .orElse(new BoardGame());
    }

    //TODO test
    public Double getHighestRatingWithMapReduce() throws Exception {
        return games
                .stream()
                .map(BoardGame::getRating)
                .reduce((
                        rating1, rating2) ->
                        rating1.compareTo(rating2) > 0
                                ? rating1 : rating2)
                .orElseThrow(Exception::new);
    }

    //TODO test
    public String glueString() {
        return games
                .stream()
                .map(BoardGame::getName)
                .collect(Collectors.joining());
    }

    //TODO test
    public String glueUpperCaseString() {
        return games
                .stream()
                .map(BoardGame::getName)
                .map(String::toUpperCase)
                .collect(Collectors.joining())
                .toUpperCase(); //alternative
    }

    //TODO test
    public Map<String, Double> formatToMapWithoutStream() {
        Map<String, Double> map = new HashMap<>();
        for (BoardGame game : games) {
            map.put(game.getName(), game.getRating());
        }
        return map;
    }

    //TODO test
    public Map<String, Double> getMap() {
        return games
                .stream()
                .collect(
                        Collectors.toMap(
                                BoardGame::getName,
                                BoardGame::getRating)
                );
    }

    public String getNameUppercase() {
        return games
                .stream()
                .map(BoardGame::getName)
                .map(String::toUpperCase)
                .collect(Collectors.joining());
    }

    //TODO test
    public Set<BoardGame> toSet() {
        return new HashSet<>(games);
    }


    //Tasks:

    //0. Every task should have separated method with junit test
    //1. Generate random games(at least 100)
    //2. Find game with the highest rating
    //3. Find game with the highest rating which has letter a in the name
    //4. Now use streams my friend, with map and reduce
    //5. Please glue all the names in one string
    //6. And make it uppercase
    //7. And collect data generated in point 1 to Map
    //8. To Set
}