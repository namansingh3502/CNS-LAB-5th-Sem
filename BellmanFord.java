import java.util.Scanner;

public class BellmanFord {
    public static final int MAX = 999;


    public static void main(String[] args){

        int vertex = 0, source;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of vertex : ");
        vertex = input.nextInt();

        int[][] matrix = new int[vertex + 1][vertex + 1];

        System.out.println("Enter the adjacency matrix : ");
        for (int i = 1; i <= vertex; i++ ){
            for (int j = 1; j <= vertex; j++ ){
                matrix[i][j] = input.nextInt();
                if( i == j ){
                    matrix[i][j] = 0;
                    continue;
                }
                if( matrix[i][j] == 0 ){
                    matrix[i][j] = MAX;
                }
            }
        }

        System.out.println("Enter the source vertex : ");
        source = input.nextInt();

        evaluation( vertex, matrix, source );
    }
    public static void evaluation(int vertex, int[][] matrix, int source){
        int[] distance = new int[vertex+1];

        for( int i = 1; i <= vertex; i++ ) distance[i] = MAX;
        distance[source] = 0;

        for( int i = 1; i <= vertex; i++ ){
            for( int j = 1; j <= vertex; j++ ){
                for( int k = 1; k <= vertex; k++ ){
                    if( matrix[j][k] != MAX ){
                        if( distance[k] > distance[j] + matrix[j][k] ){
                            distance[k] = distance[j] + matrix[j][k];
                        }
                    }
                }
            }
            for( int j = 1; j <= vertex; j++ ){
                for( int k = 1; k <= vertex; k++ ){
                    if( matrix[j][k] != MAX ){
                        if( distance[k] > distance[j] + matrix[j][k] ){
                            System.out.println("The graph contains negetive edge cycle");
                            return;
                        }
                    }
                }
            }
        }

        for(int i = 1; i <= vertex; i++ ){
            System.out.println("distance from source " + source + " to " + i + " is " + distance[i]);
        }
    }
}
