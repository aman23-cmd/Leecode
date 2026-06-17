class Solution {
    static class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int originalcolor=image[sr][sc];
        if(originalcolor==color)return image;
        Queue<Pair>q=new LinkedList<>();
        q.offer(new Pair(sr,sc));
        image[sr][sc]=color;
        int []dr={-1,0,1,0};
        int []dc={0,1,0,-1};
        while(!q.isEmpty()){
            Pair curr=q.poll();
            for(int i=0;i<4;i++){
                int nr=curr.row+dr[i];
                int nc=curr.col+dc[i];
                 if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    image[nr][nc] == originalcolor){
                        image[nr][nc]=color;
                        q.offer(new Pair(nr,nc));
                    }

            }
        }
        return image;

    }
}