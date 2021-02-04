<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
    google.charts.load('current', {packages: ['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
        $.ajax({
            url: '/recipe/forChart.np?field=SMALL',
            dataType: 'JSON',
            success: function (jsonData) {
                var data = new google.visualization.DataTable();
                data.addColumn('string', '소분류');
                data.addColumn('number', '좋아요');
                for (var i = 0; i < jsonData.length; i++) {
                    data.addRow([jsonData[i].소분류, jsonData[i].좋아요]);
                }
                var options = {
                        'title':'소분류별 좋아요 분포',
                        'width':400,
                        'height':400,
                        pieSliceText:'label',
                        is3D:true,
                        slices:{
                           0:{offset:0.2}
                           ,12:{offset:0.5}
                        }
                };
                var chart = new google.visualization.PieChart(document.getElementById('myChart2'));
                chart.draw(data, options);
                console.log(jsonData);
            }
        });
    }
    google.setOnLoadCallback(drawChart);
</script>
<div id="myChart2" style=""></div>
