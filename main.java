import java.lang.Math;

class Main{
    public static void main(String[] args){
        int width = 100;
        int height = 100;
        boolean[][] conway = new boolean[width][height];
        conway = shuffle(33,conway);
        conway = advance(conway);
    }

    public static boolean[][] shuffle(int chance,boolean[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(((int)(Math.random()*100))<chance){
                    board[i][j] = (!board[i][j]);
                }
            }
        }
        return(board);
    }

    public static boolean[][] advance(boolean[][] board){
        boolean[][] newboard = board;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]&&count(board,i,j)<3){newboard[i][j]=false;}
                else if(board[i][j]&&count(board,i,j)>3){newboard[i][j]=false;}
                else if(!board[i][j]&&count(board,i,j)==3){newboard[i][j]=true;}
            }
        } 
        return(newboard);     
    }

    public static int count(boolean[][] board, int x, int y){
        int count = 0;
        int[][] checks = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int i=0;i<8;i++){
            try{
                if(board[x+checks[i][0]][y+checks[i][1]]){
                    count++;
                }
            }catch(Exception e){}
        }
        return(count);
    }
}