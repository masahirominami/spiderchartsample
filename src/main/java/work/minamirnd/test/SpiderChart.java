/**
 * Spider chart sample using JFreeChart
 * https://stackoverflow.com/questions/32862913/how-to-draw-a-spiderchart-above-a-existing-jfreechart/32885067#32885067
 *
 */

package work.minamirnd.test;

import java.awt.EventQueue;
import java.util.Random;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/** @see https://stackoverflow.com/a/32885067/230513 */
public class SpiderChart extends ApplicationFrame {

    private static final int OBSERVATIONS = 2;
    private static final int VARIABLES = 5;
    private static final Random r = new Random();

    public SpiderChart(String s) {
        super(s);
        add(createDemoPanel());
    }

    private static CategoryDataset createDataset() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 1; i <= OBSERVATIONS; i++) {
            String rowKey = "Observation " + i;
            for (int j = 1; j <= VARIABLES; j++) {
                Comparable colKey = Character.valueOf((char)(j+64));
                dataset.addValue(r.nextInt(3) + 1, rowKey, colKey);
            }
        }
        return dataset;
    }

    public static JFreeChart createChart(CategoryDataset dataset) {
        SpiderWebPlot plot = new SpiderWebPlot(dataset);
        JFreeChart chart = new JFreeChart("Test", plot);
        return chart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            SpiderChart demo = new SpiderChart("SpiderWebChart");
            demo.pack();
            demo.setDefaultCloseOperation(EXIT_ON_CLOSE);
            demo.setVisible(true);
        });
    }
}
