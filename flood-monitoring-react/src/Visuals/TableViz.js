import {Pagination, Table} from '@mantine/core';
import React, {useEffect, useState} from "react";
import { DataTable } from 'mantine-datatable';
import dayjs from 'dayjs';
import {default_page_size} from "../appConfig";

export default function TableViz({stationRecordings, title}) {

    const tableHeaders = (
        <Table.Tr>
            <Table.Th>#</Table.Th>
            <Table.Th>DateTime</Table.Th>
            <Table.Th>Value</Table.Th>
        </Table.Tr>
    );

    /**
     * Pagination
     */
    const [page, setPage] = useState(1);
    const [records, setRecords] = useState(stationRecordings.slice(0, default_page_size));

    /**
     * Update the records on page change
     */
    useEffect(() => {
        const from = (page - 1) * default_page_size;
        const to = from + default_page_size;
        setRecords(stationRecordings.slice(from, to));
    }, [page]);

    return (
        <>
            {/*<h6 style={{margin: '1rem'}}>{title}</h6>*/}
            <Table striped highlightOnHover withTableBorder withColumnBorders style={{height: '40%'}}>
                <Table.Thead style={{textAlignLast: 'center'}}>{tableHeaders}</Table.Thead>
                <Table.Tbody>
                    {
                        records.map((item, index) => (
                            <Table.Tr key={index}>
                                <Table.Td>{((page - 1) * default_page_size) + index + 1}</Table.Td>
                                <Table.Td>{item.dateString}</Table.Td>
                                <Table.Td>{item.value}</Table.Td>
                            </Table.Tr>
                        ))
                    }
                </Table.Tbody>
            </Table>
            <Pagination total={10} radius="xl" style={{margin: '1rem'}} onChange={setPage}/>
        </>
    );
}
