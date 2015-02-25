var Group = javafx.scene.Group;
var Scene = javafx.scene.Scene;
var PieChart = javafx.scene.chart.PieChart;
var ObservableList = javafx.collections.ObservableList;
var FXCollections = javafx.collections.FXCollections;

var dataFile = "pie-chart-data.csv";

var scene = new Scene(new Group());
var pieChartData = FXCollections.observableArrayList(
  new PieChart.Data("Grapefruit", 13),
  new PieChart.Data("Oranges", 25),
  new PieChart.Data("Plums", 10),
  new PieChart.Data("Pears", 22),
  new PieChart.Data("Apples", 30)
);
var chart = new PieChart(pieChartData);

//(scene.getRoot()).getChildren().add(chart);
(scene.getRoot()).getChildren().add(chart);
$STAGE.scene = scene;

$STAGE.title = "Pie Chart";
$STAGE.width = 500;
$STAGE.height = 500;
