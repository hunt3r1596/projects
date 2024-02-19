import React from 'react';
import 'chart.js/auto';
import 'chartjs-adapter-date-fns'; // Import this adapter
import { Line } from 'react-chartjs-2';

export default function LineChart({ data, label }) {

    /**
     * To convert the data into chart-js format
     */
    const { labels, dataPoints } = data.reduce((acc, item) => {
        acc.labels.push(item.dateString);
        acc.dataPoints.push(item.value);
        return acc;
    }, { labels: [], dataPoints: [] });

    const chartData = {
        labels,
        datasets: [
            {
                label: label,
                data: dataPoints,
                fill: false,
            },
        ]
    };

    const options = {
        scales: {
            x: {
                title: {
                    display: true,
                    text: 'Date & Time',
                }
            },
            y: {
                title: {
                    display: true,
                    text: 'values',
                }
            }
        },
    };

    return (
        <div style={{height:400, width: 800}}>
            <Line data={chartData} options={options}/>
        </div>
    );
}
