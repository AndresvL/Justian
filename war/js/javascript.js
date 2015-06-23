//Pie chart (google api)
google.load("visualization", "1", {packages: ["corechart"]});
google.setOnLoadCallback(drawChart);
function drawChart() {
    var data = google.visualization.arrayToDataTable([
        ['Task', 'Hours per Day'],
        ['Werk', 3],
        ['Les', 7],
        ['Vrije tijd', 3],
        ['Slapen', 8],
        ['School', 3]
    ]);

    var options = {
        title: 'Dagelijkse bezigheden',
        legend: 'none',
        pieSliceText: 'label',
        slices: {
            0: {offset: 0.1},
            2: {offset: 0.2},
            4: {offset: 0.3}
        }
    };


    var chart = new google.visualization.PieChart(document.getElementById('piechart'));

    chart.draw(data, options);
}
