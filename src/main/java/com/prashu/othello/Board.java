package com.prashu.othello;

import java.util.*;
import java.util.stream.IntStream;

public class Board {

    private final Map<Position, Disc> spots = new HashMap<>();

    public Board(){
        initialiseBoard();
    }

    private void initialiseBoard(){
        IntStream.range(0, 8).forEach( i ->
            IntStream.range(0,8).forEach( j ->
                {
                    if(i == 3 && j == 3 || i == 4 && j == 4){
                        spots.put(new Position(i, j), Disc.O);
                    }else if(i == 3 && j == 4 || i == 4 && j == 3){
                        spots.put(new Position(i, j), Disc.X);
                    }else{
                        spots.put(new Position(i, j), Disc.E);
                    }
                }
            )
        );
    }

    public Position getPosition(int horizontal, int vertical){
        return spots.keySet().stream().
                filter(key -> key.getHorizontal() == horizontal && key.getVertical() == vertical)
                .findFirst()
                .get();
    }

    public Disc getSpotValue(int horizontal, int vertical){
        Position position = getPosition(horizontal, vertical);
        return spots.get(position);
    }

    public String display(){
        StringBuilder display = new StringBuilder();
        display.append("\n" + "\ta\tb\tc\td\te\tf\tg\th" + "\n");
        IntStream.range(0, 8).forEach( i ->
                {
                    display.append(i + 1 + "\t");
                    IntStream.range(0,8).forEach( j ->
                        display.append(getSpotValue(i, j).getSide() + "\t")
                    );
                    display.append(i + 1 + "\n");
                }
        );
        display.append(" \ta\tb\tc\td\te\tf\tg\th\n");
        display.append(displayScores());
        return display.toString();
    }

    public int countSpots(Disc side){
        return (int) spots.entrySet().stream().filter(s -> s.getValue() == side).count();
    }

    public int playerOScore(){
        return countSpots(Disc.O);
    }

    public int playerXScore(){
        return countSpots(Disc.X);
    }

    public int emptySpots(){
        return countSpots(Disc.E);
    }

    public boolean allSpotsCovered(){
        return emptySpots() == 0 ? true : false;
    }

    public boolean isGameFinished(){
        if(allSpotsCovered()){
            return true;
        }
        return false;
    }

    public String displayScores(){
        StringBuilder scores = new StringBuilder("\n");
        scores.append("PlayerX : " + playerXScore() + ",\t");
        scores.append("PlayerO : " + playerOScore() + ",\t");
        scores.append("Empty Spots : " + emptySpots());

        return scores.toString();
    }

    public String displayWinner(){
        StringBuilder winner = new StringBuilder("\n");
        winner.append("PlayerX : " + playerXScore() + ",\t");
        winner.append("PlayerO : " + playerOScore() + ",\t");
        winner.append(playerXScore() == playerOScore() ? "Match Tie" : playerXScore() > playerOScore() ? "PlayerX won!" : "PlayerO won!");
        return winner.toString();
    }

    private boolean isSpotAlreadyTaken(Position position){
        return !spots.get(position).equals(Disc.E);
    }

    private List<Position> aggregatePositionsToUpdate(Position position, Disc side){
        List<Position> positionsToUpdate = new ArrayList<>();

        positionsToUpdate.addAll(getPositionsToUpdate(position.getAllNPositions(), side));
        positionsToUpdate.addAll(getPositionsToUpdate(position.getAllWPositions(), side));
        positionsToUpdate.addAll(getPositionsToUpdate(position.getAllEPositions(), side));
        positionsToUpdate.addAll(getPositionsToUpdate(position.getAllSPositions(), side));
        positionsToUpdate.addAll(getPositionsToUpdate(position.getAllNEPositions(), side));
        positionsToUpdate.addAll(getPositionsToUpdate(position.getAllNWPositions(), side));
        positionsToUpdate.addAll(getPositionsToUpdate(position.getAllSEPositions(), side));
        positionsToUpdate.addAll(getPositionsToUpdate(position.getAllSWPositions(), side));
        positionsToUpdate.removeIf(Objects::isNull);

        return positionsToUpdate;
    }

    private List<Position> getPositionsToUpdate(List<Position> positions, Disc side){
        Disc oppositeSide = side == Disc.X ? Disc.O : (side == Disc.O ? Disc.X : Disc.E);
        List<Position> positionsToUpdate = new ArrayList<>();
        boolean endingMatchingPositionFound = false;
        for(Position p : positions){
            if(spots.get(p) == side){
                endingMatchingPositionFound = true;
                break;
            }else if(spots.get(p) == oppositeSide){
                positionsToUpdate.add(p);
            }else if(spots.get(p) == Disc.E){
                break;
            }
        }

        return endingMatchingPositionFound ? positionsToUpdate : new ArrayList<>();
    }

    private void reshuffleBoard(List<Position> positionsToUpdate, Disc symbol){
        positionsToUpdate.stream().forEach(p ->
                spots.put(p, symbol)
        );
    }

    public Outcome placeDisc(Position position, Disc symbol){

        if(isSpotAlreadyTaken(position)){
            return Outcome.SPACE_ALREADY_TAKEN;
        }

        List<Position> positionsToUpdate = aggregatePositionsToUpdate(position, symbol);
        if (positionsToUpdate.size() == 0){
            return Outcome.NOT_A_LEGAL_MOVE;
        }else{
            positionsToUpdate.add(position);
            reshuffleBoard(positionsToUpdate, symbol);
            return Outcome.LEGAL_MOVE;
        }
    }

    public int getPossibleSpotsCount(Disc side){
        int possibleSpots = (int) spots.entrySet().stream()
                .filter(e -> e.getValue() == Disc.E)
                .map(e -> e.getKey())
                .map(p -> aggregatePositionsToUpdate(p, side))
                .filter(l -> l.size() > 0)
                .count();

        return possibleSpots;
    }
}
