import './App.css';
import React, {useEffect, useRef, useState} from "react";
import {stations_part_url} from "../appConfig";
import StationSelector from "../Selectors/StationSelector";
import {Button, LoadingOverlay} from "@mantine/core";
import MeasureSelector from "../Selectors/MeasureSelector";
import {apiRequest, getOptionsTemplate} from "../Handlers/ApiHandler";
import {getStationReadingsbyMeasure} from "../Handlers/Readings";
import {VizPanel} from "../Visuals/VizPanel";

function App() {
    /**
     * Stations Data
     */
    const [stationList, setStationList] = useState(null);
    const [stationInfoList, setStationInfoList] = useState(null);
    const [selectedStation, setSelectedStation] = useState(null);

    /**
     * Measures Data
     */
    const [selectedMeasure, setSelectedMeasure] = useState(null);
    const [measuresList, setMeasuresList] = useState(null);

    /**
     * Readings Data
     */
    const [stationReadings, setStationReadings] = useState(null);

    const [renderViz, setRenderViz] = useState(false);  // To render the viz panel
    const hasRendered = useRef(false); // To prevent multiple calls on load

    /**
     * Fetch stations data on load
     */
    useEffect(() => {
        if (!hasRendered.current) {
            const optionsTemplate = getOptionsTemplate();
            optionsTemplate.url = stations_part_url;
            optionsTemplate.params.status = 'Active';

            apiRequest(optionsTemplate).then((data) => {
                setStationInfoList(data.items);
                const stations = data.items.map((station) => {
                    return {
                        label: station.label + ' (' + station.notation + ')',
                        value: station.notation
                    }
                }).sort((a, b) => a.label.localeCompare(b.label));

                setStationList(stations);
                console.log('Stations data loaded.');
            });
            hasRendered.current = true;
        }
    }, []);


    /**
     * Fetch readings data on station selection
     */
    useEffect(() => {
        setRenderViz(false);
        setStationReadings(null);
        if (selectedStation) {
            setupMeasures();
            setRenderViz(true);
        }
    }, [selectedStation]);


    /**
     * Fetch readings data on measure selection (change)
     */
    useEffect(() => {
        if (selectedMeasure) {
            if (renderViz)
                setStationReadings(null);
            fetchReadings();
        }
    }, [selectedMeasure]);


    /**
     * To get the measures for the selected station
     * @returns {*|*[]}
     */
    function getMeasures() {
        if (!selectedStation)
            return [];
        const m =  stationInfoList.find((station) => station.notation === selectedStation).measures;

        if (Array.isArray(m)) {
            console.log('Multiple measures found');
            return m.filter(measure => measure.unitName !== '---').map((measure, index) => {
                return {
                    parameter: measure.parameter,
                    label: measure.parameterName + ' (' + measure.qualifier + ')',
                    qualifier: measure.qualifier,
                    value: String(index)
                }
            });
        } else {
            console.log('Single measure found');
            return [{
                parameter: m.parameter,
                label: m.parameterName + ' (' + m.qualifier + ')',
                qualifier: m.qualifier,
                value: String(0)
            }]
        }
    }


    /**
     * To set up the measures for the selected station
     */
    function setupMeasures() {
        console.log('Selected Station: ' + selectedStation)
        const stationMeasures = getMeasures()
        setMeasuresList(stationMeasures);
        console.log('Measures data loaded.', stationMeasures)
        setSelectedMeasure(stationMeasures[0]);
        // fetchReadings(stationMeasures[0]);
    }


    /**
     * To fetch the readings for the selected station and measure
     */
    function fetchReadings() {
        if (selectedStation) {
            getStationReadingsbyMeasure(selectedStation, selectedMeasure, setStationReadings);
        }
    }


    /**
     * To update the measure value with the selected measure value
     * @param measureToUpdate
     */
    function updateSelectedMeasure(measureToUpdate) {
        if (selectedMeasure.label === measureToUpdate.label)
            console.log('No need to update');
        else{
            console.log('Updating measure to: ' + measureToUpdate.label)
            setSelectedMeasure(measureToUpdate);
        }
    }


    /**
     * To set up the measure selector
     * @returns {Element}
     */
    function setupMeasureSelector() {
        if (renderViz && selectedStation && selectedMeasure) {
            // console.log('Selected Measure: ' + selectedMeasure.label);
            return (
                <MeasureSelector measures={measuresList} value={selectedMeasure.value} updateSelectedMeasure={updateSelectedMeasure}/>
            )
        }
    }


    /**
     * To set up the panel for the visualizations (LineChart and Table)
     * @returns {Element}
     */
    function setupVizPanel() {
        if (renderViz) {
            if (stationReadings) {
                return (
                    <VizPanel readings={stationReadings} title={selectedMeasure.label}/>
                )
            } else {
                return <LoadingOverlay
                    visible={true}
                    zIndex={1000}
                    overlayProps={{ radius: 'sm', blur: 2 }}
                    loaderProps={{ color: 'blue', type: 'bars' }}
                />
            }
        }
    }

    return (
        <div className="App">
            <header className="App-header">
                <div>
                    <h2>Flood Monitoring API Tool</h2>
                    <div className='search'>
                        <StationSelector stations={stationList} onChangeSelection={setSelectedStation}/>
                        {/*<Button variant="outline" color="blue" onClick={setupMeasures} disabled={!selectedStation}>Fetch</Button>*/}
                    </div>
                        {setupMeasureSelector()}
                    <div className={"vizTabs"}>
                        {setupVizPanel()}
                    </div>
                </div>
            </header>
        </div>
    );
}

export default App;
