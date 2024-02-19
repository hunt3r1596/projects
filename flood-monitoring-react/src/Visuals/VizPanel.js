import { Tabs } from '@mantine/core';
import TableViz from "./TableViz";
import React from "react";
import LineChart from "./LineChart";

export function VizPanel({readings, title}) {
    return (
        <Tabs defaultValue="chart">
            <Tabs.List justify="center">
                <Tabs.Tab value="chart">Chart</Tabs.Tab>
                <Tabs.Tab value="table">Table</Tabs.Tab>
            </Tabs.List>

            <Tabs.Panel value="chart" pt="xs">
                <LineChart data={readings} height={'40%'} width={'75%'} label={title}/>
            </Tabs.Panel>

            <Tabs.Panel value="table" pt="xs">
                <TableViz stationRecordings={readings} title={title}/>
            </Tabs.Panel>
        </Tabs>


    );
}