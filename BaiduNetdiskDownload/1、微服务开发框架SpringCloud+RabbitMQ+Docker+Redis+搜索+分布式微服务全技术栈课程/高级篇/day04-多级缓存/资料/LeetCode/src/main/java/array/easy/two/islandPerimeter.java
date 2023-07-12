package array.easy.two;


//463. 岛屿的周长
//        给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
//
//        网格中的格子 水平和垂直 方向相连（对角线方向不相连）。
//        整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
//
//        岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
//        格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
public class islandPerimeter {
    public static void main(String[] args) {
        int[][] ints = {{1,0}};
        System.out.println(islandPerimeter(ints));

    }

    public static int islandPerimeter(int[][] grid) {
        int num=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]!=1) continue;
                if((i-1)<0){
                    num++;
                }
                if ((j-1)<0){
                    num++;
                }if ((i+1)>= grid.length){
                    num++;
                }if ((j+1)>= grid[i].length){
                    num++;
                }
                if (i-1>=0&&grid[i-1][j]==0){
                    num++;
                }
                if (i+1< grid.length&&grid[i+1][j]==0) {
                    num++;
                }
                if (j+1<grid[i].length&&grid[i][j+1]==0) {
                    num++;
                }
                if (j-1>=0&&grid[i][j-1]==0) {
                    num++;
                }
            }
        }
        return num;
    }
}
