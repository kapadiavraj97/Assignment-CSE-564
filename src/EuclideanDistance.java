public class EuclideanDistance {

    /*Calculate the euclidean distance and create a adjacency 2d matrix*/
    public int[][] distanceCalculation(int [] xCoordinates, int [] yCoordinates){
        int [][] distanceMatrix = new int[xCoordinates.length][yCoordinates.length];
        for(int i=0;i<xCoordinates.length-1;i++){
            for(int j=i+1;j<xCoordinates.length;j++){
                double a=Math.sqrt((xCoordinates[i]-xCoordinates[j])*(xCoordinates[i]-xCoordinates[j])+(yCoordinates[i]-yCoordinates[j])*(yCoordinates[i]-yCoordinates[j]));
                distanceMatrix[i][j]=(int)a;
                distanceMatrix[j][i]=(int)a;
            }
        }
        return distanceMatrix;
    }
}