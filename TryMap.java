import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

class MapNode {
    int x, y;

    public MapNode(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class MapEdge {
    MapNode start, end;

    public MapEdge(MapNode start, MapNode end) {
        this.start = start;
        this.end = end;
    }
}

class MapPanel extends JPanel {
    private ArrayList<MapNode> nodes;
    private ArrayList<MapEdge> edges;

    public MapPanel(ArrayList<MapNode> nodes, ArrayList<MapEdge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw edges
        g2d.setColor(Color.BLACK);
        for (MapEdge edge : edges) {
            g2d.drawLine(edge.start.x, edge.start.y, edge.end.x, edge.end.y);
        }

        // Draw nodes
        g2d.setColor(Color.BLUE);
        for (MapNode node : nodes) {
            int nodeSize = 20;
            g2d.fill(new Ellipse2D.Double(node.x - nodeSize / 2, node.y - nodeSize / 2, nodeSize, nodeSize));
        }
    }
}

class MapGUI extends JFrame {
    public MapGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Impressive Map GUI");
        setSize(600, 400);

        ArrayList<MapNode> nodes = new ArrayList<>();
        nodes.add(new MapNode(50, 50));
        nodes.add(new MapNode(150, 100));
        nodes.add(new MapNode(300, 200));
        nodes.add(new MapNode(450, 100));
        nodes.add(new MapNode(550, 50));

        ArrayList<MapEdge> edges = new ArrayList<>();
        edges.add(new MapEdge(nodes.get(0), nodes.get(1)));
        edges.add(new MapEdge(nodes.get(1), nodes.get(2)));
        edges.add(new MapEdge(nodes.get(2), nodes.get(3)));
        edges.add(new MapEdge(nodes.get(3), nodes.get(4)));

        MapPanel mapPanel = new MapPanel(nodes, edges);
        add(mapPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MapGUI());
    }
}
