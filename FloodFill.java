/**
 Approach: DFS

 Time Complexity: O(m*n)
 Space Complexity: O(m*n) //recursive stack space
 */

class FloodFill {

    int n,m;
    int[][] dir = {
            {-1, 0},//top
            {1,0}, //bottom
            {0, -1}, // left
            {0,1} //right;
    };


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image == null || image.length == 0 || image[sr][sc] == color) {
            return image;
        }

        m = image.length;
        n = image[0].length;



        fill(image, sr, sc, color, image[sr][sc]);

        // for(int[] s: dir) {
        //     System.out.println(s[0]+" "+s[1]);
        // }
        return image;

    }

    private void fill(int[][] a, int x, int y, int color, int replace) {

        if(x < 0 || x >= m || y<0 || y>=n) {
            return;
        }
        int val = a[x][y];

        if(val != replace) {
            return;
        }


        a[x][y] = color;

        for(int[] d:dir) {

            int i = x+d[0];
            int j = y+d[1];

            fill(a, i, j, color, replace);
        }

    }
}
