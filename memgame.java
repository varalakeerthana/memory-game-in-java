import java.util.*;
public class memgame{
  public static void main(String args[]){
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> cards = new ArrayList<>();

    cards.add("A"); cards.add("A");
    cards.add("B"); cards.add("B");
    cards.add("C"); cards.add("C");
    cards.add("D"); cards.add("D");
    Collections.shuffle(cards);

    String board[] = new String[cards.size()];
    Arrays.fill(board," ");
    boolean[] flipped = new boolean[cards.size()];
    int noofPairs =0;

    System.out.println("Welcome to the memory game");
    while(noofPairs<4){
      displayBoard(board);
      int firstIndex=getIndex(scanner , board,flipped,"Enter the index to flip the first card:");
      board[firstIndex]=cards.get(firstIndex);
      flipped[firstIndex]=true;
      displayBoard(board);

      int secondIndex=getIndex(scanner , board,flipped,"Enter the index to flip the second card:");
      board[secondIndex]=cards.get(secondIndex);
      flipped[secondIndex]=true;
      displayBoard(board);

      if(cards.get(firstIndex).equals(cards.get(secondIndex))){
        System.out.println("You found a pair");
        noofPairs++;
      }else{
        System.out.println("Sorry! Those cards doesn't match");
        board[firstIndex]=" ";
        board[secondIndex]=" ";
        flipped[firstIndex]=false;
        flipped[secondIndex]=false;
      }
      
    }
    System.out.println("Congratulations!..You won..");
  }
  public static int getIndex(Scanner scanner , String board[] , boolean[] flipped , String prompt){
    int index;
    while(true){
      System.out.print(prompt);
      index = scanner.nextInt();
      if(index<0 || index>=board.length){
        System.out.println("Entered an invalid position.");
        //System.out.print("Enter valid position:");
        
      }else if(flipped[index]){
        System.out.println("Index already flipped.");
      }else{
        break;
      }
      
    }
    return index;
  }
  public static void displayBoard(String board[]){
    int i=0;
    System.out.print("| ");
    while(i<board.length){
      System.out.print(board[i]);
      System.out.print(" |");
      i++;
    }
    System.out.println();
  }
    
}
