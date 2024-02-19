import {apiRequest, getOptionsTemplate} from "./ApiHandler";
import {date_format, stations_part_url} from "../appConfig";

//The API updates every 15 minutes, i.e., a new reading will be recorded every 15 minutes


/**
 * Determines the last quarter-hour mark
 * To avoid multiple unique calls for fetching same response
 * @returns {Date}
 */
function getLastQuarterHourDate() {
    const now = new Date();
    let minutes = now.getMinutes();
    minutes = minutes - (minutes % 15);
    return new Date(now.getFullYear(), now.getMonth(), now.getDate(), now.getHours(), minutes, 0, 0);
}


/**
 * To fetch data from a certain point of time 'since'.
 * In this case, last 24 hours
 * @returns {string}
 */
function getSinceTime() {
    const lastQuarterHourDate = getLastQuarterHourDate();
    const sinceDate = new Date(lastQuarterHourDate.getTime() - 24 * 60 * 60 * 1000);
    return sinceDate.toISOString();
}


/**
 * API call to fetch the recording based on the request
 * @param optionsTemplate
 * @param setResponseData
 */
function fetchReadings(optionsTemplate, setResponseData) {
    apiRequest(optionsTemplate)
        .then((response) => {
            // console.log(response);
            const data = response.items.map((item) => {
                const dateString = String(item.dateTime);
                return {
                    dateTime: new Date(dateString),
                    dateString: String(new Intl.DateTimeFormat('en-GB', date_format).format(new Date(dateString))),
                    value: parseFloat(item.value)
                }
            }).sort((a, b) => a.dateTime - b.dateTime);
            setResponseData(data);
        });
}


/**
 * To fetch the readings based on station and measure
 * @param stationId
 * @param measure
 * @param setResponseData
 */
export function getStationReadingsbyMeasure(stationId, measure, setResponseData) {
    const url = stations_part_url + '/' + stationId + '/readings';

    const sinceDate = getSinceTime();

    const optionsTemplate = getOptionsTemplate();
    optionsTemplate.url = url;
    optionsTemplate.params.since = sinceDate;
    optionsTemplate.params.parameter = measure.parameter;
    optionsTemplate.params.qualifier = measure.qualifier;

    fetchReadings(optionsTemplate, setResponseData);
}
