import {Select} from '@mantine/core';

export default function MeasureSelector({measures, value, updateSelectedMeasure}) {

    // const measureList = measures.map((measure, index) => {
    //     return {
    //         label: measure.label,
    //         value: String(index)
    //     }
    // });

    return (

        <Select
            style={{ width: '100%' }}
            label="Select a measure"
            placeholder="Pick a measurement for readings"
            data={measures}
            defaultValue={measures[0].value}
            value={value}
            // clearable
            allowDeselect={false}
            searchable
            nothingFoundMessage="No Measurements available"
            // mt="md"
            onChange={(value) => updateSelectedMeasure(measures[parseInt(value)])}
        />
    );
}