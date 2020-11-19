public class Model {
    private int xCoordinates[];
    private int yCoordiates[];
    private int [] nodesList;
    private int noOfCities=29;
    private int [][] adjacencyMatrix=new int[noOfCities][noOfCities];
    private String cities;

    public int[] getxCoordinates() {
        return xCoordinates;
    }

    public int[] getyCoordiates() {
        return yCoordiates;
    }

    public int[] getNodesList() {
        return nodesList;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public String getCities() {
        return cities;
    }

    public void setxCoordinates(int[] xCoordinates) {
        this.xCoordinates = xCoordinates;
    }

    public void setyCoordiates(int[] yCoordiates) {
        this.yCoordiates = yCoordiates;
    }

    public void setNodesList(int[] nodesList) {
        this.nodesList = nodesList;
    }

    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }
}
