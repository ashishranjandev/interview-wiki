package interview.uprnetwrkz;

public class Board {
/*
    public Piece[][] state = new Piece[8][8];
    private Color turnColor = Color.WHITE;

    public Board() {
        for (int y = 0; y < 8; y++) {
            state[1][y] = new Pawn(Color.WHITE);
            state[6][y] = new Pawn(Color.BLACK);
        }
    }

    public void move(Position from, Position to) throws IllegalArgumentException {
        int fromRow = from.x;
        int fromCol = from.y;
        Piece piece = state[fromRow][fromCol];

        int toRow = to.x;
        int toCol = to.y;

        // piece should not be null to move
        if(piece == null)
            throw new IllegalArgumentException();

            // check for invalid positions
        else if(fromRow <0 || fromRow >=8 || toRow<0 || toRow>=8 )
            throw new IllegalArgumentException();
            //  next position is empty
        else if(state[toRow][toCol] == null) {

            // for white pawn condition
            if(piece.color.equals(Color.WHITE))
            {
                if(toCol != fromCol)
                    throw new IllegalArgumentException();
                else if(fromRow == 1){
                    //valid case
                    if(toRow == 2 )
                    {}
                    else if(toRow == 3)
                    {
                        // cannot move if already a pawn present in from
                        if(state[2][toCol] !=null)
                            throw new IllegalArgumentException();
                    }
                    else
                        throw new IllegalArgumentException();
                }
                // row should grow by 1
                else if(toRow-fromRow !=1)
                    throw new IllegalArgumentException();



            }

            // for black pawn condition
            else
            {
                if(toCol != fromCol)
                    throw new IllegalArgumentException();
                else if(fromRow == 6){
                    //valid case
                    if(toRow == 5 )
                    {}
                    else if(toRow == 4){
                        // cannot move if already a pawn present in from
                        if(state[4][toCol] !=null)
                            throw new IllegalArgumentException();
                    }
                    else
                        throw new IllegalArgumentException();
                }
                //row should grow by 1
                else if(fromRow-toRow !=1)
                    throw new IllegalArgumentException();

            }







            // if next postion is occupied
        } else if(state[toRow][toCol] !=null){


            // next postion should be same
            Piece opponent = state[toRow][toCol];
            if(opponent.color.equals(piece.color))
                throw new IllegalArgumentException();

            // for white pawn
            if(piece.color.equals(Color.WHITE))
            {

                // check for diagonal condition
                if(toRow == fromRow + 1 && (toCol == fromCol-1 || toCol == fromCol +1))
                {
                    //valid case
                    //continue;
                }
                else{

                    throw new IllegalArgumentException();

                }

            }

            // for black pawn

            else
            {

                // check for diagonal condition

                if(toRow == fromRow - 1 && (toCol == fromCol-1 || toCol == fromCol +1))
                {
                    //valid case
                    // continue;
                }
                else{

                    throw new IllegalArgumentException();

                }
            }

        }



        // replace the next postion with current
        state[toRow][toCol] = piece;
        // set the current as null
        state[fromRow][fromCol] = null;


    }




    public Piece getPiece(Position pos) {

        int row = pos.x;
        int col = pos.y;
        return state[row][col];
    }


    public Color getPieceColor(Position pos) {
        int row = pos.x;
        int col = pos.y;
        Piece piece = state[row][col];
        if(piece == null)
            return null;
        else
            return piece.color;
    }
    */
}
