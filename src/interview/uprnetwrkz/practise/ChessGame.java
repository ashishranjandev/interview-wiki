package interview.uprnetwrkz.practise;

import java.util.*;

// Enum to define the color of the pieces
enum Color {
    WHITE, BLACK
}

// Class representing a position on the chess board
class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return row == position.row && col == position.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}

// Abstract class representing a chess piece
abstract class Piece {
    protected Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    // Abstract method to be implemented by specific pieces for move validation
    public abstract boolean isValidMove(Board board, Position start, Position end);
}

// Class for Pawn piece
class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Position start, Position end) {
        int direction = (color == Color.WHITE) ? 1 : -1;
        int startRank = (color == Color.WHITE) ? 1 : 6;

        // Move forward by 1
        if (start.getCol() == end.getCol()) {
            if (start.getRow() + direction == end.getRow()) {
                return board.getPiece(end) == null;
            }

            // Move forward by 2 on initial rank
            if (start.getRow() == startRank && start.getRow() + 2 * direction == end.getRow()) {
                return board.getPiece(end) == null && board.getPiece(new Position(start.getRow() + direction, start.getCol())) == null;
            }
        }

        // Capturing diagonally
        if (Math.abs(start.getCol() - end.getCol()) == 1 && start.getRow() + direction == end.getRow()) {
            return board.getPiece(end) != null && board.getPieceColor(end) != color;
        }

        return false;
    }
}

// Class for Rook piece
class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Position start, Position end) {
        // Rook moves in straight lines, horizontally or vertically
        if (start.getRow() == end.getRow() || start.getCol() == end.getCol()) {
            return true;
        }
        return false;
    }
}

// Other pieces can be implemented in a similar way (Knight, Bishop, King, Queen)

// Chess Board class to manage the game
class Board {
    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];
    }

    // Method to place a piece on the board
    public void placePiece(Piece piece, Position position) {
        board[position.getRow()][position.getCol()] = piece;
    }

    // Method to get the piece at a specific position
    public Piece getPiece(Position position) {
        return board[position.getRow()][position.getCol()];
    }

    // Method to get the color of the piece at a specific position
    public Color getPieceColor(Position position) {
        Piece piece = getPiece(position);
        if (piece != null) {
            return piece.getColor();
        }
        return null;
    }

    public void move(Position from, Position to) throws IllegalArgumentException {
        Piece piece = getPiece(from);

        if (piece == null) {
            throw new IllegalArgumentException("No piece at the starting position!");
        }

        // Check if the move is valid for the piece
        if (!piece.isValidMove(this, from, to)) {
            throw new IllegalArgumentException("Invalid move for the piece!");
        }

        // Check if the destination is valid (either empty or an enemy piece)
        Piece targetPiece = getPiece(to);
        if (targetPiece != null && targetPiece.getColor() == piece.getColor()) {
            throw new IllegalArgumentException("Cannot move to a position occupied by a piece of the same color!");
        }

        // Perform the move
        board[to.getRow()][to.getCol()] = piece;
        board[from.getRow()][from.getCol()] = null; // Clear the starting position
    }

    // Method to print the current board
    public void printBoard() {
        for (int row = 7; row >= 0; row--) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece == null) {
                    System.out.print("[ ]");
                } else {
                    String symbol = piece.getClass().getSimpleName().substring(0, 1);
                    System.out.print("[" + symbol + "]");
                }
            }
            System.out.println();
        }
    }
}

// Main class to run the chess game
public class ChessGame {
    public static void main(String[] args) {
        Board board = new Board();

        // Place some pieces on the board
        board.placePiece(new Pawn(Color.WHITE), new Position(1, 0));
        board.placePiece(new Rook(Color.BLACK), new Position(7, 0));

        // Print the initial board
        board.printBoard();

        // Test getPiece and getPieceColor
        System.out.println("Piece at (1,0): " + board.getPiece(new Position(1, 0)).getClass().getSimpleName());
        System.out.println("Color of piece at (1,0): " + board.getPieceColor(new Position(1, 0)));

        // Test Pawn movement
        Pawn whitePawn = (Pawn) board.getPiece(new Position(1, 0));
        boolean isValidMove = whitePawn.isValidMove(board, new Position(1, 0), new Position(3, 0));
        System.out.println("Is Pawn move from (1,0) to (3,0) valid? " + isValidMove);
    }
}

