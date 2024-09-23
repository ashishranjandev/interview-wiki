package interview.uprnetwrkz;

public class Pawn {
/*
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Position from, Position to) {


        // check Board.move for more details on comment


        int fromRow = from.x;
        int fromCol = from.y;
        Piece piece = board.state[fromRow][fromCol];

        int toRow = to.x;
        int toCol = to.y;

        if(piece == null)
            return false;
        else if(fromRow <0 || fromRow >=8 || toRow<0 || toRow>=8 )
            return false;

        else if(board.state[toRow][toCol] == null) {
            if(piece.color.equals(Color.WHITE))
            {
                if(toCol != fromCol)
                    return false;
                else if(fromRow == 1){
                    if(toRow == 2 )
                    {}
                    else if(toRow == 3)
                    {
                        if(board.state[2][toCol] !=null)
                            return false;
                    }
                    else
                        return false;
                }
                else if(toRow-fromRow !=1)
                    return false;



            }

            else
            {
                if(toCol != fromCol)
                    return false;
                else if(fromRow == 6){

                    if(toRow == 5 )
                    {}
                    else if(toRow == 4){

                        if(board.state[4][toCol] !=null)
                            return false;
                    }
                    else
                        return false;
                }
                else if(fromRow-toRow !=1)
                    return false;

            }








        } else if(board.state[toRow][toCol] !=null){

            Piece opponent = board.state[toRow][toCol];
            if(opponent.color.equals(piece.color))
                return false;

            if(piece.color.equals(Color.WHITE))
            {

                if(toRow == fromRow + 1 && (toCol == fromCol-1 || toCol == fromCol +1))
                {
                    //continue;
                }
                else{

                    return false;

                }

            }

            else
            {

                if(toRow == fromRow - 1 && (toCol == fromCol-1 || toCol == fromCol +1))
                {
                    // continue;
                }
                else{

                    return false;

                }
            }

        }


        return true;



    }
*/

}