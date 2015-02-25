(function() {

  /*
   * csv ファイルを読み込み以下の形式の配列を返す
   * [
   *  { headers[0]: row[0], headers[1]: row[1], ... , headers[n]: row[n] }
   * ]
   */
  var readCSVFile = function(fpath, headers) {
    var Paths = java.nio.file.Paths;
    var Files = java.nio.file.Files;
    var Stream = java.util.stream.Stream;
    var rows = [];

    var lines =  Files.lines(Paths.get(fpath));
    lines.forEach(function(line) {
      var row,
          rowObj = {},
          i;

      // コメント行は飛ばす
      if (line.indexOf('#') === 0) {
        return;
      }

      // ヘッダとデータを組み合わせて一行に対応する Object を作成
      row = line.split(',');
      for (i = 0; i < row.length; i++) {
        rowObj[ headers[i] ] = row[i];
      }
      rows.push( rowObj );
    });

    return rows;
  };

  var main =  function() {
    var Group = javafx.scene.Group;
    var Scene = javafx.scene.Scene;
    var PieChart = javafx.scene.chart.PieChart;
    var ObservableList = javafx.collections.ObservableList;
    var FXCollections = javafx.collections.FXCollections;
    var scene = new Scene(new Group());

    var pieChartData = FXCollections.observableArrayList();
    var dataFile = "pie-chart-data.csv";
    var rows = readCSV(dataFile, [ "name", "value" ] );

    for each ( var row in rows ) {
      pieChartData.add( new PieChart.Data(row.name, Number(row.value) ));
    }

    var chart = new PieChart(pieChartData);
    (scene.getRoot()).getChildren().add(chart);
    $STAGE.scene = scene;
    $STAGE.title = "Pie Chart";
    $STAGE.width = 500;
    $STAGE.height = 500;
  };

  main();

})();
