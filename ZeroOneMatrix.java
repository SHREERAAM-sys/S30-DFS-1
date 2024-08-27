/*

 Approach: BFS - considering like level order traversal starting from independetn elements in queue


 Working:
 Declare
 m - no of rows
 n - no of cols
 dir - direction matrix for U D L R
 queue - of int[] array to store index

 since zero is independent of any element in the matrix
 traverse the matrix
 if encountered zero
 add to quere the index of zero i,j
 else // encounterd 1
 convert it -1 // this conversion is for knowing the visided cells

 no perform bfs

 declare level to zero

 when the queue is not empty

 get the size // considered as a level

 poll the elements in the queue tilthe size

 get the current index array from the queue poll

 iterate over the directions array i.e all four directions

 calculate the new row nr
 calculate new column nc
 check if nr and nc are withing the limits and the value at mat[nr][nc] = -1
 set mat[nr][nc] = lvl+1 //this will give the nearest distance from 1
 add the current index to queue // which will be iterated as next level

 increment lvl

 return the matrix



 Time Complexity: O(m*n)
 Space Complexity O(m*n)
 */

class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {

        if(mat == null || mat.length == 0){
            return mat;
        }

        int m = mat.length;
        int n = mat[0].length;

        int[][] direction = {{-1,0}, {1,0}, {0, -1}, {0, 1}}; //U D L R

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {

                if(mat[i][j] == 0) {

                    int[] index = new int[]{i,j};
                    queue.add(index); // adding independent value in the queue i.e zero
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }

        System.out.println(queue.size());

        int lvl = 0;
        while(!queue.isEmpty()) {

            int size = queue.size();

            for(int i =0; i<size; i++) {

                int[] cur = queue.poll();

                for(int[] dir: direction) {

                    int nr = cur[0]+dir[0];
                    int nc = cur[1]+dir[1];

                    if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc] == -1) {
                        mat[nr][nc] = lvl+1;
                        queue.add(new int[]{nr,nc});
                    }
                }
            }
            lvl++;

        }
        System.out.println(queue.size());

        return mat;
    }
}
