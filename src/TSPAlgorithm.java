import java.util.ArrayList;
import java.util.List;

// Module to calculate TSP using nearest neighbour algorithm
public class TSPAlgorithm {
    private List<Integer> finalNodes=new ArrayList<>();
    private int distance=0;
    int distance1[];
    private int nodeList[];

    public List<Integer> getFinalNodes() {
        return finalNodes;
    }

    public int getDistance() {
        return distance;
    }

    public int[] getNodeList() {
        return nodeList;
    }

    /*Nearest Neighbour Algorithm to calculate the optimal path and distance */
    public void tsp(int adjacencyMatrix[][],int start_point) {
            distance1=new int[adjacencyMatrix.length];
            int initial = start_point;
            List<Integer> list = new ArrayList<Integer>();
            list.add(initial);
            int result = 0;
            for (int i = 0; i < adjacencyMatrix.length - 1; i++) {
                int min = 9999;
                int minpos = 0;
                for (int j = 0; j < adjacencyMatrix.length; j++) {
                    if (min > adjacencyMatrix[j][initial] && !list.contains(j)) {
                        min = adjacencyMatrix[j][initial];
                        minpos = j;
                    }
                }
                result = result + min;
                list.add(minpos);
                initial = minpos;
                distance1[i]=result;
            }
                distance = result + adjacencyMatrix[list.get(0)][list.get(list.size()-1)];
                distance1[adjacencyMatrix.length-1]=distance;
                list.add(start_point);
                finalNodes=list;
                nodeList=new int[finalNodes.size()];
                for(int i=0;i<list.size();i++){
                    nodeList[i]=list.get(i);
                }
    }

}