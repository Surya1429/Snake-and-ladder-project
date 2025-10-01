//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
class SnakeAndLadderGridGAme
{
    private static final int rows = 5;
    private static final int cols = 6;
    private static final int N = rows * cols;
    private static  int[] board = new int[N];
    private static final Random rand = new Random();
    static void printBoard(int p1,int p2)
    {
        int num = N-1;
        for(int i = 0;i<rows;i++){
            if(i%2==0)  //----> left to right
            {
                for(int j= 0;j<cols;j++){
                    printcell(num--,p1,p2);
                }
            }
            else{  //-------->right to left
                int start = num-(cols-1);
                for(int j = 0;j<cols;j++){
                    printcell(start+j,p1,p2);
                }
                num = num-cols;
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void printcell(int cell,int p1,int p2){
        if(cell == p1 && cell == p2){
            System.out.printf(" P1&P2 ");
        }
        else if(cell==p1){
            System.out.printf(" p1   ");
        }
        else if(cell==p2){
            System.out.printf(" p2   ");
        }
        else {
            System.out.printf("%3d    ",cell);
        }
    }
    static void initBoard()
    {
        Arrays.fill(board, -1);

        // ladders
        board[2] = 21;
        board[4] = 7;
        board[10] = 25;
        board[19] = 28;

        //snakes

        board[26] = 0;
        board[20] = 8;
        board[16] = 3;
        board[18] = 6;
    }
    static void play()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("......Welcome to Snake and Ladder Grid...... ");
        System.out.println("Snakes: 26-> 0, 20 -> 8, 16 -> 3, 18 -> 6");
        System.out.println("Ladders: 2 -> 21, 4 -> 7, 10 -> 25, 19 - >28\n");

        int p1 = 0,p2 = 0;
        boolean pt = true;
        initBoard();
        printBoard(p1,p2);

        while(true){
            System.out.println((pt)?"P1":"P2");
            sc.nextLine();
            int dice = rand.nextInt(6)+1;
            System.out.println("Dice rolled : "+dice);
            if(pt)
            {
                p1 = move(p1,dice);
                System.out.println(" P1 moved to "+p1);
                printBoard(p1,p2);
                if(p1==N-1)
                {
                    System.out.println("......****P1 Wins****......");
                    break;
                }
            }
            else
            {
                p2 = move(p2,dice);
                System.out.println(" P2 moved to "+p2);
                printBoard(p2,p1);
                if(p2==N-1)
                {
                    System.out.println("......****P2 Wins****......");
                    break;
                }
            }
            pt = !pt;
        }

    }
    private static int move(int pos,int dice)
    {
        if(pos+dice>=N)
                return pos;
        pos += dice;
        if(board[pos]!=-1)
        {
            if(board[pos]>pos){
                System.out.println(" Ladder ! climb up to "+board[pos]);
            }
            else{
                System.out.println(" Snake ! Go Down to "+board[pos]);
            }
            pos = board[pos];
        }
        return pos;
    }
}
class Main
{
    public static void main(String[] args)
    {

        SnakeAndLadderGridGAme.play();

    }
}