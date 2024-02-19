import {LoadingOverlay, MultiSelect, Select} from "@mantine/core";
import React from "react";

export default function StationSelector({stations, onChangeSelection}) {
    if (!stations) {
        return (
            <>
                <LoadingOverlay
                    visible={true}
                    zIndex={1000}
                    overlayProps={{ radius: 'sm', blur: 2 }}
                    loaderProps={{ color: 'blue', type: 'bars' }}
                />

                <Select
                    label="Select Stations"
                    placeholder="Loading ...."
                    disabled
                />
            </>
        );
    }

    return (

        <Select
            style={{ width: 300 }}
            // label="Select Station Name"
            placeholder="Pick a station"
            data={stations}
            defaultValue=""
            clearable
            searchable
            allowDeselect={false}
            nothingFoundMessage="No station found"
            // mt="md"
            onChange={onChangeSelection}
        />
    );
}