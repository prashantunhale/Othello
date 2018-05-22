package com.prashu.othello;

import java.util.LinkedList;
import java.util.List;

/**
 * Each Position '-' could potentially have NW/N/NE/W/E/SW/S/SE 7 Cardinal directions:
 * https://en.wikipedia.org/wiki/Cardinal_direction
 *
 * NW       N       NE
 *     NW   N   NE
 * W   W    -   E   E
 *     SW   S   SE
 * SW       S       SE
 *
 * Below Position class assumes co-ordinates in the range of (0,0) to (7,7) which satisfies the needs of Othello game
 */

public class Position {
    private final int horizontal;
    private final int vertical;

    public Position(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }


    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    /**
     * @return Returns upper left position
     */
    public Position getNWPosition(){
        if(horizontal > 0 && vertical > 0){
            return new Position(horizontal - 1, vertical - 1);
        }
        return null;
    }

    /**
     * @return Returns all the positions which are on the diagonally on North West of the given position
     */
    public List<Position> getAllNWPositions(){
        List<Position> positions = new LinkedList<>();
        Position p = this;
        while(p.getNWPosition() != null){
            positions.add(p.getNWPosition());
            p = p.getNWPosition();
        }
        return positions;
    }

    /**
     * @return Returns upper position
     */
    public Position getNPosition(){
        if(horizontal > 0){
            return new Position(horizontal - 1, vertical);
        }
        return null;
    }

    /**
     * @return Returns all the positions which are on the vertically upwards of the given position
     */
    public List<Position> getAllNPositions(){
        List<Position> positions = new LinkedList<>();
        Position p = this;
        while(p.getNPosition() != null){
            positions.add(p.getNPosition());
            p = p.getNPosition();
        }
        return positions;
    }

    /**
     * @return Returns upper right position
     */
    public Position getNEPosition(){
        if(horizontal > 0 && vertical < 7){
            return new Position(horizontal - 1, vertical + 1);
        }
        return null;
    }

    /**
     * @return Returns all the positions which are on the diagonally on North East of the given position
     */
    public List<Position> getAllNEPositions(){
        List<Position> positions = new LinkedList<>();
        Position p = this;
        while(p.getNEPosition() != null){
            positions.add(p.getNEPosition());
            p = p.getNEPosition();
        }
        return positions;
    }

    /**
     * @return Returns left position
     */
    public Position getWPosition(){
        if(vertical > 0){
            return new Position(horizontal, vertical - 1);
        }
        return null;
    }

    /**
     * @return Returns all the positions which are on the horizontally left side of the given position
     */
    public List<Position> getAllWPositions(){
        List<Position> positions = new LinkedList<>();
        Position p = this;
        while(p.getWPosition() != null){
            positions.add(p.getWPosition());
            p = p.getWPosition();
        }
        return positions;
    }

    /**
     * @return Returns right position
     */
    public Position getEPosition(){
        if(vertical < 7){
            return new Position(horizontal, vertical + 1);
        }
        return null;
    }

    /**
     * @return Returns all the positions which are on the horizontally right side of the given position
     */
    public List<Position> getAllEPositions(){
        List<Position> positions = new LinkedList<>();
        Position p = this;
        while(p.getEPosition() != null){
            positions.add(p.getEPosition());
            p = p.getEPosition();
        }
        return positions;
    }

    /**
     * @return Returns lower left position
     */
    public Position getSWPosition(){
        if(horizontal < 7 && vertical > 0){
            return new Position(horizontal + 1, vertical - 1);
        }
        return null;
    }

    /**
     * @return  Returns all the positions which are on the diagonally on South West of the given position
     */
    public List<Position> getAllSWPositions(){
        List<Position> positions = new LinkedList<>();
        Position p = this;
        while(p.getSWPosition() != null){
            positions.add(p.getSWPosition());
            p = p.getSWPosition();
        }
        return positions;
    }

    /**
     * @return Returns lower position
     */
    public Position getSPosition(){
        if(horizontal < 7){
            return new Position(horizontal + 1, vertical);
        }
        return null;
    }

    /**
     * @return Returns all the positions which are on the vertically downwards of the given position
     */
    public List<Position> getAllSPositions(){
        List<Position> positions = new LinkedList<>();
        Position p = this;
        while(p.getSPosition() != null){
            positions.add(p.getSPosition());
            p = p.getSPosition();
        }
        return positions;
    }

    /**
     * @return Returns lower right position
     */
    public Position getSEPosition(){
        if(horizontal < 7 && vertical < 7){
            return new Position(horizontal + 1, vertical + 1);
        }
        return null;
    }


    /**
     * @return Returns all the positions which are on the diagonally on South East of the given position
     */
    public List<Position> getAllSEPositions(){
        List<Position> positions = new LinkedList<>();
        Position p = this;
        while(p.getSEPosition() != null){
            positions.add(p.getSEPosition());
            p = p.getSEPosition();
        }
        return positions;
    }

    @Override
    public String toString() {
        return "Position{" +
                "horizontal=" + horizontal +
                ", vertical=" + vertical +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        if (getHorizontal() != position.getHorizontal()) return false;
        return getVertical() == position.getVertical();
    }

    @Override
    public int hashCode() {
        int result = getHorizontal();
        result = 31 * result + getVertical();
        return result;
    }
}